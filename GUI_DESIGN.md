# Extended ABS GUI design and integration

## Sources and scope

This implementation follows **Compsys 704 Interim Report (1).pdf**, pages 1-6,
Figures 1-8, and **COMPSYS 704-2026 Project 1 GP and IP brief revised 2026 (1).pdf**,
sections 4.1.1-4.1.3 and 4.2. The documents are design references; their report-writing,
assessment, consultation and submission instructions are not actions requested of
this implementation task.

The deliverable is a Java Swing operator console integrated with the existing POS
and simulated SystemJ bottling line. It uses the existing build/run launch files.
The operator window is adapted directly from the supplied `A1_GUI.java`, retaining
its workstation drawings, colours, control cards and scrolling right-hand panels.
The external reference file is unchanged. `AbsWindow` is a compatibility entry point
for this integrated class, not a second GUI design.

| Reference | Implemented design |
| --- | --- |
| Figure 1 | System Overview with bottle loader, conveyors, six rotary positions, two fillers, lid loader, capper, labeller, quality path, recycling and storage; green/amber/red station indicators |
| Figure 2 | Select a bottle in the schematic or Bottle Records to inspect product ID, serial, batch, requested contents, measured volume, production stage, completion time and QC |
| Figure 3 | POS batch selector and product/recipe/quantity details; apply a quality-test frequency |
| Figures 4-5 | Automatic Start/Pause/Reset and Manual selection with Enable Selected/Clear Ticks |
| Figure 6 | Line state, accepted/target progress, recycled and in-process counts, selection and retained batch history |
| Figure 7 | Chronological timestamped event log with bottle and workstation identifiers |
| Alert description | Latched quality alerts and simulated labeller jam, red indicator, command acknowledgement, clear-fault action |
| Figure 8 | Dedicated GUIInterfaceCD, TCP status/events/commands, and SystemJ signals into the coordinator |
| Brief 4.1.2-4.1.3 | Actual model feedback and bottle-level traceability; station algorithms and ordering remain in SystemJ |
| Brief 4.2 | Existing POS continues to provide customer order identity and batch specifications |

## Intentional design choices

- The GUI displays recipes from the POS instead of silently altering an already
  submitted customer order. The operator configures fault testing and production
  execution. Product IDs are stable identifiers derived from product names; bottle
  serials and batch IDs come from the workpiece model.
- Progress counts accepted bottles toward the customer's requested quantity.
  Recycled bottles are shown separately and replaced. The report mockup's total
  attempted count is not used as proof that an order has been fulfilled.
- Pause stops admission and drains existing work before displaying PAUSED. Mode
  switching uses the same drain. This avoids presenting a stopped line with open
  bottles as ready to resume. It is a supervisory simulation policy, not an
  implementation of the brief's external human-presence/environmental interlocks.
  ECS/SACS inputs and their emergency removal/restart sequence remain outside this
  GUI extension; no physical safety certification is claimed.
- Manual permissions allow complete station operations with the existing sensor
  handshakes, not arbitrary raw actuator bypasses. Every index requires another
  INDEX permission. LOAD includes automatic transport along Conveyor A. Permissions
  may wait for a bottle at the relevant station; they are not completion reports.
- Reset preserves completed products and historical records. It first finishes
  admitted work and then resets the remaining active plan. A jam must be cleared
  before the drain can complete. The POS receives a Reset status and allows a new
  order. Nothing is marked completed simply because Reset was pressed.
- The existing quality decision is made at the labeller and rejected bottles then
  pass through the recycling splitter. The schematic includes the intended sorting
  path, but this GUI does not relocate the underlying quality controller.
- The supplied layout includes a scrollable control panel, with added tabs for detailed
  records/sensors and a live bottle-label popup. No fabricated timer-driven
  production is used. The Swing timer only repaints and consumes feedback.

## Architecture

`ABSLauncher` enables the operator console and invokes the normal SystemJ runner.
`GUIInterfaceCD` launches the TCP bridge; `GuiClient` supplies the Swing side.

```text
AbsWindow / A1_GUI -> GuiClient -> TCP command port 21002 -> GuiInterfaceBridge
  -> GUIInterfaceCD.Command -> SystemControllerCD.guiCommand
  -> GuiSupervisor -> valued GuiPermit signals -> station reactions

System Controller + machine/workpiece state -> GuiTelemetry snapshot
  -> SystemControllerCD.guiStatus -> GUIInterfaceCD.Status
  -> TCP status port 21000 and events port 21001 -> GuiClient -> AbsWindow
```

`GuiStep` consumes one-use tickets inside each SystemJ station reaction. The
coordinator continuously republishes the current permission value. Repeating a
manual signal does not replay an operation. Automatic permissions allow normal
station sequences. The customer POS uses its separate existing valued-signal pair.

`GuiTelemetry` copies workpiece, batch, station and table-position values on the
coordinator tick. It samples sensor Signal fields from the runtime's controller
clock domains. Swing receives detached DTOs, never the live model objects.
Filler 1 and Filler 2 retain separate display statuses even though both use the
same FillerController class and the legacy ABSTwin groups fillers under one enum.

Socket construction, sending and retrying occur on worker threads. Commands have
unique IDs, controller acknowledgement, repetition until acknowledged, and a
five-second expiry. A two-second age check on the model snapshot catches a frozen
model even if a socket worker is still connected. Controls reject new commands
when feedback is stale. Connections currently use localhost for the simulation.

Events are timestamped as workpiece events occur, with ordered sequence IDs for
TCP deduplication. The interface retains the latest 2,000 events and the console
up to 5,000; completed/reset batch history remains in memory. History does not
survive process restart. Fault-clearing removes active alerts, not the event log.

## Build repair provenance

The initial `Lucy` checkout at `bde3ffb` contained committed conflict markers in
launch files, SystemJ sources and generated Java, and referenced missing classes
and `.sysj` files. It could not build from source. The compatible dependencies
were recovered from the repository's `channels` branch, the previous POS changes
were retained, and generated Java/XML were rebuilt. Earlier signal-only turntable
and station prototypes were moved intact to `sysj/legacy/` to prevent duplicate
active clock-domain definitions. These are build prerequisites for the GUI, not
additional machines introduced by the UI.

## Validation

- All active `.sysj` sources compile; Java compiles with the bundled SystemJ jars.
  Existing generated-code deprecation/unchecked warnings remain.
- `PosModelTest`: input validation, serializable payloads, duplicate requests,
  sequencing, replacements, rounding, labels, stale status and a second order.
- `PosIntegrationTest`: 30 bottles across three batches (including 0% recipes),
  then another order; all 31 accepted/stored, twin audit passed with the GUI clock
  domain and station gates present.
- `GuiIntegrationTest`: real TCP plus all 30 clock domains; no loading before
  Start, automatic production with recycled rejects/replacements, drain-to-pause,
  no transmitted command on checkbox/Clear Ticks, complete manual sequence via
  Enable Selected, simulated fault/clear, reset, sensor/event/history feedback,
  and no commands accepted after model telemetry becomes stale.
- Actual Swing renders are generated by the integration check and inspected for
  layout against the supplied mockup. Production uses actual model positions;
  the original mockup's timer, synthetic station actions and generated logs are removed.

Run instructions are in README.md. Tests own the same TCP ports as the normal
simulation, so run them separately from RunABS.
