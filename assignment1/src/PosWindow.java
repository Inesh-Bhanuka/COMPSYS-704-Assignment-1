import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/** Customer POS, laid out like Figure 9. All Swing state stays on the EDT. */
public final class PosWindow extends JFrame {
    private final JTextField orderId = new JTextField();
    private final JTextField customer = new JTextField("Registered Customer");
    private final JTextField product = new JTextField("Custom Product");
    private final JComboBox<String> bottle = new JComboBox<String>(new String[] {"100 mL", "200 mL", "250 mL", "500 mL"});
    private final JSpinner liquidOne = new JSpinner(new SpinnerNumberModel(50, 0, 100, 1));
    private final JSpinner liquidTwo = new JSpinner(new SpinnerNumberModel(50, 0, 100, 1));
    private final JSpinner quantity = new JSpinner(new SpinnerNumberModel(10, 1, 10000, 1));
    private final JButton add = new JButton("Add Batch");
    private final JButton remove = new JButton("Remove Selected");
    private final JButton submit = new JButton("Submit to Production");
    private final JButton newOrder = new JButton("New Order");
    private final JLabel status = new JLabel("Draft");
    private final JLabel message = new JLabel("Add one or more product batches.");
    private final DefaultTableModel rows = new DefaultTableModel(
            new String[] {"Batch", "Product", "Bottle", "Liquid 1", "Liquid 2", "Quantity", "Status"}, 0) {
        public boolean isCellEditable(int row, int column) { return false; }
    };
    private final JTable table = new JTable(rows);
    private final List<PosOrderRequest.ProductBatch> draft = new ArrayList<PosOrderRequest.ProductBatch>();
    private boolean submitted, notified;
    private long lastRevision = -1;

    public PosWindow() {
        super("Purchase Order System - Group Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1000, 650));
        setSize(1460, 880);
        setLocationRelativeTo(null);
        JPanel root = new JPanel(new BorderLayout(16, 20));
        root.setBorder(BorderFactory.createEmptyBorder(14, 18, 14, 18));
        setContentPane(root);
        JLabel heading = new JLabel(getTitle(), SwingConstants.CENTER);
        heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
        root.add(heading, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createTitledBorder("Purchase Order"));
        form.setPreferredSize(new Dimension(435, 600));
        JPanel fields = new JPanel(new GridBagLayout());
        orderId.setEditable(false);
        orderId.setBorder(null);
        orderId.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
        bottle.setSelectedItem("250 mL");
        field(fields, 0, "Order ID", orderId);
        field(fields, 1, "Customer", customer);
        field(fields, 2, "Product", product);
        field(fields, 3, "Bottle size", bottle);
        field(fields, 4, "Liquid 1 (%)", liquidOne);
        field(fields, 5, "Liquid 2 (%)", liquidTwo);
        field(fields, 6, "Batch quantity", quantity);
        GridBagConstraints button = new GridBagConstraints();
        button.gridy = 7; button.gridwidth = 2; button.fill = GridBagConstraints.HORIZONTAL;
        button.insets = new Insets(18, 8, 0, 8);
        fields.add(add, button);
        GridBagConstraints centered = new GridBagConstraints();
        centered.weightx = 1; centered.fill = GridBagConstraints.HORIZONTAL;
        form.add(fields, centered);

        table.setRowHeight(38);
        table.setFillsViewportHeight(true);
        table.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        table.getTableHeader().setFont(table.getFont());
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getColumnModel().getColumn(0).setPreferredWidth(55);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(190);
        JPanel batches = new JPanel(new BorderLayout());
        batches.setBorder(BorderFactory.createTitledBorder("Order Batches"));
        batches.add(new JScrollPane(table));
        JPanel middle = new JPanel(new BorderLayout(16, 0));
        middle.add(form, BorderLayout.WEST);
        middle.add(batches, BorderLayout.CENTER);
        root.add(middle, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout(0, 18));
        JPanel summary = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 0));
        summary.add(new JLabel("Order status:")); summary.add(status); summary.add(message);
        status.setFont(status.getFont().deriveFont(Font.BOLD));
        bottom.add(summary, BorderLayout.NORTH);
        JPanel actions = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 12, 0));
        actions.add(remove); actions.add(submit); actions.add(newOrder);
        bottom.add(actions, BorderLayout.SOUTH);
        root.add(bottom, BorderLayout.SOUTH);

        applyFont(root, new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        heading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
        status.setFont(status.getFont().deriveFont(Font.BOLD));
        orderId.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
        customer.setDisabledTextColor(java.awt.Color.GRAY);
        product.setDisabledTextColor(java.awt.Color.GRAY);
        for (JSpinner spinner : new JSpinner[] {liquidOne, liquidTwo, quantity}) {
            ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setDisabledTextColor(java.awt.Color.GRAY);
        }

        add.addActionListener(e -> addBatch());
        remove.addActionListener(e -> removeBatch());
        submit.addActionListener(e -> submitOrder());
        newOrder.addActionListener(e -> resetOrder());
        table.getSelectionModel().addListSelectionListener(e -> updateButtons());
        resetOrder();
        Timer feedbackTimer = new Timer(150, e -> refreshFeedback());
        feedbackTimer.start();
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent e) { feedbackTimer.stop(); }
        });
    }

    private void applyFont(java.awt.Component component, Font font) {
        component.setFont(font);
        if (component instanceof java.awt.Container) {
            for (java.awt.Component child : ((java.awt.Container) component).getComponents()) applyFont(child, font);
        }
    }

    private void field(JPanel panel, int row, String label, JComponent input) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = row; c.anchor = GridBagConstraints.WEST; c.insets = new Insets(6, 8, 6, 8);
        panel.add(new JLabel(label), c);
        c.gridx = 1; c.weightx = 1; c.fill = GridBagConstraints.HORIZONTAL;
        input.setPreferredSize(new Dimension(280, 30));
        panel.add(input, c);
    }

    private void addBatch() {
        try {
            liquidOne.commitEdit(); liquidTwo.commitEdit(); quantity.commitEdit();
            int size = Integer.parseInt(((String) bottle.getSelectedItem()).split(" ")[0]);
            PosOrderRequest.ProductBatch b = new PosOrderRequest.ProductBatch(product.getText(), size,
                    (Integer) liquidOne.getValue(), (Integer) liquidTwo.getValue(), (Integer) quantity.getValue());
            draft.add(b);
            rows.addRow(new Object[] {"B" + draft.size(), b.productName, b.bottleSizeMl + " mL",
                    b.liquidOne + ".0%", b.liquidTwo + ".0%", b.quantity, "Draft"});
            message.setText(draft.size() + " batches ready to submit.");
            updateButtons();
        } catch (Exception e) { showError(e); }
    }

    private void removeBatch() {
        int row = table.getSelectedRow();
        if (submitted || row < 0) return;
        draft.remove(row); rows.removeRow(row);
        for (int i = 0; i < rows.getRowCount(); i++) rows.setValueAt("B" + (i + 1), i, 0);
        message.setText(draft.size() + " batches ready to submit.");
        updateButtons();
    }

    private void submitOrder() {
        try {
            PosBridge.submit(new PosOrderRequest(orderId.getText(), customer.getText(), draft));
            submitted = true;
            status.setText("Submitting");
            message.setText("Waiting for the manufacturing system to accept the order.");
            for (int i = 0; i < rows.getRowCount(); i++) rows.setValueAt("Queued", i, 6);
            updateButtons();
        } catch (Exception e) { showError(e); }
    }

    private void resetOrder() {
        if (submitted && !notified) return;
        submitted = false; notified = false; lastRevision = -1;
        orderId.setText(PosOrderRequest.newOrderId());
        orderId.setToolTipText(orderId.getText());
        draft.clear(); rows.setRowCount(0);
        status.setText("Draft"); message.setText("Add one or more product batches.");
        updateButtons();
    }

    private void updateButtons() {
        customer.setEnabled(!submitted); product.setEnabled(!submitted); bottle.setEnabled(!submitted);
        liquidOne.setEnabled(!submitted); liquidTwo.setEnabled(!submitted); quantity.setEnabled(!submitted);
        add.setEnabled(!submitted); remove.setEnabled(!submitted && table.getSelectedRow() >= 0);
        submit.setEnabled(!submitted && !draft.isEmpty());
        newOrder.setEnabled(!submitted || notified);
    }

    private void refreshFeedback() {
        PosOrderStatus feedback = PosBridge.latest();
        if (!submitted || feedback == null || !feedback.orderId.equals(orderId.getText())
                || feedback.revision <= lastRevision) return;
        lastRevision = feedback.revision;
        status.setText(feedback.status); message.setText(feedback.message);
        for (int i = 0; i < Math.min(rows.getRowCount(), feedback.batches.size()); i++) {
            rows.setValueAt(feedback.batches.get(i).status, i, 6);
        }
        if ("Reset".equals(feedback.status)) { notified = true; updateButtons(); }
        if (feedback.isComplete() && !notified) {
            notified = true; updateButtons();
            java.awt.Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, feedback.message + "\nOrder: " + feedback.orderId,
                    "Purchase order completed", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void showError(Exception e) {
        JOptionPane.showMessageDialog(this, e instanceof java.text.ParseException
                ? "Enter a whole number within the field's range." : e.getMessage(),
                "Check purchase order", JOptionPane.WARNING_MESSAGE);
    }
}
