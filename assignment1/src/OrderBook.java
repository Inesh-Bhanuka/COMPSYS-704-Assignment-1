/**
 * The orders the POS stub issues, standing in for real customer orders.
 *
 * Each line is one bottle: size, then the percentage of liquid A and B.
 * Percentages have to sum to 100 or less - the fillers refuse anything that
 * would overflow, so a bad line here shows up as a refusal rather than a mess.
 */
public class OrderBook {

	private static final int[] SIZE = { Workpiece.SMALL, Workpiece.LARGE, Workpiece.SMALL, Workpiece.LARGE };
	private static final int[] PCT_A = { 50, 25, 100, 60 };
	private static final int[] PCT_B = { 50, 75, 0, 40 };

	public static int count() {
		return SIZE.length;
	}

	/** Order i, numbered from 0. Bottle ids start at 1. */
	public static Workpiece order(int i) {
		return new Workpiece(i + 1, SIZE[i], PCT_A[i], PCT_B[i]);
	}
}
