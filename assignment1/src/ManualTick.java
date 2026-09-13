import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * One operator tick: the actuator signals to assert, together, once.
 *
 * The sequence number is what makes it exactly once. The panel resends the
 * same tick several times because a single TCP emit can be missed, and the
 * plant fires the one whose number it has not seen before, so a resend is
 * harmless and a loss is not.
 */
public final class ManualTick implements Serializable {

	private static final long serialVersionUID = 1L;

	public final long sequence;
	public final Set<String> signals;

	public ManualTick(long sequence, Set<String> signals) {
		this.sequence = sequence;
		this.signals = Collections.unmodifiableSet(new HashSet<String>(signals));
	}

	public String toString() {
		return "tick " + sequence + " " + signals;
	}
}
