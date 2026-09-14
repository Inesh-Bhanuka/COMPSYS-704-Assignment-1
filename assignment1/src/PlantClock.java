/**
 * The plant's tick counter, so every event carries a comparable timestamp.
 *
 * Advanced by the System Controller once per tick and read by everyone else,
 * so the whole plant agrees on a single monotonic clock.
 */
public class PlantClock {

	private static long tick = 0;

	public static long now() {
		return tick;
	}

	public static void advance() {
		tick++;
	}
}
