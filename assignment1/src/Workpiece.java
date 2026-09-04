/**
 * A bottle travelling through the line, and its recipe.
 *
 * Liquids are dispensed in order - A at the first filler, B at the second -
 * so both filler instances can run the same code and just ask the bottle what
 * it needs next.
 */
public class Workpiece {

	/** Bottle sizes the line supports, in millilitres. */
	public static final int SMALL = 100;
	public static final int LARGE = 200;

	public final int id;
	public final int sizeMl;

	private final int[] pct;      // percentage of the bottle per liquid
	private int next = 0;         // liquid to dispense next
	private int filledMl = 0;

	private boolean lidded = false;
	private boolean capped = false;

	// ---- Quality record ----
	//
	// The record travels with the workpiece rather than living in the
	// coordinator, so detection can sit wherever the fault originates and
	// every machine downstream sees the same verdict. Nothing on the line
	// makes this decision yet - see OrderBook for where the defect is armed.
	private String defect = null;

	// ---- Recycling ----
	//
	// The Recycling Station strips the bottle back to an empty container, so
	// it undoes the manufacturing state rather than just setting a flag. That
	// keeps the digital twin honest: a recovered bottle really is unsealed and
	// empty, and would be truthful if it were loaded again.
	private boolean lidRemoved = false;
	private boolean drained = false;
	private boolean returned = false;

	public Workpiece(int id, int sizeMl, int pctA, int pctB) {
		this.id = id;
		this.sizeMl = sizeMl;
		this.pct = new int[] { pctA, pctB };
	}

	/** 0 = liquid A, 1 = liquid B, -1 = nothing left to dispense. */
	public int nextLiquid() {
		return next < pct.length ? next : -1;
	}

	public String nextLiquidName() {
		return next == 0 ? "A" : "B";
	}

	/** Millilitres the next liquid calls for. */
	public int nextVolumeMl() {
		return next < pct.length ? sizeMl * pct[next] / 100 : 0;
	}

	/** True if that volume still fits. The fillers check this before opening a valve. */
	public boolean fits(int ml) {
		return filledMl + ml <= sizeMl;
	}

	public void dispensed(int ml) {
		filledMl += ml;
		next++;
	}

	public int filledMl() {
		return filledMl;
	}

	public void lid() {
		lidded = true;
	}

	public void cap() {
		capped = true;
	}

	public boolean isSealed() {
		return lidded && capped;
	}

	/** Flag this bottle as having failed its quality check. */
	public void reject(String reason) {
		defect = reason;
	}

	public boolean isRejected() {
		return defect != null;
	}

	/** Why it was rejected, for the log and the operator. */
	public String defect() {
		return defect == null ? "none" : defect;
	}

	/** Lid removal: the cap and lid come off and go to the waste bin. */
	public void removeLid() {
		lidRemoved = true;
		lidded = false;
		capped = false;
	}

	/** Liquid dumping: the contents go to the waste sink. */
	public void drain() {
		drained = true;
		filledMl = 0;
	}

	/** Bottle return: the empty container reaches the collector bin. */
	public void returnToCollector() {
		returned = true;
	}

	/** All three recycling stages done, so the container may be reused. */
	public boolean isRecovered() {
		return lidRemoved && drained && returned;
	}

	public String toString() {
		return "bottle " + id + " (" + sizeMl + "ml, " + pct[0] + "/" + pct[1] + ")";
	}
}
