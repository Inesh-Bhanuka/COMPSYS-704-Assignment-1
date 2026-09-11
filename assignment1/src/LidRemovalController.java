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
  private int S119242 = 1;
  private int S103558 = 1;
  private int S118710 = 1;
  private int S106084 = 1;
  private int S103583 = 1;
  private int S103567 = 1;
  private int S103562 = 1;
  private int S103604 = 1;
  private int S103609 = 1;
  private int S103659 = 1;
  private int S103664 = 1;
  private int S103879 = 1;
  private int S103874 = 1;
  private int S119240 = 1;
  private int S118886 = 1;
  
  private int[] ends = new int[9];
  private int[] tdone = new int[9];
  
  public void thread119304(int [] tdone, int [] ends){
        switch(S119240){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S118886){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 263, column: 20
              S118886=1;
              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 265, column: 20
                S118886=2;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 32
                  currsigs.addElement(cylZaxisExtend);
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 265, column: 20
              S118886=2;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
                cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 32
                currsigs.addElement(cylZaxisExtend);
                if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                  unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 35
                  currsigs.addElement(unscrewTurnExtend);
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                  unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 35
                  currsigs.addElement(unscrewTurnExtend);
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
            S118886=2;
            S118886=0;
            if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 263, column: 20
              S118886=1;
              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 265, column: 20
                S118886=2;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 32
                  currsigs.addElement(cylZaxisExtend);
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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

  public void thread119302(int [] tdone, int [] ends){
        S103609=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread119301(int [] tdone, int [] ends){
        S103604=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread119299(int [] tdone, int [] ends){
        S103664=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread119298(int [] tdone, int [] ends){
        S103659=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread119296(int [] tdone, int [] ends){
        switch(S103664){
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

  public void thread119295(int [] tdone, int [] ends){
        switch(S103659){
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

  public void thread119293(int [] tdone, int [] ends){
        S103664=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread119292(int [] tdone, int [] ends){
        S103659=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread119290(int [] tdone, int [] ends){
        switch(S103609){
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

  public void thread119289(int [] tdone, int [] ends){
        switch(S103604){
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

  public void thread119287(int [] tdone, int [] ends){
        S103664=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread119286(int [] tdone, int [] ends){
        S103659=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread119284(int [] tdone, int [] ends){
        S103609=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread119283(int [] tdone, int [] ends){
        S103604=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread119281(int [] tdone, int [] ends){
        S103664=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread119280(int [] tdone, int [] ends){
        S103659=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread119278(int [] tdone, int [] ends){
        S103609=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread119277(int [] tdone, int [] ends){
        S103604=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread119275(int [] tdone, int [] ends){
        S103664=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread119274(int [] tdone, int [] ends){
        S103659=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread119272(int [] tdone, int [] ends){
        S103609=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread119271(int [] tdone, int [] ends){
        S103604=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread119269(int [] tdone, int [] ends){
        S103664=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread119268(int [] tdone, int [] ends){
        S103659=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread119266(int [] tdone, int [] ends){
        S103609=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread119265(int [] tdone, int [] ends){
        S103604=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread119263(int [] tdone, int [] ends){
        S103664=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread119262(int [] tdone, int [] ends){
        S103659=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread119260(int [] tdone, int [] ends){
        S103609=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread119259(int [] tdone, int [] ends){
        S103604=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread119257(int [] tdone, int [] ends){
        S103664=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread119256(int [] tdone, int [] ends){
        S103659=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread119255(int [] tdone, int [] ends){
        switch(S118710){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S106084){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 143, column: 20
              S106084=1;
              if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 147, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S106084=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S103583=0;
                S103567=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 149, column: 5
                  enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                  S103567=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S103562=0;
                  if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                    enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 149, column: 5
                    S103562=1;
                    if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                      enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                      ends[3]=2;
                      ;//sysj\lidRemovalController.sysj line: 149, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 151, column: 5
                      System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 153, column: 5
                      S103583=1;
                      if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 159, column: 21
                        S103583=2;
                        if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 169, column: 21
                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                          S103583=3;
                          if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                            S103583=4;
                            if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                              S103583=5;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                                S103583=6;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                                  S103583=7;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 240, column: 37
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 241, column: 21
                                      S103583=8;
                                      S103879=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                        S103879=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S103874=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                          S103874=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                            S106084=2;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S103583=8;
                                    S103879=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                      S103879=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S103874=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                        S103874=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                          S106084=2;
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
                            thread119256(tdone,ends);
                            thread119257(tdone,ends);
                            int biggest119258 = 0;
                            if(ends[6]>=biggest119258){
                              biggest119258=ends[6];
                            }
                            if(ends[7]>=biggest119258){
                              biggest119258=ends[7];
                            }
                            if(biggest119258 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread119259(tdone,ends);
                          thread119260(tdone,ends);
                          int biggest119261 = 0;
                          if(ends[4]>=biggest119261){
                            biggest119261=ends[4];
                          }
                          if(ends[5]>=biggest119261){
                            biggest119261=ends[5];
                          }
                          if(biggest119261 == 1){
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
              S106084=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S103583){
                case 0 : 
                  switch(S103567){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 149, column: 5
                        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                        S103567=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S103562){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                              enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 149, column: 5
                              S103562=1;
                              if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                                enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 149, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 151, column: 5
                                System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 153, column: 5
                                S103583=1;
                                if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 159, column: 21
                                  S103583=2;
                                  if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 169, column: 21
                                    System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                                    S103583=3;
                                    if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                                      S103583=4;
                                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                                        S103583=5;
                                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                                          S103583=6;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                                            S103583=7;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 240, column: 37
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 241, column: 21
                                                S103583=8;
                                                S103879=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                                  S103879=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S103874=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                                    S103874=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                                      S106084=2;
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
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                            }
                                            else {
                                              S103583=8;
                                              S103879=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                                S103879=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S103874=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                                  S103874=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                                    S106084=2;
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
                                      thread119262(tdone,ends);
                                      thread119263(tdone,ends);
                                      int biggest119264 = 0;
                                      if(ends[6]>=biggest119264){
                                        biggest119264=ends[6];
                                      }
                                      if(ends[7]>=biggest119264){
                                        biggest119264=ends[7];
                                      }
                                      if(biggest119264 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread119265(tdone,ends);
                                    thread119266(tdone,ends);
                                    int biggest119267 = 0;
                                    if(ends[4]>=biggest119267){
                                      biggest119267=ends[4];
                                    }
                                    if(ends[5]>=biggest119267){
                                      biggest119267=ends[5];
                                    }
                                    if(biggest119267 == 1){
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
                              S103583=1;
                              if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 159, column: 21
                                S103583=2;
                                if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 169, column: 21
                                  System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                                  S103583=3;
                                  if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                                    S103583=4;
                                    if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                                      S103583=5;
                                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                                        S103583=6;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                                          S103583=7;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 240, column: 37
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 241, column: 21
                                              S103583=8;
                                              S103879=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                                S103879=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S103874=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                                  S103874=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                                    S106084=2;
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
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            S103583=8;
                                            S103879=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                              S103879=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S103874=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                                S103874=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                                  S106084=2;
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
                                    thread119268(tdone,ends);
                                    thread119269(tdone,ends);
                                    int biggest119270 = 0;
                                    if(ends[6]>=biggest119270){
                                      biggest119270=ends[6];
                                    }
                                    if(ends[7]>=biggest119270){
                                      biggest119270=ends[7];
                                    }
                                    if(biggest119270 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread119271(tdone,ends);
                                  thread119272(tdone,ends);
                                  int biggest119273 = 0;
                                  if(ends[4]>=biggest119273){
                                    biggest119273=ends[4];
                                  }
                                  if(ends[5]>=biggest119273){
                                    biggest119273=ends[5];
                                  }
                                  if(biggest119273 == 1){
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
                      S103567=1;
                      S103567=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 149, column: 5
                        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                        S103567=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S103562=0;
                        if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                          enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 149, column: 5
                          S103562=1;
                          if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                            enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 149, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 151, column: 5
                            System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 153, column: 5
                            S103583=1;
                            if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 159, column: 21
                              S103583=2;
                              if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 169, column: 21
                                System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                                S103583=3;
                                if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                                  S103583=4;
                                  if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                                    S103583=5;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                                      S103583=6;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                                        S103583=7;
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 240, column: 37
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 241, column: 21
                                            S103583=8;
                                            S103879=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                              S103879=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S103874=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                                S103874=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                                  S106084=2;
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
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          S103583=8;
                                          S103879=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                            S103879=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S103874=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                              S103874=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                                S106084=2;
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
                                  thread119274(tdone,ends);
                                  thread119275(tdone,ends);
                                  int biggest119276 = 0;
                                  if(ends[6]>=biggest119276){
                                    biggest119276=ends[6];
                                  }
                                  if(ends[7]>=biggest119276){
                                    biggest119276=ends[7];
                                  }
                                  if(biggest119276 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                thread119277(tdone,ends);
                                thread119278(tdone,ends);
                                int biggest119279 = 0;
                                if(ends[4]>=biggest119279){
                                  biggest119279=ends[4];
                                }
                                if(ends[5]>=biggest119279){
                                  biggest119279=ends[5];
                                }
                                if(biggest119279 == 1){
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
                    S103583=2;
                    if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 169, column: 21
                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                      S103583=3;
                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                        S103583=4;
                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                          S103583=5;
                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                            S103583=6;
                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                              S103583=7;
                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                                if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 240, column: 37
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 241, column: 21
                                  S103583=8;
                                  S103879=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                    S103879=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S103874=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                      S103874=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                        S106084=2;
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
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S103583=8;
                                S103879=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                  S103879=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S103874=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                    S103874=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                      S106084=2;
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
                        thread119280(tdone,ends);
                        thread119281(tdone,ends);
                        int biggest119282 = 0;
                        if(ends[6]>=biggest119282){
                          biggest119282=ends[6];
                        }
                        if(ends[7]>=biggest119282){
                          biggest119282=ends[7];
                        }
                        if(biggest119282 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      thread119283(tdone,ends);
                      thread119284(tdone,ends);
                      int biggest119285 = 0;
                      if(ends[4]>=biggest119285){
                        biggest119285=ends[4];
                      }
                      if(ends[5]>=biggest119285){
                        biggest119285=ends[5];
                      }
                      if(biggest119285 == 1){
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
                    S103583=3;
                    if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                      S103583=4;
                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                        S103583=5;
                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                          S103583=6;
                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                            S103583=7;
                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 240, column: 37
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 241, column: 21
                                S103583=8;
                                S103879=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                  S103879=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S103874=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                    S103874=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                      S106084=2;
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
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S103583=8;
                              S103879=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                S103879=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S103874=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                  S103874=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                    S106084=2;
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
                      thread119286(tdone,ends);
                      thread119287(tdone,ends);
                      int biggest119288 = 0;
                      if(ends[6]>=biggest119288){
                        biggest119288=ends[6];
                      }
                      if(ends[7]>=biggest119288){
                        biggest119288=ends[7];
                      }
                      if(biggest119288 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread119289(tdone,ends);
                    thread119290(tdone,ends);
                    int biggest119291 = 0;
                    if(ends[4]>=biggest119291){
                      biggest119291=ends[4];
                    }
                    if(ends[5]>=biggest119291){
                      biggest119291=ends[5];
                    }
                    if(biggest119291 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest119291 == 0){
                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                      S103583=3;
                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                        S103583=4;
                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                          S103583=5;
                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                            S103583=6;
                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                              S103583=7;
                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                                if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 240, column: 37
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 241, column: 21
                                  S103583=8;
                                  S103879=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                    S103879=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S103874=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                      S103874=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                        S106084=2;
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
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S103583=8;
                                S103879=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                  S103879=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S103874=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                    S103874=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                      S106084=2;
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
                        thread119292(tdone,ends);
                        thread119293(tdone,ends);
                        int biggest119294 = 0;
                        if(ends[6]>=biggest119294){
                          biggest119294=ends[6];
                        }
                        if(ends[7]>=biggest119294){
                          biggest119294=ends[7];
                        }
                        if(biggest119294 == 1){
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
                    S103583=4;
                    if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                      S103583=5;
                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                        S103583=6;
                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                          S103583=7;
                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 240, column: 37
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 241, column: 21
                              S103583=8;
                              S103879=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                S103879=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S103874=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                  S103874=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                    S106084=2;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S103583=8;
                            S103879=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                              S103879=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S103874=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                S103874=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                  S106084=2;
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
                    thread119295(tdone,ends);
                    thread119296(tdone,ends);
                    int biggest119297 = 0;
                    if(ends[6]>=biggest119297){
                      biggest119297=ends[6];
                    }
                    if(ends[7]>=biggest119297){
                      biggest119297=ends[7];
                    }
                    if(biggest119297 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest119297 == 0){
                      S103583=4;
                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                        S103583=5;
                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                          S103583=6;
                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                            S103583=7;
                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 240, column: 37
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 241, column: 21
                                S103583=8;
                                S103879=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                  S103879=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S103874=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                    S103874=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                      S106084=2;
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
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S103583=8;
                              S103879=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                S103879=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S103874=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                  S103874=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                    S106084=2;
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
                    S103583=5;
                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                      S103583=6;
                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                        S103583=7;
                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 240, column: 37
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 241, column: 21
                            S103583=8;
                            S103879=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                              S103879=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S103874=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                S103874=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                  S106084=2;
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
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          S103583=8;
                          S103879=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                            S103879=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S103874=0;
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                              S103874=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                S106084=2;
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
                    S103583=6;
                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                      S103583=7;
                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                        if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 240, column: 37
                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 241, column: 21
                          S103583=8;
                          S103879=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                            S103879=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S103874=0;
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                              S103874=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                S106084=2;
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
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S103583=8;
                        S103879=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                          S103879=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S103874=0;
                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                            S103874=1;
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 247, column: 5
                              S106084=2;
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
                    S103583=7;
                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 240, column: 37
                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 241, column: 21
                        S103583=8;
                        S103879=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                          S103879=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S103874=0;
                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                            S103874=1;
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 247, column: 5
                              S106084=2;
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
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      S103583=8;
                      S103879=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                        S103879=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S103874=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                          S103874=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 247, column: 5
                            S106084=2;
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
                  if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 240, column: 37
                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 241, column: 21
                    S103583=8;
                    S103879=0;
                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                      S103879=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      S103874=0;
                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                        S103874=1;
                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                          ends[3]=2;
                          ;//sysj\lidRemovalController.sysj line: 247, column: 5
                          S106084=2;
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
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 8 : 
                  switch(S103879){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                        S103879=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S103874){
                          case 0 : 
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                              S103874=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                S106084=2;
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
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 247, column: 5
                              S106084=2;
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
                      S103879=1;
                      S103879=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                        S103879=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S103874=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                          S103874=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 247, column: 5
                            S106084=2;
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
                
              }
            }
            break;
          
          case 2 : 
            S106084=2;
            S106084=0;
            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 143, column: 20
              S106084=1;
              if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 147, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S106084=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S103583=0;
                S103567=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 149, column: 5
                  enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                  S103567=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S103562=0;
                  if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                    enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 149, column: 5
                    S103562=1;
                    if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
                      enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
                      ends[3]=2;
                      ;//sysj\lidRemovalController.sysj line: 149, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 151, column: 5
                      System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 153, column: 5
                      S103583=1;
                      if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 159, column: 21
                        S103583=2;
                        if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 169, column: 21
                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                          S103583=3;
                          if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                            S103583=4;
                            if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                              S103583=5;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                                S103583=6;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                                  S103583=7;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 240, column: 37
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 241, column: 21
                                      S103583=8;
                                      S103879=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                        S103879=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S103874=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                          S103874=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                            S106084=2;
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
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                  else {
                                    S103583=8;
                                    S103879=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                      S103879=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S103874=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                        S103874=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                          S106084=2;
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
                            thread119298(tdone,ends);
                            thread119299(tdone,ends);
                            int biggest119300 = 0;
                            if(ends[6]>=biggest119300){
                              biggest119300=ends[6];
                            }
                            if(ends[7]>=biggest119300){
                              biggest119300=ends[7];
                            }
                            if(biggest119300 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread119301(tdone,ends);
                          thread119302(tdone,ends);
                          int biggest119303 = 0;
                          if(ends[4]>=biggest119303){
                            biggest119303=ends[4];
                          }
                          if(ends[5]>=biggest119303){
                            biggest119303=ends[5];
                          }
                          if(biggest119303 == 1){
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

  public void thread119254(int [] tdone, int [] ends){
        switch(S103558){
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

  public void thread119252(int [] tdone, int [] ends){
        S119240=1;
    S118886=0;
    if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 263, column: 20
      S118886=1;
      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 265, column: 20
        S118886=2;
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
      }
      else {
        if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 269, column: 14
          cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 269, column: 32
          currsigs.addElement(cylZaxisExtend);
          if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
            unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 35
            currsigs.addElement(unscrewTurnExtend);
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
          if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 271, column: 14
            unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 271, column: 35
            currsigs.addElement(unscrewTurnExtend);
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 273, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 273, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 275, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 275, column: 32
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

  public void thread119250(int [] tdone, int [] ends){
        S103609=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread119249(int [] tdone, int [] ends){
        S103604=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 171, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread119247(int [] tdone, int [] ends){
        S103664=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread119246(int [] tdone, int [] ends){
        S103659=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 183, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread119245(int [] tdone, int [] ends){
        S118710=1;
    OK_thread_3 = 0;//sysj\lidRemovalController.sysj line: 129, column: 3
    BLOCKED_thread_3 = 2;//sysj\lidRemovalController.sysj line: 131, column: 3
    w_thread_3 = null;//sysj\lidRemovalController.sysj line: 135, column: 3
    code_thread_3 = 0;//sysj\lidRemovalController.sysj line: 137, column: 3
    S106084=0;
    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 143, column: 20
      S106084=1;
      if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 147, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S106084=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S103583=0;
        S103567=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 149, column: 5
          enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
          S103567=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S103562=0;
          if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
            enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 149, column: 5
            S103562=1;
            if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 149, column: 5
              enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 149, column: 5
              ends[3]=2;
              ;//sysj\lidRemovalController.sysj line: 149, column: 5
              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 151, column: 5
              System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 153, column: 5
              S103583=1;
              if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 159, column: 21
                S103583=2;
                if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 169, column: 21
                  System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 175, column: 5
                  S103583=3;
                  if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 181, column: 21
                    S103583=4;
                    if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 195, column: 21
                      S103583=5;
                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 201, column: 21
                        S103583=6;
                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 211, column: 21
                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 223, column: 5
                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 225, column: 5
                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 231, column: 5
                          S103583=7;
                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 233, column: 13
                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 235, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 237, column: 6
                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 240, column: 37
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 241, column: 21
                              S103583=8;
                              S103879=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                S103879=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S103874=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                  S103874=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                    S106084=2;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            S103583=8;
                            S103879=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 247, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                              S103879=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S103874=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 247, column: 5
                                S103874=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 247, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 247, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 247, column: 5
                                  S106084=2;
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
                    thread119246(tdone,ends);
                    thread119247(tdone,ends);
                    int biggest119248 = 0;
                    if(ends[6]>=biggest119248){
                      biggest119248=ends[6];
                    }
                    if(ends[7]>=biggest119248){
                      biggest119248=ends[7];
                    }
                    if(biggest119248 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  thread119249(tdone,ends);
                  thread119250(tdone,ends);
                  int biggest119251 = 0;
                  if(ends[4]>=biggest119251){
                    biggest119251=ends[4];
                  }
                  if(ends[5]>=biggest119251){
                    biggest119251=ends[5];
                  }
                  if(biggest119251 == 1){
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

  public void thread119244(int [] tdone, int [] ends){
        S103558=1;
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
      switch(S119242){
        case 0 : 
          S119242=0;
          break RUN;
        
        case 1 : 
          S119242=2;
          S119242=2;
          auto_1.setClear();//sysj\lidRemovalController.sysj line: 103, column: 2
          manual_1.setClear();//sysj\lidRemovalController.sysj line: 103, column: 2
          thread119244(tdone,ends);
          thread119245(tdone,ends);
          thread119252(tdone,ends);
          int biggest119253 = 0;
          if(ends[2]>=biggest119253){
            biggest119253=ends[2];
          }
          if(ends[3]>=biggest119253){
            biggest119253=ends[3];
          }
          if(ends[8]>=biggest119253){
            biggest119253=ends[8];
          }
          if(biggest119253 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidRemovalController.sysj line: 103, column: 2
          manual_1.setClear();//sysj\lidRemovalController.sysj line: 103, column: 2
          thread119254(tdone,ends);
          thread119255(tdone,ends);
          thread119304(tdone,ends);
          int biggest119305 = 0;
          if(ends[2]>=biggest119305){
            biggest119305=ends[2];
          }
          if(ends[3]>=biggest119305){
            biggest119305=ends[3];
          }
          if(ends[8]>=biggest119305){
            biggest119305=ends[8];
          }
          if(biggest119305 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest119305 == 0){
            S119242=0;
            active[1]=0;
            ends[1]=0;
            S119242=0;
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
