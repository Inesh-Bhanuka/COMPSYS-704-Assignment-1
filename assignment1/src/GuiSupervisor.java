import java.util.*;

/** Supervisory policy, executed by SystemController. Stations retain their own sequences. */
public final class GuiSupervisor {
    public static final String[] OPERATIONS = {"LOAD","INDEX","FILL1","FILL2","LID","CAP","OUTFEED","QUALITY","LABEL","RECYCLE"};
    private static String mode="Automatic", pendingMode="Automatic", commandId="", message="";
    private static boolean running=!Boolean.getBoolean("gui.enabled"), draining, resetting, jam;
    private static int rejectEvery, productionNumber;
    private static final Set<String> commands = new HashSet<String>();
    private static final Map<String,Long> tickets = new HashMap<String,Long>();
    private static final List<GuiSnapshot.Event> events = new ArrayList<GuiSnapshot.Event>();
    private static final Map<String,GuiSnapshot.Event> alerts = new LinkedHashMap<String,GuiSnapshot.Event>();
    private static final List<String> history = new ArrayList<String>();
    private static final Set<Long> archived = new HashSet<Long>();
    private static long eventSequence;

    public static synchronized void command(GuiCommand c) {
        if (c==null || c.id==null || !commands.add(c.id)) return;
        if(c.action==null || c.operations==null) { event("-","SYSTEM","Malformed GUI command rejected.","INFO"); return; }
        commandId=c.id;
        if(System.currentTimeMillis()-c.createdAt>5000) {
            message="Expired command rejected. Review the current state and try again.";
            event("-","SYSTEM",message,"INFO"); return;
        }
        if (c.action.equals("START")) {
            if (jam || draining) { message="Clear the fault or wait for the line to drain before starting."; }
            else { mode="Automatic"; pendingMode=mode; running=true; message="Automatic production started."; }
        } else if (c.action.equals("PAUSE") || c.action.equals("RESET") || c.action.equals("MANUAL") || c.action.equals("AUTO")) {
            running=false; draining=true;
            resetting=c.action.equals("RESET");
            pendingMode=c.action.equals("MANUAL")?"Manual":"Automatic";
            GuiStep.discard(tickets);
            message="Finishing admitted bottles before " + (resetting?"reset.":"stopping.");
        } else if (c.action.equals("ENABLE")) {
            if (!mode.equals("Manual") || draining || jam) message="Enable Selected is available only in settled Manual mode.";
            else if (c.operations.isEmpty()) message="Select at least one operation.";
            else if (!Arrays.asList(OPERATIONS).containsAll(c.operations)) message="Unknown manual operation rejected.";
            else {
                for(String op:new HashSet<String>(c.operations)) tickets.put(op,tickets.containsKey(op)?tickets.get(op)+1:1L);
                message="Enabled once: " + String.join(", ",c.operations) + ". Waiting for the relevant station/bottle.";
            }
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

    public static synchronized GuiPermit permits() { return new GuiPermit((running && mode.equals("Automatic")) || draining,jam,tickets); }
    public static synchronized boolean canLoad() {
        if (draining || jam) return false;
        return running && mode.equals("Automatic") || mode.equals("Manual") && GuiStep.take("LOAD",permits());
    }
    public static synchronized boolean qualityAllowed() { return GuiStep.take("QUALITY",permits()); }
    public static synchronized void prepare(WorkpieceTwin w, boolean replacement) {
        if (!replacement && rejectEvery>0 && ++productionNumber % rejectEvery == 0) w.armFault("lid-fitted");
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
        if(!running) return "PAUSED";
        PurchaseOrder o=OrderBook.purchaseOrder();
        return o==null?"IDLE":o.status()==POStatus.COMPLETE?"COMPLETED":"RUNNING";
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
    }
}
