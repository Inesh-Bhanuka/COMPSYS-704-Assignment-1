import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class GUIInterface extends ClockDomain{
  public GUIInterface(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal Status = new Signal("Status", Signal.INPUT);
  public Signal Command = new Signal("Command", Signal.OUTPUT);
  private GuiCommand command_thread_1;//sysj\guiInterface.sysj line: 7, column: 5
  private int S47012 = 1;
  private int S46983 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S47012){
        case 0 : 
          S47012=0;
          break RUN;
        
        case 1 : 
          S47012=2;
          S47012=2;
          command_thread_1 = null;//sysj\guiInterface.sysj line: 7, column: 5
          GuiInterfaceBridge.open();//sysj\guiInterface.sysj line: 8, column: 5
          S46983=0;
          if(Status.getprestatus()){//sysj\guiInterface.sysj line: 10, column: 17
            GuiInterfaceBridge.publish((GuiSnapshot)(Status.getpreval() == null ? null : ((GuiSnapshot)Status.getpreval())));//sysj\guiInterface.sysj line: 10, column: 26
            command_thread_1 = GuiInterfaceBridge.command();//sysj\guiInterface.sysj line: 11, column: 9
            if(command_thread_1 != null){//sysj\guiInterface.sysj line: 12, column: 12
              Command.setPresent();//sysj\guiInterface.sysj line: 12, column: 30
              currsigs.addElement(Command);
              Command.setValue(command_thread_1);//sysj\guiInterface.sysj line: 12, column: 30
              S46983=1;
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
            else {
              S46983=1;
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
          else {
            command_thread_1 = GuiInterfaceBridge.command();//sysj\guiInterface.sysj line: 11, column: 9
            if(command_thread_1 != null){//sysj\guiInterface.sysj line: 12, column: 12
              Command.setPresent();//sysj\guiInterface.sysj line: 12, column: 30
              currsigs.addElement(Command);
              Command.setValue(command_thread_1);//sysj\guiInterface.sysj line: 12, column: 30
              S46983=1;
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
            else {
              S46983=1;
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
        
        case 2 : 
          switch(S46983){
            case 0 : 
              S46983=0;
              if(Status.getprestatus()){//sysj\guiInterface.sysj line: 10, column: 17
                GuiInterfaceBridge.publish((GuiSnapshot)(Status.getpreval() == null ? null : ((GuiSnapshot)Status.getpreval())));//sysj\guiInterface.sysj line: 10, column: 26
                command_thread_1 = GuiInterfaceBridge.command();//sysj\guiInterface.sysj line: 11, column: 9
                if(command_thread_1 != null){//sysj\guiInterface.sysj line: 12, column: 12
                  Command.setPresent();//sysj\guiInterface.sysj line: 12, column: 30
                  currsigs.addElement(Command);
                  Command.setValue(command_thread_1);//sysj\guiInterface.sysj line: 12, column: 30
                  S46983=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S46983=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                command_thread_1 = GuiInterfaceBridge.command();//sysj\guiInterface.sysj line: 11, column: 9
                if(command_thread_1 != null){//sysj\guiInterface.sysj line: 12, column: 12
                  Command.setPresent();//sysj\guiInterface.sysj line: 12, column: 30
                  currsigs.addElement(Command);
                  Command.setValue(command_thread_1);//sysj\guiInterface.sysj line: 12, column: 30
                  S46983=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S46983=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 1 : 
              S46983=1;
              S46983=0;
              if(Status.getprestatus()){//sysj\guiInterface.sysj line: 10, column: 17
                GuiInterfaceBridge.publish((GuiSnapshot)(Status.getpreval() == null ? null : ((GuiSnapshot)Status.getpreval())));//sysj\guiInterface.sysj line: 10, column: 26
                command_thread_1 = GuiInterfaceBridge.command();//sysj\guiInterface.sysj line: 11, column: 9
                if(command_thread_1 != null){//sysj\guiInterface.sysj line: 12, column: 12
                  Command.setPresent();//sysj\guiInterface.sysj line: 12, column: 30
                  currsigs.addElement(Command);
                  Command.setValue(command_thread_1);//sysj\guiInterface.sysj line: 12, column: 30
                  S46983=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S46983=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                command_thread_1 = GuiInterfaceBridge.command();//sysj\guiInterface.sysj line: 11, column: 9
                if(command_thread_1 != null){//sysj\guiInterface.sysj line: 12, column: 12
                  Command.setPresent();//sysj\guiInterface.sysj line: 12, column: 30
                  currsigs.addElement(Command);
                  Command.setValue(command_thread_1);//sysj\guiInterface.sysj line: 12, column: 30
                  S46983=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S46983=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
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
          Status.gethook();
          df = true;
        }
        runClockDomain();
      }
      Status.setpreclear();
      Command.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = Status.getStatus() ? Status.setprepresent() : Status.setpreclear();
      Status.setpreval(Status.getValue());
      Status.setClear();
      Command.sethook();
      Command.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        Status.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
