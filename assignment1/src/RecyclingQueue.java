/**
 * Bottles waiting inside the Recycling Station.
 *
 * The station recovers one bottle at a time - lid removal, then draining,
 * then return. bottleRejected is a rendezvous, so without a buffer the
 * System Controller's send only completes once a whole recovery cycle has
 * finished, and one defective bottle stalls the production line for its
 * duration. Intake parks the bottle here and releases the coordinator
 * immediately; the sequencer draws from the queue in arrival order.
 *
 * Capacity is finite on purpose. Full means intake stops receiving and the
 * back-pressure propagates upward on its own, which is the honest behaviour
 * for a station slower than the line. The buffer absorbs bursts, nothing more.
 *
 * In Java rather than in the reactions, like TableModel and BeltQueue:
 * SystemJ generates a separate control path for every branch enclosing a
 * rendezvous, so bookkeeping kept in a reaction multiplies the generated
 * state machine instead of adding to it.
 */
public class RecyclingQueue {

	/** How many rejected bottles may wait inside the station. */
	public static final int CAPACITY = 5;

	private static RecyclingQueue SHARED;

	/** Reactions get their own scope, so they share the queue through this. */
	public static RecyclingQueue shared() {
		if (SHARED == null) {
			SHARED = new RecyclingQueue();
		}
		return SHARED;
	}

	private final WorkpieceTwin[] q = new WorkpieceTwin[CAPACITY];
	private int head = 0;
	private int tail = 0;
	private int count = 0;

	/** Empty the station's waiting line. Used by a hard reset, nothing else. */
	public synchronized void clear() {
		for (int i = 0; i < q.length; i++) {
			q[i] = null;
		}
		head = 0;
		tail = 0;
		count = 0;
	}

	/** True while the station may accept another rejected bottle. */
	public synchronized boolean hasRoom() {
		return count < CAPACITY;
	}

	/** True while a bottle is waiting to be recovered. */
	public synchronized boolean hasWork() {
		return count > 0;
	}

	public synchronized int size() {
		return count;
	}

	/**
	 * The bottles waiting, in the order they will be recovered.
	 *
	 * A copy, for the operator display, which samples from the coordinator's
	 * clock domain - a different thread from the station's. Hence every
	 * method here is synchronised.
	 */
	public synchronized java.util.List<WorkpieceTwin> waiting() {
		java.util.List<WorkpieceTwin> out = new java.util.ArrayList<WorkpieceTwin>(count);
		for (int i = 0; i < count; i++) {
			out.add(q[(head + i) % CAPACITY]);
		}
		return out;
	}

	public synchronized void push(WorkpieceTwin w) {
		if (count == CAPACITY) {
			// Unreachable while callers check hasRoom() first, and loud rather
			// than silent so one that forgets is obvious.
			System.out.println("[RQ] Recycling queue full, dropped " + w + ".");
			return;
		}
		q[tail] = w;
		tail = (tail + 1) % CAPACITY;
		count++;
		System.out.println("[RQ] " + w + " queued for recycling (" + count + "/" + CAPACITY + " waiting).");
	}

	public synchronized WorkpieceTwin take() {
		if (count == 0) {
			return null;
		}
		WorkpieceTwin w = q[head];
		q[head] = null;
		head = (head + 1) % CAPACITY;
		count--;
		return w;
	}
}
