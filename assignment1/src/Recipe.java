import java.io.Serializable;

/** What a bottle should contain, as percentages of its capacity. */
public class Recipe implements Serializable {

	private static final long serialVersionUID = 1L;

	public final int liquidOne;
	public final int liquidTwo;
	public final int tolerance;

	public Recipe(int liquidOne, int liquidTwo, int tolerance) {
		this.liquidOne = liquidOne;
		this.liquidTwo = liquidTwo;
		this.tolerance = tolerance;
	}

	/** Percentage called for by liquid index, 0 or 1. */
	public int pct(int liquid) {
		return liquid == 0 ? liquidOne : liquidTwo;
	}

	public int liquids() {
		return 2;
	}

	/** A recipe asking for more than a full bottle can never be dispensed. */
	public boolean isValid() {
		return liquidOne >= 0 && liquidTwo >= 0 && liquidOne + liquidTwo <= 100;
	}

	public String toString() {
		return liquidOne + "/" + liquidTwo;
	}
}
