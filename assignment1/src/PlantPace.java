import com.systemj.ClockDomain;
import com.systemj.Container;
import com.systemj.SystemJRunner;
import com.systemj.TickFinisher;

import java.util.Vector;
import java.util.concurrent.locks.LockSupport;

/**
 * Wall-clock pacing for the whole plant, so the operator display is watchable.
 *
 * ---- The problem ----
 *
 * SystemJ clock domains free-run: each one ticks as fast as its thread is
 * scheduled, which on a modern machine is on the order of a thousand ticks a
 * second. Every reaction in this system is correct at that rate - the logic
 * does not depend on how long a tick takes - but nothing is observable. A
 * diverter stroke of three ticks is three milliseconds, and the GUI only
 * repaints ten times a second, so a whole machine cycle can pass between two
 * frames. Watching the panel, bottles teleport.
 *
 * ---- The hook ----
 *
 * The SystemJ runtime calls runClockDomain() once per tick and ends the tick
 * with runFinisher(), which delegates to the domain's TickFinisher. The
 * default finisher does nothing; the debugger installs one that blocks on a
 * barrier. That is the intended extension point for anything that wants to
 * happen at a tick boundary, which is exactly where a delay belongs: outside
 * every reaction, outside every rendezvous, and after the tick's signals have
 * been resolved.
 *
 * So this installs one pacer on every clock domain in the program. Each pacer
 * holds its own next-tick deadline, because the domains are asynchronous and
 * must stay that way - they are not being brought into lockstep, they are
 * each being slowed to the same rate. Relative timing between machines is
 * therefore unchanged, and so is every ordering the design relies on. The
 * simulation is the same simulation, running against a slower clock.
 *
 * ---- Tuning ----
 *
 *   -Dabs.ticksPerSecond=60    the rate every clock domain is held to.
 *                              Lower is slower. 0 restores free-running,
 *                              which is what a regression run wants. At the
 *                              default a tick is about 17ms, so the shortest
 *                              actuator stroke lasts a couple of display
 *                              frames - the GUI only repaints every 100ms,
 *                              which is the floor worth aiming at.
 *
 * A domain that falls behind its deadline does not accumulate debt: it
 * abandons the missed deadline and paces from now. Without that, a garbage
 * collection pause would be followed by a burst of unpaced ticks, which is
 * precisely the stutter this exists to remove.
 */
public final class PlantPace implements TickFinisher {

	/** Ticks per second every clock domain is held to; 0 disables pacing. */
	public static final int TICKS_PER_SECOND =
			Integer.getInteger("abs.ticksPerSecond", 60).intValue();

	private static boolean installed = false;

	/**
	 * Attach a pacer to every clock domain in the running program.
	 *
	 * Safe to call from anywhere and more than once. The program is built by
	 * SystemJRunner while this is being called from inside a reaction, so the
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
