import java.util.HashSet;
import java.util.Set;

import com.systemj.netapi.TCPReceiver;

/**
 * The operator panel's mailbox: which actuator signals to assert this tick.
 *
 * ---- One press, one tick ----
 *
 * SystemJ's unit of meaning is the tick, and manual control is most useful
 * when it speaks the same unit: tick the signals you want, press Send Tick,
 * and the plant advances by exactly that. So this does not model a button
 * being held down. It hands each signal out once, and never again for the
 * same operator tick.
 *
 * Exactly-once is per signal rather than per read, which is what makes it
 * safe inside a clock domain: the panel's thirteen reactions all ask in the
 * same tick and in no defined order, so a latch advanced by one of them would
 * race the other twelve. Marking each (tick, signal) pair as it is taken has
 * no ordering to get wrong.
 *
 * ---- Why it is not read from a socket inside a tick ----
 *
 * TCPReceiver delivers on its own thread and this class only ever hands the
 * clock domain a field it has already been given. No clock domain ever waits
 * on a socket, which is the rule the twin publisher had to learn the hard way.
 */
public final class ManualDrive {

	private static volatile ManualTick pending;
	private static final Set<String> taken = new HashSet<String>();
	private static long lastSequence = -1;
	private static boolean opened;

	private ManualDrive() {
	}

	/** Idempotent, and safe to call from inside a reaction: it never blocks. */
	public static synchronized void open() {
		if (opened || !Boolean.getBoolean("gui.enabled")) {
			return;
		}
		opened = true;
		GuiClient.daemon("manual drive receiver", new Runnable() {
			public void run() {
				TCPReceiver receiver = new TCPReceiver("127.0.0.1", GuiClient.MANUAL_PORT);
				receiver.setConsumer((present, value) -> {
					if (Boolean.TRUE.equals(present) && value instanceof ManualTick) {
						accept((ManualTick) value);
					}
				});
			}
		});
	}

	/** A resend of the tick already in hand is ignored; a new one replaces it. */
	private static synchronized void accept(ManualTick tick) {
		if (tick.sequence <= lastSequence) {
			return;
		}
		lastSequence = tick.sequence;
		taken.clear();
		pending = tick;
	}

	/**
	 * True once for this signal, for this operator tick.
	 *
	 * The panel domain calls this for every actuator every tick; all but the
	 * ones the operator selected return false, and each selected one returns
	 * true exactly once.
	 */
	public static synchronized boolean held(String id) {
		open();
		ManualTick tick = pending;
		if (tick == null || !tick.signals.contains(id)) {
			return false;
		}
		if (!taken.add(id)) {
			return false;
		}
		if (taken.size() == tick.signals.size()) {
			pending = null;   // every signal in it has now fired
		}
		return true;
	}

	/** How many signals of the current operator tick are still to fire. */
	public static synchronized int outstanding() {
		ManualTick tick = pending;
		return tick == null ? 0 : tick.signals.size() - taken.size();
	}
}
