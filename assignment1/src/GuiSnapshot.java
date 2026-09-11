import java.io.Serializable;
import java.util.*;

/** Snapshot contains values only; Swing never reads or mutates live workpiece objects. */
public final class GuiSnapshot implements Serializable {
    private static final long serialVersionUID = 1L;
    public long tick, capturedAt;
    public String mode, state, commandId = "", commandMessage = "", orderId = "";
    public int rejectEvery;
    public final List<Bottle> bottles = new ArrayList<Bottle>();
    public final List<BatchView> batches = new ArrayList<BatchView>();
    public final List<Event> events = new ArrayList<Event>();
    public final List<Event> alerts = new ArrayList<Event>();
    public final Map<String,String> sensors = new TreeMap<String,String>();
    public final Map<String,String> stations = new LinkedHashMap<String,String>();
    public final List<String> history = new ArrayList<String>();
    public static final class Bottle implements Serializable {
        private static final long serialVersionUID = 1L;
        public long id, batch;
        public String serial, product, productId, stage, quality, completed, location;
        public int size, one, two, filled, position;
        public boolean lidded, capped, labelled;
    }
    public static final class BatchView implements Serializable {
        private static final long serialVersionUID = 1L;
        public long id;
        public String product, productId, status;
        public int size, one, two, target, accepted, recycled, inProcess;
    }
    public static final class Event implements Serializable {
        private static final long serialVersionUID = 1L;
        public final long sequence, time;
        public final String bottle, machine, message, severity;
        public Event(long sequence, long time, String bottle, String machine, String message, String severity) {
            this.sequence=sequence; this.time=time; this.bottle=bottle; this.machine=machine;
            this.message=message; this.severity=severity;
        }
    }
}
