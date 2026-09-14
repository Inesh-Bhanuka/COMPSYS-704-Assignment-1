/**
 * How many ticks a piece of machine motion takes.
 *
 * Each plant models its actuators with a tick counter - STROKE ticks for the
 * diverter, ROT ticks for a sixty degree turn, DRAIN ticks to empty a bottle.
 * They ask for those numbers through here so one factor moves all of them
 * together, which keeps their ratios fixed: the line's behaviour, including
 * which stage is the bottleneck, does not change with the setting.
 *
 *   -Dabs.timeScale=5    multiplier on every machine's motion time.
 *                        1 gives the original, quick-running numbers.
 *
 * Separate from PlantPace, which sets how long a tick lasts. Pacing slows
 * everything including the cross-domain rendezvous between machines; scaling
 * changes only the machines, which is what makes one operation legible rather
 * than instantaneous. A watchable demo wants both.
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

	/** A per-tick rate, scaled the other way: 20ml a tick at scale 5 is 4ml a tick. */
	public static int rate(int base) {
		int r = (int) Math.round(base / SCALE);
		return r < 1 ? 1 : r;
	}

	private PlantTiming() {
	}
}
