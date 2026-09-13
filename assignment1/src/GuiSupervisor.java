import java.util.*;

/** Supervisory policy, executed by SystemController. Stations retain their own sequences. */
public final class GuiSupervisor {
    private static String mode="Automatic", pendingMode="Automatic", commandId="", message="";
    private static boolean running=!Boolean.getBoolean("gui.enabled"), draining, resetting, jam;
    private static int rejectEvery, productionNumber;
    private static final Set<String> commands = new HashSet<String>();
    private static final List<GuiSnapshot.Event> events = new ArrayList<GuiSnapshot.Event>();
    private static final Map<String,GuiSnapshot.Event> alerts = new LinkedHashMap<String,GuiSnapshot.Event>();
    private static final List<String> history = new ArrayList<String>();
    private static final Set<Long> archived = new HashSet<Long>();
    private static long eventSequence;

    /** Operator permission belongs to one order, never to the next customer order. */
    public static synchronized void orderAccepted() {
        if (Boolean.getBoolean("gui.enabled")) {
            running=false;
            message="New order ready. Press Start to begin production.";
            event("-","SYSTEM",message,"INFO");
        }
    }

    public static synchronized void command(GuiCommand c) {
        if (c==null || c.id==null || !commands.add(c.id)) return;
        if(c.action==null || c.operations==null) { event("-","SYSTEM","Malformed GUI command rejected.","INFO"); return; }
        commandId=c.id;
        if(System.currentTimeMillis()-c.createdAt>5000) {
            message="Expired command rejected. Review the current state and try again.";
            event("-","SYSTEM",message,"INFO"); return;
        }
        if (c.action.equals("START")) {
            // Start admits bottles; it does not decide the mode. In manual
            // that matters: the operator picks Manual, presses Start, and the
            // coordinator books one bottle in for them to walk down the line
            // by hand. Switching back is the mode selector's job, not Start's.
            if (jam || draining) { message="Clear the fault or wait for the line to drain before starting."; }
            else if (mode.equals("Manual")) { running=true; message="Manual: a bottle is booked in. Tick the signals to move it."; }
            else { mode="Automatic"; pendingMode=mode; running=true; message="Automatic production started."; }
        } else if (c.action.equals("PAUSE")) {
            if (resetting || draining) message="Reset/mode transition is draining; wait for admitted bottles to finish.";
            else {
                running=false;                message="Paused. Current station actions finish; new operations wait for Start.";
            }
        } else if (c.action.equals("RESET")) {
            // Not a drain. The line is emptied on the coordinator's next tick
            // and the plan goes with it, so there is nothing to wait for and
            // no half-reset state to be caught in.
            running=false; draining=false; resetting=false;
            mode="Automatic"; pendingMode=mode;
            resetRequested=true;
            message="Hard reset: the line is cleared.";
        } else if (c.action.equals("MANUAL") || c.action.equals("AUTO")) {
            running=false; draining=true;
            pendingMode=c.action.equals("MANUAL")?"Manual":"Automatic";
            message="Finishing admitted bottles before stopping.";
        } else if (c.action.equals("QUALITY")) {
            if (c.rejectEvery<0 || c.rejectEvery==1 || c.rejectEvery>1000) message="Reject frequency must be 0 (off), or 2-1000.";
            else { rejectEvery=c.rejectEvery; productionNumber=0; message="Quality test: " + (rejectEvery==0?"all pass":"reject 1 in every "+rejectEvery+" new bottles")+"."; }
        } else if (c.action.equals("FAULT")) {
            jam=true; running=false; draining=true;
            message="Labeller jam simulated. Admission stopped; clear the fault to finish the line.";
            GuiSnapshot.Event e=event("-","LABELLER",message,"FAULT"); alerts.put("LABELLER",e);
        } else if (c.action.equals("CLEAR_FAULT")) {
            jam=false; alerts.clear(); message="Fault cleared. Admitted bottles will finish; press Start to resume admission.";
        } else { message="Unknown command rejected: "+c.action; }
        event("-","SYSTEM",message,"INFO");
    }


    /**
     * The mode every machine controller is held in: 0 automatic, 1 manual.
     *
     * Manual is only asserted once the line has finished draining, because a
     * controller that switches mode mid-sequence abandons whatever it was
     * holding. Draining therefore stays automatic until wip reaches zero, at
     * which point observe() settles the mode and this starts returning 1.
     */
    public static synchronized int machineMode() { return mode.equals("Manual") && !draining ? 1 : 0; }

    private static boolean resetRequested;

    /**
     * True once, on the tick the coordinator should empty the line.
     *
     * Consumed rather than polled as a level, so the wipe and the reset
     * signal to the machines happen in the same instant and cannot be applied
     * twice. The brief's requirement - that no opened bottle survives a
     * suspension - is met by there being no bottle left at all.
     */
    public static synchronized boolean takeReset() {
        if (!resetRequested) {
            return false;
        }
        resetRequested = false;
        return true;
    }


    /** The same thing as the line mode the digital twin reports. */
    public static synchronized LineMode lineMode() {
        if (draining) return LineMode.DRAINING;
        if (mode.equals("Manual")) return LineMode.MANUAL;
        if (!running || jam) return LineMode.SUSPENDED;
        return LineMode.AUTO;
    }
    /**
     * Whether the coordinator may hand the loader another bottle.
     *
     * Manual is deliberately not excluded. The point of manual mode is to walk
     * a real bottle through the line by hand, so the coordinator still admits
     * it and still books it into the registry; what changes is that every
     * actuator afterwards waits for the operator instead of firing itself.
     * Admission is rate-limited by the loader's rendezvous either way, so one
     * bottle is admitted and the next waits until the loader is free again.
     */
    public static synchronized boolean canLoad() {
        if (draining || jam) return false;
        return running;
    }
    /**
     * The faults the quality test injects, one per affected bottle, in turn.
     *
     * Rotating rather than always arming the same one is the point: each is
     * caught by a different station, so a run exercises four detection paths
     * and the histories show where each fault was found rather than four
     * copies of the same line.
     */
    private static final String[] FAULTS = {"lid-fitted", "misfill", "cap-loose", "no-print"};
    private static int faultsArmed;

    public static synchronized void prepare(WorkpieceTwin w, boolean replacement) {
        if (!replacement && rejectEvery>0 && ++productionNumber % rejectEvery == 0) {
            w.armFault(FAULTS[faultsArmed++ % FAULTS.length]);
        }
    }
    public static synchronized void observe(ABSTwin plant) {
        PurchaseOrder order=OrderBook.purchaseOrder();
        if (order!=null) for(Batch b:order.batches()) {
            if(b.isComplete() && archived.add(b.id)) history.add("BATCH-"+b.id+" | "+b.productName+" | "+b.accepted()+"/"+b.target+" accepted | "+b.recovered()+" recycled | COMPLETE");
        }
        if (draining && plant.wip()==0 && !jam) {
            draining=false; mode=pendingMode;
            if(resetting) {
                if(order!=null) for(Batch b:order.batches()) if(!b.isComplete()) history.add("BATCH-"+b.id+" | "+b.productName+" | "+b.accepted()+"/"+b.target+" accepted | "+b.recovered()+" recycled | RESET");
                OrderBook.resetAfterDrain(); resetting=false; alerts.clear();
            }
            message="Line stopped with no bottles in process. "+mode+" mode ready.";
            event("-","SYSTEM",message,"INFO");
        }
    }
    public static synchronized String state() {
        if(jam) return "FAULT";
        if(draining) return resetting?"RESETTING / DRAINING":"DRAINING";
        if(mode.equals("Manual")) return "MANUAL";
        // No order is IDLE even when stopped: after a hard reset the line is
        // empty and waiting for a customer, which is not the same as paused
        // part way through a run.
        PurchaseOrder o=OrderBook.purchaseOrder();
        if(o==null) return "IDLE";
        if(!running) return "PAUSED";
        return o.status()==POStatus.COMPLETE?"COMPLETED":"RUNNING";
    }
    public static synchronized void fill(GuiSnapshot s) {
        s.mode=mode; s.state=state(); s.commandId=commandId; s.commandMessage=message; s.rejectEvery=rejectEvery;
        s.events.addAll(events); s.alerts.addAll(alerts.values()); s.history.addAll(history);
    }
    public static synchronized GuiSnapshot.Event event(String bottle,String machine,String message,String severity) {
        GuiSnapshot.Event e=new GuiSnapshot.Event(++eventSequence,System.currentTimeMillis(),bottle,machine,message,severity);
        events.add(e); if(events.size()>2000) events.remove(0); return e;
    }
    public static synchronized void workpieceEvent(WorkpieceTwin w,WorkpieceEvent e) {
        String severity=e.type==EventType.FLAGGED?"QUALITY":"INFO";
        GuiSnapshot.Event record=event(w.serial,e.machine.toString(),e.type+": "+e.cause+(e.type==EventType.MEASURED?" ("+e.measurement+" mL)":""),severity);
        if(e.type==EventType.FLAGGED) alerts.put(e.machine.toString(),record);
        if(e.machine==Machine.RECYCLING && e.type==EventType.COMPLETED && "returned".equals(e.cause)) {
            alerts.entrySet().removeIf(a -> "QUALITY".equals(a.getValue().severity) && w.serial.equals(a.getValue().bottle));
        }
    }
}
