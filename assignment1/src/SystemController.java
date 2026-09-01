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
  public Signal lidLoaderLoaded = new Signal("lidLoaderLoaded", Signal.INPUT);
  public Signal reloaded = new Signal("reloaded", Signal.INPUT);
  public Signal mode = new Signal("mode", Signal.OUTPUT);
  public Signal lidLoaderLoad = new Signal("lidLoaderLoad", Signal.OUTPUT);
  public Signal enable = new Signal("enable", Signal.OUTPUT);
  private int cycles_thread_4;//sysj/systemController.sysj line: 34, column: 3
  private int i_thread_4;//sysj/systemController.sysj line: 35, column: 3
  private int S1744 = 1;
  private int S1673 = 1;
  private int S1678 = 1;
  private int S1742 = 1;
  private int S1679 = 1;
  private int S1688 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread1752(int [] tdone, int [] ends){
        switch(S1742){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S1679){
          case 0 : 
            S1679=0;
            S1679=1;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 1 : 
            S1679=1;
            S1679=2;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 2 : 
            S1679=2;
            S1679=3;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 3 : 
            S1679=3;
            S1679=4;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 4 : 
            S1679=4;
            cycles_thread_4 = 7;//sysj/systemController.sysj line: 34, column: 3
            i_thread_4 = 0;//sysj/systemController.sysj line: 35, column: 3
            S1679=5;
            if(i_thread_4 < cycles_thread_4){//sysj/systemController.sysj line: 37, column: 9
              System.out.println("[SC] Requesting lid load " + (i_thread_4 + 1) + " of " + cycles_thread_4 + "...");//sysj/systemController.sysj line: 38, column: 4
              S1688=0;
              lidLoaderLoad.setPresent();//sysj/systemController.sysj line: 41, column: 5
              currsigs.addElement(lidLoaderLoad);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj/systemController.sysj line: 37, column: 3
              System.out.println("[SC] All " + cycles_thread_4 + " cycles done.");//sysj/systemController.sysj line: 52, column: 3
              S1679=6;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 5 : 
            switch(S1688){
              case 0 : 
                if(lidLoaderLoaded.getprestatus()){//sysj/systemController.sysj line: 40, column: 10
                  i_thread_4 = i_thread_4 + 1;//sysj/systemController.sysj line: 44, column: 4
                  System.out.println("[SC] Load " + i_thread_4 + " complete.");//sysj/systemController.sysj line: 45, column: 4
                  S1688=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  lidLoaderLoad.setPresent();//sysj/systemController.sysj line: 41, column: 5
                  currsigs.addElement(lidLoaderLoad);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S1688=1;
                S1688=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 2 : 
                S1688=2;
                S1688=3;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 3 : 
                S1688=3;
                if(i_thread_4 < cycles_thread_4){//sysj/systemController.sysj line: 37, column: 9
                  System.out.println("[SC] Requesting lid load " + (i_thread_4 + 1) + " of " + cycles_thread_4 + "...");//sysj/systemController.sysj line: 38, column: 4
                  S1688=0;
                  lidLoaderLoad.setPresent();//sysj/systemController.sysj line: 41, column: 5
                  currsigs.addElement(lidLoaderLoad);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  ends[4]=2;
                  ;//sysj/systemController.sysj line: 37, column: 3
                  System.out.println("[SC] All " + cycles_thread_4 + " cycles done.");//sysj/systemController.sysj line: 52, column: 3
                  S1679=6;
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

  public void thread1751(int [] tdone, int [] ends){
        switch(S1678){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        enable.setPresent();//sysj/systemController.sysj line: 24, column: 4
        currsigs.addElement(enable);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread1750(int [] tdone, int [] ends){
        switch(S1673){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        mode.setPresent();//sysj/systemController.sysj line: 17, column: 4
        currsigs.addElement(mode);
        mode.setValue(0);//sysj/systemController.sysj line: 17, column: 4
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread1748(int [] tdone, int [] ends){
        S1742=1;
    S1679=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread1747(int [] tdone, int [] ends){
        S1678=1;
    enable.setPresent();//sysj/systemController.sysj line: 24, column: 4
    currsigs.addElement(enable);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1746(int [] tdone, int [] ends){
        S1673=1;
    mode.setPresent();//sysj/systemController.sysj line: 17, column: 4
    currsigs.addElement(mode);
    mode.setValue(0);//sysj/systemController.sysj line: 17, column: 4
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
      switch(S1744){
        case 0 : 
          S1744=0;
          break RUN;
        
        case 1 : 
          S1744=2;
          S1744=2;
          thread1746(tdone,ends);
          thread1747(tdone,ends);
          thread1748(tdone,ends);
          int biggest1749 = 0;
          if(ends[2]>=biggest1749){
            biggest1749=ends[2];
          }
          if(ends[3]>=biggest1749){
            biggest1749=ends[3];
          }
          if(ends[4]>=biggest1749){
            biggest1749=ends[4];
          }
          if(biggest1749 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread1750(tdone,ends);
          thread1751(tdone,ends);
          thread1752(tdone,ends);
          int biggest1753 = 0;
          if(ends[2]>=biggest1753){
            biggest1753=ends[2];
          }
          if(ends[3]>=biggest1753){
            biggest1753=ends[3];
          }
          if(ends[4]>=biggest1753){
            biggest1753=ends[4];
          }
          if(biggest1753 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1753 == 0){
            S1744=0;
            active[1]=0;
            ends[1]=0;
            S1744=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0};
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
          lidLoaderLoaded.gethook();
          reloaded.gethook();
          df = true;
        }
        runClockDomain();
      }
      lidLoaderLoaded.setpreclear();
      reloaded.setpreclear();
      mode.setpreclear();
      lidLoaderLoad.setpreclear();
      enable.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = lidLoaderLoaded.getStatus() ? lidLoaderLoaded.setprepresent() : lidLoaderLoaded.setpreclear();
      lidLoaderLoaded.setpreval(lidLoaderLoaded.getValue());
      lidLoaderLoaded.setClear();
      dummyint = reloaded.getStatus() ? reloaded.setprepresent() : reloaded.setpreclear();
      reloaded.setpreval(reloaded.getValue());
      reloaded.setClear();
      mode.sethook();
      mode.setClear();
      lidLoaderLoad.sethook();
      lidLoaderLoad.setClear();
      enable.sethook();
      enable.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        lidLoaderLoaded.gethook();
        reloaded.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
