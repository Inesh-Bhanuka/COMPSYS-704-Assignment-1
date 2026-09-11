import java.io.*;
import java.util.*;

/** Standalone assertions for the order boundary and production accounting. */
public final class PosModelTest {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Invalid order was accepted");
    }

    private static void finish(WorkpieceTwin w) {
        w.dispensed(w.nextVolumeMl());
        w.dispensed(w.nextVolumeMl());
        w.lid(); w.cap(); w.completed(Machine.LABELLER, "label printed");
        w.arrived(Machine.BATCH_STORAGE); w.seal();
        BatchStore.shared().store(w);
        OrderBook.delivered(w);
    }

    public static void main(String[] args) throws Exception {
        invalid(() -> new PosOrderRequest.ProductBatch("", 250, 50, 50, 1));
        invalid(() -> new PosOrderRequest.ProductBatch("X", 250, 50, 40, 1));
        invalid(() -> new PosOrderRequest.ProductBatch("X", 250, 50, 60, 1));
        invalid(() -> new PosOrderRequest.ProductBatch("X", 250, -1, 101, 1));
        invalid(() -> new PosOrderRequest.ProductBatch("X", 250, 50, 50, 0));
        invalid(() -> new PosOrderRequest.ProductBatch("X", 123, 50, 50, 1));
        List<PosOrderRequest.ProductBatch> batches = new ArrayList<PosOrderRequest.ProductBatch>();
        invalid(() -> new PosOrderRequest("x", "Customer", batches));
        batches.add(new PosOrderRequest.ProductBatch("Citrus", 250, 33, 67, 2));
        batches.add(new PosOrderRequest.ProductBatch("Water", 100, 0, 100, 1));
        invalid(() -> new PosOrderRequest("x", " ", batches));
        PosOrderRequest order = new PosOrderRequest(PosOrderRequest.newOrderId(), "Test Customer", batches);
        batches.clear();
        check(order.totalBatches == 2 && order.batches.size() == 2, "Request must copy draft");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        new ObjectOutputStream(bytes).writeObject(order);
        PosOrderRequest copy = (PosOrderRequest) new ObjectInputStream(
                new ByteArrayInputStream(bytes.toByteArray())).readObject();
        check(copy.orderId.equals(order.orderId) && copy.batches.get(0).productName.equals("Citrus"),
                "Signal serialization lost order details");
        PosBridge.submit(order);
        OrderBook.accept(copy);
        PurchaseOrder active = OrderBook.purchaseOrder();
        OrderBook.accept(copy);
        check(OrderBook.purchaseOrder() == active, "Repeated request restarted order");
        WorkpieceTwin first = OrderBook.nextBottle();
        WorkpieceTwin reject = OrderBook.nextBottle();
        check(OrderBook.nextBottle() == null, "Next batch started before current one finished");
        finish(first);
        check(first.filledMl() == 250, "Percentage rounding left bottle short");
        check(new LabelData(first).product.equals("Citrus"), "Product name missing from label");
        OrderBook.delivered(first);
        check(OrderBook.feedback().batches.get(0).accepted == 1, "Duplicate completion counted twice");
        reject.reject(Machine.FILLER, "test reject");
        reject.returnToCollector(); reject.seal(); OrderBook.recycled(reject);
        check(!OrderBook.feedback().isComplete(), "Recycling completed an unfilled order");
        WorkpieceTwin remake = OrderBook.nextBottle();
        check(remake != null && remake.batchId == first.batchId && remake.id != reject.id, "Missing replacement");
        finish(remake);
        check(!OrderBook.feedback().isComplete(), "Order completed before final batch");
        WorkpieceTwin second = OrderBook.nextBottle();
        check(second.batchId != first.batchId && second.nextVolumeMl() == 0, "Wrong next batch recipe");
        finish(second);
        PosOrderStatus complete = OrderBook.feedback();
        check(complete.isComplete() && second.filledMl() == 100, "All batches must complete");
        PosBridge.acceptFeedback(complete);
        PosBridge.acceptFeedback(new PosOrderStatus(order.orderId, complete.revision - 1,
                "In Production", "stale", complete.batches));
        check(PosBridge.latest().isComplete(), "Stale status undid completion");
        PosOrderRequest next = new PosOrderRequest(PosOrderRequest.newOrderId(), "Second Customer",
                Collections.singletonList(new PosOrderRequest.ProductBatch("Next", 200, 100, 0, 1)));
        PosBridge.submit(next); OrderBook.accept(next);
        PosBridge.acceptFeedback(complete);
        check(PosBridge.latest() == null, "Previous order status leaked into next order");
        WorkpieceTwin nextBottle = OrderBook.nextBottle();
        check(nextBottle.id > second.id && nextBottle.batchId > second.batchId, "Bottle or batch ID reused");
        finish(nextBottle);
        OrderBook.accept(order);
        check(OrderBook.purchaseOrder().orderId.equals(next.orderId), "Old request replayed");
        System.out.println("POS MODEL TEST PASSED");
    }
}
