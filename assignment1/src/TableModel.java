/**
 * Where every workpiece on the rotary table is.
 *
 * Kept out of the clock domain for two reasons: the compiler inlines Java
 * into the generated state machine, so this keeps it under the JVM's 64 KB
 * method limit, and the reactions that share it need one accessor.
 *
 * Index 0..5 is table position 1..6: load, filler A, filler B, lid, capper,
 * unload.
 */
public class TableModel {

	private static TableModel SHARED;

	/** Reactions get their own scope, so they share the model through this. */
	public static TableModel shared() {
		if (SHARED == null) {
			SHARED = new TableModel();
		}
		return SHARED;
	}

	private final WorkpieceTwin[] pos = new WorkpieceTwin[6];

	/**
	 * A rendezvous completes whenever both sides are ready, which is not
	 * necessarily an aligned instant, so an accepted bottle waits here and is
	 * placed at the next alignment.
	 */
	private WorkpieceTwin pending;

	public boolean hasPending() {
		return pending != null;
	}

	public void setPending(WorkpieceTwin w) {
		pending = w;
	}

	public void commitPending() {
		pos[0] = pending;
		System.out.println("[RT] " + pending + " placed at position 1.");
		pending = null;
	}

	/** The workpiece at a position, or null. */
	public WorkpieceTwin at(int i) {
		return pos[i];
	}

	public boolean occupied(int i) {
		return pos[i] != null;
	}

	public WorkpieceTwin exitWorkpiece() {
		return pos[5];
	}

	public boolean exitOccupied() {
		return pos[5] != null;
	}

	public boolean loadPointFree() {
		return pos[0] == null;
	}

	public boolean anyOccupied() {
		for (int i = 0; i < 6; i++) {
			if (pos[i] != null) {
				return true;
			}
		}
		return false;
	}

	/** Load point free, nothing accepted, nothing on the table. */
	public boolean idle() {
		return pos[0] == null && pending == null && !anyOccupied();
	}

	public boolean readyToPlace() {
		return pos[0] == null && pending != null;
	}

	public void clearExit() {
		pos[5] = null;
	}

	/** Advance every workpiece one position. */
	public void index() {
		WorkpieceTwin last = pos[5];
		for (int i = 5; i > 0; i--) {
			pos[i] = pos[i - 1];
		}
		pos[0] = last;
	}

	public void sayUnloading() {
		System.out.println("[RT] Unloading " + pos[5] + " from position 6.");
	}

	/**
	 * Compare the model against the plant's own presence sensors.
	 *
	 * Appendix 4 puts sensors at positions 1, 2, 4 and 5 only. The controller
	 * drives the table from this model, so the sensors are the one
	 * independent check that the two still agree; a mismatch means a bottle
	 * has been placed, taken or lost without the model hearing about it, and
	 * it is far better to say so than to keep sequencing on a stale picture.
	 *
	 * Reported rather than corrected: the model is the record the workpiece
	 * twins are attached to, and silently rewriting it would hide the fault
	 * the check exists to find.
	 */
	public void checkAgainstSensors(boolean atPos2, boolean atPos4, boolean atPos5) {
		report("2", pos[1] != null, atPos2);
		report("4", pos[3] != null, atPos4);
		report("5", pos[4] != null, atPos5);
	}

	private void report(String where, boolean model, boolean sensed) {
		if (model != sensed) {
			System.out.println("[RT] Occupancy mismatch at position " + where
					+ ": model says " + (model ? "occupied" : "empty")
					+ ", sensor says " + (sensed ? "occupied" : "empty") + ".");
		}
	}

	/** Occupancy line, only when the table is carrying something. */
	public void report() {
		if (!anyOccupied()) {
			return;
		}
		StringBuilder sb = new StringBuilder("[RT] Indexed. Positions 1-6:");
		for (int i = 0; i < 6; i++) {
			sb.append(' ').append(pos[i] == null ? "." : Long.toString(pos[i].id));
		}
		System.out.println(sb.toString());
	}
}
