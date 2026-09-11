import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/** Exercises Swing actions and renders the actual form without a visible window. */
public final class PosUiTest {
    private static PosWindow window;
    private static java.util.List<Component> components(Container parent) {
        java.util.List<Component> all = new ArrayList<Component>();
        for (Component c : parent.getComponents()) {
            all.add(c);
            if (c instanceof Container) all.addAll(components((Container) c));
        }
        return all;
    }
    private static JButton button(String title) {
        for (Component c : components(window)) {
            if (c instanceof JButton && title.equals(((JButton) c).getText())) return (JButton) c;
        }
        throw new AssertionError("Missing button " + title);
    }
    private static JTable table() {
        for (Component c : components(window)) if (c instanceof JTable) return (JTable) c;
        throw new AssertionError("Missing batch table");
    }
    private static void check(boolean value, String message) {
        if (!value) throw new AssertionError(message);
    }
    private static void render(String path) throws Exception {
        window.addNotify(); window.validate();
        Container content = window.getContentPane();
        BufferedImage image = new BufferedImage(content.getWidth(), content.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        content.printAll(graphics); graphics.dispose();
        ImageIO.write(image, "png", new File(path));
    }
    public static void main(String[] args) throws Exception {
        try {
            SwingUtilities.invokeAndWait(() -> {
                window = new PosWindow();
                check(!button("Submit to Production").isEnabled(), "Empty order can be submitted");
                button("Add Batch").doClick(); button("Add Batch").doClick();
                table().setRowSelectionInterval(0, 0); button("Remove Selected").doClick();
                check(table().getRowCount() == 1 && "B1".equals(table().getValueAt(0, 0)), "Remove/renumber failed");
                button("Add Batch").doClick(); button("Add Batch").doClick();
                check(table().getRowCount() == 3, "Multiple batches missing");
                button("Submit to Production").doClick();
                check(PosBridge.pending().totalBatches == 3, "Submitted payload missing batches");
                check(!button("Add Batch").isEnabled() && !button("Submit to Production").isEnabled()
                        && !button("New Order").isEnabled(), "Production controls not locked");
                java.util.List<PosOrderStatus.BatchProgress> batches = Arrays.asList(
                        new PosOrderStatus.BatchProgress(1, 6, 10, 0, "Producing 6/10"),
                        new PosOrderStatus.BatchProgress(2, 0, 10, 0, "Queued"),
                        new PosOrderStatus.BatchProgress(3, 0, 10, 0, "Queued"));
                PosBridge.acceptFeedback(new PosOrderStatus(PosBridge.pending().orderId, 1, "In Production",
                        "Production launched for 3 batches.", batches));
            });
            Thread.sleep(350);
            SwingUtilities.invokeAndWait(() -> {
                check("Producing 6/10".equals(table().getValueAt(0, 6)), "Feedback not displayed");
                try { render("bin/pos-preview.png"); } catch (Exception e) { throw new RuntimeException(e); }
                javax.swing.Timer dismiss = new javax.swing.Timer(100, e -> {
                    for (Window w : Window.getWindows()) if (w instanceof JDialog) w.dispose();
                });
                dismiss.start();
                java.util.List<PosOrderStatus.BatchProgress> batches = Arrays.asList(
                        new PosOrderStatus.BatchProgress(1, 10, 10, 0, "Completed"),
                        new PosOrderStatus.BatchProgress(2, 10, 10, 0, "Completed"),
                        new PosOrderStatus.BatchProgress(3, 10, 10, 0, "Completed"));
                PosBridge.acceptFeedback(new PosOrderStatus(PosBridge.pending().orderId, 2, "Completed",
                        "All batches completed. Registered Customer, your purchase order is ready.", batches));
            });
            Thread.sleep(500);
            SwingUtilities.invokeAndWait(() -> {
                check(button("New Order").isEnabled(), "Completion did not unlock New Order");
                check("Completed".equals(table().getValueAt(2, 6)), "Final batch not completed in GUI");
                button("New Order").doClick();
                check(table().getRowCount() == 0 && button("Add Batch").isEnabled(), "New draft did not reset");
                window.dispose();
            });
            System.out.println("POS UI TEST PASSED; preview: bin/pos-preview.png");
            System.exit(0);
        } catch (Throwable error) {
            error.printStackTrace(); System.exit(1);
        }
    }
}
