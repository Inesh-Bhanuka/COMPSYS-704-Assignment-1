import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class BottleLoaderPlant extends ClockDomain{
  public BottleLoaderPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal vacOn = new Signal("vacOn", Signal.INPUT);
  public Signal release = new Signal("release", Signal.INPUT);
  public Signal armSource = new Signal("armSource", Signal.INPUT);
  public Signal armDest = new Signal("armDest", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal bottleAtSource = new Signal("bottleAtSource", Signal.OUTPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.OUTPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.OUTPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.OUTPUT);
  public Signal supplyEmpty = new Signal("supplyEmpty", Signal.OUTPUT);
  private int supply_thread_3;//sysj\bottleLoaderPlant.sysj line: 37, column: 3
  private boolean holding_thread_3;//sysj\bottleLoaderPlant.sysj line: 38, column: 3
  private int S1333 = 1;
  private int S1203 = 1;
  private int S1175 = 1;
  private int S1331 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread1339(int [] tdone, int [] ends){
        switch(S1331){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\bottleLoaderPlant.sysj line: 41, column: 12
          if(holding_thread_3){//sysj\bottleLoaderPlant.sysj line: 43, column: 5
            if(release.getprestatus()){//sysj\bottleLoaderPlant.sysj line: 45, column: 14
              holding_thread_3 = false;//sysj\bottleLoaderPlant.sysj line: 46, column: 7
              System.out.println("[BLPlant] Bottle released.");//sysj\bottleLoaderPlant.sysj line: 47, column: 7
              if(holding_thread_3){//sysj\bottleLoaderPlant.sysj line: 65, column: 5
                WPgripped.setPresent();//sysj\bottleLoaderPlant.sysj line: 66, column: 6
                currsigs.addElement(WPgripped);
                if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
                  bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
                  currsigs.addElement(bottleAtSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
                  currsigs.addElement(supplyEmpty);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
                  bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
                  currsigs.addElement(bottleAtSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
                  currsigs.addElement(supplyEmpty);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
            }
            else {
              if(holding_thread_3){//sysj\bottleLoaderPlant.sysj line: 65, column: 5
                WPgripped.setPresent();//sysj\bottleLoaderPlant.sysj line: 66, column: 6
                currsigs.addElement(WPgripped);
                if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
                  bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
                  currsigs.addElement(bottleAtSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
                  currsigs.addElement(supplyEmpty);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
                  bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
                  currsigs.addElement(bottleAtSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
                  currsigs.addElement(supplyEmpty);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
            }
          }
          else {
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\bottleLoaderPlant.sysj line: 53, column: 14
              if(supply_thread_3 > 0) {//sysj\bottleLoaderPlant.sysj line: 54, column: 21
                supply_thread_3 = supply_thread_3 - 1;//sysj\bottleLoaderPlant.sysj line: 55, column: 8
                holding_thread_3 = true;//sysj\bottleLoaderPlant.sysj line: 56, column: 8
                System.out.println("[BLPlant] Bottle picked, supply = " + supply_thread_3);//sysj\bottleLoaderPlant.sysj line: 57, column: 8
              }
              else {//sysj\bottleLoaderPlant.sysj line: 59, column: 12
                System.out.println("[BLPlant] Pick attempted but supply is empty.");//sysj\bottleLoaderPlant.sysj line: 60, column: 8
              }
              if(holding_thread_3){//sysj\bottleLoaderPlant.sysj line: 65, column: 5
                WPgripped.setPresent();//sysj\bottleLoaderPlant.sysj line: 66, column: 6
                currsigs.addElement(WPgripped);
                if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
                  bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
                  currsigs.addElement(bottleAtSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
                  currsigs.addElement(supplyEmpty);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
                  bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
                  currsigs.addElement(bottleAtSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
                  currsigs.addElement(supplyEmpty);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
            }
            else {
              if(holding_thread_3){//sysj\bottleLoaderPlant.sysj line: 65, column: 5
                WPgripped.setPresent();//sysj\bottleLoaderPlant.sysj line: 66, column: 6
                currsigs.addElement(WPgripped);
                if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
                  bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
                  currsigs.addElement(bottleAtSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
                  currsigs.addElement(supplyEmpty);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
                  bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
                  currsigs.addElement(bottleAtSource);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
                  currsigs.addElement(supplyEmpty);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
            }
          }
        }
        else {
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread1338(int [] tdone, int [] ends){
        switch(S1203){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S1175){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\bottleLoaderPlant.sysj line: 27, column: 10
              S1175=1;
              armAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 31, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\bottleLoaderPlant.sysj line: 28, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\bottleLoaderPlant.sysj line: 30, column: 10
              S1175=0;
              armAtDest.setPresent();//sysj\bottleLoaderPlant.sysj line: 28, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 31, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1336(int [] tdone, int [] ends){
        S1331=1;
    supply_thread_3 = 20;//sysj\bottleLoaderPlant.sysj line: 37, column: 3
    holding_thread_3 = false;//sysj\bottleLoaderPlant.sysj line: 38, column: 3
    if(enable.getprestatus()){//sysj\bottleLoaderPlant.sysj line: 41, column: 12
      if(holding_thread_3){//sysj\bottleLoaderPlant.sysj line: 43, column: 5
        if(release.getprestatus()){//sysj\bottleLoaderPlant.sysj line: 45, column: 14
          holding_thread_3 = false;//sysj\bottleLoaderPlant.sysj line: 46, column: 7
          System.out.println("[BLPlant] Bottle released.");//sysj\bottleLoaderPlant.sysj line: 47, column: 7
          if(holding_thread_3){//sysj\bottleLoaderPlant.sysj line: 65, column: 5
            WPgripped.setPresent();//sysj\bottleLoaderPlant.sysj line: 66, column: 6
            currsigs.addElement(WPgripped);
            if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
              bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
              currsigs.addElement(bottleAtSource);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
              currsigs.addElement(supplyEmpty);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
          else {
            if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
              bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
              currsigs.addElement(bottleAtSource);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
              currsigs.addElement(supplyEmpty);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
        }
        else {
          if(holding_thread_3){//sysj\bottleLoaderPlant.sysj line: 65, column: 5
            WPgripped.setPresent();//sysj\bottleLoaderPlant.sysj line: 66, column: 6
            currsigs.addElement(WPgripped);
            if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
              bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
              currsigs.addElement(bottleAtSource);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
              currsigs.addElement(supplyEmpty);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
          else {
            if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
              bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
              currsigs.addElement(bottleAtSource);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
              currsigs.addElement(supplyEmpty);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
        }
      }
      else {
        if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\bottleLoaderPlant.sysj line: 53, column: 14
          if(supply_thread_3 > 0) {//sysj\bottleLoaderPlant.sysj line: 54, column: 21
            supply_thread_3 = supply_thread_3 - 1;//sysj\bottleLoaderPlant.sysj line: 55, column: 8
            holding_thread_3 = true;//sysj\bottleLoaderPlant.sysj line: 56, column: 8
            System.out.println("[BLPlant] Bottle picked, supply = " + supply_thread_3);//sysj\bottleLoaderPlant.sysj line: 57, column: 8
          }
          else {//sysj\bottleLoaderPlant.sysj line: 59, column: 12
            System.out.println("[BLPlant] Pick attempted but supply is empty.");//sysj\bottleLoaderPlant.sysj line: 60, column: 8
          }
          if(holding_thread_3){//sysj\bottleLoaderPlant.sysj line: 65, column: 5
            WPgripped.setPresent();//sysj\bottleLoaderPlant.sysj line: 66, column: 6
            currsigs.addElement(WPgripped);
            if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
              bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
              currsigs.addElement(bottleAtSource);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
              currsigs.addElement(supplyEmpty);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
          else {
            if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
              bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
              currsigs.addElement(bottleAtSource);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
              currsigs.addElement(supplyEmpty);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
        }
        else {
          if(holding_thread_3){//sysj\bottleLoaderPlant.sysj line: 65, column: 5
            WPgripped.setPresent();//sysj\bottleLoaderPlant.sysj line: 66, column: 6
            currsigs.addElement(WPgripped);
            if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
              bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
              currsigs.addElement(bottleAtSource);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
              currsigs.addElement(supplyEmpty);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
          else {
            if(supply_thread_3 > 0){//sysj\bottleLoaderPlant.sysj line: 69, column: 8
              bottleAtSource.setPresent();//sysj\bottleLoaderPlant.sysj line: 70, column: 6
              currsigs.addElement(bottleAtSource);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              supplyEmpty.setPresent();//sysj\bottleLoaderPlant.sysj line: 73, column: 6
              currsigs.addElement(supplyEmpty);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
        }
      }
    }
    else {
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread1335(int [] tdone, int [] ends){
        S1203=1;
    S1175=0;
    armAtDest.setPresent();//sysj\bottleLoaderPlant.sysj line: 28, column: 5
    currsigs.addElement(armAtDest);
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S1333){
        case 0 : 
          S1333=0;
          break RUN;
        
        case 1 : 
          S1333=2;
          S1333=2;
          thread1335(tdone,ends);
          thread1336(tdone,ends);
          int biggest1337 = 0;
          if(ends[2]>=biggest1337){
            biggest1337=ends[2];
          }
          if(ends[3]>=biggest1337){
            biggest1337=ends[3];
          }
          if(biggest1337 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread1338(tdone,ends);
          thread1339(tdone,ends);
          int biggest1340 = 0;
          if(ends[2]>=biggest1340){
            biggest1340=ends[2];
          }
          if(ends[3]>=biggest1340){
            biggest1340=ends[3];
          }
          if(biggest1340 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1340 == 0){
            S1333=0;
            active[1]=0;
            ends[1]=0;
            S1333=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0};
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
          vacOn.gethook();
          release.gethook();
          armSource.gethook();
          armDest.gethook();
          enable.gethook();
          df = true;
        }
        runClockDomain();
      }
      vacOn.setpreclear();
      release.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      enable.setpreclear();
      bottleAtSource.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      supplyEmpty.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = vacOn.getStatus() ? vacOn.setprepresent() : vacOn.setpreclear();
      vacOn.setpreval(vacOn.getValue());
      vacOn.setClear();
      dummyint = release.getStatus() ? release.setprepresent() : release.setpreclear();
      release.setpreval(release.getValue());
      release.setClear();
      dummyint = armSource.getStatus() ? armSource.setprepresent() : armSource.setpreclear();
      armSource.setpreval(armSource.getValue());
      armSource.setClear();
      dummyint = armDest.getStatus() ? armDest.setprepresent() : armDest.setpreclear();
      armDest.setpreval(armDest.getValue());
      armDest.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      bottleAtSource.sethook();
      bottleAtSource.setClear();
      WPgripped.sethook();
      WPgripped.setClear();
      armAtSource.sethook();
      armAtSource.setClear();
      armAtDest.sethook();
      armAtDest.setClear();
      supplyEmpty.sethook();
      supplyEmpty.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        vacOn.gethook();
        release.gethook();
        armSource.gethook();
        armDest.gethook();
        enable.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
