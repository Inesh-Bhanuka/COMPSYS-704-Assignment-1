import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** One line item of an order: a run of identical bottles. */
public class Batch implements Serializable {

	private static final long serialVersionUID = 1L;

	public final long id;
	public final String productName;
	public final Recipe recipe;
	public final int sizeMl;
	public final int target;

	private final List<WorkpieceTwin> workpieces = new ArrayList<WorkpieceTwin>();

	public Batch(long id, Recipe recipe, int sizeMl, int target) {
		this(id, "Custom Product", recipe, sizeMl, target);
	}

	public Batch(long id, String productName, Recipe recipe, int sizeMl, int target) {
		this.id = id;
		this.productName = productName;
		this.recipe = recipe;
		this.sizeMl = sizeMl;
		this.target = target;
	}

	public void add(WorkpieceTwin w) {
		workpieces.add(w);
	}

	public List<WorkpieceTwin> workpieces() {
		return java.util.Collections.unmodifiableList(workpieces);
	}

	public int accepted() {
		return count(WorkpieceStatus.DONE);
	}

	public int recovered() {
		return count(WorkpieceStatus.RECOVERED);
	}

	/** The batch is filled when enough good bottles exist, not when enough were admitted. */
	public boolean isComplete() {
		return accepted() >= target;
	}

	private int count(WorkpieceStatus s) {
		int n = 0;
		for (WorkpieceTwin w : workpieces) {
			if (w.status() == s) {
				n++;
			}
		}
		return n;
	}

	public String toString() {
		return "batch " + id + " (" + sizeMl + "ml " + recipe + ", " + accepted() + "/" + target + ")";
	}
}
