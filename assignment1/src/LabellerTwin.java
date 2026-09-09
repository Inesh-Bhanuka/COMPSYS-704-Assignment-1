import java.io.Serializable;

/** Labeller twin. Consumables and the last serial it printed. */
public class LabellerTwin extends MachineTwin implements Serializable {

	private static final long serialVersionUID = 1L;

	private int labelStock = 0;
	private int glueLevel = 0;
	private String lastSerial = "";

	public LabellerTwin() {
		super(Machine.LABELLER);
	}

	public int labelStock() {
		return labelStock;
	}

	public int glueLevel() {
		return glueLevel;
	}

	public String lastSerial() {
		return lastSerial;
	}

	public void setStock(int labels, int glue) {
		labelStock = labels;
		glueLevel = glue;
	}

	public void setLastSerial(String s) {
		lastSerial = s;
	}
}
