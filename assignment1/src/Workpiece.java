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

	public String toString() {
		return "bottle " + id + " (" + sizeMl + "ml, " + pct[0] + "/" + pct[1] + ")";
	}
}
