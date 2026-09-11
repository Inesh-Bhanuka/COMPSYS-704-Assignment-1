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
  private int S101179 = 1;
  private int S86323 = 1;
  private int S100647 = 1;
  private int S88711 = 1;
  private int S86348 = 1;
  private int S86332 = 1;
  private int S86327 = 1;
  private int S86369 = 1;
  private int S86374 = 1;
  private int S86424 = 1;
  private int S86429 = 1;
  private int S86620 = 1;
  private int S86615 = 1;
  private int S101177 = 1;
  private int S100823 = 1;
  
  private int[] ends = new int[9];
  private int[] tdone = new int[9];
  
  public void thread101241(int [] tdone, int [] ends){
        switch(S101177){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S100823){
          case 0 : 
            if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 130, column: 20
              S100823=1;
              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 20
                S100823=2;
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
              S100823=2;
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
            S100823=2;
            S100823=0;
            if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 130, column: 20
              S100823=1;
              if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 20
                S100823=2;
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

  public void thread101239(int [] tdone, int [] ends){
        S86374=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread101238(int [] tdone, int [] ends){
        S86369=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread101236(int [] tdone, int [] ends){
        S86429=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101235(int [] tdone, int [] ends){
        S86424=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101233(int [] tdone, int [] ends){
        switch(S86429){
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

  public void thread101232(int [] tdone, int [] ends){
        switch(S86424){
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

  public void thread101230(int [] tdone, int [] ends){
        S86429=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101229(int [] tdone, int [] ends){
        S86424=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101227(int [] tdone, int [] ends){
        switch(S86374){
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

  public void thread101226(int [] tdone, int [] ends){
        switch(S86369){
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

  public void thread101224(int [] tdone, int [] ends){
        S86429=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101223(int [] tdone, int [] ends){
        S86424=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101221(int [] tdone, int [] ends){
        S86374=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread101220(int [] tdone, int [] ends){
        S86369=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread101218(int [] tdone, int [] ends){
        S86429=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101217(int [] tdone, int [] ends){
        S86424=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101215(int [] tdone, int [] ends){
        S86374=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread101214(int [] tdone, int [] ends){
        S86369=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread101212(int [] tdone, int [] ends){
        S86429=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101211(int [] tdone, int [] ends){
        S86424=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101209(int [] tdone, int [] ends){
        S86374=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread101208(int [] tdone, int [] ends){
        S86369=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread101206(int [] tdone, int [] ends){
        S86429=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101205(int [] tdone, int [] ends){
        S86424=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101203(int [] tdone, int [] ends){
        S86374=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread101202(int [] tdone, int [] ends){
        S86369=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread101200(int [] tdone, int [] ends){
        S86429=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101199(int [] tdone, int [] ends){
        S86424=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101197(int [] tdone, int [] ends){
        S86374=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread101196(int [] tdone, int [] ends){
        S86369=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread101194(int [] tdone, int [] ends){
        S86429=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101193(int [] tdone, int [] ends){
        S86424=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101192(int [] tdone, int [] ends){
        switch(S100647){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S88711){
          case 0 : 
            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 72, column: 20
              S88711=1;
              if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 74, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S88711=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S86348=0;
                S86332=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 75, column: 5
                  enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                  S86332=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S86327=0;
                  if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                    enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 75, column: 5
                    S86327=1;
                    if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                      enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                      ends[3]=2;
                      ;//sysj\lidRemovalController.sysj line: 75, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
                      System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 77, column: 5
                      S86348=1;
                      if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 80, column: 21
                        S86348=2;
                        if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 21
                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                          S86348=3;
                          if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                            S86348=4;
                            if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                              S86348=5;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                                S86348=6;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                                    S86348=7;
                                    S86620=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S86620=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S86615=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                        S86615=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                          S88711=2;
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
                                    S86348=7;
                                    S86620=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S86620=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S86615=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                        S86615=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                          S88711=2;
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
                        else {
                          thread101196(tdone,ends);
                          thread101197(tdone,ends);
                          int biggest101198 = 0;
                          if(ends[4]>=biggest101198){
                            biggest101198=ends[4];
                          }
                          if(ends[5]>=biggest101198){
                            biggest101198=ends[5];
                          }
                          if(biggest101198 == 1){
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
              S88711=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              switch(S86348){
                case 0 : 
                  switch(S86332){
                    case 0 : 
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 75, column: 5
                        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                        S86332=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S86327){
                          case 0 : 
                            if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                              enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 75, column: 5
                              S86327=1;
                              if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                                enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 75, column: 5
                                w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
                                System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 77, column: 5
                                S86348=1;
                                if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 80, column: 21
                                  S86348=2;
                                  if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 21
                                    System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                                    S86348=3;
                                    if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                                      S86348=4;
                                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                                        S86348=5;
                                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                                          S86348=6;
                                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                                              S86348=7;
                                              S86620=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                S86620=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S86615=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  S86615=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                                    S88711=2;
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
                                              S86348=7;
                                              S86620=0;
                                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                S86620=1;
                                                active[3]=1;
                                                ends[3]=1;
                                                tdone[3]=1;
                                              }
                                              else {
                                                S86615=0;
                                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  S86615=1;
                                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                    ends[3]=2;
                                                    ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                                    S88711=2;
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
                              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
                              System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 77, column: 5
                              S86348=1;
                              if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 80, column: 21
                                S86348=2;
                                if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 21
                                  System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                                  S86348=3;
                                  if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                                    S86348=4;
                                    if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                                      S86348=5;
                                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                                        S86348=6;
                                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                                            S86348=7;
                                            S86620=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                              S86620=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S86615=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                                S86615=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  S88711=2;
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
                                            S86348=7;
                                            S86620=0;
                                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                              S86620=1;
                                              active[3]=1;
                                              ends[3]=1;
                                              tdone[3]=1;
                                            }
                                            else {
                                              S86615=0;
                                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                                S86615=1;
                                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  ends[3]=2;
                                                  ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                                  S88711=2;
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
                                    thread101205(tdone,ends);
                                    thread101206(tdone,ends);
                                    int biggest101207 = 0;
                                    if(ends[6]>=biggest101207){
                                      biggest101207=ends[6];
                                    }
                                    if(ends[7]>=biggest101207){
                                      biggest101207=ends[7];
                                    }
                                    if(biggest101207 == 1){
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                  }
                                }
                                else {
                                  thread101208(tdone,ends);
                                  thread101209(tdone,ends);
                                  int biggest101210 = 0;
                                  if(ends[4]>=biggest101210){
                                    biggest101210=ends[4];
                                  }
                                  if(ends[5]>=biggest101210){
                                    biggest101210=ends[5];
                                  }
                                  if(biggest101210 == 1){
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
                      S86332=1;
                      S86332=0;
                      if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 75, column: 5
                        enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                        S86332=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S86327=0;
                        if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                          enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 75, column: 5
                          S86327=1;
                          if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                            enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 75, column: 5
                            w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
                            System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 77, column: 5
                            S86348=1;
                            if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 80, column: 21
                              S86348=2;
                              if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 21
                                System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                                S86348=3;
                                if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                                  S86348=4;
                                  if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                                    S86348=5;
                                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                                      S86348=6;
                                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                                          S86348=7;
                                          S86620=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                            S86620=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S86615=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                              S86615=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                                S88711=2;
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
                                          S86348=7;
                                          S86620=0;
                                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                            S86620=1;
                                            active[3]=1;
                                            ends[3]=1;
                                            tdone[3]=1;
                                          }
                                          else {
                                            S86615=0;
                                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                              S86615=1;
                                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                                ends[3]=2;
                                                ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                                S88711=2;
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
                                  thread101211(tdone,ends);
                                  thread101212(tdone,ends);
                                  int biggest101213 = 0;
                                  if(ends[6]>=biggest101213){
                                    biggest101213=ends[6];
                                  }
                                  if(ends[7]>=biggest101213){
                                    biggest101213=ends[7];
                                  }
                                  if(biggest101213 == 1){
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                }
                              }
                              else {
                                thread101214(tdone,ends);
                                thread101215(tdone,ends);
                                int biggest101216 = 0;
                                if(ends[4]>=biggest101216){
                                  biggest101216=ends[4];
                                }
                                if(ends[5]>=biggest101216){
                                  biggest101216=ends[5];
                                }
                                if(biggest101216 == 1){
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
                    S86348=2;
                    if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 21
                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                      S86348=3;
                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                        S86348=4;
                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                          S86348=5;
                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                            S86348=6;
                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                                S86348=7;
                                S86620=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S86620=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S86615=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S86615=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S88711=2;
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
                                S86348=7;
                                S86620=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S86620=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S86615=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S86615=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S88711=2;
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
                        thread101217(tdone,ends);
                        thread101218(tdone,ends);
                        int biggest101219 = 0;
                        if(ends[6]>=biggest101219){
                          biggest101219=ends[6];
                        }
                        if(ends[7]>=biggest101219){
                          biggest101219=ends[7];
                        }
                        if(biggest101219 == 1){
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                      }
                    }
                    else {
                      thread101220(tdone,ends);
                      thread101221(tdone,ends);
                      int biggest101222 = 0;
                      if(ends[4]>=biggest101222){
                        biggest101222=ends[4];
                      }
                      if(ends[5]>=biggest101222){
                        biggest101222=ends[5];
                      }
                      if(biggest101222 == 1){
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
                    S86348=3;
                    if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                      S86348=4;
                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                        S86348=5;
                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                          S86348=6;
                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                              S86348=7;
                              S86620=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                S86620=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S86615=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S86615=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S88711=2;
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
                              S86348=7;
                              S86620=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                S86620=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S86615=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S86615=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S88711=2;
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
                      thread101223(tdone,ends);
                      thread101224(tdone,ends);
                      int biggest101225 = 0;
                      if(ends[6]>=biggest101225){
                        biggest101225=ends[6];
                      }
                      if(ends[7]>=biggest101225){
                        biggest101225=ends[7];
                      }
                      if(biggest101225 == 1){
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                    }
                  }
                  else {
                    thread101226(tdone,ends);
                    thread101227(tdone,ends);
                    int biggest101228 = 0;
                    if(ends[4]>=biggest101228){
                      biggest101228=ends[4];
                    }
                    if(ends[5]>=biggest101228){
                      biggest101228=ends[5];
                    }
                    if(biggest101228 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest101228 == 0){
                      System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                      S86348=3;
                      if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                        S86348=4;
                        if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                          S86348=5;
                          if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                            S86348=6;
                            if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                              w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                              System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                              code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                              if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                                System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                                code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                                S86348=7;
                                S86620=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S86620=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S86615=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S86615=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S88711=2;
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
                                S86348=7;
                                S86620=0;
                                if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S86620=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S86615=0;
                                  if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S86615=1;
                                    if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      ends[3]=2;
                                      ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S88711=2;
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
                        thread101229(tdone,ends);
                        thread101230(tdone,ends);
                        int biggest101231 = 0;
                        if(ends[6]>=biggest101231){
                          biggest101231=ends[6];
                        }
                        if(ends[7]>=biggest101231){
                          biggest101231=ends[7];
                        }
                        if(biggest101231 == 1){
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
                    S86348=4;
                    if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                      S86348=5;
                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                        S86348=6;
                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                            S86348=7;
                            S86620=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                              S86620=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S86615=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                S86615=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S88711=2;
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
                            S86348=7;
                            S86620=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                              S86620=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S86615=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                S86615=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S88711=2;
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
                    thread101232(tdone,ends);
                    thread101233(tdone,ends);
                    int biggest101234 = 0;
                    if(ends[6]>=biggest101234){
                      biggest101234=ends[6];
                    }
                    if(ends[7]>=biggest101234){
                      biggest101234=ends[7];
                    }
                    if(biggest101234 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    //FINXME code
                    if(biggest101234 == 0){
                      S86348=4;
                      if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                        S86348=5;
                        if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                          S86348=6;
                          if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                            w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                            System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                            code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                            if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                              System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                              code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                              S86348=7;
                              S86620=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                S86620=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S86615=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S86615=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S88711=2;
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
                              S86348=7;
                              S86620=0;
                              if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                S86620=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S86615=0;
                                if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S86615=1;
                                  if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                    status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                    ends[3]=2;
                                    ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                    S88711=2;
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
                    S86348=5;
                    if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                      S86348=6;
                      if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                        w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                        System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                        code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                        if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                          System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                          code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                          S86348=7;
                          S86620=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                            S86620=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S86615=0;
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                              S86615=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                S88711=2;
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
                          S86348=7;
                          S86620=0;
                          if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                            S86620=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S86615=0;
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                              S86615=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                S88711=2;
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
                    S86348=6;
                    if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                      w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                      System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                      code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                      if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                        System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                        code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                        S86348=7;
                        S86620=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                          S86620=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S86615=0;
                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                            S86615=1;
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 122, column: 5
                              S88711=2;
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
                        S86348=7;
                        S86620=0;
                        if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                          S86620=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S86615=0;
                          if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                            status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                            S86615=1;
                            if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                              ends[3]=2;
                              ;//sysj\lidRemovalController.sysj line: 122, column: 5
                              S88711=2;
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
                      S86348=7;
                      S86620=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                        S86620=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S86615=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                          S86615=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 122, column: 5
                            S88711=2;
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
                      S86348=7;
                      S86620=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                        S86620=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S86615=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                          S86615=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 122, column: 5
                            S88711=2;
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
                  switch(S86620){
                    case 0 : 
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                        S86620=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        switch(S86615){
                          case 0 : 
                            if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                              S86615=1;
                              if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                ends[3]=2;
                                ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                S88711=2;
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
                              S88711=2;
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
                      S86620=1;
                      S86620=0;
                      if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                        status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                        S86620=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S86615=0;
                        if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                          status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                          S86615=1;
                          if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                            status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                            ends[3]=2;
                            ;//sysj\lidRemovalController.sysj line: 122, column: 5
                            S88711=2;
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
                  S88711=2;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            S88711=2;
            S88711=0;
            if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 72, column: 20
              S88711=1;
              if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 74, column: 20
                enable_in.setPreempted();
                status_o.setPreempted();
                S88711=2;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S86348=0;
                S86332=0;
                if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 75, column: 5
                  enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                  S86332=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S86327=0;
                  if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                    enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 75, column: 5
                    S86327=1;
                    if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
                      enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
                      ends[3]=2;
                      ;//sysj\lidRemovalController.sysj line: 75, column: 5
                      w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
                      System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 77, column: 5
                      S86348=1;
                      if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 80, column: 21
                        S86348=2;
                        if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 21
                          System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                          S86348=3;
                          if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                            S86348=4;
                            if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                              S86348=5;
                              if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                                S86348=6;
                                if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                                  w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                                  System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                                  code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                                  if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                                    System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                                    code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                                    S86348=7;
                                    S86620=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S86620=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S86615=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                        S86615=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                          S88711=2;
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
                                    S86348=7;
                                    S86620=0;
                                    if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                      status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                      S86620=1;
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S86615=0;
                                      if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                        status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                        S86615=1;
                                        if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                          status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                          ends[3]=2;
                                          ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                          S88711=2;
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
                            thread101235(tdone,ends);
                            thread101236(tdone,ends);
                            int biggest101237 = 0;
                            if(ends[6]>=biggest101237){
                              biggest101237=ends[6];
                            }
                            if(ends[7]>=biggest101237){
                              biggest101237=ends[7];
                            }
                            if(biggest101237 == 1){
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                          }
                        }
                        else {
                          thread101238(tdone,ends);
                          thread101239(tdone,ends);
                          int biggest101240 = 0;
                          if(ends[4]>=biggest101240){
                            biggest101240=ends[4];
                          }
                          if(ends[5]>=biggest101240){
                            biggest101240=ends[5];
                          }
                          if(biggest101240 == 1){
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

  public void thread101191(int [] tdone, int [] ends){
        switch(S86323){
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

  public void thread101189(int [] tdone, int [] ends){
        S101177=1;
    S100823=0;
    if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 130, column: 20
      S100823=1;
      if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 131, column: 20
        S100823=2;
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

  public void thread101187(int [] tdone, int [] ends){
        S86374=1;
    lidGripperExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 39
    currsigs.addElement(lidGripperExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread101186(int [] tdone, int [] ends){
        S86369=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 86, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread101184(int [] tdone, int [] ends){
        S86429=1;
    unscrewTurnExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 39
    currsigs.addElement(unscrewTurnExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread101183(int [] tdone, int [] ends){
        S86424=1;
    cylZaxisExtend.setPresent();//sysj\lidRemovalController.sysj line: 92, column: 8
    currsigs.addElement(cylZaxisExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread101182(int [] tdone, int [] ends){
        S100647=1;
    OK_thread_3 = 0;//sysj\lidRemovalController.sysj line: 65, column: 3
    BLOCKED_thread_3 = 2;//sysj\lidRemovalController.sysj line: 66, column: 3
    w_thread_3 = null;//sysj\lidRemovalController.sysj line: 68, column: 3
    code_thread_3 = 0;//sysj\lidRemovalController.sysj line: 69, column: 3
    S88711=0;
    if(auto_1.getprestatus()){//sysj\lidRemovalController.sysj line: 72, column: 20
      S88711=1;
      if(manual_1.getprestatus()){//sysj\lidRemovalController.sysj line: 74, column: 20
        enable_in.setPreempted();
        status_o.setPreempted();
        S88711=2;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S86348=0;
        S86332=0;
        if(!enable_in.isPartnerPresent() || enable_in.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 75, column: 5
          enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
          S86332=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          S86327=0;
          if(!enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
            enable_in.setACK(true);//sysj\lidRemovalController.sysj line: 75, column: 5
            S86327=1;
            if(enable_in.isREQ()){//sysj\lidRemovalController.sysj line: 75, column: 5
              enable_in.setACK(false);//sysj\lidRemovalController.sysj line: 75, column: 5
              ends[3]=2;
              ;//sysj\lidRemovalController.sysj line: 75, column: 5
              w_thread_3 = (WorkpieceTwin)(enable_in.getVal() == null ? null : ((WorkpieceTwin)enable_in.getVal()));//sysj\lidRemovalController.sysj line: 76, column: 5
              System.out.println("[LR] Removing the lid from " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 77, column: 5
              S86348=1;
              if(zAxisLowered.getprestatus()){//sysj\lidRemovalController.sysj line: 80, column: 21
                S86348=2;
                if(lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 85, column: 21
                  System.out.println("[LR] Cap gripped on " + w_thread_3 + ".");//sysj\lidRemovalController.sysj line: 88, column: 5
                  S86348=3;
                  if(turnAtFinalPos.getprestatus()){//sysj\lidRemovalController.sysj line: 91, column: 21
                    S86348=4;
                    if(zAxisLifted.getprestatus()){//sysj\lidRemovalController.sysj line: 98, column: 21
                      S86348=5;
                      if(turnAtHomePos.getprestatus()){//sysj\lidRemovalController.sysj line: 101, column: 21
                        S86348=6;
                        if(!lidGripped.getprestatus()){//sysj\lidRemovalController.sysj line: 106, column: 21
                          w_thread_3.removeLid();//sysj\lidRemovalController.sysj line: 112, column: 5
                          System.out.println("[LR] Lid off " + w_thread_3 + ", sealed=" + w_thread_3.isSealed() + ".");//sysj\lidRemovalController.sysj line: 113, column: 5
                          code_thread_3 = OK_thread_3;//sysj\lidRemovalController.sysj line: 116, column: 5
                          if(lidBinFull.getprestatus()){//sysj\lidRemovalController.sysj line: 117, column: 13
                            System.out.println("[LR] Lid waste bin is full; no further bottles until it is serviced.");//sysj\lidRemovalController.sysj line: 118, column: 6
                            code_thread_3 = BLOCKED_thread_3;//sysj\lidRemovalController.sysj line: 119, column: 6
                            S86348=7;
                            S86620=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                              S86620=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S86615=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                S86615=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S88711=2;
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
                            S86348=7;
                            S86620=0;
                            if(!status_o.isPartnerPresent() || status_o.isPartnerPreempted()){//sysj\lidRemovalController.sysj line: 122, column: 5
                              status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                              S86620=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S86615=0;
                              if(status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                status_o.setVal(new Integer(code_thread_3));//sysj\lidRemovalController.sysj line: 122, column: 5
                                S86615=1;
                                if(!status_o.isACK()){//sysj\lidRemovalController.sysj line: 122, column: 5
                                  status_o.setREQ(false);//sysj\lidRemovalController.sysj line: 122, column: 5
                                  ends[3]=2;
                                  ;//sysj\lidRemovalController.sysj line: 122, column: 5
                                  S88711=2;
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
                    thread101183(tdone,ends);
                    thread101184(tdone,ends);
                    int biggest101185 = 0;
                    if(ends[6]>=biggest101185){
                      biggest101185=ends[6];
                    }
                    if(ends[7]>=biggest101185){
                      biggest101185=ends[7];
                    }
                    if(biggest101185 == 1){
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                  }
                }
                else {
                  thread101186(tdone,ends);
                  thread101187(tdone,ends);
                  int biggest101188 = 0;
                  if(ends[4]>=biggest101188){
                    biggest101188=ends[4];
                  }
                  if(ends[5]>=biggest101188){
                    biggest101188=ends[5];
                  }
                  if(biggest101188 == 1){
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

  public void thread101181(int [] tdone, int [] ends){
        S86323=1;
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
      switch(S101179){
        case 0 : 
          S101179=0;
          break RUN;
        
        case 1 : 
          S101179=2;
          S101179=2;
          auto_1.setClear();//sysj\lidRemovalController.sysj line: 52, column: 2
          manual_1.setClear();//sysj\lidRemovalController.sysj line: 52, column: 2
          thread101181(tdone,ends);
          thread101182(tdone,ends);
          thread101189(tdone,ends);
          int biggest101190 = 0;
          if(ends[2]>=biggest101190){
            biggest101190=ends[2];
          }
          if(ends[3]>=biggest101190){
            biggest101190=ends[3];
          }
          if(ends[8]>=biggest101190){
            biggest101190=ends[8];
          }
          if(biggest101190 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          auto_1.setClear();//sysj\lidRemovalController.sysj line: 52, column: 2
          manual_1.setClear();//sysj\lidRemovalController.sysj line: 52, column: 2
          thread101191(tdone,ends);
          thread101192(tdone,ends);
          thread101241(tdone,ends);
          int biggest101242 = 0;
          if(ends[2]>=biggest101242){
            biggest101242=ends[2];
          }
          if(ends[3]>=biggest101242){
            biggest101242=ends[3];
          }
          if(ends[8]>=biggest101242){
            biggest101242=ends[8];
          }
          if(biggest101242 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest101242 == 0){
            S101179=0;
            active[1]=0;
            ends[1]=0;
            S101179=0;
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
