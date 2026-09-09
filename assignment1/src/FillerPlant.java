import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class FillerPlant extends ClockDomain{
  public FillerPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal valveOpen = new Signal("valveOpen", Signal.INPUT);
  public Signal fillTarget = new Signal("fillTarget", Signal.INPUT);
  public Signal filled = new Signal("filled", Signal.OUTPUT);
  private int RATE_thread_1;//sysj/fillerPlant.sysj line: 15, column: 2
  private int target_thread_1;//sysj/fillerPlant.sysj line: 17, column: 2
  private int poured_thread_1;//sysj/fillerPlant.sysj line: 18, column: 2
  private int S39155 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S39155){
        case 0 : 
          S39155=0;
          break RUN;
        
        case 1 : 
          S39155=2;
          S39155=2;
          RATE_thread_1 = 20;//sysj/fillerPlant.sysj line: 15, column: 2
          target_thread_1 = 0;//sysj/fillerPlant.sysj line: 17, column: 2
          poured_thread_1 = 0;//sysj/fillerPlant.sysj line: 18, column: 2
          if(enable.getprestatus()){//sysj/fillerPlant.sysj line: 21, column: 11
            if(valveOpen.getprestatus()){//sysj/fillerPlant.sysj line: 22, column: 12
              if(fillTarget.getprestatus()){//sysj/fillerPlant.sysj line: 23, column: 13
                target_thread_1 = (Integer)(fillTarget.getpreval() == null ? null : ((Integer)fillTarget.getpreval()));//sysj/fillerPlant.sysj line: 24, column: 6
                if(poured_thread_1 < target_thread_1) {//sysj/fillerPlant.sysj line: 26, column: 24
                  poured_thread_1 += RATE_thread_1;//sysj/fillerPlant.sysj line: 27, column: 6
                  if(poured_thread_1 > target_thread_1) {//sysj/fillerPlant.sysj line: 28, column: 25
                    poured_thread_1 = target_thread_1;//sysj/fillerPlant.sysj line: 28, column: 27
                  }
                }
                if(target_thread_1 > 0 && poured_thread_1 >= target_thread_1){//sysj/fillerPlant.sysj line: 30, column: 8
                  filled.setPresent();//sysj/fillerPlant.sysj line: 31, column: 6
                  currsigs.addElement(filled);
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
                if(poured_thread_1 < target_thread_1) {//sysj/fillerPlant.sysj line: 26, column: 24
                  poured_thread_1 += RATE_thread_1;//sysj/fillerPlant.sysj line: 27, column: 6
                  if(poured_thread_1 > target_thread_1) {//sysj/fillerPlant.sysj line: 28, column: 25
                    poured_thread_1 = target_thread_1;//sysj/fillerPlant.sysj line: 28, column: 27
                  }
                }
                if(target_thread_1 > 0 && poured_thread_1 >= target_thread_1){//sysj/fillerPlant.sysj line: 30, column: 8
                  filled.setPresent();//sysj/fillerPlant.sysj line: 31, column: 6
                  currsigs.addElement(filled);
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
              target_thread_1 = 0;//sysj/fillerPlant.sysj line: 38, column: 5
              poured_thread_1 = 0;//sysj/fillerPlant.sysj line: 39, column: 5
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
          if(enable.getprestatus()){//sysj/fillerPlant.sysj line: 21, column: 11
            if(valveOpen.getprestatus()){//sysj/fillerPlant.sysj line: 22, column: 12
              if(fillTarget.getprestatus()){//sysj/fillerPlant.sysj line: 23, column: 13
                target_thread_1 = (Integer)(fillTarget.getpreval() == null ? null : ((Integer)fillTarget.getpreval()));//sysj/fillerPlant.sysj line: 24, column: 6
                if(poured_thread_1 < target_thread_1) {//sysj/fillerPlant.sysj line: 26, column: 24
                  poured_thread_1 += RATE_thread_1;//sysj/fillerPlant.sysj line: 27, column: 6
                  if(poured_thread_1 > target_thread_1) {//sysj/fillerPlant.sysj line: 28, column: 25
                    poured_thread_1 = target_thread_1;//sysj/fillerPlant.sysj line: 28, column: 27
                  }
                }
                if(target_thread_1 > 0 && poured_thread_1 >= target_thread_1){//sysj/fillerPlant.sysj line: 30, column: 8
                  filled.setPresent();//sysj/fillerPlant.sysj line: 31, column: 6
                  currsigs.addElement(filled);
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
                if(poured_thread_1 < target_thread_1) {//sysj/fillerPlant.sysj line: 26, column: 24
                  poured_thread_1 += RATE_thread_1;//sysj/fillerPlant.sysj line: 27, column: 6
                  if(poured_thread_1 > target_thread_1) {//sysj/fillerPlant.sysj line: 28, column: 25
                    poured_thread_1 = target_thread_1;//sysj/fillerPlant.sysj line: 28, column: 27
                  }
                }
                if(target_thread_1 > 0 && poured_thread_1 >= target_thread_1){//sysj/fillerPlant.sysj line: 30, column: 8
                  filled.setPresent();//sysj/fillerPlant.sysj line: 31, column: 6
                  currsigs.addElement(filled);
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
              target_thread_1 = 0;//sysj/fillerPlant.sysj line: 38, column: 5
              poured_thread_1 = 0;//sysj/fillerPlant.sysj line: 39, column: 5
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
          valveOpen.gethook();
          fillTarget.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      valveOpen.setpreclear();
      fillTarget.setpreclear();
      filled.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = valveOpen.getStatus() ? valveOpen.setprepresent() : valveOpen.setpreclear();
      valveOpen.setpreval(valveOpen.getValue());
      valveOpen.setClear();
      dummyint = fillTarget.getStatus() ? fillTarget.setprepresent() : fillTarget.setpreclear();
      fillTarget.setpreval(fillTarget.getValue());
      fillTarget.setClear();
      filled.sethook();
      filled.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        valveOpen.gethook();
        fillTarget.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
