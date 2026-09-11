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
  public input_Channel statusSplitter_in = new input_Channel();
  public input_Channel statusConveyor_in = new input_Channel();
  public input_Channel statusLidRemoval_in = new input_Channel();
  public input_Channel statusDumper_in = new input_Channel();
  public input_Channel statusReturn_in = new input_Channel();
  public output_Channel bottleRecycled_o = new output_Channel();
  public output_Channel enableSplitter_o = new output_Channel();
  public output_Channel enableLidRemoval_o = new output_Channel();
  public output_Channel enableDumper_o = new output_Channel();
  public output_Channel enableReturn_o = new output_Channel();
  public output_Channel enableConveyor_o = new output_Channel();
  private Signal stationState_1;
  private int cur_thread_2;//sysj\recyclingStationController.sysj line: 80, column: 3
  private RecyclingRecord m_thread_3;//sysj\recyclingStationController.sysj line: 108, column: 3
  private int TO_LID_thread_3;//sysj\recyclingStationController.sysj line: 111, column: 3
  private int TO_DUMP_thread_3;//sysj\recyclingStationController.sysj line: 112, column: 3
  private int TO_RETURN_thread_3;//sysj\recyclingStationController.sysj line: 113, column: 3
  private int DISCHARGE_thread_3;//sysj\recyclingStationController.sysj line: 114, column: 3
  private WorkpieceTwin w_thread_3;//sysj\recyclingStationController.sysj line: 116, column: 3
  private boolean permitted_thread_3;//sysj\recyclingStationController.sysj line: 126, column: 1
  private int S207627 = 1;
  private int S200417 = 1;
  private int S207625 = 1;
  private int S200441 = 1;
  private int S200425 = 1;
  private int S200420 = 1;
  private int S200462 = 1;
  private int S200457 = 1;
  private int S200506 = 1;
  private int S200501 = 1;
  private int S200642 = 1;
  private int S200637 = 1;
  private int S200686 = 1;
  private int S200681 = 1;
  private int S200774 = 1;
  private int S200769 = 1;
  private int S200818 = 1;
  private int S200813 = 1;
  private int S200906 = 1;
  private int S200901 = 1;
  private int S200950 = 1;
  private int S200945 = 1;
  private int S201038 = 1;
  private int S201033 = 1;
  private int S201082 = 1;
  private int S201077 = 1;
  private int S201170 = 1;
  private int S201165 = 1;
  private int S201214 = 1;
  private int S201209 = 1;
  private int S201302 = 1;
  private int S201297 = 1;
  private int S201346 = 1;
  private int S201341 = 1;
  private int S201434 = 1;
  private int S201429 = 1;
  private int S201478 = 1;
  private int S201473 = 1;
  private int S201566 = 1;
  private int S201561 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread207633(int [] tdone, int [] ends){
        switch(S207625){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S200441){
          case 0 : 
            switch(S200425){
              case 0 : 
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 124, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
                  S200425=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S200420){
                    case 0 : 
                      if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
                        bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 124, column: 4
                        S200420=1;
                        if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
                          bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 124, column: 4
                          w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 125, column: 4
                          permitted_thread_3 = false;//sysj\recyclingStationController.sysj line: 126, column: 1
                          S200441=1;
                          active[3]=1;
                          ends[3]=1;
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
                      if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
                        bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 124, column: 4
                        w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 125, column: 4
                        permitted_thread_3 = false;//sysj\recyclingStationController.sysj line: 126, column: 1
                        S200441=1;
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
                S200425=1;
                S200425=0;
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 124, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
                  S200425=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S200420=0;
                  if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
                    bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 124, column: 4
                    S200420=1;
                    if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
                      bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 124, column: 4
                      w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 125, column: 4
                      permitted_thread_3 = false;//sysj\recyclingStationController.sysj line: 126, column: 1
                      S200441=1;
                      active[3]=1;
                      ends[3]=1;
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
          
          case 1 : 
            S200441=1;
            S200441=2;
            if(!permitted_thread_3){//sysj\recyclingStationController.sysj line: 128, column: 19
              permitted_thread_3 = GuiStep.take("RECYCLE", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\recyclingStationController.sysj line: 129, column: 17
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              ends[3]=2;
              ;//sysj\recyclingStationController.sysj line: 128, column: 13
              S200441=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            if(!permitted_thread_3){//sysj\recyclingStationController.sysj line: 128, column: 19
              permitted_thread_3 = GuiStep.take("RECYCLE", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\recyclingStationController.sysj line: 129, column: 17
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              ends[3]=2;
              ;//sysj\recyclingStationController.sysj line: 128, column: 13
              S200441=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            S200441=3;
            m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 134, column: 4
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 135, column: 4
            currsigs.addElement(stationState_1);
            stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 135, column: 4
            S200441=4;
            S200462=0;
            if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 138, column: 4
              enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 4
              S200462=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S200457=0;
              if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 4
                enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 138, column: 4
                S200457=1;
                if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 4
                  enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 138, column: 4
                  S200441=5;
                  S200506=0;
                  if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 4
                    statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                    S200506=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S200501=0;
                    if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                      statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 4
                      S200501=1;
                      if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                        statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 139, column: 4
                        m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 4
                        S200441=6;
                        if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 146, column: 4
                          m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 147, column: 5
                          stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 149, column: 6
                          currsigs.addElement(stationState_1);
                          stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 149, column: 6
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S200441=7;
                          active[3]=1;
                          ends[3]=1;
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
          
          case 4 : 
            switch(S200462){
              case 0 : 
                if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 138, column: 4
                  enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 4
                  S200462=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S200457){
                    case 0 : 
                      if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 4
                        enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 138, column: 4
                        S200457=1;
                        if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 4
                          enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 138, column: 4
                          S200441=5;
                          S200506=0;
                          if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 4
                            statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                            S200506=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S200501=0;
                            if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                              statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 4
                              S200501=1;
                              if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                                statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 139, column: 4
                                m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 4
                                S200441=6;
                                if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 146, column: 4
                                  m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 147, column: 5
                                  stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 149, column: 6
                                  currsigs.addElement(stationState_1);
                                  stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 149, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S200441=7;
                                  active[3]=1;
                                  ends[3]=1;
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
                      if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 4
                        enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 138, column: 4
                        S200441=5;
                        S200506=0;
                        if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 4
                          statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                          S200506=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S200501=0;
                          if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                            statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 4
                            S200501=1;
                            if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                              statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 139, column: 4
                              m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 4
                              S200441=6;
                              if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 146, column: 4
                                m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 147, column: 5
                                stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 149, column: 6
                                currsigs.addElement(stationState_1);
                                stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 149, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S200441=7;
                                active[3]=1;
                                ends[3]=1;
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
                S200462=1;
                S200462=0;
                if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 138, column: 4
                  enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 4
                  S200462=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S200457=0;
                  if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 4
                    enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 138, column: 4
                    S200457=1;
                    if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 4
                      enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 138, column: 4
                      S200441=5;
                      S200506=0;
                      if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 4
                        statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                        S200506=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S200501=0;
                        if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                          statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 4
                          S200501=1;
                          if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                            statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 139, column: 4
                            m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 4
                            S200441=6;
                            if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 146, column: 4
                              m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 147, column: 5
                              stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 149, column: 6
                              currsigs.addElement(stationState_1);
                              stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 149, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S200441=7;
                              active[3]=1;
                              ends[3]=1;
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
          
          case 5 : 
            switch(S200506){
              case 0 : 
                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 4
                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                  S200506=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S200501){
                    case 0 : 
                      if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                        statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 4
                        S200501=1;
                        if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                          statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 139, column: 4
                          m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 4
                          S200441=6;
                          if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 146, column: 4
                            m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 147, column: 5
                            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 149, column: 6
                            currsigs.addElement(stationState_1);
                            stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 149, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S200441=7;
                            active[3]=1;
                            ends[3]=1;
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
                      if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                        statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 139, column: 4
                        m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 4
                        S200441=6;
                        if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 146, column: 4
                          m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 147, column: 5
                          stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 149, column: 6
                          currsigs.addElement(stationState_1);
                          stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 149, column: 6
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S200441=7;
                          active[3]=1;
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
                S200506=1;
                S200506=0;
                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 4
                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                  S200506=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S200501=0;
                  if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                    statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 4
                    S200501=1;
                    if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                      statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 139, column: 4
                      m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 4
                      S200441=6;
                      if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 146, column: 4
                        m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 147, column: 5
                        stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 149, column: 6
                        currsigs.addElement(stationState_1);
                        stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 149, column: 6
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S200441=7;
                        active[3]=1;
                        ends[3]=1;
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
          
          case 6 : 
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 149, column: 6
            currsigs.addElement(stationState_1);
            stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 149, column: 6
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 7 : 
            S200441=7;
            S200441=8;
            S200642=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 156, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 4
              S200642=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S200637=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 4
                enableConveyor_o.setVal(new Integer(TO_LID_thread_3));//sysj\recyclingStationController.sysj line: 156, column: 4
                S200637=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 156, column: 4
                  S200441=9;
                  S200686=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                    S200686=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S200681=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 4
                      S200681=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 157, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 4
                        S200441=10;
                        active[3]=1;
                        ends[3]=1;
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
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 8 : 
            switch(S200642){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 156, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 4
                  S200642=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S200637){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 4
                        enableConveyor_o.setVal(new Integer(TO_LID_thread_3));//sysj\recyclingStationController.sysj line: 156, column: 4
                        S200637=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 156, column: 4
                          S200441=9;
                          S200686=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                            S200686=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S200681=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 4
                              S200681=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 157, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 4
                                S200441=10;
                                active[3]=1;
                                ends[3]=1;
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
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 4
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 156, column: 4
                        S200441=9;
                        S200686=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                          S200686=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S200681=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 4
                            S200681=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 157, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 4
                              S200441=10;
                              active[3]=1;
                              ends[3]=1;
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
                }
                break;
              
              case 1 : 
                S200642=1;
                S200642=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 156, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 4
                  S200642=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S200637=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 4
                    enableConveyor_o.setVal(new Integer(TO_LID_thread_3));//sysj\recyclingStationController.sysj line: 156, column: 4
                    S200637=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 156, column: 4
                      S200441=9;
                      S200686=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                        S200686=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S200681=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 4
                          S200681=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 157, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 4
                            S200441=10;
                            active[3]=1;
                            ends[3]=1;
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
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 9 : 
            switch(S200686){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                  S200686=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S200681){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 4
                        S200681=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 157, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 4
                          S200441=10;
                          active[3]=1;
                          ends[3]=1;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 157, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 4
                        S200441=10;
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
                S200686=1;
                S200686=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                  S200686=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S200681=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 4
                    S200681=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 157, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 4
                      S200441=10;
                      active[3]=1;
                      ends[3]=1;
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
          
          case 10 : 
            S200441=10;
            S200441=11;
            S200774=0;
            if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 162, column: 4
              enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 4
              S200774=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S200769=0;
              if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 4
                enableLidRemoval_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 162, column: 4
                S200769=1;
                if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 162, column: 4
                  S200441=12;
                  S200818=0;
                  if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 4
                    statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                    S200818=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S200813=0;
                    if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                      statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 4
                      S200813=1;
                      if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 163, column: 4
                        m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 4
                        S200441=13;
                        active[3]=1;
                        ends[3]=1;
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
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 11 : 
            switch(S200774){
              case 0 : 
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 162, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 4
                  S200774=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S200769){
                    case 0 : 
                      if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 4
                        enableLidRemoval_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 162, column: 4
                        S200769=1;
                        if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 4
                          enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 162, column: 4
                          S200441=12;
                          S200818=0;
                          if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 4
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                            S200818=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S200813=0;
                            if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                              statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 4
                              S200813=1;
                              if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                                statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 163, column: 4
                                m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 4
                                S200441=13;
                                active[3]=1;
                                ends[3]=1;
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
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 4
                        enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 162, column: 4
                        S200441=12;
                        S200818=0;
                        if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 4
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                          S200818=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S200813=0;
                          if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                            statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 4
                            S200813=1;
                            if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                              statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 163, column: 4
                              m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 4
                              S200441=13;
                              active[3]=1;
                              ends[3]=1;
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
                }
                break;
              
              case 1 : 
                S200774=1;
                S200774=0;
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 162, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 4
                  S200774=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S200769=0;
                  if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 4
                    enableLidRemoval_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 162, column: 4
                    S200769=1;
                    if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 4
                      enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 162, column: 4
                      S200441=12;
                      S200818=0;
                      if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 4
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                        S200818=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S200813=0;
                        if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                          statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 4
                          S200813=1;
                          if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 163, column: 4
                            m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 4
                            S200441=13;
                            active[3]=1;
                            ends[3]=1;
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
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 12 : 
            switch(S200818){
              case 0 : 
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 4
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                  S200818=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S200813){
                    case 0 : 
                      if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                        statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 4
                        S200813=1;
                        if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 163, column: 4
                          m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 4
                          S200441=13;
                          active[3]=1;
                          ends[3]=1;
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
                      if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 163, column: 4
                        m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 4
                        S200441=13;
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
                S200818=1;
                S200818=0;
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 4
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                  S200818=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S200813=0;
                  if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                    statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 4
                    S200813=1;
                    if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                      statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 163, column: 4
                      m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 4
                      S200441=13;
                      active[3]=1;
                      ends[3]=1;
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
          
          case 13 : 
            S200441=13;
            S200441=14;
            S200906=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 168, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 168, column: 4
              S200906=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S200901=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 168, column: 4
                enableConveyor_o.setVal(new Integer(TO_DUMP_thread_3));//sysj\recyclingStationController.sysj line: 168, column: 4
                S200901=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 168, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 168, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 168, column: 4
                  S200441=15;
                  S200950=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                    S200950=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S200945=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 169, column: 4
                      S200945=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 169, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 170, column: 4
                        S200441=16;
                        active[3]=1;
                        ends[3]=1;
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
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 14 : 
            switch(S200906){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 168, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 168, column: 4
                  S200906=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S200901){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 168, column: 4
                        enableConveyor_o.setVal(new Integer(TO_DUMP_thread_3));//sysj\recyclingStationController.sysj line: 168, column: 4
                        S200901=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 168, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 168, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 168, column: 4
                          S200441=15;
                          S200950=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                            S200950=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S200945=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 169, column: 4
                              S200945=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 169, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 170, column: 4
                                S200441=16;
                                active[3]=1;
                                ends[3]=1;
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
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 168, column: 4
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 168, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 168, column: 4
                        S200441=15;
                        S200950=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                          S200950=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S200945=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 169, column: 4
                            S200945=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 169, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 170, column: 4
                              S200441=16;
                              active[3]=1;
                              ends[3]=1;
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
                }
                break;
              
              case 1 : 
                S200906=1;
                S200906=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 168, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 168, column: 4
                  S200906=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S200901=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 168, column: 4
                    enableConveyor_o.setVal(new Integer(TO_DUMP_thread_3));//sysj\recyclingStationController.sysj line: 168, column: 4
                    S200901=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 168, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 168, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 168, column: 4
                      S200441=15;
                      S200950=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                        S200950=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S200945=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 169, column: 4
                          S200945=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 169, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 170, column: 4
                            S200441=16;
                            active[3]=1;
                            ends[3]=1;
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
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 15 : 
            switch(S200950){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                  S200950=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S200945){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 169, column: 4
                        S200945=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 169, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 170, column: 4
                          S200441=16;
                          active[3]=1;
                          ends[3]=1;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 169, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 170, column: 4
                        S200441=16;
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
                S200950=1;
                S200950=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                  S200950=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S200945=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 169, column: 4
                    S200945=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 169, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 170, column: 4
                      S200441=16;
                      active[3]=1;
                      ends[3]=1;
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
          
          case 16 : 
            S200441=16;
            S200441=17;
            S201038=0;
            if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 174, column: 4
              enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 174, column: 4
              S201038=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S201033=0;
              if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 174, column: 4
                enableDumper_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 174, column: 4
                S201033=1;
                if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 174, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 174, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 174, column: 4
                  S200441=18;
                  S201082=0;
                  if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 175, column: 4
                    statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                    S201082=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S201077=0;
                    if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                      statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 175, column: 4
                      S201077=1;
                      if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 175, column: 4
                        m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 176, column: 4
                        S200441=19;
                        active[3]=1;
                        ends[3]=1;
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
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 17 : 
            switch(S201038){
              case 0 : 
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 174, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 174, column: 4
                  S201038=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S201033){
                    case 0 : 
                      if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 174, column: 4
                        enableDumper_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 174, column: 4
                        S201033=1;
                        if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 174, column: 4
                          enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 174, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 174, column: 4
                          S200441=18;
                          S201082=0;
                          if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 175, column: 4
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                            S201082=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S201077=0;
                            if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                              statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 175, column: 4
                              S201077=1;
                              if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                                statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 175, column: 4
                                m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 176, column: 4
                                S200441=19;
                                active[3]=1;
                                ends[3]=1;
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
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 174, column: 4
                        enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 174, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 174, column: 4
                        S200441=18;
                        S201082=0;
                        if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 175, column: 4
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                          S201082=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S201077=0;
                          if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                            statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 175, column: 4
                            S201077=1;
                            if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                              statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 175, column: 4
                              m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 176, column: 4
                              S200441=19;
                              active[3]=1;
                              ends[3]=1;
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
                }
                break;
              
              case 1 : 
                S201038=1;
                S201038=0;
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 174, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 174, column: 4
                  S201038=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S201033=0;
                  if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 174, column: 4
                    enableDumper_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 174, column: 4
                    S201033=1;
                    if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 174, column: 4
                      enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 174, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 174, column: 4
                      S200441=18;
                      S201082=0;
                      if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 175, column: 4
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                        S201082=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S201077=0;
                        if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                          statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 175, column: 4
                          S201077=1;
                          if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 175, column: 4
                            m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 176, column: 4
                            S200441=19;
                            active[3]=1;
                            ends[3]=1;
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
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 18 : 
            switch(S201082){
              case 0 : 
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 175, column: 4
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                  S201082=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S201077){
                    case 0 : 
                      if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                        statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 175, column: 4
                        S201077=1;
                        if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 175, column: 4
                          m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 176, column: 4
                          S200441=19;
                          active[3]=1;
                          ends[3]=1;
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
                      if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 175, column: 4
                        m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 176, column: 4
                        S200441=19;
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
                S201082=1;
                S201082=0;
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 175, column: 4
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                  S201082=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S201077=0;
                  if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                    statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 175, column: 4
                    S201077=1;
                    if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                      statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 175, column: 4
                      m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 176, column: 4
                      S200441=19;
                      active[3]=1;
                      ends[3]=1;
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
          
          case 19 : 
            S200441=19;
            S200441=20;
            S201170=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 180, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 180, column: 4
              S201170=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S201165=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 180, column: 4
                enableConveyor_o.setVal(new Integer(TO_RETURN_thread_3));//sysj\recyclingStationController.sysj line: 180, column: 4
                S201165=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 180, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 180, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 180, column: 4
                  S200441=21;
                  S201214=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 181, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                    S201214=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S201209=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 181, column: 4
                      S201209=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 181, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 182, column: 4
                        S200441=22;
                        active[3]=1;
                        ends[3]=1;
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
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 20 : 
            switch(S201170){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 180, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 180, column: 4
                  S201170=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S201165){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 180, column: 4
                        enableConveyor_o.setVal(new Integer(TO_RETURN_thread_3));//sysj\recyclingStationController.sysj line: 180, column: 4
                        S201165=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 180, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 180, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 180, column: 4
                          S200441=21;
                          S201214=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 181, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                            S201214=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S201209=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 181, column: 4
                              S201209=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 181, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 182, column: 4
                                S200441=22;
                                active[3]=1;
                                ends[3]=1;
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
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 180, column: 4
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 180, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 180, column: 4
                        S200441=21;
                        S201214=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 181, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                          S201214=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S201209=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 181, column: 4
                            S201209=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 181, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 182, column: 4
                              S200441=22;
                              active[3]=1;
                              ends[3]=1;
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
                }
                break;
              
              case 1 : 
                S201170=1;
                S201170=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 180, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 180, column: 4
                  S201170=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S201165=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 180, column: 4
                    enableConveyor_o.setVal(new Integer(TO_RETURN_thread_3));//sysj\recyclingStationController.sysj line: 180, column: 4
                    S201165=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 180, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 180, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 180, column: 4
                      S200441=21;
                      S201214=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 181, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                        S201214=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S201209=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 181, column: 4
                          S201209=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 181, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 182, column: 4
                            S200441=22;
                            active[3]=1;
                            ends[3]=1;
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
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 21 : 
            switch(S201214){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 181, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                  S201214=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S201209){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 181, column: 4
                        S201209=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 181, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 182, column: 4
                          S200441=22;
                          active[3]=1;
                          ends[3]=1;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 181, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 182, column: 4
                        S200441=22;
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
                S201214=1;
                S201214=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 181, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                  S201214=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S201209=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 181, column: 4
                    S201209=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 181, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 182, column: 4
                      S200441=22;
                      active[3]=1;
                      ends[3]=1;
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
          
          case 22 : 
            S200441=22;
            S200441=23;
            S201302=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 186, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 186, column: 4
              S201302=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S201297=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 186, column: 4
                enableConveyor_o.setVal(new Integer(DISCHARGE_thread_3));//sysj\recyclingStationController.sysj line: 186, column: 4
                S201297=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 186, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 186, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 186, column: 4
                  S200441=24;
                  S201346=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 187, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                    S201346=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S201341=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 187, column: 4
                      S201341=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 187, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 188, column: 4
                        S200441=25;
                        active[3]=1;
                        ends[3]=1;
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
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 23 : 
            switch(S201302){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 186, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 186, column: 4
                  S201302=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S201297){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 186, column: 4
                        enableConveyor_o.setVal(new Integer(DISCHARGE_thread_3));//sysj\recyclingStationController.sysj line: 186, column: 4
                        S201297=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 186, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 186, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 186, column: 4
                          S200441=24;
                          S201346=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 187, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                            S201346=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S201341=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 187, column: 4
                              S201341=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 187, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 188, column: 4
                                S200441=25;
                                active[3]=1;
                                ends[3]=1;
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
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 186, column: 4
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 186, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 186, column: 4
                        S200441=24;
                        S201346=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 187, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                          S201346=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S201341=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 187, column: 4
                            S201341=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 187, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 188, column: 4
                              S200441=25;
                              active[3]=1;
                              ends[3]=1;
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
                }
                break;
              
              case 1 : 
                S201302=1;
                S201302=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 186, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 186, column: 4
                  S201302=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S201297=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 186, column: 4
                    enableConveyor_o.setVal(new Integer(DISCHARGE_thread_3));//sysj\recyclingStationController.sysj line: 186, column: 4
                    S201297=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 186, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 186, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 186, column: 4
                      S200441=24;
                      S201346=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 187, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                        S201346=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S201341=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 187, column: 4
                          S201341=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 187, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 188, column: 4
                            S200441=25;
                            active[3]=1;
                            ends[3]=1;
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
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 24 : 
            switch(S201346){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 187, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                  S201346=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S201341){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 187, column: 4
                        S201341=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 187, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 188, column: 4
                          S200441=25;
                          active[3]=1;
                          ends[3]=1;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 187, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 188, column: 4
                        S200441=25;
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
                S201346=1;
                S201346=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 187, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                  S201346=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S201341=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 187, column: 4
                    S201341=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 187, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 188, column: 4
                      S200441=25;
                      active[3]=1;
                      ends[3]=1;
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
          
          case 25 : 
            S200441=25;
            S200441=26;
            S201434=0;
            if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 192, column: 4
              enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 192, column: 4
              S201434=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S201429=0;
              if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 192, column: 4
                enableReturn_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 192, column: 4
                S201429=1;
                if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 192, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 192, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 192, column: 4
                  S200441=27;
                  S201478=0;
                  if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 193, column: 4
                    statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                    S201478=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S201473=0;
                    if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                      statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 193, column: 4
                      S201473=1;
                      if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 193, column: 4
                        m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 194, column: 4
                        S200441=28;
                        active[3]=1;
                        ends[3]=1;
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
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 26 : 
            switch(S201434){
              case 0 : 
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 192, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 192, column: 4
                  S201434=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S201429){
                    case 0 : 
                      if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 192, column: 4
                        enableReturn_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 192, column: 4
                        S201429=1;
                        if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 192, column: 4
                          enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 192, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 192, column: 4
                          S200441=27;
                          S201478=0;
                          if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 193, column: 4
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                            S201478=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S201473=0;
                            if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                              statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 193, column: 4
                              S201473=1;
                              if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                                statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 193, column: 4
                                m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 194, column: 4
                                S200441=28;
                                active[3]=1;
                                ends[3]=1;
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
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 192, column: 4
                        enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 192, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 192, column: 4
                        S200441=27;
                        S201478=0;
                        if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 193, column: 4
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                          S201478=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S201473=0;
                          if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                            statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 193, column: 4
                            S201473=1;
                            if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                              statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 193, column: 4
                              m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 194, column: 4
                              S200441=28;
                              active[3]=1;
                              ends[3]=1;
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
                }
                break;
              
              case 1 : 
                S201434=1;
                S201434=0;
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 192, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 192, column: 4
                  S201434=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S201429=0;
                  if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 192, column: 4
                    enableReturn_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 192, column: 4
                    S201429=1;
                    if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 192, column: 4
                      enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 192, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 192, column: 4
                      S200441=27;
                      S201478=0;
                      if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 193, column: 4
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                        S201478=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S201473=0;
                        if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                          statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 193, column: 4
                          S201473=1;
                          if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 193, column: 4
                            m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 194, column: 4
                            S200441=28;
                            active[3]=1;
                            ends[3]=1;
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
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 27 : 
            switch(S201478){
              case 0 : 
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 193, column: 4
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                  S201478=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S201473){
                    case 0 : 
                      if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                        statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 193, column: 4
                        S201473=1;
                        if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 193, column: 4
                          m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 194, column: 4
                          S200441=28;
                          active[3]=1;
                          ends[3]=1;
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
                      if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 193, column: 4
                        m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 194, column: 4
                        S200441=28;
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
                S201478=1;
                S201478=0;
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 193, column: 4
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                  S201478=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S201473=0;
                  if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                    statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 193, column: 4
                    S201473=1;
                    if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                      statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 193, column: 4
                      m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 194, column: 4
                      S200441=28;
                      active[3]=1;
                      ends[3]=1;
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
          
          case 28 : 
            S200441=28;
            m_thread_3.reportRecovered();//sysj\recyclingStationController.sysj line: 198, column: 4
            S200441=29;
            S201566=0;
            if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 199, column: 4
              bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 199, column: 4
              S201566=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S201561=0;
              if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 199, column: 4
                bottleRecycled_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 199, column: 4
                S201561=1;
                if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 199, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 199, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 199, column: 4
                  S200441=30;
                  active[3]=1;
                  ends[3]=1;
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
          
          case 29 : 
            switch(S201566){
              case 0 : 
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 199, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 199, column: 4
                  S201566=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S201561){
                    case 0 : 
                      if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 199, column: 4
                        bottleRecycled_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 199, column: 4
                        S201561=1;
                        if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 199, column: 4
                          bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 199, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 199, column: 4
                          S200441=30;
                          active[3]=1;
                          ends[3]=1;
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
                      if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 199, column: 4
                        bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 199, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 199, column: 4
                        S200441=30;
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
                S201566=1;
                S201566=0;
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 199, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 199, column: 4
                  S201566=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S201561=0;
                  if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 199, column: 4
                    bottleRecycled_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 199, column: 4
                    S201561=1;
                    if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 199, column: 4
                      bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 199, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 199, column: 4
                      S200441=30;
                      active[3]=1;
                      ends[3]=1;
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
          
          case 30 : 
            S200441=30;
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 204, column: 4
            currsigs.addElement(stationState_1);
            stationState_1.setValue(m_thread_3.restingState());//sysj\recyclingStationController.sysj line: 204, column: 4
            S200441=31;
            if(m_thread_3.suspended()){//sysj\recyclingStationController.sysj line: 211, column: 4
              m_thread_3.reportSuspension();//sysj\recyclingStationController.sysj line: 212, column: 5
              stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 214, column: 6
              currsigs.addElement(stationState_1);
              stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 214, column: 6
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S200441=32;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 31 : 
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 214, column: 6
            currsigs.addElement(stationState_1);
            stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 214, column: 6
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 32 : 
            S200441=32;
            S200441=0;
            S200425=0;
            if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 124, column: 4
              bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
              S200425=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S200420=0;
              if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
                bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 124, column: 4
                S200420=1;
                if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 124, column: 4
                  w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 125, column: 4
                  permitted_thread_3 = false;//sysj\recyclingStationController.sysj line: 126, column: 1
                  S200441=1;
                  active[3]=1;
                  ends[3]=1;
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

  public void thread207632(int [] tdone, int [] ends){
        switch(S200417){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(stationState_1.getprestatus()){//sysj\recyclingStationController.sysj line: 82, column: 12
          cur_thread_2 = ((Integer)(stationState_1.getpreval() == null ? 0 : ((Integer)stationState_1.getpreval()).intValue())).intValue();//sysj\recyclingStationController.sysj line: 83, column: 5
          recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 85, column: 4
          currsigs.addElement(recyclingStatus);
          recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 85, column: 4
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 85, column: 4
          currsigs.addElement(recyclingStatus);
          recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 85, column: 4
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread207630(int [] tdone, int [] ends){
        S207625=1;
    m_thread_3 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 108, column: 3
    TO_LID_thread_3 = 1;//sysj\recyclingStationController.sysj line: 111, column: 3
    TO_DUMP_thread_3 = 2;//sysj\recyclingStationController.sysj line: 112, column: 3
    TO_RETURN_thread_3 = 3;//sysj\recyclingStationController.sysj line: 113, column: 3
    DISCHARGE_thread_3 = 4;//sysj\recyclingStationController.sysj line: 114, column: 3
    w_thread_3 = null;//sysj\recyclingStationController.sysj line: 116, column: 3
    S200441=0;
    S200425=0;
    if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 124, column: 4
      bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
      S200425=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S200420=0;
      if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
        bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 124, column: 4
        S200420=1;
        if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
          bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
          ends[3]=2;
          ;//sysj\recyclingStationController.sysj line: 124, column: 4
          w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 125, column: 4
          permitted_thread_3 = false;//sysj\recyclingStationController.sysj line: 126, column: 1
          S200441=1;
          active[3]=1;
          ends[3]=1;
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

  public void thread207629(int [] tdone, int [] ends){
        S200417=1;
    cur_thread_2 = 0;//sysj\recyclingStationController.sysj line: 80, column: 3
    if(stationState_1.getprestatus()){//sysj\recyclingStationController.sysj line: 82, column: 12
      cur_thread_2 = ((Integer)(stationState_1.getpreval() == null ? 0 : ((Integer)stationState_1.getpreval()).intValue())).intValue();//sysj\recyclingStationController.sysj line: 83, column: 5
      recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 85, column: 4
      currsigs.addElement(recyclingStatus);
      recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 85, column: 4
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
    else {
      recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 85, column: 4
      currsigs.addElement(recyclingStatus);
      recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 85, column: 4
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
      switch(S207627){
        case 0 : 
          S207627=0;
          break RUN;
        
        case 1 : 
          S207627=2;
          S207627=2;
          stationState_1.setClear();//sysj\recyclingStationController.sysj line: 77, column: 2
          thread207629(tdone,ends);
          thread207630(tdone,ends);
          int biggest207631 = 0;
          if(ends[2]>=biggest207631){
            biggest207631=ends[2];
          }
          if(ends[3]>=biggest207631){
            biggest207631=ends[3];
          }
          if(biggest207631 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          stationState_1.setClear();//sysj\recyclingStationController.sysj line: 77, column: 2
          thread207632(tdone,ends);
          thread207633(tdone,ends);
          int biggest207634 = 0;
          if(ends[2]>=biggest207634){
            biggest207634=ends[2];
          }
          if(ends[3]>=biggest207634){
            biggest207634=ends[3];
          }
          if(biggest207634 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest207634 == 0){
            S207627=0;
            active[1]=0;
            ends[1]=0;
            S207627=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0};
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
          statusSplitter_in.gethook();
          statusConveyor_in.gethook();
          statusLidRemoval_in.gethook();
          statusDumper_in.gethook();
          statusReturn_in.gethook();
          bottleRecycled_o.gethook();
          enableSplitter_o.gethook();
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
      statusSplitter_in.sethook();
      statusConveyor_in.sethook();
      statusLidRemoval_in.sethook();
      statusDumper_in.sethook();
      statusReturn_in.sethook();
      bottleRecycled_o.sethook();
      enableSplitter_o.sethook();
      enableLidRemoval_o.sethook();
      enableDumper_o.sethook();
      enableReturn_o.sethook();
      enableConveyor_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleRejected_in.gethook();
        statusSplitter_in.gethook();
        statusConveyor_in.gethook();
        statusLidRemoval_in.gethook();
        statusDumper_in.gethook();
        statusReturn_in.gethook();
        bottleRecycled_o.gethook();
        enableSplitter_o.gethook();
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
