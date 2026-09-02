/**
 * FIFO of workpiece identities travelling on one conveyor belt.
 *
 * The belt is physically first-in-first-out, so the controller does not need
 * to know where on the belt a given bottle is - only the order they arrive
 * in. A bottle is pushed when it is injected at the load point and popped
 * when it is handed to the next machine.
 *
 * Held as a Java object at clock-domain scope, like TableModel, so that the
 * two conveyor reactions that share it see the same queue and the array
 * handling stays out of the generated state machine.
 */
public class BeltQueue {

	/**
	 * The SystemJ compiler gives each reaction its own local scope, so an
	 * object declared at clock-domain level is not visible inside the parallel
	 * reactions that need it. There is exactly one of these per system, so the
	 * reactions share it through this accessor instead.
	 */
	private static BeltQueue SHARED;

	public static BeltQueue shared() {
		if (SHARED == null) {
			SHARED = new BeltQueue();
		}
		return SHARED;
	}

	private final int[] q = new int[16];
	private int head = 0;
	private int tail = 0;
	private int count = 0;

	public void push(int id) {
		if (count == q.length) {
			System.out.println("[Q] Belt queue overflow, dropped bottle " + id + ".");
			return;
		}
		q[tail] = id;
		tail = (tail + 1) % q.length;
		count++;
	}

	/** Identity of the bottle that will arrive next, or 0 if the belt is empty. */
	public int peek() {
		return count == 0 ? 0 : q[head];
	}

	public int pop() {
		if (count == 0) {
			System.out.println("[Q] Belt queue underflow - a bottle arrived that was never injected.");
			return 0;
		}
		int v = q[head];
		head = (head + 1) % q.length;
		count--;
		return v;
	}

	public int size() {
		return count;
	}
}
