import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The twin of one bottle: its identity, its recipe, and everything that has
 * happened to it.
 *
 * The history is the record. Lifecycle state, station, fill level and whether
 * it is lidded are all folded out of the events rather than kept beside them,
 * so the two can never disagree - which is the usual way a model that stores
 * both goes wrong. Every event carries the tick it happened on, so any past
 * state can be reconstructed by replaying up to that point.
 *
 * Ownership travels with the bottle: exactly one clock domain holds a twin at
 * a time, and it hands it on by rendezvous, so appends never race.
 */
public class WorkpieceTwin implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Bottle sizes the line supports, in millilitres. */
	public static final int SMALL = 100;
	public static final int LARGE = 200;

	public final long id;
	public final String serial;
	public final long batchId;
	public final String productName;
	public final int sizeMl;
	public final Recipe recipe;

	private final List<WorkpieceEvent> history = new ArrayList<WorkpieceEvent>();

	// Folded from the history on every append, never assigned anywhere else.
	private WorkpieceStatus status = WorkpieceStatus.LOADED;
	private Machine station = Machine.NONE;

	public WorkpieceTwin(long id, long batchId, int sizeMl, Recipe recipe) {
		this(id, batchId, "Advantech " + sizeMl + "ml", sizeMl, recipe);
	}

	public WorkpieceTwin(long id, long batchId, String productName, int sizeMl, Recipe recipe) {
		this.id = id;
		this.productName = productName;
		this.batchId = batchId;
		this.sizeMl = sizeMl;
		this.recipe = recipe;
		this.serial = String.format("ABS-%03d-%04d", batchId, id);
	}

	// ---- History ----

	public void record(long tick, Machine machine, EventType type, String cause) {
		record(new WorkpieceEvent(tick, machine, type, cause));
	}

	public void record(long tick, Machine machine, EventType type, String cause, double measurement) {
		record(new WorkpieceEvent(tick, machine, type, cause, measurement));
	}

	public void record(WorkpieceEvent e) {
		history.add(e);
		fold(e);
	}

	public List<WorkpieceEvent> history() {
		return java.util.Collections.unmodifiableList(history);
	}

	public WorkpieceEvent lastEvent() {
		return history.isEmpty() ? null : history.get(history.size() - 1);
	}

	// ---- Fault injection ----
	//
	// An armed fault is not part of the record. It is a condition the plant
	// will exhibit, which a station then has to detect for itself - so the
	// history shows the station that caught it, not the fact that it was
	// planted.
	private String armedFault;

	public void armFault(String kind) {
		armedFault = kind;
	}

	/** True once, at the station that catches it. */
	public boolean catchFault(String kind) {
		if (kind.equals(armedFault)) {
			armedFault = null;
			return true;
		}
		return false;
	}

	// ---- What the machines report ----
	//
	// Each of these is an event, not a flag. A machine hands the twin on by
	// rendezvous, so exactly one clock domain is appending at any instant.

	/** A filler metered ml of the next liquid in. */
	public void dispensed(int ml) {
		record(PlantClock.now(), Machine.FILLER, EventType.MEASURED, "liquid " + nextLiquidName(), ml);
	}

	/**
	 * Was the last fill within the recipe's tolerance? The filler checks its
	 * own work, so a short fill is caught where it happens.
	 */
	public boolean lastFillInTolerance(int asked) {
		WorkpieceEvent e = lastEvent();
		if (e == null || e.type != EventType.MEASURED) {
			return true;
		}
		int slack = sizeMl * recipe.tolerance / 100;
		return Math.abs(e.measurement - asked) <= slack;
	}

	public void lid() {
		record(PlantClock.now(), Machine.LID_LOADER, EventType.COMPLETED, "lid placed");
	}

	public void cap() {
		record(PlantClock.now(), Machine.LID_CAPPER, EventType.COMPLETED, "cap seated");
	}

	/** A station flags a fault at the station that detected it, not where it is acted on. */
	public void reject(Machine at, String reason) {
		record(PlantClock.now(), at, EventType.FLAGGED, reason);
	}

	public void removeLid() {
		record(PlantClock.now(), Machine.RECYCLING, EventType.COMPLETED, "lid removed");
	}

	public void drain() {
		record(PlantClock.now(), Machine.RECYCLING, EventType.COMPLETED, "drained");
	}

	public void returnToCollector() {
		record(PlantClock.now(), Machine.RECYCLING, EventType.COMPLETED, "returned");
	}

	public void arrived(Machine at) {
		record(PlantClock.now(), at, EventType.ARRIVED, "arrived");
	}

	public void started(Machine at, String what) {
		record(PlantClock.now(), at, EventType.STARTED, what);
	}

	public void completed(Machine at, String what) {
		record(PlantClock.now(), at, EventType.COMPLETED, what);
	}

	public void seal() {
		record(PlantClock.now(), Machine.NONE, EventType.SEALED, "left the line");
	}

	// ---- Derived state ----

	public WorkpieceStatus status() {
		return status;
	}

	public Machine station() {
		return station;
	}

	/** Sum of what the fillers metered in, less anything the dumper took out. */
	public int filledMl() {
		int ml = 0;
		for (WorkpieceEvent e : history) {
			if (e.type == EventType.MEASURED && e.machine == Machine.FILLER) {
				ml += (int) e.measurement;
			}
			if (e.type == EventType.COMPLETED && e.machine == Machine.RECYCLING
					&& "drained".equals(e.cause)) {
				ml = 0;
			}
		}
		return ml;
	}

	/** How many fills have been recorded, which is also which liquid is next. */
	public int fillsDone() {
		int n = 0;
		for (WorkpieceEvent e : history) {
			if (e.type == EventType.MEASURED && e.machine == Machine.FILLER) {
				n++;
			}
		}
		return n;
	}

	/** 0 = liquid A, 1 = liquid B, -1 = nothing left to dispense. */
	public int nextLiquid() {
		int n = fillsDone();
		return n < recipe.liquids() ? n : -1;
	}

	public String nextLiquidName() {
		return nextLiquid() == 0 ? "A" : "B";
	}

	/** Millilitres the next liquid calls for. */
	public int nextVolumeMl() {
		int n = nextLiquid();
		if (n < 0) return 0;
		// Give the rounding remainder to Liquid 2 for an exactly full bottle.
		return n == 1 && recipe.liquidOne + recipe.liquidTwo == 100
				? sizeMl - sizeMl * recipe.liquidOne / 100 : sizeMl * recipe.pct(n) / 100;
	}

	/** True if that volume still fits. The fillers check before opening a valve. */
	public boolean fits(int ml) {
		return filledMl() + ml <= sizeMl;
	}

	public boolean isLidded() {
		return lastAt(Machine.LID_LOADER, EventType.COMPLETED) > lastRemoval();
	}

	public boolean isCapped() {
		return lastAt(Machine.LID_CAPPER, EventType.COMPLETED) > lastRemoval();
	}

	public boolean isSealed() {
		return isLidded() && isCapped();
	}

	/** Recovered means stripped back to an empty, unsealed container. */
	public boolean isRecovered() {
		return status == WorkpieceStatus.RECOVERED;
	}

	public boolean isLabelled() {
		return lastAt(Machine.LABELLER, EventType.COMPLETED) >= 0;
	}

	// ---- Quality ----

	public boolean isRejected() {
		return defect() != null;
	}

	/** Why it was flagged, and by which station, or null if it is clean. */
	public String defect() {
		for (int i = history.size() - 1; i >= 0; i--) {
			WorkpieceEvent e = history.get(i);
			if (e.type == EventType.FLAGGED) {
				return e.cause + " at " + e.machine;
			}
		}
		return null;
	}

	/** Has every fill the recipe asked for been recorded? */
	public boolean fillComplete() {
		return fillsDone() >= recipe.liquids();
	}

	/**
	 * The labeller's refusal test. A label is evidence of what the plant did,
	 * so it can only be printed against a history that justifies it.
	 */
	public String labelRefusalReason() {
		if (isRejected()) {
			return "quality flag unresolved: " + defect();
		}
		if (!fillComplete()) {
			return "only " + fillsDone() + " of " + recipe.liquids() + " fills recorded";
		}
		if (status != WorkpieceStatus.CAPPED) {
			return "state is " + status + ", expected CAPPED";
		}
		return null;
	}

	// ---- Internals ----

	private int lastAt(Machine m, EventType t) {
		for (int i = history.size() - 1; i >= 0; i--) {
			WorkpieceEvent e = history.get(i);
			if (e.machine == m && e.type == t) {
				return i;
			}
		}
		return -1;
	}

	private int lastRemoval() {
		for (int i = history.size() - 1; i >= 0; i--) {
			WorkpieceEvent e = history.get(i);
			if (e.machine == Machine.RECYCLING && "lid removed".equals(e.cause)) {
				return i;
			}
		}
		return -1;
	}

	/** The projection. One event in, one state out. */
	private void fold(WorkpieceEvent e) {
		if (e.machine != Machine.NONE && e.type != EventType.SEALED) {
			station = e.machine;
		}
		switch (e.type) {
		case FLAGGED:
			status = WorkpieceStatus.REJECTED;
			break;
		case STARTED:
			if (e.machine == Machine.FILLER) {
				status = WorkpieceStatus.FILLING;
			} else if (e.machine == Machine.LID_CAPPER) {
				status = WorkpieceStatus.CAPPING;
			} else if (e.machine == Machine.LABELLER) {
				status = WorkpieceStatus.LABELLING;
			} else if (e.machine == Machine.RECYCLING) {
				status = WorkpieceStatus.RECYCLING;
			}
			break;
		case COMPLETED:
			if (e.machine == Machine.FILLER && fillComplete()) {
				status = WorkpieceStatus.FILLED;
			} else if (e.machine == Machine.LID_CAPPER) {
				status = WorkpieceStatus.CAPPED;
			} else if (e.machine == Machine.LABELLER) {
				status = WorkpieceStatus.LABELLED;
			} else if (e.machine == Machine.RECYCLING && "returned".equals(e.cause)) {
				status = WorkpieceStatus.RECOVERED;
			}
			break;
		case SEALED:
			status = status == WorkpieceStatus.RECOVERED ? status : WorkpieceStatus.DONE;
			break;
		default:
			break;
		}
	}

	public String toString() {
		return "bottle " + id + " (" + sizeMl + "ml, " + recipe + ")";
	}
}
