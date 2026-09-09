import com.systemj.netapi.TCPSender;

/**
 * Publishes the ABSTwin and the active PurchaseOrder out of the plant for the
 * GUI, on two ports.
 *
 * Kept out of the clock domain so a display that is not listening can never
 * affect the control layer: if the socket is not there, publishing is a no-op
 * and the plant carries on.
 */
public class TwinPublisher {

	public static final int TWIN_PORT = 20000;
	public static final int ORDER_PORT = 20001;

	private static TwinPublisher SHARED;

	public static TwinPublisher shared() {
		if (SHARED == null) {
			SHARED = new TwinPublisher();
		}
		return SHARED;
	}

	private volatile TCPSender twinOut;
	private volatile TCPSender orderOut;

	/**
	 * The senders are opened on a background thread. TCPSender connects in its
	 * constructor, and a clock domain must never block waiting for a display
	 * that may not be running - so the plant starts regardless and publishing
	 * begins if and when a listener appears.
	 */
	private TwinPublisher() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					twinOut = new TCPSender("127.0.0.1", TWIN_PORT);
					orderOut = new TCPSender("127.0.0.1", ORDER_PORT);
					System.out.println("[TWIN] Publishing on " + TWIN_PORT + " (plant) and "
							+ ORDER_PORT + " (order).");
				} catch (Exception e) {
					System.out.println("[TWIN] No listener; the twin is maintained but not published.");
				}
			}
		});
		t.setDaemon(true);
		t.start();
	}

	public void publish(ABSTwin plant, PurchaseOrder order) {
		send(twinOut, plant);
		send(orderOut, order);
	}

	private void send(TCPSender out, Object payload) {
		if (out == null || payload == null) {
			return;
		}
		try {
			out.emit(payload, 1);
		} catch (Exception e) {
			// A display coming and going is not a plant fault.
		}
	}
}
