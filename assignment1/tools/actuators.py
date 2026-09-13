#!/usr/bin/env python3
"""
The one place that says which actuators the operator panel can drive.

Generates, from the table below:

  sysj/operatorPanel.sysj    the panel clock domain, one output per actuator
  src/ManualActuator.java    the catalogue the GUI builds its buttons from
  tools/genxml_manual.py     the routing fragment genxml.py imports

Adding an actuator is one row here, then `python3 tools/actuators.py` and
`python3 tools/genxml.py`.  Nothing else should ever be hand-edited.
"""

import io
import os

# machine key, CD name, panel label, [(actuator signal, button label)]
MACHINES = [
    ("bl", "BottleLoaderControllerCD", "Bottle loader", [
        ("vacOn",                 "Vacuum on"),
        ("release",               "Release"),
        ("armSource",             "Arm to supply"),
        ("armDest",               "Arm to conveyor"),
    ]),
    ("cv", "ConveyorControllerCD", "Conveyor", [
        ("motInfeed",             "Infeed belt"),
        ("takeFromPos1",          "Lift off position 1"),
        ("motOutfeed",            "Outfeed belt"),
        ("injectInfeed",          "Set bottle on infeed"),
        ("injectOutfeed",         "Set bottle on outfeed"),
        ("collectFromEnd",        "Take off at the end"),
    ]),
    ("rt", "RotaryTableControllerCD", "Rotary table", [
        ("rotaryTrigger",         "Index 60 degrees"),
        ("loadPos1",              "Place at position 1"),
        ("unloadExit",            "Unload position 6"),
    ]),
    ("f1", "Filler1ControllerCD", "Filler 1", [
        ("valveOpen",             "Valve open"),
    ]),
    ("f2", "Filler2ControllerCD", "Filler 2", [
        ("valveOpen",             "Valve open"),
    ]),
    ("ll", "LidLoaderControllerCD", "Lid loader", [
        ("pusherExtend",          "Magazine pusher"),
        ("vacOn",                 "Vacuum on"),
        ("armSource",             "Arm to pick-up"),
        ("armDest",               "Arm to bottle"),
        ("refill",                "Refill magazine"),
    ]),
    ("cp", "CapperControllerCD", "Capper", [
        ("screwOn",               "Screw down"),
    ]),
    ("lb", "LabellerControllerCD", "Labeller", [
        ("applyLabelExtend",      "Applicator out"),
        ("applyLabelRetract",     "Applicator back"),
        ("rollerOnOff",           "Glue roller"),
    ]),
    ("sp", "SplitterControllerCD", "Quality splitter", [
        ("diverterExtend",        "Diverter to reject"),
        ("diverterRetract",       "Diverter to normal"),
        ("admitBottle",           "Admit from outfeed"),
    ]),
    ("rc", "RecyclingConveyorControllerCD", "Recycling conveyor", [
        ("recyclingConveyorMotor", "Belt"),
        ("injectAtEntry",         "Set bottle at entry"),
        ("collectAtReturn",       "Take off at return"),
    ]),
    ("lr", "LidRemovalControllerCD", "Lid removal", [
        ("cylZaxisExtend",        "Head down"),
        ("unscrewTurnExtend",     "Untwist"),
        ("unscrewTurnRetract",    "Twist back"),
        ("lidGripperExtend",      "Gripper close"),
        ("lidEjectExtend",        "Eject lid"),
    ]),
    ("ld", "LiquidDumperControllerCD", "Liquid dumper", [
        ("cylClampBottleExtend",  "Clamp bottle"),
        ("invertRotateExtend",    "Invert"),
        ("invertRotateRetract",   "Upright"),
        ("drainValveOnOff",       "Drain valve"),
    ]),
    ("br", "BottleReturnControllerCD", "Bottle return", [
        ("motorOnOff",            "Collector belt"),
        ("transferArmExtend",     "Transfer arm out"),
        ("transferArmRetract",    "Transfer arm back"),
    ]),
]

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))


def out_name(key, actuator):
    """Panel-side signal name, e.g. ('bl', 'vacOn') -> 'blVacOn'."""
    return key + actuator[0].upper() + actuator[1:]


def entries():
    for key, cd, label, acts in MACHINES:
        for actuator, button in acts:
            yield key, cd, label, actuator, button, out_name(key, actuator)


def write(path, text):
    full = os.path.join(ROOT, path)
    io.open(full, "w", encoding="utf-8", newline="\n").write(text)
    print("wrote " + path)


def sysj():
    rows = list(entries())
    decls = []
    for i in range(0, len(rows), 4):
        names = ", ".join(r[5] for r in rows[i:i + 4])
        decls.append("\t\toutput signal " + names + ";")
    # One reaction per machine. Not decoration: the compiler expands the
    # branches inside a reaction combinatorially, and thirty-three tests in
    # one reaction exhausts a 3 GB heap. Split by machine it is five at most.
    blocks = []
    for key, cd, label, acts in MACHINES:
        lines = ['\t{ // ' + label, '\t\twhile(true){']
        for actuator, button in acts:
            lines.append('\t\t\tif(ManualDrive.held("%s.%s")){ emit %s; }'
                         % (key, actuator, out_name(key, actuator)))
        lines.append('\t\t\tpause;')
        lines.append('\t\t}')
        lines.append('\t}')
        blocks.append("\n".join(lines))
    body = ["\n\t||\n".join(blocks)]
    return """/*
 * Operator panel.
 *
 * The manual counterpart to the System Controller: where that one runs the
 * automatic production plan, this one carries an operator's hands onto the
 * plant. Each output is wired to one machine's manual input for one actuator,
 * so a press here asserts exactly one actuator signal and nothing else
 * decides what it means.
 *
 * Every controller ignores these while its mode input reads 0, so this domain
 * can emit freely and the plant only listens once the line is genuinely in
 * manual. That keeps the arbitration in one place - the mode signal - rather
 * than spread across thirteen machines.
 *
 * ManualDrive is a mailbox filled by the GUI on its own thread, never read
 * from a socket inside a tick. It expires by itself if the panel stops
 * talking, so a closed window or a dropped connection releases every actuator
 * rather than leaving one asserted.
 *
 * GENERATED by tools/actuators.py - edit the table there, not this file.
 */
OperatorPanel(
%s
\t\t)
->
{
%s
}
""" % ("\n".join(decls), "\n".join(body))


def catalogue():
    rows = list(entries())
    items = []
    for key, cd, label, actuator, button, name in rows:
        items.append('\t\tnew ManualActuator("%s.%s", "%s", "%s")'
                     % (key, actuator, label, button))
    return """import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * One operator-panel button: the actuator it drives and the words on it.
 *
 * The panel clock domain and the GUI are generated from the same table, so a
 * button can never name an actuator the plant does not have.
 *
 * GENERATED by tools/actuators.py - edit the table there, not this file.
 */
public final class ManualActuator {

\tpublic final String id;
\tpublic final String machine;
\tpublic final String label;

\tprivate ManualActuator(String id, String machine, String label) {
\t\tthis.id = id;
\t\tthis.machine = machine;
\t\tthis.label = label;
\t}

\tprivate static final ManualActuator[] ALL = {
%s
\t};

\tpublic static List<ManualActuator> all() {
\t\tList<ManualActuator> list = new ArrayList<ManualActuator>();
\t\tfor (ManualActuator a : ALL) {
\t\t\tlist.add(a);
\t\t}
\t\treturn Collections.unmodifiableList(list);
\t}

\t/** Machine labels in plant order, for grouping the panel. */
\tpublic static List<String> machines() {
\t\tList<String> names = new ArrayList<String>();
\t\tfor (ManualActuator a : ALL) {
\t\t\tif (!names.contains(a.machine)) {
\t\t\t\tnames.add(a.machine);
\t\t\t}
\t\t}
\t\treturn Collections.unmodifiableList(names);
\t}

\tpublic String toString() {
\t\treturn machine + " / " + label;
\t}
}
""" % (",\n".join(items))


def routing():
    lines = []
    for key, cd, label, actuator, button, name in entries():
        lines.append('    "%s": "%s.%sM",' % (name, cd, actuator))
    return '''"""
Where each operator-panel output lands.

GENERATED by tools/actuators.py - edit the table there, not this file.
"""

MANUAL = {
%s
}
''' % ("\n".join(lines))


if __name__ == "__main__":
    write("sysj/operatorPanel.sysj", sysj())
    write("src/ManualActuator.java", catalogue())
    write("tools/genxml_manual.py", routing())
    print("%d actuators across %d machines" % (len(list(entries())), len(MACHINES)))
