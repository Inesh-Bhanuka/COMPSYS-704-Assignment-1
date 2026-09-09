import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class LidRemovalController extends ClockDomain{
  public LidRemovalController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal zAxisLowered = new Signal("zAxisLowered", Signal.INPUT);
  public Signal zAxisLifted = new Signal("zAxisLifted", Signal.INPUT);
  public Signal turnAtHomePos = new Signal("turnAtHomePos", Signal.INPUT);
  public Signal turnAtFinalPos = new Signal("turnAtFinalPos", Signal.INPUT);
  public Signal lidGripped = new Signal("lidGripped", Signal.INPUT);
  public Signal lidBinFull = new Signal("lidBinFull", Signal.INPUT);
  public Signal cylZaxisExtendM = new Signal("cylZaxisExtendM", Signal.INPUT);
  public Signal unscrewTurnExtendM = new Signal("unscrewTurnExtendM", Signal.INPUT);
  public Signal lidGripperExtendM = new Signal("lidGripperExtendM", Signal.INPUT);
  public Signal lidEjectExtendM = new Signal("lidEjectExtendM", Signal.INPUT);
  public Signal cylZaxisExtend = new Signal("cylZaxisExtend", Signal.OUTPUT);
  public Signal unscrewTurnExtend = new Signal("unscrewTurnExtend", Signal.OUTPUT);
  public Signal unscrewTurnRetract = new Signal("unscrewTurnRetract", Signal.OUTPUT);
  public Signal lidGripperExtend = new Signal("lidGripperExtend", Signal.OUTPUT);
  public Signal lidEjectExtend = new Signal("lidEjectExtend", Signal.OUTPUT);
  public input_Channel enable_in = new input_Channel();
  public output_Channel status_o = new output_Channel();
  private Signal auto_1;
  private Signal manual_1;
  private int OK_thread_3;//sysj/lidRemovalController.sysj line: 65, column: 3
  private int BLOCKED_thread_3;//sysj/lidRemovalController.sysj line: 66, column: 3
  private Workpiece w_thread_3;//sysj/lidRemovalController.sysj line: 68, column: 3
  private int code_thread_3;//sysj/lidRemovalController.sysj line: 69, column: 3
  private int S101143 = 1;
  private int S86287 = 1;
  private int S100611 = 1;
  private int S88675 = 1;
  private int S86312 = 1;
  private int S86296 = 1;
  private int S86291 = 1;
  private int S86333 = 1;
  private int S86338 = 1;
  private int S86388 = 1;
  private int S86393 = 1;
  private int S86584 = 1;
  private int S86579 = 1;
  private int S101141 = 1;
  private int S100787 = 1;
  
  private int[] ends = new int[9];
  private int[] tdone = new int[9];
  
  public void thread101205(int [] tdone, int [] ends){
        switch(S101141){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S100787){
          case 0 : 
            if(manual_1.getprestatus()){//sysj/lidRemovalController.sysj line: 130, column: 20
              S100787=1;
              if(auto_1.getprestatus()){//sysj/lidRemovalController.sysj line: 131, column: 20
                S100787=2;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                if(cylZaxisExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 133, column: 14
                  cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 133, column: 32
                  currsigs.addElement(cylZaxisExtend);
                  if(unscrewTurnExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 134, column: 14
                    unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 134, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                    else {
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                  }
                  else {
                    if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                    else {
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                  }
                }
                else {
                  if(unscrewTurnExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 134, column: 14
                    unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 134, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                    else {
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                  }
                  else {
                    if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                    else {
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                  }
                }
              }
            }
            else {
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(auto_1.getprestatus()){//sysj/lidRemovalController.sysj line: 131, column: 20
              S100787=2;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              if(cylZaxisExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 133, column: 14
                cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 133, column: 32
                currsigs.addElement(cylZaxisExtend);
                if(unscrewTurnExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 134, column: 14
                  unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 134, column: 35
                  currsigs.addElement(unscrewTurnExtend);
                  if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
                    lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                      currsigs.addElement(lidEjectExtend);
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                    else {
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                  }
                  else {
                    if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                      currsigs.addElement(lidEjectExtend);
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                    else {
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                  }
                }
                else {
                  if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
                    lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                      currsigs.addElement(lidEjectExtend);
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                    else {
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                  }
                  else {
                    if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                      currsigs.addElement(lidEjectExtend);
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                    else {
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                  }
                }
              }
              else {
                if(unscrewTurnExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 134, column: 14
                  unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 134, column: 35
                  currsigs.addElement(unscrewTurnExtend);
                  if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
                    lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                      currsigs.addElement(lidEjectExtend);
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                    else {
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                  }
                  else {
                    if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                      currsigs.addElement(lidEjectExtend);
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                    else {
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                  }
                }
                else {
                  if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
                    lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                      currsigs.addElement(lidEjectExtend);
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                    else {
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                  }
                  else {
                    if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                      currsigs.addElement(lidEjectExtend);
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                    else {
                      active[8]=1;
                      ends[8]=1;
                      tdone[8]=1;
                    }
                  }
                }
              }
            }
            break;
          
          case 2 : 
            S100787=2;
            S100787=0;
            if(manual_1.getprestatus()){//sysj/lidRemovalController.sysj line: 130, column: 20
              S100787=1;
              if(auto_1.getprestatus()){//sysj/lidRemovalController.sysj line: 131, column: 20
                S100787=2;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                if(cylZaxisExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 133, column: 14
                  cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 133, column: 32
                  currsigs.addElement(cylZaxisExtend);
                  if(unscrewTurnExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 134, column: 14
                    unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 134, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                    else {
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                  }
                  else {
                    if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                    else {
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                  }
                }
                else {
                  if(unscrewTurnExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 134, column: 14
                    unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 134, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                    else {
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                  }
                  else {
                    if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                    else {
                      if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                        currsigs.addElement(lidEjectExtend);
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                      else {
                        active[8]=1;
                        ends[8]=1;
                        tdone[8]=1;
                      }
                    }
                  }
                }
              }
            }
            else {
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread101203(int [] tdone, int [] ends){
        S86338=1;
    lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread101202(int [] tdone, int [] ends){
        S86333=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread101200(int [] tdone, int [] ends){
        S86393=1;
    unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101199(int [] tdone, int [] ends){
        S86388=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101197(int [] tdone, int [] ends){
        switch(S86393){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 39
        currsigs.addElement(unscrewTurnExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread101196(int [] tdone, int [] ends){
        switch(S86388){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 8
        currsigs.addElement(cylZaxisExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread101194(int [] tdone, int [] ends){
        S86393=1;
    unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101193(int [] tdone, int [] ends){
        S86388=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101191(int [] tdone, int [] ends){
        switch(S86338){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 39
        currsigs.addElement(lidGripperExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread101190(int [] tdone, int [] ends){
        switch(S86333){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 8
        currsigs.addElement(cylZaxisExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread101188(int [] tdone, int [] ends){
        S86393=1;
    unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101187(int [] tdone, int [] ends){
        S86388=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101185(int [] tdone, int [] ends){
        S86338=1;
    lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread101184(int [] tdone, int [] ends){
        S86333=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread101182(int [] tdone, int [] ends){
        S86393=1;
    unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101181(int [] tdone, int [] ends){
        S86388=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101179(int [] tdone, int [] ends){
        S86338=1;
    lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread101178(int [] tdone, int [] ends){
        S86333=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread101176(int [] tdone, int [] ends){
        S86393=1;
    unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101175(int [] tdone, int [] ends){
        S86388=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101173(int [] tdone, int [] ends){
        S86338=1;
    lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread101172(int [] tdone, int [] ends){
        S86333=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread101170(int [] tdone, int [] ends){
        S86393=1;
    unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101169(int [] tdone, int [] ends){
        S86388=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101167(int [] tdone, int [] ends){
        S86338=1;
    lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread101166(int [] tdone, int [] ends){
        S86333=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread101164(int [] tdone, int [] ends){
        S86393=1;
    unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101163(int [] tdone, int [] ends){
        S86388=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101161(int [] tdone, int [] ends){
        S86338=1;
    lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread101160(int [] tdone, int [] ends){
        S86333=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread101158(int [] tdone, int [] ends){
        S86393=1;
    unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101157(int [] tdone, int [] ends){
        S86388=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101156(int [] tdone, int [] ends){
        switch(S100611){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S88675){
          case 0 : 
            if(auto_1.getprestatus()){//sysj/lidRemovalController.sysj line: 72, column: 20
              S88675=1;
              if(manual_1.getprestatus()){//sysj/lidRemovalController.sysj line: 74, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S88675=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S86312=0;
                S86296=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 75, column: 5
                  enable_in.setACK(false);//sysj/lidRemovalController.sysj line: 75, column: 5
                  S86296=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S86291=0;
                  if(!enable_in.isREQ()){//sysj/lidRemovalController.sysj line: 75, column: 5
                    enable_in.setACK(true);//sysj/lidRemovalController.sysj line: 75, column: 5
                    S86291=1;
                    if(enable_in.isREQ()){//sysj/lidRemovalController.sysj line: 75, column: 5
                      enable_in.setACK(false);//sysj/lidRemovalController.sysj line: 75, column: 5
                      ends[3]=2;
                      ;//sysj/lidRemovalController.sysj line: 75, column: 5
                      w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/lidRemovalController.sysj line: 76, column: 5
                      System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj/lidRemovalController.sysj line: 77, column: 5
                      S86312=1;
                      if(zAxisLowered.getprestatus()){//sysj/lidRemovalController.sysj line: 80, column: 21
                        S86312=2;
                        if(lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 85, column: 21
                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj/lidRemovalController.sysj line: 88, column: 5
                          S86312=3;
                          if(turnAtFinalPos.getprestatus()){//sysj/lidRemovalController.sysj line: 91, column: 21
                            S86312=4;
                            if(zAxisLifted.getprestatus()){//sysj/lidRemovalController.sysj line: 98, column: 21
                              S86312=5;
                              if(turnAtHomePos.getprestatus()){//sysj/lidRemovalController.sysj line: 101, column: 21
                                S86312=6;
                                if(!lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 106, column: 21
                                  w_thread_3.removeLid();//sysj/lidRemovalController.sysj line: 112, column: 5
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj/lidRemovalController.sysj line: 113, column: 5
                                  code_thread_3 = OK_thread_3;//sysj/lidRemovalController.sysj line: 116, column: 5
                                  if(lidBinFull.getprestatus()){//sysj/lidRemovalController.sysj line: 117, column: 13
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj/lidRemovalController.sysj line: 118, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj/lidRemovalController.sysj line: 119, column: 6
                                    S86312=7;
                                    S86584=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                      S86584=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S86579=0;
                                      if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                        S86579=1;
                                        if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                          status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                          S88675=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    S86312=7;
                                    S86584=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                      S86584=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S86579=0;
                                      if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                        S86579=1;
                                        if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                          status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                          S88675=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 107, column: 6
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                unscrewTurnRetract.setPresent();//sysj/lidRemovalController.sysj line: 102, column: 6
                                currsigs.addElement(unscrewTurnRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            thread101157(tdone,ends);
                            thread101158(tdone,ends);
                            int biggest101159 = 0;
                            if(ends[6]>=biggest101159){
                              biggest101159=ends[6];
                            }
                            if(ends[7]>=biggest101159){
                              biggest101159=ends[7];
                            }
                            if(biggest101159 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread101160(tdone,ends);
                          thread101161(tdone,ends);
                          int biggest101162 = 0;
                          if(ends[4]>=biggest101162){
                            biggest101162=ends[4];
                          }
                          if(ends[5]>=biggest101162){
                            biggest101162=ends[5];
                          }
                          if(biggest101162 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 81, column: 6
                        currsigs.addElement(cylZaxisExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
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
          
          case 1 : 
            if(manual_1.getprestatus()){//sysj/lidRemovalController.sysj line: 74, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S88675=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S86312){
                case 0 : 
                  switch(S86296){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 75, column: 5
                        enable_in.setACK(false);//sysj/lidRemovalController.sysj line: 75, column: 5
                        S86296=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S86291){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj/lidRemovalController.sysj line: 75, column: 5
                              enable_in.setACK(true);//sysj/lidRemovalController.sysj line: 75, column: 5
                              S86291=1;
                              if(enable_in.isREQ()){//sysj/lidRemovalController.sysj line: 75, column: 5
                                enable_in.setACK(false);//sysj/lidRemovalController.sysj line: 75, column: 5
                                ends[3]=2;
                                ;//sysj/lidRemovalController.sysj line: 75, column: 5
                                w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/lidRemovalController.sysj line: 76, column: 5
                                System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj/lidRemovalController.sysj line: 77, column: 5
                                S86312=1;
                                if(zAxisLowered.getprestatus()){//sysj/lidRemovalController.sysj line: 80, column: 21
                                  S86312=2;
                                  if(lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 85, column: 21
                                    System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj/lidRemovalController.sysj line: 88, column: 5
                                    S86312=3;
                                    if(turnAtFinalPos.getprestatus()){//sysj/lidRemovalController.sysj line: 91, column: 21
                                      S86312=4;
                                      if(zAxisLifted.getprestatus()){//sysj/lidRemovalController.sysj line: 98, column: 21
                                        S86312=5;
                                        if(turnAtHomePos.getprestatus()){//sysj/lidRemovalController.sysj line: 101, column: 21
                                          S86312=6;
                                          if(!lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 106, column: 21
                                            w_thread_3.removeLid();//sysj/lidRemovalController.sysj line: 112, column: 5
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj/lidRemovalController.sysj line: 113, column: 5
                                            code_thread_3 = OK_thread_3;//sysj/lidRemovalController.sysj line: 116, column: 5
                                            if(lidBinFull.getprestatus()){//sysj/lidRemovalController.sysj line: 117, column: 13
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj/lidRemovalController.sysj line: 118, column: 6
                                              code_thread_3 = BLOCKED_thread_3;//sysj/lidRemovalController.sysj line: 119, column: 6
                                              S86312=7;
                                              S86584=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                                status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                                S86584=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S86579=0;
                                                if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                                  S86579=1;
                                                  if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                                    status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                                    ends[3]=2;
                                                    ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                                    S88675=2;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                            else {
                                              S86312=7;
                                              S86584=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                                status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                                S86584=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S86579=0;
                                                if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                                  S86579=1;
                                                  if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                                    status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                                    ends[3]=2;
                                                    ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                                    S88675=2;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                            }
                                          }
                                          else {
                                            lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 107, column: 6
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          unscrewTurnRetract.setPresent();//sysj/lidRemovalController.sysj line: 102, column: 6
                                          currsigs.addElement(unscrewTurnRetract);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      thread101163(tdone,ends);
                                      thread101164(tdone,ends);
                                      int biggest101165 = 0;
                                      if(ends[6]>=biggest101165){
                                        biggest101165=ends[6];
                                      }
                                      if(ends[7]>=biggest101165){
                                        biggest101165=ends[7];
                                      }
                                      if(biggest101165 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread101166(tdone,ends);
                                    thread101167(tdone,ends);
                                    int biggest101168 = 0;
                                    if(ends[4]>=biggest101168){
                                      biggest101168=ends[4];
                                    }
                                    if(ends[5]>=biggest101168){
                                      biggest101168=ends[5];
                                    }
                                    if(biggest101168 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 81, column: 6
                                  currsigs.addElement(cylZaxisExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            break;
                          
                          case 1 : 
                            if(enable_in.isREQ()){//sysj/lidRemovalController.sysj line: 75, column: 5
                              enable_in.setACK(false);//sysj/lidRemovalController.sysj line: 75, column: 5
                              ends[3]=2;
                              ;//sysj/lidRemovalController.sysj line: 75, column: 5
                              w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/lidRemovalController.sysj line: 76, column: 5
                              System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj/lidRemovalController.sysj line: 77, column: 5
                              S86312=1;
                              if(zAxisLowered.getprestatus()){//sysj/lidRemovalController.sysj line: 80, column: 21
                                S86312=2;
                                if(lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 85, column: 21
                                  System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj/lidRemovalController.sysj line: 88, column: 5
                                  S86312=3;
                                  if(turnAtFinalPos.getprestatus()){//sysj/lidRemovalController.sysj line: 91, column: 21
                                    S86312=4;
                                    if(zAxisLifted.getprestatus()){//sysj/lidRemovalController.sysj line: 98, column: 21
                                      S86312=5;
                                      if(turnAtHomePos.getprestatus()){//sysj/lidRemovalController.sysj line: 101, column: 21
                                        S86312=6;
                                        if(!lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 106, column: 21
                                          w_thread_3.removeLid();//sysj/lidRemovalController.sysj line: 112, column: 5
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj/lidRemovalController.sysj line: 113, column: 5
                                          code_thread_3 = OK_thread_3;//sysj/lidRemovalController.sysj line: 116, column: 5
                                          if(lidBinFull.getprestatus()){//sysj/lidRemovalController.sysj line: 117, column: 13
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj/lidRemovalController.sysj line: 118, column: 6
                                            code_thread_3 = BLOCKED_thread_3;//sysj/lidRemovalController.sysj line: 119, column: 6
                                            S86312=7;
                                            S86584=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                              status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                              S86584=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S86579=0;
                                              if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                                S86579=1;
                                                if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                                  status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                                  ends[3]=2;
                                                  ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                                  S88675=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                          else {
                                            S86312=7;
                                            S86584=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                              status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                              S86584=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S86579=0;
                                              if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                                S86579=1;
                                                if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                                  status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                                  ends[3]=2;
                                                  ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                                  S88675=2;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                          }
                                        }
                                        else {
                                          lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 107, column: 6
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        unscrewTurnRetract.setPresent();//sysj/lidRemovalController.sysj line: 102, column: 6
                                        currsigs.addElement(unscrewTurnRetract);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    thread101169(tdone,ends);
                                    thread101170(tdone,ends);
                                    int biggest101171 = 0;
                                    if(ends[6]>=biggest101171){
                                      biggest101171=ends[6];
                                    }
                                    if(ends[7]>=biggest101171){
                                      biggest101171=ends[7];
                                    }
                                    if(biggest101171 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread101172(tdone,ends);
                                  thread101173(tdone,ends);
                                  int biggest101174 = 0;
                                  if(ends[4]>=biggest101174){
                                    biggest101174=ends[4];
                                  }
                                  if(ends[5]>=biggest101174){
                                    biggest101174=ends[5];
                                  }
                                  if(biggest101174 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 81, column: 6
                                currsigs.addElement(cylZaxisExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                      break;
                    
                    case 1 : 
                      S86296=1;
                      S86296=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 75, column: 5
                        enable_in.setACK(false);//sysj/lidRemovalController.sysj line: 75, column: 5
                        S86296=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S86291=0;
                        if(!enable_in.isREQ()){//sysj/lidRemovalController.sysj line: 75, column: 5
                          enable_in.setACK(true);//sysj/lidRemovalController.sysj line: 75, column: 5
                          S86291=1;
                          if(enable_in.isREQ()){//sysj/lidRemovalController.sysj line: 75, column: 5
                            enable_in.setACK(false);//sysj/lidRemovalController.sysj line: 75, column: 5
                            ends[3]=2;
                            ;//sysj/lidRemovalController.sysj line: 75, column: 5
                            w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/lidRemovalController.sysj line: 76, column: 5
                            System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj/lidRemovalController.sysj line: 77, column: 5
                            S86312=1;
                            if(zAxisLowered.getprestatus()){//sysj/lidRemovalController.sysj line: 80, column: 21
                              S86312=2;
                              if(lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 85, column: 21
                                System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj/lidRemovalController.sysj line: 88, column: 5
                                S86312=3;
                                if(turnAtFinalPos.getprestatus()){//sysj/lidRemovalController.sysj line: 91, column: 21
                                  S86312=4;
                                  if(zAxisLifted.getprestatus()){//sysj/lidRemovalController.sysj line: 98, column: 21
                                    S86312=5;
                                    if(turnAtHomePos.getprestatus()){//sysj/lidRemovalController.sysj line: 101, column: 21
                                      S86312=6;
                                      if(!lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 106, column: 21
                                        w_thread_3.removeLid();//sysj/lidRemovalController.sysj line: 112, column: 5
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj/lidRemovalController.sysj line: 113, column: 5
                                        code_thread_3 = OK_thread_3;//sysj/lidRemovalController.sysj line: 116, column: 5
                                        if(lidBinFull.getprestatus()){//sysj/lidRemovalController.sysj line: 117, column: 13
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj/lidRemovalController.sysj line: 118, column: 6
                                          code_thread_3 = BLOCKED_thread_3;//sysj/lidRemovalController.sysj line: 119, column: 6
                                          S86312=7;
                                          S86584=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                            status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                            S86584=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S86579=0;
                                            if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                              S86579=1;
                                              if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                                status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                                ends[3]=2;
                                                ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                                S88675=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                        else {
                                          S86312=7;
                                          S86584=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                            status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                            S86584=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S86579=0;
                                            if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                              S86579=1;
                                              if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                                status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                                ends[3]=2;
                                                ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                                S88675=2;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                        }
                                      }
                                      else {
                                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 107, column: 6
                                        currsigs.addElement(lidEjectExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      unscrewTurnRetract.setPresent();//sysj/lidRemovalController.sysj line: 102, column: 6
                                      currsigs.addElement(unscrewTurnRetract);
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  thread101175(tdone,ends);
                                  thread101176(tdone,ends);
                                  int biggest101177 = 0;
                                  if(ends[6]>=biggest101177){
                                    biggest101177=ends[6];
                                  }
                                  if(ends[7]>=biggest101177){
                                    biggest101177=ends[7];
                                  }
                                  if(biggest101177 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                thread101178(tdone,ends);
                                thread101179(tdone,ends);
                                int biggest101180 = 0;
                                if(ends[4]>=biggest101180){
                                  biggest101180=ends[4];
                                }
                                if(ends[5]>=biggest101180){
                                  biggest101180=ends[5];
                                }
                                if(biggest101180 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 81, column: 6
                              currsigs.addElement(cylZaxisExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      break;
                    
                  }
                  break;
                
                case 1 : 
                  if(zAxisLowered.getprestatus()){//sysj/lidRemovalController.sysj line: 80, column: 21
                    S86312=2;
                    if(lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 85, column: 21
                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj/lidRemovalController.sysj line: 88, column: 5
                      S86312=3;
                      if(turnAtFinalPos.getprestatus()){//sysj/lidRemovalController.sysj line: 91, column: 21
                        S86312=4;
                        if(zAxisLifted.getprestatus()){//sysj/lidRemovalController.sysj line: 98, column: 21
                          S86312=5;
                          if(turnAtHomePos.getprestatus()){//sysj/lidRemovalController.sysj line: 101, column: 21
                            S86312=6;
                            if(!lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 106, column: 21
                              w_thread_3.removeLid();//sysj/lidRemovalController.sysj line: 112, column: 5
                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj/lidRemovalController.sysj line: 113, column: 5
                              code_thread_3 = OK_thread_3;//sysj/lidRemovalController.sysj line: 116, column: 5
                              if(lidBinFull.getprestatus()){//sysj/lidRemovalController.sysj line: 117, column: 13
                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj/lidRemovalController.sysj line: 118, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj/lidRemovalController.sysj line: 119, column: 6
                                S86312=7;
                                S86584=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                  S86584=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S86579=0;
                                  if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                    S86579=1;
                                    if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                      ends[3]=2;
                                      ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                      S88675=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                S86312=7;
                                S86584=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                  S86584=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S86579=0;
                                  if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                    S86579=1;
                                    if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                      ends[3]=2;
                                      ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                      S88675=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 107, column: 6
                              currsigs.addElement(lidEjectExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            unscrewTurnRetract.setPresent();//sysj/lidRemovalController.sysj line: 102, column: 6
                            currsigs.addElement(unscrewTurnRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        thread101181(tdone,ends);
                        thread101182(tdone,ends);
                        int biggest101183 = 0;
                        if(ends[6]>=biggest101183){
                          biggest101183=ends[6];
                        }
                        if(ends[7]>=biggest101183){
                          biggest101183=ends[7];
                        }
                        if(biggest101183 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      thread101184(tdone,ends);
                      thread101185(tdone,ends);
                      int biggest101186 = 0;
                      if(ends[4]>=biggest101186){
                        biggest101186=ends[4];
                      }
                      if(ends[5]>=biggest101186){
                        biggest101186=ends[5];
                      }
                      if(biggest101186 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 81, column: 6
                    currsigs.addElement(cylZaxisExtend);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 2 : 
                  if(lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 85, column: 21
                    System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj/lidRemovalController.sysj line: 88, column: 5
                    S86312=3;
                    if(turnAtFinalPos.getprestatus()){//sysj/lidRemovalController.sysj line: 91, column: 21
                      S86312=4;
                      if(zAxisLifted.getprestatus()){//sysj/lidRemovalController.sysj line: 98, column: 21
                        S86312=5;
                        if(turnAtHomePos.getprestatus()){//sysj/lidRemovalController.sysj line: 101, column: 21
                          S86312=6;
                          if(!lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 106, column: 21
                            w_thread_3.removeLid();//sysj/lidRemovalController.sysj line: 112, column: 5
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj/lidRemovalController.sysj line: 113, column: 5
                            code_thread_3 = OK_thread_3;//sysj/lidRemovalController.sysj line: 116, column: 5
                            if(lidBinFull.getprestatus()){//sysj/lidRemovalController.sysj line: 117, column: 13
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj/lidRemovalController.sysj line: 118, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj/lidRemovalController.sysj line: 119, column: 6
                              S86312=7;
                              S86584=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                S86584=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S86579=0;
                                if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                  S86579=1;
                                  if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                    status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                    ends[3]=2;
                                    ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                    S88675=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              S86312=7;
                              S86584=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                S86584=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S86579=0;
                                if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                  S86579=1;
                                  if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                    status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                    ends[3]=2;
                                    ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                    S88675=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 107, column: 6
                            currsigs.addElement(lidEjectExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          unscrewTurnRetract.setPresent();//sysj/lidRemovalController.sysj line: 102, column: 6
                          currsigs.addElement(unscrewTurnRetract);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      thread101187(tdone,ends);
                      thread101188(tdone,ends);
                      int biggest101189 = 0;
                      if(ends[6]>=biggest101189){
                        biggest101189=ends[6];
                      }
                      if(ends[7]>=biggest101189){
                        biggest101189=ends[7];
                      }
                      if(biggest101189 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread101190(tdone,ends);
                    thread101191(tdone,ends);
                    int biggest101192 = 0;
                    if(ends[4]>=biggest101192){
                      biggest101192=ends[4];
                    }
                    if(ends[5]>=biggest101192){
                      biggest101192=ends[5];
                    }
                    if(biggest101192 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest101192 == 0){
                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj/lidRemovalController.sysj line: 88, column: 5
                      S86312=3;
                      if(turnAtFinalPos.getprestatus()){//sysj/lidRemovalController.sysj line: 91, column: 21
                        S86312=4;
                        if(zAxisLifted.getprestatus()){//sysj/lidRemovalController.sysj line: 98, column: 21
                          S86312=5;
                          if(turnAtHomePos.getprestatus()){//sysj/lidRemovalController.sysj line: 101, column: 21
                            S86312=6;
                            if(!lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 106, column: 21
                              w_thread_3.removeLid();//sysj/lidRemovalController.sysj line: 112, column: 5
                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj/lidRemovalController.sysj line: 113, column: 5
                              code_thread_3 = OK_thread_3;//sysj/lidRemovalController.sysj line: 116, column: 5
                              if(lidBinFull.getprestatus()){//sysj/lidRemovalController.sysj line: 117, column: 13
                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj/lidRemovalController.sysj line: 118, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj/lidRemovalController.sysj line: 119, column: 6
                                S86312=7;
                                S86584=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                  S86584=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S86579=0;
                                  if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                    S86579=1;
                                    if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                      ends[3]=2;
                                      ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                      S88675=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                S86312=7;
                                S86584=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                  S86584=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S86579=0;
                                  if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                    S86579=1;
                                    if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                      ends[3]=2;
                                      ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                      S88675=2;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                            }
                            else {
                              lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 107, column: 6
                              currsigs.addElement(lidEjectExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            unscrewTurnRetract.setPresent();//sysj/lidRemovalController.sysj line: 102, column: 6
                            currsigs.addElement(unscrewTurnRetract);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        thread101193(tdone,ends);
                        thread101194(tdone,ends);
                        int biggest101195 = 0;
                        if(ends[6]>=biggest101195){
                          biggest101195=ends[6];
                        }
                        if(ends[7]>=biggest101195){
                          biggest101195=ends[7];
                        }
                        if(biggest101195 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  break;
                
                case 3 : 
                  if(turnAtFinalPos.getprestatus()){//sysj/lidRemovalController.sysj line: 91, column: 21
                    S86312=4;
                    if(zAxisLifted.getprestatus()){//sysj/lidRemovalController.sysj line: 98, column: 21
                      S86312=5;
                      if(turnAtHomePos.getprestatus()){//sysj/lidRemovalController.sysj line: 101, column: 21
                        S86312=6;
                        if(!lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 106, column: 21
                          w_thread_3.removeLid();//sysj/lidRemovalController.sysj line: 112, column: 5
                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj/lidRemovalController.sysj line: 113, column: 5
                          code_thread_3 = OK_thread_3;//sysj/lidRemovalController.sysj line: 116, column: 5
                          if(lidBinFull.getprestatus()){//sysj/lidRemovalController.sysj line: 117, column: 13
                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj/lidRemovalController.sysj line: 118, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj/lidRemovalController.sysj line: 119, column: 6
                            S86312=7;
                            S86584=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                              S86584=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S86579=0;
                              if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                S86579=1;
                                if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                  ends[3]=2;
                                  ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                  S88675=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            S86312=7;
                            S86584=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                              S86584=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S86579=0;
                              if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                S86579=1;
                                if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                  ends[3]=2;
                                  ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                  S88675=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 107, column: 6
                          currsigs.addElement(lidEjectExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        unscrewTurnRetract.setPresent();//sysj/lidRemovalController.sysj line: 102, column: 6
                        currsigs.addElement(unscrewTurnRetract);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    thread101196(tdone,ends);
                    thread101197(tdone,ends);
                    int biggest101198 = 0;
                    if(ends[6]>=biggest101198){
                      biggest101198=ends[6];
                    }
                    if(ends[7]>=biggest101198){
                      biggest101198=ends[7];
                    }
                    if(biggest101198 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest101198 == 0){
                      S86312=4;
                      if(zAxisLifted.getprestatus()){//sysj/lidRemovalController.sysj line: 98, column: 21
                        S86312=5;
                        if(turnAtHomePos.getprestatus()){//sysj/lidRemovalController.sysj line: 101, column: 21
                          S86312=6;
                          if(!lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 106, column: 21
                            w_thread_3.removeLid();//sysj/lidRemovalController.sysj line: 112, column: 5
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj/lidRemovalController.sysj line: 113, column: 5
                            code_thread_3 = OK_thread_3;//sysj/lidRemovalController.sysj line: 116, column: 5
                            if(lidBinFull.getprestatus()){//sysj/lidRemovalController.sysj line: 117, column: 13
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj/lidRemovalController.sysj line: 118, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj/lidRemovalController.sysj line: 119, column: 6
                              S86312=7;
                              S86584=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                S86584=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S86579=0;
                                if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                  S86579=1;
                                  if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                    status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                    ends[3]=2;
                                    ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                    S88675=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              S86312=7;
                              S86584=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                S86584=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S86579=0;
                                if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                  S86579=1;
                                  if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                    status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                    ends[3]=2;
                                    ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                    S88675=2;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                          }
                          else {
                            lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 107, column: 6
                            currsigs.addElement(lidEjectExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          unscrewTurnRetract.setPresent();//sysj/lidRemovalController.sysj line: 102, column: 6
                          currsigs.addElement(unscrewTurnRetract);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  break;
                
                case 4 : 
                  if(zAxisLifted.getprestatus()){//sysj/lidRemovalController.sysj line: 98, column: 21
                    S86312=5;
                    if(turnAtHomePos.getprestatus()){//sysj/lidRemovalController.sysj line: 101, column: 21
                      S86312=6;
                      if(!lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 106, column: 21
                        w_thread_3.removeLid();//sysj/lidRemovalController.sysj line: 112, column: 5
                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj/lidRemovalController.sysj line: 113, column: 5
                        code_thread_3 = OK_thread_3;//sysj/lidRemovalController.sysj line: 116, column: 5
                        if(lidBinFull.getprestatus()){//sysj/lidRemovalController.sysj line: 117, column: 13
                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj/lidRemovalController.sysj line: 118, column: 6
                          code_thread_3 = BLOCKED_thread_3;//sysj/lidRemovalController.sysj line: 119, column: 6
                          S86312=7;
                          S86584=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                            status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                            S86584=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S86579=0;
                            if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                              S86579=1;
                              if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                ends[3]=2;
                                ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                S88675=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          S86312=7;
                          S86584=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                            status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                            S86584=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S86579=0;
                            if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                              S86579=1;
                              if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                ends[3]=2;
                                ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                S88675=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      else {
                        lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 107, column: 6
                        currsigs.addElement(lidEjectExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      unscrewTurnRetract.setPresent();//sysj/lidRemovalController.sysj line: 102, column: 6
                      currsigs.addElement(unscrewTurnRetract);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 5 : 
                  if(turnAtHomePos.getprestatus()){//sysj/lidRemovalController.sysj line: 101, column: 21
                    S86312=6;
                    if(!lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 106, column: 21
                      w_thread_3.removeLid();//sysj/lidRemovalController.sysj line: 112, column: 5
                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj/lidRemovalController.sysj line: 113, column: 5
                      code_thread_3 = OK_thread_3;//sysj/lidRemovalController.sysj line: 116, column: 5
                      if(lidBinFull.getprestatus()){//sysj/lidRemovalController.sysj line: 117, column: 13
                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj/lidRemovalController.sysj line: 118, column: 6
                        code_thread_3 = BLOCKED_thread_3;//sysj/lidRemovalController.sysj line: 119, column: 6
                        S86312=7;
                        S86584=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                          status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                          S86584=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S86579=0;
                          if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                            S86579=1;
                            if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                              ends[3]=2;
                              ;//sysj/lidRemovalController.sysj line: 122, column: 5
                              S88675=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        S86312=7;
                        S86584=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                          status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                          S86584=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S86579=0;
                          if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                            S86579=1;
                            if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                              ends[3]=2;
                              ;//sysj/lidRemovalController.sysj line: 122, column: 5
                              S88675=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                    }
                    else {
                      lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 107, column: 6
                      currsigs.addElement(lidEjectExtend);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    unscrewTurnRetract.setPresent();//sysj/lidRemovalController.sysj line: 102, column: 6
                    currsigs.addElement(unscrewTurnRetract);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 6 : 
                  if(!lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 106, column: 21
                    w_thread_3.removeLid();//sysj/lidRemovalController.sysj line: 112, column: 5
                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj/lidRemovalController.sysj line: 113, column: 5
                    code_thread_3 = OK_thread_3;//sysj/lidRemovalController.sysj line: 116, column: 5
                    if(lidBinFull.getprestatus()){//sysj/lidRemovalController.sysj line: 117, column: 13
                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj/lidRemovalController.sysj line: 118, column: 6
                      code_thread_3 = BLOCKED_thread_3;//sysj/lidRemovalController.sysj line: 119, column: 6
                      S86312=7;
                      S86584=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                        status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                        S86584=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S86579=0;
                        if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                          S86579=1;
                          if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                            status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                            ends[3]=2;
                            ;//sysj/lidRemovalController.sysj line: 122, column: 5
                            S88675=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      S86312=7;
                      S86584=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                        status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                        S86584=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S86579=0;
                        if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                          S86579=1;
                          if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                            status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                            ends[3]=2;
                            ;//sysj/lidRemovalController.sysj line: 122, column: 5
                            S88675=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  else {
                    lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 107, column: 6
                    currsigs.addElement(lidEjectExtend);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 7 : 
                  switch(S86584){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                        status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                        S86584=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S86579){
                          case 0 : 
                            if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                              S86579=1;
                              if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                ends[3]=2;
                                ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                S88675=2;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            break;
                          
                          case 1 : 
                            if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                              ends[3]=2;
                              ;//sysj/lidRemovalController.sysj line: 122, column: 5
                              S88675=2;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            break;
                          
                        }
                      }
                      break;
                    
                    case 1 : 
                      S86584=1;
                      S86584=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                        status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                        S86584=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S86579=0;
                        if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                          S86579=1;
                          if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                            status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                            ends[3]=2;
                            ;//sysj/lidRemovalController.sysj line: 122, column: 5
                            S88675=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      break;
                    
                  }
                  break;
                
                case 8 : 
                  S88675=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S88675=2;
            S88675=0;
            if(auto_1.getprestatus()){//sysj/lidRemovalController.sysj line: 72, column: 20
              S88675=1;
              if(manual_1.getprestatus()){//sysj/lidRemovalController.sysj line: 74, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S88675=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S86312=0;
                S86296=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 75, column: 5
                  enable_in.setACK(false);//sysj/lidRemovalController.sysj line: 75, column: 5
                  S86296=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S86291=0;
                  if(!enable_in.isREQ()){//sysj/lidRemovalController.sysj line: 75, column: 5
                    enable_in.setACK(true);//sysj/lidRemovalController.sysj line: 75, column: 5
                    S86291=1;
                    if(enable_in.isREQ()){//sysj/lidRemovalController.sysj line: 75, column: 5
                      enable_in.setACK(false);//sysj/lidRemovalController.sysj line: 75, column: 5
                      ends[3]=2;
                      ;//sysj/lidRemovalController.sysj line: 75, column: 5
                      w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/lidRemovalController.sysj line: 76, column: 5
                      System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj/lidRemovalController.sysj line: 77, column: 5
                      S86312=1;
                      if(zAxisLowered.getprestatus()){//sysj/lidRemovalController.sysj line: 80, column: 21
                        S86312=2;
                        if(lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 85, column: 21
                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj/lidRemovalController.sysj line: 88, column: 5
                          S86312=3;
                          if(turnAtFinalPos.getprestatus()){//sysj/lidRemovalController.sysj line: 91, column: 21
                            S86312=4;
                            if(zAxisLifted.getprestatus()){//sysj/lidRemovalController.sysj line: 98, column: 21
                              S86312=5;
                              if(turnAtHomePos.getprestatus()){//sysj/lidRemovalController.sysj line: 101, column: 21
                                S86312=6;
                                if(!lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 106, column: 21
                                  w_thread_3.removeLid();//sysj/lidRemovalController.sysj line: 112, column: 5
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj/lidRemovalController.sysj line: 113, column: 5
                                  code_thread_3 = OK_thread_3;//sysj/lidRemovalController.sysj line: 116, column: 5
                                  if(lidBinFull.getprestatus()){//sysj/lidRemovalController.sysj line: 117, column: 13
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj/lidRemovalController.sysj line: 118, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj/lidRemovalController.sysj line: 119, column: 6
                                    S86312=7;
                                    S86584=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                      S86584=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S86579=0;
                                      if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                        S86579=1;
                                        if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                          status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                          S88675=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    S86312=7;
                                    S86584=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                      S86584=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S86579=0;
                                      if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                        S86579=1;
                                        if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                          status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                          S88675=2;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                }
                                else {
                                  lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 107, column: 6
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                unscrewTurnRetract.setPresent();//sysj/lidRemovalController.sysj line: 102, column: 6
                                currsigs.addElement(unscrewTurnRetract);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            thread101199(tdone,ends);
                            thread101200(tdone,ends);
                            int biggest101201 = 0;
                            if(ends[6]>=biggest101201){
                              biggest101201=ends[6];
                            }
                            if(ends[7]>=biggest101201){
                              biggest101201=ends[7];
                            }
                            if(biggest101201 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread101202(tdone,ends);
                          thread101203(tdone,ends);
                          int biggest101204 = 0;
                          if(ends[4]>=biggest101204){
                            biggest101204=ends[4];
                          }
                          if(ends[5]>=biggest101204){
                            biggest101204=ends[5];
                          }
                          if(biggest101204 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 81, column: 6
                        currsigs.addElement(cylZaxisExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
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
        break;
      
    }
  }

  public void thread101155(int [] tdone, int [] ends){
        switch(S86287){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj/lidRemovalController.sysj line: 56, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/lidRemovalController.sysj line: 57, column: 8
            auto_1.setPresent();//sysj/lidRemovalController.sysj line: 57, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj/lidRemovalController.sysj line: 58, column: 12
            currsigs.addElement(manual_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
        }
        else {
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread101153(int [] tdone, int [] ends){
        S101141=1;
    S100787=0;
    if(manual_1.getprestatus()){//sysj/lidRemovalController.sysj line: 130, column: 20
      S100787=1;
      if(auto_1.getprestatus()){//sysj/lidRemovalController.sysj line: 131, column: 20
        S100787=2;
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
      }
      else {
        if(cylZaxisExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 133, column: 14
          cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 133, column: 32
          currsigs.addElement(cylZaxisExtend);
          if(unscrewTurnExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 134, column: 14
            unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 134, column: 35
            currsigs.addElement(unscrewTurnExtend);
            if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
              lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                currsigs.addElement(lidEjectExtend);
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
            }
            else {
              if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                currsigs.addElement(lidEjectExtend);
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
            }
          }
          else {
            if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
              lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                currsigs.addElement(lidEjectExtend);
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
            }
            else {
              if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                currsigs.addElement(lidEjectExtend);
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
            }
          }
        }
        else {
          if(unscrewTurnExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 134, column: 14
            unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 134, column: 35
            currsigs.addElement(unscrewTurnExtend);
            if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
              lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                currsigs.addElement(lidEjectExtend);
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
            }
            else {
              if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                currsigs.addElement(lidEjectExtend);
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
            }
          }
          else {
            if(lidGripperExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 135, column: 14
              lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 135, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                currsigs.addElement(lidEjectExtend);
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
            }
            else {
              if(lidEjectExtendM.getprestatus()){//sysj/lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 136, column: 32
                currsigs.addElement(lidEjectExtend);
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
            }
          }
        }
      }
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread101151(int [] tdone, int [] ends){
        S86338=1;
    lidGripperExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread101150(int [] tdone, int [] ends){
        S86333=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread101148(int [] tdone, int [] ends){
        S86393=1;
    unscrewTurnExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101147(int [] tdone, int [] ends){
        S86388=1;
    cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101146(int [] tdone, int [] ends){
        S100611=1;
    OK_thread_3 = 0;//sysj/lidRemovalController.sysj line: 65, column: 3
    BLOCKED_thread_3 = 2;//sysj/lidRemovalController.sysj line: 66, column: 3
    w_thread_3 = null;//sysj/lidRemovalController.sysj line: 68, column: 3
    code_thread_3 = 0;//sysj/lidRemovalController.sysj line: 69, column: 3
    S88675=0;
    if(auto_1.getprestatus()){//sysj/lidRemovalController.sysj line: 72, column: 20
      S88675=1;
      if(manual_1.getprestatus()){//sysj/lidRemovalController.sysj line: 74, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S88675=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S86312=0;
        S86296=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 75, column: 5
          enable_in.setACK(false);//sysj/lidRemovalController.sysj line: 75, column: 5
          S86296=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S86291=0;
          if(!enable_in.isREQ()){//sysj/lidRemovalController.sysj line: 75, column: 5
            enable_in.setACK(true);//sysj/lidRemovalController.sysj line: 75, column: 5
            S86291=1;
            if(enable_in.isREQ()){//sysj/lidRemovalController.sysj line: 75, column: 5
              enable_in.setACK(false);//sysj/lidRemovalController.sysj line: 75, column: 5
              ends[3]=2;
              ;//sysj/lidRemovalController.sysj line: 75, column: 5
              w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj/lidRemovalController.sysj line: 76, column: 5
              System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj/lidRemovalController.sysj line: 77, column: 5
              S86312=1;
              if(zAxisLowered.getprestatus()){//sysj/lidRemovalController.sysj line: 80, column: 21
                S86312=2;
                if(lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 85, column: 21
                  System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj/lidRemovalController.sysj line: 88, column: 5
                  S86312=3;
                  if(turnAtFinalPos.getprestatus()){//sysj/lidRemovalController.sysj line: 91, column: 21
                    S86312=4;
                    if(zAxisLifted.getprestatus()){//sysj/lidRemovalController.sysj line: 98, column: 21
                      S86312=5;
                      if(turnAtHomePos.getprestatus()){//sysj/lidRemovalController.sysj line: 101, column: 21
                        S86312=6;
                        if(!lidGripped.getprestatus()){//sysj/lidRemovalController.sysj line: 106, column: 21
                          w_thread_3.removeLid();//sysj/lidRemovalController.sysj line: 112, column: 5
                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj/lidRemovalController.sysj line: 113, column: 5
                          code_thread_3 = OK_thread_3;//sysj/lidRemovalController.sysj line: 116, column: 5
                          if(lidBinFull.getprestatus()){//sysj/lidRemovalController.sysj line: 117, column: 13
                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj/lidRemovalController.sysj line: 118, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj/lidRemovalController.sysj line: 119, column: 6
                            S86312=7;
                            S86584=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                              S86584=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S86579=0;
                              if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                S86579=1;
                                if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                  ends[3]=2;
                                  ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                  S88675=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            S86312=7;
                            S86584=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj/lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                              S86584=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S86579=0;
                              if(status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj/lidRemovalController.sysj line: 122, column: 5
                                S86579=1;
                                if(!status_o.isACK()){//sysj/lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj/lidRemovalController.sysj line: 122, column: 5
                                  ends[3]=2;
                                  ;//sysj/lidRemovalController.sysj line: 122, column: 5
                                  S88675=2;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                        }
                        else {
                          lidEjectExtend.setPresent();//sysj/lidRemovalController.sysj line: 107, column: 6
                          currsigs.addElement(lidEjectExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        unscrewTurnRetract.setPresent();//sysj/lidRemovalController.sysj line: 102, column: 6
                        currsigs.addElement(unscrewTurnRetract);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    thread101147(tdone,ends);
                    thread101148(tdone,ends);
                    int biggest101149 = 0;
                    if(ends[6]>=biggest101149){
                      biggest101149=ends[6];
                    }
                    if(ends[7]>=biggest101149){
                      biggest101149=ends[7];
                    }
                    if(biggest101149 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  thread101150(tdone,ends);
                  thread101151(tdone,ends);
                  int biggest101152 = 0;
                  if(ends[4]>=biggest101152){
                    biggest101152=ends[4];
                  }
                  if(ends[5]>=biggest101152){
                    biggest101152=ends[5];
                  }
                  if(biggest101152 == 1){
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
              }
              else {
                cylZaxisExtend.setPresent();//sysj/lidRemovalController.sysj line: 81, column: 6
                currsigs.addElement(cylZaxisExtend);
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
          else {
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
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

  public void thread101145(int [] tdone, int [] ends){
        S86287=1;
    if(mode.getprestatus()){//sysj/lidRemovalController.sysj line: 56, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj/lidRemovalController.sysj line: 57, column: 8
        auto_1.setPresent();//sysj/lidRemovalController.sysj line: 57, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj/lidRemovalController.sysj line: 58, column: 12
        currsigs.addElement(manual_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
    }
    else {
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S101143){
        case 0 : 
          S101143=0;
          break RUN;
        
        case 1 : 
          S101143=2;
          S101143=2;
          auto_1.setClear();//sysj/lidRemovalController.sysj line: 52, column: 2
          manual_1.setClear();//sysj/lidRemovalController.sysj line: 52, column: 2
          thread101145(tdone,ends);
          thread101146(tdone,ends);
          thread101153(tdone,ends);
          int biggest101154 = 0;
          if(ends[2]>=biggest101154){
            biggest101154=ends[2];
          }
          if(ends[3]>=biggest101154){
            biggest101154=ends[3];
          }
          if(ends[8]>=biggest101154){
            biggest101154=ends[8];
          }
          if(biggest101154 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj/lidRemovalController.sysj line: 52, column: 2
          manual_1.setClear();//sysj/lidRemovalController.sysj line: 52, column: 2
          thread101155(tdone,ends);
          thread101156(tdone,ends);
          thread101205(tdone,ends);
          int biggest101206 = 0;
          if(ends[2]>=biggest101206){
            biggest101206=ends[2];
          }
          if(ends[3]>=biggest101206){
            biggest101206=ends[3];
          }
          if(ends[8]>=biggest101206){
            biggest101206=ends[8];
          }
          if(biggest101206 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest101206 == 0){
            S101143=0;
            active[1]=0;
            ends[1]=0;
            S101143=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    auto_1 = new Signal();
    manual_1 = new Signal();
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
          enable_in.gethook();
          status_o.gethook();
          mode.gethook();
          zAxisLowered.gethook();
          zAxisLifted.gethook();
          turnAtHomePos.gethook();
          turnAtFinalPos.gethook();
          lidGripped.gethook();
          lidBinFull.gethook();
          cylZaxisExtendM.gethook();
          unscrewTurnExtendM.gethook();
          lidGripperExtendM.gethook();
          lidEjectExtendM.gethook();
          df = true;
        }
        runClockDomain();
      }
      mode.setpreclear();
      zAxisLowered.setpreclear();
      zAxisLifted.setpreclear();
      turnAtHomePos.setpreclear();
      turnAtFinalPos.setpreclear();
      lidGripped.setpreclear();
      lidBinFull.setpreclear();
      cylZaxisExtendM.setpreclear();
      unscrewTurnExtendM.setpreclear();
      lidGripperExtendM.setpreclear();
      lidEjectExtendM.setpreclear();
      cylZaxisExtend.setpreclear();
      unscrewTurnExtend.setpreclear();
      unscrewTurnRetract.setpreclear();
      lidGripperExtend.setpreclear();
      lidEjectExtend.setpreclear();
      auto_1.setpreclear();
      manual_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      dummyint = zAxisLowered.getStatus() ? zAxisLowered.setprepresent() : zAxisLowered.setpreclear();
      zAxisLowered.setpreval(zAxisLowered.getValue());
      zAxisLowered.setClear();
      dummyint = zAxisLifted.getStatus() ? zAxisLifted.setprepresent() : zAxisLifted.setpreclear();
      zAxisLifted.setpreval(zAxisLifted.getValue());
      zAxisLifted.setClear();
      dummyint = turnAtHomePos.getStatus() ? turnAtHomePos.setprepresent() : turnAtHomePos.setpreclear();
      turnAtHomePos.setpreval(turnAtHomePos.getValue());
      turnAtHomePos.setClear();
      dummyint = turnAtFinalPos.getStatus() ? turnAtFinalPos.setprepresent() : turnAtFinalPos.setpreclear();
      turnAtFinalPos.setpreval(turnAtFinalPos.getValue());
      turnAtFinalPos.setClear();
      dummyint = lidGripped.getStatus() ? lidGripped.setprepresent() : lidGripped.setpreclear();
      lidGripped.setpreval(lidGripped.getValue());
      lidGripped.setClear();
      dummyint = lidBinFull.getStatus() ? lidBinFull.setprepresent() : lidBinFull.setpreclear();
      lidBinFull.setpreval(lidBinFull.getValue());
      lidBinFull.setClear();
      dummyint = cylZaxisExtendM.getStatus() ? cylZaxisExtendM.setprepresent() : cylZaxisExtendM.setpreclear();
      cylZaxisExtendM.setpreval(cylZaxisExtendM.getValue());
      cylZaxisExtendM.setClear();
      dummyint = unscrewTurnExtendM.getStatus() ? unscrewTurnExtendM.setprepresent() : unscrewTurnExtendM.setpreclear();
      unscrewTurnExtendM.setpreval(unscrewTurnExtendM.getValue());
      unscrewTurnExtendM.setClear();
      dummyint = lidGripperExtendM.getStatus() ? lidGripperExtendM.setprepresent() : lidGripperExtendM.setpreclear();
      lidGripperExtendM.setpreval(lidGripperExtendM.getValue());
      lidGripperExtendM.setClear();
      dummyint = lidEjectExtendM.getStatus() ? lidEjectExtendM.setprepresent() : lidEjectExtendM.setpreclear();
      lidEjectExtendM.setpreval(lidEjectExtendM.getValue());
      lidEjectExtendM.setClear();
      cylZaxisExtend.sethook();
      cylZaxisExtend.setClear();
      unscrewTurnExtend.sethook();
      unscrewTurnExtend.setClear();
      unscrewTurnRetract.sethook();
      unscrewTurnRetract.setClear();
      lidGripperExtend.sethook();
      lidGripperExtend.setClear();
      lidEjectExtend.sethook();
      lidEjectExtend.setClear();
      auto_1.setClear();
      manual_1.setClear();
      enable_in.sethook();
      status_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable_in.gethook();
        status_o.gethook();
        mode.gethook();
        zAxisLowered.gethook();
        zAxisLifted.gethook();
        turnAtHomePos.gethook();
        turnAtFinalPos.gethook();
        lidGripped.gethook();
        lidBinFull.gethook();
        cylZaxisExtendM.gethook();
        unscrewTurnExtendM.gethook();
        lidGripperExtendM.gethook();
        lidEjectExtendM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
