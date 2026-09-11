import java.io.Serializable;

/** Rotary index table twin. */
public class RotaryTableTwin extends MachineTwin implements Serializable {

	private static final long serialVersionUID = 1L;

	private int position = 1;
	private boolean rotating = false;

	public RotaryTableTwin() {
		super(Machine.ROTARY_TABLE);
	}

	public int position() {
		return position;
	}

	public boolean rotating() {
		return rotating;
	}

	public void setPosition(int p) {
		position = p;
	}

	public void setRotating(boolean b) {
		rotating = b;
	}
}
