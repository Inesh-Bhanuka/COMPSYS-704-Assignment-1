import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * A customer order. One batch per line item, run to completion in turn.
 *
 * Published to the GUI alongside the ABSTwin, so order progress is read off
 * the same objects the plant is driven from rather than tracked separately.
 */
public class PurchaseOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	public final long id;
	public final String email;
	public final LocalDateTime orderCreated;

	private final List<Batch> batches = new ArrayList<Batch>();
	private POStatus status = POStatus.RECEIVED;
	private LocalDateTime orderComplete;

	public PurchaseOrder(long id, String email) {
		this.id = id;
		this.email = email;
		this.orderCreated = LocalDateTime.now();
	}

	public void add(Batch b) {
		batches.add(b);
	}

	public List<Batch> batches() {
		return java.util.Collections.unmodifiableList(batches);
	}

	public POStatus status() {
		return status;
	}

	public LocalDateTime orderComplete() {
		return orderComplete;
	}

	public void start() {
		status = POStatus.PROCESSING;
	}

	/** Re-checked whenever a bottle finishes; completes itself when every batch is filled. */
	public void refresh() {
		if (status == POStatus.COMPLETE) {
			return;
		}
		for (Batch b : batches) {
			if (!b.isComplete()) {
				return;
			}
		}
		if (!batches.isEmpty()) {
			status = POStatus.COMPLETE;
			orderComplete = LocalDateTime.now();
		}
	}

	public Batch batch(long batchId) {
		for (Batch b : batches) {
			if (b.id == batchId) {
				return b;
			}
		}
		return null;
	}

	public String toString() {
		return "order " + id + " [" + status + ", " + batches.size() + " batches]";
	}
}
