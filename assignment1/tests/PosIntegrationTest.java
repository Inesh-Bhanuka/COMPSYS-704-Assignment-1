import java.util.*;

/** Runs the real 29-CD XML: GUI mailbox -> POS signals -> plant -> feedback signals. */
public final class PosIntegrationTest {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private static PosOrderStatus awaitOrder(PosOrderRequest request, int seconds) throws Exception {
        long deadline = System.currentTimeMillis() + seconds * 1000L;
        PosOrderStatus last = null;
        while (System.currentTimeMillis() < deadline) {
            PosOrderStatus now = PosBridge.latest();
            if (now != null && now.orderId.equals(request.orderId)) {
                if (last == null || now.revision != last.revision) {
                    System.out.println("[TEST] " + now.status + " " + now.batches.stream()
                            .map(b -> b.status).collect(java.util.stream.Collectors.joining(" | ")));
                    last = now;
                }
                if (now.isComplete()) return now;
            }
            Thread.sleep(100);
        }
        throw new AssertionError("Timed out waiting for signal feedback: " + request.orderId
                + " last=" + (last == null ? "none" : last.status));
    }

    public static void main(String[] args) {
        try {
            System.setProperty("pos.headless", "true");
            Thread plant = new Thread(() -> com.systemj.SystemJRunner.main(new String[] {"sysj/abs.xml"}));
            plant.setDaemon(true); plant.start();
            PosOrderRequest first = new PosOrderRequest(PosOrderRequest.newOrderId(), "Signal Test Customer",
                    Arrays.asList(new PosOrderRequest.ProductBatch("Citrus", 250, 33, 67, 10),
                            new PosOrderRequest.ProductBatch("Liquid Two", 100, 0, 100, 10),
                            new PosOrderRequest.ProductBatch("Liquid One", 500, 100, 0, 10)));
            PosBridge.submit(first);
            PosOrderStatus completed = awaitOrder(first, 600);
            check(completed.batches.size() == 3, "Missing batch feedback");
            for (PosOrderStatus.BatchProgress b : completed.batches) {
                check(b.accepted == 10 && b.recycled == 0, "Incorrect batch quantity");
                check(BatchStore.shared().held(b.batchId) == 10, "Feedback disagrees with storage");
                for (WorkpieceTwin w : BatchStore.shared().shelf(b.batchId)) {
                    check(w.filledMl() == w.sizeMl && w.isLabelled(), "Bottle not full and labelled");
                }
            }
            for (int i = 1; i < completed.batches.size(); i++) {
                long previousFinished = 0;
                for (WorkpieceTwin w : BatchStore.shared().shelf(completed.batches.get(i - 1).batchId)) {
                    previousFinished = Math.max(previousFinished, w.lastEvent().tick);
                }
                WorkpieceTwin firstInBatch = BatchStore.shared().shelf(completed.batches.get(i).batchId).get(0);
                check(firstInBatch.history().get(0).tick >= previousFinished, "Batch recipes overlapped");
            }
            check(TwinRegistry.shared().all().size() == 30, "Signal repeats duplicated production");
            PosOrderRequest second = new PosOrderRequest(PosOrderRequest.newOrderId(), "Returning Customer",
                    Collections.singletonList(new PosOrderRequest.ProductBatch("Second Order", 200, 50, 50, 1)));
            PosBridge.submit(second);
            PosOrderStatus next = awaitOrder(second, 120);
            check(next.batches.get(0).batchId > completed.batches.get(2).batchId, "Batch IDs reused");
            check(BatchStore.shared().total() == 31, "Second order damaged previous storage");
            TwinAudit.report();
            System.out.println("POS INTEGRATION TEST PASSED: 30 bottles across 3 batches, then a second order.");
            System.exit(0);
        } catch (Throwable error) {
            error.printStackTrace(); System.exit(1);
        }
    }
}
