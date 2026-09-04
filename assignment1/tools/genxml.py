"""Generates sysj/abs.xml and the per-machine XMLs from the .sysj interfaces.

Edit a machine's interface, rerun this, and the wiring follows. Nothing here
is hand-maintained, so the XML cannot drift from the code.
"""
import re, os

# clock domain -> (class, .sysj file, port it listens on)
CDS = [
    ("PosStubCD",                "PosStub",              "posStub",              10000),
    ("SystemControllerCD",       "SystemController",     "systemController",     10001),
    ("BottleLoaderControllerCD", "BottleLoaderController","bottleLoaderController",11000),
    ("BottleLoaderPlantCD",      "BottleLoaderPlant",    "bottleLoaderPlant",    11001),
    ("ConveyorControllerCD",     "ConveyorController",   "conveyorController",   12000),
    ("ConveyorPlantCD",          "ConveyorPlant",        "conveyorPlant",        12001),
    ("RotaryTableControllerCD",  "RotaryTableController","rotaryTableController",13000),
    ("RotaryTablePlantCD",       "RotaryTablePlant",     "rotaryTablePlant",     13001),
    ("Filler1ControllerCD",      "FillerController",     "fillerController",     14000),
    ("Filler1PlantCD",           "FillerPlant",          "fillerPlant",          14001),
    ("Filler2ControllerCD",      "FillerController",     "fillerController",     14100),
    ("Filler2PlantCD",           "FillerPlant",          "fillerPlant",          14101),
    ("LidLoaderControllerCD",    "LidLoaderController",  "lidLoaderController",  14200),
    ("LidLoaderPlantCD",         "LidLoaderPlant",       "lidLoaderPlant",       14201),
    ("CapperControllerCD",       "CapperController",     "capperController",     14300),
    ("CapperPlantCD",            "CapperPlant",          "capperPlant",          14301),
]

# Where each output signal goes. "*" means every output of that CD goes to one
# place under the same name; otherwise name the target as "CD.signalName".
SIGNALS = {
    "BottleLoaderPlantCD":      {"*": "BottleLoaderControllerCD"},
    "BottleLoaderControllerCD": {"*": "BottleLoaderPlantCD"},
    "ConveyorPlantCD":          {"*": "ConveyorControllerCD"},
    "ConveyorControllerCD":     {"*": "ConveyorPlantCD"},
    "RotaryTablePlantCD":       {"*": "RotaryTableControllerCD"},
    "RotaryTableControllerCD":  {"*": "RotaryTablePlantCD"},
    "Filler1ControllerCD":      {"*": "Filler1PlantCD"},
    "Filler1PlantCD":           {"*": "Filler1ControllerCD"},
    "Filler2ControllerCD":      {"*": "Filler2PlantCD"},
    "Filler2PlantCD":           {"*": "Filler2ControllerCD"},
    "LidLoaderControllerCD":    {"*": "LidLoaderPlantCD"},
    "LidLoaderPlantCD":         {"*": "LidLoaderControllerCD"},
    "CapperControllerCD":       {"*": "CapperPlantCD"},
    "CapperPlantCD":            {"*": "CapperControllerCD"},
    "SystemControllerCD": {
        "modeBL": "BottleLoaderControllerCD.mode",
        "modeF1": "Filler1ControllerCD.mode",
        "modeF2": "Filler2ControllerCD.mode",
        "modeLL": "LidLoaderControllerCD.mode",
        "modeCP": "CapperControllerCD.mode",
        "enableBL": "BottleLoaderPlantCD.enable",
        "enableCV": "ConveyorPlantCD.enable",
        "enableRT": "RotaryTablePlantCD.enable",
        "enableF1": "Filler1PlantCD.enable",
        "enableF2": "Filler2PlantCD.enable",
        "enableLL": "LidLoaderPlantCD.enable",
        "enableCP": "CapperPlantCD.enable",
    },
}

# Where each output channel goes, as "CD.channelName".
CHANNELS = {
    "PosStubCD":                {"order": "SystemControllerCD.purchaseOrder"},
    "SystemControllerCD":       {"orderProgress": "PosStubCD.completed",
                                 "loadOrder": "BottleLoaderControllerCD.loadOrder"},
    "BottleLoaderControllerCD": {"loadAck": "SystemControllerCD.loadAck",
                                 "bottleHandoff": "ConveyorControllerCD.bottleHandoff"},
    "ConveyorControllerCD":     {"tableInfeed": "RotaryTableControllerCD.tableInfeed",
                                 "bottleDone": "SystemControllerCD.bottleDone"},
    "RotaryTableControllerCD":  {"tableOutfeed": "ConveyorControllerCD.tableOutfeed",
                                 "startFiller1": "Filler1ControllerCD.start",
                                 "startFiller2": "Filler2ControllerCD.start",
                                 "startLid": "LidLoaderControllerCD.start",
                                 "startCapper": "CapperControllerCD.start"},
    "Filler1ControllerCD":      {"done": "RotaryTableControllerCD.doneFiller1"},
    "Filler2ControllerCD":      {"done": "RotaryTableControllerCD.doneFiller2"},
    "LidLoaderControllerCD":    {"done": "RotaryTableControllerCD.doneLid"},
    "CapperControllerCD":       {"done": "RotaryTableControllerCD.doneCapper"},
}

SERVER = 'Class="com.systemj.ipc.SimpleServer" IP="127.0.0.1" Port="%d"'
CLIENT = 'Class="com.systemj.ipc.SimpleClient" IP="127.0.0.1" Port="%d"'


def interface(path):
    """Pull the input/output signal and channel names out of a .sysj file."""
    s = re.sub(r"//.*", "", re.sub(r"/\*.*?\*/", "", open(path).read(), flags=re.S))
    body = re.search(r"\w+\s*\((.*?)\)\s*->", s, flags=re.S).group(1)
    out = {"is": [], "os": [], "ic": [], "oc": []}
    for decl in body.split(";"):
        d = " ".join(decl.split())
        m = re.match(r"(input|output) \w+ channel (.*)$", d)
        if m:
            out["ic" if m.group(1) == "input" else "oc"] += [x.strip() for x in m.group(2).split(",")]
            continue
        m = re.match(r"(input|output) (?:\w+ )?signal (.*)$", d)
        if m:
            out["is" if m.group(1) == "input" else "os"] += [x.strip() for x in m.group(2).split(",")]
    return out


def target(cd, name, table):
    """Resolve an output to 'TargetCD.name', honouring renames and '*'."""
    entry = table.get(cd, {})
    dest = entry.get(name) or entry.get("*")
    if dest is None:
        raise SystemExit("no destination for %s.%s" % (cd, name))
    return dest if "." in dest else dest + "." + name


def main():
    here = os.path.dirname(os.path.abspath(__file__))
    sysj = os.path.join(here, "..", "sysj")
    port = {cd: p for cd, _, _, p in CDS}
    blocks = {}

    for cd, cls, src, p in CDS:
        i = interface(os.path.join(sysj, src + ".sysj"))
        L = ['\t\t<ClockDomain Name="%s" Class="%s">' % (cd, cls)]
        for ch in i["ic"]:
            src_cd = next(c for c, t in CHANNELS.items() for k, v in t.items() if v == cd + "." + ch)
            src_ch = next(k for k, v in CHANNELS[src_cd].items() if v == cd + "." + ch)
            L.append('\t\t\t<iChannel Name="%-14s From="%s.%s" />' % (ch + '"', src_cd, src_ch))
        for ch in i["oc"]:
            L.append('\t\t\t<oChannel Name="%-14s To="%s" />' % (ch + '"', target(cd, ch, CHANNELS)))
        if i["ic"] or i["oc"]:
            L.append("")
        for sg in i["is"]:
            L.append('\t\t\t<iSignal Name="%-16s %s />' % (sg + '"', SERVER % p))
        for sg in i["os"]:
            t = target(cd, sg, SIGNALS)
            L.append('\t\t\t<oSignal Name="%-16s To="%-38s %s />'
                     % (sg + '"', t + '"', CLIENT % port[t.split(".")[0]]))
        L.append("\t\t</ClockDomain>")
        blocks[cd] = L

    head = ('<?xml version="1.0" encoding="UTF-8"?>\n'
            '<!-- Generated by tools/genxml.py from the .sysj interfaces. Do not hand-edit. -->\n'
            '<System xmlns="http://systemjtechnology.com">\n')
    body = []
    for cd, _, _, _ in CDS:
        body += blocks[cd] + [""]
    open(os.path.join(sysj, "abs.xml"), "w").write(
        head + '\t<SubSystem Name="ABS" Local="true">\n\n' + "\n".join(body)
        + "\t</SubSystem>\n</System>\n")

    # One file per clock domain, named after the domain rather than the
    # source, because the fillers are two instances of one class.
    machines = os.path.join(sysj, "machines")
    if not os.path.isdir(machines):
        os.makedirs(machines)
    for cd, _, _, _ in CDS:
        open(os.path.join(machines, cd + ".xml"), "w").write(
            head + '\t<SubSystem Name="%s" Local="true">\n' % cd
            + "\n".join(blocks[cd]) + "\n\t</SubSystem>\n</System>\n")

    print("generated abs.xml and %d machine XMLs" % len(CDS))


main()
