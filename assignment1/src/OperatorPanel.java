import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class OperatorPanel extends ClockDomain{
  public OperatorPanel(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal blVacOn = new Signal("blVacOn", Signal.OUTPUT);
  public Signal blRelease = new Signal("blRelease", Signal.OUTPUT);
  public Signal blArmSource = new Signal("blArmSource", Signal.OUTPUT);
  public Signal blArmDest = new Signal("blArmDest", Signal.OUTPUT);
  public Signal cvMotInfeed = new Signal("cvMotInfeed", Signal.OUTPUT);
  public Signal cvTakeFromPos1 = new Signal("cvTakeFromPos1", Signal.OUTPUT);
  public Signal cvMotOutfeed = new Signal("cvMotOutfeed", Signal.OUTPUT);
  public Signal cvInjectInfeed = new Signal("cvInjectInfeed", Signal.OUTPUT);
  public Signal cvInjectOutfeed = new Signal("cvInjectOutfeed", Signal.OUTPUT);
  public Signal cvCollectFromEnd = new Signal("cvCollectFromEnd", Signal.OUTPUT);
  public Signal rtRotaryTrigger = new Signal("rtRotaryTrigger", Signal.OUTPUT);
  public Signal rtLoadPos1 = new Signal("rtLoadPos1", Signal.OUTPUT);
  public Signal rtUnloadExit = new Signal("rtUnloadExit", Signal.OUTPUT);
  public Signal f1ValveOpen = new Signal("f1ValveOpen", Signal.OUTPUT);
  public Signal f2ValveOpen = new Signal("f2ValveOpen", Signal.OUTPUT);
  public Signal llPusherExtend = new Signal("llPusherExtend", Signal.OUTPUT);
  public Signal llVacOn = new Signal("llVacOn", Signal.OUTPUT);
  public Signal llArmSource = new Signal("llArmSource", Signal.OUTPUT);
  public Signal llArmDest = new Signal("llArmDest", Signal.OUTPUT);
  public Signal llRefill = new Signal("llRefill", Signal.OUTPUT);
  public Signal cpScrewOn = new Signal("cpScrewOn", Signal.OUTPUT);
  public Signal lbApplyLabelExtend = new Signal("lbApplyLabelExtend", Signal.OUTPUT);
  public Signal lbApplyLabelRetract = new Signal("lbApplyLabelRetract", Signal.OUTPUT);
  public Signal lbRollerOnOff = new Signal("lbRollerOnOff", Signal.OUTPUT);
  public Signal spDiverterExtend = new Signal("spDiverterExtend", Signal.OUTPUT);
  public Signal spDiverterRetract = new Signal("spDiverterRetract", Signal.OUTPUT);
  public Signal spAdmitBottle = new Signal("spAdmitBottle", Signal.OUTPUT);
  public Signal rcRecyclingConveyorMotor = new Signal("rcRecyclingConveyorMotor", Signal.OUTPUT);
  public Signal rcInjectAtEntry = new Signal("rcInjectAtEntry", Signal.OUTPUT);
  public Signal rcCollectAtReturn = new Signal("rcCollectAtReturn", Signal.OUTPUT);
  public Signal lrCylZaxisExtend = new Signal("lrCylZaxisExtend", Signal.OUTPUT);
  public Signal lrUnscrewTurnExtend = new Signal("lrUnscrewTurnExtend", Signal.OUTPUT);
  public Signal lrUnscrewTurnRetract = new Signal("lrUnscrewTurnRetract", Signal.OUTPUT);
  public Signal lrLidGripperExtend = new Signal("lrLidGripperExtend", Signal.OUTPUT);
  public Signal lrLidEjectExtend = new Signal("lrLidEjectExtend", Signal.OUTPUT);
  public Signal ldCylClampBottleExtend = new Signal("ldCylClampBottleExtend", Signal.OUTPUT);
  public Signal ldInvertRotateExtend = new Signal("ldInvertRotateExtend", Signal.OUTPUT);
  public Signal ldInvertRotateRetract = new Signal("ldInvertRotateRetract", Signal.OUTPUT);
  public Signal ldDrainValveOnOff = new Signal("ldDrainValveOnOff", Signal.OUTPUT);
  public Signal brMotorOnOff = new Signal("brMotorOnOff", Signal.OUTPUT);
  public Signal brTransferArmExtend = new Signal("brTransferArmExtend", Signal.OUTPUT);
  public Signal brTransferArmRetract = new Signal("brTransferArmRetract", Signal.OUTPUT);
  private int S227542 = 1;
  private int S226868 = 1;
  private int S226814 = 1;
  private int S227077 = 1;
  private int S227109 = 1;
  private int S227117 = 1;
  private int S227125 = 1;
  private int S227235 = 1;
  private int S227243 = 1;
  private int S227275 = 1;
  private int S227307 = 1;
  private int S227339 = 1;
  private int S227449 = 1;
  private int S227508 = 1;
  private int S227540 = 1;
  
  private int[] ends = new int[15];
  private int[] tdone = new int[15];
  
  public void thread227570(int [] tdone, int [] ends){
        switch(S227540){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        if(ManualDrive.held("br.motorOnOff")){//sysj\operatorPanel.sysj line: 150, column: 4
          brMotorOnOff.setPresent();//sysj\operatorPanel.sysj line: 150, column: 43
          currsigs.addElement(brMotorOnOff);
          if(ManualDrive.held("br.transferArmExtend")){//sysj\operatorPanel.sysj line: 151, column: 4
            brTransferArmExtend.setPresent();//sysj\operatorPanel.sysj line: 151, column: 50
            currsigs.addElement(brTransferArmExtend);
            if(ManualDrive.held("br.transferArmRetract")){//sysj\operatorPanel.sysj line: 152, column: 4
              brTransferArmRetract.setPresent();//sysj\operatorPanel.sysj line: 152, column: 51
              currsigs.addElement(brTransferArmRetract);
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
          }
          else {
            if(ManualDrive.held("br.transferArmRetract")){//sysj\operatorPanel.sysj line: 152, column: 4
              brTransferArmRetract.setPresent();//sysj\operatorPanel.sysj line: 152, column: 51
              currsigs.addElement(brTransferArmRetract);
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
          }
        }
        else {
          if(ManualDrive.held("br.transferArmExtend")){//sysj\operatorPanel.sysj line: 151, column: 4
            brTransferArmExtend.setPresent();//sysj\operatorPanel.sysj line: 151, column: 50
            currsigs.addElement(brTransferArmExtend);
            if(ManualDrive.held("br.transferArmRetract")){//sysj\operatorPanel.sysj line: 152, column: 4
              brTransferArmRetract.setPresent();//sysj\operatorPanel.sysj line: 152, column: 51
              currsigs.addElement(brTransferArmRetract);
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
          }
          else {
            if(ManualDrive.held("br.transferArmRetract")){//sysj\operatorPanel.sysj line: 152, column: 4
              brTransferArmRetract.setPresent();//sysj\operatorPanel.sysj line: 152, column: 51
              currsigs.addElement(brTransferArmRetract);
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
          }
        }
        break;
      
    }
  }

  public void thread227569(int [] tdone, int [] ends){
        switch(S227508){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        if(ManualDrive.held("ld.cylClampBottleExtend")){//sysj\operatorPanel.sysj line: 140, column: 4
          ldCylClampBottleExtend.setPresent();//sysj\operatorPanel.sysj line: 140, column: 53
          currsigs.addElement(ldCylClampBottleExtend);
          if(ManualDrive.held("ld.invertRotateExtend")){//sysj\operatorPanel.sysj line: 141, column: 4
            ldInvertRotateExtend.setPresent();//sysj\operatorPanel.sysj line: 141, column: 51
            currsigs.addElement(ldInvertRotateExtend);
            if(ManualDrive.held("ld.invertRotateRetract")){//sysj\operatorPanel.sysj line: 142, column: 4
              ldInvertRotateRetract.setPresent();//sysj\operatorPanel.sysj line: 142, column: 52
              currsigs.addElement(ldInvertRotateRetract);
              if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
                ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
                currsigs.addElement(ldDrainValveOnOff);
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
            else {
              if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
                ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
                currsigs.addElement(ldDrainValveOnOff);
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
          }
          else {
            if(ManualDrive.held("ld.invertRotateRetract")){//sysj\operatorPanel.sysj line: 142, column: 4
              ldInvertRotateRetract.setPresent();//sysj\operatorPanel.sysj line: 142, column: 52
              currsigs.addElement(ldInvertRotateRetract);
              if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
                ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
                currsigs.addElement(ldDrainValveOnOff);
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
            else {
              if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
                ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
                currsigs.addElement(ldDrainValveOnOff);
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
          }
        }
        else {
          if(ManualDrive.held("ld.invertRotateExtend")){//sysj\operatorPanel.sysj line: 141, column: 4
            ldInvertRotateExtend.setPresent();//sysj\operatorPanel.sysj line: 141, column: 51
            currsigs.addElement(ldInvertRotateExtend);
            if(ManualDrive.held("ld.invertRotateRetract")){//sysj\operatorPanel.sysj line: 142, column: 4
              ldInvertRotateRetract.setPresent();//sysj\operatorPanel.sysj line: 142, column: 52
              currsigs.addElement(ldInvertRotateRetract);
              if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
                ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
                currsigs.addElement(ldDrainValveOnOff);
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
            else {
              if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
                ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
                currsigs.addElement(ldDrainValveOnOff);
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
          }
          else {
            if(ManualDrive.held("ld.invertRotateRetract")){//sysj\operatorPanel.sysj line: 142, column: 4
              ldInvertRotateRetract.setPresent();//sysj\operatorPanel.sysj line: 142, column: 52
              currsigs.addElement(ldInvertRotateRetract);
              if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
                ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
                currsigs.addElement(ldDrainValveOnOff);
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
            else {
              if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
                ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
                currsigs.addElement(ldDrainValveOnOff);
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
          }
        }
        break;
      
    }
  }

  public void thread227568(int [] tdone, int [] ends){
        switch(S227449){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(ManualDrive.held("lr.cylZaxisExtend")){//sysj\operatorPanel.sysj line: 129, column: 4
          lrCylZaxisExtend.setPresent();//sysj\operatorPanel.sysj line: 129, column: 47
          currsigs.addElement(lrCylZaxisExtend);
          if(ManualDrive.held("lr.unscrewTurnExtend")){//sysj\operatorPanel.sysj line: 130, column: 4
            lrUnscrewTurnExtend.setPresent();//sysj\operatorPanel.sysj line: 130, column: 50
            currsigs.addElement(lrUnscrewTurnExtend);
            if(ManualDrive.held("lr.unscrewTurnRetract")){//sysj\operatorPanel.sysj line: 131, column: 4
              lrUnscrewTurnRetract.setPresent();//sysj\operatorPanel.sysj line: 131, column: 51
              currsigs.addElement(lrUnscrewTurnRetract);
              if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
                lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
                currsigs.addElement(lrLidGripperExtend);
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
              else {
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
            }
            else {
              if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
                lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
                currsigs.addElement(lrLidGripperExtend);
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
              else {
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
            }
          }
          else {
            if(ManualDrive.held("lr.unscrewTurnRetract")){//sysj\operatorPanel.sysj line: 131, column: 4
              lrUnscrewTurnRetract.setPresent();//sysj\operatorPanel.sysj line: 131, column: 51
              currsigs.addElement(lrUnscrewTurnRetract);
              if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
                lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
                currsigs.addElement(lrLidGripperExtend);
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
              else {
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
            }
            else {
              if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
                lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
                currsigs.addElement(lrLidGripperExtend);
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
              else {
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
            }
          }
        }
        else {
          if(ManualDrive.held("lr.unscrewTurnExtend")){//sysj\operatorPanel.sysj line: 130, column: 4
            lrUnscrewTurnExtend.setPresent();//sysj\operatorPanel.sysj line: 130, column: 50
            currsigs.addElement(lrUnscrewTurnExtend);
            if(ManualDrive.held("lr.unscrewTurnRetract")){//sysj\operatorPanel.sysj line: 131, column: 4
              lrUnscrewTurnRetract.setPresent();//sysj\operatorPanel.sysj line: 131, column: 51
              currsigs.addElement(lrUnscrewTurnRetract);
              if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
                lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
                currsigs.addElement(lrLidGripperExtend);
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
              else {
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
            }
            else {
              if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
                lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
                currsigs.addElement(lrLidGripperExtend);
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
              else {
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
            }
          }
          else {
            if(ManualDrive.held("lr.unscrewTurnRetract")){//sysj\operatorPanel.sysj line: 131, column: 4
              lrUnscrewTurnRetract.setPresent();//sysj\operatorPanel.sysj line: 131, column: 51
              currsigs.addElement(lrUnscrewTurnRetract);
              if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
                lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
                currsigs.addElement(lrLidGripperExtend);
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
              else {
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
            }
            else {
              if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
                lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
                currsigs.addElement(lrLidGripperExtend);
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
              else {
                if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
                  lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
                  currsigs.addElement(lrLidEjectExtend);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
                else {
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                }
              }
            }
          }
        }
        break;
      
    }
  }

  public void thread227567(int [] tdone, int [] ends){
        switch(S227339){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(ManualDrive.held("rc.recyclingConveyorMotor")){//sysj\operatorPanel.sysj line: 120, column: 4
          rcRecyclingConveyorMotor.setPresent();//sysj\operatorPanel.sysj line: 120, column: 55
          currsigs.addElement(rcRecyclingConveyorMotor);
          if(ManualDrive.held("rc.injectAtEntry")){//sysj\operatorPanel.sysj line: 121, column: 4
            rcInjectAtEntry.setPresent();//sysj\operatorPanel.sysj line: 121, column: 46
            currsigs.addElement(rcInjectAtEntry);
            if(ManualDrive.held("rc.collectAtReturn")){//sysj\operatorPanel.sysj line: 122, column: 4
              rcCollectAtReturn.setPresent();//sysj\operatorPanel.sysj line: 122, column: 48
              currsigs.addElement(rcCollectAtReturn);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
          }
          else {
            if(ManualDrive.held("rc.collectAtReturn")){//sysj\operatorPanel.sysj line: 122, column: 4
              rcCollectAtReturn.setPresent();//sysj\operatorPanel.sysj line: 122, column: 48
              currsigs.addElement(rcCollectAtReturn);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
          }
        }
        else {
          if(ManualDrive.held("rc.injectAtEntry")){//sysj\operatorPanel.sysj line: 121, column: 4
            rcInjectAtEntry.setPresent();//sysj\operatorPanel.sysj line: 121, column: 46
            currsigs.addElement(rcInjectAtEntry);
            if(ManualDrive.held("rc.collectAtReturn")){//sysj\operatorPanel.sysj line: 122, column: 4
              rcCollectAtReturn.setPresent();//sysj\operatorPanel.sysj line: 122, column: 48
              currsigs.addElement(rcCollectAtReturn);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
          }
          else {
            if(ManualDrive.held("rc.collectAtReturn")){//sysj\operatorPanel.sysj line: 122, column: 4
              rcCollectAtReturn.setPresent();//sysj\operatorPanel.sysj line: 122, column: 48
              currsigs.addElement(rcCollectAtReturn);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
          }
        }
        break;
      
    }
  }

  public void thread227566(int [] tdone, int [] ends){
        switch(S227307){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(ManualDrive.held("sp.diverterExtend")){//sysj\operatorPanel.sysj line: 111, column: 4
          spDiverterExtend.setPresent();//sysj\operatorPanel.sysj line: 111, column: 47
          currsigs.addElement(spDiverterExtend);
          if(ManualDrive.held("sp.diverterRetract")){//sysj\operatorPanel.sysj line: 112, column: 4
            spDiverterRetract.setPresent();//sysj\operatorPanel.sysj line: 112, column: 48
            currsigs.addElement(spDiverterRetract);
            if(ManualDrive.held("sp.admitBottle")){//sysj\operatorPanel.sysj line: 113, column: 4
              spAdmitBottle.setPresent();//sysj\operatorPanel.sysj line: 113, column: 44
              currsigs.addElement(spAdmitBottle);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
          }
          else {
            if(ManualDrive.held("sp.admitBottle")){//sysj\operatorPanel.sysj line: 113, column: 4
              spAdmitBottle.setPresent();//sysj\operatorPanel.sysj line: 113, column: 44
              currsigs.addElement(spAdmitBottle);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
          }
        }
        else {
          if(ManualDrive.held("sp.diverterRetract")){//sysj\operatorPanel.sysj line: 112, column: 4
            spDiverterRetract.setPresent();//sysj\operatorPanel.sysj line: 112, column: 48
            currsigs.addElement(spDiverterRetract);
            if(ManualDrive.held("sp.admitBottle")){//sysj\operatorPanel.sysj line: 113, column: 4
              spAdmitBottle.setPresent();//sysj\operatorPanel.sysj line: 113, column: 44
              currsigs.addElement(spAdmitBottle);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
          }
          else {
            if(ManualDrive.held("sp.admitBottle")){//sysj\operatorPanel.sysj line: 113, column: 4
              spAdmitBottle.setPresent();//sysj\operatorPanel.sysj line: 113, column: 44
              currsigs.addElement(spAdmitBottle);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
          }
        }
        break;
      
    }
  }

  public void thread227565(int [] tdone, int [] ends){
        switch(S227275){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(ManualDrive.held("lb.applyLabelExtend")){//sysj\operatorPanel.sysj line: 102, column: 4
          lbApplyLabelExtend.setPresent();//sysj\operatorPanel.sysj line: 102, column: 49
          currsigs.addElement(lbApplyLabelExtend);
          if(ManualDrive.held("lb.applyLabelRetract")){//sysj\operatorPanel.sysj line: 103, column: 4
            lbApplyLabelRetract.setPresent();//sysj\operatorPanel.sysj line: 103, column: 50
            currsigs.addElement(lbApplyLabelRetract);
            if(ManualDrive.held("lb.rollerOnOff")){//sysj\operatorPanel.sysj line: 104, column: 4
              lbRollerOnOff.setPresent();//sysj\operatorPanel.sysj line: 104, column: 44
              currsigs.addElement(lbRollerOnOff);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
          }
          else {
            if(ManualDrive.held("lb.rollerOnOff")){//sysj\operatorPanel.sysj line: 104, column: 4
              lbRollerOnOff.setPresent();//sysj\operatorPanel.sysj line: 104, column: 44
              currsigs.addElement(lbRollerOnOff);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
          }
        }
        else {
          if(ManualDrive.held("lb.applyLabelRetract")){//sysj\operatorPanel.sysj line: 103, column: 4
            lbApplyLabelRetract.setPresent();//sysj\operatorPanel.sysj line: 103, column: 50
            currsigs.addElement(lbApplyLabelRetract);
            if(ManualDrive.held("lb.rollerOnOff")){//sysj\operatorPanel.sysj line: 104, column: 4
              lbRollerOnOff.setPresent();//sysj\operatorPanel.sysj line: 104, column: 44
              currsigs.addElement(lbRollerOnOff);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
          }
          else {
            if(ManualDrive.held("lb.rollerOnOff")){//sysj\operatorPanel.sysj line: 104, column: 4
              lbRollerOnOff.setPresent();//sysj\operatorPanel.sysj line: 104, column: 44
              currsigs.addElement(lbRollerOnOff);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
          }
        }
        break;
      
    }
  }

  public void thread227564(int [] tdone, int [] ends){
        switch(S227243){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(ManualDrive.held("cp.screwOn")){//sysj\operatorPanel.sysj line: 95, column: 4
          cpScrewOn.setPresent();//sysj\operatorPanel.sysj line: 95, column: 40
          currsigs.addElement(cpScrewOn);
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        else {
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread227563(int [] tdone, int [] ends){
        switch(S227235){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(ManualDrive.held("ll.pusherExtend")){//sysj\operatorPanel.sysj line: 84, column: 4
          llPusherExtend.setPresent();//sysj\operatorPanel.sysj line: 84, column: 45
          currsigs.addElement(llPusherExtend);
          if(ManualDrive.held("ll.vacOn")){//sysj\operatorPanel.sysj line: 85, column: 4
            llVacOn.setPresent();//sysj\operatorPanel.sysj line: 85, column: 38
            currsigs.addElement(llVacOn);
            if(ManualDrive.held("ll.armSource")){//sysj\operatorPanel.sysj line: 86, column: 4
              llArmSource.setPresent();//sysj\operatorPanel.sysj line: 86, column: 42
              currsigs.addElement(llArmSource);
              if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
                llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
                currsigs.addElement(llArmDest);
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              else {
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
            }
            else {
              if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
                llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
                currsigs.addElement(llArmDest);
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              else {
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
            }
          }
          else {
            if(ManualDrive.held("ll.armSource")){//sysj\operatorPanel.sysj line: 86, column: 4
              llArmSource.setPresent();//sysj\operatorPanel.sysj line: 86, column: 42
              currsigs.addElement(llArmSource);
              if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
                llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
                currsigs.addElement(llArmDest);
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              else {
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
            }
            else {
              if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
                llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
                currsigs.addElement(llArmDest);
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              else {
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
            }
          }
        }
        else {
          if(ManualDrive.held("ll.vacOn")){//sysj\operatorPanel.sysj line: 85, column: 4
            llVacOn.setPresent();//sysj\operatorPanel.sysj line: 85, column: 38
            currsigs.addElement(llVacOn);
            if(ManualDrive.held("ll.armSource")){//sysj\operatorPanel.sysj line: 86, column: 4
              llArmSource.setPresent();//sysj\operatorPanel.sysj line: 86, column: 42
              currsigs.addElement(llArmSource);
              if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
                llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
                currsigs.addElement(llArmDest);
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              else {
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
            }
            else {
              if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
                llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
                currsigs.addElement(llArmDest);
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              else {
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
            }
          }
          else {
            if(ManualDrive.held("ll.armSource")){//sysj\operatorPanel.sysj line: 86, column: 4
              llArmSource.setPresent();//sysj\operatorPanel.sysj line: 86, column: 42
              currsigs.addElement(llArmSource);
              if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
                llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
                currsigs.addElement(llArmDest);
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              else {
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
            }
            else {
              if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
                llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
                currsigs.addElement(llArmDest);
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
              else {
                if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
                  llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
                  currsigs.addElement(llRefill);
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
                else {
                  active[7]=1;
                  ends[7]=1;
                  tdone[7]=1;
                }
              }
            }
          }
        }
        break;
      
    }
  }

  public void thread227562(int [] tdone, int [] ends){
        switch(S227125){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(ManualDrive.held("f2.valveOpen")){//sysj\operatorPanel.sysj line: 77, column: 4
          f2ValveOpen.setPresent();//sysj\operatorPanel.sysj line: 77, column: 42
          currsigs.addElement(f2ValveOpen);
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        break;
      
    }
  }

  public void thread227561(int [] tdone, int [] ends){
        switch(S227117){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(ManualDrive.held("f1.valveOpen")){//sysj\operatorPanel.sysj line: 70, column: 4
          f1ValveOpen.setPresent();//sysj\operatorPanel.sysj line: 70, column: 42
          currsigs.addElement(f1ValveOpen);
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread227560(int [] tdone, int [] ends){
        switch(S227109){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(ManualDrive.held("rt.rotaryTrigger")){//sysj\operatorPanel.sysj line: 61, column: 4
          rtRotaryTrigger.setPresent();//sysj\operatorPanel.sysj line: 61, column: 46
          currsigs.addElement(rtRotaryTrigger);
          if(ManualDrive.held("rt.loadPos1")){//sysj\operatorPanel.sysj line: 62, column: 4
            rtLoadPos1.setPresent();//sysj\operatorPanel.sysj line: 62, column: 41
            currsigs.addElement(rtLoadPos1);
            if(ManualDrive.held("rt.unloadExit")){//sysj\operatorPanel.sysj line: 63, column: 4
              rtUnloadExit.setPresent();//sysj\operatorPanel.sysj line: 63, column: 43
              currsigs.addElement(rtUnloadExit);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
          }
          else {
            if(ManualDrive.held("rt.unloadExit")){//sysj\operatorPanel.sysj line: 63, column: 4
              rtUnloadExit.setPresent();//sysj\operatorPanel.sysj line: 63, column: 43
              currsigs.addElement(rtUnloadExit);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
          }
        }
        else {
          if(ManualDrive.held("rt.loadPos1")){//sysj\operatorPanel.sysj line: 62, column: 4
            rtLoadPos1.setPresent();//sysj\operatorPanel.sysj line: 62, column: 41
            currsigs.addElement(rtLoadPos1);
            if(ManualDrive.held("rt.unloadExit")){//sysj\operatorPanel.sysj line: 63, column: 4
              rtUnloadExit.setPresent();//sysj\operatorPanel.sysj line: 63, column: 43
              currsigs.addElement(rtUnloadExit);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
          }
          else {
            if(ManualDrive.held("rt.unloadExit")){//sysj\operatorPanel.sysj line: 63, column: 4
              rtUnloadExit.setPresent();//sysj\operatorPanel.sysj line: 63, column: 43
              currsigs.addElement(rtUnloadExit);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
          }
        }
        break;
      
    }
  }

  public void thread227559(int [] tdone, int [] ends){
        switch(S227077){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(ManualDrive.held("cv.motInfeed")){//sysj\operatorPanel.sysj line: 49, column: 4
          cvMotInfeed.setPresent();//sysj\operatorPanel.sysj line: 49, column: 42
          currsigs.addElement(cvMotInfeed);
          if(ManualDrive.held("cv.takeFromPos1")){//sysj\operatorPanel.sysj line: 50, column: 4
            cvTakeFromPos1.setPresent();//sysj\operatorPanel.sysj line: 50, column: 45
            currsigs.addElement(cvTakeFromPos1);
            if(ManualDrive.held("cv.motOutfeed")){//sysj\operatorPanel.sysj line: 51, column: 4
              cvMotOutfeed.setPresent();//sysj\operatorPanel.sysj line: 51, column: 43
              currsigs.addElement(cvMotOutfeed);
              if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
                cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
                currsigs.addElement(cvInjectInfeed);
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
              else {
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
            }
            else {
              if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
                cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
                currsigs.addElement(cvInjectInfeed);
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
              else {
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
            }
          }
          else {
            if(ManualDrive.held("cv.motOutfeed")){//sysj\operatorPanel.sysj line: 51, column: 4
              cvMotOutfeed.setPresent();//sysj\operatorPanel.sysj line: 51, column: 43
              currsigs.addElement(cvMotOutfeed);
              if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
                cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
                currsigs.addElement(cvInjectInfeed);
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
              else {
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
            }
            else {
              if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
                cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
                currsigs.addElement(cvInjectInfeed);
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
              else {
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
            }
          }
        }
        else {
          if(ManualDrive.held("cv.takeFromPos1")){//sysj\operatorPanel.sysj line: 50, column: 4
            cvTakeFromPos1.setPresent();//sysj\operatorPanel.sysj line: 50, column: 45
            currsigs.addElement(cvTakeFromPos1);
            if(ManualDrive.held("cv.motOutfeed")){//sysj\operatorPanel.sysj line: 51, column: 4
              cvMotOutfeed.setPresent();//sysj\operatorPanel.sysj line: 51, column: 43
              currsigs.addElement(cvMotOutfeed);
              if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
                cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
                currsigs.addElement(cvInjectInfeed);
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
              else {
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
            }
            else {
              if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
                cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
                currsigs.addElement(cvInjectInfeed);
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
              else {
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
            }
          }
          else {
            if(ManualDrive.held("cv.motOutfeed")){//sysj\operatorPanel.sysj line: 51, column: 4
              cvMotOutfeed.setPresent();//sysj\operatorPanel.sysj line: 51, column: 43
              currsigs.addElement(cvMotOutfeed);
              if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
                cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
                currsigs.addElement(cvInjectInfeed);
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
              else {
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
            }
            else {
              if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
                cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
                currsigs.addElement(cvInjectInfeed);
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
              else {
                if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
                  cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
                  currsigs.addElement(cvInjectOutfeed);
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
                  if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                    cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                    currsigs.addElement(cvCollectFromEnd);
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
              }
            }
          }
        }
        break;
      
    }
  }

  public void thread227558(int [] tdone, int [] ends){
        switch(S226868){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S226814){
          case 0 : 
            S226814=0;
            if(ManualDrive.held("bl.vacOn")){//sysj\operatorPanel.sysj line: 39, column: 4
              blVacOn.setPresent();//sysj\operatorPanel.sysj line: 39, column: 38
              currsigs.addElement(blVacOn);
              if(ManualDrive.held("bl.release")){//sysj\operatorPanel.sysj line: 40, column: 4
                blRelease.setPresent();//sysj\operatorPanel.sysj line: 40, column: 40
                currsigs.addElement(blRelease);
                if(ManualDrive.held("bl.armSource")){//sysj\operatorPanel.sysj line: 41, column: 4
                  blArmSource.setPresent();//sysj\operatorPanel.sysj line: 41, column: 42
                  currsigs.addElement(blArmSource);
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
              }
              else {
                if(ManualDrive.held("bl.armSource")){//sysj\operatorPanel.sysj line: 41, column: 4
                  blArmSource.setPresent();//sysj\operatorPanel.sysj line: 41, column: 42
                  currsigs.addElement(blArmSource);
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
              }
            }
            else {
              if(ManualDrive.held("bl.release")){//sysj\operatorPanel.sysj line: 40, column: 4
                blRelease.setPresent();//sysj\operatorPanel.sysj line: 40, column: 40
                currsigs.addElement(blRelease);
                if(ManualDrive.held("bl.armSource")){//sysj\operatorPanel.sysj line: 41, column: 4
                  blArmSource.setPresent();//sysj\operatorPanel.sysj line: 41, column: 42
                  currsigs.addElement(blArmSource);
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
              }
              else {
                if(ManualDrive.held("bl.armSource")){//sysj\operatorPanel.sysj line: 41, column: 4
                  blArmSource.setPresent();//sysj\operatorPanel.sysj line: 41, column: 42
                  currsigs.addElement(blArmSource);
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
              }
            }
            break;
          
          case 1 : 
            S226814=1;
            S226814=0;
            if(ManualDrive.held("bl.vacOn")){//sysj\operatorPanel.sysj line: 39, column: 4
              blVacOn.setPresent();//sysj\operatorPanel.sysj line: 39, column: 38
              currsigs.addElement(blVacOn);
              if(ManualDrive.held("bl.release")){//sysj\operatorPanel.sysj line: 40, column: 4
                blRelease.setPresent();//sysj\operatorPanel.sysj line: 40, column: 40
                currsigs.addElement(blRelease);
                if(ManualDrive.held("bl.armSource")){//sysj\operatorPanel.sysj line: 41, column: 4
                  blArmSource.setPresent();//sysj\operatorPanel.sysj line: 41, column: 42
                  currsigs.addElement(blArmSource);
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
              }
              else {
                if(ManualDrive.held("bl.armSource")){//sysj\operatorPanel.sysj line: 41, column: 4
                  blArmSource.setPresent();//sysj\operatorPanel.sysj line: 41, column: 42
                  currsigs.addElement(blArmSource);
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
              }
            }
            else {
              if(ManualDrive.held("bl.release")){//sysj\operatorPanel.sysj line: 40, column: 4
                blRelease.setPresent();//sysj\operatorPanel.sysj line: 40, column: 40
                currsigs.addElement(blRelease);
                if(ManualDrive.held("bl.armSource")){//sysj\operatorPanel.sysj line: 41, column: 4
                  blArmSource.setPresent();//sysj\operatorPanel.sysj line: 41, column: 42
                  currsigs.addElement(blArmSource);
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
              }
              else {
                if(ManualDrive.held("bl.armSource")){//sysj\operatorPanel.sysj line: 41, column: 4
                  blArmSource.setPresent();//sysj\operatorPanel.sysj line: 41, column: 42
                  currsigs.addElement(blArmSource);
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S226814=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread227556(int [] tdone, int [] ends){
        S227540=1;
    if(ManualDrive.held("br.motorOnOff")){//sysj\operatorPanel.sysj line: 150, column: 4
      brMotorOnOff.setPresent();//sysj\operatorPanel.sysj line: 150, column: 43
      currsigs.addElement(brMotorOnOff);
      if(ManualDrive.held("br.transferArmExtend")){//sysj\operatorPanel.sysj line: 151, column: 4
        brTransferArmExtend.setPresent();//sysj\operatorPanel.sysj line: 151, column: 50
        currsigs.addElement(brTransferArmExtend);
        if(ManualDrive.held("br.transferArmRetract")){//sysj\operatorPanel.sysj line: 152, column: 4
          brTransferArmRetract.setPresent();//sysj\operatorPanel.sysj line: 152, column: 51
          currsigs.addElement(brTransferArmRetract);
          active[14]=1;
          ends[14]=1;
          tdone[14]=1;
        }
        else {
          active[14]=1;
          ends[14]=1;
          tdone[14]=1;
        }
      }
      else {
        if(ManualDrive.held("br.transferArmRetract")){//sysj\operatorPanel.sysj line: 152, column: 4
          brTransferArmRetract.setPresent();//sysj\operatorPanel.sysj line: 152, column: 51
          currsigs.addElement(brTransferArmRetract);
          active[14]=1;
          ends[14]=1;
          tdone[14]=1;
        }
        else {
          active[14]=1;
          ends[14]=1;
          tdone[14]=1;
        }
      }
    }
    else {
      if(ManualDrive.held("br.transferArmExtend")){//sysj\operatorPanel.sysj line: 151, column: 4
        brTransferArmExtend.setPresent();//sysj\operatorPanel.sysj line: 151, column: 50
        currsigs.addElement(brTransferArmExtend);
        if(ManualDrive.held("br.transferArmRetract")){//sysj\operatorPanel.sysj line: 152, column: 4
          brTransferArmRetract.setPresent();//sysj\operatorPanel.sysj line: 152, column: 51
          currsigs.addElement(brTransferArmRetract);
          active[14]=1;
          ends[14]=1;
          tdone[14]=1;
        }
        else {
          active[14]=1;
          ends[14]=1;
          tdone[14]=1;
        }
      }
      else {
        if(ManualDrive.held("br.transferArmRetract")){//sysj\operatorPanel.sysj line: 152, column: 4
          brTransferArmRetract.setPresent();//sysj\operatorPanel.sysj line: 152, column: 51
          currsigs.addElement(brTransferArmRetract);
          active[14]=1;
          ends[14]=1;
          tdone[14]=1;
        }
        else {
          active[14]=1;
          ends[14]=1;
          tdone[14]=1;
        }
      }
    }
  }

  public void thread227555(int [] tdone, int [] ends){
        S227508=1;
    if(ManualDrive.held("ld.cylClampBottleExtend")){//sysj\operatorPanel.sysj line: 140, column: 4
      ldCylClampBottleExtend.setPresent();//sysj\operatorPanel.sysj line: 140, column: 53
      currsigs.addElement(ldCylClampBottleExtend);
      if(ManualDrive.held("ld.invertRotateExtend")){//sysj\operatorPanel.sysj line: 141, column: 4
        ldInvertRotateExtend.setPresent();//sysj\operatorPanel.sysj line: 141, column: 51
        currsigs.addElement(ldInvertRotateExtend);
        if(ManualDrive.held("ld.invertRotateRetract")){//sysj\operatorPanel.sysj line: 142, column: 4
          ldInvertRotateRetract.setPresent();//sysj\operatorPanel.sysj line: 142, column: 52
          currsigs.addElement(ldInvertRotateRetract);
          if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
            ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
            currsigs.addElement(ldDrainValveOnOff);
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
          else {
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
        }
        else {
          if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
            ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
            currsigs.addElement(ldDrainValveOnOff);
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
          else {
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
        }
      }
      else {
        if(ManualDrive.held("ld.invertRotateRetract")){//sysj\operatorPanel.sysj line: 142, column: 4
          ldInvertRotateRetract.setPresent();//sysj\operatorPanel.sysj line: 142, column: 52
          currsigs.addElement(ldInvertRotateRetract);
          if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
            ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
            currsigs.addElement(ldDrainValveOnOff);
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
          else {
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
        }
        else {
          if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
            ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
            currsigs.addElement(ldDrainValveOnOff);
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
          else {
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
        }
      }
    }
    else {
      if(ManualDrive.held("ld.invertRotateExtend")){//sysj\operatorPanel.sysj line: 141, column: 4
        ldInvertRotateExtend.setPresent();//sysj\operatorPanel.sysj line: 141, column: 51
        currsigs.addElement(ldInvertRotateExtend);
        if(ManualDrive.held("ld.invertRotateRetract")){//sysj\operatorPanel.sysj line: 142, column: 4
          ldInvertRotateRetract.setPresent();//sysj\operatorPanel.sysj line: 142, column: 52
          currsigs.addElement(ldInvertRotateRetract);
          if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
            ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
            currsigs.addElement(ldDrainValveOnOff);
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
          else {
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
        }
        else {
          if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
            ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
            currsigs.addElement(ldDrainValveOnOff);
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
          else {
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
        }
      }
      else {
        if(ManualDrive.held("ld.invertRotateRetract")){//sysj\operatorPanel.sysj line: 142, column: 4
          ldInvertRotateRetract.setPresent();//sysj\operatorPanel.sysj line: 142, column: 52
          currsigs.addElement(ldInvertRotateRetract);
          if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
            ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
            currsigs.addElement(ldDrainValveOnOff);
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
          else {
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
        }
        else {
          if(ManualDrive.held("ld.drainValveOnOff")){//sysj\operatorPanel.sysj line: 143, column: 4
            ldDrainValveOnOff.setPresent();//sysj\operatorPanel.sysj line: 143, column: 48
            currsigs.addElement(ldDrainValveOnOff);
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
          else {
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
          }
        }
      }
    }
  }

  public void thread227554(int [] tdone, int [] ends){
        S227449=1;
    if(ManualDrive.held("lr.cylZaxisExtend")){//sysj\operatorPanel.sysj line: 129, column: 4
      lrCylZaxisExtend.setPresent();//sysj\operatorPanel.sysj line: 129, column: 47
      currsigs.addElement(lrCylZaxisExtend);
      if(ManualDrive.held("lr.unscrewTurnExtend")){//sysj\operatorPanel.sysj line: 130, column: 4
        lrUnscrewTurnExtend.setPresent();//sysj\operatorPanel.sysj line: 130, column: 50
        currsigs.addElement(lrUnscrewTurnExtend);
        if(ManualDrive.held("lr.unscrewTurnRetract")){//sysj\operatorPanel.sysj line: 131, column: 4
          lrUnscrewTurnRetract.setPresent();//sysj\operatorPanel.sysj line: 131, column: 51
          currsigs.addElement(lrUnscrewTurnRetract);
          if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
            lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
            currsigs.addElement(lrLidGripperExtend);
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
          else {
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
        }
        else {
          if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
            lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
            currsigs.addElement(lrLidGripperExtend);
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
          else {
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
        }
      }
      else {
        if(ManualDrive.held("lr.unscrewTurnRetract")){//sysj\operatorPanel.sysj line: 131, column: 4
          lrUnscrewTurnRetract.setPresent();//sysj\operatorPanel.sysj line: 131, column: 51
          currsigs.addElement(lrUnscrewTurnRetract);
          if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
            lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
            currsigs.addElement(lrLidGripperExtend);
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
          else {
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
        }
        else {
          if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
            lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
            currsigs.addElement(lrLidGripperExtend);
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
          else {
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
        }
      }
    }
    else {
      if(ManualDrive.held("lr.unscrewTurnExtend")){//sysj\operatorPanel.sysj line: 130, column: 4
        lrUnscrewTurnExtend.setPresent();//sysj\operatorPanel.sysj line: 130, column: 50
        currsigs.addElement(lrUnscrewTurnExtend);
        if(ManualDrive.held("lr.unscrewTurnRetract")){//sysj\operatorPanel.sysj line: 131, column: 4
          lrUnscrewTurnRetract.setPresent();//sysj\operatorPanel.sysj line: 131, column: 51
          currsigs.addElement(lrUnscrewTurnRetract);
          if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
            lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
            currsigs.addElement(lrLidGripperExtend);
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
          else {
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
        }
        else {
          if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
            lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
            currsigs.addElement(lrLidGripperExtend);
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
          else {
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
        }
      }
      else {
        if(ManualDrive.held("lr.unscrewTurnRetract")){//sysj\operatorPanel.sysj line: 131, column: 4
          lrUnscrewTurnRetract.setPresent();//sysj\operatorPanel.sysj line: 131, column: 51
          currsigs.addElement(lrUnscrewTurnRetract);
          if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
            lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
            currsigs.addElement(lrLidGripperExtend);
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
          else {
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
        }
        else {
          if(ManualDrive.held("lr.lidGripperExtend")){//sysj\operatorPanel.sysj line: 132, column: 4
            lrLidGripperExtend.setPresent();//sysj\operatorPanel.sysj line: 132, column: 49
            currsigs.addElement(lrLidGripperExtend);
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
          else {
            if(ManualDrive.held("lr.lidEjectExtend")){//sysj\operatorPanel.sysj line: 133, column: 4
              lrLidEjectExtend.setPresent();//sysj\operatorPanel.sysj line: 133, column: 47
              currsigs.addElement(lrLidEjectExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
          }
        }
      }
    }
  }

  public void thread227553(int [] tdone, int [] ends){
        S227339=1;
    if(ManualDrive.held("rc.recyclingConveyorMotor")){//sysj\operatorPanel.sysj line: 120, column: 4
      rcRecyclingConveyorMotor.setPresent();//sysj\operatorPanel.sysj line: 120, column: 55
      currsigs.addElement(rcRecyclingConveyorMotor);
      if(ManualDrive.held("rc.injectAtEntry")){//sysj\operatorPanel.sysj line: 121, column: 4
        rcInjectAtEntry.setPresent();//sysj\operatorPanel.sysj line: 121, column: 46
        currsigs.addElement(rcInjectAtEntry);
        if(ManualDrive.held("rc.collectAtReturn")){//sysj\operatorPanel.sysj line: 122, column: 4
          rcCollectAtReturn.setPresent();//sysj\operatorPanel.sysj line: 122, column: 48
          currsigs.addElement(rcCollectAtReturn);
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        else {
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
      }
      else {
        if(ManualDrive.held("rc.collectAtReturn")){//sysj\operatorPanel.sysj line: 122, column: 4
          rcCollectAtReturn.setPresent();//sysj\operatorPanel.sysj line: 122, column: 48
          currsigs.addElement(rcCollectAtReturn);
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        else {
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
      }
    }
    else {
      if(ManualDrive.held("rc.injectAtEntry")){//sysj\operatorPanel.sysj line: 121, column: 4
        rcInjectAtEntry.setPresent();//sysj\operatorPanel.sysj line: 121, column: 46
        currsigs.addElement(rcInjectAtEntry);
        if(ManualDrive.held("rc.collectAtReturn")){//sysj\operatorPanel.sysj line: 122, column: 4
          rcCollectAtReturn.setPresent();//sysj\operatorPanel.sysj line: 122, column: 48
          currsigs.addElement(rcCollectAtReturn);
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        else {
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
      }
      else {
        if(ManualDrive.held("rc.collectAtReturn")){//sysj\operatorPanel.sysj line: 122, column: 4
          rcCollectAtReturn.setPresent();//sysj\operatorPanel.sysj line: 122, column: 48
          currsigs.addElement(rcCollectAtReturn);
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        else {
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
      }
    }
  }

  public void thread227552(int [] tdone, int [] ends){
        S227307=1;
    if(ManualDrive.held("sp.diverterExtend")){//sysj\operatorPanel.sysj line: 111, column: 4
      spDiverterExtend.setPresent();//sysj\operatorPanel.sysj line: 111, column: 47
      currsigs.addElement(spDiverterExtend);
      if(ManualDrive.held("sp.diverterRetract")){//sysj\operatorPanel.sysj line: 112, column: 4
        spDiverterRetract.setPresent();//sysj\operatorPanel.sysj line: 112, column: 48
        currsigs.addElement(spDiverterRetract);
        if(ManualDrive.held("sp.admitBottle")){//sysj\operatorPanel.sysj line: 113, column: 4
          spAdmitBottle.setPresent();//sysj\operatorPanel.sysj line: 113, column: 44
          currsigs.addElement(spAdmitBottle);
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
      }
      else {
        if(ManualDrive.held("sp.admitBottle")){//sysj\operatorPanel.sysj line: 113, column: 4
          spAdmitBottle.setPresent();//sysj\operatorPanel.sysj line: 113, column: 44
          currsigs.addElement(spAdmitBottle);
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
      }
    }
    else {
      if(ManualDrive.held("sp.diverterRetract")){//sysj\operatorPanel.sysj line: 112, column: 4
        spDiverterRetract.setPresent();//sysj\operatorPanel.sysj line: 112, column: 48
        currsigs.addElement(spDiverterRetract);
        if(ManualDrive.held("sp.admitBottle")){//sysj\operatorPanel.sysj line: 113, column: 4
          spAdmitBottle.setPresent();//sysj\operatorPanel.sysj line: 113, column: 44
          currsigs.addElement(spAdmitBottle);
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
      }
      else {
        if(ManualDrive.held("sp.admitBottle")){//sysj\operatorPanel.sysj line: 113, column: 4
          spAdmitBottle.setPresent();//sysj\operatorPanel.sysj line: 113, column: 44
          currsigs.addElement(spAdmitBottle);
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
      }
    }
  }

  public void thread227551(int [] tdone, int [] ends){
        S227275=1;
    if(ManualDrive.held("lb.applyLabelExtend")){//sysj\operatorPanel.sysj line: 102, column: 4
      lbApplyLabelExtend.setPresent();//sysj\operatorPanel.sysj line: 102, column: 49
      currsigs.addElement(lbApplyLabelExtend);
      if(ManualDrive.held("lb.applyLabelRetract")){//sysj\operatorPanel.sysj line: 103, column: 4
        lbApplyLabelRetract.setPresent();//sysj\operatorPanel.sysj line: 103, column: 50
        currsigs.addElement(lbApplyLabelRetract);
        if(ManualDrive.held("lb.rollerOnOff")){//sysj\operatorPanel.sysj line: 104, column: 4
          lbRollerOnOff.setPresent();//sysj\operatorPanel.sysj line: 104, column: 44
          currsigs.addElement(lbRollerOnOff);
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        else {
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
      }
      else {
        if(ManualDrive.held("lb.rollerOnOff")){//sysj\operatorPanel.sysj line: 104, column: 4
          lbRollerOnOff.setPresent();//sysj\operatorPanel.sysj line: 104, column: 44
          currsigs.addElement(lbRollerOnOff);
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        else {
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
      }
    }
    else {
      if(ManualDrive.held("lb.applyLabelRetract")){//sysj\operatorPanel.sysj line: 103, column: 4
        lbApplyLabelRetract.setPresent();//sysj\operatorPanel.sysj line: 103, column: 50
        currsigs.addElement(lbApplyLabelRetract);
        if(ManualDrive.held("lb.rollerOnOff")){//sysj\operatorPanel.sysj line: 104, column: 4
          lbRollerOnOff.setPresent();//sysj\operatorPanel.sysj line: 104, column: 44
          currsigs.addElement(lbRollerOnOff);
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        else {
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
      }
      else {
        if(ManualDrive.held("lb.rollerOnOff")){//sysj\operatorPanel.sysj line: 104, column: 4
          lbRollerOnOff.setPresent();//sysj\operatorPanel.sysj line: 104, column: 44
          currsigs.addElement(lbRollerOnOff);
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        else {
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
      }
    }
  }

  public void thread227550(int [] tdone, int [] ends){
        S227243=1;
    if(ManualDrive.held("cp.screwOn")){//sysj\operatorPanel.sysj line: 95, column: 4
      cpScrewOn.setPresent();//sysj\operatorPanel.sysj line: 95, column: 40
      currsigs.addElement(cpScrewOn);
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

  public void thread227549(int [] tdone, int [] ends){
        S227235=1;
    if(ManualDrive.held("ll.pusherExtend")){//sysj\operatorPanel.sysj line: 84, column: 4
      llPusherExtend.setPresent();//sysj\operatorPanel.sysj line: 84, column: 45
      currsigs.addElement(llPusherExtend);
      if(ManualDrive.held("ll.vacOn")){//sysj\operatorPanel.sysj line: 85, column: 4
        llVacOn.setPresent();//sysj\operatorPanel.sysj line: 85, column: 38
        currsigs.addElement(llVacOn);
        if(ManualDrive.held("ll.armSource")){//sysj\operatorPanel.sysj line: 86, column: 4
          llArmSource.setPresent();//sysj\operatorPanel.sysj line: 86, column: 42
          currsigs.addElement(llArmSource);
          if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
            llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
            currsigs.addElement(llArmDest);
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
          else {
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
        }
        else {
          if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
            llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
            currsigs.addElement(llArmDest);
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
          else {
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
        }
      }
      else {
        if(ManualDrive.held("ll.armSource")){//sysj\operatorPanel.sysj line: 86, column: 4
          llArmSource.setPresent();//sysj\operatorPanel.sysj line: 86, column: 42
          currsigs.addElement(llArmSource);
          if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
            llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
            currsigs.addElement(llArmDest);
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
          else {
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
        }
        else {
          if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
            llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
            currsigs.addElement(llArmDest);
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
          else {
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
        }
      }
    }
    else {
      if(ManualDrive.held("ll.vacOn")){//sysj\operatorPanel.sysj line: 85, column: 4
        llVacOn.setPresent();//sysj\operatorPanel.sysj line: 85, column: 38
        currsigs.addElement(llVacOn);
        if(ManualDrive.held("ll.armSource")){//sysj\operatorPanel.sysj line: 86, column: 4
          llArmSource.setPresent();//sysj\operatorPanel.sysj line: 86, column: 42
          currsigs.addElement(llArmSource);
          if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
            llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
            currsigs.addElement(llArmDest);
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
          else {
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
        }
        else {
          if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
            llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
            currsigs.addElement(llArmDest);
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
          else {
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
        }
      }
      else {
        if(ManualDrive.held("ll.armSource")){//sysj\operatorPanel.sysj line: 86, column: 4
          llArmSource.setPresent();//sysj\operatorPanel.sysj line: 86, column: 42
          currsigs.addElement(llArmSource);
          if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
            llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
            currsigs.addElement(llArmDest);
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
          else {
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
        }
        else {
          if(ManualDrive.held("ll.armDest")){//sysj\operatorPanel.sysj line: 87, column: 4
            llArmDest.setPresent();//sysj\operatorPanel.sysj line: 87, column: 40
            currsigs.addElement(llArmDest);
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
          else {
            if(ManualDrive.held("ll.refill")){//sysj\operatorPanel.sysj line: 88, column: 4
              llRefill.setPresent();//sysj\operatorPanel.sysj line: 88, column: 39
              currsigs.addElement(llRefill);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
          }
        }
      }
    }
  }

  public void thread227548(int [] tdone, int [] ends){
        S227125=1;
    if(ManualDrive.held("f2.valveOpen")){//sysj\operatorPanel.sysj line: 77, column: 4
      f2ValveOpen.setPresent();//sysj\operatorPanel.sysj line: 77, column: 42
      currsigs.addElement(f2ValveOpen);
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread227547(int [] tdone, int [] ends){
        S227117=1;
    if(ManualDrive.held("f1.valveOpen")){//sysj\operatorPanel.sysj line: 70, column: 4
      f1ValveOpen.setPresent();//sysj\operatorPanel.sysj line: 70, column: 42
      currsigs.addElement(f1ValveOpen);
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread227546(int [] tdone, int [] ends){
        S227109=1;
    if(ManualDrive.held("rt.rotaryTrigger")){//sysj\operatorPanel.sysj line: 61, column: 4
      rtRotaryTrigger.setPresent();//sysj\operatorPanel.sysj line: 61, column: 46
      currsigs.addElement(rtRotaryTrigger);
      if(ManualDrive.held("rt.loadPos1")){//sysj\operatorPanel.sysj line: 62, column: 4
        rtLoadPos1.setPresent();//sysj\operatorPanel.sysj line: 62, column: 41
        currsigs.addElement(rtLoadPos1);
        if(ManualDrive.held("rt.unloadExit")){//sysj\operatorPanel.sysj line: 63, column: 4
          rtUnloadExit.setPresent();//sysj\operatorPanel.sysj line: 63, column: 43
          currsigs.addElement(rtUnloadExit);
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
      }
      else {
        if(ManualDrive.held("rt.unloadExit")){//sysj\operatorPanel.sysj line: 63, column: 4
          rtUnloadExit.setPresent();//sysj\operatorPanel.sysj line: 63, column: 43
          currsigs.addElement(rtUnloadExit);
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
      }
    }
    else {
      if(ManualDrive.held("rt.loadPos1")){//sysj\operatorPanel.sysj line: 62, column: 4
        rtLoadPos1.setPresent();//sysj\operatorPanel.sysj line: 62, column: 41
        currsigs.addElement(rtLoadPos1);
        if(ManualDrive.held("rt.unloadExit")){//sysj\operatorPanel.sysj line: 63, column: 4
          rtUnloadExit.setPresent();//sysj\operatorPanel.sysj line: 63, column: 43
          currsigs.addElement(rtUnloadExit);
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
      }
      else {
        if(ManualDrive.held("rt.unloadExit")){//sysj\operatorPanel.sysj line: 63, column: 4
          rtUnloadExit.setPresent();//sysj\operatorPanel.sysj line: 63, column: 43
          currsigs.addElement(rtUnloadExit);
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
      }
    }
  }

  public void thread227545(int [] tdone, int [] ends){
        S227077=1;
    if(ManualDrive.held("cv.motInfeed")){//sysj\operatorPanel.sysj line: 49, column: 4
      cvMotInfeed.setPresent();//sysj\operatorPanel.sysj line: 49, column: 42
      currsigs.addElement(cvMotInfeed);
      if(ManualDrive.held("cv.takeFromPos1")){//sysj\operatorPanel.sysj line: 50, column: 4
        cvTakeFromPos1.setPresent();//sysj\operatorPanel.sysj line: 50, column: 45
        currsigs.addElement(cvTakeFromPos1);
        if(ManualDrive.held("cv.motOutfeed")){//sysj\operatorPanel.sysj line: 51, column: 4
          cvMotOutfeed.setPresent();//sysj\operatorPanel.sysj line: 51, column: 43
          currsigs.addElement(cvMotOutfeed);
          if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
            cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
            currsigs.addElement(cvInjectInfeed);
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
          else {
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
        }
        else {
          if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
            cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
            currsigs.addElement(cvInjectInfeed);
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
          else {
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
        }
      }
      else {
        if(ManualDrive.held("cv.motOutfeed")){//sysj\operatorPanel.sysj line: 51, column: 4
          cvMotOutfeed.setPresent();//sysj\operatorPanel.sysj line: 51, column: 43
          currsigs.addElement(cvMotOutfeed);
          if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
            cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
            currsigs.addElement(cvInjectInfeed);
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
          else {
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
        }
        else {
          if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
            cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
            currsigs.addElement(cvInjectInfeed);
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
          else {
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
        }
      }
    }
    else {
      if(ManualDrive.held("cv.takeFromPos1")){//sysj\operatorPanel.sysj line: 50, column: 4
        cvTakeFromPos1.setPresent();//sysj\operatorPanel.sysj line: 50, column: 45
        currsigs.addElement(cvTakeFromPos1);
        if(ManualDrive.held("cv.motOutfeed")){//sysj\operatorPanel.sysj line: 51, column: 4
          cvMotOutfeed.setPresent();//sysj\operatorPanel.sysj line: 51, column: 43
          currsigs.addElement(cvMotOutfeed);
          if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
            cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
            currsigs.addElement(cvInjectInfeed);
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
          else {
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
        }
        else {
          if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
            cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
            currsigs.addElement(cvInjectInfeed);
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
          else {
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
        }
      }
      else {
        if(ManualDrive.held("cv.motOutfeed")){//sysj\operatorPanel.sysj line: 51, column: 4
          cvMotOutfeed.setPresent();//sysj\operatorPanel.sysj line: 51, column: 43
          currsigs.addElement(cvMotOutfeed);
          if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
            cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
            currsigs.addElement(cvInjectInfeed);
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
          else {
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
        }
        else {
          if(ManualDrive.held("cv.injectInfeed")){//sysj\operatorPanel.sysj line: 52, column: 4
            cvInjectInfeed.setPresent();//sysj\operatorPanel.sysj line: 52, column: 45
            currsigs.addElement(cvInjectInfeed);
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
          else {
            if(ManualDrive.held("cv.injectOutfeed")){//sysj\operatorPanel.sysj line: 53, column: 4
              cvInjectOutfeed.setPresent();//sysj\operatorPanel.sysj line: 53, column: 46
              currsigs.addElement(cvInjectOutfeed);
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
              if(ManualDrive.held("cv.collectFromEnd")){//sysj\operatorPanel.sysj line: 54, column: 4
                cvCollectFromEnd.setPresent();//sysj\operatorPanel.sysj line: 54, column: 47
                currsigs.addElement(cvCollectFromEnd);
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
          }
        }
      }
    }
  }

  public void thread227544(int [] tdone, int [] ends){
        S226868=1;
    S226814=0;
    if(ManualDrive.held("bl.vacOn")){//sysj\operatorPanel.sysj line: 39, column: 4
      blVacOn.setPresent();//sysj\operatorPanel.sysj line: 39, column: 38
      currsigs.addElement(blVacOn);
      if(ManualDrive.held("bl.release")){//sysj\operatorPanel.sysj line: 40, column: 4
        blRelease.setPresent();//sysj\operatorPanel.sysj line: 40, column: 40
        currsigs.addElement(blRelease);
        if(ManualDrive.held("bl.armSource")){//sysj\operatorPanel.sysj line: 41, column: 4
          blArmSource.setPresent();//sysj\operatorPanel.sysj line: 41, column: 42
          currsigs.addElement(blArmSource);
          if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
            blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
            currsigs.addElement(blArmDest);
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
        }
        else {
          if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
            blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
            currsigs.addElement(blArmDest);
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
        }
      }
      else {
        if(ManualDrive.held("bl.armSource")){//sysj\operatorPanel.sysj line: 41, column: 4
          blArmSource.setPresent();//sysj\operatorPanel.sysj line: 41, column: 42
          currsigs.addElement(blArmSource);
          if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
            blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
            currsigs.addElement(blArmDest);
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
        }
        else {
          if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
            blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
            currsigs.addElement(blArmDest);
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
        }
      }
    }
    else {
      if(ManualDrive.held("bl.release")){//sysj\operatorPanel.sysj line: 40, column: 4
        blRelease.setPresent();//sysj\operatorPanel.sysj line: 40, column: 40
        currsigs.addElement(blRelease);
        if(ManualDrive.held("bl.armSource")){//sysj\operatorPanel.sysj line: 41, column: 4
          blArmSource.setPresent();//sysj\operatorPanel.sysj line: 41, column: 42
          currsigs.addElement(blArmSource);
          if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
            blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
            currsigs.addElement(blArmDest);
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
        }
        else {
          if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
            blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
            currsigs.addElement(blArmDest);
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
        }
      }
      else {
        if(ManualDrive.held("bl.armSource")){//sysj\operatorPanel.sysj line: 41, column: 4
          blArmSource.setPresent();//sysj\operatorPanel.sysj line: 41, column: 42
          currsigs.addElement(blArmSource);
          if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
            blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
            currsigs.addElement(blArmDest);
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
        }
        else {
          if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
            blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
            currsigs.addElement(blArmDest);
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S226814=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
        }
      }
    }
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S227542){
        case 0 : 
          S227542=0;
          break RUN;
        
        case 1 : 
          S227542=2;
          S227542=2;
          thread227544(tdone,ends);
          thread227545(tdone,ends);
          thread227546(tdone,ends);
          thread227547(tdone,ends);
          thread227548(tdone,ends);
          thread227549(tdone,ends);
          thread227550(tdone,ends);
          thread227551(tdone,ends);
          thread227552(tdone,ends);
          thread227553(tdone,ends);
          thread227554(tdone,ends);
          thread227555(tdone,ends);
          thread227556(tdone,ends);
          int biggest227557 = 0;
          if(ends[2]>=biggest227557){
            biggest227557=ends[2];
          }
          if(ends[3]>=biggest227557){
            biggest227557=ends[3];
          }
          if(ends[4]>=biggest227557){
            biggest227557=ends[4];
          }
          if(ends[5]>=biggest227557){
            biggest227557=ends[5];
          }
          if(ends[6]>=biggest227557){
            biggest227557=ends[6];
          }
          if(ends[7]>=biggest227557){
            biggest227557=ends[7];
          }
          if(ends[8]>=biggest227557){
            biggest227557=ends[8];
          }
          if(ends[9]>=biggest227557){
            biggest227557=ends[9];
          }
          if(ends[10]>=biggest227557){
            biggest227557=ends[10];
          }
          if(ends[11]>=biggest227557){
            biggest227557=ends[11];
          }
          if(ends[12]>=biggest227557){
            biggest227557=ends[12];
          }
          if(ends[13]>=biggest227557){
            biggest227557=ends[13];
          }
          if(ends[14]>=biggest227557){
            biggest227557=ends[14];
          }
          if(biggest227557 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread227558(tdone,ends);
          thread227559(tdone,ends);
          thread227560(tdone,ends);
          thread227561(tdone,ends);
          thread227562(tdone,ends);
          thread227563(tdone,ends);
          thread227564(tdone,ends);
          thread227565(tdone,ends);
          thread227566(tdone,ends);
          thread227567(tdone,ends);
          thread227568(tdone,ends);
          thread227569(tdone,ends);
          thread227570(tdone,ends);
          int biggest227571 = 0;
          if(ends[2]>=biggest227571){
            biggest227571=ends[2];
          }
          if(ends[3]>=biggest227571){
            biggest227571=ends[3];
          }
          if(ends[4]>=biggest227571){
            biggest227571=ends[4];
          }
          if(ends[5]>=biggest227571){
            biggest227571=ends[5];
          }
          if(ends[6]>=biggest227571){
            biggest227571=ends[6];
          }
          if(ends[7]>=biggest227571){
            biggest227571=ends[7];
          }
          if(ends[8]>=biggest227571){
            biggest227571=ends[8];
          }
          if(ends[9]>=biggest227571){
            biggest227571=ends[9];
          }
          if(ends[10]>=biggest227571){
            biggest227571=ends[10];
          }
          if(ends[11]>=biggest227571){
            biggest227571=ends[11];
          }
          if(ends[12]>=biggest227571){
            biggest227571=ends[12];
          }
          if(ends[13]>=biggest227571){
            biggest227571=ends[13];
          }
          if(ends[14]>=biggest227571){
            biggest227571=ends[14];
          }
          if(biggest227571 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest227571 == 0){
            S227542=0;
            active[1]=0;
            ends[1]=0;
            S227542=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
          df = true;
        }
        runClockDomain();
      }
      blVacOn.setpreclear();
      blRelease.setpreclear();
      blArmSource.setpreclear();
      blArmDest.setpreclear();
      cvMotInfeed.setpreclear();
      cvTakeFromPos1.setpreclear();
      cvMotOutfeed.setpreclear();
      cvInjectInfeed.setpreclear();
      cvInjectOutfeed.setpreclear();
      cvCollectFromEnd.setpreclear();
      rtRotaryTrigger.setpreclear();
      rtLoadPos1.setpreclear();
      rtUnloadExit.setpreclear();
      f1ValveOpen.setpreclear();
      f2ValveOpen.setpreclear();
      llPusherExtend.setpreclear();
      llVacOn.setpreclear();
      llArmSource.setpreclear();
      llArmDest.setpreclear();
      llRefill.setpreclear();
      cpScrewOn.setpreclear();
      lbApplyLabelExtend.setpreclear();
      lbApplyLabelRetract.setpreclear();
      lbRollerOnOff.setpreclear();
      spDiverterExtend.setpreclear();
      spDiverterRetract.setpreclear();
      spAdmitBottle.setpreclear();
      rcRecyclingConveyorMotor.setpreclear();
      rcInjectAtEntry.setpreclear();
      rcCollectAtReturn.setpreclear();
      lrCylZaxisExtend.setpreclear();
      lrUnscrewTurnExtend.setpreclear();
      lrUnscrewTurnRetract.setpreclear();
      lrLidGripperExtend.setpreclear();
      lrLidEjectExtend.setpreclear();
      ldCylClampBottleExtend.setpreclear();
      ldInvertRotateExtend.setpreclear();
      ldInvertRotateRetract.setpreclear();
      ldDrainValveOnOff.setpreclear();
      brMotorOnOff.setpreclear();
      brTransferArmExtend.setpreclear();
      brTransferArmRetract.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      blVacOn.sethook();
      blVacOn.setClear();
      blRelease.sethook();
      blRelease.setClear();
      blArmSource.sethook();
      blArmSource.setClear();
      blArmDest.sethook();
      blArmDest.setClear();
      cvMotInfeed.sethook();
      cvMotInfeed.setClear();
      cvTakeFromPos1.sethook();
      cvTakeFromPos1.setClear();
      cvMotOutfeed.sethook();
      cvMotOutfeed.setClear();
      cvInjectInfeed.sethook();
      cvInjectInfeed.setClear();
      cvInjectOutfeed.sethook();
      cvInjectOutfeed.setClear();
      cvCollectFromEnd.sethook();
      cvCollectFromEnd.setClear();
      rtRotaryTrigger.sethook();
      rtRotaryTrigger.setClear();
      rtLoadPos1.sethook();
      rtLoadPos1.setClear();
      rtUnloadExit.sethook();
      rtUnloadExit.setClear();
      f1ValveOpen.sethook();
      f1ValveOpen.setClear();
      f2ValveOpen.sethook();
      f2ValveOpen.setClear();
      llPusherExtend.sethook();
      llPusherExtend.setClear();
      llVacOn.sethook();
      llVacOn.setClear();
      llArmSource.sethook();
      llArmSource.setClear();
      llArmDest.sethook();
      llArmDest.setClear();
      llRefill.sethook();
      llRefill.setClear();
      cpScrewOn.sethook();
      cpScrewOn.setClear();
      lbApplyLabelExtend.sethook();
      lbApplyLabelExtend.setClear();
      lbApplyLabelRetract.sethook();
      lbApplyLabelRetract.setClear();
      lbRollerOnOff.sethook();
      lbRollerOnOff.setClear();
      spDiverterExtend.sethook();
      spDiverterExtend.setClear();
      spDiverterRetract.sethook();
      spDiverterRetract.setClear();
      spAdmitBottle.sethook();
      spAdmitBottle.setClear();
      rcRecyclingConveyorMotor.sethook();
      rcRecyclingConveyorMotor.setClear();
      rcInjectAtEntry.sethook();
      rcInjectAtEntry.setClear();
      rcCollectAtReturn.sethook();
      rcCollectAtReturn.setClear();
      lrCylZaxisExtend.sethook();
      lrCylZaxisExtend.setClear();
      lrUnscrewTurnExtend.sethook();
      lrUnscrewTurnExtend.setClear();
      lrUnscrewTurnRetract.sethook();
      lrUnscrewTurnRetract.setClear();
      lrLidGripperExtend.sethook();
      lrLidGripperExtend.setClear();
      lrLidEjectExtend.sethook();
      lrLidEjectExtend.setClear();
      ldCylClampBottleExtend.sethook();
      ldCylClampBottleExtend.setClear();
      ldInvertRotateExtend.sethook();
      ldInvertRotateExtend.setClear();
      ldInvertRotateRetract.sethook();
      ldInvertRotateRetract.setClear();
      ldDrainValveOnOff.sethook();
      ldDrainValveOnOff.setClear();
      brMotorOnOff.sethook();
      brMotorOnOff.setClear();
      brTransferArmExtend.sethook();
      brTransferArmExtend.setClear();
      brTransferArmRetract.sethook();
      brTransferArmRetract.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
