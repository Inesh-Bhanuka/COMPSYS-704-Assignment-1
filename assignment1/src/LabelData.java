import java.io.Serializable;

/**
 * What gets printed on a bottle. Rendered from the twin, so every field is
 * evidence of what the plant did rather than a restatement of the order.
 */
public class LabelData implements Serializable {

	private static final long serialVersionUID = 1L;

	public final String product;
	public final String serial;
	public final long batchId;
	public final int sizeMl;
	public final int actualPctOne;
	public final int actualPctTwo;
	public final String quality;
	public final String code2d;

	public LabelData(WorkpieceTwin w) {
		this.product = w.productName;
		this.serial = w.serial;
		this.batchId = w.batchId;
		this.sizeMl = w.sizeMl;

		int one = 0;
		int two = 0;
		int seen = 0;
		for (WorkpieceEvent e : w.history()) {
			if (e.type == EventType.MEASURED && e.machine == Machine.FILLER) {
				int pct = (int) Math.round(e.measurement * 100.0 / w.sizeMl);
				if (seen == 0) {
					one = pct;
				} else if (seen == 1) {
					two = pct;
				}
				seen++;
			}
		}
		this.actualPctOne = one;
		this.actualPctTwo = two;
		this.quality = w.isRejected() ? w.defect() : "PASS";
		this.code2d = "[|" + w.serial + "|]";
	}

	public String toString() {
		return product + " " + serial + " batch " + batchId
				+ " mix " + actualPctOne + "/" + actualPctTwo
				+ " " + quality + " " + code2d;
	}
}
