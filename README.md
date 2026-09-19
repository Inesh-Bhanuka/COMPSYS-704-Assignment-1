# Automated Bottling System

COMPSYS 704 Project 1, Group 3. University of Auckland, 2026.

This is a SystemJ simulation of a bottling line. A customer places an order
through a POS window, a coordinator turns that order into individual bottles,
and thirteen machines fill, lid, cap, check, label and store each one. Bottles
that fail the quality check get sent to a recycling station, which takes the lid
off, drains them and puts them back at the start of the line.

We modelled the plant and the control separately all the way through, so every
controller talks to a simulated machine through sensors and actuators rather
than just assuming things worked. Altogether it's 31 clock domains running as
one GALS program.

## Running it

In Eclipse, hit F5 on `assignment1` first so it picks up the `.launch` files.
Then:

- **Run As &rarr; BuildAll** compiles the `.sysj` files into Java. You only need
  this after editing a `.sysj`.
- **Run As &rarr; RunABS** starts everything.

RunABS brings up all 31 clock domains in one JVM, plus the POS window and the
operator console. There's no separate POS to build or launch. It runs forever on
purpose, so stop it with the red square.

From a terminal, inside `assignment1`:

```
java  -cp "lib/*" com.systemj.compiler.JavaPrettyPrinter -d src --nojavac --silence sysj/*.sysj
javac -cp "lib/*" -d bin src/*.java
java  -cp "bin;lib/*" ABSLauncher sysj/abs.xml
```

Those are Windows classpaths. Swap the `;` for `:` on macOS or Linux. Start
`ABSLauncher` and not `SystemJRunner` directly, because it sets `gui.enabled`
before handing over.

A few flags worth knowing:

| Flag | Default | What it does |
| --- | --- | --- |
| `-Dabs.ticksPerSecond` | 60 | How fast the whole thing is clocked. Set it to `0` to run flat out, which is what the tests do. |
| `-Dabs.timeScale` | 5 | Stretches how long each machine takes to move, without touching the tick rate. This is the one that makes the demo watchable. |
| `-Dgui.headless`, `-Dpos.headless` | off | Build the windows but don't show them. For automated runs. |
| `-Dabs.lidBinCapacity` etc. | high | Sizes of the recycling bins and the waste tank. Turn them down if you want to see them fill up and get serviced in a short run. |

## How it's put together

### The clock domains

One subsystem, `ABS`, with 31 clock domains in it:

- **Interfaces:** the POS, the GUI bridge and the operator panel.
- **Coordinator:** the System Controller.
- **Bottling station:** bottle loader, conveyor, rotary table, two fillers, lid
  loader, capper and labeller.
- **Recycling station:** the Recycling Station Controller, plus the quality
  splitter, recycling conveyor, lid removal, liquid dumper and bottle return.

Every machine is two clock domains, not one: a **controller** that holds the
sequence, and a **plant** that pretends to be the mechanism, with its own travel
times and sensors. They're joined by signals only, the same way a real PLC is
wired to real hardware. A controller can't reach inside its plant and read a
variable, which is the whole point.


## The three modes

**Automatic** is the normal one. Press Start and the coordinator works through
the order.

**Manual** hands the line to the operator. Tick the signals for the next move on
the console and press Send Tick. One tick commands one stroke, and the station
then holds it until its own sensor says the move is finished. Start still books
a bottle in, so you can genuinely walk one bottle the whole way down the line by
hand.

**Paused** lets each station finish the action it's in the middle of and then
hold. Press Start and the same bottles carry on.

**Reset** isn't a drain. The line and the display both empty on the
coordinator's next tick, in one tick, and the production plan goes with them.
There's no half-reset state to get caught in because there's nothing left.

## Quality and recycling

A bottle gets rejected when its own record doesn't back up what the line is
about to claim: a fill outside tolerance, a cap that didn't seat, a lid that was
already on, a label that didn't print. The splitter reads that and diverts it.
The recycling station then unscrews and ejects the lid, drains the contents into
a waste tank, and sends the empty bottle back to the start to be filled again.

The bins and the tank aren't infinite. When one fills up the station blocks
until it's serviced, and servicing only happens when the machine is in a safe
position for it. Set the capacity flags low if you want to watch that happen
without waiting for a hundred bottles.

## Where things live

```
assignment1/
  sysj/          the .sysj sources; abs.xml wires them together
    machines/    per-domain XML, generated
    legacy/      early standalone versions, not part of the build
  src/           our Java, plus the Java generated from the .sysj files
  tests/         automated runs (below)
  tools/         the generators (below)
  lib/           SystemJ runtime and compiler
```

The generated Java is committed so the project opens and runs without building
first. **Edit the `.sysj`, never the generated `.java`.** Anything called
`*Controller.java` or `*Plant.java` gets overwritten by BuildAll.

Two python scripts are used to make the wiring simple:
- `tools/genxml.py` reads the interface of every `.sysj` and writes `abs.xml`
  and the per-domain XMLs. Run it whenever you add or rename a signal or
  channel.
- `tools/actuators.py` has the one table of actuators the operator can drive,
  and generates the operator panel clock domain, the list the console builds its
  checkboxes from, and the routing bit `genxml.py` imports. Adding an actuator
  is one row in that table, then run both scripts.

## Tests

These drive the real `abs.xml` through the same sockets the console uses, so
they're exercising the actual clock domains and not a stub.

```
javac -cp "bin;lib/*" -d bin tests/*.java
java -Dabs.ticksPerSecond=0 -cp "bin;lib/*" PosIntegrationTest
```

Run them one at a time. They bind fixed ports, so two at once will just collide
and look like a failure.

| Test | What it shows |
| --- | --- |
| `PosIntegrationTest` | 30 bottles over three batches, then a second order, all reaching storage with the audit balancing. |
| `ManualWalkthroughTest` | One bottle walked from the magazine to the shelf by hand: 29 operator steps, each one waiting for the plant to say the stroke finished. |
| `ManualModeTest` | The gates don't slow automatic down, nothing moves on its own in manual, and a tick moves exactly what you selected. |
| `HardResetTest` | Line and display empty in one tick, records survive, and production starts again on the cleared line. |
| `GuiIntegrationTest` | Start, pause, resume, mode change, simulated fault, reset, telemetry, and the console dropping its connection. |
| `GuiQualityRecoveryTest` | Reject-one-in-N, the recycling path end to end, and the bins and tank filling up and being serviced. |
| `GuiRepeatOrderTest` | A second order on a line that's already run one. |
| `PosModelTest`, `PosUiTest` | Order validation and the POS window. |



## Individual projects

Each of us extended the system in one direction. Those are covered in our own
reports, so there's no detail here:

- **Digital twin** &ndash; per-workpiece history tracking and the labelling
  station, extended into a twin of the whole plant.
- **Operator console** &ndash; the live schematic, bottle records, production
  order panel and line control.
- **Recycling station** &ndash; quality splitter, lid removal, liquid dumper and
  bottle return.
