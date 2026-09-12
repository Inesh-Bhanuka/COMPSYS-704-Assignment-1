import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class RecyclingStationController extends ClockDomain{
  public RecyclingStationController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal operatorPermit = new Signal("operatorPermit", Signal.INPUT);
  public Signal recyclingStatus = new Signal("recyclingStatus", Signal.OUTPUT);
  public input_Channel bottleRejected_in = new input_Channel();
  public input_Channel statusConveyor_in = new input_Channel();
  public input_Channel statusLidRemoval_in = new input_Channel();
  public input_Channel statusDumper_in = new input_Channel();
  public input_Channel statusReturn_in = new input_Channel();
  public output_Channel bottleRecycled_o = new output_Channel();
  public output_Channel enableLidRemoval_o = new output_Channel();
  public output_Channel enableDumper_o = new output_Channel();
  public output_Channel enableReturn_o = new output_Channel();
  public output_Channel enableConveyor_o = new output_Channel();
  private Signal stationState_1;
  private int cur_thread_2;//sysj\recyclingStationController.sysj line: 101, column: 3
  private RecyclingQueue q_thread_3;//sysj\recyclingStationController.sysj line: 118, column: 3
  private RecyclingRecord m_thread_3;//sysj\recyclingStationController.sysj line: 119, column: 3
  private WorkpieceTwin w_thread_3;//sysj\recyclingStationController.sysj line: 120, column: 3
  private RecyclingQueue q_thread_4;//sysj\recyclingStationController.sysj line: 135, column: 3
  private RecyclingRecord m_thread_4;//sysj\recyclingStationController.sysj line: 136, column: 3
  private int TO_LID_thread_4;//sysj\recyclingStationController.sysj line: 139, column: 3
  private int TO_DUMP_thread_4;//sysj\recyclingStationController.sysj line: 140, column: 3
  private int TO_RETURN_thread_4;//sysj\recyclingStationController.sysj line: 141, column: 3
  private int DISCHARGE_thread_4;//sysj\recyclingStationController.sysj line: 142, column: 3
  private WorkpieceTwin w_thread_4;//sysj\recyclingStationController.sysj line: 144, column: 3
  private boolean permitted_thread_4;//sysj\recyclingStationController.sysj line: 145, column: 3
  private int S271004 = 1;
  private int S264554 = 1;
  private int S264982 = 1;
  private int S264626 = 1;
  private int S264566 = 1;
  private int S264561 = 1;
  private int S271002 = 1;
  private int S264988 = 1;
  private int S265009 = 1;
  private int S265004 = 1;
  private int S265053 = 1;
  private int S265048 = 1;
  private int S265141 = 1;
  private int S265136 = 1;
  private int S265185 = 1;
  private int S265180 = 1;
  private int S265273 = 1;
  private int S265268 = 1;
  private int S265317 = 1;
  private int S265312 = 1;
  private int S265405 = 1;
  private int S265400 = 1;
  private int S265449 = 1;
  private int S265444 = 1;
  private int S265537 = 1;
  private int S265532 = 1;
  private int S265581 = 1;
  private int S265576 = 1;
  private int S265669 = 1;
  private int S265664 = 1;
  private int S265713 = 1;
  private int S265708 = 1;
  private int S265801 = 1;
  private int S265796 = 1;
  private int S265845 = 1;
  private int S265840 = 1;
  private int S265933 = 1;
  private int S265928 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread271012(int [] tdone, int [] ends){
        switch(S271002){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S264988){
          case 0 : 
            if(!q_thread_4.hasWork()){//sysj\recyclingStationController.sysj line: 150, column: 10
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj\recyclingStationController.sysj line: 150, column: 4
              w_thread_4 = q_thread_4.take();//sysj\recyclingStationController.sysj line: 154, column: 4
              m_thread_4.beginCycle(w_thread_4);//sysj\recyclingStationController.sysj line: 155, column: 4
              stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 156, column: 4
              currsigs.addElement(stationState_1);
              stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 156, column: 4
              permitted_thread_4 = false;//sysj\recyclingStationController.sysj line: 161, column: 4
              S264988=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            S264988=1;
            S264988=2;
            if(!permitted_thread_4){//sysj\recyclingStationController.sysj line: 163, column: 10
              permitted_thread_4 = GuiStep.take("RECYCLE", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\recyclingStationController.sysj line: 164, column: 5
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj\recyclingStationController.sysj line: 163, column: 4
              S264988=3;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 2 : 
            if(!permitted_thread_4){//sysj\recyclingStationController.sysj line: 163, column: 10
              permitted_thread_4 = GuiStep.take("RECYCLE", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\recyclingStationController.sysj line: 164, column: 5
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj\recyclingStationController.sysj line: 163, column: 4
              S264988=3;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 3 : 
            S264988=3;
            S264988=4;
            S265009=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 170, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 170, column: 4
              S265009=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S265004=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 170, column: 4
                enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 170, column: 4
                S265004=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 170, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 170, column: 4
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 170, column: 4
                  S264988=5;
                  S265053=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 171, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                    S265053=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S265048=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 171, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 171, column: 4
                      S265048=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 171, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 171, column: 4
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 172, column: 4
                        S264988=6;
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
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                }
                else {
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            break;
          
          case 4 : 
            switch(S265009){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 170, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 170, column: 4
                  S265009=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265004){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 170, column: 4
                        enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 170, column: 4
                        S265004=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 170, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 170, column: 4
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 170, column: 4
                          S264988=5;
                          S265053=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 171, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                            S265053=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S265048=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 171, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 171, column: 4
                              S265048=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 171, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 171, column: 4
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 172, column: 4
                                S264988=6;
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
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 170, column: 4
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 170, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 170, column: 4
                        S264988=5;
                        S265053=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 171, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                          S265053=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S265048=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 171, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 171, column: 4
                            S265048=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 171, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 171, column: 4
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 172, column: 4
                              S264988=6;
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
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S265009=1;
                S265009=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 170, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 170, column: 4
                  S265009=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265004=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 170, column: 4
                    enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 170, column: 4
                    S265004=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 170, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 170, column: 4
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 170, column: 4
                      S264988=5;
                      S265053=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 171, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                        S265053=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S265048=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 171, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 171, column: 4
                          S265048=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 171, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 171, column: 4
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 172, column: 4
                            S264988=6;
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
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 5 : 
            switch(S265053){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 171, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                  S265053=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265048){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 171, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 171, column: 4
                        S265048=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 171, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 171, column: 4
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 172, column: 4
                          S264988=6;
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
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 171, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 171, column: 4
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 172, column: 4
                        S264988=6;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S265053=1;
                S265053=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 171, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                  S265053=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265048=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 171, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 171, column: 4
                    S265048=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 171, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 171, column: 4
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 172, column: 4
                      S264988=6;
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
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 6 : 
            S264988=6;
            S264988=7;
            S265141=0;
            if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 176, column: 4
              enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 176, column: 4
              S265141=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S265136=0;
              if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 176, column: 4
                enableLidRemoval_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 176, column: 4
                S265136=1;
                if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 176, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 176, column: 4
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 176, column: 4
                  S264988=8;
                  S265185=0;
                  if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 177, column: 4
                    statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                    S265185=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S265180=0;
                    if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 177, column: 4
                      statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 177, column: 4
                      S265180=1;
                      if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 177, column: 4
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 177, column: 4
                        m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 178, column: 4
                        S264988=9;
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
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                }
                else {
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            break;
          
          case 7 : 
            switch(S265141){
              case 0 : 
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 176, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 176, column: 4
                  S265141=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265136){
                    case 0 : 
                      if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 176, column: 4
                        enableLidRemoval_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 176, column: 4
                        S265136=1;
                        if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 176, column: 4
                          enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 176, column: 4
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 176, column: 4
                          S264988=8;
                          S265185=0;
                          if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 177, column: 4
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                            S265185=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S265180=0;
                            if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 177, column: 4
                              statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 177, column: 4
                              S265180=1;
                              if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 177, column: 4
                                statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 177, column: 4
                                m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 178, column: 4
                                S264988=9;
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
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 176, column: 4
                        enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 176, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 176, column: 4
                        S264988=8;
                        S265185=0;
                        if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 177, column: 4
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                          S265185=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S265180=0;
                          if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 177, column: 4
                            statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 177, column: 4
                            S265180=1;
                            if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 177, column: 4
                              statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 177, column: 4
                              m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 178, column: 4
                              S264988=9;
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
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S265141=1;
                S265141=0;
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 176, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 176, column: 4
                  S265141=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265136=0;
                  if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 176, column: 4
                    enableLidRemoval_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 176, column: 4
                    S265136=1;
                    if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 176, column: 4
                      enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 176, column: 4
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 176, column: 4
                      S264988=8;
                      S265185=0;
                      if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 177, column: 4
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                        S265185=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S265180=0;
                        if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 177, column: 4
                          statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 177, column: 4
                          S265180=1;
                          if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 177, column: 4
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 177, column: 4
                            m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 178, column: 4
                            S264988=9;
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
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 8 : 
            switch(S265185){
              case 0 : 
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 177, column: 4
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                  S265185=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265180){
                    case 0 : 
                      if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 177, column: 4
                        statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 177, column: 4
                        S265180=1;
                        if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 177, column: 4
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 177, column: 4
                          m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 178, column: 4
                          S264988=9;
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
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 177, column: 4
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 177, column: 4
                        m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 178, column: 4
                        S264988=9;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S265185=1;
                S265185=0;
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 177, column: 4
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                  S265185=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265180=0;
                  if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 177, column: 4
                    statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 177, column: 4
                    S265180=1;
                    if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 177, column: 4
                      statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 177, column: 4
                      m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 178, column: 4
                      S264988=9;
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
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 9 : 
            S264988=9;
            S264988=10;
            S265273=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 182, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 182, column: 4
              S265273=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S265268=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 182, column: 4
                enableConveyor_o.setVal(new Integer(TO_DUMP_thread_4));//sysj\recyclingStationController.sysj line: 182, column: 4
                S265268=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 182, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 182, column: 4
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 182, column: 4
                  S264988=11;
                  S265317=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 183, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                    S265317=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S265312=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 183, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 183, column: 4
                      S265312=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 183, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 183, column: 4
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 184, column: 4
                        S264988=12;
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
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                }
                else {
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            break;
          
          case 10 : 
            switch(S265273){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 182, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 182, column: 4
                  S265273=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265268){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 182, column: 4
                        enableConveyor_o.setVal(new Integer(TO_DUMP_thread_4));//sysj\recyclingStationController.sysj line: 182, column: 4
                        S265268=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 182, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 182, column: 4
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 182, column: 4
                          S264988=11;
                          S265317=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 183, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                            S265317=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S265312=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 183, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 183, column: 4
                              S265312=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 183, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 183, column: 4
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 184, column: 4
                                S264988=12;
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
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 182, column: 4
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 182, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 182, column: 4
                        S264988=11;
                        S265317=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 183, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                          S265317=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S265312=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 183, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 183, column: 4
                            S265312=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 183, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 183, column: 4
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 184, column: 4
                              S264988=12;
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
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S265273=1;
                S265273=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 182, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 182, column: 4
                  S265273=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265268=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 182, column: 4
                    enableConveyor_o.setVal(new Integer(TO_DUMP_thread_4));//sysj\recyclingStationController.sysj line: 182, column: 4
                    S265268=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 182, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 182, column: 4
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 182, column: 4
                      S264988=11;
                      S265317=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 183, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                        S265317=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S265312=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 183, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 183, column: 4
                          S265312=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 183, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 183, column: 4
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 184, column: 4
                            S264988=12;
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
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 11 : 
            switch(S265317){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 183, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                  S265317=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265312){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 183, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 183, column: 4
                        S265312=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 183, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 183, column: 4
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 184, column: 4
                          S264988=12;
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
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 183, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 183, column: 4
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 184, column: 4
                        S264988=12;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S265317=1;
                S265317=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 183, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                  S265317=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265312=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 183, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 183, column: 4
                    S265312=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 183, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 183, column: 4
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 184, column: 4
                      S264988=12;
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
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 12 : 
            S264988=12;
            S264988=13;
            S265405=0;
            if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 188, column: 4
              enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 188, column: 4
              S265405=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S265400=0;
              if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 188, column: 4
                enableDumper_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 188, column: 4
                S265400=1;
                if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 188, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 188, column: 4
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 188, column: 4
                  S264988=14;
                  S265449=0;
                  if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 189, column: 4
                    statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 189, column: 4
                    S265449=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S265444=0;
                    if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 189, column: 4
                      statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 189, column: 4
                      S265444=1;
                      if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 189, column: 4
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 189, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 189, column: 4
                        m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 190, column: 4
                        S264988=15;
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
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                }
                else {
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            break;
          
          case 13 : 
            switch(S265405){
              case 0 : 
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 188, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 188, column: 4
                  S265405=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265400){
                    case 0 : 
                      if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 188, column: 4
                        enableDumper_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 188, column: 4
                        S265400=1;
                        if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 188, column: 4
                          enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 188, column: 4
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 188, column: 4
                          S264988=14;
                          S265449=0;
                          if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 189, column: 4
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 189, column: 4
                            S265449=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S265444=0;
                            if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 189, column: 4
                              statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 189, column: 4
                              S265444=1;
                              if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 189, column: 4
                                statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 189, column: 4
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 189, column: 4
                                m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 190, column: 4
                                S264988=15;
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
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 188, column: 4
                        enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 188, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 188, column: 4
                        S264988=14;
                        S265449=0;
                        if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 189, column: 4
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 189, column: 4
                          S265449=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S265444=0;
                          if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 189, column: 4
                            statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 189, column: 4
                            S265444=1;
                            if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 189, column: 4
                              statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 189, column: 4
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 189, column: 4
                              m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 190, column: 4
                              S264988=15;
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
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S265405=1;
                S265405=0;
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 188, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 188, column: 4
                  S265405=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265400=0;
                  if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 188, column: 4
                    enableDumper_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 188, column: 4
                    S265400=1;
                    if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 188, column: 4
                      enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 188, column: 4
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 188, column: 4
                      S264988=14;
                      S265449=0;
                      if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 189, column: 4
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 189, column: 4
                        S265449=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S265444=0;
                        if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 189, column: 4
                          statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 189, column: 4
                          S265444=1;
                          if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 189, column: 4
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 189, column: 4
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 189, column: 4
                            m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 190, column: 4
                            S264988=15;
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
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 14 : 
            switch(S265449){
              case 0 : 
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 189, column: 4
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 189, column: 4
                  S265449=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265444){
                    case 0 : 
                      if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 189, column: 4
                        statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 189, column: 4
                        S265444=1;
                        if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 189, column: 4
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 189, column: 4
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 189, column: 4
                          m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 190, column: 4
                          S264988=15;
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
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 189, column: 4
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 189, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 189, column: 4
                        m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 190, column: 4
                        S264988=15;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S265449=1;
                S265449=0;
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 189, column: 4
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 189, column: 4
                  S265449=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265444=0;
                  if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 189, column: 4
                    statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 189, column: 4
                    S265444=1;
                    if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 189, column: 4
                      statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 189, column: 4
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 189, column: 4
                      m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 190, column: 4
                      S264988=15;
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
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 15 : 
            S264988=15;
            S264988=16;
            S265537=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 194, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 194, column: 4
              S265537=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S265532=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 194, column: 4
                enableConveyor_o.setVal(new Integer(TO_RETURN_thread_4));//sysj\recyclingStationController.sysj line: 194, column: 4
                S265532=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 194, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 194, column: 4
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 194, column: 4
                  S264988=17;
                  S265581=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 195, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 195, column: 4
                    S265581=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S265576=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 195, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 195, column: 4
                      S265576=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 195, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 195, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 195, column: 4
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 196, column: 4
                        S264988=18;
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
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                }
                else {
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            break;
          
          case 16 : 
            switch(S265537){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 194, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 194, column: 4
                  S265537=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265532){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 194, column: 4
                        enableConveyor_o.setVal(new Integer(TO_RETURN_thread_4));//sysj\recyclingStationController.sysj line: 194, column: 4
                        S265532=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 194, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 194, column: 4
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 194, column: 4
                          S264988=17;
                          S265581=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 195, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 195, column: 4
                            S265581=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S265576=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 195, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 195, column: 4
                              S265576=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 195, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 195, column: 4
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 195, column: 4
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 196, column: 4
                                S264988=18;
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
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 194, column: 4
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 194, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 194, column: 4
                        S264988=17;
                        S265581=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 195, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 195, column: 4
                          S265581=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S265576=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 195, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 195, column: 4
                            S265576=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 195, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 195, column: 4
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 195, column: 4
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 196, column: 4
                              S264988=18;
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
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S265537=1;
                S265537=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 194, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 194, column: 4
                  S265537=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265532=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 194, column: 4
                    enableConveyor_o.setVal(new Integer(TO_RETURN_thread_4));//sysj\recyclingStationController.sysj line: 194, column: 4
                    S265532=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 194, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 194, column: 4
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 194, column: 4
                      S264988=17;
                      S265581=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 195, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 195, column: 4
                        S265581=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S265576=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 195, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 195, column: 4
                          S265576=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 195, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 195, column: 4
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 195, column: 4
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 196, column: 4
                            S264988=18;
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
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 17 : 
            switch(S265581){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 195, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 195, column: 4
                  S265581=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265576){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 195, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 195, column: 4
                        S265576=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 195, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 195, column: 4
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 195, column: 4
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 196, column: 4
                          S264988=18;
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
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 195, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 195, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 195, column: 4
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 196, column: 4
                        S264988=18;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S265581=1;
                S265581=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 195, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 195, column: 4
                  S265581=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265576=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 195, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 195, column: 4
                    S265576=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 195, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 195, column: 4
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 195, column: 4
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 196, column: 4
                      S264988=18;
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
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 18 : 
            S264988=18;
            S264988=19;
            S265669=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 200, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 200, column: 4
              S265669=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S265664=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 200, column: 4
                enableConveyor_o.setVal(new Integer(DISCHARGE_thread_4));//sysj\recyclingStationController.sysj line: 200, column: 4
                S265664=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 200, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 200, column: 4
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 200, column: 4
                  S264988=20;
                  S265713=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 201, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 201, column: 4
                    S265713=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S265708=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 201, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 201, column: 4
                      S265708=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 201, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 201, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 201, column: 4
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 202, column: 4
                        S264988=21;
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
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                }
                else {
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            break;
          
          case 19 : 
            switch(S265669){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 200, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 200, column: 4
                  S265669=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265664){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 200, column: 4
                        enableConveyor_o.setVal(new Integer(DISCHARGE_thread_4));//sysj\recyclingStationController.sysj line: 200, column: 4
                        S265664=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 200, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 200, column: 4
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 200, column: 4
                          S264988=20;
                          S265713=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 201, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 201, column: 4
                            S265713=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S265708=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 201, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 201, column: 4
                              S265708=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 201, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 201, column: 4
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 201, column: 4
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 202, column: 4
                                S264988=21;
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
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 200, column: 4
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 200, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 200, column: 4
                        S264988=20;
                        S265713=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 201, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 201, column: 4
                          S265713=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S265708=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 201, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 201, column: 4
                            S265708=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 201, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 201, column: 4
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 201, column: 4
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 202, column: 4
                              S264988=21;
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
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S265669=1;
                S265669=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 200, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 200, column: 4
                  S265669=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265664=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 200, column: 4
                    enableConveyor_o.setVal(new Integer(DISCHARGE_thread_4));//sysj\recyclingStationController.sysj line: 200, column: 4
                    S265664=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 200, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 200, column: 4
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 200, column: 4
                      S264988=20;
                      S265713=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 201, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 201, column: 4
                        S265713=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S265708=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 201, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 201, column: 4
                          S265708=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 201, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 201, column: 4
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 201, column: 4
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 202, column: 4
                            S264988=21;
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
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 20 : 
            switch(S265713){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 201, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 201, column: 4
                  S265713=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265708){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 201, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 201, column: 4
                        S265708=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 201, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 201, column: 4
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 201, column: 4
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 202, column: 4
                          S264988=21;
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
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 201, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 201, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 201, column: 4
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 202, column: 4
                        S264988=21;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S265713=1;
                S265713=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 201, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 201, column: 4
                  S265713=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265708=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 201, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 201, column: 4
                    S265708=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 201, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 201, column: 4
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 201, column: 4
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 202, column: 4
                      S264988=21;
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
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 21 : 
            S264988=21;
            S264988=22;
            S265801=0;
            if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 206, column: 4
              enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 206, column: 4
              S265801=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S265796=0;
              if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 206, column: 4
                enableReturn_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 206, column: 4
                S265796=1;
                if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 206, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 206, column: 4
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 206, column: 4
                  S264988=23;
                  S265845=0;
                  if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 207, column: 4
                    statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 207, column: 4
                    S265845=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S265840=0;
                    if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 207, column: 4
                      statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 207, column: 4
                      S265840=1;
                      if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 207, column: 4
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 207, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 207, column: 4
                        m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 208, column: 4
                        S264988=24;
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
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                }
                else {
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            break;
          
          case 22 : 
            switch(S265801){
              case 0 : 
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 206, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 206, column: 4
                  S265801=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265796){
                    case 0 : 
                      if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 206, column: 4
                        enableReturn_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 206, column: 4
                        S265796=1;
                        if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 206, column: 4
                          enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 206, column: 4
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 206, column: 4
                          S264988=23;
                          S265845=0;
                          if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 207, column: 4
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 207, column: 4
                            S265845=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S265840=0;
                            if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 207, column: 4
                              statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 207, column: 4
                              S265840=1;
                              if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 207, column: 4
                                statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 207, column: 4
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 207, column: 4
                                m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 208, column: 4
                                S264988=24;
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
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                        }
                        else {
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 206, column: 4
                        enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 206, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 206, column: 4
                        S264988=23;
                        S265845=0;
                        if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 207, column: 4
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 207, column: 4
                          S265845=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S265840=0;
                          if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 207, column: 4
                            statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 207, column: 4
                            S265840=1;
                            if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 207, column: 4
                              statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 207, column: 4
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 207, column: 4
                              m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 208, column: 4
                              S264988=24;
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
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S265801=1;
                S265801=0;
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 206, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 206, column: 4
                  S265801=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265796=0;
                  if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 206, column: 4
                    enableReturn_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 206, column: 4
                    S265796=1;
                    if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 206, column: 4
                      enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 206, column: 4
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 206, column: 4
                      S264988=23;
                      S265845=0;
                      if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 207, column: 4
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 207, column: 4
                        S265845=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S265840=0;
                        if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 207, column: 4
                          statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 207, column: 4
                          S265840=1;
                          if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 207, column: 4
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 207, column: 4
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 207, column: 4
                            m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 208, column: 4
                            S264988=24;
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
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 23 : 
            switch(S265845){
              case 0 : 
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 207, column: 4
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 207, column: 4
                  S265845=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265840){
                    case 0 : 
                      if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 207, column: 4
                        statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 207, column: 4
                        S265840=1;
                        if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 207, column: 4
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 207, column: 4
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 207, column: 4
                          m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 208, column: 4
                          S264988=24;
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
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 207, column: 4
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 207, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 207, column: 4
                        m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 208, column: 4
                        S264988=24;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S265845=1;
                S265845=0;
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 207, column: 4
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 207, column: 4
                  S265845=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265840=0;
                  if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 207, column: 4
                    statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 207, column: 4
                    S265840=1;
                    if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 207, column: 4
                      statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 207, column: 4
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 207, column: 4
                      m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 208, column: 4
                      S264988=24;
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
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 24 : 
            S264988=24;
            m_thread_4.recovered(w_thread_4);//sysj\recyclingStationController.sysj line: 212, column: 4
            S264988=25;
            S265933=0;
            if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 213, column: 4
              bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 213, column: 4
              S265933=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S265928=0;
              if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 213, column: 4
                bottleRecycled_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 213, column: 4
                S265928=1;
                if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 213, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 213, column: 4
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 213, column: 4
                  S264988=26;
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
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            break;
          
          case 25 : 
            switch(S265933){
              case 0 : 
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 213, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 213, column: 4
                  S265933=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265928){
                    case 0 : 
                      if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 213, column: 4
                        bottleRecycled_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 213, column: 4
                        S265928=1;
                        if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 213, column: 4
                          bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 213, column: 4
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 213, column: 4
                          S264988=26;
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
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 213, column: 4
                        bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 213, column: 4
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 213, column: 4
                        S264988=26;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S265933=1;
                S265933=0;
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 213, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 213, column: 4
                  S265933=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265928=0;
                  if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 213, column: 4
                    bottleRecycled_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 213, column: 4
                    S265928=1;
                    if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 213, column: 4
                      bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 213, column: 4
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 213, column: 4
                      S264988=26;
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
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 26 : 
            S264988=26;
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 218, column: 4
            currsigs.addElement(stationState_1);
            stationState_1.setValue(m_thread_4.levelFor(q_thread_4.hasWork()));//sysj\recyclingStationController.sysj line: 218, column: 4
            S264988=27;
            if(m_thread_4.suspended()){//sysj\recyclingStationController.sysj line: 226, column: 4
              m_thread_4.reportSuspension();//sysj\recyclingStationController.sysj line: 227, column: 5
              stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 229, column: 6
              currsigs.addElement(stationState_1);
              stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 229, column: 6
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S264988=28;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 27 : 
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 229, column: 6
            currsigs.addElement(stationState_1);
            stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 229, column: 6
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 28 : 
            S264988=28;
            S264988=0;
            if(!q_thread_4.hasWork()){//sysj\recyclingStationController.sysj line: 150, column: 10
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj\recyclingStationController.sysj line: 150, column: 4
              w_thread_4 = q_thread_4.take();//sysj\recyclingStationController.sysj line: 154, column: 4
              m_thread_4.beginCycle(w_thread_4);//sysj\recyclingStationController.sysj line: 155, column: 4
              stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 156, column: 4
              currsigs.addElement(stationState_1);
              stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 156, column: 4
              permitted_thread_4 = false;//sysj\recyclingStationController.sysj line: 161, column: 4
              S264988=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread271011(int [] tdone, int [] ends){
        switch(S264982){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S264626){
          case 0 : 
            if(!q_thread_3.hasRoom()){//sysj\recyclingStationController.sysj line: 123, column: 10
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              ends[3]=2;
              ;//sysj\recyclingStationController.sysj line: 123, column: 4
              S264626=1;
              S264566=0;
              if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 4
                bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 126, column: 4
                S264566=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S264561=0;
                if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 126, column: 4
                  bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 126, column: 4
                  S264561=1;
                  if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 126, column: 4
                    bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 126, column: 4
                    ends[3]=2;
                    ;//sysj\recyclingStationController.sysj line: 126, column: 4
                    w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 127, column: 4
                    m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 128, column: 4
                    q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                    S264626=2;
                    active[3]=1;
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
            break;
          
          case 1 : 
            switch(S264566){
              case 0 : 
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 126, column: 4
                  S264566=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S264561){
                    case 0 : 
                      if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 126, column: 4
                        bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 126, column: 4
                        S264561=1;
                        if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 126, column: 4
                          bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 126, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 126, column: 4
                          w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 127, column: 4
                          m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 128, column: 4
                          q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                          S264626=2;
                          active[3]=1;
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
                      if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 126, column: 4
                        bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 126, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 126, column: 4
                        w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 127, column: 4
                        m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 128, column: 4
                        q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                        S264626=2;
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
                S264566=1;
                S264566=0;
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 126, column: 4
                  S264566=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S264561=0;
                  if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 126, column: 4
                    bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 126, column: 4
                    S264561=1;
                    if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 126, column: 4
                      bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 126, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 126, column: 4
                      w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 127, column: 4
                      m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 128, column: 4
                      q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                      S264626=2;
                      active[3]=1;
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
          
          case 2 : 
            S264626=2;
            S264626=0;
            if(!q_thread_3.hasRoom()){//sysj\recyclingStationController.sysj line: 123, column: 10
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              ends[3]=2;
              ;//sysj\recyclingStationController.sysj line: 123, column: 4
              S264626=1;
              S264566=0;
              if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 4
                bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 126, column: 4
                S264566=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S264561=0;
                if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 126, column: 4
                  bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 126, column: 4
                  S264561=1;
                  if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 126, column: 4
                    bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 126, column: 4
                    ends[3]=2;
                    ;//sysj\recyclingStationController.sysj line: 126, column: 4
                    w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 127, column: 4
                    m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 128, column: 4
                    q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                    S264626=2;
                    active[3]=1;
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
            break;
          
        }
        break;
      
    }
  }

  public void thread271010(int [] tdone, int [] ends){
        switch(S264554){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(stationState_1.getprestatus()){//sysj\recyclingStationController.sysj line: 103, column: 12
          cur_thread_2 = ((Integer)(stationState_1.getpreval() == null ? 0 : ((Integer)stationState_1.getpreval()).intValue())).intValue();//sysj\recyclingStationController.sysj line: 104, column: 5
          recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 106, column: 4
          currsigs.addElement(recyclingStatus);
          recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 106, column: 4
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 106, column: 4
          currsigs.addElement(recyclingStatus);
          recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 106, column: 4
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread271008(int [] tdone, int [] ends){
        S271002=1;
    q_thread_4 = RecyclingQueue.shared();//sysj\recyclingStationController.sysj line: 135, column: 3
    m_thread_4 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 136, column: 3
    TO_LID_thread_4 = 1;//sysj\recyclingStationController.sysj line: 139, column: 3
    TO_DUMP_thread_4 = 2;//sysj\recyclingStationController.sysj line: 140, column: 3
    TO_RETURN_thread_4 = 3;//sysj\recyclingStationController.sysj line: 141, column: 3
    DISCHARGE_thread_4 = 4;//sysj\recyclingStationController.sysj line: 142, column: 3
    w_thread_4 = null;//sysj\recyclingStationController.sysj line: 144, column: 3
    permitted_thread_4 = false;//sysj\recyclingStationController.sysj line: 145, column: 3
    S264988=0;
    if(!q_thread_4.hasWork()){//sysj\recyclingStationController.sysj line: 150, column: 10
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      ends[4]=2;
      ;//sysj\recyclingStationController.sysj line: 150, column: 4
      w_thread_4 = q_thread_4.take();//sysj\recyclingStationController.sysj line: 154, column: 4
      m_thread_4.beginCycle(w_thread_4);//sysj\recyclingStationController.sysj line: 155, column: 4
      stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 156, column: 4
      currsigs.addElement(stationState_1);
      stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 156, column: 4
      permitted_thread_4 = false;//sysj\recyclingStationController.sysj line: 161, column: 4
      S264988=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread271007(int [] tdone, int [] ends){
        S264982=1;
    q_thread_3 = RecyclingQueue.shared();//sysj\recyclingStationController.sysj line: 118, column: 3
    m_thread_3 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 119, column: 3
    w_thread_3 = null;//sysj\recyclingStationController.sysj line: 120, column: 3
    S264626=0;
    if(!q_thread_3.hasRoom()){//sysj\recyclingStationController.sysj line: 123, column: 10
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      ends[3]=2;
      ;//sysj\recyclingStationController.sysj line: 123, column: 4
      S264626=1;
      S264566=0;
      if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 4
        bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 126, column: 4
        S264566=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S264561=0;
        if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 126, column: 4
          bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 126, column: 4
          S264561=1;
          if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 126, column: 4
            bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 126, column: 4
            ends[3]=2;
            ;//sysj\recyclingStationController.sysj line: 126, column: 4
            w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 127, column: 4
            m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 128, column: 4
            q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
            S264626=2;
            active[3]=1;
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

  public void thread271006(int [] tdone, int [] ends){
        S264554=1;
    cur_thread_2 = 0;//sysj\recyclingStationController.sysj line: 101, column: 3
    if(stationState_1.getprestatus()){//sysj\recyclingStationController.sysj line: 103, column: 12
      cur_thread_2 = ((Integer)(stationState_1.getpreval() == null ? 0 : ((Integer)stationState_1.getpreval()).intValue())).intValue();//sysj\recyclingStationController.sysj line: 104, column: 5
      recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 106, column: 4
      currsigs.addElement(recyclingStatus);
      recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 106, column: 4
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
    else {
      recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 106, column: 4
      currsigs.addElement(recyclingStatus);
      recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 106, column: 4
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
      switch(S271004){
        case 0 : 
          S271004=0;
          break RUN;
        
        case 1 : 
          S271004=2;
          S271004=2;
          stationState_1.setClear();//sysj\recyclingStationController.sysj line: 98, column: 2
          thread271006(tdone,ends);
          thread271007(tdone,ends);
          thread271008(tdone,ends);
          int biggest271009 = 0;
          if(ends[2]>=biggest271009){
            biggest271009=ends[2];
          }
          if(ends[3]>=biggest271009){
            biggest271009=ends[3];
          }
          if(ends[4]>=biggest271009){
            biggest271009=ends[4];
          }
          if(biggest271009 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          stationState_1.setClear();//sysj\recyclingStationController.sysj line: 98, column: 2
          thread271010(tdone,ends);
          thread271011(tdone,ends);
          thread271012(tdone,ends);
          int biggest271013 = 0;
          if(ends[2]>=biggest271013){
            biggest271013=ends[2];
          }
          if(ends[3]>=biggest271013){
            biggest271013=ends[3];
          }
          if(ends[4]>=biggest271013){
            biggest271013=ends[4];
          }
          if(biggest271013 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest271013 == 0){
            S271004=0;
            active[1]=0;
            ends[1]=0;
            S271004=0;
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
    stationState_1 = new Signal();
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
          bottleRejected_in.gethook();
          statusConveyor_in.gethook();
          statusLidRemoval_in.gethook();
          statusDumper_in.gethook();
          statusReturn_in.gethook();
          bottleRecycled_o.gethook();
          enableLidRemoval_o.gethook();
          enableDumper_o.gethook();
          enableReturn_o.gethook();
          enableConveyor_o.gethook();
          operatorPermit.gethook();
          df = true;
        }
        runClockDomain();
      }
      operatorPermit.setpreclear();
      recyclingStatus.setpreclear();
      stationState_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = operatorPermit.getStatus() ? operatorPermit.setprepresent() : operatorPermit.setpreclear();
      operatorPermit.setpreval(operatorPermit.getValue());
      operatorPermit.setClear();
      recyclingStatus.sethook();
      recyclingStatus.setClear();
      stationState_1.setClear();
      bottleRejected_in.sethook();
      statusConveyor_in.sethook();
      statusLidRemoval_in.sethook();
      statusDumper_in.sethook();
      statusReturn_in.sethook();
      bottleRecycled_o.sethook();
      enableLidRemoval_o.sethook();
      enableDumper_o.sethook();
      enableReturn_o.sethook();
      enableConveyor_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleRejected_in.gethook();
        statusConveyor_in.gethook();
        statusLidRemoval_in.gethook();
        statusDumper_in.gethook();
        statusReturn_in.gethook();
        bottleRecycled_o.gethook();
        enableLidRemoval_o.gethook();
        enableDumper_o.gethook();
        enableReturn_o.gethook();
        enableConveyor_o.gethook();
        operatorPermit.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
