"""Generates sysj/abs.xml and the per-machine XMLs from the .sysj interfaces.

Edit a machine's interface, rerun this, and the wiring follows. Nothing here
is hand-maintained, so the XML cannot drift from the code. Add a machine by
adding one row to CDS and its links to SIGNALS and CHANNELS.
"""
import re, os

# clock domain -> (class, .sysj file, port it listens on)
CDS = [
    ("GUIInterfaceCD", "GUIInterface", "guiInterface", 10002),
    ("POSCD",                         "POS",                         "pos",                         10000),
    ("SystemControllerCD",            "SystemController",            "systemController",            10001),

    ("BottleLoaderControllerCD",      "BottleLoaderController",      "bottleLoaderController",      11000),
    ("BottleLoaderPlantCD",           "BottleLoaderPlant",           "bottleLoaderPlant",           11001),
    ("ConveyorControllerCD",          "ConveyorController",          "conveyorController",          12000),
    ("ConveyorPlantCD",               "ConveyorPlant",               "conveyorPlant",               12001),
    ("RotaryTableControllerCD",       "RotaryTableController",       "rotaryTableController",       13000),
    ("RotaryTablePlantCD",            "RotaryTablePlant",            "rotaryTablePlant",            13001),

    ("Filler1ControllerCD",           "FillerController",            "fillerController",            14000),
    ("Filler1PlantCD",                "FillerPlant",                 "fillerPlant",                 14001),
    ("Filler2ControllerCD",           "FillerController",            "fillerController",            14100),
    ("Filler2PlantCD",                "FillerPlant",                 "fillerPlant",                 14101),
    ("LidLoaderControllerCD",         "LidLoaderController",         "lidLoaderController",         14200),
    ("LidLoaderPlantCD",              "LidLoaderPlant",              "lidLoaderPlant",              14201),
    ("CapperControllerCD",            "CapperController",            "capperController",            14300),
    ("CapperPlantCD",                 "CapperPlant",                 "capperPlant",                 14301),
    ("LabellerControllerCD",          "LabellerController",          "labellerController",          14400),
    ("LabellerPlantCD",               "LabellerPlant",               "labellerPlant",               14401),

    ("RecyclingStationControllerCD",  "RecyclingStationController",  "recyclingStationController",  15000),
    ("SplitterControllerCD",          "SplitterController",          "splitterController",          15100),
    ("SplitterPlantCD",               "SplitterPlant",               "splitterPlant",               15101),
    ("RecyclingConveyorControllerCD", "RecyclingConveyorController", "recyclingConveyorController", 15200),
    ("RecyclingConveyorPlantCD",      "RecyclingConveyorPlant",      "recyclingConveyorPlant",      15201),
    ("LidRemovalControllerCD",        "LidRemovalController",        "lidRemovalController",        15300),
    ("LidRemovalPlantCD",             "LidRemovalPlant",             "lidRemovalPlant",             15301),
    ("LiquidDumperControllerCD",      "LiquidDumperController",      "liquidDumperController",      15400),
    ("LiquidDumperPlantCD",           "LiquidDumperPlant",           "liquidDumperPlant",           15401),
    ("BottleReturnControllerCD",      "BottleReturnController",      "bottleReturnController",      15500),
    ("BottleReturnPlantCD",           "BottleReturnPlant",           "bottleReturnPlant",           15501),
]

# Where each output signal goes. "*" sends every remaining output of that CD to
# one place under the same name; a named entry overrides it and may rename.
SIGNALS = {
    "GUIInterfaceCD": {"Command": "SystemControllerCD.guiCommand"},
    "POSCD": {"purchaseOrder": "SystemControllerCD.purchaseOrder"},
    "BottleLoaderPlantCD":      {"*": "BottleLoaderControllerCD"},
    "ConveyorPlantCD":          {"*": "ConveyorControllerCD"},
    "RotaryTablePlantCD":       {"*": "RotaryTableControllerCD"},
    "Filler1PlantCD":           {"*": "Filler1ControllerCD"},
    "Filler2PlantCD":           {"*": "Filler2ControllerCD"},
    "LidLoaderPlantCD":         {"*": "LidLoaderControllerCD"},
    "CapperPlantCD":            {"*": "CapperControllerCD"},
    "LabellerPlantCD":          {"*": "LabellerControllerCD"},
    "SplitterPlantCD":          {"*": "SplitterControllerCD"},
    "RecyclingConveyorPlantCD": {"*": "RecyclingConveyorControllerCD"},
    "LidRemovalPlantCD":        {"*": "LidRemovalControllerCD"},
    "LiquidDumperPlantCD":      {"*": "LiquidDumperControllerCD"},
    "BottleReturnPlantCD":      {"*": "BottleReturnControllerCD"},

    # Controllers drive their own plant, and publish their machine twin to the
    # coordinator. The twin is the only thing that leaves a machine.
    "BottleLoaderControllerCD": {"*": "BottleLoaderPlantCD", "twin": "SystemControllerCD.twinBL"},
    "ConveyorControllerCD":     {"*": "ConveyorPlantCD",     "twin": "SystemControllerCD.twinCV"},
    "RotaryTableControllerCD":  {"*": "RotaryTablePlantCD",  "twin": "SystemControllerCD.twinRT"},
    "Filler1ControllerCD":      {"*": "Filler1PlantCD",      "twin": "SystemControllerCD.twinF1"},
    "Filler2ControllerCD":      {"*": "Filler2PlantCD",      "twin": "SystemControllerCD.twinF2"},
    "LidLoaderControllerCD":    {"*": "LidLoaderPlantCD",    "twin": "SystemControllerCD.twinLL"},
    "CapperControllerCD":       {"*": "CapperPlantCD",       "twin": "SystemControllerCD.twinCP"},
    "LabellerControllerCD":     {"*": "LabellerPlantCD",     "twin": "SystemControllerCD.twinLB",
                                 "status": "SystemControllerCD.labellerStatus"},
    "SplitterControllerCD":          {"*": "SplitterPlantCD"},
    "RecyclingConveyorControllerCD": {"*": "RecyclingConveyorPlantCD"},
    "LidRemovalControllerCD":        {"*": "LidRemovalPlantCD"},
    "LiquidDumperControllerCD":      {"*": "LiquidDumperPlantCD"},
    "BottleReturnControllerCD":      {"*": "BottleReturnPlantCD"},

    "RecyclingStationControllerCD": {"recyclingStatus": "SystemControllerCD.recyclingStatus"},

    "SystemControllerCD": {
        "guiStatus": "GUIInterfaceCD.Status",
        "permitRT": "RotaryTableControllerCD.operatorPermit",
        "permitF1": "Filler1ControllerCD.operatorPermit",
        "permitF2": "Filler2ControllerCD.operatorPermit",
        "permitLL": "LidLoaderControllerCD.operatorPermit",
        "permitCP": "CapperControllerCD.operatorPermit",
        "permitCV": "ConveyorControllerCD.operatorPermit",
        "permitLB": "LabellerControllerCD.operatorPermit",
        "permitRC": "RecyclingStationControllerCD.operatorPermit",
        "productionStatus": "POSCD.productionStatus",
        "modeBL": "BottleLoaderControllerCD.mode",
        "modeF1": "Filler1ControllerCD.mode",
        "modeF2": "Filler2ControllerCD.mode",
        "modeLL": "LidLoaderControllerCD.mode",
        "modeCP": "CapperControllerCD.mode",
        "modeLB": "LabellerControllerCD.mode",
        "modeSP": "SplitterControllerCD.mode",
        "modeRC": "RecyclingConveyorControllerCD.mode",
        "modeLR": "LidRemovalControllerCD.mode",
        "modeLD": "LiquidDumperControllerCD.mode",
        "modeBR": "BottleReturnControllerCD.mode",
        "enableBL": "BottleLoaderPlantCD.enable",
        "enableCV": "ConveyorPlantCD.enable",
        "enableRT": "RotaryTablePlantCD.enable",
        "enableF1": "Filler1PlantCD.enable",
        "enableF2": "Filler2PlantCD.enable",
        "enableLL": "LidLoaderPlantCD.enable",
        "enableCP": "CapperPlantCD.enable",
        "enableLB": "LabellerPlantCD.enable",
        "enableSP": "SplitterPlantCD.enable",
        "enableRC": "RecyclingConveyorPlantCD.enable",
        "enableLR": "LidRemovalPlantCD.enable",
        "enableLD": "LiquidDumperPlantCD.enable",
        "enableBR": "BottleReturnPlantCD.enable",
    },
}

# Where each output channel goes, as "CD.channelName".
CHANNELS = {
    "SystemControllerCD":       {"loadOrder": "BottleLoaderControllerCD.loadOrder",
                                 "labelBottle": "LabellerControllerCD.labelBottle",
                                 "bottleRejected": "RecyclingStationControllerCD.bottleRejected"},
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
    "LabellerControllerCD":     {"labelDone": "SystemControllerCD.labelDone"},

    "RecyclingStationControllerCD": {"bottleRecycled": "SystemControllerCD.bottleRecycled",
                                     "enableSplitter": "SplitterControllerCD.enable",
                                     "enableLidRemoval": "LidRemovalControllerCD.enable",
                                     "enableDumper": "LiquidDumperControllerCD.enable",
                                     "enableReturn": "BottleReturnControllerCD.enable",
                                     "enableConveyor": "RecyclingConveyorControllerCD.enable"},
    "SplitterControllerCD":          {"status": "RecyclingStationControllerCD.statusSplitter"},
    "RecyclingConveyorControllerCD": {"status": "RecyclingStationControllerCD.statusConveyor"},
    "LidRemovalControllerCD":        {"status": "RecyclingStationControllerCD.statusLidRemoval"},
    "LiquidDumperControllerCD":      {"status": "RecyclingStationControllerCD.statusDumper"},
    "BottleReturnControllerCD":      {"status": "RecyclingStationControllerCD.statusReturn"},
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
        raise SystemExit("genxml: no destination for %s.%s" % (cd, name))
    return dest if "." in dest else dest + "." + name


def main():
    here = os.path.dirname(os.path.abspath(__file__))
    sysj = os.path.join(here, "..", "sysj")
    port = {cd: p for cd, _, _, p in CDS}
    blocks = {}

    # every channel endpoint, so an iChannel can name where it comes from
    source = {}
    for cd, links in CHANNELS.items():
        for name, dest in links.items():
            source[dest] = cd + "." + name

    for cd, cls, src, p in CDS:
        i = interface(os.path.join(sysj, src + ".sysj"))
        L = ['\t\t<ClockDomain Name="%s" Class="%s">' % (cd, cls)]
        for ch in i["ic"]:
            frm = source.get(cd + "." + ch)
            if frm is None:
                raise SystemExit("genxml: nothing sends to %s.%s" % (cd, ch))
            L.append('\t\t\t<iChannel Name="%-16s From="%s" />' % (ch + '"', frm))
        for ch in i["oc"]:
            L.append('\t\t\t<oChannel Name="%-16s To="%s" />' % (ch + '"', target(cd, ch, CHANNELS)))
        if i["ic"] or i["oc"]:
            L.append("")
        for sg in i["is"]:
            L.append('\t\t\t<iSignal Name="%-18s %s />' % (sg + '"', SERVER % p))
        for sg in i["os"]:
            t = target(cd, sg, SIGNALS)
            tcd = t.split(".")[0]
            client = CLIENT % port[tcd]
            if cd == "SystemControllerCD" and sg == "guiStatus":
                client = client.replace("com.systemj.ipc.SimpleClient", "GuiStatusSender")
            L.append('\t\t\t<oSignal Name="%-18s To="%-42s %s />'
                     % (sg + '"', t + '"', client))
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

    # One file per clock domain, named after the domain rather than the source,
    # because the fillers are two instances of one class.
    machines = os.path.join(sysj, "machines")
    if not os.path.isdir(machines):
        os.makedirs(machines)
    for cd, _, _, _ in CDS:
        open(os.path.join(machines, cd + ".xml"), "w").write(
            head + '\t<SubSystem Name="%s" Local="true">\n' % cd
            + "\n".join(blocks[cd]) + "\n\t</SubSystem>\n</System>\n")

    print("generated abs.xml and %d machine XMLs" % len(CDS))


main()
