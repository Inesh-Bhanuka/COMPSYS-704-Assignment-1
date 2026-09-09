import java.util.List;

/**
 * The structural checks from the validation plan, run over the archive rather
 * than over the animation.
 *
 * These catch the class of fault where the plant behaves correctly and the
 * model quietly loses an event - which is exactly what watching the run would
 * not show you.
 */
public class TwinAudit {

	public static void report() {
		List<WorkpieceTwin> all = TwinRegistry.shared().all();
		PurchaseOrder order = OrderBook.purchaseOrder();

		System.out.println();
		System.out.println("================ WORKPIECE HISTORIES ================");
		for (WorkpieceTwin w : all) {
			System.out.println();
			System.out.println(w + "  serial " + w.serial + "  batch " + w.batchId
					+ "  -> " + w.status());
			for (WorkpieceEvent e : w.history()) {
				System.out.println("    " + e);
			}
		}

		System.out.println();
		System.out.println("================ AUDIT ================");
		int admitted = all.size();
		int accepted = 0;
		int recovered = 0;
		int problems = 0;

		for (WorkpieceTwin w : all) {
			if (w.status() == WorkpieceStatus.DONE) {
				accepted++;
			}
			if (w.status() == WorkpieceStatus.RECOVERED) {
				recovered++;
			}
			problems += checkChain(w);
			problems += checkLabel(w);
		}

		problems += assertThat("accepted + recovered == admitted",
				accepted + recovered == admitted,
				accepted + " + " + recovered + " vs " + admitted);

		System.out.println();
		System.out.println("  order " + order.id + " is " + order.status());
		for (Batch b : order.batches()) {
			// A short batch is not a fault. It means bottles were rejected and
			// the line has not yet replaced them, which is what the POS needs
			// to know to keep the order line open.
			System.out.println("    batch " + b.id + ": " + b.accepted() + "/" + b.target
					+ " accepted, " + b.recovered() + " recovered"
					+ (b.isComplete() ? "" : "  (short - rejections not yet replaced)"));
		}

		System.out.println();
		System.out.println("  admitted " + admitted + ", accepted " + accepted
				+ ", recovered " + recovered);
		System.out.println(problems == 0
				? "AUDIT PASSED - every bottle is accounted for and every label is justified"
				: "AUDIT FAILED - " + problems + " problem(s) above");
	}

	/** Events must be non-empty, monotonic in tick, and start at the loader. */
	private static int checkChain(WorkpieceTwin w) {
		List<WorkpieceEvent> h = w.history();
		if (h.isEmpty()) {
			return assertThat("bottle " + w.id + " has a history", false, "empty");
		}
		int bad = assertThat("bottle " + w.id + " starts at the loader",
				h.get(0).machine == Machine.LOADER, h.get(0).toString());
		long last = -1;
		for (WorkpieceEvent e : h) {
			if (e.tick < last) {
				bad += assertThat("bottle " + w.id + " has monotonic ticks", false, e.toString());
				break;
			}
			last = e.tick;
		}
		return bad;
	}

	/** The invariant the labeller exists to guarantee. */
	private static int checkLabel(WorkpieceTwin w) {
		if (!w.isLabelled()) {
			return 0;
		}
		return assertThat("bottle " + w.id + " was labelled only if its record justifies it",
				w.fillComplete() && w.isSealed(),
				"fills=" + w.fillsDone() + " sealed=" + w.isSealed());
	}

	private static int assertThat(String what, boolean ok, String detail) {
		System.out.println((ok ? "  ok   " : "  FAIL ") + what + (ok ? "" : "  [" + detail + "]"));
		return ok ? 0 : 1;
	}
}
