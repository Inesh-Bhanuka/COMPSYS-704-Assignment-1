/**
 * A hard reset: the whole line empty in one tick.
 *
 * ---- Why it happens here and not in thirteen places ----
 *
 * Everything the display shows comes from a handful of shared models - what
 * is on the table, what is on the belts, what is waiting at the recycling
 * station, what is on the storage shelves, and which bottles are live. Empty
 * those together in one call and the picture goes clean in a single tick,
 * with no order of operations for a half-reset state to appear in.
 *
 * The clock domains still need telling, because a plant keeps its own
 * occupancy and a controller can be parked mid-sequence holding a bottle that
 * no longer exists. They get the reset signal for exactly that; this class is
 * what makes the instant consistent.
 *
 * ---- What is kept ----
 *
 * The histories. Every bottle cleared by a reset is discarded on its own
 * record first, so its story ends with the reason rather than trailing off,
 * and the registry keeps it in an archive the audit still reads. A reset
 * empties the plant, not the evidence: a run that ends with a reset can still
 * account for every bottle it ever admitted, which is the entire point of
 * keeping a record separate from the thing it describes.
 */
public final class PlantReset {

	private PlantReset() {
	}

	/**
	 * Empty the line. Returns how many bottles were still in it.
	 *
	 * Safe to call more than once: a bottle already in a terminal state is
	 * not discarded again, so a repeated reset is a no-op rather than a
	 * second ending appended to a story that already finished.
	 */
	public static synchronized int now() {
		int cleared = 0;

		for (WorkpieceTwin w : TwinRegistry.shared().all()) {
			WorkpieceStatus s = w.status();
			if (s != WorkpieceStatus.DONE && s != WorkpieceStatus.RECOVERED
					&& s != WorkpieceStatus.SCRAP) {
				w.discard();
				cleared++;
			}
		}

		TableModel.shared().clear();
		BeltQueue.shared().clear();
		RecyclingQueue.shared().clear();
		BatchStore.shared().clear();
		TwinRegistry.shared().archiveAll();
		OrderBook.clearPlan();

		System.out.println("[SC] Hard reset: line cleared, " + cleared
				+ " bottle(s) removed unfinished. Histories kept.");
		return cleared;
	}
}
