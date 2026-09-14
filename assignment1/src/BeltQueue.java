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
	 * Whether the infeed can take another bottle. The coordinator asks before
	 * it books one, because push() below can only drop a workpiece it has no
	 * room for - and a dropped twin stays in the registry as LOADED forever,
	 * leaving the order short of bottles that exist nowhere else.
	 *
	 * The belt is the slowest thing between the loader and the table, so this
	 * is where the line's back-pressure belongs: admission stops and resumes
	 * on its own as the table draws bottles off.
	 */
	public boolean hasRoom() {
		return count + COMMITTED <= q.length;
	}

	/**
	 * Slots held back for bottles already committed to but not yet on the
	 * belt: one in the loader's hands, one just booked and being handed over.
	 * Both will push before anything else can, so the room has to be reserved
	 * for them - count < length alone lets the loader take the last slot and
	 * strands the bottle behind it.
	 */
	private static final int COMMITTED = 2;

	public void push(WorkpieceTwin w) {
		if (count == q.length) {
			// Unreachable while callers check hasRoom() first, and loud rather
			// than silent so one that forgets is obvious.
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
