import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class ConveyorStub extends ClockDomain{
  public ConveyorStub(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal bottlePlaced = new Signal("bottlePlaced", Signal.INPUT);
  public Signal conveyorReady = new Signal("conveyorReady", Signal.OUTPUT);
  private int busy_thread_1;//sysj\conveyorController.sysj line: 19, column: 2
  private int dwell_thread_1;//sysj\conveyorController.sysj line: 20, column: 2
  private int S1396 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S1396){
        case 0 : 
          S1396=0;
          break RUN;
        
        case 1 : 
          S1396=2;
          S1396=2;
          busy_thread_1 = 12;//sysj\conveyorController.sysj line: 19, column: 2
          dwell_thread_1 = 8;//sysj\conveyorController.sysj line: 20, column: 2
          if(enable.getprestatus()){//sysj\conveyorController.sysj line: 23, column: 11
            if(busy_thread_1 > 0){//sysj\conveyorController.sysj line: 24, column: 7
              busy_thread_1 = busy_thread_1 - 1;//sysj\conveyorController.sysj line: 25, column: 5
              System.out.println("[CV] " + busy_thread_1);//sysj\conveyorController.sysj line: 26, column: 5
              if(busy_thread_1 == 0) {//sysj\conveyorController.sysj line: 27, column: 18
                System.out.println("[CV] Ready to accept.");//sysj\conveyorController.sysj line: 28, column: 6
              }
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
            else {
              conveyorReady.setPresent();//sysj\conveyorController.sysj line: 32, column: 5
              currsigs.addElement(conveyorReady);
              if(bottlePlaced.getprestatus()){//sysj\conveyorController.sysj line: 33, column: 13
                System.out.println("[CV] Bottle received - busy for " + dwell_thread_1 + " ticks.");//sysj\conveyorController.sysj line: 34, column: 6
                busy_thread_1 = dwell_thread_1;//sysj\conveyorController.sysj line: 35, column: 6
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            }
          }
          else {
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          if(enable.getprestatus()){//sysj\conveyorController.sysj line: 23, column: 11
            if(busy_thread_1 > 0){//sysj\conveyorController.sysj line: 24, column: 7
              busy_thread_1 = busy_thread_1 - 1;//sysj\conveyorController.sysj line: 25, column: 5
              System.out.println("[CV] " + busy_thread_1);//sysj\conveyorController.sysj line: 26, column: 5
              if(busy_thread_1 == 0) {//sysj\conveyorController.sysj line: 27, column: 18
                System.out.println("[CV] Ready to accept.");//sysj\conveyorController.sysj line: 28, column: 6
              }
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
            else {
              conveyorReady.setPresent();//sysj\conveyorController.sysj line: 32, column: 5
              currsigs.addElement(conveyorReady);
              if(bottlePlaced.getprestatus()){//sysj\conveyorController.sysj line: 33, column: 13
                System.out.println("[CV] Bottle received - busy for " + dwell_thread_1 + " ticks.");//sysj\conveyorController.sysj line: 34, column: 6
                busy_thread_1 = dwell_thread_1;//sysj\conveyorController.sysj line: 35, column: 6
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            }
          }
          else {
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1};
    char [] paused1 = {0, 0};
    char [] suspended1 = {0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[1] != 0){
      int index = 1;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        if(!df){
          enable.gethook();
          bottlePlaced.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      bottlePlaced.setpreclear();
      conveyorReady.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = bottlePlaced.getStatus() ? bottlePlaced.setprepresent() : bottlePlaced.setpreclear();
      bottlePlaced.setpreval(bottlePlaced.getValue());
      bottlePlaced.setClear();
      conveyorReady.sethook();
      conveyorReady.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        bottlePlaced.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
