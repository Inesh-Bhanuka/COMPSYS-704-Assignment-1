import java.io.Serializable;

/** Capper twin. */
public class LidCapperTwin extends MachineTwin implements Serializable {

	private static final long serialVersionUID = 1L;

	private int appliedTurns = 0;

	public LidCapperTwin() {
		super(Machine.LID_CAPPER);
	}

	public int appliedTurns() {
		return appliedTurns;
	}

	public void setAppliedTurns(int n) {
		appliedTurns = n;
	}
}
