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

	private final Workpiece[] pos = new Workpiece[6];

	/**
	 * A rendezvous completes whenever both sides are ready, which is not
	 * necessarily an aligned instant, so an accepted bottle waits here and is
	 * placed at the next alignment.
	 */
	private Workpiece pending;

	public boolean hasPending() {
		return pending != null;
	}

	public void setPending(Workpiece w) {
		pending = w;
	}

	public void commitPending() {
		pos[0] = pending;
		System.out.println("[RT] " + pending + " placed at position 1.");
		pending = null;
	}

	/** The workpiece at a position, or null. */
	public Workpiece at(int i) {
		return pos[i];
	}

	public boolean occupied(int i) {
		return pos[i] != null;
	}

	public Workpiece exitWorkpiece() {
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
		Workpiece last = pos[5];
		for (int i = 5; i > 0; i--) {
			pos[i] = pos[i - 1];
		}
		pos[0] = last;
	}

	public void sayUnloading() {
		System.out.println("[RT] Unloading " + pos[5] + " from position 6.");
	}

	/** Occupancy line, only when the table is carrying something. */
	public void report() {
		if (!anyOccupied()) {
			return;
		}
		StringBuilder sb = new StringBuilder("[RT] Indexed. Positions 1-6:");
		for (int i = 0; i < 6; i++) {
			sb.append(' ').append(pos[i] == null ? "." : Integer.toString(pos[i].id));
		}
		System.out.println(sb.toString());
	}
}
