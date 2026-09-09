import java.io.Serializable;

/** Bottle loader twin. */
public class LoaderTwin extends MachineTwin implements Serializable {

	private static final long serialVersionUID = 1L;

	private int bottlesRemaining = 20;

	public LoaderTwin() {
		super(Machine.LOADER);
	}

	public int bottlesRemaining() {
		return bottlesRemaining;
	}

	public void setBottlesRemaining(int n) {
		bottlesRemaining = n;
	}
}
