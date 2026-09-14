import com.systemj.ClockDomain;
import com.systemj.Container;
import com.systemj.SystemJRunner;
import com.systemj.TickFinisher;

import java.util.Vector;
import java.util.concurrent.locks.LockSupport;

/**
 * Holds every clock domain to a wall-clock rate, so the display is watchable.
 *
 * Clock domains free-run at around a thousand ticks a second. The reactions
 * are correct at that rate - none of them depend on how long a tick takes -
 * but a three tick diverter stroke is three milliseconds and the GUI repaints
 * ten times a second, so whole machine cycles pass between frames.
 *
 * The runtime ends each tick with runFinisher(), which is the intended hook
 * for work at a tick boundary: outside every reaction, outside every
 * rendezvous, after the tick's signals are resolved. A pacer goes on every
 * domain, each with its own deadline - the domains stay asynchronous and are
 * each slowed by the same factor, so every ordering the design relies on is
 * unchanged.
 *
 *   -Dabs.ticksPerSecond=60   the rate every domain is held to. Lower is
 *                             slower; 0 free-runs, which is what a regression
 *                             run wants. 60 puts the shortest actuator stroke
 *                             across a couple of display frames.
 */
public final class PlantPace implements TickFinisher {

	/** Ticks per second every clock domain is held to; 0 disables pacing. */
	public static final int TICKS_PER_SECOND =
			Integer.getInteger("abs.ticksPerSecond", 60).intValue();

	private static boolean installed = false;

	/**
	 * Attach a pacer to every clock domain. Safe to call more than once.
	 *
	 * The program is still being built while a reaction calls this, so the
	 * attachment waits on a daemon thread rather than blocking a tick.
	 */
	public static synchronized void install() {
		if (installed || TICKS_PER_SECOND <= 0) {
			return;
		}
		installed = true;
		Thread t = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 200; i++) {
					if (attach()) {
						return;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException stop) {
						return;
					}
				}
				System.out.println("[PACE] No clock domains found; the plant is running unpaced.");
			}
		}, "plant-pace-install");
		t.setDaemon(true);
		t.start();
	}

	private static boolean attach() {
		Container program = SystemJRunner.getProgram();
		if (program == null) {
			return false;
		}
		int n = attach(program);
		if (n == 0) {
			return false;
		}
		System.out.println("[PACE] " + n + " clock domains paced to "
				+ TICKS_PER_SECOND + " ticks/s.");
		return true;
	}

	private static int attach(Container c) {
		int n = 0;
		if (c instanceof ClockDomain) {
			((ClockDomain) c).setFinisher(new PlantPace());
			n++;
		}
		Vector children = c.getChildren();
		if (children != null) {
			for (int i = 0; i < children.size(); i++) {
				Object child = children.get(i);
				if (child instanceof Container) {
					n += attach((Container) child);
				}
			}
		}
		return n;
	}

	private final long period = 1000000000L / TICKS_PER_SECOND;
	private long deadline = 0;

	/** A domain behind its deadline paces from now rather than catching up in a burst. */
	public void finishTick(ClockDomain cd) {
		long now = System.nanoTime();
		if (deadline == 0) {
			deadline = now;
		}
		deadline += period;
		long wait = deadline - now;
		if (wait > 0) {
			LockSupport.parkNanos(wait);
		} else {
			// Behind schedule: pace from here rather than catching up in a burst.
			deadline = now;
		}
	}
}
