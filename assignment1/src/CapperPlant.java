import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class CapperPlant extends ClockDomain{
  public CapperPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal screwOn = new Signal("screwOn", Signal.INPUT);
  public Signal capSeated = new Signal("capSeated", Signal.OUTPUT);
  private int TURNS_thread_1;//sysj\capperPlant.sysj line: 11, column: 2
  private int turned_thread_1;//sysj\capperPlant.sysj line: 12, column: 2
  private int S27933 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S27933){
        case 0 : 
          S27933=0;
          break RUN;
        
        case 1 : 
          S27933=2;
          S27933=2;
          TURNS_thread_1 = 12;//sysj\capperPlant.sysj line: 11, column: 2
          turned_thread_1 = 0;//sysj\capperPlant.sysj line: 12, column: 2
          if(enable.getprestatus()){//sysj\capperPlant.sysj line: 15, column: 11
            if(screwOn.getprestatus()){//sysj\capperPlant.sysj line: 16, column: 12
              if(turned_thread_1 < TURNS_thread_1) {//sysj\capperPlant.sysj line: 17, column: 23
                turned_thread_1 = turned_thread_1 + 1;//sysj\capperPlant.sysj line: 17, column: 25
              }
              if(turned_thread_1 >= TURNS_thread_1){//sysj\capperPlant.sysj line: 18, column: 8
                capSeated.setPresent();//sysj\capperPlant.sysj line: 18, column: 26
                currsigs.addElement(capSeated);
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
            else {
              turned_thread_1 = 0;//sysj\capperPlant.sysj line: 21, column: 5
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
          else {
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          if(enable.getprestatus()){//sysj\capperPlant.sysj line: 15, column: 11
            if(screwOn.getprestatus()){//sysj\capperPlant.sysj line: 16, column: 12
              if(turned_thread_1 < TURNS_thread_1) {//sysj\capperPlant.sysj line: 17, column: 23
                turned_thread_1 = turned_thread_1 + 1;//sysj\capperPlant.sysj line: 17, column: 25
              }
              if(turned_thread_1 >= TURNS_thread_1){//sysj\capperPlant.sysj line: 18, column: 8
                capSeated.setPresent();//sysj\capperPlant.sysj line: 18, column: 26
                currsigs.addElement(capSeated);
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
            else {
              turned_thread_1 = 0;//sysj\capperPlant.sysj line: 21, column: 5
              active[1]=1;
              ends[1]=1;
              break RUN;
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
          screwOn.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      screwOn.setpreclear();
      capSeated.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = screwOn.getStatus() ? screwOn.setprepresent() : screwOn.setpreclear();
      screwOn.setpreval(screwOn.getValue());
      screwOn.setClear();
      capSeated.sethook();
      capSeated.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        screwOn.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
