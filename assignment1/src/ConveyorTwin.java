import java.io.Serializable;

/** Conveyor twin. */
public class ConveyorTwin extends MachineTwin implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean moving = false;

	public ConveyorTwin() {
		super(Machine.CONVEYOR);
	}

	public boolean moving() {
		return moving;
	}

	public void setMoving(boolean b) {
		moving = b;
	}
}
