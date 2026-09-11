/**
 * The outcome of one recycling transaction.
 *
 * The Recycling Station Controller drives five subsystems in sequence and has
 * to fold their status codes into two conclusions: may this bottle be
 * reported as recovered, and may the station take another one. Doing that
 * with local flags puts a conditional between every pair of rendezvous, and
 * SystemJ generates a separate control path for each - the sequencer's
 * runClockDomain method then exceeds the JVM's 64 KB limit, exactly as the
 * rotary table's occupancy handling did before it moved into TableModel.
 *
 * So the accumulation lives here instead, as plain Java, and the reaction
 * keeps a single straight line of sends and receives.
 */
public class RecyclingRecord {

	/** Reactions get their own scope, so they share the record through this. */
	private static RecyclingRecord SHARED;

	public static RecyclingRecord shared() {
		if (SHARED == null) {
			SHARED = new RecyclingRecord();
		}
		return SHARED;
	}

	/** Status codes a subsystem controller may report to the RSC. */
	public static final int OK = 0;
	public static final int JAMMED = 1;
	public static final int BLOCKED = 2;
	public static final int WARN = 3;

	/** States the RSC holds out to the System Controller. */
	public static final int IDLE = 0;
	public static final int BUSY = 1;
	public static final int FAULT = 2;
	public static final int WARNING = 3;

	private WorkpieceTwin bottle;
	private boolean jammed = false;
	private boolean blocked = false;
	private boolean warning = false;

	/** Start a transaction for one rejected bottle. */
	public void begin(WorkpieceTwin w) {
		bottle = w;
		jammed = false;
		blocked = false;
		warning = false;
		System.out.println("[RSC] " + w + " accepted for recycling: " + w.defect() + ".");
	}

	/** Fold one subsystem's status into the transaction's outcome. */
	public void record(int status) {
		if (status == JAMMED) {
			jammed = true;
		}
		if (status == BLOCKED) {
			blocked = true;
		}
		if (status == WARN) {
			warning = true;
		}
	}

	/**
	 * A jammed diverter is the one failure that leaves nothing on the
	 * recycling conveyor, so it is the only one the sequencer must react to
	 * mid-transaction.
	 */
	public boolean jammed() {
		return jammed;
	}

	/**
	 * A bin or tank that has reached capacity. The bottle in progress is
	 * always finished first; what is suspended is the admission of the next
	 * one, which is what keeps the station at a clean boundary.
	 */
	public boolean suspended() {
		return blocked;
	}

	/** The level held out on RecyclingSystemStatus between transactions. */
	public int restingState() {
		if (blocked || jammed) {
			return FAULT;
		}
		if (warning) {
			return WARNING;
		}
		return IDLE;
	}

	/** Every stage done: the container is empty, unsealed and in the bin. */
	public void reportRecovered() {
		System.out.println("[RSC] " + bottle + " recovered - "
				+ (bottle.isRecovered() ? "empty, unsealed, container returned" : "INCOMPLETE")
				+ ".");
	}

	public void reportJam() {
		System.out.println("[RSC] Splitter jammed on " + bottle + "; station halted.");
	}

	public void reportSuspension() {
		System.out.println("[RSC] Station suspended after " + bottle
				+ "; a bin or the waste tank needs servicing.");
	}
}
