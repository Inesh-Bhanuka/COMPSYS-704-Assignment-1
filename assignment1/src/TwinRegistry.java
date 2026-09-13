import java.util.ArrayList;
import java.util.List;

/**
 * Every workpiece the plant has admitted, in order.
 *
 * The twins themselves travel with their bottles; this only keeps a handle on
 * them so the published ABSTwin can carry the whole population rather than
 * just whatever happens to be passing through the coordinator.
 */
public class TwinRegistry {

	private static TwinRegistry SHARED;

	public static TwinRegistry shared() {
		if (SHARED == null) {
			SHARED = new TwinRegistry();
		}
		return SHARED;
	}

	private final List<WorkpieceTwin> admitted = new ArrayList<WorkpieceTwin>();
	private final List<WorkpieceTwin> archived = new ArrayList<WorkpieceTwin>();

	public void admit(WorkpieceTwin w) {
		if (w != null && !admitted.contains(w)) {
			admitted.add(w);
		}
	}

	/** Every bottle this plant has ever admitted, including reset ones. */
	public List<WorkpieceTwin> all() {
		List<WorkpieceTwin> everything = new ArrayList<WorkpieceTwin>(archived);
		everything.addAll(admitted);
		return everything;
	}

	/**
	 * Retire the current population without forgetting it.
	 *
	 * A hard reset clears the line, and the display follows the live list, so
	 * the picture goes empty. The record does not: these bottles move to the
	 * archive, where the audit still finds them. Losing the history would
	 * throw away the one thing the digital twin exists to provide.
	 */
	public void archiveAll() {
		archived.addAll(admitted);
		admitted.clear();
	}

	/**
	 * Replace the plant twin's population with the live one.
	 *
	 * Replace, not add to: the snapshot is meant to be what is in the plant
	 * now, and a bottle that has left - retired, recovered or cleared by a
	 * reset - should leave the picture with it.
	 */
	public void fill(ABSTwin plant) {
		plant.clearWorkpieces();
		for (WorkpieceTwin w : admitted) {
			plant.track(w);
		}
	}
}
