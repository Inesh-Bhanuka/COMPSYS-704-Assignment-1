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
  public Signal mode = new Signal("mode", Signal.OUTPUT);
  public Signal bottleLoad = new Signal("bottleLoad", Signal.OUTPUT);
  public Signal enable = new Signal("enable", Signal.OUTPUT);
  public Signal enableCV = new Signal("enableCV", Signal.OUTPUT);
  private int cycles_thread_4;//sysj\systemController.sysj line: 36, column: 3
  private int i_thread_4;//sysj\systemController.sysj line: 37, column: 3
  private int S3142 = 1;
  private int S3071 = 1;
  private int S3076 = 1;
  private int S3140 = 1;
  private int S3077 = 1;
  private int S3086 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread3150(int [] tdone, int [] ends){
        switch(S3140){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S3077){
          case 0 : 
            S3077=0;
            S3077=1;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 1 : 
            S3077=1;
            S3077=2;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 2 : 
            S3077=2;
            S3077=3;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 3 : 
            S3077=3;
            S3077=4;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 4 : 
            S3077=4;
            cycles_thread_4 = 5;//sysj\systemController.sysj line: 36, column: 3
            i_thread_4 = 0;//sysj\systemController.sysj line: 37, column: 3
            S3077=5;
            if(i_thread_4 < cycles_thread_4){//sysj\systemController.sysj line: 39, column: 9
              System.out.println("[SC] Requesting bottle load " + (i_thread_4 + 1) + " of " + cycles_thread_4 + "...");//sysj\systemController.sysj line: 40, column: 4
              S3086=0;
              bottleLoad.setPresent();//sysj\systemController.sysj line: 43, column: 5
              currsigs.addElement(bottleLoad);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj\systemController.sysj line: 39, column: 3
              System.out.println("[SC] All " + cycles_thread_4 + " bottles loaded.");//sysj\systemController.sysj line: 55, column: 3
              S3077=6;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 5 : 
            switch(S3086){
              case 0 : 
                if(bottleLoaded.getprestatus()){//sysj\systemController.sysj line: 42, column: 10
                  i_thread_4 = i_thread_4 + 1;//sysj\systemController.sysj line: 46, column: 4
                  System.out.println("[SC] Bottle " + i_thread_4 + " loaded onto conveyor.");//sysj\systemController.sysj line: 47, column: 4
                  S3086=1;
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
                S3086=1;
                S3086=2;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 2 : 
                S3086=2;
                S3086=3;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
                break;
              
              case 3 : 
                S3086=3;
                if(i_thread_4 < cycles_thread_4){//sysj\systemController.sysj line: 39, column: 9
                  System.out.println("[SC] Requesting bottle load " + (i_thread_4 + 1) + " of " + cycles_thread_4 + "...");//sysj\systemController.sysj line: 40, column: 4
                  S3086=0;
                  bottleLoad.setPresent();//sysj\systemController.sysj line: 43, column: 5
                  currsigs.addElement(bottleLoad);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  ends[4]=2;
                  ;//sysj\systemController.sysj line: 39, column: 3
                  System.out.println("[SC] All " + cycles_thread_4 + " bottles loaded.");//sysj\systemController.sysj line: 55, column: 3
                  S3077=6;
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

  public void thread3149(int [] tdone, int [] ends){
        switch(S3076){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        enable.setPresent();//sysj\systemController.sysj line: 25, column: 4
        currsigs.addElement(enable);
        enableCV.setPresent();//sysj\systemController.sysj line: 26, column: 4
        currsigs.addElement(enableCV);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread3148(int [] tdone, int [] ends){
        switch(S3071){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        mode.setPresent();//sysj\systemController.sysj line: 17, column: 4
        currsigs.addElement(mode);
        mode.setValue(0);//sysj\systemController.sysj line: 17, column: 4
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread3146(int [] tdone, int [] ends){
        S3140=1;
    S3077=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread3145(int [] tdone, int [] ends){
        S3076=1;
    enable.setPresent();//sysj\systemController.sysj line: 25, column: 4
    currsigs.addElement(enable);
    enableCV.setPresent();//sysj\systemController.sysj line: 26, column: 4
    currsigs.addElement(enableCV);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3144(int [] tdone, int [] ends){
        S3071=1;
    mode.setPresent();//sysj\systemController.sysj line: 17, column: 4
    currsigs.addElement(mode);
    mode.setValue(0);//sysj\systemController.sysj line: 17, column: 4
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
      switch(S3142){
        case 0 : 
          S3142=0;
          break RUN;
        
        case 1 : 
          S3142=2;
          S3142=2;
          thread3144(tdone,ends);
          thread3145(tdone,ends);
          thread3146(tdone,ends);
          int biggest3147 = 0;
          if(ends[2]>=biggest3147){
            biggest3147=ends[2];
          }
          if(ends[3]>=biggest3147){
            biggest3147=ends[3];
          }
          if(ends[4]>=biggest3147){
            biggest3147=ends[4];
          }
          if(biggest3147 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread3148(tdone,ends);
          thread3149(tdone,ends);
          thread3150(tdone,ends);
          int biggest3151 = 0;
          if(ends[2]>=biggest3151){
            biggest3151=ends[2];
          }
          if(ends[3]>=biggest3151){
            biggest3151=ends[3];
          }
          if(ends[4]>=biggest3151){
            biggest3151=ends[4];
          }
          if(biggest3151 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3151 == 0){
            S3142=0;
            active[1]=0;
            ends[1]=0;
            S3142=0;
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
          bottleLoaded.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleLoaded.setpreclear();
      mode.setpreclear();
      bottleLoad.setpreclear();
      enable.setpreclear();
      enableCV.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleLoaded.getStatus() ? bottleLoaded.setprepresent() : bottleLoaded.setpreclear();
      bottleLoaded.setpreval(bottleLoaded.getValue());
      bottleLoaded.setClear();
      mode.sethook();
      mode.setClear();
      bottleLoad.sethook();
      bottleLoad.setClear();
      enable.sethook();
      enable.setClear();
      enableCV.sethook();
      enableCV.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleLoaded.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
