/** Timed drain and tank bookkeeping for the liquid-dumper plant reaction. */
public final class DumperDrainCycle {
    private final int drainTime, invertedPosition;
    private final RecyclingCapacity tank=new RecyclingCapacity("Waste tank",RecyclingCapacity.WASTE_TANK);
    private int elapsed;
    private boolean drained;
    public DumperDrainCycle(int drainTime,int invertedPosition) { this.drainTime=drainTime; this.invertedPosition=invertedPosition; }
    public void openValve(int angle) {
        if(angle==invertedPosition && !drained && ++elapsed>=drainTime) {
            drained=true; elapsed=0; tank.add();
            System.out.println("[LDPlant] Contents drained to the waste tank (level "+tank.level()+").");
        }
    }
    public boolean drained() { return drained; }
    public int level() { return tank.level(); }
    public void finishTick(int clamp,int angle) { drained=tank.serviceDumper(clamp,angle,drained); }
}
