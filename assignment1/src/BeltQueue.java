/**
 * Workpieces travelling on the infeed belt, in arrival order.
 *
 * The belt is physically FIFO, so the controller only needs the order, not
 * where on the belt anything is.
 */
public class BeltQueue {

	private static BeltQueue SHARED;

	/** Reactions get their own scope, so they share the queue through this. */
	public static BeltQueue shared() {
		if (SHARED == null) {
			SHARED = new BeltQueue();
		}
		return SHARED;
	}

	private final Workpiece[] q = new Workpiece[16];
	private int head = 0;
	private int tail = 0;
	private int count = 0;

	public void push(Workpiece w) {
		if (count == q.length) {
			System.out.println("[Q] Belt queue full, dropped " + w + ".");
			return;
		}
		q[tail] = w;
		tail = (tail + 1) % q.length;
		count++;
	}

	public Workpiece peek() {
		return count == 0 ? null : q[head];
	}

	public Workpiece pop() {
		if (count == 0) {
			System.out.println("[Q] A bottle arrived that was never injected.");
			return null;
		}
		Workpiece w = q[head];
		head = (head + 1) % q.length;
		count--;
		return w;
	}

	public int size() {
		return count;
	}
}
