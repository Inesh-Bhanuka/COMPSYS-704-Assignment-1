/**
 * The plant's tick counter, so every event carries a comparable timestamp.
 *
 * Advanced by the System Controller once per tick and read by everyone else.
 * On a distributed deployment this becomes a tick channel from the
 * coordinator rather than a shared counter, but the property the twin needs -
 * a single monotonic clock the whole plant agrees on - is the same.
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
