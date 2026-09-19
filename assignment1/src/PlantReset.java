/**
 * A hard reset: the whole line empty in one tick.
 *
 * Everything the display shows comes from a handful of shared models - the
 * table, the belts, the recycling station, the storage shelves, and the
 * registry of live bottles. Emptying them together in one call leaves no
 * order of operations for a half-reset state to appear in.
 *
 * The clock domains still need telling, because a plant keeps its own
 * occupancy and a controller can be parked mid-sequence holding a bottle that
 * no longer exists. They get the reset signal for that; this class is what
 * makes the instant consistent.
 *
 * The histories are kept. Each cleared bottle is discarded on its own record
 * first, so the record ends with a reason, and the registry moves it to an
 * archive the audit still reads. A run that ends in a reset can still account
 * for every bottle it admitted.
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
