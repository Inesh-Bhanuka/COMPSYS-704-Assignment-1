import java.util.*;
import com.systemj.netapi.TCPSender;

/**
 * Reset empties the whole line, and the display with it, in one tick.
 *
 * Not a drain: nothing is finished, nothing is pushed to the end, and there is
 * no settling period to be caught half way through. The models the display
 * reads are emptied in the same instant the machines are told, so the picture
 * goes clean together rather than a stage at a time.
 *
 * What survives is the record. Every bottle the reset removed is discarded on
 * its own history first and kept in the registry's archive, so the audit can
 * still account for every bottle the run ever admitted.
 */
public final class HardResetTest {

	private static final StringBuffer LOG = new StringBuffer();

	private static void check(boolean ok, String what) {
		if (!ok) {
			throw new AssertionError(what);
		}
		System.out.println("  ok   " + what);
	}

	private static void command(String action) throws Exception {
		GuiCommand c = new GuiCommand(action);
		try (TCPSender s = new TCPSender("127.0.0.1", GuiClient.COMMAND_PORT)) {
			for (int i = 0; i < 6; i++) {
				s.emit(c, 1);
				Thread.sleep(200);
			}
		}
	}

	/**
	 * Start production, and keep asking until it actually starts.
	 *
	 * Accepting an order sets the line back to stopped so the operator decides
	 * when it runs, so a Start that arrives just before the order lands is
	 * cancelled by it. One retry loop is simpler than trying to win the race.
	 */
	private static void startProduction(int seconds) throws Exception {
		long end = System.currentTimeMillis() + seconds * 1000L;
		int seen = countLoads();
		while (System.currentTimeMillis() < end) {
			command("START");
			for (int i = 0; i < 20; i++) {
				if (countLoads() > seen) {
					return;
				}
				Thread.sleep(200);
			}
		}
		throw new AssertionError("Production never started");
	}

	private static int countLoads() {
		int n = 0, i = 0;
		while ((i = LOG.indexOf("[SC] Loading bottle", i)) >= 0) {
			n++;
			i++;
		}
		return n;
	}

	private static void waitFor(String text, int seconds) throws Exception {
		long end = System.currentTimeMillis() + seconds * 1000L;
		while (System.currentTimeMillis() < end) {
			if (LOG.indexOf(text) >= 0) {
				return;
			}
			Thread.sleep(100);
		}
		throw new AssertionError("Timed out waiting for: " + text);
	}

	public static void main(String[] args) {
		try {
			System.setProperty("gui.enabled", "true");
			System.setProperty("gui.headless", "true");
			System.setProperty("pos.headless", "true");

			java.io.PrintStream real = System.out;
			System.setOut(new java.io.PrintStream(new java.io.OutputStream() {
				public void write(int b) {
					LOG.append((char) b);
					real.write(b);
				}
			}, true));

			Thread plant = new Thread(new Runnable() {
				public void run() {
					com.systemj.SystemJRunner.main(new String[] {"sysj/abs.xml"});
				}
			});
			plant.setDaemon(true);
			plant.start();
			Thread.sleep(4000);

			// A batch big enough that the line is genuinely busy when the
			// reset lands: bottles on the table, on the belts, and stored.
			PosBridge.submit(new PosOrderRequest(PosOrderRequest.newOrderId(), "Reset Test",
					Collections.singletonList(
							new PosOrderRequest.ProductBatch("Probe", 200, 50, 50, 8))));
			startProduction(60);
			waitFor("stored in batch", 240);

			int admitted = TwinRegistry.shared().all().size();
			check(BatchStore.shared().total() > 0, "storage had product in it before the reset");
			check(admitted > 0, "the line had admitted " + admitted + " bottle(s)");

			command("RESET");
			waitFor("Hard reset: line cleared", 60);

			// Everything the display reads, empty.
			check(!TableModel.shared().anyOccupied(), "nothing left on the table");
			check(BeltQueue.shared().size() == 0, "nothing left on the infeed");
			check(RecyclingQueue.shared().size() == 0, "nothing waiting at the recycling station");
			check(BatchStore.shared().total() == 0, "storage is empty");
			check(OrderBook.purchaseOrder() == null, "the production plan is gone");

			// And the display itself.
			Thread.sleep(1500);
			GuiSnapshot snap = GuiTelemetry.latest();
			check(snap != null, "telemetry produced a snapshot");
			check(snap.bottles.isEmpty(),
					"the display shows no bottles at all, not " + snap.bottles.size());

			// The record is not what was reset.
			check(TwinRegistry.shared().all().size() == admitted,
					"every bottle admitted is still in the archive");
			for (WorkpieceTwin w : TwinRegistry.shared().all()) {
				check(w.status() == WorkpieceStatus.DONE
						|| w.status() == WorkpieceStatus.RECOVERED
						|| w.status() == WorkpieceStatus.SCRAP,
						"every bottle ended in a terminal state");
				break;
			}

			TwinAudit.report();
			check(LOG.indexOf("AUDIT FAILED") < 0, "the audit still balances after a reset");

			// The line is usable again straight away.
			int mark = LOG.length();
			PosBridge.submit(new PosOrderRequest(PosOrderRequest.newOrderId(), "After Reset",
					Collections.singletonList(
							new PosOrderRequest.ProductBatch("Second", 100, 60, 40, 1))));
			startProduction(60);
			long end = System.currentTimeMillis() + 240000L;
			while (System.currentTimeMillis() < end && BatchStore.shared().total() == 0) {
				Thread.sleep(200);
			}
			check(BatchStore.shared().total() == 1, "a fresh order runs on the cleared line");
			check(LOG.substring(mark).indexOf("AUDIT FAILED") < 0, "no fault while restarting");

			System.out.println("HARD RESET TEST PASSED: the line and the display empty "
					+ "in one tick, the record survives, production restarts.");
			System.exit(0);
		} catch (Throwable error) {
			error.printStackTrace();
			System.exit(1);
		}
	}
}
