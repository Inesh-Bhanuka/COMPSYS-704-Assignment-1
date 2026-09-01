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

	private final boolean[] occ = new boolean[6];

	public boolean at(int i) {
		return occ[i];
	}

	public boolean loadPointFree() {
		return !occ[0];
	}

	public boolean exitOccupied() {
		return occ[5];
	}

	public boolean anyOccupied() {
		for (int i = 0; i < 6; i++) {
			if (occ[i]) {
				return true;
			}
		}
		return false;
	}

	public void load() {
		occ[0] = true;
		System.out.println("[RT] Bottle accepted at position 1.");
	}

	public void clearExit() {
		occ[5] = false;
	}

	/** Advance every workpiece one position. */
	public void index() {
		boolean last = occ[5];
		for (int i = 5; i > 0; i--) {
			occ[i] = occ[i - 1];
		}
		occ[0] = last;
	}

	public void sayUnloading() {
		System.out.println("[RT] Unloading position 6 to outfeed.");
	}

	/** Prints the occupancy line, but only when the table is carrying work. */
	public void report() {
		if (!anyOccupied()) {
			return;
		}
		StringBuilder sb = new StringBuilder("[RT] Indexed. Occupancy 1-6: ");
		for (int i = 0; i < 6; i++) {
			sb.append(occ[i] ? 'X' : '.');
		}
		System.out.println(sb.toString());
	}
}
