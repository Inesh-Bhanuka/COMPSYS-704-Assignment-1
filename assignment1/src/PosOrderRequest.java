import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/** Immutable valued-signal payload from the trusted customer session to the plant. */
public final class PosOrderRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    public final String orderId, customerName;
    public final int totalBatches;
    public final List<ProductBatch> batches;

    public static String newOrderId() { return "PO-" + UUID.randomUUID().toString(); }

    public PosOrderRequest(String orderId, String customerName, List<ProductBatch> batches) {
        this.orderId = required(orderId, "Order ID");
        this.customerName = required(customerName, "Customer name");
        if (batches == null || batches.isEmpty()) {
            throw new IllegalArgumentException("Add at least one product batch.");
        }
        this.batches = Collections.unmodifiableList(new ArrayList<ProductBatch>(batches));
        this.totalBatches = this.batches.size();
        validate();
    }

    /** Validate again at the controller boundary, including deserialized input. */
    public void validate() {
        required(orderId, "Order ID");
        required(customerName, "Customer name");
        if (batches == null || batches.isEmpty() || totalBatches != batches.size()) {
            throw new IllegalArgumentException("The total batch count must match the order.");
        }
        for (ProductBatch batch : batches) {
            if (batch == null) throw new IllegalArgumentException("A batch is missing.");
            batch.validate();
        }
    }

    private static String required(String value, String name) {
        if (value == null || value.trim().isEmpty()) throw new IllegalArgumentException(name + " is required.");
        return value.trim();
    }

    public static final class ProductBatch implements Serializable {
        private static final long serialVersionUID = 1L;
        public final String productName;
        public final int bottleSizeMl, liquidOne, liquidTwo, quantity;

        public ProductBatch(String productName, int bottleSizeMl, int liquidOne, int liquidTwo, int quantity) {
            this.productName = required(productName, "Product name");
            this.bottleSizeMl = bottleSizeMl;
            this.liquidOne = liquidOne;
            this.liquidTwo = liquidTwo;
            this.quantity = quantity;
            validate();
        }

        public void validate() {
            required(productName, "Product name");
            if (bottleSizeMl != 100 && bottleSizeMl != 200 && bottleSizeMl != 250 && bottleSizeMl != 500) {
                throw new IllegalArgumentException("Choose a 100, 200, 250 or 500 mL bottle.");
            }
            if (liquidOne < 0 || liquidOne > 100 || liquidTwo < 0 || liquidTwo > 100
                    || liquidOne + liquidTwo != 100) {
                throw new IllegalArgumentException("Liquid 1 and Liquid 2 must add up to 100%.");
            }
            if (quantity < 1 || quantity > 10000) {
                throw new IllegalArgumentException("Batch quantity must be between 1 and 10,000.");
            }
        }
    }
}
