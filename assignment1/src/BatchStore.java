import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Where labelled bottles end up, kept batch by batch.
 *
 * The line ends here rather than at a machine - the outfeed conveyor pulls a
 * finished bottle off at position 6 and it is set down in the storage for its
 * batch. So this is the terminal the twin retires into: once a batch is full
 * its twins are archived together, and any one of them can be found again by
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

	/** The point of printing a serial: it retrieves the whole record. */
	public WorkpieceTwin find(String serial) {
		return bySerial.get(serial);
	}

	public java.util.Set<Long> batches() {
		return shelves.keySet();
	}
}
