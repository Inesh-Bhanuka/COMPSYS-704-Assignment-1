import com.systemj.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.*;

/** Samples the model on the System Controller tick, then publishes detached values. */
public final class GuiTelemetry {
    private static long lastCapture;
    private static GuiSnapshot latest;
    private static final Map<String,String> namedStations=new HashMap<String,String>();
    public static void noteMachine(String name,MachineTwin twin) { if(twin!=null) namedStations.put(name,twin.status().toString()); }
    private static final String SENSOR_NAMES="armAtSource armAtDest bottleAtSource WPgripped supplyEmpty bottleAtPos1 bottleAtPos2 bottleAtPos4 bottleAtPos5 infeedClear infeedAdmitted bottleAtOutfeedEnd outfeedClear tableAligned exitCleared filled lidAtPickup pusherExtended pusherRetracted magazineEmpty refilled capperDown capperUp capped labelPrinted labelApplied bottleAtLabeller labelStockLow glueLow labelStock glueLevel recyclingStatus";
    public static String productId(String product) { return "P-"+UUID.nameUUIDFromBytes(product.getBytes(StandardCharsets.UTF_8)).toString().substring(0,8).toUpperCase(); }
    public static GuiSnapshot capture(ABSTwin plant) {
        if(latest!=null && System.currentTimeMillis()-lastCapture<80) return latest;
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
            b.stage=w.status().toString(); b.location=w.station().toString(); b.position=-1;
            for(int p=0;p<6;p++) if(TableModel.shared().at(p)==w) { b.position=p; b.location="ROTARY_TABLE"; }
            b.lidded=w.isLidded(); b.capped=w.isCapped(); b.labelled=w.isLabelled();
            b.quality=w.isRejected()?"REJECT: "+w.defect():w.isLabelled()?"PASS":"PENDING";
            b.completed=w.status()==WorkpieceStatus.DONE && w.lastEvent()!=null?w.lastEvent().timestamp.toString():"In production";
            s.bottles.add(b);
        }
        for(GuiSnapshot.Event a:s.alerts) s.stations.put(a.machine,"FAULT");
        com.systemj.SystemJProgram program=SystemJRunner.getProgram();
        if(program!=null) sensors(program,s);
        latest=s; return s;
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
}
