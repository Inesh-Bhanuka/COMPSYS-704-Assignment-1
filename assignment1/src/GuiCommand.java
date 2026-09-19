import java.io.Serializable;
import java.util.*;

/** Immutable operator intent: one press of a control button. Manual actuator
 *  selections are not commands - they travel to the plant as a ManualTick. */
public final class GuiCommand implements Serializable {
    private static final long serialVersionUID = 1L;
    public final String id = UUID.randomUUID().toString();
    public final long createdAt = System.currentTimeMillis();
    public final String action;
    public final List<String> operations;
    public final int rejectEvery;
    public GuiCommand(String action) { this(action, Collections.<String>emptyList(), 0); }
    public GuiCommand(String action, List<String> operations, int rejectEvery) {
        this.action = action;
        this.operations = Collections.unmodifiableList(new ArrayList<String>(operations));
        this.rejectEvery = rejectEvery;
    }
}
