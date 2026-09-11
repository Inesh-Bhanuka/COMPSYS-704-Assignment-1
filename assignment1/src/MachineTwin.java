import java.io.Serializable;

/**
 * A machine's own summary of itself: what it is doing, what it was last told,
 * and what it last confirmed.
 *
 * Deliberately not a mirror of the raw signal set. Publishing the signals
 * would make every consumer reimplement the controller's reading of its own
 * sensors, and would tie the model to a machine's internals. This is the
 * interpretation, so a machine can be rebuilt without any consumer changing.
 *
 * Written only by the controller of the machine it mirrors. Everyone else
 * holds it read-only.
 */
public abstract class MachineTwin implements Serializable {

	private static final long serialVersionUID = 1L;

	public final Machine machine;

	private MachineStatus status = MachineStatus.IDLE;
	private String lastCommand = "";
	private String lastConfirmation = "";
	private long tickChanged = 0;

	protected MachineTwin(Machine machine) {
		this.machine = machine;
	}

	public MachineStatus status() {
		return status;
	}

	public String lastCommand() {
		return lastCommand;
	}

	public String lastConfirmation() {
		return lastConfirmation;
	}

	public long tickChanged() {
		return tickChanged;
	}

	/** Returns true when something actually changed, so callers can emit only then. */
	public boolean update(long tick, MachineStatus s, String command, String confirmation) {
		boolean changed = s != status
				|| !command.equals(lastCommand)
				|| !confirmation.equals(lastConfirmation);
		if (changed) {
			status = s;
			lastCommand = command;
			lastConfirmation = confirmation;
			tickChanged = tick;
		}
		return changed;
	}

	public String toString() {
		return machine + "[" + status + " cmd=" + lastCommand + " ack=" + lastConfirmation + "]";
	}
}
