import java.io.Serializable;
import java.util.*;

/** Coordinator-issued permits; each manual ticket enables one complete station operation. */
public final class GuiPermit implements Serializable {
    private static final long serialVersionUID = 1L;
    public final boolean automatic;
    public final boolean labellerBlocked;
    public final Map<String, Long> tickets;
    public GuiPermit(boolean automatic, boolean labellerBlocked, Map<String, Long> tickets) {
        this.automatic = automatic; this.labellerBlocked = labellerBlocked;
        this.tickets = Collections.unmodifiableMap(new HashMap<String, Long>(tickets));
    }
}
