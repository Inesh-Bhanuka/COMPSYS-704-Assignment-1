import java.util.*;
import com.systemj.netapi.TCPSender;

/**
 * One bottle, by hand, from the magazine to the shelf.
 *
 * This is the operating procedure written as a test. Each step names one
 * checkbox on the manual panel and the line the plant prints when that stroke
 * has finished; the test ticks the box until that line appears, then moves on.
 * If the panel's order were wrong the test would stall at the step that is out
 * of place, which is the only honest way to publish a procedure.
 *
 * It finishes by printing the recipe it just executed, so the procedure in the
 * report is generated from a run rather than transcribed from the source.
 */
public final class ManualWalkthroughTest {

	private static final StringBuffer LOG = new StringBuffer();
	private static final List<String> RECIPE = new ArrayList<String>();
	private static long sequence;

	/** One step of the procedure: tick this, wait for the plant to say that. */
	private static final class Step {
		final String id;       // panel checkbox, machine.actuator
		final String expect;   // what the plant prints when the stroke is done
		final String note;     // what the operator is doing
		Step(String id, String expect, String note) {
			this.id = id;
			this.expect = expect;
			this.note = note;
		}
	}

	private static Step step(String id, String expect, String note) {
		return new Step(id, expect, note);
	}

	private static String since(int marker) {
		return LOG.substring(Math.min(marker, LOG.length()));
	}

	private static void command(String action) throws Exception {
		GuiCommand c = new GuiCommand(action);
		try (TCPSender s = new TCPSender("127.0.0.1", GuiClient.COMMAND_PORT)) {
			for (int i = 0; i < 6; i++) {
				s.emit(c, 1);
				Thread.sleep(150);
			}
		}
	}

	private static void pulse(Set<String> ids, int ticks) throws Exception {
		try (TCPSender s = new TCPSender("127.0.0.1", GuiClient.MANUAL_PORT)) {
			for (int t = 0; t < ticks; t++) {
				ManualTick tick = new ManualTick(++sequence, ids);
				for (int i = 0; i < 3; i++) {
					s.emit(tick, 1);
					Thread.sleep(30);
				}
			}
		}
	}

	/**
	 * Press Send Tick with one box selected until the plant reports the move.
	 *
	 * The gate opens on the first tick that carries the signal. Repeating is
	 * insurance against the sequence not having reached that gate yet - and,
	 * for the belts, the way a level is actually driven by hand.
	 */
	private static void run(Step s, int seconds) throws Exception {
		int marker = LOG.length();
		long end = System.currentTimeMillis() + seconds * 1000L;
		Set<String> one = new HashSet<String>(Arrays.asList(s.id));
		while (System.currentTimeMillis() < end) {
			pulse(one, 4);
			if (s.expect == null || since(marker).indexOf(s.expect) >= 0) {
				System.out.println("  ok   " + label(s.id) + "  ->  " + s.note);
				RECIPE.add(label(s.id) + "   " + s.note);
				return;
			}
		}
		throw new AssertionError("Stalled at '" + label(s.id) + "' ("
				+ s.note + ") - never saw: " + s.expect);
	}

	/** The words actually printed on the panel, not the signal name. */
	private static String label(String id) {
		for (ManualActuator a : ManualActuator.all()) {
			if (a.id.equals(id)) {
				return a.machine + " / " + a.label;
			}
		}
		return id;
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

			// Manual first, so nothing runs itself while the order is placed.
			command("MANUAL");
			long settle = System.currentTimeMillis() + 60000L;
			while (System.currentTimeMillis() < settle && GuiSupervisor.machineMode() != 1) {
				Thread.sleep(100);
			}
			if (GuiSupervisor.machineMode() != 1) {
				throw new AssertionError("Never reached manual mode");
			}
			System.out.println("  ok   Operation mode -> Manual");

			// One bottle, no quality injection: this is the clean path.
			int booked = LOG.length();
			PosBridge.submit(new PosOrderRequest(PosOrderRequest.newOrderId(), "Walkthrough",
					Arrays.asList(new PosOrderRequest.ProductBatch("Probe", 100, 60, 40, 1))));
			long deadline = System.currentTimeMillis() + 60000L;
			while (System.currentTimeMillis() < deadline
					&& since(booked).indexOf("[BL] Order received") < 0) {
				command("START");
				Thread.sleep(1000);
			}
			if (since(booked).indexOf("[BL] Order received") < 0) {
				throw new AssertionError("Start never booked a bottle in");
			}
			System.out.println("  ok   Start  ->  one bottle booked in, loader waiting");

			// ---- the procedure ----
			Step[] procedure = {
				// Bottle loader
				step("bl.armSource",       null,                                  "arm swings to the magazine"),
				step("bl.vacOn",           "[BLPlant] Bottle picked",             "vacuum grips the bottle"),
				step("bl.armDest",         "[CV] Accepted",                       "arm carries it over the belt"),
				step("bl.release",         "[BLPlant] Bottle released",           "vacuum lets go"),

				// Infeed conveyor
				step("cv.injectInfeed",    "[CVPlant] Bottle entered infeed",     "bottle is set down on the belt"),
				step("cv.motInfeed",       "[CVPlant] Bottle arrived at position 1", "belt carries it to the index point"),
				step("cv.takeFromPos1",    "handed to the table",                 "bottle is lifted onto the table"),

				// Rotary table. Position 1 is the load point and does no work;
				// the four stations sit at positions 2 to 5 and the exit is 6,
				// so every station is one index away from the one before it.
				step("rt.loadPos1",        "placed at position 1",                "table takes it at position 1"),
				step("rt.rotaryTrigger",   "[RT] Indexed",                        "index to position 2, filler 1"),

				// The filler announces the pour before it opens the valve, so the
				// line that says the stroke is DONE is the running total.
				step("f1.valveOpen",       "now at 60ml",                         "filler 1 meters the first liquid"),
				step("rt.rotaryTrigger",   "[RT] Indexed",                        "index to position 3, filler 2"),

				step("f2.valveOpen",       "now at 100ml",                        "filler 2 meters the second liquid"),
				step("rt.rotaryTrigger",   "[RT] Indexed",                        "index to position 4, lid loader"),

				step("ll.pusherExtend",    "[LIDPlant] Lid pushed out",           "magazine pushes a lid to the pick-up"),
				step("ll.armSource",       null,                                  "lid arm swings to the pick-up"),
				step("ll.vacOn",           null,                                  "vacuum grips the lid"),
				step("ll.armDest",         "[LID] Lid placed",                    "arm places the lid on the bottle"),
				step("rt.rotaryTrigger",   "[RT] Indexed",                        "index to position 5, capper"),

				step("cp.screwOn",         "sealed",                              "capper screws the lid down"),
				step("rt.rotaryTrigger",   "[RT] Indexed",                        "index to position 6, the exit"),

				// The transfer to the belt is a rendezvous and happens before the
				// stroke, so it is the plant that says the stroke is done.
				step("rt.unloadExit",      "[RTPlant] Bottle unloaded from position 6", "bottle is unloaded to the outfeed"),

				// Outfeed conveyor
				step("cv.injectOutfeed",   "[CVPlant] Bottle entered outfeed",    "bottle is set on the outfeed belt"),
				step("cv.motOutfeed",      "[CVPlant] Bottle arrived at labeller point", "belt carries it to the end"),
				step("cv.collectFromEnd",  "delivered to the labeller point",     "bottle is taken off the end"),

				// Quality splitter
				step("sp.admitBottle",     "at the decision point",               "splitter claims it and reads the record"),
				step("sp.diverterRetract", "released down the",                   "diverter sends it down the normal path"),

				// Labeller
				step("lb.rollerOnOff",     "[LABPlant] Printing",                 "glue roller runs, printer prints"),
				step("lb.applyLabelExtend","[LABPlant] Label applied",            "applicator presses the label on"),
				step("lb.applyLabelRetract", "[LAB] Labelled",                    "applicator retracts, bottle is labelled"),
			};

			for (Step s : procedure) {
				run(s, 120);
			}

			// It is on the shelf, and the books say so.
			long end = System.currentTimeMillis() + 60000L;
			while (System.currentTimeMillis() < end && BatchStore.shared().total() == 0) {
				Thread.sleep(200);
			}
			if (BatchStore.shared().total() != 1) {
				throw new AssertionError("The bottle never reached storage");
			}
			System.out.println("  ok   bottle stored in a batch");

			WorkpieceTwin done = TwinRegistry.shared().all().get(0);
			if (done.status() != WorkpieceStatus.DONE) {
				throw new AssertionError("Stored, but the record says " + done.status());
			}
			System.out.println("  ok   its record reads DONE, the same as any automatic bottle");

			TwinAudit.report();
			if (LOG.indexOf("AUDIT FAILED") >= 0) {
				throw new AssertionError("The audit does not balance");
			}

			System.out.println();
			System.out.println("================ MANUAL PROCEDURE, ONE BOTTLE ================");
			System.out.println("Operation mode -> Manual, then press Start.");
			System.out.println("Then, one box at a time, Send Tick until the move completes:");
			int n = 1;
			for (String line : RECIPE) {
				System.out.println(String.format("%3d. %s", n++, line));
			}
			System.out.println("==============================================================");
			System.out.println("MANUAL WALKTHROUGH TEST PASSED: " + RECIPE.size()
					+ " operator steps carried one bottle from the magazine to the shelf.");
			System.exit(0);
		} catch (Throwable error) {
			error.printStackTrace();
			System.exit(1);
		}
	}
}
