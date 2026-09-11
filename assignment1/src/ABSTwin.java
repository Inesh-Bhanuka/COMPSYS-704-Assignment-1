import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The whole plant as one object: every machine twin, every workpiece in
 * flight, and a few roll-ups over them.
 *
 * Assembled by the System Controller and published complete on every tick, so
 * a consumer that misses a transmission is only ever one tick stale rather
 * than out of step. That is why this is a snapshot and not a differential
 * update - a dropped connection degrades the display without damaging the
 * record.
 */
public class ABSTwin implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Map<Machine, MachineTwin> machines = new LinkedHashMap<Machine, MachineTwin>();
	private final List<WorkpieceTwin> workpieces = new ArrayList<WorkpieceTwin>();

	private LineMode mode = LineMode.AUTO;
	private long tick = 0;

	/** A machine twin arriving from its controller replaces the one held here. */
	public void put(MachineTwin t) {
		if (t != null) {
			machines.put(t.machine, t);
		}
	}

	public MachineTwin machine(Machine m) {
		return machines.get(m);
	}

	public List<MachineTwin> machines() {
		return new ArrayList<MachineTwin>(machines.values());
	}

	public void track(WorkpieceTwin w) {
		if (w != null && !workpieces.contains(w)) {
			workpieces.add(w);
		}
	}

	public List<WorkpieceTwin> workpieces() {
		return java.util.Collections.unmodifiableList(workpieces);
	}

	public LineMode mode() {
		return mode;
	}

	public void setMode(LineMode m) {
		mode = m;
	}

	public long tick() {
		return tick;
	}

	public void setTick(long t) {
		tick = t;
	}

	/** Bottles admitted but not yet finished one way or the other. */
	public int wip() {
		int n = 0;
		for (WorkpieceTwin w : workpieces) {
			WorkpieceStatus s = w.status();
			if (s != WorkpieceStatus.DONE && s != WorkpieceStatus.RECOVERED && s != WorkpieceStatus.SCRAP) {
				n++;
			}
		}
		return n;
	}

	public int completed() {
		int n = 0;
		for (WorkpieceTwin w : workpieces) {
			if (w.status() == WorkpieceStatus.DONE) {
				n++;
			}
		}
		return n;
	}

	/** Finished bottles per thousand ticks. Cheap, and enough for the panel. */
	public double throughput() {
		return tick == 0 ? 0.0 : completed() * 1000.0 / tick;
	}

	public String summary() {
		StringBuilder sb = new StringBuilder();
		sb.append("t").append(tick).append(" ").append(mode)
				.append(" wip=").append(wip()).append(" done=").append(completed());
		for (MachineTwin t : machines.values()) {
			sb.append("  ").append(t.machine).append(":").append(t.status());
		}
		return sb.toString();
	}
}
