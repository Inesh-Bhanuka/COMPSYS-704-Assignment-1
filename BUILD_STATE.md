# ABS — build state

Where the SystemJ bottling system stands, how to run it, and what is left.
Current as of the `channels` branch, which is **three commits ahead and not
pushed**.

Checked against our conceptual design and Ahil's IP report rather than the
brief PDF — worth reconciling with the real document.

---

## Running it

One launch target. **Refresh the project (F5) first** — Eclipse only lists
`.launch` files it has scanned — then **Run As → RunABS**. That runs
`SystemJRunner` against `sysj/abs.xml`, which brings up all 29 clock domains
in one JVM. It runs forever by design; stop it with the red square.

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
paces off that. At the end it prints every workpiece history and an audit.

### If it does not start

- **No launch configs in the list** — the project name in `.project` must
  match what the `.launch` files expect (`assignment1`). Refresh after any
  change to the folder.
- **Missing-library errors** — `lib/` needs the SystemJ jars. They are in the
  repo now; a fresh clone should be fine.
- **`.git` lock file errors** — delete `.git/HEAD.lock` and
  `.git/objects/maintenance.lock` and retry.

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
| Outfeed belt | Built | Pulls the finished bottle off at position 6 |
| Quality splitter | **Misplaced** | Built and works, but wired downstream of the decision — see below |
| Labeller | Built | Prints from the workpiece twin; refuses what the record can't justify |
| Batch storage | Built | Where the line ends — labelled bottles retire onto their batch's shelf |
| Recycling station | Built | The branch: strip the lid, drain, return the container |

29 clock domains, 31 channels, every one point-to-point with one sender.

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

All 29 clock domains sit in a single `<SubSystem>`. Channels are wired by name
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

Two bottle sizes (100 and 200 ml) and arbitrary percentages per liquid; edit
`OrderBook` to change the run. Fill time comes out of the volume at 20 ml per
tick, so the sizes fall out of the model rather than being special-cased. The
fillers check `fits()` before opening a valve — a 200 ml bottle ordered at 70%
and 70% takes 140 ml and has the second fill refused.

Every machine also publishes a `MachineTwin`: an interpreted summary (status,
last command, last confirmation), not a mirror of its raw signals, so a
machine can be rebuilt without any consumer changing. The coordinator collects
them into an `ABSTwin`.

### For the GUI

`ABSTwin` goes out on **port 20000** and the live `PurchaseOrder` on **20001**,
via `com.systemj.netapi.TCPSender`, as complete snapshots every tick. A
display that misses one is a tick behind rather than out of step. There are
also **25 manual-override inputs** declared across the plant with nothing
driving them — one per actuator on every machine, including the recycling
station. That is the whole operator-panel attachment surface and it is ready.

### Fault injection

Two faults are armed in `OrderBook`: a bottle that arrives with a lid already
fitted, and a short fill. Each is caught by the station that meets it rather
than announced up front, so the history records where it was detected, not
where it was acted on. Comment out those two lines for a clean run.

This is also what finally made the recycling station execute — nothing in the
plant had ever called `reject()`, so six machines had never run a line.

### Last verified run

```
admitted 4, accepted 2, recovered 2
batch storage holds 2 bottle(s)
  batch 1: ABS-001-0001
  batch 2: ABS-002-0004
ok  serial ABS-001-0001 retrieves its own record
AUDIT PASSED - every bottle is accounted for and every label is justified
```

---

## The one thing that is wired wrong

**The quality splitter is downstream of the decision it is supposed to make.**

Both the interim report and the IP report say the outfeed carries a bottle to
the splitter, which routes it forward to the labeller and batch storage or
aside to the recycling station. What the code does is send every bottle to the
labeller, let the labeller refuse a flagged one, hand it to the recycling
station, and *then* fire the diverter — diverting a bottle off a belt it has
already left.

The splitter was built for the right place and the hook was left open:
`admitBottle` is described in its own header as the stand-in for the outfeed
releasing the workpiece. The fix is to have it take the bottle from the
coordinator, read the quality record off the twin it is holding, and drive the
diverter it already senses.

It is worth doing, because it makes the labeller's refusal the **backstop**
rather than the primary gate: a sensed diverter *and* a labeller that will not
print against a flagged record even if that diverter jams. Two independent
mechanisms is a much better validation story than one.

It changes the recycling station's interface, so it needs agreeing first.

---

## SystemJ gotchas we have already paid for

Read before writing more `.sysj`.

- Channel declarations put the type **before** the keyword:
  `input Integer channel x`, matching valued signals.
- Every loop needs a `pause` on every path. A `send` or `receive` does not
  count — the compiler rejects the loop outright.
- A Java object **or constant** declared at clock-domain level is not visible
  inside parallel reactions; each reaction gets its own scope. `TableModel`,
  `BeltQueue` and the rest go through a static accessor for this reason.
- Array initialisers in a reaction (`int[] x = {1,2,3}`) generate a broken
  type and fail at `javac`. `new int[n]` is fine.
- Conditional rendezvous are expensive. Four optional sends plus four optional
  receives is sixteen paths, and the compiler died on the JVM's 64 KB method
  limit before the barrier was made unconditional.
- A clock domain must never block on something outside the plant. `TCPSender`
  connects in its constructor, and building the twin publisher inside a
  reaction froze the entire system when no GUI was listening.
- Console output interleaves across clock domains. Print order is not
  evidence of timing.

---

## What is left

1. **Push the branch**, and move the splitter onto the outfeed.
2. **Real POS.** `PosStub` issues one hardcoded order of two batches. The
   channel and the `PurchaseOrder` object both already exist.
3. **Batch boundaries.** Finish a batch in full, then reconfigure — filler
   proportions, label content — before the next starts. `Batch.isComplete()`
   already knows; nothing acts on it, and a rejected bottle currently leaves a
   line item short forever.
4. **Mode, safety and overrides.** Mode reaches every machine but is only ever
   set to 0. Running, suspended, draining, reconfiguring, plus the §4.1.2
   conditions. "No opened bottles left across a suspension" is testable, so it
   will be tested.
5. **The GUI consuming Status and Events.** The twin already carries both —
   `ABSTwin` is the continuous state, every workpiece history is the discrete
   log. What is missing is a consumer.
6. **A `.gitattributes` with `* text=auto`.** Every diff currently shows tens
   of thousands of phantom line-ending changes.
