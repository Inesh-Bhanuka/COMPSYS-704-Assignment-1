import re,glob,os,sys
PORT={"BottleLoaderControllerCD":11000,"BottleLoaderPlantCD":11001,
      "ConveyorControllerCD":12000,"ConveyorPlantCD":12001,"SystemControllerCD":12002,
      "RotaryTableControllerCD":13000,"RotaryTablePlantCD":13001,"StationStubsCD":13003}
CLS={"BottleLoaderController":"BottleLoaderControllerCD","BottleLoaderPlant":"BottleLoaderPlantCD",
     "ConveyorController":"ConveyorControllerCD","ConveyorPlant":"ConveyorPlantCD",
     "SystemController":"SystemControllerCD","RotaryTableController":"RotaryTableControllerCD",
     "RotaryTablePlant":"RotaryTablePlantCD","StationStubs":"StationStubsCD"}
ORDER=["BottleLoaderPlantCD","BottleLoaderControllerCD","ConveyorPlantCD","ConveyorControllerCD",
       "RotaryTablePlantCD","RotaryTableControllerCD","StationStubsCD","SystemControllerCD"]
SIGDEST={  # (source CD, signal) -> destination CD
 ("BottleLoaderPlantCD","*"):"BottleLoaderControllerCD",
 ("BottleLoaderControllerCD","*"):"BottleLoaderPlantCD",
 ("ConveyorPlantCD","*"):"ConveyorControllerCD",
 ("ConveyorControllerCD","*"):"ConveyorPlantCD",
 ("RotaryTablePlantCD","*"):"RotaryTableControllerCD",
 ("RotaryTableControllerCD","*"):"RotaryTablePlantCD",
 ("SystemControllerCD","mode"):"BottleLoaderControllerCD",
 ("SystemControllerCD","enableBL"):"BottleLoaderPlantCD.enable",
 ("SystemControllerCD","enableCV"):"ConveyorPlantCD.enable",
 ("SystemControllerCD","enableRT"):"RotaryTablePlantCD.enable",
 ("SystemControllerCD","enableST"):"StationStubsCD.enable"}
CHAN={ # source CD -> {channel: dest CD}
 "SystemControllerCD":{"loadOrder":"BottleLoaderControllerCD"},
 "BottleLoaderControllerCD":{"loadAck":"SystemControllerCD","bottleHandoff":"ConveyorControllerCD"},
 "ConveyorControllerCD":{"tableInfeed":"RotaryTableControllerCD","bottleDone":"SystemControllerCD"},
 "RotaryTableControllerCD":{"tableOutfeed":"ConveyorControllerCD","startFiller1":"StationStubsCD",
   "startFiller2":"StationStubsCD","startLid":"StationStubsCD","startCapper":"StationStubsCD"},
 "StationStubsCD":{"doneFiller1":"RotaryTableControllerCD","doneFiller2":"RotaryTableControllerCD",
   "doneLid":"RotaryTableControllerCD","doneCapper":"RotaryTableControllerCD"}}
def iface(path):
    s=open(path).read(); s=re.sub(r"/\*.*?\*/","",s,flags=re.S); s=re.sub(r"//.*","",s)
    m=re.search(r"(\w+)\s*\((.*?)\)\s*->",s,flags=re.S)
    cls=m.group(1); r={"is":[],"os":[],"ic":[],"oc":[]}
    for d in m.group(2).split(";"):
        d=" ".join(d.split())
        mc=re.match(r"(input|output) \w+ channel (.*)$",d)
        ms=re.match(r"(input|output) (?:\w+ )?signal (.*)$",d)
        if mc: r["ic" if mc.group(1)=="input" else "oc"]+= [x.strip() for x in mc.group(2).split(",")]
        elif ms: r["is" if ms.group(1)=="input" else "os"]+= [x.strip() for x in ms.group(2).split(",")]
    return cls,r
cds={}
for f in glob.glob("sysj/*.sysj"):
    cls,r=iface(f)
    if cls in CLS: cds[CLS[cls]]=(cls,r)
src_of_chan={}
for s,d in CHAN.items():
    for ch,dst in d.items(): src_of_chan[(dst,ch)]=s
L=['<?xml version="1.0" encoding="UTF-8"?>','<System xmlns="http://systemjtechnology.com">',
   '\t<SubSystem Name="ABS" Local="true">','']
for cd in ORDER:
    cls,r=cds[cd]; p=PORT[cd]
    L.append('\t\t<ClockDomain Name="%s" Class="%s">'%(cd,cls))
    for ch in r["ic"]:
        s=src_of_chan.get((cd,ch))
        assert s, "no sender for %s.%s"%(cd,ch)
        L.append('\t\t\t<iChannel Name="%-13s From="%s.%s" />'%(ch+'"',s,ch))
    for ch in r["oc"]:
        d=CHAN[cd][ch]
        L.append('\t\t\t<oChannel Name="%-13s To="%s.%s" />'%(ch+'"',d,ch))
    if r["ic"] or r["oc"]: L.append('')
    for sg in r["is"]:
        L.append('\t\t\t<iSignal Name="%-16s Class="com.systemj.ipc.SimpleServer" IP="127.0.0.1" Port="%d" />'%(sg+'"',p))
    for sg in r["os"]:
        d=SIGDEST.get((cd,sg)) or SIGDEST[(cd,"*")]
        # a destination may rename the signal: "CD.otherName"
        dcd,dsig=(d.split(".",1)+[sg])[:2] if "." in d else (d,sg)
        L.append('\t\t\t<oSignal Name="%-16s To="%-34s Class="com.systemj.ipc.SimpleClient" IP="127.0.0.1" Port="%d" />'%(sg+'"',dcd+"."+dsig+'"',PORT[dcd]))
    L.append('\t\t</ClockDomain>'); L.append('')
L+=['\t</SubSystem>','</System>','']
open("sysj/abs.xml","w").write("\n".join(L))

# Regenerate each machine's own XML from the same source, so the per-machine
# files can never drift out of step with abs.xml or with the .sysj interfaces.
FILE={"BottleLoaderPlantCD":"bottleLoaderPlant","BottleLoaderControllerCD":"bottleLoaderController",
      "ConveyorPlantCD":"conveyorPlant","ConveyorControllerCD":"conveyorController",
      "RotaryTablePlantCD":"turntablePlant","RotaryTableControllerCD":"turntableController",
      "StationStubsCD":"stationStubs","SystemControllerCD":"systemController"}
blocks={}
cur=None
for line in L:
    m=re.search(r'<ClockDomain Name="(\w+)"',line)
    if m: cur=m.group(1); blocks[cur]=[line]; continue
    if cur:
        blocks[cur].append(line)
        if "</ClockDomain>" in line: cur=None
head=('<?xml version="1.0" encoding="UTF-8"?>\n'
      '<!--\n  One machine\'s interface, generated by tools/genxml.py from the .sysj\n'
      '  sources. Do not hand-edit: change the .sysj interface and regenerate.\n-->\n'
      '<System xmlns="http://systemjtechnology.com">\n\t<SubSystem Name="%s" Local="true">\n')
for cd,b in blocks.items():
    open("sysj/%s.xml"%FILE[cd],"w").write(head%FILE[cd] + "\n".join(b) + "\n\t</SubSystem>\n</System>\n")
print("generated abs.xml and", len(blocks), "machine XMLs")
