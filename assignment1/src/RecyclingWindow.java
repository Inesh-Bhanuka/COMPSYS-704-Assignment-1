import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

/**
 * The Recycling Station, on its own.
 *
 * ---- Why a second window ----
 *
 * On the system overview the whole station is one box, and every bottle inside
 * it is drawn at the same point: at lid removal, at the dumper and at the
 * return all land on the same pixel. The station's own sequence - the part the
 * IP is about - is therefore invisible exactly where it matters. This window
 * is that one box opened up, with a stop per station and the plant's own
 * photo-eyes and limit switches under each one.
 *
 * ---- What it reads ----
 *
 * Nothing of its own. It is handed the same GuiSnapshot the overview is
 * working from, on the same refresh, and every lamp on it is a signal the
 * sensor sweep already collects from the running clock domains. There is no
 * second sampler, no timer, and no path from this window back into the plant:
 * it cannot drive anything and cannot fall out of step with the overview.
 *
 * ---- Closing it ----
 *
 * DISPOSE_ON_CLOSE, and the overview holds no state that depends on this
 * window existing - it checks isDisplayable() before each update and builds a
 * fresh one the next time the box is clicked. Closing this window stops the
 * updates to it and nothing else; the line keeps running.
 */
public final class RecyclingWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private final View view = new View();

	public RecyclingWindow(Window owner) {
		super("Recycling Station");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout(0, 0));
		add(view, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(owner);
	}

	/** Take the overview's current snapshot. */
	public void update(GuiSnapshot s) {
		view.update(s);
	}

/**
 * Everything the window draws.
 *
 * A panel rather than the frame itself so it can be built, given a snapshot
 * and painted with no display attached, which is how its layout is checked.
 */
public static final class View extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final Color NAVY = new Color(24, 45, 72);
	private static final Color GREEN = new Color(43, 155, 102);
	private static final Color AMBER = new Color(241, 170, 63);
	private static final Color RED = new Color(205, 77, 67);
	private static final Color LINE = new Color(73, 89, 105);
	private static final Color PANEL_BG = new Color(246, 249, 252);
	private static final Color BELT = new Color(205, 212, 219);
	private static final Color STATION_FILL = new Color(205, 229, 241);
	private static final Color OFF = new Color(198, 205, 212);

	/** The window's fixed content width, so it never resizes as text changes. */
	private static final int CONTENT_WIDTH = 860;

	private final JLabel state = new JLabel(" ");
	private final JLabel queue = new JLabel(" ");
	private final JLabel recovered = new JLabel(" ");
	private final JLabel inStation = new JLabel(" ");
	private final DefaultListModel<String> waiting = new DefaultListModel<String>();
	private final DefaultListModel<String> events = new DefaultListModel<String>();
	private final StationPanel diagram = new StationPanel();

	private GuiSnapshot snapshot;

	public View() {
		setLayout(new BorderLayout(0, 0));
		setBackground(PANEL_BG);
		add(header(), BorderLayout.NORTH);
		add(diagram, BorderLayout.CENTER);
		add(lists(), BorderLayout.SOUTH);
	}

	private JPanel header() {
		// Clamped, because the in-station line changes length every time a
		// different bottle arrives and a frame that resizes itself while the
		// operator is watching it is worse than a truncated serial.
		JPanel bar = new JPanel(new GridLayout(2, 2, 16, 2)) {
			private static final long serialVersionUID = 1L;
			@Override public Dimension getPreferredSize() {
				Dimension d = super.getPreferredSize();
				return new Dimension(Math.min(d.width, CONTENT_WIDTH), d.height);
			}
		};
		bar.setBackground(NAVY);
		bar.setBorder(BorderFactory.createEmptyBorder(10, 14, 10, 14));
		for (JLabel l : new JLabel[] {state, queue, recovered, inStation}) {
			l.setForeground(Color.WHITE);
			l.setFont(new Font("SansSerif", Font.BOLD, 13));
			bar.add(l);
		}
		inStation.setFont(new Font("SansSerif", Font.PLAIN, 12));
		recovered.setFont(new Font("SansSerif", Font.PLAIN, 12));
		return bar;
	}

	private JPanel lists() {
		JPanel row = new JPanel(new GridLayout(1, 2, 10, 0));
		row.setBackground(PANEL_BG);
		row.setBorder(BorderFactory.createEmptyBorder(8, 10, 10, 10));
		row.add(titled("Waiting to be admitted", new JList<String>(waiting), 150));
		row.add(titled("Station activity", new JList<String>(events), 150));
		return row;
	}

	private JPanel titled(String title, JList<String> list, int height) {
		list.setFont(new Font("Monospaced", Font.PLAIN, 11));
		JScrollPane scroll = new JScrollPane(list);
		scroll.setPreferredSize(new Dimension(10, height));
		JPanel p = new JPanel(new BorderLayout());
		p.setBackground(PANEL_BG);
		p.setBorder(BorderFactory.createTitledBorder(title));
		p.add(scroll, BorderLayout.CENTER);
		return p;
	}

	/**
	 * Take the overview's current snapshot. Called on the Swing thread from the
	 * overview's own refresh, so there is one sampler and one repaint clock for
	 * both windows.
	 */
	void update(GuiSnapshot s) {
		if (s == null) {
			return;
		}
		snapshot = s;

		String level = station(s);
		state.setText("STATION: " + level);
		state.setForeground("SUSPENDED".equals(level) || "FAULT".equals(level) ? RED
				: "IDLE".equals(level) ? AMBER : Color.WHITE);
		queue.setText("QUEUE: " + s.recyclingQueued + " / " + s.recyclingCapacity + " waiting");
		recovered.setText("RECOVERED THIS RUN: " + s.recyclingRecovered);
		inStation.setText(s.recyclingInStation.isEmpty()
				? "No bottle in the station" : "In the station: " + s.recyclingInStation);

		replace(waiting, s.recyclingWaiting.isEmpty()
				? one("Nothing waiting.") : s.recyclingWaiting);
		replace(events, activity(s));
		diagram.repaint();
	}

	private static List<String> one(String text) {
		List<String> l = new ArrayList<String>();
		l.add(text);
		return l;
	}

	/** Rewrite only when the content changed, so the scroll position survives. */
	private static void replace(DefaultListModel<String> model, List<String> rows) {
		if (model.size() == rows.size()) {
			boolean same = true;
			for (int i = 0; i < rows.size(); i++) {
				if (!rows.get(i).equals(model.get(i))) {
					same = false;
					break;
				}
			}
			if (same) {
				return;
			}
		}
		model.clear();
		for (String r : rows) {
			model.addElement(r);
		}
	}

	/** The station's own lines out of the shared event log, newest last. */
	private static List<String> activity(GuiSnapshot s) {
		List<String> rows = new ArrayList<String>();
		for (GuiSnapshot.Event e : s.events) {
			if (e.machine == null) {
				continue;
			}
			if (e.machine.contains("RECYCL") || e.machine.contains("SPLITTER")) {
				rows.add(e.bottle + "  " + e.machine + ": " + e.message);
			}
		}
		int keep = 40;
		if (rows.size() > keep) {
			rows = new ArrayList<String>(rows.subList(rows.size() - keep, rows.size()));
		}
		if (rows.isEmpty()) {
			rows.add("No recycling activity yet.");
		}
		return rows;
	}

	private static String station(GuiSnapshot s) {
		String v = s.stations.get("RECYCLING");
		return v == null ? "UNKNOWN" : v;
	}

	// ---- sensor access ------------------------------------------------

	/** A signal as the sweep found it. Absent means the sweep has not seen it. */
	private String signal(String cd, String name) {
		if (snapshot == null) {
			return null;
		}
		return snapshot.sensors.get(cd + "." + name);
	}

	private boolean on(String cd, String name) {
		String v = signal(cd, name);
		return v != null && !"OFF".equals(v);
	}

	private String value(String cd, String name) {
		String v = signal(cd, name);
		return v == null || "OFF".equals(v) ? "-" : v;
	}

	private static final String CONVEYOR = "RecyclingConveyorControllerCD";
	private static final String LID = "LidRemovalControllerCD";
	private static final String DUMPER = "LiquidDumperControllerCD";
	private static final String RETURN = "BottleReturnControllerCD";

	// ---- the diagram --------------------------------------------------

	private final class StationPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		StationPanel() {
			setBackground(PANEL_BG);
			setPreferredSize(new Dimension(CONTENT_WIDTH, 340));
			setBorder(BorderFactory.createEmptyBorder(12, 10, 4, 10));
		}

		@Override
		protected void paintComponent(Graphics graphics) {
			super.paintComponent(graphics);
			Graphics2D g = (Graphics2D) graphics.create();
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

			int y = 74;
			int[] x = {40, 235, 430, 625};
			int w = 155;

			belt(g, x[0], y, x[3] + w, 96);

			stop(g, x[0], y, w, "1. ENTRY", "from the splitter",
					on(CONVEYOR, "bottleAtSplitterExit"), new String[0], new boolean[0]);

			stop(g, x[1], y, w, "2. LID REMOVAL", "unscrew and eject",
					on(CONVEYOR, "bottleAtLidRemoval"),
					new String[] {"z down", "z up", "turned", "gripped"},
					new boolean[] {on(LID, "zAxisLowered"), on(LID, "zAxisLifted"),
							on(LID, "turnAtFinalPos"), on(LID, "lidGripped")});

			stop(g, x[2], y, w, "3. LIQUID DUMPER", "invert and drain",
					on(CONVEYOR, "bottleAtDumper"),
					new String[] {"clamped", "inverted", "upright", "drained"},
					new boolean[] {on(DUMPER, "clampClosed"), on(DUMPER, "bottleInverted"),
							on(DUMPER, "bottleUpright"), on(DUMPER, "bottleDrained")});

			stop(g, x[3], y, w, "4. BOTTLE RETURN", "transfer to the bin",
					on(CONVEYOR, "bottleAtReturn"),
					new String[] {"arm home", "at loader", "in bin"},
					new boolean[] {on(RETURN, "armAtHome"), on(RETURN, "armAtLoader"),
							on(RETURN, "bottleAtCollector")});

			arrow(g, x[0] + w, y + 48, x[1]);
			arrow(g, x[1] + w, y + 48, x[2]);
			arrow(g, x[2] + w, y + 48, x[3]);

			receptacles(g, 40, 272);

			g.setColor(LINE);
			g.setFont(new Font("SansSerif", Font.PLAIN, 11));
			g.drawString("Indexing conveyor - one command moves the bottle one stop. "
					+ "Lamps are the plant's own sensors.", 40, 36);
			g.dispose();
		}

		private void belt(Graphics2D g, int x, int y, int right, int h) {
			g.setColor(BELT);
			g.fillRoundRect(x - 14, y - 12, right - x + 28, h + 24, 14, 14);
			g.setColor(LINE);
			g.setStroke(new BasicStroke(1.4f));
			g.drawRoundRect(x - 14, y - 12, right - x + 28, h + 24, 14, 14);
			g.setStroke(new BasicStroke(1f));
		}

		private void stop(Graphics2D g, int x, int y, int w, String title, String subtitle,
				boolean occupied, String[] names, boolean[] states) {
			int h = 96;
			g.setColor(occupied ? new Color(223, 242, 232) : STATION_FILL);
			g.fillRoundRect(x, y, w, h, 10, 10);
			g.setColor(occupied ? GREEN : LINE);
			g.setStroke(new BasicStroke(occupied ? 2.4f : 1.2f));
			g.drawRoundRect(x, y, w, h, 10, 10);
			g.setStroke(new BasicStroke(1f));

			g.setColor(NAVY);
			g.setFont(new Font("SansSerif", Font.BOLD, 11));
			centre(g, title, x + w / 2, y + 18);
			g.setFont(new Font("SansSerif", Font.PLAIN, 10));
			g.setColor(LINE);
			centre(g, subtitle, x + w / 2, y + 32);

			lamp(g, x + w / 2 - 5, y + 40, occupied);

			if (occupied) {
				bottle(g, x + w / 2, y + 60);
			}

			g.setFont(new Font("SansSerif", Font.PLAIN, 10));
			for (int i = 0; i < names.length; i++) {
				int ly = y + h + 26 + i * 15;
				lamp(g, x + 6, ly - 8, states[i]);
				g.setColor(states[i] ? NAVY : LINE);
				g.drawString(names[i], x + 22, ly);
			}
		}

		/**
		 * The bottle standing at a stop, drawn from its own record: how much
		 * is in it and whether the lid is still on. Those are the two things
		 * this station changes, so they are the two things worth drawing -
		 * the liquid falls away as the dumper works and the cap disappears
		 * when lid removal is done.
		 */
		private void bottle(Graphics2D g, int cx, int cy) {
			int w = 18, h = 30;
			int left = cx - w / 2, top = cy - h / 2;

			g.setColor(Color.WHITE);
			g.fillRoundRect(left, top, w, h, 4, 4);

			int size = snapshot == null ? 0 : snapshot.recyclingSizeMl;
			int filled = snapshot == null ? 0 : snapshot.recyclingFilledMl;
			if (size > 0 && filled > 0) {
				int liquid = Math.max(2, Math.min(h - 4, (h - 4) * filled / size));
				g.setColor(new Color(54, 181, 211));
				g.fillRoundRect(left + 2, top + h - 2 - liquid, w - 4, liquid, 3, 3);
			}

			g.setColor(LINE);
			g.drawRoundRect(left, top, w, h, 4, 4);
			if (snapshot != null && snapshot.recyclingLidded) {
				g.setColor(RED);
				g.fillRect(cx - 4, top - 6, 8, 6);
				g.setColor(LINE);
				g.drawRect(cx - 4, top - 6, 8, 6);
			}
		}

		private void arrow(Graphics2D g, int fromX, int y, int toX) {
			g.setColor(LINE);
			g.setStroke(new BasicStroke(2f));
			g.drawLine(fromX + 4, y, toX - 6, y);
			g.fillPolygon(new int[] {toX - 4, toX - 12, toX - 12},
					new int[] {y, y - 5, y + 5}, 3);
			g.setStroke(new BasicStroke(1f));
		}

		private void receptacles(Graphics2D g, int x, int y) {
			boolean lidFull = on(LID, "lidBinFull");
			boolean binFull = on(RETURN, "collectorBinFull");
			String tank = value(DUMPER, "wasteTankLevel");

			receptacle(g, x, y, "Lid waste bin", lidFull ? "FULL" : "accepting", lidFull);
			receptacle(g, x + 260, y, "Waste tank", "level " + tank, false);
			receptacle(g, x + 520, y, "Collector bin", binFull ? "FULL" : "accepting", binFull);
		}

		private void receptacle(Graphics2D g, int x, int y, String name, String note, boolean full) {
			g.setColor(Color.WHITE);
			g.fillRoundRect(x, y, 240, 40, 8, 8);
			g.setColor(full ? RED : LINE);
			g.setStroke(new BasicStroke(full ? 2f : 1f));
			g.drawRoundRect(x, y, 240, 40, 8, 8);
			g.setStroke(new BasicStroke(1f));
			lamp(g, x + 12, y + 15, !full);
			g.setColor(NAVY);
			g.setFont(new Font("SansSerif", Font.BOLD, 11));
			g.drawString(name, x + 32, y + 18);
			g.setColor(full ? RED : LINE);
			g.setFont(new Font("SansSerif", Font.PLAIN, 10));
			g.drawString(note, x + 32, y + 31);
		}

		private void lamp(Graphics2D g, int x, int y, boolean lit) {
			g.setColor(lit ? GREEN : OFF);
			g.fillOval(x, y, 11, 11);
			g.setColor(LINE);
			g.drawOval(x, y, 11, 11);
		}

		private void centre(Graphics2D g, String text, int cx, int baseY) {
			FontMetrics m = g.getFontMetrics();
			g.drawString(text, cx - m.stringWidth(text) / 2, baseY);
		}
	}
}
}
