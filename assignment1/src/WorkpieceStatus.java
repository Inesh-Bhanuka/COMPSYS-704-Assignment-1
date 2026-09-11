/** Lifecycle of a bottle. Derived from its event history, never set directly. */
public enum WorkpieceStatus {
	LOADED, FILLING, FILLED, CAPPING, CAPPED, LABELLING, LABELLED, DONE,
	REJECTED, RECYCLING, RECOVERED, SCRAP
}
