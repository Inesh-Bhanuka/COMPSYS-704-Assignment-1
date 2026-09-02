/**
 * The rotary table's occupancy model, held outside the clock domain.
 *
 * Two reasons for this class. First, the SystemJ compiler inlines Java
 * statements into the generated state machine, so keeping logic here rather
 * than in the reaction keeps the generated method well under the JVM's 64 KB
 * limit. Second, this is the controller's record of where every workpiece is,
 * which is the natural place to attach workpiece identity later.
 *
 * Index 0..5 corresponds to table positions 1..6:
 *   0 - load from the infeed conveyor
 *   1 - liquid filler 1
 *   2 - liquid filler 2
 *   3 - lid placement
 *   4 - capper
 *   5 - unload to the outfeed conveyor
 */
public class TableModel {

	/**
	 * The SystemJ compiler gives each reaction its own local scope, so an
	 * object declared at clock-domain level is not visible inside the parallel
	 * reactions that need it. There is exactly one of these per system, so the
	 * reactions share it through this accessor instead.
	 */
	private static TableModel SHARED;

	public static TableModel shared() {
		if (SHARED == null) {
			SHARED = new TableModel();
		}
		return SHARED;
	}

	private final int[] id = new int[6];

	/**
	 * One-deep intake buffer. The infeed rendezvous commits the transfer at
	 * the instant the channel completes, which is not necessarily an instant
	 * at which the table is aligned. The accepted bottle waits here and is
	 * placed at position 1 on the next alignment.
	 */
	private int pending = 0;

	public boolean hasPending() {
		return pending != 0;
	}

	public void setPending(int bottle) {
		pending = bottle;
	}

	/** Move the accepted bottle onto position 1. */
	public void commitPending() {
		id[0] = pending;
		System.out.println("[RT] Bottle " + pending + " placed at position 1.");
		pending = 0;
	}

	/** Identity at a position, or 0 if that position is empty. */
	public int idAt(int i) {
		return id[i];
	}

	public int exitId() {
		return id[5];
	}

	public boolean at(int i) {
		return id[i] != 0;
	}

	/** Load point free, nothing accepted, and nothing on the table. */
	public boolean idle() {
		return id[0] == 0 && pending == 0 && !anyOccupied();
	}

	/** Load point free and a bottle waiting in the intake buffer. */
	public boolean readyToPlace() {
		return id[0] == 0 && pending != 0;
	}

	public boolean loadPointFree() {
		return id[0] == 0;
	}

	public boolean exitOccupied() {
		return id[5] != 0;
	}

	public boolean anyOccupied() {
		for (int i = 0; i < 6; i++) {
			if (id[i] != 0) {
				return true;
			}
		}
		return false;
	}

	public void clearExit() {
		id[5] = 0;
	}

	/** Advance every workpiece one position. */
	public void index() {
		int last = id[5];
		for (int i = 5; i > 0; i--) {
			id[i] = id[i - 1];
		}
		id[0] = last;
	}

	public void sayUnloading() {
		System.out.println("[RT] Unloading bottle " + id[5] + " from position 6.");
	}

	/** Prints the occupancy line, but only when the table is carrying work. */
	public void report() {
		if (!anyOccupied()) {
			return;
		}
		StringBuilder sb = new StringBuilder("[RT] Indexed. Positions 1-6:");
		for (int i = 0; i < 6; i++) {
			sb.append(' ').append(id[i] == 0 ? "." : Integer.toString(id[i]));
		}
		System.out.println(sb.toString());
	}
}
