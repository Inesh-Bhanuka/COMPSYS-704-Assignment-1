import com.systemj.ipc.GenericSignalSender;
import com.systemj.ipc.SimpleClient;
import java.util.Hashtable;
import java.util.concurrent.ArrayBlockingQueue;

/** GUI telemetry is sample-and-hold: a slow display must never block a plant tick. */
public final class GuiStatusSender extends GenericSignalSender {
    private final ArrayBlockingQueue<GuiSnapshot> samples = new ArrayBlockingQueue<GuiSnapshot>(1);
    private final SimpleClient sender = new SimpleClient();

    @Override public void configure(Hashtable configuration) {
        sender.configure(configuration);
        GuiClient.daemon("GUI status signal", () -> {
            GuiSnapshot pending = null;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    if (pending == null) pending = samples.take();
                    GuiSnapshot newer = samples.poll();
                    if (newer != null) pending = newer;
                    if (sender.setup(new Object[]{Boolean.TRUE, pending})) {
                        sender.run();
                        pending = null;
                    } else Thread.sleep(100);
                } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
        });
    }

    @Override public void run() {
        if (buffer.length > 1 && buffer[1] instanceof GuiSnapshot) {
            GuiSnapshot sample = (GuiSnapshot)buffer[1];
            if (!samples.offer(sample)) { samples.poll(); samples.offer(sample); }
        }
    }
    // Hold the last snapshot between samples; its capturedAt detects stale data.
    @Override public void arun() { }
}
