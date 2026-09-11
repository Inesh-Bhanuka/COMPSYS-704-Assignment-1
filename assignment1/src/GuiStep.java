import java.util.*;

/** Per-operation ticket consumption by SystemJ reactions, never by the GUI. */
public final class GuiStep {
    private static final Map<String, Long> used = new HashMap<String, Long>();
    public static synchronized boolean take(String operation, GuiPermit permit) {
        if (permit == null || (permit.labellerBlocked && operation.equals("LABEL"))) return false;
        if (permit.automatic) return true;
        long ticket = permit.tickets.containsKey(operation) ? permit.tickets.get(operation) : 0;
        long previous = used.containsKey(operation) ? used.get(operation) : 0;
        if (ticket <= previous) return false;
        used.put(operation, previous + 1);
        return true;
    }
    public static boolean infeedEnabled(GuiPermit permit) { return permit != null && (permit.automatic || BeltQueue.shared().peek() != null); }
    public static synchronized void discard(Map<String, Long> tickets) { used.putAll(tickets); }
}
