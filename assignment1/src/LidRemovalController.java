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
  private int OK_thread_3;//sysj\lidRemovalController.sysj line: 65, column: 3
  private int BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 66, column: 3
  private WorkpieceTwin w_thread_3;//sysj\lidRemovalController.sysj line: 68, column: 3
  private int code_thread_3;//sysj\lidRemovalController.sysj line: 69, column: 3
  private int S137569 = 1;
  private int S110563 = 1;
  private int S137037 = 1;
  private int S114976 = 1;
  private int S110588 = 1;
  private int S110572 = 1;
  private int S110567 = 1;
  private int S110597 = 1;
  private int S110602 = 1;
  private int S110607 = 1;
  private int S110635 = 1;
  private int S110640 = 1;
  private int S111447 = 1;
  private int S111442 = 1;
  private int S137567 = 1;
  private int S137213 = 1;
  
  private int[] ends = new int[9];
  private int[] tdone = new int[9];
  
  public void thread137631(int [] tdone, int [] ends){
        switch(S137567){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S137213){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 144, column: 20
              S137213=1;
              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 145, column: 20
                S137213=2;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 147, column: 14
                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 147, column: 32
                  currsigs.addElement(cylZaxisExtend);
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 148, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 148, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 148, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 148, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 145, column: 20
              S137213=2;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 147, column: 14
                cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 147, column: 32
                currsigs.addElement(cylZaxisExtend);
                if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 148, column: 14
                  unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 148, column: 35
                  currsigs.addElement(unscrewTurnExtend);
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 148, column: 14
                  unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 148, column: 35
                  currsigs.addElement(unscrewTurnExtend);
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
            S137213=2;
            S137213=0;
            if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 144, column: 20
              S137213=1;
              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 145, column: 20
                S137213=2;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 147, column: 14
                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 147, column: 32
                  currsigs.addElement(cylZaxisExtend);
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 148, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 148, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 148, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 148, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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

  public void thread137629(int [] tdone, int [] ends){
        S110607=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread137628(int [] tdone, int [] ends){
        S110602=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread137626(int [] tdone, int [] ends){
        S110640=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137625(int [] tdone, int [] ends){
        S110635=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137623(int [] tdone, int [] ends){
        switch(S110640){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
        currsigs.addElement(unscrewTurnExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread137622(int [] tdone, int [] ends){
        switch(S110635){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
        currsigs.addElement(cylZaxisExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread137620(int [] tdone, int [] ends){
        S110640=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137619(int [] tdone, int [] ends){
        S110635=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137617(int [] tdone, int [] ends){
        switch(S110607){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 40
        currsigs.addElement(lidGripperExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread137616(int [] tdone, int [] ends){
        switch(S110602){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 9
        currsigs.addElement(cylZaxisExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread137614(int [] tdone, int [] ends){
        S110640=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137613(int [] tdone, int [] ends){
        S110635=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137611(int [] tdone, int [] ends){
        S110607=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread137610(int [] tdone, int [] ends){
        S110602=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread137608(int [] tdone, int [] ends){
        S110640=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137607(int [] tdone, int [] ends){
        S110635=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137605(int [] tdone, int [] ends){
        S110607=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread137604(int [] tdone, int [] ends){
        S110602=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread137602(int [] tdone, int [] ends){
        S110640=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137601(int [] tdone, int [] ends){
        S110635=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137599(int [] tdone, int [] ends){
        S110607=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread137598(int [] tdone, int [] ends){
        S110602=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread137596(int [] tdone, int [] ends){
        S110640=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137595(int [] tdone, int [] ends){
        S110635=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137593(int [] tdone, int [] ends){
        S110607=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread137592(int [] tdone, int [] ends){
        S110602=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread137590(int [] tdone, int [] ends){
        S110640=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137589(int [] tdone, int [] ends){
        S110635=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137587(int [] tdone, int [] ends){
        S110607=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread137586(int [] tdone, int [] ends){
        S110602=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread137584(int [] tdone, int [] ends){
        S110640=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137583(int [] tdone, int [] ends){
        S110635=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137582(int [] tdone, int [] ends){
        switch(S137037){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S114976){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 72, column: 20
              S114976=1;
              if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 74, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S114976=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S110588=0;
                S110572=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 75, column: 5
                  enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                  S110572=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S110567=0;
                  if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                    enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 75, column: 5
                    S110567=1;
                    if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                      enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                      ends[3]=2;
                      ;//sysj\lidRemovalController.sysj line: 75, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 84, column: 5
                      S110588=1;
                      if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 86, column: 8
                        System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 87, column: 6
                        S110597=0;
                        if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 90, column: 22
                          S110597=1;
                          if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                            System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 98, column: 6
                            S110597=2;
                            if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 22
                              S110597=3;
                              if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 22
                                S110597=4;
                                if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 111, column: 22
                                  S110597=5;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                    S110597=6;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                        S110588=2;
                                        S111447=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111447=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S111442=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111442=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S114976=2;
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
                                      S110588=2;
                                      S111447=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111447=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111442=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111442=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114976=2;
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
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                    currsigs.addElement(lidEjectExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 112, column: 7
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
                              thread137583(tdone,ends);
                              thread137584(tdone,ends);
                              int biggest137585 = 0;
                              if(ends[6]>=biggest137585){
                                biggest137585=ends[6];
                              }
                              if(ends[7]>=biggest137585){
                                biggest137585=ends[7];
                              }
                              if(biggest137585 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread137586(tdone,ends);
                            thread137587(tdone,ends);
                            int biggest137588 = 0;
                            if(ends[4]>=biggest137588){
                              biggest137588=ends[4];
                            }
                            if(ends[5]>=biggest137588){
                              biggest137588=ends[5];
                            }
                            if(biggest137588 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 91, column: 7
                          currsigs.addElement(cylZaxisExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S110588=2;
                        S111447=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                          S111447=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S111442=0;
                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                            S111442=1;
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                              S114976=2;
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
            if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 74, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S114976=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S110588){
                case 0 : 
                  switch(S110572){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 75, column: 5
                        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                        S110572=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S110567){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                              enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 75, column: 5
                              S110567=1;
                              if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                                enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 75, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 84, column: 5
                                S110588=1;
                                if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 86, column: 8
                                  System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 87, column: 6
                                  S110597=0;
                                  if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 90, column: 22
                                    S110597=1;
                                    if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 98, column: 6
                                      S110597=2;
                                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 22
                                        S110597=3;
                                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 22
                                          S110597=4;
                                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 111, column: 22
                                            S110597=5;
                                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                              S110597=6;
                                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                                if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                  S110588=2;
                                                  S111447=0;
                                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111447=1;
                                                    active[3]=1;
                                                    ends[3]=1;
                                                    tdone[3]=1;
                                                  }
                                                  else {
                                                    S111442=0;
                                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S111442=1;
                                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        ends[3]=2;
                                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                        S114976=2;
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
                                                S110588=2;
                                                S111447=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111447=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S111442=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111442=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S114976=2;
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
                                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                              currsigs.addElement(lidEjectExtend);
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                          }
                                          else {
                                            unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 112, column: 7
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
                                        thread137589(tdone,ends);
                                        thread137590(tdone,ends);
                                        int biggest137591 = 0;
                                        if(ends[6]>=biggest137591){
                                          biggest137591=ends[6];
                                        }
                                        if(ends[7]>=biggest137591){
                                          biggest137591=ends[7];
                                        }
                                        if(biggest137591 == 1){
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                    }
                                    else {
                                      thread137592(tdone,ends);
                                      thread137593(tdone,ends);
                                      int biggest137594 = 0;
                                      if(ends[4]>=biggest137594){
                                        biggest137594=ends[4];
                                      }
                                      if(ends[5]>=biggest137594){
                                        biggest137594=ends[5];
                                      }
                                      if(biggest137594 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 91, column: 7
                                    currsigs.addElement(cylZaxisExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  S110588=2;
                                  S111447=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111447=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S111442=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111442=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S114976=2;
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
                            if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                              enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 75, column: 5
                              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 84, column: 5
                              S110588=1;
                              if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 86, column: 8
                                System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 87, column: 6
                                S110597=0;
                                if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 90, column: 22
                                  S110597=1;
                                  if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                                    System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 98, column: 6
                                    S110597=2;
                                    if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 22
                                      S110597=3;
                                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 22
                                        S110597=4;
                                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 111, column: 22
                                          S110597=5;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                            S110597=6;
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                                S110588=2;
                                                S111447=0;
                                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111447=1;
                                                  active[3]=1;
                                                  ends[3]=1;
                                                  tdone[3]=1;
                                                }
                                                else {
                                                  S111442=0;
                                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S111442=1;
                                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      ends[3]=2;
                                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                      S114976=2;
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
                                              S110588=2;
                                              S111447=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111447=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111442=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111442=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114976=2;
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
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 112, column: 7
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
                                      thread137595(tdone,ends);
                                      thread137596(tdone,ends);
                                      int biggest137597 = 0;
                                      if(ends[6]>=biggest137597){
                                        biggest137597=ends[6];
                                      }
                                      if(ends[7]>=biggest137597){
                                        biggest137597=ends[7];
                                      }
                                      if(biggest137597 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread137598(tdone,ends);
                                    thread137599(tdone,ends);
                                    int biggest137600 = 0;
                                    if(ends[4]>=biggest137600){
                                      biggest137600=ends[4];
                                    }
                                    if(ends[5]>=biggest137600){
                                      biggest137600=ends[5];
                                    }
                                    if(biggest137600 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 91, column: 7
                                  currsigs.addElement(cylZaxisExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                S110588=2;
                                S111447=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111447=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S111442=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111442=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S114976=2;
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
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            break;
                          
                        }
                      }
                      break;
                    
                    case 1 : 
                      S110572=1;
                      S110572=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 75, column: 5
                        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                        S110572=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S110567=0;
                        if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                          enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 75, column: 5
                          S110567=1;
                          if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                            enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 75, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 84, column: 5
                            S110588=1;
                            if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 86, column: 8
                              System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 87, column: 6
                              S110597=0;
                              if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 90, column: 22
                                S110597=1;
                                if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                                  System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 98, column: 6
                                  S110597=2;
                                  if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 22
                                    S110597=3;
                                    if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 22
                                      S110597=4;
                                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 111, column: 22
                                        S110597=5;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                          S110597=6;
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                              S110588=2;
                                              S111447=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111447=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S111442=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S111442=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                    S114976=2;
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
                                            S110588=2;
                                            S111447=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S111447=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S111442=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                                S111442=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                                  S114976=2;
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
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 112, column: 7
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
                                    thread137601(tdone,ends);
                                    thread137602(tdone,ends);
                                    int biggest137603 = 0;
                                    if(ends[6]>=biggest137603){
                                      biggest137603=ends[6];
                                    }
                                    if(ends[7]>=biggest137603){
                                      biggest137603=ends[7];
                                    }
                                    if(biggest137603 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread137604(tdone,ends);
                                  thread137605(tdone,ends);
                                  int biggest137606 = 0;
                                  if(ends[4]>=biggest137606){
                                    biggest137606=ends[4];
                                  }
                                  if(ends[5]>=biggest137606){
                                    biggest137606=ends[5];
                                  }
                                  if(biggest137606 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 91, column: 7
                                currsigs.addElement(cylZaxisExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              S110588=2;
                              S111447=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                S111447=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S111442=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111442=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S114976=2;
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
                  switch(S110597){
                    case 0 : 
                      if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 90, column: 22
                        S110597=1;
                        if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 98, column: 6
                          S110597=2;
                          if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 22
                            S110597=3;
                            if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 22
                              S110597=4;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 111, column: 22
                                S110597=5;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                  S110597=6;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                      S110588=2;
                                      S111447=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111447=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111442=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111442=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114976=2;
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
                                    S110588=2;
                                    S111447=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111447=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S111442=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111442=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S114976=2;
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
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 112, column: 7
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
                            thread137607(tdone,ends);
                            thread137608(tdone,ends);
                            int biggest137609 = 0;
                            if(ends[6]>=biggest137609){
                              biggest137609=ends[6];
                            }
                            if(ends[7]>=biggest137609){
                              biggest137609=ends[7];
                            }
                            if(biggest137609 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread137610(tdone,ends);
                          thread137611(tdone,ends);
                          int biggest137612 = 0;
                          if(ends[4]>=biggest137612){
                            biggest137612=ends[4];
                          }
                          if(ends[5]>=biggest137612){
                            biggest137612=ends[5];
                          }
                          if(biggest137612 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 91, column: 7
                        currsigs.addElement(cylZaxisExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                        System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 98, column: 6
                        S110597=2;
                        if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 22
                          S110597=3;
                          if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 22
                            S110597=4;
                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 111, column: 22
                              S110597=5;
                              if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                S110597=6;
                                if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                  System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                  if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                    S110588=2;
                                    S111447=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111447=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S111442=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111442=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S114976=2;
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
                                  S110588=2;
                                  S111447=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111447=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S111442=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111442=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S114976=2;
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
                                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                currsigs.addElement(lidEjectExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 112, column: 7
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
                          thread137613(tdone,ends);
                          thread137614(tdone,ends);
                          int biggest137615 = 0;
                          if(ends[6]>=biggest137615){
                            biggest137615=ends[6];
                          }
                          if(ends[7]>=biggest137615){
                            biggest137615=ends[7];
                          }
                          if(biggest137615 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        thread137616(tdone,ends);
                        thread137617(tdone,ends);
                        int biggest137618 = 0;
                        if(ends[4]>=biggest137618){
                          biggest137618=ends[4];
                        }
                        if(ends[5]>=biggest137618){
                          biggest137618=ends[5];
                        }
                        if(biggest137618 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        //FINXME code
                        if(biggest137618 == 0){
                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 98, column: 6
                          S110597=2;
                          if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 22
                            S110597=3;
                            if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 22
                              S110597=4;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 111, column: 22
                                S110597=5;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                  S110597=6;
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                    if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                      S110588=2;
                                      S111447=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111447=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111442=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111442=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114976=2;
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
                                    S110588=2;
                                    S111447=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111447=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S111442=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111442=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S114976=2;
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
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 112, column: 7
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
                            thread137619(tdone,ends);
                            thread137620(tdone,ends);
                            int biggest137621 = 0;
                            if(ends[6]>=biggest137621){
                              biggest137621=ends[6];
                            }
                            if(ends[7]>=biggest137621){
                              biggest137621=ends[7];
                            }
                            if(biggest137621 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                      }
                      break;
                    
                    case 2 : 
                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 22
                        S110597=3;
                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 22
                          S110597=4;
                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 111, column: 22
                            S110597=5;
                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                              S110597=6;
                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                  S110588=2;
                                  S111447=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111447=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S111442=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111442=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S114976=2;
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
                                S110588=2;
                                S111447=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111447=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S111442=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111442=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S114976=2;
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
                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                              currsigs.addElement(lidEjectExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 112, column: 7
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
                        thread137622(tdone,ends);
                        thread137623(tdone,ends);
                        int biggest137624 = 0;
                        if(ends[6]>=biggest137624){
                          biggest137624=ends[6];
                        }
                        if(ends[7]>=biggest137624){
                          biggest137624=ends[7];
                        }
                        if(biggest137624 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        //FINXME code
                        if(biggest137624 == 0){
                          S110597=3;
                          if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 22
                            S110597=4;
                            if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 111, column: 22
                              S110597=5;
                              if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                S110597=6;
                                if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                  System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                  code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                  if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                    S110588=2;
                                    S111447=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111447=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S111442=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111442=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S114976=2;
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
                                  S110588=2;
                                  S111447=0;
                                  if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111447=1;
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S111442=0;
                                    if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S111442=1;
                                      if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        ends[3]=2;
                                        ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S114976=2;
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
                                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                currsigs.addElement(lidEjectExtend);
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                            else {
                              unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 112, column: 7
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
                    
                    case 3 : 
                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 22
                        S110597=4;
                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 111, column: 22
                          S110597=5;
                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                            S110597=6;
                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                S110588=2;
                                S111447=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111447=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S111442=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111442=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S114976=2;
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
                              S110588=2;
                              S111447=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                S111447=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S111442=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111442=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S114976=2;
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
                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                            currsigs.addElement(lidEjectExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 112, column: 7
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
                    
                    case 4 : 
                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 111, column: 22
                        S110597=5;
                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                          S110597=6;
                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                            if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                              S110588=2;
                              S111447=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                S111447=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S111442=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111442=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S114976=2;
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
                            S110588=2;
                            S111447=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                              S111447=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S111442=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                S111442=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S114976=2;
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
                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                          currsigs.addElement(lidEjectExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 112, column: 7
                        currsigs.addElement(unscrewTurnRetract);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 5 : 
                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                        S110597=6;
                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                          if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                            S110588=2;
                            S111447=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                              S111447=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S111442=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                S111442=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S114976=2;
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
                          S110588=2;
                          S111447=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                            S111447=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S111442=0;
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                              S111442=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                S114976=2;
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
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                        currsigs.addElement(lidEjectExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 6 : 
                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                        S110588=2;
                        S111447=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                          S111447=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S111442=0;
                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                            S111442=1;
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                              S114976=2;
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
                    
                  }
                  break;
                
                case 2 : 
                  switch(S111447){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                        S111447=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S111442){
                          case 0 : 
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                              S111442=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                S114976=2;
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
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                              S114976=2;
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
                      S111447=1;
                      S111447=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                        S111447=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S111442=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                          S111442=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                            S114976=2;
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
            S114976=2;
            S114976=0;
            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 72, column: 20
              S114976=1;
              if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 74, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S114976=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S110588=0;
                S110572=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 75, column: 5
                  enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                  S110572=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S110567=0;
                  if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                    enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 75, column: 5
                    S110567=1;
                    if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                      enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                      ends[3]=2;
                      ;//sysj\lidRemovalController.sysj line: 75, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 84, column: 5
                      S110588=1;
                      if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 86, column: 8
                        System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 87, column: 6
                        S110597=0;
                        if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 90, column: 22
                          S110597=1;
                          if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                            System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 98, column: 6
                            S110597=2;
                            if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 22
                              S110597=3;
                              if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 22
                                S110597=4;
                                if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 111, column: 22
                                  S110597=5;
                                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                                    S110597=6;
                                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                                      if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                        S110588=2;
                                        S111447=0;
                                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111447=1;
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                        else {
                                          S111442=0;
                                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S111442=1;
                                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                              ends[3]=2;
                                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                              S114976=2;
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
                                      S110588=2;
                                      S111447=0;
                                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                        S111447=1;
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S111442=0;
                                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                          S111442=1;
                                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                            ends[3]=2;
                                            ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                            S114976=2;
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
                                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                                    currsigs.addElement(lidEjectExtend);
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                                else {
                                  unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 112, column: 7
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
                              thread137625(tdone,ends);
                              thread137626(tdone,ends);
                              int biggest137627 = 0;
                              if(ends[6]>=biggest137627){
                                biggest137627=ends[6];
                              }
                              if(ends[7]>=biggest137627){
                                biggest137627=ends[7];
                              }
                              if(biggest137627 == 1){
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                            }
                          }
                          else {
                            thread137628(tdone,ends);
                            thread137629(tdone,ends);
                            int biggest137630 = 0;
                            if(ends[4]>=biggest137630){
                              biggest137630=ends[4];
                            }
                            if(ends[5]>=biggest137630){
                              biggest137630=ends[5];
                            }
                            if(biggest137630 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 91, column: 7
                          currsigs.addElement(cylZaxisExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        S110588=2;
                        S111447=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                          S111447=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S111442=0;
                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                            S111442=1;
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 136, column: 5
                              S114976=2;
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

  public void thread137581(int [] tdone, int [] ends){
        switch(S110563){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\lidRemovalController.sysj line: 56, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidRemovalController.sysj line: 57, column: 8
            auto_1.setPresent();//sysj\lidRemovalController.sysj line: 57, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            manual_1.setPresent();//sysj\lidRemovalController.sysj line: 58, column: 12
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

  public void thread137579(int [] tdone, int [] ends){
        S137567=1;
    S137213=0;
    if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 144, column: 20
      S137213=1;
      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 145, column: 20
        S137213=2;
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
      }
      else {
        if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 147, column: 14
          cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 147, column: 32
          currsigs.addElement(cylZaxisExtend);
          if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 148, column: 14
            unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 148, column: 35
            currsigs.addElement(unscrewTurnExtend);
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
          if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 148, column: 14
            unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 148, column: 35
            currsigs.addElement(unscrewTurnExtend);
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 149, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 149, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 150, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 150, column: 32
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

  public void thread137577(int [] tdone, int [] ends){
        S110607=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 40
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread137576(int [] tdone, int [] ends){
        S110602=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 96, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread137574(int [] tdone, int [] ends){
        S110640=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 40
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread137573(int [] tdone, int [] ends){
        S110635=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 9
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread137572(int [] tdone, int [] ends){
        S137037=1;
    OK_thread_3 = 0;//sysj\lidRemovalController.sysj line: 65, column: 3
    BLOCKED_thread_3 = 2;//sysj\lidRemovalController.sysj line: 66, column: 3
    w_thread_3 = null;//sysj\lidRemovalController.sysj line: 68, column: 3
    code_thread_3 = 0;//sysj\lidRemovalController.sysj line: 69, column: 3
    S114976=0;
    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 72, column: 20
      S114976=1;
      if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 74, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S114976=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S110588=0;
        S110572=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 75, column: 5
          enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
          S110572=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S110567=0;
          if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
            enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 75, column: 5
            S110567=1;
            if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
              enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
              ends[3]=2;
              ;//sysj\lidRemovalController.sysj line: 75, column: 5
              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 84, column: 5
              S110588=1;
              if(w_thread_3 != null){//sysj\lidRemovalController.sysj line: 86, column: 8
                System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 87, column: 6
                S110597=0;
                if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 90, column: 22
                  S110597=1;
                  if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 95, column: 22
                    System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 98, column: 6
                    S110597=2;
                    if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 22
                      S110597=3;
                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 108, column: 22
                        S110597=4;
                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 111, column: 22
                          S110597=5;
                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 116, column: 22
                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 122, column: 6
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 123, column: 6
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 126, column: 6
                            S110597=6;
                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 127, column: 14
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 128, column: 7
                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 129, column: 7
                              if(!lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 38
                                code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 132, column: 22
                                S110588=2;
                                S111447=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111447=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S111442=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S111442=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                      S114976=2;
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
                              S110588=2;
                              S111447=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                S111447=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S111442=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                                  S111442=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 136, column: 5
                                    S114976=2;
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
                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 117, column: 7
                            currsigs.addElement(lidEjectExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 112, column: 7
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
                      thread137573(tdone,ends);
                      thread137574(tdone,ends);
                      int biggest137575 = 0;
                      if(ends[6]>=biggest137575){
                        biggest137575=ends[6];
                      }
                      if(ends[7]>=biggest137575){
                        biggest137575=ends[7];
                      }
                      if(biggest137575 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread137576(tdone,ends);
                    thread137577(tdone,ends);
                    int biggest137578 = 0;
                    if(ends[4]>=biggest137578){
                      biggest137578=ends[4];
                    }
                    if(ends[5]>=biggest137578){
                      biggest137578=ends[5];
                    }
                    if(biggest137578 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 91, column: 7
                  currsigs.addElement(cylZaxisExtend);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                S110588=2;
                S111447=0;
                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 136, column: 5
                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                  S111447=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S111442=0;
                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 136, column: 5
                    S111442=1;
                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 136, column: 5
                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 136, column: 5
                      ends[3]=2;
                      ;//sysj\lidRemovalController.sysj line: 136, column: 5
                      S114976=2;
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

  public void thread137571(int [] tdone, int [] ends){
        S110563=1;
    if(mode.getprestatus()){//sysj\lidRemovalController.sysj line: 56, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lidRemovalController.sysj line: 57, column: 8
        auto_1.setPresent();//sysj\lidRemovalController.sysj line: 57, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        manual_1.setPresent();//sysj\lidRemovalController.sysj line: 58, column: 12
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
      switch(S137569){
        case 0 : 
          S137569=0;
          break RUN;
        
        case 1 : 
          S137569=2;
          S137569=2;
          auto_1.setClear();//sysj\lidRemovalController.sysj line: 52, column: 2
          manual_1.setClear();//sysj\lidRemovalController.sysj line: 52, column: 2
          thread137571(tdone,ends);
          thread137572(tdone,ends);
          thread137579(tdone,ends);
          int biggest137580 = 0;
          if(ends[2]>=biggest137580){
            biggest137580=ends[2];
          }
          if(ends[3]>=biggest137580){
            biggest137580=ends[3];
          }
          if(ends[8]>=biggest137580){
            biggest137580=ends[8];
          }
          if(biggest137580 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidRemovalController.sysj line: 52, column: 2
          manual_1.setClear();//sysj\lidRemovalController.sysj line: 52, column: 2
          thread137581(tdone,ends);
          thread137582(tdone,ends);
          thread137631(tdone,ends);
          int biggest137632 = 0;
          if(ends[2]>=biggest137632){
            biggest137632=ends[2];
          }
          if(ends[3]>=biggest137632){
            biggest137632=ends[3];
          }
          if(ends[8]>=biggest137632){
            biggest137632=ends[8];
          }
          if(biggest137632 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest137632 == 0){
            S137569=0;
            active[1]=0;
            ends[1]=0;
            S137569=0;
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
