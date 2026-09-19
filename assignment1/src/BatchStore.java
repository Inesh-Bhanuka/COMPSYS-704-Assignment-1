import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Where labelled bottles end up, kept batch by batch.
 *
 * The line ends here rather than at a machine - the outfeed conveyor takes a
 * bottle off the table at position 6, the labeller prints and applies its
 * label, and it is set down in the storage for its batch. So this is where
 * the twin retires: shelved with the rest of its batch, and findable again by
 * the serial printed on its own label.
 */
public class BatchStore {

	private static BatchStore SHARED;

	public static BatchStore shared() {
		if (SHARED == null) {
			SHARED = new BatchStore();
		}
		return SHARED;
	}

	private final Map<Long, List<WorkpieceTwin>> shelves = new LinkedHashMap<Long, List<WorkpieceTwin>>();
	private final Map<String, WorkpieceTwin> bySerial = new LinkedHashMap<String, WorkpieceTwin>();

	/**
	 * Empty the shelves.
	 *
	 * A hard reset returns the whole display to a clean line, storage
	 * included. The bottles themselves are not forgotten - their histories
	 * stay in the registry's archive, so the audit can still account for
	 * every one of them afterwards.
	 */
	public void clear() {
		shelves.clear();
		bySerial.clear();
	}

	public void store(WorkpieceTwin w) {
		List<WorkpieceTwin> shelf = shelves.get(w.batchId);
		if (shelf == null) {
			shelf = new ArrayList<WorkpieceTwin>();
			shelves.put(w.batchId, shelf);
		}
		shelf.add(w);
		bySerial.put(w.serial, w);
	}

	public List<WorkpieceTwin> shelf(long batchId) {
		List<WorkpieceTwin> shelf = shelves.get(batchId);
		return shelf == null ? new ArrayList<WorkpieceTwin>() : shelf;
	}

	public int held(long batchId) {
		return shelf(batchId).size();
	}

	public int total() {
		int n = 0;
		for (List<WorkpieceTwin> shelf : shelves.values()) {
			n += shelf.size();
		}
		return n;
	}

	/** Look a bottle up by the serial printed on its label. */
	public WorkpieceTwin find(String serial) {
		return bySerial.get(serial);
	}

	public java.util.Set<Long> batches() {
		return shelves.keySet();
	}
}
