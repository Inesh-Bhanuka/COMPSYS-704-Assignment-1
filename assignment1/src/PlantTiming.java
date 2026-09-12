/**
 * How many ticks a piece of machine motion takes.
 *
 * Every plant models its actuators with a tick counter - the diverter takes
 * STROKE ticks to cross between end stops, the table takes ROT ticks to turn
 * sixty degrees, the dumper takes DRAIN ticks to empty a bottle. Those numbers
 * were chosen small so a test run finishes quickly, which is the wrong
 * trade-off for a demonstration: at a few ticks each, the machines are a blur
 * and the only thing an observer can follow is the log.
 *
 * Rather than editing a dozen plants every time the demo needs to be slower or
 * faster, each plant asks for its motion times through here and one scale
 * factor moves all of them together. That keeps the relative timing of the
 * machines fixed - the table is still slower than the capper by the same
 * ratio - so the line's behaviour, including which stage is the bottleneck,
 * does not change with the setting.
 *
 *   -Dabs.timeScale=5    multiplier on every machine's motion time.
 *                        1 restores the original, quick-running numbers.
 *
 * This is deliberately separate from PlantPace, which sets how long a tick
 * lasts in wall-clock time. Pacing slows everything including the
 * cross-domain rendezvous that carry workpieces between machines; scaling
 * changes only how long the machines themselves take, which is what makes an
 * individual operation legible rather than instantaneous. A watchable demo
 * wants both.
 */
public final class PlantTiming {

	/** Multiplier on machine motion times. */
	public static final double SCALE = scale();

	private static double scale() {
		String s = System.getProperty("abs.timeScale");
		if (s == null) {
			return 5.0;
		}
		try {
			double v = Double.parseDouble(s.trim());
			return v > 0 ? v : 1.0;
		} catch (NumberFormatException bad) {
			return 5.0;
		}
	}

	/** A duration in ticks, scaled. Never less than one tick. */
	public static int ticks(int base) {
		int t = (int) Math.round(base * SCALE);
		return t < 1 ? 1 : t;
	}

	/**
	 * A per-tick rate, scaled the other way: pouring 20ml a tick at scale 5
	 * becomes 4ml a tick, so the same bottle takes five times as long to fill.
	 */
	public static int rate(int base) {
		int r = (int) Math.round(base / SCALE);
		return r < 1 ? 1 : r;
	}

	private PlantTiming() {
	}
}
