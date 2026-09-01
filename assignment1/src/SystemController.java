import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class SystemController extends ClockDomain{
  public SystemController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleLoaded = new Signal("bottleLoaded", Signal.INPUT);
  public Signal bottleAtLabeller = new Signal("bottleAtLabeller", Signal.INPUT);
  public Signal mode = new Signal("mode", Signal.OUTPUT);
  public Signal bottleLoad = new Signal("bottleLoad", Signal.OUTPUT);
  public Signal enableBL = new Signal("enableBL", Signal.OUTPUT);
  public Signal enableCV = new Signal("enableCV", Signal.OUTPUT);
  public Signal enableRT = new Signal("enableRT", Signal.OUTPUT);
  public Signal enableST = new Signal("enableST", Signal.OUTPUT);
  private int delivered_thread_5;//sysj\systemController.sysj line: 59, column: 3
  private boolean seen_thread_5;//sysj\systemController.sysj line: 60, column: 3
  private int cycles_thread_4;//sysj\systemController.sysj line: 38, column: 3
  private int i_thread_4;//sysj\systemController.sysj line: 39, column: 3
  private int S4689 = 1;
  private int S4604 = 1;
  private int S4609 = 1;
  private int S4673 = 1;
  private int S4610 = 1;
  private int S4619 = 1;
  private int S4687 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread4699(int [] tdone, int [] ends){
        switch(S4687){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(bottleAtLabeller.getprestatus()){//sysj\systemController.sysj line: 63, column: 12
          if(!seen_thread_5) {//sysj\systemController.sysj line: 64, column: 14
            delivered_thread_5 = delivered_thread_5 + 1;//sysj\systemController.sysj line: 65, column: 6
            seen_thread_5 = true;//sysj\systemController.sysj line: 66, column: 6
            System.out.println("[SC] Bottle " + delivered_thread_5 + " reached the labeller.");//sysj\systemController.sysj line: 67, column: 6
          }
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          seen_thread_5 = false;//sysj\systemController.sysj line: 71, column: 5
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread4698(int [] tdone, int [] ends){
        switch(S4673){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S4610){
          case 0 : 
            S4610=0;
            S4610=1;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 1 : 
            S4610=1;
            S4610=2;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 2 : 
            S4610=2;
            S4610=3;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 3 : 
            S4610=3;
            S4610=4;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 4 : 
            S4610=4;
            cycles_thread_4 = 4;//sysj\systemController.sysj line: 38, column: 3
            i_thread_4 = 0;//sysj\systemController.sysj line: 39, column: 3
            S4610=5;
            if(i_thread_4 < cycles_thread_4){//sysj\systemController.sysj line: 41, column: 9
              System.out.println("[SC] Requesting bottle load " + (i_thread_4 + 1) + " of " + cycles_thread_4 + "...");//sysj\systemController.sysj line: 42, column: 4
              S4619=0;
              bottleLoad.setPresent();//sysj\systemController.sysj line: 45, column: 5
              currsigs.addElement(bottleLoad);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj\systemController.sysj line: 41, column: 3
              System.out.println("[SC] All " + cycles_thread_4 + " load requests issued.");//sysj\systemController.sysj line: 54, column: 3
              S4610=6;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 5 : 
            switch(S4619){
              case 0 : 
                if(bottleLoaded.getprestatus()){//sysj\systemController.sysj line: 44, column: 10
                  i_thread_4 = i_thread_4 + 1;//sysj\systemController.sysj line: 48, column: 4
                  System.out.println("[SC] Bottle " + i_thread_4 + " loaded onto conveyor.");//sysj\systemController.sysj line: 49, column: 4
                  S4619=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  bottleLoad.setPresent();//sysj\systemController.sysj line: 45, column: 5
                  currsigs.addElement(bottleLoad);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S4619=1;
                S4619=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 2 : 
                S4619=2;
                S4619=3;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 3 : 
                S4619=3;
                if(i_thread_4 < cycles_thread_4){//sysj\systemController.sysj line: 41, column: 9
                  System.out.println("[SC] Requesting bottle load " + (i_thread_4 + 1) + " of " + cycles_thread_4 + "...");//sysj\systemController.sysj line: 42, column: 4
                  S4619=0;
                  bottleLoad.setPresent();//sysj\systemController.sysj line: 45, column: 5
                  currsigs.addElement(bottleLoad);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  ends[4]=2;
                  ;//sysj\systemController.sysj line: 41, column: 3
                  System.out.println("[SC] All " + cycles_thread_4 + " load requests issued.");//sysj\systemController.sysj line: 54, column: 3
                  S4610=6;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 6 : 
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread4697(int [] tdone, int [] ends){
        switch(S4609){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        enableBL.setPresent();//sysj\systemController.sysj line: 27, column: 4
        currsigs.addElement(enableBL);
        enableCV.setPresent();//sysj\systemController.sysj line: 28, column: 4
        currsigs.addElement(enableCV);
        enableRT.setPresent();//sysj\systemController.sysj line: 29, column: 4
        currsigs.addElement(enableRT);
        enableST.setPresent();//sysj\systemController.sysj line: 30, column: 4
        currsigs.addElement(enableST);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread4696(int [] tdone, int [] ends){
        switch(S4604){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        mode.setPresent();//sysj\systemController.sysj line: 20, column: 4
        currsigs.addElement(mode);
        mode.setValue(0);//sysj\systemController.sysj line: 20, column: 4
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread4694(int [] tdone, int [] ends){
        S4687=1;
    delivered_thread_5 = 0;//sysj\systemController.sysj line: 59, column: 3
    seen_thread_5 = false;//sysj\systemController.sysj line: 60, column: 3
    if(bottleAtLabeller.getprestatus()){//sysj\systemController.sysj line: 63, column: 12
      if(!seen_thread_5) {//sysj\systemController.sysj line: 64, column: 14
        delivered_thread_5 = delivered_thread_5 + 1;//sysj\systemController.sysj line: 65, column: 6
        seen_thread_5 = true;//sysj\systemController.sysj line: 66, column: 6
        System.out.println("[SC] Bottle " + delivered_thread_5 + " reached the labeller.");//sysj\systemController.sysj line: 67, column: 6
      }
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      seen_thread_5 = false;//sysj\systemController.sysj line: 71, column: 5
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread4693(int [] tdone, int [] ends){
        S4673=1;
    S4610=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread4692(int [] tdone, int [] ends){
        S4609=1;
    enableBL.setPresent();//sysj\systemController.sysj line: 27, column: 4
    currsigs.addElement(enableBL);
    enableCV.setPresent();//sysj\systemController.sysj line: 28, column: 4
    currsigs.addElement(enableCV);
    enableRT.setPresent();//sysj\systemController.sysj line: 29, column: 4
    currsigs.addElement(enableRT);
    enableST.setPresent();//sysj\systemController.sysj line: 30, column: 4
    currsigs.addElement(enableST);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread4691(int [] tdone, int [] ends){
        S4604=1;
    mode.setPresent();//sysj\systemController.sysj line: 20, column: 4
    currsigs.addElement(mode);
    mode.setValue(0);//sysj\systemController.sysj line: 20, column: 4
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
      switch(S4689){
        case 0 : 
          S4689=0;
          break RUN;
        
        case 1 : 
          S4689=2;
          S4689=2;
          thread4691(tdone,ends);
          thread4692(tdone,ends);
          thread4693(tdone,ends);
          thread4694(tdone,ends);
          int biggest4695 = 0;
          if(ends[2]>=biggest4695){
            biggest4695=ends[2];
          }
          if(ends[3]>=biggest4695){
            biggest4695=ends[3];
          }
          if(ends[4]>=biggest4695){
            biggest4695=ends[4];
          }
          if(ends[5]>=biggest4695){
            biggest4695=ends[5];
          }
          if(biggest4695 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread4696(tdone,ends);
          thread4697(tdone,ends);
          thread4698(tdone,ends);
          thread4699(tdone,ends);
          int biggest4700 = 0;
          if(ends[2]>=biggest4700){
            biggest4700=ends[2];
          }
          if(ends[3]>=biggest4700){
            biggest4700=ends[3];
          }
          if(ends[4]>=biggest4700){
            biggest4700=ends[4];
          }
          if(ends[5]>=biggest4700){
            biggest4700=ends[5];
          }
          if(biggest4700 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest4700 == 0){
            S4689=0;
            active[1]=0;
            ends[1]=0;
            S4689=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0};
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
          bottleLoaded.gethook();
          bottleAtLabeller.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleLoaded.setpreclear();
      bottleAtLabeller.setpreclear();
      mode.setpreclear();
      bottleLoad.setpreclear();
      enableBL.setpreclear();
      enableCV.setpreclear();
      enableRT.setpreclear();
      enableST.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleLoaded.getStatus() ? bottleLoaded.setprepresent() : bottleLoaded.setpreclear();
      bottleLoaded.setpreval(bottleLoaded.getValue());
      bottleLoaded.setClear();
      dummyint = bottleAtLabeller.getStatus() ? bottleAtLabeller.setprepresent() : bottleAtLabeller.setpreclear();
      bottleAtLabeller.setpreval(bottleAtLabeller.getValue());
      bottleAtLabeller.setClear();
      mode.sethook();
      mode.setClear();
      bottleLoad.sethook();
      bottleLoad.setClear();
      enableBL.sethook();
      enableBL.setClear();
      enableCV.sethook();
      enableCV.setClear();
      enableRT.sethook();
      enableRT.setClear();
      enableST.sethook();
      enableST.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleLoaded.gethook();
        bottleAtLabeller.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
