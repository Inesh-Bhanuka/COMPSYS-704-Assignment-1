/**
 * Bottles waiting inside the Recycling Station.
 *
 * The station recovers one bottle at a time - lid removal, then draining,
 * then return - because that is what the interim report specifies and what
 * the single-bottle indexing conveyor physically allows. The problem with
 * doing only that is upstream: bottleRejected is a rendezvous, so while a
 * recovery was in progress the System Controller's send simply did not
 * complete, and the whole production line stalled behind one defective
 * bottle for the length of a full recycling cycle.
 *
 * This queue is the buffer that removes the stall without changing the
 * process. The intake reaction accepts a rejected bottle as soon as there is
 * room and parks it here; the System Controller is released at that moment
 * and carries on. The sequencer then takes bottles out one at a time, in
 * arrival order, and recovers them exactly as before.
 *
 * Capacity is finite on purpose. When five bottles are already waiting the
 * intake reaction stops receiving, the coordinator's send stops completing,
 * and the back-pressure propagates upward on its own - which is the correct
 * behaviour for a station whose recovery rate really is lower than the
 * line's reject rate. The buffer absorbs bursts; it does not pretend the
 * station is infinitely fast.
 *
 * It lives in Java rather than in the reactions for the same reason
 * TableModel and BeltQueue do: SystemJ generates a separate control path for
 * every branch that encloses a rendezvous, so bookkeeping kept in the
 * reaction multiplies the generated state machine instead of adding to it.
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

	/** True while the station may accept another rejected bottle. */
	public boolean hasRoom() {
		return count < CAPACITY;
	}

	/** True while a bottle is waiting to be recovered. */
	public boolean hasWork() {
		return count > 0;
	}

	public int size() {
		return count;
	}

	public void push(WorkpieceTwin w) {
		if (count == CAPACITY) {
			// Unreachable while the intake reaction checks hasRoom() first;
			// kept so a future caller that forgets is noisy rather than
			// silently losing a bottle.
			System.out.println("[RQ] Recycling queue full, dropped " + w + ".");
			return;
		}
		q[tail] = w;
		tail = (tail + 1) % CAPACITY;
		count++;
		System.out.println("[RQ] " + w + " queued for recycling (" + count + "/" + CAPACITY + " waiting).");
	}

	public WorkpieceTwin take() {
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
