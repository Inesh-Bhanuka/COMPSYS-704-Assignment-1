# COMPSYS-704-Assignment-1
SystemJ-based simulation of an IIoT Automated Bottling System (ABS) featuring GALS clock domains, POS integration, and automated fault-tolerant bottle recycling.

## Build and run

In Eclipse, refresh `assignment1`, run the existing **BuildAll** (or **BuildSystemJ**),
then refresh/build the Java project and run **RunABS** (or **RunSystemJ**).
Both run configurations start `sysj/abs.xml`, including the POS window and all
manufacturing clock domains. No separate POS build or run configuration is needed.
Stop the launch with Eclipse's red square, or close the POS window to exit the simulation.

From PowerShell in `assignment1`:

```powershell
java -cp "lib/*" com.systemj.compiler.JavaPrettyPrinter -d src --nojavac --silence sysj/*.sysj
javac -cp "lib/*" -d bin src/*.java
java -cp "bin;lib/*" com.systemj.SystemJRunner sysj/abs.xml
```

If a SystemJ interface or its wiring changes, regenerate the existing XML with
`python tools/genxml.py` before running. Generated Java sources are committed;
edit the `.sysj` source for clock-domain changes and regenerate it.

## Purchase Order System

The POS uses the supplied Figure 9 layout: purchase-order editor on the left,
batch table on the right, and status/actions below. Enter the customer name and
product, choose 100, 200, 250 or 500 mL, set whole-number percentages totalling
exactly 100%, and choose a quantity from 1 to 10,000. **Add Batch** can be repeated
for different products. Select a draft row to remove it, then **Submit to Production**.
Only rows added to the table are submitted; the form is locked during production.

Every order receives a UUID-based Order ID. The display changes from **Submitting**
to **In Production** when the controller acknowledges it. Each batch shows its
accepted bottle count; **Completed** appears only after all ordered quantities
reach batch storage. A dialog and audible notification tell the customer that
the whole order is ready. **New Order** then starts a fresh draft while previous
bottles remain in batch storage. Only one order is submitted from this GUI at a time.

`POSCD.purchaseOrder` sends a serializable `PosOrderRequest` valued signal to
`SystemControllerCD.purchaseOrder`. It includes Order ID, customer name, total
batch count, and every batch's product name, size, percentages and quantity.
`SystemControllerCD.productionStatus` returns immutable `PosOrderStatus` snapshots
to the POS. Both signals are repeated across ticks; Order IDs prevent duplicate
production and revisions prevent stale feedback. The Swing mailbox is used only
by the POS clock domain: the GUI does not read controller objects for progress.
The existing machine-to-machine channels remain in use.

The controller completes one batch before issuing the next batch's bottles.
Product names follow bottles through to their labels. Recycled rejects trigger
replacement bottles and never count as deliveries. Zero-percent ingredients and
250 mL rounding are handled. The simulated bottle tray, label roll and glue supply
replenish after five enabled ticks when empty, allowing the sample three batches
of ten and subsequent orders to finish.

This is the trusted, registered-customer simulation described in the assignment:
the customer field represents an already authenticated session. Account registration,
Internet hosting and email delivery are not implemented. Completion notification is
in the POS window; signal connections use the existing localhost SystemJ transport.
Orders and their history are held in memory for the running simulation.

## Regression checks

After building, from `assignment1`:

```powershell
javac -cp "bin;lib/*" -d bin tests/*.java
java -cp "bin;lib/*" PosModelTest
java -cp "bin;lib/*" PosIntegrationTest
java -cp "bin;lib/*" PosUiTest
```

The model check covers validation, serialization, repeated orders, batch boundaries,
reject replacements, rounding, product labels, stale feedback and subsequent orders.
The integration check starts the actual 29-domain XML without opening a window,
submits three batches of ten using the POS signal path (including 0%/100% recipes),
checks physical storage and batch ordering, then submits another order. Do not run
it alongside RunABS, because both use the same signal ports. It exits when done and
fails after a bounded timeout if the line or feedback stalls.
The Swing check exercises add/remove/submit, progress, completion and New Order,
and renders the actual form to `bin/pos-preview.png` without showing a window.
