import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * One thing that happened to one bottle. Immutable once created - the history
 * is append-only, so an event is never revised and can never be seen
 * half-applied.
 */
public class WorkpieceEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	public final long tick;
	public final LocalDateTime timestamp;
	public final Machine machine;
	public final EventType type;
	public final String cause;
	public final double measurement;

	public WorkpieceEvent(long tick, Machine machine, EventType type, String cause, double measurement) {
		this.tick = tick;
		this.timestamp = LocalDateTime.now();
		this.machine = machine;
		this.type = type;
		this.cause = cause;
		this.measurement = measurement;
	}

	public WorkpieceEvent(long tick, Machine machine, EventType type, String cause) {
		this(tick, machine, type, cause, 0.0);
	}

	public String toString() {
		String m = measurement == 0.0 ? "" : " " + measurement;
		return "t" + tick + " " + machine + " " + type + " (" + cause + ")" + m;
	}
}
