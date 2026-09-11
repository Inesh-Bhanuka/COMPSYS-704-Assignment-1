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
  private int OK_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 3
  private int BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 131, column: 3
  private WorkpieceTwin w_thread_3;//sysj\lidRemovalController.sysj line: 135, column: 3
  private int code_thread_3;//sysj\lidRemovalController.sysj line: 137, column: 3
  private int S121474 = 1;
  private int S106618 = 1;
  private int S120942 = 1;
  private int S109006 = 1;
  private int S106643 = 1;
  private int S106627 = 1;
  private int S106622 = 1;
  private int S106664 = 1;
  private int S106669 = 1;
  private int S106719 = 1;
  private int S106724 = 1;
  private int S106915 = 1;
  private int S106910 = 1;
  private int S121472 = 1;
  private int S121118 = 1;
  
  private int[] ends = new int[9];
  private int[] tdone = new int[9];
  
  public void thread121536(int [] tdone, int [] ends){
        switch(S121472){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S121118){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 259, column: 20
              S121118=1;
              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 261, column: 20
                S121118=2;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 265, column: 14
                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 265, column: 32
                  currsigs.addElement(cylZaxisExtend);
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 267, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 267, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 267, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 267, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 261, column: 20
              S121118=2;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 265, column: 14
                cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 265, column: 32
                currsigs.addElement(cylZaxisExtend);
                if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 267, column: 14
                  unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 267, column: 35
                  currsigs.addElement(unscrewTurnExtend);
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 267, column: 14
                  unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 267, column: 35
                  currsigs.addElement(unscrewTurnExtend);
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
            S121118=2;
            S121118=0;
            if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 259, column: 20
              S121118=1;
              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 261, column: 20
                S121118=2;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 265, column: 14
                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 265, column: 32
                  currsigs.addElement(cylZaxisExtend);
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 267, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 267, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 267, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 267, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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

  public void thread121534(int [] tdone, int [] ends){
        S106669=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread121533(int [] tdone, int [] ends){
        S106664=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread121531(int [] tdone, int [] ends){
        S106724=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread121530(int [] tdone, int [] ends){
        S106719=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread121528(int [] tdone, int [] ends){
        switch(S106724){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
        currsigs.addElement(unscrewTurnExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread121527(int [] tdone, int [] ends){
        switch(S106719){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
        currsigs.addElement(cylZaxisExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread121525(int [] tdone, int [] ends){
        S106724=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread121524(int [] tdone, int [] ends){
        S106719=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread121522(int [] tdone, int [] ends){
        switch(S106669){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 39
        currsigs.addElement(lidGripperExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread121521(int [] tdone, int [] ends){
        switch(S106664){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 8
        currsigs.addElement(cylZaxisExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread121519(int [] tdone, int [] ends){
        S106724=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread121518(int [] tdone, int [] ends){
        S106719=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread121516(int [] tdone, int [] ends){
        S106669=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread121515(int [] tdone, int [] ends){
        S106664=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread121513(int [] tdone, int [] ends){
        S106724=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread121512(int [] tdone, int [] ends){
        S106719=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread121510(int [] tdone, int [] ends){
        S106669=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread121509(int [] tdone, int [] ends){
        S106664=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread121507(int [] tdone, int [] ends){
        S106724=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread121506(int [] tdone, int [] ends){
        S106719=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread121504(int [] tdone, int [] ends){
        S106669=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread121503(int [] tdone, int [] ends){
        S106664=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread121501(int [] tdone, int [] ends){
        S106724=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread121500(int [] tdone, int [] ends){
        S106719=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread121498(int [] tdone, int [] ends){
        S106669=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread121497(int [] tdone, int [] ends){
        S106664=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread121495(int [] tdone, int [] ends){
        S106724=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread121494(int [] tdone, int [] ends){
        S106719=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread121492(int [] tdone, int [] ends){
        S106669=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread121491(int [] tdone, int [] ends){
        S106664=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread121489(int [] tdone, int [] ends){
        S106724=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread121488(int [] tdone, int [] ends){
        S106719=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread121487(int [] tdone, int [] ends){
        switch(S120942){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S109006){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 143, column: 20
              S109006=1;
              if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 147, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S109006=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S106643=0;
                S106627=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 149, column: 5
                  enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                  S106627=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S106622=0;
                  if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                    enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 149, column: 5
                    S106622=1;
                    if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                      enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                      ends[3]=2;
                      ;//sysj\lidRemovalController.sysj line: 149, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 151, column: 5
                      System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 153, column: 5
                      S106643=1;
                      if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 159, column: 21
                        S106643=2;
                        if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 169, column: 21
                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                          S106643=3;
                          if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                            S106643=4;
                            if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                              S106643=5;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                                S106643=6;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                                    S106643=7;
                                    S106915=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                      S106915=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S106910=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                        S106910=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                          S109006=2;
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
                                    S106643=7;
                                    S106915=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                      S106915=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S106910=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                        S106910=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                          S109006=2;
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
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 213, column: 6
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 203, column: 6
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
                            thread121488(tdone,ends);
                            thread121489(tdone,ends);
                            int biggest121490 = 0;
                            if(ends[6]>=biggest121490){
                              biggest121490=ends[6];
                            }
                            if(ends[7]>=biggest121490){
                              biggest121490=ends[7];
                            }
                            if(biggest121490 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread121491(tdone,ends);
                          thread121492(tdone,ends);
                          int biggest121493 = 0;
                          if(ends[4]>=biggest121493){
                            biggest121493=ends[4];
                          }
                          if(ends[5]>=biggest121493){
                            biggest121493=ends[5];
                          }
                          if(biggest121493 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 161, column: 6
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
            if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 147, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S109006=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S106643){
                case 0 : 
                  switch(S106627){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 149, column: 5
                        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                        S106627=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S106622){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                              enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 149, column: 5
                              S106622=1;
                              if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                                enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 149, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 151, column: 5
                                System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 153, column: 5
                                S106643=1;
                                if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 159, column: 21
                                  S106643=2;
                                  if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 169, column: 21
                                    System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                                    S106643=3;
                                    if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                                      S106643=4;
                                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                                        S106643=5;
                                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                                          S106643=6;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                                              S106643=7;
                                              S106915=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                                S106915=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S106910=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                                  S106910=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                                    S109006=2;
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
                                              S106643=7;
                                              S106915=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                                S106915=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S106910=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                                  S106910=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                                    S109006=2;
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
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 213, column: 6
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 203, column: 6
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
                                      thread121494(tdone,ends);
                                      thread121495(tdone,ends);
                                      int biggest121496 = 0;
                                      if(ends[6]>=biggest121496){
                                        biggest121496=ends[6];
                                      }
                                      if(ends[7]>=biggest121496){
                                        biggest121496=ends[7];
                                      }
                                      if(biggest121496 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread121497(tdone,ends);
                                    thread121498(tdone,ends);
                                    int biggest121499 = 0;
                                    if(ends[4]>=biggest121499){
                                      biggest121499=ends[4];
                                    }
                                    if(ends[5]>=biggest121499){
                                      biggest121499=ends[5];
                                    }
                                    if(biggest121499 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 161, column: 6
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
                            if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                              enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 149, column: 5
                              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 151, column: 5
                              System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 153, column: 5
                              S106643=1;
                              if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 159, column: 21
                                S106643=2;
                                if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 169, column: 21
                                  System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                                  S106643=3;
                                  if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                                    S106643=4;
                                    if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                                      S106643=5;
                                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                                        S106643=6;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                                            S106643=7;
                                            S106915=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                              S106915=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S106910=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                                S106910=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                                  S109006=2;
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
                                            S106643=7;
                                            S106915=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                              S106915=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S106910=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                                S106910=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                                  S109006=2;
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
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 213, column: 6
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 203, column: 6
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
                                    thread121500(tdone,ends);
                                    thread121501(tdone,ends);
                                    int biggest121502 = 0;
                                    if(ends[6]>=biggest121502){
                                      biggest121502=ends[6];
                                    }
                                    if(ends[7]>=biggest121502){
                                      biggest121502=ends[7];
                                    }
                                    if(biggest121502 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread121503(tdone,ends);
                                  thread121504(tdone,ends);
                                  int biggest121505 = 0;
                                  if(ends[4]>=biggest121505){
                                    biggest121505=ends[4];
                                  }
                                  if(ends[5]>=biggest121505){
                                    biggest121505=ends[5];
                                  }
                                  if(biggest121505 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 161, column: 6
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
                      S106627=1;
                      S106627=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 149, column: 5
                        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                        S106627=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S106622=0;
                        if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                          enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 149, column: 5
                          S106622=1;
                          if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                            enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 149, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 151, column: 5
                            System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 153, column: 5
                            S106643=1;
                            if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 159, column: 21
                              S106643=2;
                              if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 169, column: 21
                                System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                                S106643=3;
                                if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                                  S106643=4;
                                  if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                                    S106643=5;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                                      S106643=6;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                                          S106643=7;
                                          S106915=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                            S106915=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S106910=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                              S106910=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                                S109006=2;
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
                                          S106643=7;
                                          S106915=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                            S106915=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S106910=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                              S106910=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                                S109006=2;
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
                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 213, column: 6
                                        currsigs.addElement(lidEjectExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 203, column: 6
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
                                  thread121506(tdone,ends);
                                  thread121507(tdone,ends);
                                  int biggest121508 = 0;
                                  if(ends[6]>=biggest121508){
                                    biggest121508=ends[6];
                                  }
                                  if(ends[7]>=biggest121508){
                                    biggest121508=ends[7];
                                  }
                                  if(biggest121508 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                thread121509(tdone,ends);
                                thread121510(tdone,ends);
                                int biggest121511 = 0;
                                if(ends[4]>=biggest121511){
                                  biggest121511=ends[4];
                                }
                                if(ends[5]>=biggest121511){
                                  biggest121511=ends[5];
                                }
                                if(biggest121511 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 161, column: 6
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
                  if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 159, column: 21
                    S106643=2;
                    if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 169, column: 21
                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                      S106643=3;
                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                        S106643=4;
                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                          S106643=5;
                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                            S106643=6;
                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                                S106643=7;
                                S106915=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                  S106915=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S106910=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                    S106910=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                      S109006=2;
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
                                S106643=7;
                                S106915=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                  S106915=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S106910=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                    S106910=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                      S109006=2;
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
                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 213, column: 6
                              currsigs.addElement(lidEjectExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 203, column: 6
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
                        thread121512(tdone,ends);
                        thread121513(tdone,ends);
                        int biggest121514 = 0;
                        if(ends[6]>=biggest121514){
                          biggest121514=ends[6];
                        }
                        if(ends[7]>=biggest121514){
                          biggest121514=ends[7];
                        }
                        if(biggest121514 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      thread121515(tdone,ends);
                      thread121516(tdone,ends);
                      int biggest121517 = 0;
                      if(ends[4]>=biggest121517){
                        biggest121517=ends[4];
                      }
                      if(ends[5]>=biggest121517){
                        biggest121517=ends[5];
                      }
                      if(biggest121517 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 161, column: 6
                    currsigs.addElement(cylZaxisExtend);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 2 : 
                  if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 169, column: 21
                    System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                    S106643=3;
                    if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                      S106643=4;
                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                        S106643=5;
                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                          S106643=6;
                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                              S106643=7;
                              S106915=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                S106915=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S106910=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                  S106910=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                    S109006=2;
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
                              S106643=7;
                              S106915=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                S106915=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S106910=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                  S106910=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                    S109006=2;
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
                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 213, column: 6
                            currsigs.addElement(lidEjectExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 203, column: 6
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
                      thread121518(tdone,ends);
                      thread121519(tdone,ends);
                      int biggest121520 = 0;
                      if(ends[6]>=biggest121520){
                        biggest121520=ends[6];
                      }
                      if(ends[7]>=biggest121520){
                        biggest121520=ends[7];
                      }
                      if(biggest121520 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread121521(tdone,ends);
                    thread121522(tdone,ends);
                    int biggest121523 = 0;
                    if(ends[4]>=biggest121523){
                      biggest121523=ends[4];
                    }
                    if(ends[5]>=biggest121523){
                      biggest121523=ends[5];
                    }
                    if(biggest121523 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest121523 == 0){
                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                      S106643=3;
                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                        S106643=4;
                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                          S106643=5;
                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                            S106643=6;
                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                                S106643=7;
                                S106915=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                  S106915=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S106910=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                    S106910=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                      S109006=2;
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
                                S106643=7;
                                S106915=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                  S106915=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S106910=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                    S106910=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                      S109006=2;
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
                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 213, column: 6
                              currsigs.addElement(lidEjectExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 203, column: 6
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
                        thread121524(tdone,ends);
                        thread121525(tdone,ends);
                        int biggest121526 = 0;
                        if(ends[6]>=biggest121526){
                          biggest121526=ends[6];
                        }
                        if(ends[7]>=biggest121526){
                          biggest121526=ends[7];
                        }
                        if(biggest121526 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  break;
                
                case 3 : 
                  if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                    S106643=4;
                    if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                      S106643=5;
                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                        S106643=6;
                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                            S106643=7;
                            S106915=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                              S106915=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S106910=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                S106910=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                  S109006=2;
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
                            S106643=7;
                            S106915=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                              S106915=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S106910=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                S106910=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                  S109006=2;
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
                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 213, column: 6
                          currsigs.addElement(lidEjectExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 203, column: 6
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
                    thread121527(tdone,ends);
                    thread121528(tdone,ends);
                    int biggest121529 = 0;
                    if(ends[6]>=biggest121529){
                      biggest121529=ends[6];
                    }
                    if(ends[7]>=biggest121529){
                      biggest121529=ends[7];
                    }
                    if(biggest121529 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest121529 == 0){
                      S106643=4;
                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                        S106643=5;
                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                          S106643=6;
                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                              S106643=7;
                              S106915=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                S106915=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S106910=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                  S106910=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                    S109006=2;
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
                              S106643=7;
                              S106915=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                S106915=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S106910=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                  S106910=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                    S109006=2;
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
                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 213, column: 6
                            currsigs.addElement(lidEjectExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 203, column: 6
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
                  if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                    S106643=5;
                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                      S106643=6;
                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                          S106643=7;
                          S106915=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                            S106915=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S106910=0;
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                              S106910=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                S109006=2;
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
                          S106643=7;
                          S106915=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                            S106915=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S106910=0;
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                              S106910=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                S109006=2;
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
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 213, column: 6
                        currsigs.addElement(lidEjectExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 203, column: 6
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
                  if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                    S106643=6;
                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                        S106643=7;
                        S106915=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                          S106915=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S106910=0;
                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                            S106910=1;
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 243, column: 5
                              S109006=2;
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
                        S106643=7;
                        S106915=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                          S106915=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S106910=0;
                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                            S106910=1;
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 243, column: 5
                              S109006=2;
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
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 213, column: 6
                      currsigs.addElement(lidEjectExtend);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 203, column: 6
                    currsigs.addElement(unscrewTurnRetract);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 6 : 
                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                      S106643=7;
                      S106915=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                        S106915=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S106910=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                          S106910=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 243, column: 5
                            S109006=2;
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
                      S106643=7;
                      S106915=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                        S106915=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S106910=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                          S106910=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 243, column: 5
                            S109006=2;
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
                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 213, column: 6
                    currsigs.addElement(lidEjectExtend);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 7 : 
                  switch(S106915){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                        S106915=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S106910){
                          case 0 : 
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                              S106910=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                S109006=2;
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
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 243, column: 5
                              S109006=2;
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
                      S106915=1;
                      S106915=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                        S106915=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S106910=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                          S106910=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 243, column: 5
                            S109006=2;
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
                  S109006=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S109006=2;
            S109006=0;
            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 143, column: 20
              S109006=1;
              if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 147, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S109006=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S106643=0;
                S106627=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 149, column: 5
                  enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                  S106627=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S106622=0;
                  if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                    enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 149, column: 5
                    S106622=1;
                    if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                      enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                      ends[3]=2;
                      ;//sysj\lidRemovalController.sysj line: 149, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 151, column: 5
                      System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 153, column: 5
                      S106643=1;
                      if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 159, column: 21
                        S106643=2;
                        if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 169, column: 21
                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                          S106643=3;
                          if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                            S106643=4;
                            if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                              S106643=5;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                                S106643=6;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                                    S106643=7;
                                    S106915=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                      S106915=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S106910=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                        S106910=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                          S109006=2;
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
                                    S106643=7;
                                    S106915=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                      S106915=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S106910=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                        S106910=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                          S109006=2;
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
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 213, column: 6
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 203, column: 6
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
                            thread121530(tdone,ends);
                            thread121531(tdone,ends);
                            int biggest121532 = 0;
                            if(ends[6]>=biggest121532){
                              biggest121532=ends[6];
                            }
                            if(ends[7]>=biggest121532){
                              biggest121532=ends[7];
                            }
                            if(biggest121532 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread121533(tdone,ends);
                          thread121534(tdone,ends);
                          int biggest121535 = 0;
                          if(ends[4]>=biggest121535){
                            biggest121535=ends[4];
                          }
                          if(ends[5]>=biggest121535){
                            biggest121535=ends[5];
                          }
                          if(biggest121535 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 161, column: 6
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

  public void thread121486(int [] tdone, int [] ends){
        switch(S106618){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\lidRemovalController.sysj line: 111, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidRemovalController.sysj line: 113, column: 8
            auto_1.setPresent();//sysj\lidRemovalController.sysj line: 113, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\lidRemovalController.sysj line: 115, column: 12
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

  public void thread121484(int [] tdone, int [] ends){
        S121472=1;
    S121118=0;
    if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 259, column: 20
      S121118=1;
      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 261, column: 20
        S121118=2;
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
      }
      else {
        if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 265, column: 14
          cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 265, column: 32
          currsigs.addElement(cylZaxisExtend);
          if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 267, column: 14
            unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 267, column: 35
            currsigs.addElement(unscrewTurnExtend);
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
          if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 267, column: 14
            unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 267, column: 35
            currsigs.addElement(unscrewTurnExtend);
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 32
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

  public void thread121482(int [] tdone, int [] ends){
        S106669=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread121481(int [] tdone, int [] ends){
        S106664=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread121479(int [] tdone, int [] ends){
        S106724=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread121478(int [] tdone, int [] ends){
        S106719=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread121477(int [] tdone, int [] ends){
        S120942=1;
    OK_thread_3 = 0;//sysj\lidRemovalController.sysj line: 129, column: 3
    BLOCKED_thread_3 = 2;//sysj\lidRemovalController.sysj line: 131, column: 3
    w_thread_3 = null;//sysj\lidRemovalController.sysj line: 135, column: 3
    code_thread_3 = 0;//sysj\lidRemovalController.sysj line: 137, column: 3
    S109006=0;
    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 143, column: 20
      S109006=1;
      if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 147, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S109006=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S106643=0;
        S106627=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 149, column: 5
          enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
          S106627=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S106622=0;
          if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
            enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 149, column: 5
            S106622=1;
            if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
              enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
              ends[3]=2;
              ;//sysj\lidRemovalController.sysj line: 149, column: 5
              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 151, column: 5
              System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 153, column: 5
              S106643=1;
              if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 159, column: 21
                S106643=2;
                if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 169, column: 21
                  System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                  S106643=3;
                  if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                    S106643=4;
                    if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                      S106643=5;
                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                        S106643=6;
                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                            S106643=7;
                            S106915=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                              S106915=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S106910=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                S106910=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                  S109006=2;
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
                            S106643=7;
                            S106915=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 243, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                              S106915=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S106910=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 243, column: 5
                                S106910=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 243, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 243, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 243, column: 5
                                  S109006=2;
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
                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 213, column: 6
                          currsigs.addElement(lidEjectExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 203, column: 6
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
                    thread121478(tdone,ends);
                    thread121479(tdone,ends);
                    int biggest121480 = 0;
                    if(ends[6]>=biggest121480){
                      biggest121480=ends[6];
                    }
                    if(ends[7]>=biggest121480){
                      biggest121480=ends[7];
                    }
                    if(biggest121480 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  thread121481(tdone,ends);
                  thread121482(tdone,ends);
                  int biggest121483 = 0;
                  if(ends[4]>=biggest121483){
                    biggest121483=ends[4];
                  }
                  if(ends[5]>=biggest121483){
                    biggest121483=ends[5];
                  }
                  if(biggest121483 == 1){
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
              }
              else {
                cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 161, column: 6
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

  public void thread121476(int [] tdone, int [] ends){
        S106618=1;
    if(mode.getprestatus()){//sysj\lidRemovalController.sysj line: 111, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidRemovalController.sysj line: 113, column: 8
        auto_1.setPresent();//sysj\lidRemovalController.sysj line: 113, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\lidRemovalController.sysj line: 115, column: 12
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
      switch(S121474){
        case 0 : 
          S121474=0;
          break RUN;
        
        case 1 : 
          S121474=2;
          S121474=2;
          auto_1.setClear();//sysj\lidRemovalController.sysj line: 103, column: 2
          manual_1.setClear();//sysj\lidRemovalController.sysj line: 103, column: 2
          thread121476(tdone,ends);
          thread121477(tdone,ends);
          thread121484(tdone,ends);
          int biggest121485 = 0;
          if(ends[2]>=biggest121485){
            biggest121485=ends[2];
          }
          if(ends[3]>=biggest121485){
            biggest121485=ends[3];
          }
          if(ends[8]>=biggest121485){
            biggest121485=ends[8];
          }
          if(biggest121485 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidRemovalController.sysj line: 103, column: 2
          manual_1.setClear();//sysj\lidRemovalController.sysj line: 103, column: 2
          thread121486(tdone,ends);
          thread121487(tdone,ends);
          thread121536(tdone,ends);
          int biggest121537 = 0;
          if(ends[2]>=biggest121537){
            biggest121537=ends[2];
          }
          if(ends[3]>=biggest121537){
            biggest121537=ends[3];
          }
          if(ends[8]>=biggest121537){
            biggest121537=ends[8];
          }
          if(biggest121537 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest121537 == 0){
            S121474=0;
            active[1]=0;
            ends[1]=0;
            S121474=0;
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
