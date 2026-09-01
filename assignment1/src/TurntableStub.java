import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class TurntableStub extends ClockDomain{
  public TurntableStub(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal bottleToTable = new Signal("bottleToTable", Signal.INPUT);
  public Signal tableReady = new Signal("tableReady", Signal.OUTPUT);
  public Signal bottleFromTable = new Signal("bottleFromTable", Signal.OUTPUT);
  private int STEPS_thread_1;//sysj\turntableController.sysj line: 16, column: 2
  private int HOLD_thread_1;//sysj\turntableController.sysj line: 17, column: 2
  private int busy_thread_1;//sysj\turntableController.sysj line: 19, column: 2
  private int announce_thread_1;//sysj\turntableController.sysj line: 20, column: 2
  private int S3846 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S3846){
        case 0 : 
          S3846=0;
          break RUN;
        
        case 1 : 
          S3846=2;
          S3846=2;
          STEPS_thread_1 = 12;//sysj\turntableController.sysj line: 16, column: 2
          HOLD_thread_1 = 3;//sysj\turntableController.sysj line: 17, column: 2
          busy_thread_1 = 0;//sysj\turntableController.sysj line: 19, column: 2
          announce_thread_1 = 0;//sysj\turntableController.sysj line: 20, column: 2
          if(enable.getprestatus()){//sysj\turntableController.sysj line: 23, column: 11
            if(busy_thread_1 > 0){//sysj\turntableController.sysj line: 25, column: 7
              busy_thread_1 = busy_thread_1 - 1;//sysj\turntableController.sysj line: 26, column: 5
              if(busy_thread_1 == 0) {//sysj\turntableController.sysj line: 27, column: 18
                System.out.println("[TT] Processing complete - bottle at position 5.");//sysj\turntableController.sysj line: 28, column: 6
                announce_thread_1 = HOLD_thread_1;//sysj\turntableController.sysj line: 29, column: 6
              }
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
            else {
              if(announce_thread_1 > 0){//sysj\turntableController.sysj line: 32, column: 12
                bottleFromTable.setPresent();//sysj\turntableController.sysj line: 33, column: 5
                currsigs.addElement(bottleFromTable);
                announce_thread_1 = announce_thread_1 - 1;//sysj\turntableController.sysj line: 34, column: 5
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                tableReady.setPresent();//sysj\turntableController.sysj line: 37, column: 5
                currsigs.addElement(tableReady);
                if(bottleToTable.getprestatus()){//sysj\turntableController.sysj line: 38, column: 13
                  System.out.println("[TT] Bottle accepted - processing for " + STEPS_thread_1 + " ticks.");//sysj\turntableController.sysj line: 39, column: 6
                  busy_thread_1 = STEPS_thread_1;//sysj\turntableController.sysj line: 40, column: 6
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
          }
          else {
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          if(enable.getprestatus()){//sysj\turntableController.sysj line: 23, column: 11
            if(busy_thread_1 > 0){//sysj\turntableController.sysj line: 25, column: 7
              busy_thread_1 = busy_thread_1 - 1;//sysj\turntableController.sysj line: 26, column: 5
              if(busy_thread_1 == 0) {//sysj\turntableController.sysj line: 27, column: 18
                System.out.println("[TT] Processing complete - bottle at position 5.");//sysj\turntableController.sysj line: 28, column: 6
                announce_thread_1 = HOLD_thread_1;//sysj\turntableController.sysj line: 29, column: 6
              }
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
            else {
              if(announce_thread_1 > 0){//sysj\turntableController.sysj line: 32, column: 12
                bottleFromTable.setPresent();//sysj\turntableController.sysj line: 33, column: 5
                currsigs.addElement(bottleFromTable);
                announce_thread_1 = announce_thread_1 - 1;//sysj\turntableController.sysj line: 34, column: 5
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                tableReady.setPresent();//sysj\turntableController.sysj line: 37, column: 5
                currsigs.addElement(tableReady);
                if(bottleToTable.getprestatus()){//sysj\turntableController.sysj line: 38, column: 13
                  System.out.println("[TT] Bottle accepted - processing for " + STEPS_thread_1 + " ticks.");//sysj\turntableController.sysj line: 39, column: 6
                  busy_thread_1 = STEPS_thread_1;//sysj\turntableController.sysj line: 40, column: 6
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
          bottleToTable.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      bottleToTable.setpreclear();
      tableReady.setpreclear();
      bottleFromTable.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = bottleToTable.getStatus() ? bottleToTable.setprepresent() : bottleToTable.setpreclear();
      bottleToTable.setpreval(bottleToTable.getValue());
      bottleToTable.setClear();
      tableReady.sethook();
      tableReady.setClear();
      bottleFromTable.sethook();
      bottleFromTable.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        bottleToTable.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
