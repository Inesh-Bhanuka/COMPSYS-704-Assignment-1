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
  private Workpiece w_thread_3;//sysj\lidRemovalController.sysj line: 68, column: 3
  private int code_thread_3;//sysj\lidRemovalController.sysj line: 69, column: 3
  private int S63300 = 1;
  private int S48444 = 1;
  private int S62768 = 1;
  private int S50832 = 1;
  private int S48469 = 1;
  private int S48453 = 1;
  private int S48448 = 1;
  private int S48490 = 1;
  private int S48495 = 1;
  private int S48545 = 1;
  private int S48550 = 1;
  private int S48741 = 1;
  private int S48736 = 1;
  private int S63298 = 1;
  private int S62944 = 1;
  
  private int[] ends = new int[9];
  private int[] tdone = new int[9];
  
  public void thread63362(int [] tdone, int [] ends){
        switch(S63298){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S62944){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 130, column: 20
              S62944=1;
              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 20
                S62944=2;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 133, column: 14
                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 133, column: 32
                  currsigs.addElement(cylZaxisExtend);
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 134, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 134, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 134, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 134, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 20
              S62944=2;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 133, column: 14
                cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 133, column: 32
                currsigs.addElement(cylZaxisExtend);
                if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 134, column: 14
                  unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 134, column: 35
                  currsigs.addElement(unscrewTurnExtend);
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 134, column: 14
                  unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 134, column: 35
                  currsigs.addElement(unscrewTurnExtend);
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                  if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
                    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
                    currsigs.addElement(lidGripperExtend);
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                    if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
            S62944=2;
            S62944=0;
            if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 130, column: 20
              S62944=1;
              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 20
                S62944=2;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 133, column: 14
                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 133, column: 32
                  currsigs.addElement(cylZaxisExtend);
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 134, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 134, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                  if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 134, column: 14
                    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 134, column: 35
                    currsigs.addElement(unscrewTurnExtend);
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                    if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
                      lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
                      currsigs.addElement(lidGripperExtend);
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
                      if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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

  public void thread63360(int [] tdone, int [] ends){
        S48495=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread63359(int [] tdone, int [] ends){
        S48490=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread63357(int [] tdone, int [] ends){
        S48550=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread63356(int [] tdone, int [] ends){
        S48545=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread63354(int [] tdone, int [] ends){
        switch(S48550){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
        currsigs.addElement(unscrewTurnExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread63353(int [] tdone, int [] ends){
        switch(S48545){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
        currsigs.addElement(cylZaxisExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread63351(int [] tdone, int [] ends){
        S48550=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread63350(int [] tdone, int [] ends){
        S48545=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread63348(int [] tdone, int [] ends){
        switch(S48495){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 39
        currsigs.addElement(lidGripperExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread63347(int [] tdone, int [] ends){
        switch(S48490){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 8
        currsigs.addElement(cylZaxisExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread63345(int [] tdone, int [] ends){
        S48550=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread63344(int [] tdone, int [] ends){
        S48545=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread63342(int [] tdone, int [] ends){
        S48495=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread63341(int [] tdone, int [] ends){
        S48490=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread63339(int [] tdone, int [] ends){
        S48550=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread63338(int [] tdone, int [] ends){
        S48545=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread63336(int [] tdone, int [] ends){
        S48495=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread63335(int [] tdone, int [] ends){
        S48490=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread63333(int [] tdone, int [] ends){
        S48550=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread63332(int [] tdone, int [] ends){
        S48545=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread63330(int [] tdone, int [] ends){
        S48495=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread63329(int [] tdone, int [] ends){
        S48490=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread63327(int [] tdone, int [] ends){
        S48550=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread63326(int [] tdone, int [] ends){
        S48545=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread63324(int [] tdone, int [] ends){
        S48495=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread63323(int [] tdone, int [] ends){
        S48490=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread63321(int [] tdone, int [] ends){
        S48550=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread63320(int [] tdone, int [] ends){
        S48545=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread63318(int [] tdone, int [] ends){
        S48495=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread63317(int [] tdone, int [] ends){
        S48490=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread63315(int [] tdone, int [] ends){
        S48550=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread63314(int [] tdone, int [] ends){
        S48545=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread63313(int [] tdone, int [] ends){
        switch(S62768){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S50832){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 72, column: 20
              S50832=1;
              if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 74, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S50832=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S48469=0;
                S48453=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 75, column: 5
                  enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                  S48453=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S48448=0;
                  if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                    enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 75, column: 5
                    S48448=1;
                    if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                      enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                      ends[3]=2;
                      ;//sysj\lidRemovalController.sysj line: 75, column: 5
                      w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
                      System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 77, column: 5
                      S48469=1;
                      if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 80, column: 21
                        S48469=2;
                        if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 21
                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                          S48469=3;
                          if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                            S48469=4;
                            if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                              S48469=5;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                                S48469=6;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                                    S48469=7;
                                    S48741=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S48741=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S48736=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                        S48736=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                          S50832=2;
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
                                    S48469=7;
                                    S48741=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S48741=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S48736=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                        S48736=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                          S50832=2;
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
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 107, column: 6
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 6
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
                            thread63314(tdone,ends);
                            thread63315(tdone,ends);
                            int biggest63316 = 0;
                            if(ends[6]>=biggest63316){
                              biggest63316=ends[6];
                            }
                            if(ends[7]>=biggest63316){
                              biggest63316=ends[7];
                            }
                            if(biggest63316 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread63317(tdone,ends);
                          thread63318(tdone,ends);
                          int biggest63319 = 0;
                          if(ends[4]>=biggest63319){
                            biggest63319=ends[4];
                          }
                          if(ends[5]>=biggest63319){
                            biggest63319=ends[5];
                          }
                          if(biggest63319 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 81, column: 6
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
            if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 74, column: 20
              enable_in.setPreempted();
              status_o.setPreempted();
              S50832=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S48469){
                case 0 : 
                  switch(S48453){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 75, column: 5
                        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                        S48453=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S48448){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                              enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 75, column: 5
                              S48448=1;
                              if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                                enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 75, column: 5
                                w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
                                System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 77, column: 5
                                S48469=1;
                                if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 80, column: 21
                                  S48469=2;
                                  if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 21
                                    System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                                    S48469=3;
                                    if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                                      S48469=4;
                                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                                        S48469=5;
                                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                                          S48469=6;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                                              S48469=7;
                                              S48741=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                S48741=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S48736=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  S48736=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                                    S50832=2;
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
                                              S48469=7;
                                              S48741=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                S48741=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S48736=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  S48736=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                                    S50832=2;
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
                                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 107, column: 6
                                            currsigs.addElement(lidEjectExtend);
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                        }
                                        else {
                                          unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 6
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
                                      thread63320(tdone,ends);
                                      thread63321(tdone,ends);
                                      int biggest63322 = 0;
                                      if(ends[6]>=biggest63322){
                                        biggest63322=ends[6];
                                      }
                                      if(ends[7]>=biggest63322){
                                        biggest63322=ends[7];
                                      }
                                      if(biggest63322 == 1){
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                  }
                                  else {
                                    thread63323(tdone,ends);
                                    thread63324(tdone,ends);
                                    int biggest63325 = 0;
                                    if(ends[4]>=biggest63325){
                                      biggest63325=ends[4];
                                    }
                                    if(ends[5]>=biggest63325){
                                      biggest63325=ends[5];
                                    }
                                    if(biggest63325 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 81, column: 6
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
                            if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                              enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 75, column: 5
                              w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
                              System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 77, column: 5
                              S48469=1;
                              if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 80, column: 21
                                S48469=2;
                                if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 21
                                  System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                                  S48469=3;
                                  if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                                    S48469=4;
                                    if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                                      S48469=5;
                                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                                        S48469=6;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                                            S48469=7;
                                            S48741=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                              S48741=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S48736=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                                S48736=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  S50832=2;
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
                                            S48469=7;
                                            S48741=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                              S48741=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S48736=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                                S48736=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  S50832=2;
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
                                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 107, column: 6
                                          currsigs.addElement(lidEjectExtend);
                                          active[3]=1;
                                          ends[3]=1;
                                          tdone[3]=1;
                                        }
                                      }
                                      else {
                                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 6
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
                                    thread63326(tdone,ends);
                                    thread63327(tdone,ends);
                                    int biggest63328 = 0;
                                    if(ends[6]>=biggest63328){
                                      biggest63328=ends[6];
                                    }
                                    if(ends[7]>=biggest63328){
                                      biggest63328=ends[7];
                                    }
                                    if(biggest63328 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread63329(tdone,ends);
                                  thread63330(tdone,ends);
                                  int biggest63331 = 0;
                                  if(ends[4]>=biggest63331){
                                    biggest63331=ends[4];
                                  }
                                  if(ends[5]>=biggest63331){
                                    biggest63331=ends[5];
                                  }
                                  if(biggest63331 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 81, column: 6
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
                      S48453=1;
                      S48453=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 75, column: 5
                        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                        S48453=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S48448=0;
                        if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                          enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 75, column: 5
                          S48448=1;
                          if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                            enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 75, column: 5
                            w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
                            System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 77, column: 5
                            S48469=1;
                            if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 80, column: 21
                              S48469=2;
                              if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 21
                                System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                                S48469=3;
                                if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                                  S48469=4;
                                  if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                                    S48469=5;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                                      S48469=6;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                                          S48469=7;
                                          S48741=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                            S48741=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S48736=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                              S48736=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                                S50832=2;
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
                                          S48469=7;
                                          S48741=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                            S48741=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S48736=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                              S48736=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                                S50832=2;
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
                                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 107, column: 6
                                        currsigs.addElement(lidEjectExtend);
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                    }
                                    else {
                                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 6
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
                                  thread63332(tdone,ends);
                                  thread63333(tdone,ends);
                                  int biggest63334 = 0;
                                  if(ends[6]>=biggest63334){
                                    biggest63334=ends[6];
                                  }
                                  if(ends[7]>=biggest63334){
                                    biggest63334=ends[7];
                                  }
                                  if(biggest63334 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                thread63335(tdone,ends);
                                thread63336(tdone,ends);
                                int biggest63337 = 0;
                                if(ends[4]>=biggest63337){
                                  biggest63337=ends[4];
                                }
                                if(ends[5]>=biggest63337){
                                  biggest63337=ends[5];
                                }
                                if(biggest63337 == 1){
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                            }
                            else {
                              cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 81, column: 6
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
                  if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 80, column: 21
                    S48469=2;
                    if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 21
                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                      S48469=3;
                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                        S48469=4;
                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                          S48469=5;
                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                            S48469=6;
                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                                S48469=7;
                                S48741=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S48741=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S48736=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S48736=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S50832=2;
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
                                S48469=7;
                                S48741=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S48741=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S48736=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S48736=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S50832=2;
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
                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 107, column: 6
                              currsigs.addElement(lidEjectExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 6
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
                        thread63338(tdone,ends);
                        thread63339(tdone,ends);
                        int biggest63340 = 0;
                        if(ends[6]>=biggest63340){
                          biggest63340=ends[6];
                        }
                        if(ends[7]>=biggest63340){
                          biggest63340=ends[7];
                        }
                        if(biggest63340 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      thread63341(tdone,ends);
                      thread63342(tdone,ends);
                      int biggest63343 = 0;
                      if(ends[4]>=biggest63343){
                        biggest63343=ends[4];
                      }
                      if(ends[5]>=biggest63343){
                        biggest63343=ends[5];
                      }
                      if(biggest63343 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 81, column: 6
                    currsigs.addElement(cylZaxisExtend);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 2 : 
                  if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 21
                    System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                    S48469=3;
                    if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                      S48469=4;
                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                        S48469=5;
                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                          S48469=6;
                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                              S48469=7;
                              S48741=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                S48741=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S48736=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S48736=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S50832=2;
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
                              S48469=7;
                              S48741=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                S48741=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S48736=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S48736=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S50832=2;
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
                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 107, column: 6
                            currsigs.addElement(lidEjectExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 6
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
                      thread63344(tdone,ends);
                      thread63345(tdone,ends);
                      int biggest63346 = 0;
                      if(ends[6]>=biggest63346){
                        biggest63346=ends[6];
                      }
                      if(ends[7]>=biggest63346){
                        biggest63346=ends[7];
                      }
                      if(biggest63346 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread63347(tdone,ends);
                    thread63348(tdone,ends);
                    int biggest63349 = 0;
                    if(ends[4]>=biggest63349){
                      biggest63349=ends[4];
                    }
                    if(ends[5]>=biggest63349){
                      biggest63349=ends[5];
                    }
                    if(biggest63349 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest63349 == 0){
                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                      S48469=3;
                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                        S48469=4;
                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                          S48469=5;
                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                            S48469=6;
                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                                S48469=7;
                                S48741=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S48741=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S48736=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S48736=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S50832=2;
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
                                S48469=7;
                                S48741=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S48741=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S48736=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S48736=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S50832=2;
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
                              lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 107, column: 6
                              currsigs.addElement(lidEjectExtend);
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                          else {
                            unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 6
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
                        thread63350(tdone,ends);
                        thread63351(tdone,ends);
                        int biggest63352 = 0;
                        if(ends[6]>=biggest63352){
                          biggest63352=ends[6];
                        }
                        if(ends[7]>=biggest63352){
                          biggest63352=ends[7];
                        }
                        if(biggest63352 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                  }
                  break;
                
                case 3 : 
                  if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                    S48469=4;
                    if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                      S48469=5;
                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                        S48469=6;
                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                            S48469=7;
                            S48741=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                              S48741=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S48736=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                S48736=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S50832=2;
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
                            S48469=7;
                            S48741=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                              S48741=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S48736=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                S48736=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S50832=2;
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
                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 107, column: 6
                          currsigs.addElement(lidEjectExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 6
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
                    thread63353(tdone,ends);
                    thread63354(tdone,ends);
                    int biggest63355 = 0;
                    if(ends[6]>=biggest63355){
                      biggest63355=ends[6];
                    }
                    if(ends[7]>=biggest63355){
                      biggest63355=ends[7];
                    }
                    if(biggest63355 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest63355 == 0){
                      S48469=4;
                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                        S48469=5;
                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                          S48469=6;
                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                              S48469=7;
                              S48741=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                S48741=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S48736=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S48736=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S50832=2;
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
                              S48469=7;
                              S48741=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                S48741=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S48736=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S48736=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S50832=2;
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
                            lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 107, column: 6
                            currsigs.addElement(lidEjectExtend);
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                        else {
                          unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 6
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
                  if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                    S48469=5;
                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                      S48469=6;
                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                          S48469=7;
                          S48741=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                            S48741=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S48736=0;
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                              S48736=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                S50832=2;
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
                          S48469=7;
                          S48741=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                            S48741=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S48736=0;
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                              S48736=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                S50832=2;
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
                        lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 107, column: 6
                        currsigs.addElement(lidEjectExtend);
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                    else {
                      unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 6
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
                  if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                    S48469=6;
                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                        S48469=7;
                        S48741=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                          S48741=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S48736=0;
                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                            S48736=1;
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 122, column: 5
                              S50832=2;
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
                        S48469=7;
                        S48741=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                          S48741=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S48736=0;
                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                            S48736=1;
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 122, column: 5
                              S50832=2;
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
                      lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 107, column: 6
                      currsigs.addElement(lidEjectExtend);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                  else {
                    unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 6
                    currsigs.addElement(unscrewTurnRetract);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 6 : 
                  if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                    w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                    System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                    code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                    if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                      System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                      code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                      S48469=7;
                      S48741=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                        S48741=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S48736=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                          S48736=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 122, column: 5
                            S50832=2;
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
                      S48469=7;
                      S48741=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                        S48741=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S48736=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                          S48736=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 122, column: 5
                            S50832=2;
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
                    lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 107, column: 6
                    currsigs.addElement(lidEjectExtend);
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  break;
                
                case 7 : 
                  switch(S48741){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                        S48741=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S48736){
                          case 0 : 
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                              S48736=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                S50832=2;
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
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 122, column: 5
                              S50832=2;
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
                      S48741=1;
                      S48741=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                        S48741=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S48736=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                          S48736=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 122, column: 5
                            S50832=2;
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
                  S50832=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S50832=2;
            S50832=0;
            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 72, column: 20
              S50832=1;
              if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 74, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S50832=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S48469=0;
                S48453=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 75, column: 5
                  enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                  S48453=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S48448=0;
                  if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                    enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 75, column: 5
                    S48448=1;
                    if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                      enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                      ends[3]=2;
                      ;//sysj\lidRemovalController.sysj line: 75, column: 5
                      w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
                      System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 77, column: 5
                      S48469=1;
                      if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 80, column: 21
                        S48469=2;
                        if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 21
                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                          S48469=3;
                          if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                            S48469=4;
                            if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                              S48469=5;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                                S48469=6;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                                    S48469=7;
                                    S48741=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S48741=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S48736=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                        S48736=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                          S50832=2;
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
                                    S48469=7;
                                    S48741=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S48741=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S48736=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                        S48736=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                          S50832=2;
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
                                  lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 107, column: 6
                                  currsigs.addElement(lidEjectExtend);
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                              }
                              else {
                                unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 6
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
                            thread63356(tdone,ends);
                            thread63357(tdone,ends);
                            int biggest63358 = 0;
                            if(ends[6]>=biggest63358){
                              biggest63358=ends[6];
                            }
                            if(ends[7]>=biggest63358){
                              biggest63358=ends[7];
                            }
                            if(biggest63358 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread63359(tdone,ends);
                          thread63360(tdone,ends);
                          int biggest63361 = 0;
                          if(ends[4]>=biggest63361){
                            biggest63361=ends[4];
                          }
                          if(ends[5]>=biggest63361){
                            biggest63361=ends[5];
                          }
                          if(biggest63361 == 1){
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                        }
                      }
                      else {
                        cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 81, column: 6
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

  public void thread63312(int [] tdone, int [] ends){
        switch(S48444){
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

  public void thread63310(int [] tdone, int [] ends){
        S63298=1;
    S62944=0;
    if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 130, column: 20
      S62944=1;
      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 20
        S62944=2;
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
      }
      else {
        if(cylZaxisExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 133, column: 14
          cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 133, column: 32
          currsigs.addElement(cylZaxisExtend);
          if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 134, column: 14
            unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 134, column: 35
            currsigs.addElement(unscrewTurnExtend);
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
          if(unscrewTurnExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 134, column: 14
            unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 134, column: 35
            currsigs.addElement(unscrewTurnExtend);
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
            if(lidGripperExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 135, column: 14
              lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 135, column: 34
              currsigs.addElement(lidGripperExtend);
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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
              if(lidEjectExtendM.getprestatus()){//sysj\lidRemovalController.sysj line: 136, column: 14
                lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 136, column: 32
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

  public void thread63308(int [] tdone, int [] ends){
        S48495=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread63307(int [] tdone, int [] ends){
        S48490=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread63305(int [] tdone, int [] ends){
        S48550=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread63304(int [] tdone, int [] ends){
        S48545=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread63303(int [] tdone, int [] ends){
        S62768=1;
    OK_thread_3 = 0;//sysj\lidRemovalController.sysj line: 65, column: 3
    BLOCKED_thread_3 = 2;//sysj\lidRemovalController.sysj line: 66, column: 3
    w_thread_3 = null;//sysj\lidRemovalController.sysj line: 68, column: 3
    code_thread_3 = 0;//sysj\lidRemovalController.sysj line: 69, column: 3
    S50832=0;
    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 72, column: 20
      S50832=1;
      if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 74, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S50832=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S48469=0;
        S48453=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 75, column: 5
          enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
          S48453=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S48448=0;
          if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
            enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 75, column: 5
            S48448=1;
            if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
              enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
              ends[3]=2;
              ;//sysj\lidRemovalController.sysj line: 75, column: 5
              w_thread_3 = (Workpiece)(enable_in.getVal() == null ? null : ((Workpiece)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
              System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 77, column: 5
              S48469=1;
              if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 80, column: 21
                S48469=2;
                if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 21
                  System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                  S48469=3;
                  if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                    S48469=4;
                    if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                      S48469=5;
                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                        S48469=6;
                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                            S48469=7;
                            S48741=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                              S48741=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S48736=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                S48736=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S50832=2;
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
                            S48469=7;
                            S48741=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                              S48741=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S48736=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                S48736=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S50832=2;
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
                          lidEjectExtend.setPresent();//sysj\lidRemovalController.sysj line: 107, column: 6
                          currsigs.addElement(lidEjectExtend);
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                      else {
                        unscrewTurnRetract.setPresent();//sysj\lidRemovalController.sysj line: 102, column: 6
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
                    thread63304(tdone,ends);
                    thread63305(tdone,ends);
                    int biggest63306 = 0;
                    if(ends[6]>=biggest63306){
                      biggest63306=ends[6];
                    }
                    if(ends[7]>=biggest63306){
                      biggest63306=ends[7];
                    }
                    if(biggest63306 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  thread63307(tdone,ends);
                  thread63308(tdone,ends);
                  int biggest63309 = 0;
                  if(ends[4]>=biggest63309){
                    biggest63309=ends[4];
                  }
                  if(ends[5]>=biggest63309){
                    biggest63309=ends[5];
                  }
                  if(biggest63309 == 1){
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
              }
              else {
                cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 81, column: 6
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

  public void thread63302(int [] tdone, int [] ends){
        S48444=1;
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
      switch(S63300){
        case 0 : 
          S63300=0;
          break RUN;
        
        case 1 : 
          S63300=2;
          S63300=2;
          auto_1.setClear();//sysj\lidRemovalController.sysj line: 52, column: 2
          manual_1.setClear();//sysj\lidRemovalController.sysj line: 52, column: 2
          thread63302(tdone,ends);
          thread63303(tdone,ends);
          thread63310(tdone,ends);
          int biggest63311 = 0;
          if(ends[2]>=biggest63311){
            biggest63311=ends[2];
          }
          if(ends[3]>=biggest63311){
            biggest63311=ends[3];
          }
          if(ends[8]>=biggest63311){
            biggest63311=ends[8];
          }
          if(biggest63311 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidRemovalController.sysj line: 52, column: 2
          manual_1.setClear();//sysj\lidRemovalController.sysj line: 52, column: 2
          thread63312(tdone,ends);
          thread63313(tdone,ends);
          thread63362(tdone,ends);
          int biggest63363 = 0;
          if(ends[2]>=biggest63363){
            biggest63363=ends[2];
          }
          if(ends[3]>=biggest63363){
            biggest63363=ends[3];
          }
          if(ends[8]>=biggest63363){
            biggest63363=ends[8];
          }
          if(biggest63363 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest63363 == 0){
            S63300=0;
            active[1]=0;
            ends[1]=0;
            S63300=0;
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
