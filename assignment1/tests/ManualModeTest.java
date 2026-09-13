import java.util.*;
import com.systemj.netapi.TCPSender;

/**
 * Manual mode walks a real bottle down the line, one actuator at a time.
 *
 * The point of this test is the thing that is easy to fake and hard to do: in
 * manual the plant must move only when the operator says so, and the bottle's
 * record must advance exactly as it would in automatic, because it is the same
 * sequence running - each actuator stroke simply waits at a gate for its
 * manual input instead of firing itself.
 *
 * So the test asserts three separate things:
 *
 *   1. automatic production is untouched by the gates;
 *   2. in manual, nothing moves on its own, over several seconds of silence;
 *   3. ticking one signal at a time carries a bottle from the magazine, onto
 *      the infeed belt, along it, and into the table's hands.
 *
 * Step 3 is the whole argument. If the gates were wired wrongly the sequence
 * would either run away by itself (caught by 2) or stall at the first gate
 * (caught by 3).
 */
public final class ManualModeTest {

	private static final StringBuffer LOG = new StringBuffer();

	private static void check(boolean ok, String what) {
		if (!ok) {
			throw new AssertionError(what);
		}
		System.out.println("  ok   " + what);
	}

	/** Everything the plant has printed since the marker. */
	private static String since(int marker) {
		return LOG.substring(Math.min(marker, LOG.length()));
	}

	/** Resent a few times, as the real panel does: one emit can be missed. */
	private static void command(String action) throws Exception {
		GuiCommand c = new GuiCommand(action);
		try (TCPSender s = new TCPSender("127.0.0.1", GuiClient.COMMAND_PORT)) {
			for (int i = 0; i < 6; i++) {
				s.emit(c, 1);
				Thread.sleep(200);
			}
		}
	}

	/** The supervisor's own state, not a console line: messages go to the GUI. */
	private static void waitForManual(int seconds) throws Exception {
		long end = System.currentTimeMillis() + seconds * 1000L;
		while (System.currentTimeMillis() < end) {
			if (GuiSupervisor.machineMode() == 1) {
				return;
			}
			Thread.sleep(100);
		}
		throw new AssertionError("Timed out waiting for manual mode; supervisor says "
				+ GuiSupervisor.state());
	}

	private static long sequence;

	/**
	 * Press Send Tick, the way the panel does.
	 *
	 * Each tick is resent a few times because one emit can be missed; the
	 * sequence number is what makes the resend harmless, so a controller sees
	 * the signal once however many copies arrive.
	 */
	private static void pulse(Set<String> ids, int ticks) throws Exception {
		try (TCPSender s = new TCPSender("127.0.0.1", GuiClient.MANUAL_PORT)) {
			for (int t = 0; t < ticks; t++) {
				ManualTick tick = new ManualTick(++sequence, ids);
				for (int i = 0; i < 3; i++) {
					s.emit(tick, 1);
					Thread.sleep(40);
				}
			}
		}
	}

	/**
	 * Hold one signal on the panel until the plant says it did something.
	 *
	 * The gate opens on the first tick that carries the signal; the stroke that
	 * follows is held by the controller against the plant's own sensor, not by
	 * the operator's finger. Repeating the tick is only insurance against the
	 * sequence not having reached the gate yet.
	 */
	private static void drive(String id, String expect, int seconds) throws Exception {
		int marker = LOG.length();
		long end = System.currentTimeMillis() + seconds * 1000L;
		Set<String> one = new HashSet<String>(Arrays.asList(id));
		while (System.currentTimeMillis() < end) {
			pulse(one, 4);
			if (since(marker).indexOf(expect) >= 0) {
				System.out.println("  ok   ticking '" + id + "' produced: " + expect);
				return;
			}
		}
		throw new AssertionError("Ticking '" + id + "' never produced: " + expect);
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

			// ---- 1. automatic production still works ----
			//
			// Every actuator in the line now sits behind a manual gate. In
			// automatic the mode reaction emits 'auto' every tick, so each gate
			// is preempted in the same instant it is entered and costs nothing.
			// This is the assertion that says so.
			PosOrderRequest order = new PosOrderRequest(PosOrderRequest.newOrderId(), "Manual Test",
					Arrays.asList(new PosOrderRequest.ProductBatch("Probe", 100, 60, 40, 3)));
			PosBridge.submit(order);
			command("START");
			waitFor("stored in batch", 240);
			check(true, "automatic production still completes a bottle through every gate");

			// ---- 2. switch to manual and let the line settle ----
			command("MANUAL");
			waitForManual(120);
			check(GuiSupervisor.machineMode() == 1, "machines are told mode 1 once drained");
			check(GuiSupervisor.lineMode() == LineMode.MANUAL, "the twin reports MANUAL, not AUTO");

			// ---- 3. nothing moves on its own ----
			int quiet = LOG.length();
			Thread.sleep(5000);
			String silence = since(quiet);
			check(silence.indexOf("[RTPlant] Rotating.") < 0,
					"the table does not index by itself in manual");
			check(silence.indexOf("[BLPlant] Bottle picked") < 0,
					"the loader does not pick by itself in manual");

			// ---- 4. book a bottle in by hand ----
			//
			// Start still admits. What it no longer does is choose the mode, so
			// the coordinator hands the loader a real workpiece and the loader
			// then stops at its first gate, waiting for the operator.
			int booked = LOG.length();
			PosBridge.submit(new PosOrderRequest(PosOrderRequest.newOrderId(), "By Hand",
					Arrays.asList(new PosOrderRequest.ProductBatch("Probe", 100, 60, 40, 1))));
			// Accepting an order sets the line back to stopped so the operator
			// decides when it runs, so a Start that arrives just before the
			// order lands is cancelled by it. Retrying is simpler than trying
			// to win that race.
			long deadline = System.currentTimeMillis() + 60000L;
			while (System.currentTimeMillis() < deadline
					&& since(booked).indexOf("[BL] Order received") < 0) {
				command("START");
				Thread.sleep(1000);
			}
			check(since(booked).indexOf("[BL] Order received") >= 0,
					"Start in manual books a bottle in and the loader takes the order");

			Thread.sleep(3000);
			check(since(booked).indexOf("[BLPlant] Bottle picked") < 0,
					"and the loader then waits - the order alone moves nothing");

			// ---- 5. walk it out of the magazine ----
			// Swinging the arm over to the magazine has no line of its own in
			// the plant log - the proof that it happened is that the next gate
			// becomes reachable at all.
			pulse(new HashSet<String>(Arrays.asList("bl.armSource")), 8);
			drive("bl.vacOn", "[BLPlant] Bottle picked", 60);
			drive("bl.armDest", "[CV] Accepted", 60);
			drive("bl.release", "[BLPlant] Bottle released", 60);

			// ---- 6. and down the belt into the table ----
			drive("cv.injectInfeed", "[CVPlant] Bottle entered infeed", 60);
			drive("cv.motInfeed", "[CVPlant] Bottle arrived at position 1", 90);
			drive("cv.takeFromPos1", "handed to the table", 60);

			// The record moved with the bottle, because it is the same sequence
			// that runs in automatic - there is no second set of books.
			boolean inFlight = false;
			for (WorkpieceTwin w : TwinRegistry.shared().all()) {
				if (w.status() != WorkpieceStatus.DONE
						&& w.status() != WorkpieceStatus.RECOVERED
						&& w.status() != WorkpieceStatus.SCRAP) {
					inFlight = true;
				}
			}
			check(inFlight, "the hand-driven bottle is on the books as work in progress");

			// ---- 7. onto the carousel, and one tick across two machines ----
			drive("rt.loadPos1", "[RTPlant] Bottle loaded at position 1", 60);

			// A selection, not a single button: the table will not index until
			// the stations it started have all reported back, and the only
			// station holding a bottle is filler 1. Ticking both together is
			// how the panel is meant to be used - the operator selects the
			// signals the next move needs and sends them as one tick.
			int marker = LOG.length();
			long busy = System.currentTimeMillis() + 90000L;
			Set<String> both = new HashSet<String>(Arrays.asList("f1.valveOpen", "rt.rotaryTrigger"));
			while (System.currentTimeMillis() < busy
					&& since(marker).indexOf("[RTPlant] Rotating.") < 0) {
				pulse(both, 4);
			}
			String seen = since(marker);
			check(seen.indexOf("[FILL] Liquid") >= 0, "the ticked valve filled the bottle");
			check(seen.indexOf("[RTPlant] Rotating.") >= 0,
					"and the same selection indexed the table once the station was done");

			System.out.println("MANUAL MODE TEST PASSED: automatic unaffected, nothing self-starts "
					+ "in manual, and ticked signals carry a bottle from the magazine to the table.");
			System.exit(0);
		} catch (Throwable error) {
			error.printStackTrace();
			System.exit(1);
		}
	}
}
