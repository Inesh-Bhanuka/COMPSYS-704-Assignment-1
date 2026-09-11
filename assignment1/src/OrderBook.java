import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Controller-owned production plan. No GUI access or hardcoded customer orders. */
public final class OrderBook {
    private static PurchaseOrder active;
    private static PosOrderRequest request;
    private static PosOrderStatus feedback;
    private static final Set<String> seenOrders = new HashSet<String>();
    private static final Map<Long, WorkpieceTwin> issued = new LinkedHashMap<Long, WorkpieceTwin>();
    private static final Set<Long> delivered = new HashSet<Long>();
    private static final Set<Long> recovered = new HashSet<Long>();
    private static long nextOrder = 1, nextBatch = 1, nextBottle = 1, revision;
    private static int batchIndex;

    private OrderBook() { }

    /** Repeated signal levels acknowledge the same order without producing duplicates. */
    public static synchronized void accept(PosOrderRequest incoming) {
        if (incoming == null || seenOrders.contains(incoming.orderId)) return;
        // A busy controller retains its current plan. The request stays asserted until accepted.
        if (active != null && active.status() != POStatus.COMPLETE) return;
        try {
            incoming.validate();
        } catch (IllegalArgumentException e) {
            feedback = new PosOrderStatus(incoming.orderId, ++revision, "Rejected", e.getMessage(),
                    new ArrayList<PosOrderStatus.BatchProgress>());
            return;
        }
        seenOrders.add(incoming.orderId);
        request = incoming;
        active = new PurchaseOrder(nextOrder++, incoming.orderId, incoming.customerName);
        for (PosOrderRequest.ProductBatch b : incoming.batches) {
            active.add(new Batch(nextBatch++, b.productName, new Recipe(b.liquidOne, b.liquidTwo, 5),
                    b.bottleSizeMl, b.quantity));
        }
        issued.clear();
        delivered.clear();
        recovered.clear();
        batchIndex = 0;
        active.start();
        GuiSupervisor.orderAccepted();
        updateFeedback();
        System.out.println("[SC] Accepted " + incoming.orderId + " for " + incoming.customerName
                + " (" + incoming.totalBatches + " batches).");
    }

    /** Reserve a bottle. Each batch drains completely before the next recipe starts. */
    public static synchronized WorkpieceTwin nextBottle() {
        if (active == null || active.status() == POStatus.COMPLETE) return null;
        Batch b = active.batches().get(batchIndex);
        if (b.isComplete()) {
            batchIndex++;
            if (batchIndex == active.batches().size()) return null;
            b = active.batches().get(batchIndex);
        }
        // Recovered rejects free a slot for a replacement, never a delivered count.
        if (b.workpieces().size() - b.recovered() >= b.target) return null;
        WorkpieceTwin w = new WorkpieceTwin(nextBottle++, b.id, b.productName, b.sizeMl, b.recipe);
        GuiSupervisor.prepare(w, b.recovered() > 0 && b.workpieces().size() >= b.target);
        b.add(w);
        issued.put(w.id, w);
        updateFeedback();
        return w;
    }

    public static synchronized void delivered(WorkpieceTwin w) {
        if (w == null || issued.get(w.id) != w || w.isRejected()
                || w.status() != WorkpieceStatus.DONE || !delivered.add(w.id)) return;
        active.refresh();
        updateFeedback();
    }

    public static synchronized void recycled(WorkpieceTwin w) {
        if (w == null || issued.get(w.id) != w || !w.isRecovered() || !recovered.add(w.id)) return;
        updateFeedback();
    }

    public static synchronized void resetAfterDrain() {
        if (request != null && feedback != null) feedback = new PosOrderStatus(request.orderId, ++revision,
                "Reset", "Production reset after admitted bottles finished. Create a new purchase order.", feedback.batches);
        active = null;
        issued.clear(); delivered.clear(); recovered.clear();
    }

    public static synchronized PurchaseOrder purchaseOrder() { return active; }
    public static synchronized PosOrderStatus feedback() { return feedback; }

    private static void updateFeedback() {
        List<PosOrderStatus.BatchProgress> progress = new ArrayList<PosOrderStatus.BatchProgress>();
        for (Batch b : active.batches()) {
            String state = b.isComplete() ? "Completed" : b.workpieces().isEmpty() ? "Queued"
                    : "Producing " + b.accepted() + "/" + b.target;
            if (b.recovered() > 0 && !b.isComplete()) state += " (" + b.recovered() + " recycled)";
            progress.add(new PosOrderStatus.BatchProgress(b.id, b.accepted(), b.target, b.recovered(), state));
        }
        boolean complete = active.status() == POStatus.COMPLETE;
        feedback = new PosOrderStatus(request.orderId, ++revision, complete ? "Completed" : "In Production",
                complete ? "All batches completed. " + request.customerName + ", your purchase order is ready."
                         : "Production launched for " + request.totalBatches + " batches.", progress);
    }
}
