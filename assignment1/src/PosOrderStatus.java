import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Complete immutable feedback snapshot, repeated across asynchronous ticks. */
public final class PosOrderStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    public final String orderId, status, message;
    public final long revision;
    public final List<BatchProgress> batches;

    public PosOrderStatus(String orderId, long revision, String status, String message, List<BatchProgress> batches) {
        this.orderId = orderId;
        this.revision = revision;
        this.status = status;
        this.message = message;
        this.batches = Collections.unmodifiableList(new ArrayList<BatchProgress>(batches));
    }

    public boolean isComplete() { return "Completed".equals(status); }

    public static final class BatchProgress implements Serializable {
        private static final long serialVersionUID = 1L;
        public final long batchId;
        public final int accepted, target, recycled;
        public final String status;

        public BatchProgress(long batchId, int accepted, int target, int recycled, String status) {
            this.batchId = batchId;
            this.accepted = accepted;
            this.target = target;
            this.recycled = recycled;
            this.status = status;
        }
    }
}
