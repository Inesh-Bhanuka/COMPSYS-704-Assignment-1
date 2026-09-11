import java.io.Serializable;

/** Filler twin. Carries what it actually metered, not what it was asked for. */
public class FillerTwin extends MachineTwin implements Serializable {

	private static final long serialVersionUID = 1L;

	private double dispensedMass = 0.0;
	private int valveOpenTime = 0;

	public FillerTwin() {
		super(Machine.FILLER);
	}

	public double dispensedMass() {
		return dispensedMass;
	}

	public int valveOpenTime() {
		return valveOpenTime;
	}

	public void setDispensed(double ml, int ticks) {
		dispensedMass = ml;
		valveOpenTime = ticks;
	}
}
