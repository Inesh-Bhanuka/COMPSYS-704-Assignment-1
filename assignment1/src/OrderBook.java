/**
 * The order the POS stub issues, standing in for a real customer order.
 *
 * Two line items, so a run exercises both bottle sizes and the batch
 * structure the twin is organised around. Replace this whole class when the
 * real POS lands - nothing else refers to it.
 */
public class OrderBook {

	private static PurchaseOrder ORDER;
	private static WorkpieceTwin[] BOTTLES;

	private static void build() {
		if (ORDER != null) {
			return;
		}
		ORDER = new PurchaseOrder(1, "orders@advantech.example");

		Batch small = new Batch(1, new Recipe(50, 50, 5), WorkpieceTwin.SMALL, 2);
		Batch large = new Batch(2, new Recipe(25, 75, 5), WorkpieceTwin.LARGE, 2);
		ORDER.add(small);
		ORDER.add(large);

		BOTTLES = new WorkpieceTwin[4];
		BOTTLES[0] = admit(1, small);
		BOTTLES[1] = admit(2, small);
		BOTTLES[2] = admit(3, large);
		BOTTLES[3] = admit(4, large);

		// Fault injection for validation. Bottle 2 arrives with a lid already
		// fitted and bottle 3 is short-filled; each is detected by the station
		// that would encounter it, not announced here. Comment these two lines
		// out for a clean run.
		BOTTLES[1].armFault("lid-fitted");
		BOTTLES[2].armFault("misfill");

		ORDER.start();
	}

	private static WorkpieceTwin admit(long id, Batch b) {
		WorkpieceTwin w = new WorkpieceTwin(id, b.id, b.sizeMl, b.recipe);
		b.add(w);
		return w;
	}

	public static PurchaseOrder purchaseOrder() {
		build();
		return ORDER;
	}

	public static int count() {
		build();
		return BOTTLES.length;
	}

	/** Bottle i of the order, numbered from 0. */
	public static WorkpieceTwin order(int i) {
		build();
		return BOTTLES[i];
	}
}
