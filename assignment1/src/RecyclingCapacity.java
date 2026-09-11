/** Finite simulated recycling receptacle, serviced only at a safe machine boundary. */
public final class RecyclingCapacity {
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
