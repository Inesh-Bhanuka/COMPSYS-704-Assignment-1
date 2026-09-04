# ABS — build state

Where the SystemJ bottling system stands, how to run it, and what is left
against the brief. Current as of the `channels` branch.

Checked against our conceptual design rather than the brief PDF — worth
reconciling with the real document before planning around the last section.

---

## Running it

One launch target. **Refresh the project (F5) first** — Eclipse only lists
`.launch` files it has scanned — then **Run As → RunABS**. That runs
`SystemJRunner` against `sysj/abs.xml`, which brings up all sixteen clock
domains in one JVM. It runs forever by design; stop it with the red square.

You only need **Run As → BuildAll** after editing a `.sysj`. From a terminal,
inside `assignment1`:

```
java  -cp "lib/*" com.systemj.compiler.JavaPrettyPrinter -d src --nojavac --silence sysj/*.sysj
javac -cp "lib/*" -d bin src/*.java
java  -cp "bin;lib/*" com.systemj.SystemJRunner sysj/abs.xml
```

Semicolons in that last classpath — Windows separator.

Give it about ninety seconds for four bottles to drain. The capper takes
twelve ticks and the table cannot index until it is done, so the whole line
paces off that.

### If it does not start

- **No launch configs in the list** — the project name in `.project` must
  match what the `.launch` files expect (`assignment1`). Refresh after any
  change to the folder.
- **22 missing-library errors** — `lib/` needs the SystemJ jars. They are in
  the repo now; a fresh clone should be fine.

---

## The line, end to end

| Stage | State | Notes |
| --- | --- | --- |
| Bottle loader | Built | Arm and vacuum, supply of 20, auto/manual |
| Infeed belt | Built | Queued, several bottles in transit |
| Rotary table | Built | 6 positions, barrier, real rotation |
| Filler 1 + 2 | Built | Valve and flow meter, ml from the recipe |
| Lid loader | Built | Magazine of three, refills itself |
| Capper | Built | 12 ticks, sets the barrier pace |
| Outfeed belt | Built | Ends at the labeller point |
| Labeller | Missing | Ahil's IP |
| Unloader | Missing | Bottles vanish at the end |

---

## Clock domains

Every machine is a controller and plant pair, so each one could be deployed to
its own microcomputer unchanged.

| Clock domain | Port | State | Notes |
| --- | --- | --- | --- |
| `PosStubCD` | 10000 | Stub | Issues four orders, prints completions |
| `SystemControllerCD` | 10001 | Live | Orders in, load commands out, mode and plant power |
| `BottleLoaderControllerCD` | 11000 | Live | Auto/manual, supply monitoring |
| `BottleLoaderPlantCD` | 11001 | Live | Arm and vacuum, supply of 20 |
| `ConveyorControllerCD` | 12000 | Live | Accept, run, hand off, outfeed |
| `ConveyorPlantCD` | 12001 | Live | Infeed is a 7-slot queue, outfeed single-bottle |
| `RotaryTableControllerCD` | 13000 | Live | Unload, place, run stations, index |
| `RotaryTablePlantCD` | 13001 | Live | 6 positions, 6-tick rotation, sensors at 1, 2, 4, 5 |
| `Filler1ControllerCD` | 14000 | Live | Liquid A at position 2 |
| `Filler1PlantCD` | 14001 | Live | Valve and flow meter, 20 ml per tick |
| `Filler2ControllerCD` | 14100 | Live | Liquid B at position 3, same class as filler 1 |
| `Filler2PlantCD` | 14101 | Live | Second instance of the same plant |
| `LidLoaderControllerCD` | 14200 | Live | Pusher, vacuum arm, refill cycle |
| `LidLoaderPlantCD` | 14201 | Live | Magazine of three |
| `CapperControllerCD` | 14300 | Live | Slowest station |
| `CapperPlantCD` | 14301 | Live | Screwing head, 12 ticks |

---

## How the pieces talk

One rule, and it is worth being able to state it in the demo:

- A **transfer** between two machines — a command, an acknowledgement, a
  bottle changing hands — is a **channel**, carrying the workpiece.
- A **level** a reaction tests every tick — sensor, actuator, plant power,
  operating mode — is a **signal**.

Sensors cannot be channels: `abort(armAtSource){...}` has to evaluate a level
at every tick boundary, and a rendezvous cannot be tested without committing
to it.

All sixteen clock domains sit in a single `<SubSystem>`. Channels are wired by
name alone — `From` and `To`, no class, no IP, no port — and channels crossing
a subsystem boundary would need an `<Interconnection>` block. One subsystem,
and that question disappears. (`sysj.xsd` inside `sjrt-base` is the reference.)

There are no fixed-width pulse handshakes left in any controller. Every
actuator command is held until the plant's own sensor confirms the effect.

`tools/genxml.py` generates `sysj/abs.xml` and one file per clock domain into
`sysj/machines/`, straight from the `.sysj` interfaces. **Do not hand-edit the
XML** — change the interface and rerun the script.

---

## Recipes and bottle sizes

`Workpiece` carries the recipe: bottle size (100 or 200 ml), the percentage of
each liquid, and how much has gone in so far. Percentages are arbitrary, not
four fixed recipes — edit `OrderBook` to change the run.

Fill time comes out of the volume, at 20 ml per tick, so a 200 ml bottle takes
twice as long as a 100 ml one at the same percentage. The two sizes fall out
of the model rather than being special-cased.

The fillers check `fits()` before opening a valve, so a recipe over 100% is
refused rather than overflowing. Tested with a 200 ml bottle at 70% and 70%:
140 ml went in, the second fill was refused, the bottle finished at 140 ml.
That run is worth keeping for the validation section.

Both fillers are the same class instantiated twice. The controller asks the
bottle which liquid it needs next rather than being told which filler it is,
which is what lets one piece of code serve both positions.

### Last verified run

```
bottle 1 (100ml, 50/50)   A 50ml   B 50ml      → 100ml, sealed
bottle 2 (200ml, 25/75)   A 50ml   B 150ml     → 200ml, sealed
bottle 3 (100ml, 100/0)   A 100ml  (B skipped) → 100ml, sealed
bottle 4 (200ml, 60/40)   A 120ml  B 80ml      → 200ml, sealed
```

Four orders in, four bottles out in order, each visiting all four stations
exactly once, with a magazine refill part way through.

---

## Three design decisions worth being able to defend

**The rotary table's intake is a separate reaction with a one-deep buffer.** A
rendezvous completes whenever both sides are ready, which is not necessarily
an instant when the table is aligned. So the transfer and the physical
placement are separate events. Nothing is lost or duplicated.

**The barrier starts all four stations even when positions are empty.** Four
optional sends plus four optional receives is sixteen control paths; the
compiler ran for over a minute and then died on the JVM's 64 KB method limit.
Unconditional, with `null` meaning "nothing at this position", took the same
file to two seconds. A station parked at its receive starts instantly, so they
still run concurrently and the receives wait for the slowest.

**Two plant signals exist to close handshakes that had nothing to acknowledge
against.** The infeed belt runs every tick, so a bottle leaves the load point
in the same instant it arrives and `infeedClear` never reads occupied — that
is what the old three-tick pulse was papering over; `conveyorPlant` gains
`infeedAdmitted`. And there is no presence sensor at table position 6, so
`turntablePlant` gains `exitCleared`. Both are actuator-complete outputs, not
new workpiece sensors, so the sensor set still matches Appendix 4.

---

## SystemJ gotchas we have already paid for

Worth reading before writing more `.sysj`.

- Channel declarations put the type **before** the keyword:
  `input Integer channel x`, matching valued signals.
- Every loop needs a `pause` on every path. A `send` or `receive` does not
  count — the compiler rejects the loop outright.
- A Java object **or constant** declared at clock-domain level is not visible
  inside parallel reactions; each reaction gets its own scope. `TableModel`
  and `BeltQueue` are reached through a static accessor for this reason.
- Array initialisers in a reaction (`int[] x = {1,2,3}`) generate a broken
  type and fail at `javac`. `new int[n]` is fine. That is why the order list
  lives in `OrderBook`.
- Conditional rendezvous are expensive — see the barrier note above.
- Console output interleaves across clock domains. Print order is not
  evidence of timing.
- `bottleAtPos6` used to read `occ[4]`, which is position 5. Renamed
  `bottleAtPos5`.

---

## What is left

### Group

1. **Real POS.** `PosStub` issues four hardcoded orders. Replace it with
   orders arriving as line items, each a batch of identical bottles, and
   progress reported back. The channel it plugs into already exists.
2. **Batch boundaries.** Finish a batch in full, then reconfigure — filler
   proportions, label content — before the next starts. Nothing implements
   this and our design commits to it.
3. **Unloader.** The outfeed still ends at a collector that never refuses.
4. **Mode, safety and overrides.** Mode is wired to every station but only
   ever set to 0. Running, suspended, draining, reconfiguring, plus the
   §4.1.2 conditions and the operator path. "No opened bottles left across a
   suspension" is testable, so it will be tested.
5. **Status and Events.** Continuous state for the GUI, timestamped
   occurrences for the log. Validation is reading one against the other.
6. **Fault injection.** For the validation section. Nobody owns this yet.

### Individual projects

Every station already has auto/manual mode and manual override inputs
declared with nothing driving them — `vacOnM`, `armSourceM`, `armDestM`,
`pusherExtendM`, `valveOpenM`, `screwOnM`. That is where the **GUI** attaches,
and the logic behind it works today.

The **labeller** slots between the outfeed end and the `bottleDone` channel
that currently reports straight to the coordinator. Make the conveyor send to
the labeller and let the labeller report onward; the rendezvous then gives
backpressure for free.

The **recycling station** needs a quality decision that nothing in the line
currently makes, and a diverter that does not exist.

---

## Three things to settle as a group

1. **The end of the outfeed is getting crowded.** The labeller and the
   recycling station are both machines at the same end of the same belt. That
   junction wants one design agreed between two people, not two designs
   discovered at integration.
2. **Who owns the operator panel.** The manual override inputs are the GUI's
   attachment point; a visualisation feed would attach at the same place. Two
   IPs, one screen, unless we decide otherwise now.
3. **What we are deliberately skipping.** Fault injection, bottle size meaning
   anything outside filling, and the Baxter robot. Better an explicit decision
   than an accidental one.
