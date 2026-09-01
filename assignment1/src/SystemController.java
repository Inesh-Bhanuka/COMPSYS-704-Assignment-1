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
  public Signal enableTT = new Signal("enableTT", Signal.OUTPUT);
  private int delivered_thread_5;//sysj\systemController.sysj line: 57, column: 3
  private boolean seen_thread_5;//sysj\systemController.sysj line: 58, column: 3
  private int cycles_thread_4;//sysj\systemController.sysj line: 36, column: 3
  private int i_thread_4;//sysj\systemController.sysj line: 37, column: 3
  private int S3767 = 1;
  private int S3682 = 1;
  private int S3687 = 1;
  private int S3751 = 1;
  private int S3688 = 1;
  private int S3697 = 1;
  private int S3765 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread3777(int [] tdone, int [] ends){
        switch(S3765){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(bottleAtLabeller.getprestatus()){//sysj\systemController.sysj line: 61, column: 12
          if(!seen_thread_5) {//sysj\systemController.sysj line: 62, column: 14
            delivered_thread_5 = delivered_thread_5 + 1;//sysj\systemController.sysj line: 63, column: 6
            seen_thread_5 = true;//sysj\systemController.sysj line: 64, column: 6
            System.out.println("[SC] Bottle " + delivered_thread_5 + " reached the labeller.");//sysj\systemController.sysj line: 65, column: 6
          }
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          seen_thread_5 = false;//sysj\systemController.sysj line: 69, column: 5
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread3776(int [] tdone, int [] ends){
        switch(S3751){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S3688){
          case 0 : 
            S3688=0;
            S3688=1;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 1 : 
            S3688=1;
            S3688=2;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 2 : 
            S3688=2;
            S3688=3;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 3 : 
            S3688=3;
            S3688=4;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 4 : 
            S3688=4;
            cycles_thread_4 = 4;//sysj\systemController.sysj line: 36, column: 3
            i_thread_4 = 0;//sysj\systemController.sysj line: 37, column: 3
            S3688=5;
            if(i_thread_4 < cycles_thread_4){//sysj\systemController.sysj line: 39, column: 9
              System.out.println("[SC] Requesting bottle load " + (i_thread_4 + 1) + " of " + cycles_thread_4 + "...");//sysj\systemController.sysj line: 40, column: 4
              S3697=0;
              bottleLoad.setPresent();//sysj\systemController.sysj line: 43, column: 5
              currsigs.addElement(bottleLoad);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj\systemController.sysj line: 39, column: 3
              System.out.println("[SC] All " + cycles_thread_4 + " load requests issued.");//sysj\systemController.sysj line: 52, column: 3
              S3688=6;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 5 : 
            switch(S3697){
              case 0 : 
                if(bottleLoaded.getprestatus()){//sysj\systemController.sysj line: 42, column: 10
                  i_thread_4 = i_thread_4 + 1;//sysj\systemController.sysj line: 46, column: 4
                  System.out.println("[SC] Bottle " + i_thread_4 + " loaded onto conveyor.");//sysj\systemController.sysj line: 47, column: 4
                  S3697=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  bottleLoad.setPresent();//sysj\systemController.sysj line: 43, column: 5
                  currsigs.addElement(bottleLoad);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S3697=1;
                S3697=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 2 : 
                S3697=2;
                S3697=3;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 3 : 
                S3697=3;
                if(i_thread_4 < cycles_thread_4){//sysj\systemController.sysj line: 39, column: 9
                  System.out.println("[SC] Requesting bottle load " + (i_thread_4 + 1) + " of " + cycles_thread_4 + "...");//sysj\systemController.sysj line: 40, column: 4
                  S3697=0;
                  bottleLoad.setPresent();//sysj\systemController.sysj line: 43, column: 5
                  currsigs.addElement(bottleLoad);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  ends[4]=2;
                  ;//sysj\systemController.sysj line: 39, column: 3
                  System.out.println("[SC] All " + cycles_thread_4 + " load requests issued.");//sysj\systemController.sysj line: 52, column: 3
                  S3688=6;
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

  public void thread3775(int [] tdone, int [] ends){
        switch(S3687){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        enableBL.setPresent();//sysj\systemController.sysj line: 26, column: 4
        currsigs.addElement(enableBL);
        enableCV.setPresent();//sysj\systemController.sysj line: 27, column: 4
        currsigs.addElement(enableCV);
        enableTT.setPresent();//sysj\systemController.sysj line: 28, column: 4
        currsigs.addElement(enableTT);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread3774(int [] tdone, int [] ends){
        switch(S3682){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        mode.setPresent();//sysj\systemController.sysj line: 19, column: 4
        currsigs.addElement(mode);
        mode.setValue(0);//sysj\systemController.sysj line: 19, column: 4
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread3772(int [] tdone, int [] ends){
        S3765=1;
    delivered_thread_5 = 0;//sysj\systemController.sysj line: 57, column: 3
    seen_thread_5 = false;//sysj\systemController.sysj line: 58, column: 3
    if(bottleAtLabeller.getprestatus()){//sysj\systemController.sysj line: 61, column: 12
      if(!seen_thread_5) {//sysj\systemController.sysj line: 62, column: 14
        delivered_thread_5 = delivered_thread_5 + 1;//sysj\systemController.sysj line: 63, column: 6
        seen_thread_5 = true;//sysj\systemController.sysj line: 64, column: 6
        System.out.println("[SC] Bottle " + delivered_thread_5 + " reached the labeller.");//sysj\systemController.sysj line: 65, column: 6
      }
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      seen_thread_5 = false;//sysj\systemController.sysj line: 69, column: 5
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread3771(int [] tdone, int [] ends){
        S3751=1;
    S3688=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread3770(int [] tdone, int [] ends){
        S3687=1;
    enableBL.setPresent();//sysj\systemController.sysj line: 26, column: 4
    currsigs.addElement(enableBL);
    enableCV.setPresent();//sysj\systemController.sysj line: 27, column: 4
    currsigs.addElement(enableCV);
    enableTT.setPresent();//sysj\systemController.sysj line: 28, column: 4
    currsigs.addElement(enableTT);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3769(int [] tdone, int [] ends){
        S3682=1;
    mode.setPresent();//sysj\systemController.sysj line: 19, column: 4
    currsigs.addElement(mode);
    mode.setValue(0);//sysj\systemController.sysj line: 19, column: 4
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
      switch(S3767){
        case 0 : 
          S3767=0;
          break RUN;
        
        case 1 : 
          S3767=2;
          S3767=2;
          thread3769(tdone,ends);
          thread3770(tdone,ends);
          thread3771(tdone,ends);
          thread3772(tdone,ends);
          int biggest3773 = 0;
          if(ends[2]>=biggest3773){
            biggest3773=ends[2];
          }
          if(ends[3]>=biggest3773){
            biggest3773=ends[3];
          }
          if(ends[4]>=biggest3773){
            biggest3773=ends[4];
          }
          if(ends[5]>=biggest3773){
            biggest3773=ends[5];
          }
          if(biggest3773 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread3774(tdone,ends);
          thread3775(tdone,ends);
          thread3776(tdone,ends);
          thread3777(tdone,ends);
          int biggest3778 = 0;
          if(ends[2]>=biggest3778){
            biggest3778=ends[2];
          }
          if(ends[3]>=biggest3778){
            biggest3778=ends[3];
          }
          if(ends[4]>=biggest3778){
            biggest3778=ends[4];
          }
          if(ends[5]>=biggest3778){
            biggest3778=ends[5];
          }
          if(biggest3778 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3778 == 0){
            S3767=0;
            active[1]=0;
            ends[1]=0;
            S3767=0;
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
      enableTT.setpreclear();
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
      enableTT.sethook();
      enableTT.setClear();
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
