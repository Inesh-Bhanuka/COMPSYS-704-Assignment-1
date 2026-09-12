/**
 * Finite simulated recycling receptacle, serviced only at a safe machine boundary.
 *
 * ---- On the sizes below ----
 *
 * The three receptacles - the lid waste bin, the bottle collector and the
 * waste tank - are modelled because the design has to say what happens when
 * one fills: the machine finishes the container it is holding, reports
 * BLOCKED, and stops accepting work until servicing clears it, so the
 * back-pressure reaches the Recycling Station Controller at a clean boundary
 * rather than mid-cycle. That mechanism is the part worth having.
 *
 * Their capacities are not. Emptying a bin is a manual, out-of-scope activity
 * that the simulation stands in for with an automatic service after a few
 * ticks, so small capacities buy nothing: they just interrupt a demonstration
 * every third bottle with a full-then-immediately-serviced pair of messages
 * that says more about the stub than about the plant. They are therefore set
 * large enough that a demonstration run never reaches one, while the
 * full-and-blocked path stays in the code and stays reachable - set
 * -Dabs.lidBinCapacity=3 and it behaves exactly as it used to.
 */
public final class RecyclingCapacity {

    /** Lids the removal station's waste bin holds before it must be serviced. */
    public static final int LID_BIN = Integer.getInteger("abs.lidBinCapacity", 250).intValue();

    /** Containers the bottle return's collector bin holds. */
    public static final int BOTTLE_BIN = Integer.getInteger("abs.bottleBinCapacity", 250).intValue();

    /** Bottles' worth of liquid the dumper's waste tank holds. */
    public static final int WASTE_TANK = Integer.getInteger("abs.wasteTankCapacity", 250).intValue();

    /** Where the dumper starts reporting a warning rather than running clean. */
    public static final int WASTE_TANK_WARN = warn(WASTE_TANK);

    private static int warn(int capacity) {
        int w = capacity - capacity / 10;   // the last tenth of the tank
        return w < 1 ? 1 : w;
    }

    private final String name;
    private final int capacity;
    private int level, serviceTicks;
    public RecyclingCapacity(String name, int capacity) { this.name=name; this.capacity=capacity; }
    public int level() { return level; }
    public boolean full() { return level>=capacity; }
    // Keep compound predicates out of SystemJ's generated branch expansion.
    public void serviceReturn(int arm, boolean carrying, int position) { service(arm==0 && !carrying && position<0); }
    public boolean serviceDumper(int clamp, int angle, boolean drained) {
        boolean drainLatched=drained && clamp!=0;
        service(clamp==0 && angle==0 && !drainLatched);
        return drainLatched;
    }
    public void add() {
        if(full()) throw new IllegalStateException(name+" overflow: controller must wait for servicing");
        level++;
        if(full()) GuiSupervisor.event("-","RECYCLING",name+" full; simulated servicing pending.","INFO");
    }
    public void service(boolean machineSafe) {
        if(!full() || !machineSafe) { serviceTicks=0; return; }
        if(++serviceTicks>=5) {
            level=0; serviceTicks=0;
            GuiSupervisor.event("-","RECYCLING",name+" emptied by simulated servicing; capacity available.","INFO");
            System.out.println("[RECYCLING] "+name+" serviced.");
        }
    }
}
