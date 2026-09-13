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

	private final WorkpieceTwin[] q = new WorkpieceTwin[16];
	private int head = 0;
	private int tail = 0;
	private int count = 0;

	/** Sweep the belt. Used by a hard reset, nothing else. */
	public void clear() {
		for (int i = 0; i < q.length; i++) {
			q[i] = null;
		}
		head = 0;
		tail = 0;
		count = 0;
	}

	/**
	 * Whether the infeed can take another bottle.
	 *
	 * The coordinator asks before it books one. It did not used to, and push()
	 * below simply dropped the workpiece when the queue was full: the bottle
	 * went onto the belt physically, its twin was never queued, and it stayed
	 * in the registry as LOADED for the rest of the run. An order that lost
	 * five bottles that way could never reach its target, and the line looked
	 * like it had stalled when in fact it was waiting for bottles that no
	 * longer existed anywhere but the registry.
	 *
	 * The belt is the slowest thing between the loader and the table, so this
	 * is also the right place for the line's back-pressure: the coordinator
	 * stops booking, the loader stops picking, and admission resumes on its
	 * own as the table draws bottles off.
	 */
	public boolean hasRoom() {
		return count + COMMITTED <= q.length;
	}

	/**
	 * Slots held back for bottles the coordinator has committed to but which
	 * are not on the belt yet.
	 *
	 * There are two: one in the loader's hands, and one the coordinator has
	 * just booked and is handing over. Both will push before anything else
	 * can, so the queue has to have been holding room for them all along.
	 *
	 * Checking count < length alone is not enough, and the log said so: the
	 * coordinator booked a bottle while the queue stood at 15 of 16, the
	 * bottle already in the loader took the last slot, and the one just
	 * booked had nowhere to go.
	 */
	private static final int COMMITTED = 2;

	public void push(WorkpieceTwin w) {
		if (count == q.length) {
			// Unreachable while the coordinator checks hasRoom() first. Kept
			// loud rather than silent so a future caller that forgets is
			// noisy instead of quietly losing a bottle.
			System.out.println("[Q] Belt queue full, dropped " + w + ".");
			return;
		}
		q[tail] = w;
		tail = (tail + 1) % q.length;
		count++;
	}

	public WorkpieceTwin peek() {
		return count == 0 ? null : q[head];
	}

	public WorkpieceTwin pop() {
		if (count == 0) {
			System.out.println("[Q] A bottle arrived that was never injected.");
			return null;
		}
		WorkpieceTwin w = q[head];
		head = (head + 1) % q.length;
		count--;
		return w;
	}

	public int size() {
		return count;
	}
}
