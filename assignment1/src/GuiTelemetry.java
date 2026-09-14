import com.systemj.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.*;

/** Samples the model on the System Controller tick, then publishes detached values. */
public final class GuiTelemetry {
    private static long lastCapture;
    private static GuiSnapshot latest;

    /** The snapshot the display is currently working from. */
    public static synchronized GuiSnapshot latest() { return latest; }

    private static final Map<String,String> namedStations=new HashMap<String,String>();
    public static void noteMachine(String name,MachineTwin twin) { if(twin!=null) namedStations.put(name,twin.status().toString()); }
    private static final String SENSOR_NAMES="armAtSource armAtDest bottleAtSource WPgripped supplyEmpty bottleAtPos1 bottleAtPos2 bottleAtPos4 bottleAtPos5 infeedClear infeedAdmitted bottleAtOutfeedEnd outfeedClear tableAligned exitCleared filled lidAtPickup pusherExtended pusherRetracted magazineEmpty refilled capperDown capperUp capped labelPrinted labelApplied bottleAtLabeller labelStockLow glueLow labelStock glueLevel recyclingStatus bottleAtSplitterExit bottleAtLidRemoval bottleAtDumper bottleAtReturn bottleLeftReturn zAxisLowered zAxisLifted turnAtHomePos turnAtFinalPos lidGripped lidBinFull clampClosed bottleInverted bottleUpright bottleDrained wasteTankLevel bottleAtCollector armAtHome armAtLoader collectorBinFull";
    public static String productId(String product) { return "P-"+UUID.nameUUIDFromBytes(product.getBytes(StandardCharsets.UTF_8)).toString().substring(0,8).toUpperCase(); }
    public static GuiSnapshot capture(ABSTwin plant) {
        // Absence means no new telemetry. Publish only fresh samples; socket work
        // is delegated to GuiStatusSender so backpressure cannot stop the scheduler.
        if(latest!=null && System.currentTimeMillis()-lastCapture<100) return null;
        lastCapture=System.currentTimeMillis();
        GuiSnapshot s=new GuiSnapshot(); s.tick=plant.tick(); s.capturedAt=lastCapture;
        GuiSupervisor.fill(s);
        PurchaseOrder order=OrderBook.purchaseOrder();
        if(order!=null) {
            s.orderId=order.orderId;
            for(Batch b:order.batches()) {
                GuiSnapshot.BatchView v=new GuiSnapshot.BatchView(); v.id=b.id; v.product=b.productName;
                v.productId=productId(b.productName); v.size=b.sizeMl; v.one=b.recipe.liquidOne; v.two=b.recipe.liquidTwo;
                v.target=b.target; v.accepted=b.accepted(); v.recycled=b.recovered();
                v.inProcess=b.workpieces().size()-v.accepted-v.recycled;
                v.status=b.isComplete()?"Completed":b.workpieces().isEmpty()?"Queued":"In Production";
                s.batches.add(v);
            }
        }
        for(MachineTwin t:plant.machines()) s.stations.put(t.machine.toString(),t.status().toString());
        s.stations.putAll(namedStations);
        for(WorkpieceTwin w:plant.workpieces()) {
            GuiSnapshot.Bottle b=new GuiSnapshot.Bottle(); b.id=w.id; b.serial=w.serial; b.batch=w.batchId;
            b.product=w.productName; b.productId=productId(w.productName); b.size=w.sizeMl;
            b.one=w.recipe.liquidOne; b.two=w.recipe.liquidTwo; b.filled=w.filledMl();
            b.stage=w.status().toString(); b.location=belt(w); b.position=-1;
            for(int p=0;p<6;p++) if(TableModel.shared().at(p)==w) { b.position=p; b.location="ROTARY_TABLE"; }
            b.lidded=w.isLidded(); b.capped=w.isCapped(); b.labelled=w.isLabelled();
            b.quality=w.isRejected()?"REJECT: "+w.defect():w.isLabelled()?"PASS":"PENDING";
            b.completed=w.status()==WorkpieceStatus.DONE && w.lastEvent()!=null?w.lastEvent().timestamp.toString():"In production";
            s.bottles.add(b);
        }
        com.systemj.SystemJProgram program=SystemJRunner.getProgram();
        if(program!=null) sensors(program,s);
        recycling(s);
        for(GuiSnapshot.Event a:s.alerts) s.stations.put(a.machine,"FAULT");
        latest=s; return s;
    }
    /**
     * The Recycling Station's own figures: what its photo-eyes cannot show.
     *
     * The bottle on the belt is the one the station owns that is not in the
     * queue - the sequencer takes it out before commanding the conveyor, so
     * the two sets never overlap.
     */
    private static void recycling(GuiSnapshot s) {
        RecyclingQueue q=RecyclingQueue.shared();
        java.util.List<WorkpieceTwin> waiting=q.waiting();
        s.recyclingCapacity=RecyclingQueue.CAPACITY;
        s.recyclingQueued=waiting.size();
        // The station's level, off recyclingStatus: 0 idle, 1 busy,
        // 2 suspended or faulted, 3 running with a bin or tank warning.
        // Nothing publishes a MachineTwin for the station, so this is the
        // only thing that drives its lamp.
        String level=s.sensors.get("SystemControllerCD.recyclingStatus");
        if(level!=null && !"OFF".equals(level)) {
            s.stations.put("RECYCLING",
                    "1".equals(level)?"WORKING":"2".equals(level)?"FAULT":"3".equals(level)?"WARNING":"IDLE");
        }
        java.util.Set<Long> queued=new HashSet<Long>();
        for(WorkpieceTwin w:waiting) { s.recyclingWaiting.add(w.toString()); queued.add(Long.valueOf(w.id)); }
        for(GuiSnapshot.Bottle b:s.bottles) {
            if("RECOVERED".equals(b.stage)) { s.recyclingRecovered++; continue; }
            if("RECYCLING".equals(b.location) && !queued.contains(Long.valueOf(b.id))) {
                s.recyclingInStation="bottle "+b.id+" | "+b.serial
                        +" | "+b.filled+"/"+b.size+"ml | "+(b.lidded?"lidded":"open");
                s.recyclingFilledMl=b.filled; s.recyclingSizeMl=b.size; s.recyclingLidded=b.lidded;
            }
        }
    }

    private static void sensors(com.systemj.Container container,GuiSnapshot s) {
        if(container instanceof ClockDomain) {
            ClockDomain cd=(ClockDomain)container;
            if(cd.getName().contains("Controller")) for(Field f:cd.getClass().getFields()) {
                if(f.getType()!=Signal.class || !Arrays.asList(SENSOR_NAMES.split(" ")).contains(f.getName())) continue;
                try {
                    Signal signal=(Signal)f.get(cd);
                    Object value=signal.getpreval();
                    s.sensors.put(cd.getName()+"."+f.getName(),signal.getprestatus()?(value==null?"ON":String.valueOf(value)):"OFF");
                } catch(IllegalAccessException e) { throw new IllegalStateException(e); }
            }
        }
        for(int i=0;i<container.getChildSize();i++) sensors(container.getChild(i),s);
    }

    /**
     * Where the bottle is, told apart by belt.
     *
     * The infeed and the outfeed are one CONVEYOR to the plant - the same
     * controller drives both - but they are opposite ends of the line to
     * anyone looking at it. The outfeed marks its handover on the record, so
     * the last CONVEYOR event says which belt the bottle is actually on.
     */
    private static String belt(WorkpieceTwin w) {
        String station = w.station().toString();
        if (!"CONVEYOR".equals(station)) {
            return station;
        }
        for (int i = w.history().size() - 1; i >= 0; i--) {
            WorkpieceEvent e = w.history().get(i);
            if (e.machine == Machine.CONVEYOR) {
                return "outfeed".equals(e.cause) ? "CONVEYOR_OUT" : "CONVEYOR_IN";
            }
        }
        return "CONVEYOR_IN";
    }
}
