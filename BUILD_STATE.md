# ABS — build state

Where the SystemJ bottling system stands, how to run it, and what is left.
Current as of the recycling-station rework (queue intake, machine timing and
receptacle capacities).

Checked against our conceptual design, the interim report and the IP report
rather than the brief PDF — worth reconciling with the real document.

---

## Running it

**Run As → RunABS.** Refresh the project (F5) first — Eclipse only lists
`.launch` files it has scanned. That runs `SystemJRunner` against
`sysj/abs.xml`, which brings up all 30 clock domains in one JVM together with
the POS window and the operator console. It runs forever by design; stop it
with the red square.

You only need **Run As → BuildAll** after editing a `.sysj`. From a terminal,
inside `assignment1`:

```
java  -cp "lib/*" com.systemj.compiler.JavaPrettyPrinter -d src --nojavac --silence sysj/*.sysj
javac -cp "lib/*" -d bin src/*.java
java  -cp "bin;lib/*" ABSLauncher sysj/abs.xml
```

Semicolons in those classpaths — Windows separator. Launch `ABSLauncher`
rather than `SystemJRunner` directly; it sets `gui.enabled` before handing
over, which is what brings up the operator console.

### Demo speed and capacities

Two system properties, both with demo-friendly defaults, so nothing needs
recompiling to change the pace of a run:

| Property | Default | What it does |
| --- | --- | --- |
| `-Dabs.ticksPerSecond` | 60 | Wall-clock rate every clock domain is held to. Lower is slower; `0` free-runs. |
| `-Dabs.timeScale` | 5 | Multiplier on every machine's motion time. `1` restores the original quick numbers. |
| `-Dabs.lidBinCapacity` | 250 | Lids the removal station's waste bin holds. |
| `-Dabs.bottleBinCapacity` | 250 | Containers the bottle return's collector holds. |
| `-Dabs.wasteTankCapacity` | 250 | Bottles' worth of liquid the dumper's tank holds. |

`PlantPace` and `PlantTiming` are deliberately separate knobs. Pacing sets how
long a tick lasts, which slows everything including the cross-domain
rendezvous; scaling sets how many ticks a machine's motion takes, which is
what makes an individual operation legible instead of instantaneous. A
watchable demo wants both. Neither changes the plant's behaviour: every
domain is slowed by the same factor and every machine keeps its motion time
relative to the others, so orderings and bottlenecks are unchanged. A
regression run should use `-Dabs.ticksPerSecond=0`.

Capacities are large on purpose. The full-and-blocked path matters and is
still in the code — a machine finishes the container it is holding, reports
BLOCKED, and stops accepting work until servicing clears it. The *number* does
not: emptying a bin is a manual, out-of-scope activity that the simulation
stands in for with an automatic service, so a small capacity only interrupts a
demonstration with full-then-immediately-serviced pairs that say more about
the stub than the plant. `-Dabs.lidBinCapacity=3` gets the old behaviour back
for anyone who wants to see the suspension fire.

At the defaults a twenty-unit order takes a few minutes and each machine
action lasts several display frames.

### If it does not start

- **No launch configs in the list** — the project name in `.project` must
  match what the `.launch` files expect (`assignment1`). Refresh after any
  change to the folder.
- **Missing-library errors** — `lib/` needs the SystemJ jars. They are in the
  repo; a fresh clone should be fine.
- **`.git` lock file errors** — delete `.git/HEAD.lock` and
  `.git/objects/maintenance.lock` and retry.
- **`ArrayIndexOutOfBoundsException` in `bytecode.Parser.parseThisClass`
  during BuildAll** — see *Known problems* below. The command-line
  `JavaPrettyPrinter` invocation above is the workaround.

---

## The line, end to end

| Stage | State | Notes |
| --- | --- | --- |
| POS | Built | Customer window; orders, batches, recipes, replacements |
| Bottle loader | Built | Arm and vacuum, supply of 20, refills itself |
| Infeed belt | Built | Queued, several bottles in transit |
| Rotary table | Built | 6 positions, unconditional barrier, real rotation |
| Filler 1 + 2 | Built | Valve and flow meter, ml from the recipe |
| Lid loader | Built | Magazine of three, refills itself |
| Capper | Built | Sets the barrier pace |
| Outfeed belt | Built | Pulls the finished bottle off at position 6 |
| Quality splitter | Built | **On the outfeed, ahead of the decision** — routes forward or aside |
| Labeller | Built | Prints from the workpiece twin; refuses what the record can't justify |
| Batch storage | Built | Where the line ends — labelled bottles retire onto their batch's shelf |
| Recycling station | Built | The branch: strip the lid, drain, return the container |
| Operator console | Built | Schematic, records, events, automatic and manual control |

30 clock domains, 28 channels, every one point-to-point with one sender.

---

## How the pieces talk

One rule, worth being able to state out loud in the demo:

- A **transfer** between two machines — a command, an acknowledgement, a
  bottle changing hands — is a **channel**, carrying the workpiece.
- A **level** a reaction tests every tick — sensor, actuator, plant power,
  operating mode — is a **signal**.

Sensors cannot be channels: `abort(armAtSource){...}` has to evaluate a level
at every tick boundary, and a rendezvous cannot be tested without committing
to it.

All 30 clock domains sit in a single `<SubSystem>`. Channels are wired by name
alone — `From` and `To`, no class, no IP, no port — and channels crossing a
subsystem boundary would need an `<Interconnection>` block. One subsystem, and
that question disappears. (`sysj.xsd` inside `sjrt-base` is the reference.)

There are no fixed-width pulse handshakes left in any controller. Every
actuator command is held until the plant's own sensor confirms the effect.

`tools/genxml.py` generates `sysj/abs.xml` and one file per clock domain into
`sysj/machines/`, straight from the `.sysj` interfaces. **Do not hand-edit the
XML** — change the interface and rerun the script. Adding a machine is one row
in `CDS` plus its links in `SIGNALS` and `CHANNELS`.

---

## Recipes, sizes and the digital twin

`WorkpieceTwin` is the bottle: identity, recipe, and an append-only history of
everything that happened to it. Lifecycle state, station, fill level and
whether it is lidded are all **folded out of the events** rather than stored
beside them, so the two can never disagree. Every event carries a tick, so any
past state can be replayed.

Ownership travels with the bottle — exactly one clock domain holds a twin at a
time and hands it on by rendezvous, so appends never race.

Bottle sizes and per-liquid percentages come from the POS order. Fill time
comes out of the volume at a fixed ml per tick, so the sizes fall out of the
model rather than being special-cased. The fillers check `fits()` before
opening a valve — a 200 ml bottle ordered at 70% and 70% takes 140 ml and has
the second fill refused.

Every machine also publishes a `MachineTwin`: an interpreted summary (status,
last command, last confirmation), not a mirror of its raw signals, so a
machine can be rebuilt without any consumer changing. The coordinator collects
them into an `ABSTwin`.

---

## The quality decision

The splitter now sits **on the outfeed, ahead of the decision it makes**,
which is what both reports describe. The System Controller takes the finished
bottle off the outfeed, hands the twin to the splitter, and the splitter reads
the quality record and drives the diverter to the matching path, verifying
against its own end-stop sensors with a bounded stroke timeout. Only a bottle
that went forward reaches the labeller.

That makes the labeller's refusal the **backstop** rather than the primary
gate: a sensed diverter *and* a labeller that will not print against a flagged
record even if that diverter jams. A jammed diverter is recorded on the twin
as a rejection by the splitter, so the labeller catches it on the way past.
Two independent mechanisms is a better validation story than one.

---

## The recycling station

The branch off the outfeed. A diverted bottle is carried to three stations in
turn — lid removal, liquid dumping, bottle return — by an indexing conveyor
that owns all four photo-eyes, and the Recycling Station Controller is the
only machine the coordinator talks to.

**Recovery is strictly sequential**, as the IP report specifies: one bottle
visits the three stations in order and nothing inside the station runs
concurrently. What is *not* sequential any more is intake. `bottleRejected` is
a rendezvous, so while the sequencer was also the reaction waiting for the
next bottle, the coordinator's send only completed after a whole recovery
cycle — one defective bottle stalled the entire production line for the length
of that cycle, even though recycling is a side branch of it.

Intake is therefore a separate reaction with a **five-deep queue**
(`RecyclingQueue`) behind it. The station accepts a rejected bottle as soon as
it has room, which releases the coordinator immediately; the sequencer draws
from the queue in arrival order and recovers bottles one at a time exactly as
before. When the queue is full, intake stops receiving, the coordinator's send
stops completing, and the back-pressure propagates upward on its own — which
is the honest behaviour for a station whose recovery rate really is lower than
the line's reject rate.

The indexing conveyor is deliberately **not** a free-running belt. One rising
edge of the motor command moves the bottle one station and no further. A belt
that advanced on every tick the motor was present raced the cross-domain
latency between raising a photo-eye and the controller's release arriving
back, and carried bottles a whole station past their stop — the liquid dumper
started on a bottle that was still at lid removal. One command, one station
removes the race outright instead of trying to tune the latency away, and a
stop at each station is what the real machine has anyway.

### Last verified run

Two consecutive orders, the second with a forced fault on every third bottle:

- Every rejected bottle accepted, queued, and recovered, in arrival order.
- Every recovery ran lid removal → drain → return strictly in order, with no
  station acting before the conveyor reported the bottle had arrived, and
  never more than one bottle inside the station.
- Bottles were accepted into the queue while an earlier one was still being
  drained; the main line kept labelling and shelving throughout.
- No receptacle reached capacity, and no splitter stroke timed out at the
  scaled machine timings.

Note when reading a faulted run that **replacement bottles are not
fault-armed** — `GuiSupervisor.prepare` skips them — so the bottles loaded to
make up a short order all pass. That looks like the fault injection stopping
and is not.

---

## The operator console

`ABSLauncher` enables the console and invokes the normal SystemJ runner.
`GUIInterfaceCD` carries the TCP bridge; the Swing side is `A1_GUI` via
`GuiClient`. Status, events and commands go over separate ports, snapshots are
complete rather than differential, and `GuiStatusSender` is a bounded
sample-and-hold so socket back-pressure can never block a controller tick.

`GUI_DESIGN.md` has the full mapping to the interim report's figures.

### What manual mode actually does

Manual mode issues **per-operation permission tickets**. `GuiStep.take()`
consumes one ticket inside the station's own reaction, so the operator
releases one complete station operation — with its real sensor handshake —
rather than jogging an actuator. Repeating a signal does not replay an
operation, and a permission may sit waiting until a bottle actually arrives at
that station; it is a permit, not a completion report.

Ten operations are ticketed and nine are gated inside `.sysj`:

`LOAD` (in `GuiSupervisor.admission`), `INDEX`, `FILL1`, `FILL2`, `LID`,
`CAP`, `OUTFEED`, `QUALITY`, `LABEL`, `RECYCLE`.

Two honest limits:

- **`RECYCLE` is one ticket for the whole recovery.** Lid removal, draining
  and return are not individually steppable, so the recycling station cannot
  be walked through stage by stage the way the main line can.
- **The per-machine `mode` signal is not driven.** Every controller has a
  Manual reaction and every plant has manual-override inputs — 21 distinct
  `…M` actuator signals across ten controllers — and they are declared, wired
  in the XML, and complete. But the System Controller emits `mode(0)` to all
  of them unconditionally, so those reactions never activate and nothing ever
  drives an override signal. There are effectively two manual concepts in the
  system and only the ticket one is connected.

Wiring the second is a contained job: route a GUI command to the `mode`
signals and the `…M` overrides instead of hardcoding 0. It would give
actuator-level jogging on top of the current operation-level stepping.

### Is the schematic an animation?

No — it is **discrete-state, frame-by-frame teleportation**, and deliberately
so. `A1_GUI.position(Bottle)` is a lookup on the twin's state: a bottle on the
table maps to one of six fixed points, and otherwise to a single fixed point
per location or stage — loader, splitter, recycling, labeller, done,
recovered. There is no travel fraction, no interpolation and no per-tick
coordinate; the 100 ms Swing timer only repaints whatever the last snapshot
said. That is a design choice the GUI notes record: the supplied mockup's
timer-driven synthetic motion was removed so that nothing on screen is ever
invented rather than reported.

The cost is that a bottle jumps between anchors, and that **the recycling
station is a single anchor point** — a bottle at lid removal, at the dumper
and at the return all draw at the same pixel, so the station's internal
sequence is invisible in the schematic even though the log and the event
panel show it in full.

If real motion is wanted later, the honest way to get it is to publish a
travel fraction from the plants that already count travel ticks
(`ConveyorPlant`, `RecyclingConveyorPlant`, `RotaryTablePlant` all hold
exactly this state) and interpolate between anchors from that, rather than
letting the Swing timer invent the movement. Giving the recycling conveyor its
own four anchors is worth doing either way and needs no new plant state at
all, since `RecyclingConveyorPlant` already knows which station the bottle is
at.

---

## SystemJ gotchas we have already paid for

Read before writing more `.sysj`.

- Channel declarations put the type **before** the keyword:
  `input Integer channel x`, matching valued signals.
- Every loop needs a `pause` on every path. A `send` or `receive` does not
  count — the compiler rejects the loop outright.
- A Java object **or constant** declared at clock-domain level is not visible
  inside parallel reactions; each reaction gets its own scope. `TableModel`,
  `BeltQueue`, `RecyclingQueue` and the rest go through a static accessor for
  this reason.
- Array initialisers in a reaction (`int[] x = {1,2,3}`) generate a broken
  type and fail at `javac`. `new int[n]` is fine.
- `suspend` is a reserved keyword.
- Conditional rendezvous are expensive. Four optional sends plus four optional
  receives is sixteen paths, and the compiler died on the JVM's 64 KB method
  limit before the barrier was made unconditional.
- **Put a `pause` after every rendezvous in a long sequence.** The compiler
  inlines everything following a rendezvous into its "the partner is ready
  now" branch, so a dozen in a row nest a dozen deep and the generated method
  grows exponentially. The Recycling Station Controller generated a 58 MB
  Java file before this was understood; a `pause` is a state boundary and it
  came down to 190 KB. The cost is one tick between stages.
- **Data `if`s around rendezvous multiply the same way.** Move the
  bookkeeping into a shared Java object and keep the reaction a straight line.
- **Parallel reactions add rather than multiply.** A plant with many
  `present/else` pairs split into four reactions went from 2.9 MB to 41 KB.
- A clock domain must never block on something outside the plant. `TCPSender`
  connects in its constructor, and building the twin publisher inside a
  reaction froze the entire system when no GUI was listening.
- **A level meaning "done" must be cleared or made edge-triggered.** Three
  separate bugs in this build came from a peer over-running a stale level
  across the asynchronous clock-domain boundary.
- Console output interleaves across clock domains. **Print order is not
  evidence of timing** — instrument and count instead.

---

## Known problems

1. **`BuildAll` crashes in Eclipse** with
   `ArrayIndexOutOfBoundsException: 51200` at
   `bytecode.Parser.parseThisClass`. The bundled compiler's own class-file
   parser is walking a constant pool it cannot handle. Not reproduced from the
   command line, so the workaround is the `JavaPrettyPrinter` invocation at
   the top of this file. The culprit class has not been proven.
2. **`bottleAtLabeller` is declared and never read.** Either wire it or drop
   it from the interface.
3. **Nothing runs headless.** Every entry point brings up Swing, so there is
   no way to run the line in CI or capture a regression log without a display.
4. **No `.gitattributes`.** Every diff shows tens of thousands of phantom
   line-ending changes; `* text=auto` fixes it.
5. **`.project` name collision.** Two projects in the workspace are both
   called `COMPSYS704_Lab_2`, which has already caused an old build to be run
   by mistake and diagnosed as a logic fault.
6. **Manual mode is half-wired** — see the operator console section above.
7. **The schematic does not animate** — see the operator console section
   above.

---

## What is left

1. Wire the `mode` signals and the `…M` overrides so the per-machine manual
   reactions and actuator jogging become reachable.
2. Give the recycling conveyor its own four anchors in the schematic, so the
   station's sequence is visible rather than collapsed to one point.
3. Decide whether real interpolated motion is worth publishing travel
   fractions for.
4. Add `.gitattributes`, fix the `.project` name, and either use or remove
   `bottleAtLabeller`.
5. A headless entry point, so a run can be captured and checked automatically.
6. Reconcile the whole thing against the brief PDF rather than against our own
   design documents.
