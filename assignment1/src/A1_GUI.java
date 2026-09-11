import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 * Interactive Swing visualisation for the COMPSYS 704 automated bottling line.
 *
 * Adapted from the supplied A1_GUI.java mockup.
 * Build and run through the existing ABS launch configurations.
 *
 * The file deliberately contains ASCII characters only so that it also
 * compiles on Windows systems whose default source encoding is windows-1252.
 */
public class A1_GUI extends JFrame {

    private static final Color NAVY = new Color(24, 45, 72);
    private static final Color BLUE = new Color(32, 111, 179);
    private static final Color CYAN = new Color(54, 181, 211);
    private static final Color GREEN = new Color(43, 155, 102);
    private static final Color AMBER = new Color(241, 170, 63);
    private static final Color RED = new Color(205, 77, 67);
    private static final Color PANEL_BG = new Color(246, 249, 252);
    private static final Color LINE = new Color(73, 89, 105);

    private final FactoryPanel factoryPanel = new FactoryPanel();
    private final JTextArea eventLog = new JTextArea(10, 24);

    private final JTextField productNameField = new JTextField("Custom Blend A");
    private final JTextField productIdField = new JTextField("P-704-A");
    private final JTextField batchIdField = new JTextField("BATCH-001");
    private final JSpinner quantitySpinner = new JSpinner(
            new SpinnerNumberModel(12, 1, 10000, 1));
    private final JSpinner liquid1Spinner = new JSpinner(
            new SpinnerNumberModel(45, 0, 100, 5));
    private final JSpinner liquid2Spinner = new JSpinner(
            new SpinnerNumberModel(55, 0, 100, 5));
    private final JComboBox<String> faultModeCombo = new JComboBox<String>(
            new String[] {"No forced failures", "Every 5th bottle fails",
                    "Every 3rd bottle fails"});

    private final JLabel lineStateLabel = valueLabel("IDLE", LINE);
    private final JLabel producedLabel = valueLabel("0 / 12", BLUE);
    private final JLabel acceptedLabel = valueLabel("0", GREEN);
    private final JLabel recycledLabel = valueLabel("0", RED);
    private final JLabel activeBottleLabel = valueLabel("None", LINE);

    private final JButton startButton = new JButton("Start");
    private final JButton pauseButton = new JButton("Pause");
    private final JButton resetButton = new JButton("Reset");
    private final JButton executeManualButton = new JButton("Enable Selected");
    private final JButton clearManualButton = new JButton("Clear Ticks");

    private final JComboBox<String> operationModeCombo = new JComboBox<String>(
            new String[] {"Automatic", "Manual"});
    private final CardLayout modeCardLayout = new CardLayout();
    private final JPanel modeCards = new JPanel(modeCardLayout);
    private JPanel automaticControlPanel;
    private JPanel manualControlPanel;
    private final JCheckBox conveyorACheck = new JCheckBox("Conveyor A move / load");
    private final JCheckBox rotaryCheck = new JCheckBox("Index rotary table");
    private final JCheckBox liquid1Check = new JCheckBox("Liquid 1 fill");
    private final JCheckBox liquid2Check = new JCheckBox("Liquid 2 fill");
    private final JCheckBox lidCheck = new JCheckBox("Place lid");
    private final JCheckBox capperCheck = new JCheckBox("Screw lid with capper");
    private final JCheckBox conveyorBCheck = new JCheckBox("Conveyor B move / collect");
    private final JCheckBox inspectCheck = new JCheckBox("Quality inspect / split");
    private final JCheckBox labelCheck = new JCheckBox("Label and batch store");
    private final JCheckBox recycleCheck = new JCheckBox("Recycle failed product");
    private final JCheckBox[] manualChecks = {conveyorACheck, rotaryCheck,
            liquid1Check, liquid2Check, lidCheck, capperCheck, conveyorBCheck,
            inspectCheck, labelCheck, recycleCheck};

    private final JProgressBar batchProgressBar = new JProgressBar();
    private final JLabel batchInfoLabel = new JLabel("No active batch");
    private final JTextArea batchHistoryArea = new JTextArea(4, 24);

    private final GuiClient client;
    private final Timer refreshTimer;
    private GuiSnapshot snapshot;
    private boolean updating;
    private int requestedQuantity;
    private boolean photoEyeActive;
    private Bottle selectedBottle;
    private final java.util.Map<Long, Bottle> liveBottles = new java.util.LinkedHashMap<Long, Bottle>();
    private final JTextArea alertArea = new JTextArea(4, 24);
    private final JLabel connectionLabel = new JLabel("Waiting for SystemJ feedback");
    private final JLabel commandLabel = new JLabel(" ");
    private final JComboBox<String> batchSelector = new JComboBox<String>();
    private final javax.swing.table.DefaultTableModel bottleModel = new javax.swing.table.DefaultTableModel(
            new String[]{"Serial", "Batch", "Product", "Stage", "Quality"}, 0) {
        public boolean isCellEditable(int row, int column) { return false; }
    };
    private final javax.swing.JTable bottleTable = new javax.swing.JTable(bottleModel);
    private final javax.swing.table.DefaultTableModel sensorModel = new javax.swing.table.DefaultTableModel(
            new String[]{"Sensor", "State"}, 0) {
        public boolean isCellEditable(int row, int column) { return false; }
    };
    private final List<Long> bottleIds = new ArrayList<Long>();
    private long selectedId = -1, selectedBatch = -1;
    private final javax.swing.JPopupMenu labelPopup = new javax.swing.JPopupMenu();

    public A1_GUI() { this(new GuiClient()); }
    public A1_GUI(GuiClient client) {

        super("Advantech Automated Bottling System - EABS Visualisation");
        this.client = client;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Rectangle usableScreen = GraphicsEnvironment
                .getLocalGraphicsEnvironment().getMaximumWindowBounds();
        int windowWidth = Math.min(1500,
                Math.max(320, usableScreen.width - 24));
        int windowHeight = Math.min(920,
                Math.max(500, usableScreen.height - 40));
        windowWidth = Math.min(windowWidth, usableScreen.width);
        windowHeight = Math.min(windowHeight, usableScreen.height);
        setMinimumSize(new Dimension(Math.min(900, windowWidth),
                Math.min(620, windowHeight)));
        setSize(windowWidth, windowHeight);
        setLocation(usableScreen.x + (usableScreen.width - windowWidth) / 2,
                usableScreen.y + (usableScreen.height - windowHeight) / 2);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(new Color(231, 237, 243));
        root.add(createHeader(), BorderLayout.NORTH);
        javax.swing.JTabbedPane views = new javax.swing.JTabbedPane();
        views.addTab("System Overview", factoryPanel);
        views.addTab("Bottle Records", new JScrollPane(bottleTable));
        views.addTab("Sensors", new JScrollPane(new javax.swing.JTable(sensorModel)));
        root.add(views, BorderLayout.CENTER);
        bottleTable.getSelectionModel().addListSelectionListener(e -> {
            if (!updating && bottleTable.getSelectedRow() >= 0) {
                selectedId = bottleIds.get(bottleTable.convertRowIndexToModel(bottleTable.getSelectedRow()));
                selectedBottle = liveBottles.get(selectedId);
                refreshView();
            }
        });
        LabelPreviewPanel floatingLabel = new LabelPreviewPanel();
        floatingLabel.setPreferredSize(new Dimension(560, 180));
        labelPopup.add(floatingLabel);
        root.add(createControlPanel(), BorderLayout.EAST);
        setContentPane(root);

        refreshTimer = new Timer(100, e -> refreshView());
        refreshTimer.setCoalesce(true);
        startButton.addActionListener(e -> send(new GuiCommand("START")));
        pauseButton.addActionListener(e -> send(new GuiCommand("PAUSE")));
        resetButton.addActionListener(e -> send(new GuiCommand("RESET")));
        executeManualButton.setName("Enable Selected");
        clearManualButton.setName("Clear Ticks");
        for (int i = 0; i < manualChecks.length; i++) manualChecks[i].setName("operation-" + GuiSupervisor.OPERATIONS[i]);
        executeManualButton.addActionListener(e -> executeManualControls());
        clearManualButton.addActionListener(e -> { for (JCheckBox check : manualChecks) check.setSelected(false); });
        operationModeCombo.addActionListener(e -> {
            if (!updating) send(new GuiCommand(operationModeCombo.getSelectedIndex() == 0 ? "AUTO" : "MANUAL"));
        });
        faultModeCombo.addActionListener(e -> {
            if (!updating) send(new GuiCommand("QUALITY", java.util.Collections.<String>emptyList(),
                    faultModeCombo.getSelectedIndex() == 1 ? 5 : faultModeCombo.getSelectedIndex() == 2 ? 3 : 0));
        });
        batchSelector.addActionListener(e -> {
            if (!updating && snapshot != null && batchSelector.getSelectedIndex() >= 0) {
                selectedBatch = snapshot.batches.get(batchSelector.getSelectedIndex()).id;
                refreshView();
            }
        });
        productNameField.setEditable(false); productIdField.setEditable(false); batchIdField.setEditable(false);
        quantitySpinner.setEnabled(false); liquid1Spinner.setEnabled(false); liquid2Spinner.setEnabled(false);
        refreshView();
        refreshTimer.start();
    }

    @Override public void dispose() { refreshTimer.stop(); super.dispose(); }

    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(NAVY);
        header.setBorder(new EmptyBorder(13, 20, 13, 20));

        JLabel title = new JLabel("SYSTEM OVERVIEW");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        header.add(title, BorderLayout.WEST);
        connectionLabel.setForeground(Color.WHITE);
        header.add(connectionLabel, BorderLayout.EAST);
        return header;
    }

    private JPanel createControlPanel() {
        JPanel side = new JPanel();
        side.setBackground(PANEL_BG);
        side.setPreferredSize(new Dimension(330, 700));
        side.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0,
                new Color(200, 210, 220)));
        side.setLayout(new BoxLayout(side, BoxLayout.Y_AXIS));

        JScrollPane scroll = new JScrollPane(createControlContent());
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(14);
        side.add(scroll);
        return side;
    }

    private JPanel createControlContent() {
        JPanel content = new VerticalScrollablePanel();
        content.setBackground(PANEL_BG);
        content.setBorder(new EmptyBorder(16, 16, 20, 16));
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        content.add(sectionTitle("PRODUCTION ORDER"));
        JPanel form = new JPanel(new GridBagLayout());
        form.setOpaque(false);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 0, 4, 8);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        addFormRow(form, c, "POS batch", batchSelector);
        addFormRow(form, c, "Product name", productNameField);
        addFormRow(form, c, "Product ID", productIdField);
        addFormRow(form, c, "Batch ID", batchIdField);
        addFormRow(form, c, "Quantity", quantitySpinner);
        addFormRow(form, c, "Liquid 1 (%)", liquid1Spinner);
        addFormRow(form, c, "Liquid 2 (%)", liquid2Spinner);
        addFormRow(form, c, "Quality mode", faultModeCombo);
        content.add(form);
        content.add(Box.createVerticalStrut(12));

        content.add(sectionTitle("LINE CONTROL"));
        JPanel modeRow = new JPanel(new BorderLayout(8, 0));
        modeRow.setOpaque(false);
        JLabel modeLabel = new JLabel("Operation mode");
        modeLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
        modeLabel.setForeground(LINE);
        modeRow.add(modeLabel, BorderLayout.WEST);
        modeRow.add(operationModeCombo, BorderLayout.CENTER);
        content.add(modeRow);
        content.add(Box.createVerticalStrut(8));

        modeCards.setOpaque(false);
        automaticControlPanel = createAutomaticControlPanel();
        manualControlPanel = createManualControlPanel();
        modeCards.add(automaticControlPanel, "AUTO");
        modeCards.add(manualControlPanel, "MANUAL");
        setModeCardHeight(automaticControlPanel);
        content.add(modeCards);
        content.add(Box.createVerticalStrut(14));

        content.add(sectionTitle("LIVE STATUS"));
        JPanel status = new JPanel(new GridBagLayout());
        status.setOpaque(false);
        GridBagConstraints s = new GridBagConstraints();
        s.insets = new Insets(3, 0, 3, 8);
        s.fill = GridBagConstraints.HORIZONTAL;
        s.gridy = 0;
        addStatusRow(status, s, "Line", lineStateLabel);
        addStatusRow(status, s, "Completed", producedLabel);
        addStatusRow(status, s, "Accepted", acceptedLabel);
        addStatusRow(status, s, "Recycled", recycledLabel);
        addStatusRow(status, s, "Selected", activeBottleLabel);
        content.add(status);
        content.add(Box.createVerticalStrut(14));

        content.add(sectionTitle("BATCH PROGRESS"));
        batchProgressBar.setMinimum(0);
        batchProgressBar.setMaximum(requestedQuantity);
        batchProgressBar.setValue(0);
        batchProgressBar.setStringPainted(true);
        batchProgressBar.setString("0 / " + requestedQuantity + " completed");
        batchProgressBar.setForeground(GREEN);
        batchProgressBar.setBackground(Color.WHITE);
        content.add(batchProgressBar);
        content.add(Box.createVerticalStrut(6));
        batchInfoLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        batchInfoLabel.setForeground(LINE);
        Dimension batchInfoSize = new Dimension(280, 58);
        batchInfoLabel.setPreferredSize(batchInfoSize);
        batchInfoLabel.setMinimumSize(batchInfoSize);
        batchInfoLabel.setMaximumSize(batchInfoSize);
        content.add(batchInfoLabel);
        content.add(Box.createVerticalStrut(7));
        batchHistoryArea.setEditable(false);
        batchHistoryArea.setLineWrap(true);
        batchHistoryArea.setWrapStyleWord(true);
        batchHistoryArea.setFont(new Font("SansSerif", Font.PLAIN, 10));
        batchHistoryArea.setBackground(Color.WHITE);
        batchHistoryArea.setText("Batch history will appear here.\n");
        JScrollPane historyScroll = new JScrollPane(batchHistoryArea);
        historyScroll.setPreferredSize(new Dimension(280, 82));
        historyScroll.setBorder(BorderFactory.createLineBorder(
                new Color(205, 214, 222)));
        content.add(historyScroll);
        content.add(Box.createVerticalStrut(14));

        content.add(sectionTitle("EVENT LOG"));
        eventLog.setEditable(false);
        eventLog.setFont(new Font("Monospaced", Font.PLAIN, 11));
        eventLog.setLineWrap(true);
        eventLog.setWrapStyleWord(true);
        eventLog.setBackground(Color.WHITE);
        eventLog.setForeground(new Color(43, 55, 67));
        JScrollPane logScroll = new JScrollPane(eventLog);
        logScroll.setPreferredSize(new Dimension(280, 185));
        logScroll.setBorder(BorderFactory.createLineBorder(new Color(205, 214, 222)));
        content.add(logScroll);
        content.add(Box.createVerticalStrut(14));

        content.add(sectionTitle("ALERTS"));
        alertArea.setEditable(false); alertArea.setLineWrap(true); alertArea.setWrapStyleWord(true);
        alertArea.setForeground(RED); content.add(new JScrollPane(alertArea));
        JPanel faultButtons = new JPanel(new java.awt.GridLayout(1, 2, 4, 0));
        JButton fault = new JButton("Simulate jam"), clear = new JButton("Clear Fault");
        fault.addActionListener(e -> send(new GuiCommand("FAULT")));
        clear.addActionListener(e -> send(new GuiCommand("CLEAR_FAULT")));
        faultButtons.add(fault); faultButtons.add(clear); content.add(faultButtons);
        content.add(commandLabel);
        content.add(Box.createVerticalStrut(14));
        content.add(sectionTitle("LABEL PREVIEW"));
        content.add(new LabelPreviewPanel());
        return content;
    }

    private JPanel createAutomaticControlPanel() {
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.setOpaque(false);
        styleBlackButton(startButton);
        styleBlackButton(pauseButton);
        styleBlackButton(resetButton);
        GridBagConstraints b = new GridBagConstraints();
        b.fill = GridBagConstraints.HORIZONTAL;
        b.weightx = 1;
        b.insets = new Insets(3, 3, 3, 3);
        b.gridy = 0;
        b.gridx = 0;
        buttons.add(startButton, b);
        b.gridx = 1;
        buttons.add(pauseButton, b);
        b.gridx = 2;
        buttons.add(resetButton, b);
        return buttons;
    }

    private JPanel createManualControlPanel() {
        JPanel manual = new JPanel(new GridBagLayout());
        manual.setOpaque(false);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1;
        c.insets = new Insets(1, 0, 1, 0);
        c.gridx = 0;
        c.gridy = 0;
        for (JCheckBox checkBox : manualChecks) {
            checkBox.setOpaque(false);
            checkBox.setFont(new Font("SansSerif", Font.PLAIN, 10));
            checkBox.setForeground(LINE);
            manual.add(checkBox, c);
            c.gridy++;
        }

        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.setOpaque(false);
        styleBlackButton(executeManualButton);
        styleBlackButton(clearManualButton);
        GridBagConstraints b = new GridBagConstraints();
        b.fill = GridBagConstraints.HORIZONTAL;
        b.weightx = 1;
        b.insets = new Insets(4, 2, 0, 2);
        b.gridx = 0;
        buttons.add(executeManualButton, b);
        b.gridx = 1;
        buttons.add(clearManualButton, b);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(4, 0, 0, 0);
        manual.add(buttons, c);
        return manual;
    }

    private void setModeCardHeight(JPanel visibleCard) {
        int cardHeight = visibleCard.getPreferredSize().height;
        modeCards.setPreferredSize(new Dimension(280, cardHeight));
        modeCards.setMinimumSize(new Dimension(0, cardHeight));
        modeCards.setMaximumSize(new Dimension(Integer.MAX_VALUE, cardHeight));
    }

    private static JLabel sectionTitle(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.BOLD, 12));
        label.setForeground(NAVY);
        label.setBorder(new EmptyBorder(0, 0, 7, 0));
        label.setAlignmentX(LEFT_ALIGNMENT);
        return label;
    }

    private static JLabel valueLabel(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.BOLD, 12));
        label.setForeground(color);
        return label;
    }

    private static void styleBlackButton(JButton button) {
        button.setFont(new Font("SansSerif", Font.BOLD, 11));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(9, 8, 9, 8));
    }

    private static void addFormRow(JPanel panel, GridBagConstraints c,
            String name, java.awt.Component input) {
        c.gridx = 0;
        c.weightx = 0;
        JLabel label = new JLabel(name);
        label.setFont(new Font("SansSerif", Font.PLAIN, 11));
        label.setForeground(LINE);
        panel.add(label, c);
        c.gridx = 1;
        c.weightx = 1;
        panel.add(input, c);
        c.gridy++;
    }

    private static void addStatusRow(JPanel panel, GridBagConstraints c,
            String name, JLabel value) {
        c.gridx = 0;
        c.weightx = 0;
        JLabel label = new JLabel(name);
        label.setFont(new Font("SansSerif", Font.PLAIN, 11));
        label.setForeground(LINE);
        panel.add(label, c);
        c.gridx = 1;
        c.weightx = 1;
        panel.add(value, c);
        c.gridy++;
    }

    private void send(GuiCommand command) {
        commandLabel.setText(client.send(command) ? "Command sent; awaiting controller" : "No live connection / command queue full");
    }

    private void executeManualControls() {
        List<String> operations = new ArrayList<String>();
        for (int i = 0; i < manualChecks.length; i++) if (manualChecks[i].isSelected()) operations.add(GuiSupervisor.OPERATIONS[i]);
        if (!operations.isEmpty()) send(new GuiCommand("ENABLE", operations, 0));
    }

    /** The timer renders received values only; it never advances production. */
    void refreshView() {
        updating = true;
        try {
            snapshot = client.latest();
            boolean connected = client.connected();
            connectionLabel.setText(connected ? "SystemJ connected" : "Disconnected / stale feedback");
            boolean manual = snapshot != null && "Manual".equalsIgnoreCase(snapshot.mode);
            operationModeCombo.setSelectedIndex(manual ? 1 : 0);
            modeCardLayout.show(modeCards, manual ? "MANUAL" : "AUTO");
            setModeCardHeight(manual ? manualControlPanel : automaticControlPanel);
            operationModeCombo.setEnabled(connected);
            startButton.setEnabled(connected && !manual);
            pauseButton.setEnabled(connected && !manual);
            resetButton.setEnabled(connected);
            executeManualButton.setEnabled(connected && manual);
            clearManualButton.setEnabled(manual);
            faultModeCombo.setEnabled(connected);
            lineStateLabel.setText(connected ? snapshot.state : "DISCONNECTED");
            lineStateLabel.setForeground(!connected ? RED : "RUNNING".equals(snapshot.state) ? GREEN : AMBER.darker());
            if (snapshot == null) return;
            faultModeCombo.setSelectedIndex(snapshot.rejectEvery == 5 ? 1 : snapshot.rejectEvery == 3 ? 2 : 0);
            GuiSnapshot.BatchView batch = null;
            boolean batchesChanged = batchSelector.getItemCount() != snapshot.batches.size();
            if (!batchesChanged) for (int i = 0; i < snapshot.batches.size(); i++) {
                GuiSnapshot.BatchView b = snapshot.batches.get(i);
                if (!("B" + b.id + " - " + b.product).equals(batchSelector.getItemAt(i))) { batchesChanged = true; break; }
            }
            if (batchesChanged) batchSelector.removeAllItems();
            for (GuiSnapshot.BatchView b : snapshot.batches) {
                if (batchesChanged) batchSelector.addItem("B" + b.id + " - " + b.product);
                if (b.id == selectedBatch) batch = b;
            }
            if (batch == null && !snapshot.batches.isEmpty()) {
                batch = snapshot.batches.get(0);
                for (GuiSnapshot.BatchView b : snapshot.batches) if (!"Completed".equals(b.status)) { batch = b; break; }
            }
            if (batch != null) {
                selectedBatch = batch.id; batchSelector.setSelectedIndex(snapshot.batches.indexOf(batch));
                requestedQuantity = batch.target;
                productNameField.setText(batch.product); productIdField.setText(batch.productId); batchIdField.setText("B" + batch.id);
                quantitySpinner.setValue(batch.target); liquid1Spinner.setValue(batch.one); liquid2Spinner.setValue(batch.two);
                producedLabel.setText((batch.accepted + batch.recycled) + " processed / " + batch.target + " target");
                acceptedLabel.setText("" + batch.accepted); recycledLabel.setText("" + batch.recycled);
                batchProgressBar.setMaximum(Math.max(1, batch.target)); batchProgressBar.setValue(batch.accepted);
                batchProgressBar.setString(batch.accepted + " / " + batch.target + " accepted");
                batchInfoLabel.setText("<html>B" + batch.id + " - " + html(batch.product) + "<br>Target: " + batch.target
                        + " | In process: " + batch.inProcess + "<br>Recipe: " + batch.one + "% L1 + " + batch.two + "% L2 | " + batch.size + " mL</html>");
            } else {
                selectedBatch = -1; productNameField.setText(""); productIdField.setText(""); batchIdField.setText("");
                producedLabel.setText("0 / 0"); acceptedLabel.setText("0"); recycledLabel.setText("0");
                batchProgressBar.setValue(0); batchProgressBar.setString("No active batch"); batchInfoLabel.setText("Create a purchase order in POS");
            }
            liveBottles.clear(); bottleIds.clear(); bottleModel.setRowCount(0);
            for (GuiSnapshot.Bottle b : snapshot.bottles) {
                liveBottles.put(b.id, new Bottle(b)); bottleIds.add(b.id);
                bottleModel.addRow(new Object[]{b.serial, "B" + b.batch, b.product, b.stage, b.quality});
            }
            selectedBottle = liveBottles.get(selectedId);
            activeBottleLabel.setText(selectedBottle == null ? "None" : selectedBottle.shortId());
            sensorModel.setRowCount(0); photoEyeActive = false;
            for (java.util.Map.Entry<String, String> e : snapshot.sensors.entrySet()) {
                sensorModel.addRow(new Object[]{e.getKey(), e.getValue()});
                if (e.getKey().endsWith("bottleAtPos1") && "ON".equals(e.getValue())) photoEyeActive = true;
            }
            StringBuilder events = new StringBuilder();
            for (GuiSnapshot.Event e : client.events()) events.append(eventText(e)).append("\n");
            if (!eventLog.getText().equals(events.toString())) { eventLog.setText(events.toString()); eventLog.setCaretPosition(eventLog.getDocument().getLength()); }
            StringBuilder alerts = new StringBuilder();
            for (GuiSnapshot.Event e : snapshot.alerts) alerts.append(eventText(e)).append("\n");
            alertArea.setText(alerts.length() == 0 ? "No active faults" : alerts.toString());
            batchHistoryArea.setText(String.join("\n", snapshot.history));
            commandLabel.setText("<html>" + html(snapshot.commandMessage) + "</html>");
        } finally { updating = false; repaint(); labelPopup.repaint(); }
    }

    private static String html(String text) { return text == null ? "" : text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;"); }
    private static String eventText(GuiSnapshot.Event e) {
        return "[" + new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date(e.time)) + "] " + e.bottle + " " + e.machine + ": " + e.message;
    }

    private final class LabelPreviewPanel extends JPanel {
        LabelPreviewPanel() {
            setPreferredSize(new Dimension(285, 180));
            setMaximumSize(new Dimension(Integer.MAX_VALUE, 180));
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createLineBorder(new Color(190, 202, 212)));
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            Graphics2D g = (Graphics2D) graphics.create();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            int w = getWidth();
            g.setColor(NAVY);
            g.fillRect(0, 0, w, 26);
            g.setColor(Color.WHITE);
            g.setFont(new Font("SansSerif", Font.BOLD, 11));
            g.drawString("ADVANTECH PRODUCT LABEL", 10, 18);

            Bottle bottle = selectedBottle;
            g.setColor(new Color(38, 49, 60));
            g.setFont(new Font("SansSerif", Font.PLAIN, 10));
            int y = 43;
            if (bottle == null) {
                g.drawString("Select or produce a bottle to preview its label.", 10, y);
            } else {
                drawLabelLine(g, "Product", bottle.productName, y); y += 16;
                drawLabelLine(g, "ID / Serial", bottle.productId + " / "
                        + bottle.serialText(), y); y += 16;
                drawLabelLine(g, "Batch", bottle.batchId, y); y += 16;
                drawLabelLine(g, "Contents", bottle.liquid1Percent + "% L1, "
                        + bottle.liquid2Percent + "% L2", y); y += 16;
                drawLabelLine(g, "Volume", bottle.data.filled + " / " + bottle.data.size + " mL", y); y += 16;
                String complete = bottle.data.stage + " / " + bottle.data.completed;
                drawLabelLine(g, "Completed", complete, y); y += 16;
                String result = bottle.data.quality;
                g.setColor(!bottle.qualityInspected ? AMBER.darker()
                        : (bottle.qualityPassed ? GREEN : RED));
                g.setFont(new Font("SansSerif", Font.BOLD, 10));
                g.drawString("QC: " + result, 10, y);
            }
            g.dispose();
        }

        private void drawLabelLine(Graphics2D g, String key, String value, int y) {
            g.setFont(new Font("SansSerif", Font.BOLD, 10));
            g.setColor(LINE);
            g.drawString(key + ":", 10, y);
            g.setFont(new Font("SansSerif", Font.PLAIN, 10));
            g.setColor(new Color(30, 40, 50));
            g.drawString(value, 78, y);
        }
    }

    private final class FactoryPanel extends JPanel {
        private static final int DESIGN_W = 1100;
        private static final int DESIGN_H = 820;
        private final int[] stationX = {-145, -110, 0, 110, 145, 0};
        private final int[] stationY = {35, -95, -145, -95, 35, 145};
        private double viewScale = 1.0;
        private double viewOffsetX;
        private double viewOffsetY;

        FactoryPanel() {
            setBackground(new Color(235, 241, 246));
            setPreferredSize(new Dimension(1000, 760));
            setToolTipText("Click a bottle to inspect its digital label.");
            addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    selectBottleAt(e.getX(), e.getY());
                }
            });
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            Graphics2D g = (Graphics2D) graphics.create();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            viewScale = Math.min(getWidth() / (double) DESIGN_W,
                    getHeight() / (double) DESIGN_H);
            viewOffsetX = (getWidth() - DESIGN_W * viewScale) / 2.0;
            viewOffsetY = (getHeight() - DESIGN_H * viewScale) / 2.0;
            g.translate(viewOffsetX, viewOffsetY);
            g.scale(viewScale, viewScale);

            drawFloor(g);
            drawConveyors(g);
            drawPickAndPlaceRobot(g);
            drawPhotoEye(g);
            drawRotaryTable(g);
            drawFiller(g, 385, 82, -23, "LIQUID FILLER 1", CYAN);
            drawFiller(g, 535, 55, 0, "LIQUID FILLER 2", BLUE);
            drawCapLoader(g);
            drawCapper(g);
            drawDownstream(g);
            drawBottles(g);
            drawFlowArrows(g);
            g.dispose();
        }

        private void drawFloor(Graphics2D g) {
            g.setPaint(new GradientPaint(0, 0, new Color(248, 250, 252),
                    0, DESIGN_H, new Color(226, 234, 241)));
            g.fillRect(0, 0, DESIGN_W, DESIGN_H);
            g.setColor(new Color(208, 218, 227));
            g.setStroke(new BasicStroke(1f));
            for (int x = 0; x < DESIGN_W; x += 55) {
                g.drawLine(x, 0, x, DESIGN_H);
            }
            for (int y = 0; y < DESIGN_H; y += 55) {
                g.drawLine(0, y, DESIGN_W, y);
            }
            g.setFont(new Font("SansSerif", Font.PLAIN, 11));
            g.setColor(LINE);
            g.drawString("Live SystemJ workpiece positions | Green: active  Orange: idle/waiting  Red: fault",
                    24, 27);
        }

        private void drawConveyors(Graphics2D g) {
            drawHorizontalConveyor(g, 75, 343, 305, 72, "CONVEYOR A");
            drawVerticalConveyor(g, 515, 503, 80, 177, "CONVEYOR B");
        }

        private void drawHorizontalConveyor(Graphics2D g, int x, int y,
                int width, int height, String label) {
            g.setColor(new Color(83, 94, 103));
            g.fillRoundRect(x, y, width, height, 12, 12);
            g.setColor(new Color(198, 205, 210));
            g.fillRoundRect(x + 4, y + 7, width - 8, height - 14, 9, 9);
            g.setColor(new Color(128, 139, 148));
            for (int xx = x + 13; xx < x + width - 8; xx += 27) {
                g.fillRoundRect(xx, y + 11, 13, height - 22, 7, 7);
            }
            g.setColor(NAVY);
            g.setFont(new Font("SansSerif", Font.BOLD, 11));
            centerText(g, label, x + width / 2, y + height + 17);
        }

        private void drawVerticalConveyor(Graphics2D g, int x, int y,
                int width, int height, String label) {
            g.setColor(new Color(83, 94, 103));
            g.fillRoundRect(x, y, width, height, 12, 12);
            g.setColor(new Color(198, 205, 210));
            g.fillRoundRect(x + 8, y + 4, width - 16, height - 8, 9, 9);
            g.setColor(new Color(128, 139, 148));
            for (int yy = y + 13; yy < y + height - 8; yy += 27) {
                g.fillRoundRect(x + 12, yy, width - 24, 13, 7, 7);
            }
            g.setColor(NAVY);
            g.setFont(new Font("SansSerif", Font.BOLD, 11));
            AffineTransform old = g.getTransform();
            g.rotate(Math.PI / 2, x + width / 2.0, y + height / 2.0);
            centerText(g, label, x + width / 2, y + height / 2 + 4);
            g.setTransform(old);
        }

        private void drawPickAndPlaceRobot(Graphics2D g) {
            g.setColor(new Color(232, 237, 241));
            g.fillRoundRect(22, 286, 64, 51, 8, 8);
            g.setColor(LINE);
            g.drawRoundRect(22, 286, 64, 51, 8, 8);
            for (int i = 0; i < 3; i++) {
                drawMiniBottle(g, 35 + i * 18, 313, false, false,
                        new Color(180, 190, 198));
            }

            drawPickPlaceRobot(g, 168, 190, 237, 248, 330, 326,
                    "BOTTLE LOADER");

            g.setColor(NAVY);
            g.setFont(new Font("SansSerif", Font.BOLD, 11));
            centerText(g, "PICK-AND-PLACE BOTTLE ROBOT", 178, 129);
            g.setFont(new Font("SansSerif", Font.PLAIN, 9));
            centerText(g, "LOADS BOTTLES ONTO THE ROTARY TABLE", 178, 143);
        }

        private void drawPickPlaceRobot(Graphics2D g, int baseX, int baseY,
                int elbowX, int elbowY, int gripX, int gripY, String label) {
            g.setColor(new Color(56, 65, 73));
            g.fillRoundRect(baseX - 27, baseY + 79, 54, 47, 7, 7);
            g.setColor(new Color(143, 153, 161));
            g.fillRoundRect(baseX - 9, baseY + 19, 18, 67, 7, 7);
            g.setStroke(new BasicStroke(17f, BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_ROUND));
            g.setColor(new Color(201, 78, 65));
            g.drawLine(baseX, baseY + 20, elbowX, elbowY);
            g.drawLine(elbowX, elbowY, gripX, gripY);
            g.setColor(new Color(24, 27, 30));
            g.fillOval(baseX - 11, baseY + 9, 22, 22);
            g.fillOval(elbowX - 12, elbowY - 12, 24, 24);
            g.setStroke(new BasicStroke(4f));
            g.drawLine(gripX - 6, gripY, gripX - 13, gripY + 11);
            g.drawLine(gripX + 6, gripY, gripX + 13, gripY + 11);
            g.setStroke(new BasicStroke(1f));
            g.setColor(Color.WHITE);
            g.setFont(new Font("SansSerif", Font.BOLD, 9));
            centerText(g, label, baseX, baseY + 108);
        }

        private void drawPhotoEye(Graphics2D g) {
            int x = 363;
            boolean detected = photoEyeActive;
            g.setColor(new Color(48, 56, 64));
            g.fillRoundRect(x - 10, 335, 20, 20, 5, 5);
            g.fillRoundRect(x - 10, 403, 20, 20, 5, 5);
            g.setColor(detected ? GREEN : RED);
            g.fillOval(x - 5, 340, 10, 10);
            g.fillOval(x - 5, 408, 10, 10);
            g.setColor(new Color(218, 53, 53, detected ? 210 : 85));
            g.setStroke(new BasicStroke(2f));
            g.drawLine(x, 355, x, 403);
            g.setStroke(new BasicStroke(1f));
            g.setColor(NAVY);
            g.setFont(new Font("SansSerif", Font.BOLD, 9));
            centerText(g, "PHOTO EYE", x, 435);
            g.setFont(new Font("SansSerif", Font.PLAIN, 8));
            centerText(g, detected ? "BOTTLE DETECTED" : "CLEAR", x, 446);
        }

        private void drawRotaryTable(Graphics2D g) {
            int cx = 550;
            int cy = 345;
            int r = 174;
            g.setColor(new Color(105, 115, 124, 65));
            g.fillOval(cx - r + 9, cy - r + 12, r * 2, r * 2);
            g.setPaint(new GradientPaint(cx - r, cy - r,
                    new Color(230, 235, 238), cx + r, cy + r,
                    new Color(153, 164, 173)));
            g.fillOval(cx - r, cy - r, r * 2, r * 2);
            g.setColor(new Color(79, 91, 101));
            g.setStroke(new BasicStroke(3f));
            g.drawOval(cx - r, cy - r, r * 2, r * 2);

            g.setColor(new Color(114, 123, 130));
            for (int i = 0; i < 6; i++) {
                int sx = cx + stationX[i];
                int sy = cy + stationY[i];
                g.fillOval(sx - 34, sy - 34, 68, 68);
                g.setColor(new Color(232, 236, 239));
                g.fillOval(sx - 25, sy - 25, 50, 50);
                g.setColor(new Color(114, 123, 130));
            }

            g.setColor(new Color(69, 78, 86));
            g.fillOval(cx - 48, cy - 48, 96, 96);
            g.setColor(new Color(188, 197, 204));
            g.fillOval(cx - 27, cy - 27, 54, 54);
            g.setColor(new Color(77, 88, 98));
            g.fillOval(cx - 9, cy - 9, 18, 18);

            g.setColor(NAVY);
            g.setFont(new Font("SansSerif", Font.BOLD, 13));
            centerText(g, "ROTARY TABLE", cx, cy + 7);

            for (int i = 0; i < 6; i++) {
                int lx = cx + stationX[i];
                int ly = cy + stationY[i];
                g.setColor(new Color(60, 72, 83));
                g.setFont(new Font("SansSerif", Font.BOLD, 9));
                centerText(g, String.valueOf(i + 1), lx, ly + 4);
            }
        }

        private void drawFiller(Graphics2D g, int x, int y, double angle,
                String label, Color liquidColor) {
            AffineTransform old = g.getTransform();
            g.rotate(Math.toRadians(angle), x + 48, y + 55);
            g.setColor(new Color(250, 201, 118));
            g.fillRoundRect(x, y, 96, 74, 12, 12);
            g.setColor(new Color(102, 82, 58));
            g.setStroke(new BasicStroke(2f));
            g.drawRoundRect(x, y, 96, 74, 12, 12);
            g.setColor(liquidColor);
            g.fillRoundRect(x + 13, y + 14, 18, 44, 7, 7);
            g.setColor(NAVY);
            g.setFont(new Font("SansSerif", Font.BOLD, 10));
            centerText(g, label, x + 58, y + 32);
            g.setFont(new Font("SansSerif", Font.PLAIN, 9));
            centerText(g, "DISPENSER", x + 58, y + 48);
            g.setColor(new Color(75, 84, 92));
            g.fillRect(x + 40, y + 74, 16, 35);
            g.setTransform(old);
            g.setStroke(new BasicStroke(1f));
        }

        private void drawCapLoader(Graphics2D g) {
            int x = 760;
            int y = 62;
            g.setColor(new Color(249, 251, 252, 235));
            g.fillRoundRect(x, y, 275, 210, 14, 14);
            g.setColor(new Color(118, 128, 136));
            g.setStroke(new BasicStroke(2f));
            g.drawRoundRect(x, y, 275, 210, 14, 14);
            g.setColor(NAVY);
            g.setFont(new Font("SansSerif", Font.BOLD, 13));
            centerText(g, "CAP LOADER", x + 137, y + 23);

            // Aluminium machine frame and base, simplified from the real unit.
            g.setColor(new Color(137, 147, 154));
            g.fillRoundRect(x + 18, y + 178, 238, 15, 5, 5);
            g.fillRect(x + 26, y + 36, 10, 151);
            g.fillRect(x + 242, y + 36, 10, 151);
            g.fillRect(x + 26, y + 36, 226, 9);

            // Clear vertical lid magazine with a black feed block.
            g.setColor(new Color(194, 222, 230, 150));
            g.fillRoundRect(x + 43, y + 44, 39, 112, 10, 10);
            g.setColor(new Color(77, 89, 98));
            g.drawRoundRect(x + 43, y + 44, 39, 112, 10, 10);
            for (int i = 0; i < 5; i++) {
                g.setColor(new Color(225, 132, 124));
                g.fillOval(x + 48, y + 112 - i * 13, 29, 9);
                g.setColor(new Color(120, 75, 72));
                g.drawOval(x + 48, y + 112 - i * 13, 29, 9);
            }
            g.setColor(new Color(39, 45, 50));
            g.fillRoundRect(x + 36, y + 145, 54, 31, 6, 6);
            drawLid(g, x + 63, y + 161);

            // Horizontal pneumatic slide and cylinder.
            g.setColor(new Color(91, 100, 107));
            g.fillRoundRect(x + 103, y + 91, 132, 12, 5, 5);
            g.setColor(new Color(184, 191, 196));
            g.fillRoundRect(x + 105, y + 67, 100, 21, 7, 7);
            g.setColor(LINE);
            g.drawRoundRect(x + 105, y + 67, 100, 21, 7, 7);

            // Sliding pick head and the arm that presents a lid to station 4.
            g.setColor(new Color(65, 73, 79));
            g.fillRoundRect(x + 204, y + 58, 22, 95, 5, 5);
            g.setColor(new Color(153, 162, 169));
            g.fillRoundRect(x + 196, y + 94, 37, 38, 6, 6);
            g.setColor(new Color(79, 88, 96));
            g.setStroke(new BasicStroke(7f, BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_ROUND));
            g.drawLine(x + 214, y + 132, 704, 230);
            g.setStroke(new BasicStroke(1f));
            drawLid(g, 704, 230);
        }

        private void drawLid(Graphics2D g, int x, int y) {
            g.setColor(new Color(225, 132, 124));
            g.fillOval(x - 13, y - 13, 26, 26);
            g.setColor(new Color(94, 77, 76));
            g.drawOval(x - 13, y - 13, 26, 26);
        }

        private void drawCapper(Graphics2D g) {
            int x = 806;
            int y = 321;
            g.setColor(new Color(250, 201, 118));
            g.fillRoundRect(x, y, 110, 86, 12, 12);
            g.setColor(new Color(100, 80, 55));
            g.setStroke(new BasicStroke(2f));
            g.drawRoundRect(x, y, 110, 86, 12, 12);
            g.setColor(NAVY);
            g.setFont(new Font("SansSerif", Font.BOLD, 12));
            centerText(g, "CAPPER", x + 55, y + 47);
            g.setColor(new Color(58, 65, 71));
            g.fillRect(x - 48, y + 32, 48, 18);
            g.fillRoundRect(x - 61, y + 22, 18, 38, 5, 5);
            g.setStroke(new BasicStroke(1f));
        }

        private void drawDownstream(Graphics2D g) {
            drawHorizontalConveyor(g, 290, 680, 510, 70, "QUALITY SPLITTER");

            drawMachineBox(g, 91, 656, 165, 118, new Color(205, 229, 241),
                    "RECYCLING", "STATION");
            g.setColor(RED);
            g.setStroke(new BasicStroke(5f));
            g.drawLine(290, 715, 257, 715);
            g.setStroke(new BasicStroke(1f));

            drawMachineBox(g, 828, 646, 155, 105, new Color(250, 205, 127),
                    "LABELLER", "PRINT + GLUE");
            g.setColor(GREEN.darker());
            g.setStroke(new BasicStroke(5f));
            g.drawLine(800, 715, 828, 699);
            g.setStroke(new BasicStroke(1f));

            drawMachineBox(g, 828, 762, 155, 49, new Color(210, 218, 224),
                    "BATCH STORAGE", "");

            g.setColor(new Color(95, 105, 114));
            g.setStroke(new BasicStroke(4f));
            g.drawLine(905, 751, 905, 762);
            g.setStroke(new BasicStroke(1f));
        }

        private void drawMachineBox(Graphics2D g, int x, int y, int w, int h,
                Color color, String line1, String line2) {
            g.setColor(new Color(76, 87, 98, 45));
            g.fillRoundRect(x + 6, y + 7, w, h, 13, 13);
            g.setColor(color);
            g.fillRoundRect(x, y, w, h, 13, 13);
            g.setColor(LINE);
            g.setStroke(new BasicStroke(2f));
            g.drawRoundRect(x, y, w, h, 13, 13);
            g.setColor(NAVY);
            g.setFont(new Font("SansSerif", Font.BOLD, 12));
            centerText(g, line1, x + w / 2, y + h / 2 - (line2.length() > 0 ? 4 : -4));
            if (line2.length() > 0) {
                g.setFont(new Font("SansSerif", Font.PLAIN, 10));
                centerText(g, line2, x + w / 2, y + h / 2 + 13);
            }
            g.setStroke(new BasicStroke(1f));
        }

        private int[] position(Bottle b) {
            GuiSnapshot.Bottle d = b.data;
            if (d.position >= 0 && d.position < 6) return new int[]{550 + stationX[d.position], 345 + stationY[d.position]};
            if ("DONE".equals(d.stage)) return new int[]{857 + (int)(d.id % 4) * 27, 789};
            if ("RECOVERED".equals(d.stage)) return new int[]{126 + (int)(d.id % 4) * 28, 731};
            if ("LOADER".equals(d.location)) return new int[]{210, 375};
            if ("LABELLER".equals(d.location)) return new int[]{900, 703};
            if ("RECYCLING".equals(d.location)) return new int[]{275, 714};
            if ("SPLITTER".equals(d.location)) return new int[]{613, 714};
            return "LOADED".equals(d.stage) ? new int[]{320, 375} : new int[]{555, 590};
        }

        private void drawBottles(Graphics2D g) {
            for (Bottle b : liveBottles.values()) {
                int[] p = position(b); drawBottle(g, b, p[0], p[1], selectedBottle == b);
            }
            String[] machines = {"LOADER", "CONVEYOR", "ROTARY_TABLE", "FILLER1", "FILLER2", "LID_LOADER", "LID_CAPPER", "SPLITTER", "RECYCLING", "LABELLER", "BATCH_STORAGE"};
            int[][] lamps = {{167,300},{300,405},{550,345},{440,75},{615,55},{995,65},{875,340},{700,748},{230,675},{967,665},{967,782}};
            for (int i = 0; i < machines.length; i++) {
                String state = snapshot == null ? "UNKNOWN" : snapshot.stations.getOrDefault(machines[i], "IDLE");
                Color light = state.contains("FAULT") ? RED : state.contains("WORKING") || state.contains("ACTIVE") || state.contains("RUNNING") ? GREEN : AMBER;
                g.setColor(light); g.fillOval(lamps[i][0], lamps[i][1], 14, 14);
                g.setColor(LINE); g.drawOval(lamps[i][0], lamps[i][1], 14, 14);
            }
        }

        private void drawBottle(Graphics2D g, Bottle bottle, int x, int y,
                boolean selected) {
            if (selected) {
                g.setColor(new Color(255, 200, 52, 130));
                g.fillOval(x - 27, y - 34, 54, 63);
            }
            g.setColor(Color.WHITE);
            g.fillRoundRect(x - 15, y - 18, 30, 39, 9, 9);
            g.setColor(new Color(76, 91, 105));
            g.setStroke(new BasicStroke(2f));
            g.drawRoundRect(x - 15, y - 18, 30, 39, 9, 9);
            g.fillRect(x - 8, y - 25, 16, 8);

            if (bottle.liquid1Added) {
                g.setColor(new Color(63, 185, 212, 205));
                int h1 = bottle.liquid2Added ? 12 : 22;
                g.fillRoundRect(x - 11, y + 17 - h1, 22, h1, 5, 5);
            }
            if (bottle.liquid2Added) {
                g.setColor(new Color(58, 113, 193, 205));
                g.fillRoundRect(x - 11, y - 7, 22, 12, 4, 4);
            }
            if (bottle.lidPlaced) {
                g.setColor(new Color(221, 111, 101));
                g.fillRoundRect(x - 10, y - 29, 20, 6, 3, 3);
            }
            if (bottle.capped) {
                g.setColor(new Color(176, 66, 58));
                g.drawLine(x - 8, y - 27, x + 8, y - 27);
            }
            if (bottle.labelPrinted) {
                g.setColor(new Color(250, 236, 178));
                g.fillRect(x - 11, y - 4, 22, 11);
                g.setColor(NAVY);
                g.setFont(new Font("SansSerif", Font.BOLD, 7));
                centerText(g, "LABEL", x, y + 4);
            }
            g.setStroke(new BasicStroke(1f));
        }

        private void drawMiniBottle(Graphics2D g, int x, int y,
                boolean filled, boolean capped, Color liquid) {
            g.setColor(Color.WHITE);
            g.fillRoundRect(x - 7, y - 10, 14, 22, 4, 4);
            if (filled) {
                g.setColor(liquid);
                g.fillRoundRect(x - 5, y, 10, 9, 2, 2);
            }
            g.setColor(LINE);
            g.drawRoundRect(x - 7, y - 10, 14, 22, 4, 4);
            g.fillRect(x - 4, y - 15, 8, 5);
            if (capped) {
                g.setColor(RED);
                g.fillRect(x - 5, y - 17, 10, 3);
            }
        }

        private void drawFlowArrows(Graphics2D g) {
            g.setColor(new Color(33, 112, 161));
            drawArrow(g, 255, 328, 335, 328);
            drawArrow(g, 611, 650, 611, 674);
            g.setColor(RED);
            drawArrow(g, 338, 666, 250, 666);
            g.setColor(GREEN.darker());
            drawArrow(g, 770, 666, 826, 666);


        }

        private void drawArrow(Graphics2D g, int x1, int y1, int x2, int y2) {
            g.setStroke(new BasicStroke(4f, BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_ROUND));
            g.drawLine(x1, y1, x2, y2);
            double angle = Math.atan2(y2 - y1, x2 - x1);
            Path2D head = new Path2D.Double();
            head.moveTo(x2, y2);
            head.lineTo(x2 - 12 * Math.cos(angle - Math.PI / 6),
                    y2 - 12 * Math.sin(angle - Math.PI / 6));
            head.lineTo(x2 - 12 * Math.cos(angle + Math.PI / 6),
                    y2 - 12 * Math.sin(angle + Math.PI / 6));
            head.closePath();
            g.fill(head);
            g.setStroke(new BasicStroke(1f));
        }

        private void selectBottleAt(int screenX, int screenY) {
            double x = (screenX - viewOffsetX) / viewScale, y = (screenY - viewOffsetY) / viewScale;
            double best = 32;
            for (Bottle b : liveBottles.values()) {
                int[] p = position(b); double distance = Math.hypot(x - p[0], y - p[1]);
                if (distance < best) { best = distance; selectedId = b.data.id; }
            }
            refreshView();
            if (selectedBottle != null) labelPopup.show(this, screenX, screenY);
        }
    }

    private static void centerText(Graphics2D g, String text, int centerX, int baseY) {
        FontMetrics metrics = g.getFontMetrics();
        g.drawString(text, centerX - metrics.stringWidth(text) / 2, baseY);
    }

    /**
     * A vertical scrolling panel whose width always follows its viewport.
     * This prevents long live values or CardLayout children from making the
     * right-side control panel wider than the visible window.
     */
    private static final class VerticalScrollablePanel extends JPanel
            implements Scrollable {

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return getPreferredSize();
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect,
                int orientation, int direction) {
            return 14;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect,
                int orientation, int direction) {
            return Math.max(14, visibleRect.height - 28);
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return true;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return false;
        }
    }

    private static final class Bottle {
        final GuiSnapshot.Bottle data;
        final String productName, productId, batchId;
        final int liquid1Percent, liquid2Percent;
        final boolean liquid1Added, liquid2Added, lidPlaced, capped, qualityInspected, qualityPassed, labelPrinted;
        Bottle(GuiSnapshot.Bottle data) {
            this.data = data; productName = data.product; productId = data.productId; batchId = "B" + data.batch;
            liquid1Percent = data.one; liquid2Percent = data.two;
            liquid1Added = data.filled > 0 && data.one > 0;
            liquid2Added = data.filled > data.size * data.one / 100 && data.two > 0;
            lidPlaced = data.lidded; capped = data.capped;
            qualityInspected = !"PENDING".equals(data.quality); qualityPassed = "PASS".equals(data.quality);
            labelPrinted = data.labelled;
        }
        String serialText() { return data.serial; }
        String shortId() { return data.serial; }
    }

    private static void useSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
            // Swing will use its cross-platform look and feel.
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            useSystemLookAndFeel();
            new A1_GUI().setVisible(true);
        });
    }
}
