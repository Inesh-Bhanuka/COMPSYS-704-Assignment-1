import java.awt.GraphicsEnvironment;
import javax.swing.SwingUtilities;

/** Only the POS clock domain uses this GUI mailbox; the controller uses signals. */
public final class PosBridge {
    private static volatile PosOrderRequest pending;
    private static volatile PosOrderStatus latest;
    private static boolean opened;

    private PosBridge() { }

    public static synchronized void open() {
        if (opened) return;
        opened = true;
        if (!GraphicsEnvironment.isHeadless() && !Boolean.getBoolean("pos.headless")) {
            SwingUtilities.invokeLater(() -> new PosWindow().setVisible(true));
        }
    }

    public static synchronized void submit(PosOrderRequest request) {
        request.validate();
        if (pending != null && (latest == null || !latest.isComplete())) {
            throw new IllegalStateException("Wait for the current purchase order to complete.");
        }
        latest = null;
        pending = request;
    }

    public static PosOrderRequest pending() { return pending; }
    public static PosOrderStatus latest() { return latest; }

    public static synchronized void acceptFeedback(PosOrderStatus status) {
        if (status != null && pending != null && pending.orderId.equals(status.orderId)
                && (latest == null || status.revision > latest.revision)) latest = status;
    }
}
