import java.io.Serializable;

/** Lid loader twin. */
public class LidLoaderTwin extends MachineTwin implements Serializable {

	private static final long serialVersionUID = 1L;

	private int lidsRemaining = 3;

	public LidLoaderTwin() {
		super(Machine.LID_LOADER);
	}

	public int lidsRemaining() {
		return lidsRemaining;
	}

	public void setLidsRemaining(int n) {
		lidsRemaining = n;
	}
}
