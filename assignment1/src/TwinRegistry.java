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

	public void admit(WorkpieceTwin w) {
		if (w != null && !admitted.contains(w)) {
			admitted.add(w);
		}
	}

	public List<WorkpieceTwin> all() {
		return admitted;
	}

	public void fill(ABSTwin plant) {
		for (WorkpieceTwin w : admitted) {
			plant.track(w);
		}
	}
}
