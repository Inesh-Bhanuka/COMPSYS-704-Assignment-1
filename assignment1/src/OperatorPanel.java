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
  private int S226255 = 1;
  private int S225581 = 1;
  private int S225527 = 1;
  private int S225790 = 1;
  private int S225822 = 1;
  private int S225830 = 1;
  private int S225838 = 1;
  private int S225948 = 1;
  private int S225956 = 1;
  private int S225988 = 1;
  private int S226020 = 1;
  private int S226052 = 1;
  private int S226162 = 1;
  private int S226221 = 1;
  private int S226253 = 1;
  
  private int[] ends = new int[15];
  private int[] tdone = new int[15];
  
  public void thread226283(int [] tdone, int [] ends){
        switch(S226253){
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

  public void thread226282(int [] tdone, int [] ends){
        switch(S226221){
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

  public void thread226281(int [] tdone, int [] ends){
        switch(S226162){
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

  public void thread226280(int [] tdone, int [] ends){
        switch(S226052){
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

  public void thread226279(int [] tdone, int [] ends){
        switch(S226020){
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

  public void thread226278(int [] tdone, int [] ends){
        switch(S225988){
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

  public void thread226277(int [] tdone, int [] ends){
        switch(S225956){
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

  public void thread226276(int [] tdone, int [] ends){
        switch(S225948){
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

  public void thread226275(int [] tdone, int [] ends){
        switch(S225838){
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

  public void thread226274(int [] tdone, int [] ends){
        switch(S225830){
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

  public void thread226273(int [] tdone, int [] ends){
        switch(S225822){
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

  public void thread226272(int [] tdone, int [] ends){
        switch(S225790){
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

  public void thread226271(int [] tdone, int [] ends){
        switch(S225581){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S225527){
          case 0 : 
            S225527=0;
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
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
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
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
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
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
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
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
              }
            }
            break;
          
          case 1 : 
            S225527=1;
            S225527=0;
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
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
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
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
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
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
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
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
                    blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
                    currsigs.addElement(blArmDest);
                    S225527=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S225527=1;
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

  public void thread226269(int [] tdone, int [] ends){
        S226253=1;
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

  public void thread226268(int [] tdone, int [] ends){
        S226221=1;
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

  public void thread226267(int [] tdone, int [] ends){
        S226162=1;
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

  public void thread226266(int [] tdone, int [] ends){
        S226052=1;
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

  public void thread226265(int [] tdone, int [] ends){
        S226020=1;
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

  public void thread226264(int [] tdone, int [] ends){
        S225988=1;
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

  public void thread226263(int [] tdone, int [] ends){
        S225956=1;
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

  public void thread226262(int [] tdone, int [] ends){
        S225948=1;
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

  public void thread226261(int [] tdone, int [] ends){
        S225838=1;
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

  public void thread226260(int [] tdone, int [] ends){
        S225830=1;
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

  public void thread226259(int [] tdone, int [] ends){
        S225822=1;
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

  public void thread226258(int [] tdone, int [] ends){
        S225790=1;
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

  public void thread226257(int [] tdone, int [] ends){
        S225581=1;
    S225527=0;
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
            S225527=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S225527=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
        }
        else {
          if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
            blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
            currsigs.addElement(blArmDest);
            S225527=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S225527=1;
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
            S225527=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S225527=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
        }
        else {
          if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
            blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
            currsigs.addElement(blArmDest);
            S225527=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S225527=1;
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
            S225527=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S225527=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
        }
        else {
          if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
            blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
            currsigs.addElement(blArmDest);
            S225527=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S225527=1;
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
            S225527=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S225527=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
        }
        else {
          if(ManualDrive.held("bl.armDest")){//sysj\operatorPanel.sysj line: 42, column: 4
            blArmDest.setPresent();//sysj\operatorPanel.sysj line: 42, column: 40
            currsigs.addElement(blArmDest);
            S225527=1;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            S225527=1;
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
      switch(S226255){
        case 0 : 
          S226255=0;
          break RUN;
        
        case 1 : 
          S226255=2;
          S226255=2;
          thread226257(tdone,ends);
          thread226258(tdone,ends);
          thread226259(tdone,ends);
          thread226260(tdone,ends);
          thread226261(tdone,ends);
          thread226262(tdone,ends);
          thread226263(tdone,ends);
          thread226264(tdone,ends);
          thread226265(tdone,ends);
          thread226266(tdone,ends);
          thread226267(tdone,ends);
          thread226268(tdone,ends);
          thread226269(tdone,ends);
          int biggest226270 = 0;
          if(ends[2]>=biggest226270){
            biggest226270=ends[2];
          }
          if(ends[3]>=biggest226270){
            biggest226270=ends[3];
          }
          if(ends[4]>=biggest226270){
            biggest226270=ends[4];
          }
          if(ends[5]>=biggest226270){
            biggest226270=ends[5];
          }
          if(ends[6]>=biggest226270){
            biggest226270=ends[6];
          }
          if(ends[7]>=biggest226270){
            biggest226270=ends[7];
          }
          if(ends[8]>=biggest226270){
            biggest226270=ends[8];
          }
          if(ends[9]>=biggest226270){
            biggest226270=ends[9];
          }
          if(ends[10]>=biggest226270){
            biggest226270=ends[10];
          }
          if(ends[11]>=biggest226270){
            biggest226270=ends[11];
          }
          if(ends[12]>=biggest226270){
            biggest226270=ends[12];
          }
          if(ends[13]>=biggest226270){
            biggest226270=ends[13];
          }
          if(ends[14]>=biggest226270){
            biggest226270=ends[14];
          }
          if(biggest226270 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread226271(tdone,ends);
          thread226272(tdone,ends);
          thread226273(tdone,ends);
          thread226274(tdone,ends);
          thread226275(tdone,ends);
          thread226276(tdone,ends);
          thread226277(tdone,ends);
          thread226278(tdone,ends);
          thread226279(tdone,ends);
          thread226280(tdone,ends);
          thread226281(tdone,ends);
          thread226282(tdone,ends);
          thread226283(tdone,ends);
          int biggest226284 = 0;
          if(ends[2]>=biggest226284){
            biggest226284=ends[2];
          }
          if(ends[3]>=biggest226284){
            biggest226284=ends[3];
          }
          if(ends[4]>=biggest226284){
            biggest226284=ends[4];
          }
          if(ends[5]>=biggest226284){
            biggest226284=ends[5];
          }
          if(ends[6]>=biggest226284){
            biggest226284=ends[6];
          }
          if(ends[7]>=biggest226284){
            biggest226284=ends[7];
          }
          if(ends[8]>=biggest226284){
            biggest226284=ends[8];
          }
          if(ends[9]>=biggest226284){
            biggest226284=ends[9];
          }
          if(ends[10]>=biggest226284){
            biggest226284=ends[10];
          }
          if(ends[11]>=biggest226284){
            biggest226284=ends[11];
          }
          if(ends[12]>=biggest226284){
            biggest226284=ends[12];
          }
          if(ends[13]>=biggest226284){
            biggest226284=ends[13];
          }
          if(ends[14]>=biggest226284){
            biggest226284=ends[14];
          }
          if(biggest226284 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest226284 == 0){
            S226255=0;
            active[1]=0;
            ends[1]=0;
            S226255=0;
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
