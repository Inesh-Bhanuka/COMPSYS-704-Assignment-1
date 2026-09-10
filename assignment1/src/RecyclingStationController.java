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
  private int cur_thread_2;//sysj\recyclingStationController.sysj line: 79, column: 3
  private RecyclingRecord m_thread_3;//sysj\recyclingStationController.sysj line: 107, column: 3
  private int TO_LID_thread_3;//sysj\recyclingStationController.sysj line: 110, column: 3
  private int TO_DUMP_thread_3;//sysj\recyclingStationController.sysj line: 111, column: 3
  private int TO_RETURN_thread_3;//sysj\recyclingStationController.sysj line: 112, column: 3
  private int DISCHARGE_thread_3;//sysj\recyclingStationController.sysj line: 113, column: 3
  private WorkpieceTwin w_thread_3;//sysj\recyclingStationController.sysj line: 115, column: 3
  private int S166183 = 1;
  private int S158433 = 1;
  private int S166181 = 1;
  private int S158457 = 1;
  private int S158441 = 1;
  private int S158436 = 1;
  private int S158464 = 1;
  private int S158459 = 1;
  private int S158552 = 1;
  private int S158547 = 1;
  private int S158748 = 1;
  private int S158743 = 1;
  private int S158792 = 1;
  private int S158787 = 1;
  private int S158880 = 1;
  private int S158875 = 1;
  private int S158924 = 1;
  private int S158919 = 1;
  private int S159012 = 1;
  private int S159007 = 1;
  private int S159056 = 1;
  private int S159051 = 1;
  private int S159144 = 1;
  private int S159139 = 1;
  private int S159188 = 1;
  private int S159183 = 1;
  private int S159276 = 1;
  private int S159271 = 1;
  private int S159320 = 1;
  private int S159315 = 1;
  private int S159408 = 1;
  private int S159403 = 1;
  private int S159452 = 1;
  private int S159447 = 1;
  private int S159540 = 1;
  private int S159535 = 1;
  private int S159584 = 1;
  private int S159579 = 1;
  private int S159672 = 1;
  private int S159667 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread166189(int [] tdone, int [] ends){
        switch(S166181){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S158457){
          case 0 : 
            switch(S158441){
              case 0 : 
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 123, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                  S158441=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158436){
                    case 0 : 
                      if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                        bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 123, column: 4
                        S158436=1;
                        if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                          bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 123, column: 4
                          w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 124, column: 4
                          m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 125, column: 4
                          stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 126, column: 4
                          currsigs.addElement(stationState_1);
                          stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 126, column: 4
                          S158457=1;
                          S158464=0;
                          if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                            enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                            S158464=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S158459=0;
                            if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                              enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                              S158459=1;
                              if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                                enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 129, column: 4
                                S158457=2;
                                S158552=0;
                                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                  S158552=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S158547=0;
                                  if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                    statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                                    S158547=1;
                                    if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                      statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                      ends[3]=2;
                                      ;//sysj\recyclingStationController.sysj line: 130, column: 4
                                      m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                                      S158457=3;
                                      if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 137, column: 4
                                        m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 138, column: 5
                                        stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 140, column: 6
                                        currsigs.addElement(stationState_1);
                                        stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 140, column: 6
                                        active[3]=1;
                                        ends[3]=1;
                                        tdone[3]=1;
                                      }
                                      else {
                                        S158457=4;
                                        active[3]=1;
                                        ends[3]=1;
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
                        }
                        else {
                          active[3]=1;
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
                      if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                        bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 123, column: 4
                        w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 124, column: 4
                        m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 125, column: 4
                        stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 126, column: 4
                        currsigs.addElement(stationState_1);
                        stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 126, column: 4
                        S158457=1;
                        S158464=0;
                        if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                          enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                          S158464=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S158459=0;
                          if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                            enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                            S158459=1;
                            if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                              enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 129, column: 4
                              S158457=2;
                              S158552=0;
                              if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                S158552=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S158547=0;
                                if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                  statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                                  S158547=1;
                                  if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                    statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                    ends[3]=2;
                                    ;//sysj\recyclingStationController.sysj line: 130, column: 4
                                    m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                                    S158457=3;
                                    if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 137, column: 4
                                      m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 138, column: 5
                                      stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 140, column: 6
                                      currsigs.addElement(stationState_1);
                                      stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 140, column: 6
                                      active[3]=1;
                                      ends[3]=1;
                                      tdone[3]=1;
                                    }
                                    else {
                                      S158457=4;
                                      active[3]=1;
                                      ends[3]=1;
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
                S158441=1;
                S158441=0;
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 123, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                  S158441=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158436=0;
                  if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                    bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 123, column: 4
                    S158436=1;
                    if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                      bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 123, column: 4
                      w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 124, column: 4
                      m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 125, column: 4
                      stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 126, column: 4
                      currsigs.addElement(stationState_1);
                      stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 126, column: 4
                      S158457=1;
                      S158464=0;
                      if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                        enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                        S158464=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S158459=0;
                        if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                          enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                          S158459=1;
                          if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                            enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 129, column: 4
                            S158457=2;
                            S158552=0;
                            if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                              statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                              S158552=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S158547=0;
                              if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                                S158547=1;
                                if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                  ends[3]=2;
                                  ;//sysj\recyclingStationController.sysj line: 130, column: 4
                                  m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                                  S158457=3;
                                  if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 137, column: 4
                                    m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 138, column: 5
                                    stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 140, column: 6
                                    currsigs.addElement(stationState_1);
                                    stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 140, column: 6
                                    active[3]=1;
                                    ends[3]=1;
                                    tdone[3]=1;
                                  }
                                  else {
                                    S158457=4;
                                    active[3]=1;
                                    ends[3]=1;
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
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            switch(S158464){
              case 0 : 
                if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                  enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                  S158464=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158459){
                    case 0 : 
                      if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                        enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                        S158459=1;
                        if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                          enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 129, column: 4
                          S158457=2;
                          S158552=0;
                          if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                            statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                            S158552=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S158547=0;
                            if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                              statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                              S158547=1;
                              if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 130, column: 4
                                m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                                S158457=3;
                                if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 137, column: 4
                                  m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 138, column: 5
                                  stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 140, column: 6
                                  currsigs.addElement(stationState_1);
                                  stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 140, column: 6
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S158457=4;
                                  active[3]=1;
                                  ends[3]=1;
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
                      if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                        enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 129, column: 4
                        S158457=2;
                        S158552=0;
                        if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                          statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                          S158552=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S158547=0;
                          if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                            statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                            S158547=1;
                            if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                              statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 130, column: 4
                              m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                              S158457=3;
                              if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 137, column: 4
                                m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 138, column: 5
                                stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 140, column: 6
                                currsigs.addElement(stationState_1);
                                stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 140, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S158457=4;
                                active[3]=1;
                                ends[3]=1;
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
                S158464=1;
                S158464=0;
                if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                  enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                  S158464=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158459=0;
                  if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                    enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                    S158459=1;
                    if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                      enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 129, column: 4
                      S158457=2;
                      S158552=0;
                      if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                        statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                        S158552=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S158547=0;
                        if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                          statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                          S158547=1;
                          if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                            statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 130, column: 4
                            m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                            S158457=3;
                            if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 137, column: 4
                              m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 138, column: 5
                              stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 140, column: 6
                              currsigs.addElement(stationState_1);
                              stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 140, column: 6
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S158457=4;
                              active[3]=1;
                              ends[3]=1;
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
          
          case 2 : 
            switch(S158552){
              case 0 : 
                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                  S158552=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158547){
                    case 0 : 
                      if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                        statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                        S158547=1;
                        if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                          statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 130, column: 4
                          m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                          S158457=3;
                          if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 137, column: 4
                            m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 138, column: 5
                            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 140, column: 6
                            currsigs.addElement(stationState_1);
                            stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 140, column: 6
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S158457=4;
                            active[3]=1;
                            ends[3]=1;
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
                      if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                        statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 130, column: 4
                        m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                        S158457=3;
                        if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 137, column: 4
                          m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 138, column: 5
                          stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 140, column: 6
                          currsigs.addElement(stationState_1);
                          stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 140, column: 6
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S158457=4;
                          active[3]=1;
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
                S158552=1;
                S158552=0;
                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                  S158552=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158547=0;
                  if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                    statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                    S158547=1;
                    if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                      statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 130, column: 4
                      m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                      S158457=3;
                      if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 137, column: 4
                        m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 138, column: 5
                        stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 140, column: 6
                        currsigs.addElement(stationState_1);
                        stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 140, column: 6
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S158457=4;
                        active[3]=1;
                        ends[3]=1;
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
          
          case 3 : 
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 140, column: 6
            currsigs.addElement(stationState_1);
            stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 140, column: 6
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 4 : 
            S158457=4;
            S158457=5;
            S158748=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 147, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
              S158748=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S158743=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                enableConveyor_o.setVal(new Integer(TO_LID_thread_3));//sysj\recyclingStationController.sysj line: 147, column: 4
                S158743=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 147, column: 4
                  S158457=6;
                  S158792=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                    S158792=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S158787=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                      S158787=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 148, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                        S158457=7;
                        active[3]=1;
                        ends[3]=1;
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
          
          case 5 : 
            switch(S158748){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 147, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                  S158748=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158743){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                        enableConveyor_o.setVal(new Integer(TO_LID_thread_3));//sysj\recyclingStationController.sysj line: 147, column: 4
                        S158743=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 147, column: 4
                          S158457=6;
                          S158792=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                            S158792=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S158787=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                              S158787=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 148, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                                S158457=7;
                                active[3]=1;
                                ends[3]=1;
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
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 147, column: 4
                        S158457=6;
                        S158792=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                          S158792=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S158787=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                            S158787=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 148, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                              S158457=7;
                              active[3]=1;
                              ends[3]=1;
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
                S158748=1;
                S158748=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 147, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                  S158748=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158743=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                    enableConveyor_o.setVal(new Integer(TO_LID_thread_3));//sysj\recyclingStationController.sysj line: 147, column: 4
                    S158743=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 147, column: 4
                      S158457=6;
                      S158792=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                        S158792=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S158787=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                          S158787=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 148, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                            S158457=7;
                            active[3]=1;
                            ends[3]=1;
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
          
          case 6 : 
            switch(S158792){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                  S158792=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158787){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                        S158787=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 148, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                          S158457=7;
                          active[3]=1;
                          ends[3]=1;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 148, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                        S158457=7;
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
                S158792=1;
                S158792=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                  S158792=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158787=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                    S158787=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 148, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                      S158457=7;
                      active[3]=1;
                      ends[3]=1;
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
          
          case 7 : 
            S158457=7;
            S158457=8;
            S158880=0;
            if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 153, column: 4
              enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
              S158880=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S158875=0;
              if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                enableLidRemoval_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 153, column: 4
                S158875=1;
                if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 153, column: 4
                  S158457=9;
                  S158924=0;
                  if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                    statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                    S158924=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S158919=0;
                    if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                      statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                      S158919=1;
                      if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 154, column: 4
                        m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                        S158457=10;
                        active[3]=1;
                        ends[3]=1;
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
            switch(S158880){
              case 0 : 
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 153, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                  S158880=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158875){
                    case 0 : 
                      if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                        enableLidRemoval_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 153, column: 4
                        S158875=1;
                        if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                          enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 153, column: 4
                          S158457=9;
                          S158924=0;
                          if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                            S158924=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S158919=0;
                            if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                              statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                              S158919=1;
                              if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                                statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 154, column: 4
                                m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                                S158457=10;
                                active[3]=1;
                                ends[3]=1;
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
                      if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                        enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 153, column: 4
                        S158457=9;
                        S158924=0;
                        if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                          S158924=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S158919=0;
                          if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                            statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                            S158919=1;
                            if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                              statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 154, column: 4
                              m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                              S158457=10;
                              active[3]=1;
                              ends[3]=1;
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
                S158880=1;
                S158880=0;
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 153, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                  S158880=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158875=0;
                  if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                    enableLidRemoval_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 153, column: 4
                    S158875=1;
                    if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                      enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 153, column: 4
                      S158457=9;
                      S158924=0;
                      if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                        S158924=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S158919=0;
                        if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                          statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                          S158919=1;
                          if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 154, column: 4
                            m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                            S158457=10;
                            active[3]=1;
                            ends[3]=1;
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
            switch(S158924){
              case 0 : 
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                  S158924=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158919){
                    case 0 : 
                      if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                        statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                        S158919=1;
                        if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 154, column: 4
                          m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                          S158457=10;
                          active[3]=1;
                          ends[3]=1;
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
                      if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 154, column: 4
                        m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                        S158457=10;
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
                S158924=1;
                S158924=0;
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                  S158924=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158919=0;
                  if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                    statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                    S158919=1;
                    if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                      statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 154, column: 4
                      m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                      S158457=10;
                      active[3]=1;
                      ends[3]=1;
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
            S158457=10;
            S158457=11;
            S159012=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 159, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
              S159012=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S159007=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                enableConveyor_o.setVal(new Integer(TO_DUMP_thread_3));//sysj\recyclingStationController.sysj line: 159, column: 4
                S159007=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 159, column: 4
                  S158457=12;
                  S159056=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                    S159056=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S159051=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                      S159051=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 160, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                        S158457=13;
                        active[3]=1;
                        ends[3]=1;
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
            switch(S159012){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 159, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                  S159012=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S159007){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                        enableConveyor_o.setVal(new Integer(TO_DUMP_thread_3));//sysj\recyclingStationController.sysj line: 159, column: 4
                        S159007=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 159, column: 4
                          S158457=12;
                          S159056=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                            S159056=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S159051=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                              S159051=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 160, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                                S158457=13;
                                active[3]=1;
                                ends[3]=1;
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
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 159, column: 4
                        S158457=12;
                        S159056=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                          S159056=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S159051=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                            S159051=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 160, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                              S158457=13;
                              active[3]=1;
                              ends[3]=1;
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
                S159012=1;
                S159012=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 159, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                  S159012=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S159007=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                    enableConveyor_o.setVal(new Integer(TO_DUMP_thread_3));//sysj\recyclingStationController.sysj line: 159, column: 4
                    S159007=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 159, column: 4
                      S158457=12;
                      S159056=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                        S159056=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S159051=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                          S159051=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 160, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                            S158457=13;
                            active[3]=1;
                            ends[3]=1;
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
            switch(S159056){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                  S159056=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S159051){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                        S159051=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 160, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                          S158457=13;
                          active[3]=1;
                          ends[3]=1;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 160, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                        S158457=13;
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
                S159056=1;
                S159056=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                  S159056=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S159051=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                    S159051=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 160, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                      S158457=13;
                      active[3]=1;
                      ends[3]=1;
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
            S158457=13;
            S158457=14;
            S159144=0;
            if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 165, column: 4
              enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
              S159144=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S159139=0;
              if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                enableDumper_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 165, column: 4
                S159139=1;
                if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 165, column: 4
                  S158457=15;
                  S159188=0;
                  if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                    statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                    S159188=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S159183=0;
                    if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                      statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                      S159183=1;
                      if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 166, column: 4
                        m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                        S158457=16;
                        active[3]=1;
                        ends[3]=1;
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
            switch(S159144){
              case 0 : 
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 165, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                  S159144=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S159139){
                    case 0 : 
                      if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                        enableDumper_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 165, column: 4
                        S159139=1;
                        if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                          enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 165, column: 4
                          S158457=15;
                          S159188=0;
                          if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                            S159188=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S159183=0;
                            if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                              statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                              S159183=1;
                              if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                                statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 166, column: 4
                                m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                                S158457=16;
                                active[3]=1;
                                ends[3]=1;
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
                      if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                        enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 165, column: 4
                        S158457=15;
                        S159188=0;
                        if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                          S159188=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S159183=0;
                          if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                            statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                            S159183=1;
                            if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                              statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 166, column: 4
                              m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                              S158457=16;
                              active[3]=1;
                              ends[3]=1;
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
                S159144=1;
                S159144=0;
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 165, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                  S159144=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S159139=0;
                  if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                    enableDumper_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 165, column: 4
                    S159139=1;
                    if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                      enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 165, column: 4
                      S158457=15;
                      S159188=0;
                      if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                        S159188=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S159183=0;
                        if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                          statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                          S159183=1;
                          if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 166, column: 4
                            m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                            S158457=16;
                            active[3]=1;
                            ends[3]=1;
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
            switch(S159188){
              case 0 : 
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                  S159188=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S159183){
                    case 0 : 
                      if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                        statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                        S159183=1;
                        if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 166, column: 4
                          m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                          S158457=16;
                          active[3]=1;
                          ends[3]=1;
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
                      if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 166, column: 4
                        m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                        S158457=16;
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
                S159188=1;
                S159188=0;
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                  S159188=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S159183=0;
                  if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                    statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                    S159183=1;
                    if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                      statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 166, column: 4
                      m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                      S158457=16;
                      active[3]=1;
                      ends[3]=1;
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
            S158457=16;
            S158457=17;
            S159276=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 171, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
              S159276=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S159271=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                enableConveyor_o.setVal(new Integer(TO_RETURN_thread_3));//sysj\recyclingStationController.sysj line: 171, column: 4
                S159271=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 171, column: 4
                  S158457=18;
                  S159320=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                    S159320=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S159315=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                      S159315=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 172, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                        S158457=19;
                        active[3]=1;
                        ends[3]=1;
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
            switch(S159276){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 171, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                  S159276=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S159271){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                        enableConveyor_o.setVal(new Integer(TO_RETURN_thread_3));//sysj\recyclingStationController.sysj line: 171, column: 4
                        S159271=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 171, column: 4
                          S158457=18;
                          S159320=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                            S159320=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S159315=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                              S159315=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 172, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                                S158457=19;
                                active[3]=1;
                                ends[3]=1;
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
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 171, column: 4
                        S158457=18;
                        S159320=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                          S159320=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S159315=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                            S159315=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 172, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                              S158457=19;
                              active[3]=1;
                              ends[3]=1;
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
                S159276=1;
                S159276=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 171, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                  S159276=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S159271=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                    enableConveyor_o.setVal(new Integer(TO_RETURN_thread_3));//sysj\recyclingStationController.sysj line: 171, column: 4
                    S159271=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 171, column: 4
                      S158457=18;
                      S159320=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                        S159320=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S159315=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                          S159315=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 172, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                            S158457=19;
                            active[3]=1;
                            ends[3]=1;
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
            switch(S159320){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                  S159320=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S159315){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                        S159315=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 172, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                          S158457=19;
                          active[3]=1;
                          ends[3]=1;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 172, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                        S158457=19;
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
                S159320=1;
                S159320=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                  S159320=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S159315=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                    S159315=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 172, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                      S158457=19;
                      active[3]=1;
                      ends[3]=1;
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
            S158457=19;
            S158457=20;
            S159408=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 177, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
              S159408=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S159403=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                enableConveyor_o.setVal(new Integer(DISCHARGE_thread_3));//sysj\recyclingStationController.sysj line: 177, column: 4
                S159403=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 177, column: 4
                  S158457=21;
                  S159452=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                    S159452=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S159447=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                      S159447=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 178, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                        S158457=22;
                        active[3]=1;
                        ends[3]=1;
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
            switch(S159408){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 177, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                  S159408=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S159403){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                        enableConveyor_o.setVal(new Integer(DISCHARGE_thread_3));//sysj\recyclingStationController.sysj line: 177, column: 4
                        S159403=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 177, column: 4
                          S158457=21;
                          S159452=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                            S159452=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S159447=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                              S159447=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 178, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                                S158457=22;
                                active[3]=1;
                                ends[3]=1;
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
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 177, column: 4
                        S158457=21;
                        S159452=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                          S159452=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S159447=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                            S159447=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 178, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                              S158457=22;
                              active[3]=1;
                              ends[3]=1;
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
                S159408=1;
                S159408=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 177, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                  S159408=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S159403=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                    enableConveyor_o.setVal(new Integer(DISCHARGE_thread_3));//sysj\recyclingStationController.sysj line: 177, column: 4
                    S159403=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 177, column: 4
                      S158457=21;
                      S159452=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                        S159452=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S159447=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                          S159447=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 178, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                            S158457=22;
                            active[3]=1;
                            ends[3]=1;
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
            switch(S159452){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                  S159452=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S159447){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                        S159447=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 178, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                          S158457=22;
                          active[3]=1;
                          ends[3]=1;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 178, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                        S158457=22;
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
                S159452=1;
                S159452=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                  S159452=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S159447=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                    S159447=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 178, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                      S158457=22;
                      active[3]=1;
                      ends[3]=1;
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
            S158457=22;
            S158457=23;
            S159540=0;
            if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 183, column: 4
              enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
              S159540=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S159535=0;
              if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                enableReturn_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 183, column: 4
                S159535=1;
                if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 183, column: 4
                  S158457=24;
                  S159584=0;
                  if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                    statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                    S159584=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S159579=0;
                    if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                      statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                      S159579=1;
                      if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 184, column: 4
                        m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                        S158457=25;
                        active[3]=1;
                        ends[3]=1;
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
            switch(S159540){
              case 0 : 
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 183, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                  S159540=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S159535){
                    case 0 : 
                      if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                        enableReturn_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 183, column: 4
                        S159535=1;
                        if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                          enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 183, column: 4
                          S158457=24;
                          S159584=0;
                          if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                            S159584=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S159579=0;
                            if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                              statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                              S159579=1;
                              if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                                statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 184, column: 4
                                m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                                S158457=25;
                                active[3]=1;
                                ends[3]=1;
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
                      if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                        enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 183, column: 4
                        S158457=24;
                        S159584=0;
                        if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                          S159584=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S159579=0;
                          if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                            statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                            S159579=1;
                            if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                              statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 184, column: 4
                              m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                              S158457=25;
                              active[3]=1;
                              ends[3]=1;
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
                S159540=1;
                S159540=0;
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 183, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                  S159540=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S159535=0;
                  if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                    enableReturn_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 183, column: 4
                    S159535=1;
                    if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                      enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 183, column: 4
                      S158457=24;
                      S159584=0;
                      if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                        S159584=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S159579=0;
                        if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                          statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                          S159579=1;
                          if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 184, column: 4
                            m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                            S158457=25;
                            active[3]=1;
                            ends[3]=1;
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
            switch(S159584){
              case 0 : 
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                  S159584=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S159579){
                    case 0 : 
                      if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                        statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                        S159579=1;
                        if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 184, column: 4
                          m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                          S158457=25;
                          active[3]=1;
                          ends[3]=1;
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
                      if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 184, column: 4
                        m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                        S158457=25;
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
                S159584=1;
                S159584=0;
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                  S159584=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S159579=0;
                  if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                    statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                    S159579=1;
                    if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                      statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 184, column: 4
                      m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                      S158457=25;
                      active[3]=1;
                      ends[3]=1;
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
            S158457=25;
            m_thread_3.reportRecovered();//sysj\recyclingStationController.sysj line: 189, column: 4
            S158457=26;
            S159672=0;
            if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 190, column: 4
              bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
              S159672=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S159667=0;
              if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                bottleRecycled_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 190, column: 4
                S159667=1;
                if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 190, column: 4
                  S158457=27;
                  active[3]=1;
                  ends[3]=1;
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
          
          case 26 : 
            switch(S159672){
              case 0 : 
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 190, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                  S159672=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S159667){
                    case 0 : 
                      if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                        bottleRecycled_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 190, column: 4
                        S159667=1;
                        if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                          bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 190, column: 4
                          S158457=27;
                          active[3]=1;
                          ends[3]=1;
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
                      if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                        bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 190, column: 4
                        S158457=27;
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
                S159672=1;
                S159672=0;
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 190, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                  S159672=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S159667=0;
                  if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                    bottleRecycled_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 190, column: 4
                    S159667=1;
                    if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                      bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 190, column: 4
                      S158457=27;
                      active[3]=1;
                      ends[3]=1;
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
          
          case 27 : 
            S158457=27;
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 195, column: 4
            currsigs.addElement(stationState_1);
            stationState_1.setValue(m_thread_3.restingState());//sysj\recyclingStationController.sysj line: 195, column: 4
            S158457=28;
            if(m_thread_3.suspended()){//sysj\recyclingStationController.sysj line: 202, column: 4
              m_thread_3.reportSuspension();//sysj\recyclingStationController.sysj line: 203, column: 5
              stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 205, column: 6
              currsigs.addElement(stationState_1);
              stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 205, column: 6
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S158457=29;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 28 : 
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 205, column: 6
            currsigs.addElement(stationState_1);
            stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 205, column: 6
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 29 : 
            S158457=29;
            S158457=0;
            S158441=0;
            if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 123, column: 4
              bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
              S158441=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S158436=0;
              if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 123, column: 4
                S158436=1;
                if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 123, column: 4
                  w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 124, column: 4
                  m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 125, column: 4
                  stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 126, column: 4
                  currsigs.addElement(stationState_1);
                  stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 126, column: 4
                  S158457=1;
                  S158464=0;
                  if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                    enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                    S158464=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S158459=0;
                    if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                      enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                      S158459=1;
                      if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                        enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 129, column: 4
                        S158457=2;
                        S158552=0;
                        if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                          statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                          S158552=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S158547=0;
                          if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                            statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                            S158547=1;
                            if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                              statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 130, column: 4
                              m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                              S158457=3;
                              if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 137, column: 4
                                m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 138, column: 5
                                stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 140, column: 6
                                currsigs.addElement(stationState_1);
                                stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 140, column: 6
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S158457=4;
                                active[3]=1;
                                ends[3]=1;
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
                }
                else {
                  active[3]=1;
                  ends[3]=1;
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

  public void thread166188(int [] tdone, int [] ends){
        switch(S158433){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(stationState_1.getprestatus()){//sysj\recyclingStationController.sysj line: 81, column: 12
          cur_thread_2 = ((Integer)(stationState_1.getpreval() == null ? 0 : ((Integer)stationState_1.getpreval()).intValue())).intValue();//sysj\recyclingStationController.sysj line: 82, column: 5
          recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 84, column: 4
          currsigs.addElement(recyclingStatus);
          recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 84, column: 4
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 84, column: 4
          currsigs.addElement(recyclingStatus);
          recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 84, column: 4
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread166186(int [] tdone, int [] ends){
        S166181=1;
    m_thread_3 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 107, column: 3
    TO_LID_thread_3 = 1;//sysj\recyclingStationController.sysj line: 110, column: 3
    TO_DUMP_thread_3 = 2;//sysj\recyclingStationController.sysj line: 111, column: 3
    TO_RETURN_thread_3 = 3;//sysj\recyclingStationController.sysj line: 112, column: 3
    DISCHARGE_thread_3 = 4;//sysj\recyclingStationController.sysj line: 113, column: 3
    w_thread_3 = null;//sysj\recyclingStationController.sysj line: 115, column: 3
    S158457=0;
    S158441=0;
    if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 123, column: 4
      bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
      S158441=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S158436=0;
      if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
        bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 123, column: 4
        S158436=1;
        if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
          bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
          ends[3]=2;
          ;//sysj\recyclingStationController.sysj line: 123, column: 4
          w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 124, column: 4
          m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 125, column: 4
          stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 126, column: 4
          currsigs.addElement(stationState_1);
          stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 126, column: 4
          S158457=1;
          S158464=0;
          if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
            enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
            S158464=1;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
          else {
            S158459=0;
            if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
              enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
              S158459=1;
              if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                ends[3]=2;
                ;//sysj\recyclingStationController.sysj line: 129, column: 4
                S158457=2;
                S158552=0;
                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                  S158552=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158547=0;
                  if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                    statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                    S158547=1;
                    if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                      statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 130, column: 4
                      m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                      S158457=3;
                      if(m_thread_3.jammed()){//sysj\recyclingStationController.sysj line: 137, column: 4
                        m_thread_3.reportJam();//sysj\recyclingStationController.sysj line: 138, column: 5
                        stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 140, column: 6
                        currsigs.addElement(stationState_1);
                        stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 140, column: 6
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S158457=4;
                        active[3]=1;
                        ends[3]=1;
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
        }
        else {
          active[3]=1;
          ends[3]=1;
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

  public void thread166185(int [] tdone, int [] ends){
        S158433=1;
    cur_thread_2 = 0;//sysj\recyclingStationController.sysj line: 79, column: 3
    if(stationState_1.getprestatus()){//sysj\recyclingStationController.sysj line: 81, column: 12
      cur_thread_2 = ((Integer)(stationState_1.getpreval() == null ? 0 : ((Integer)stationState_1.getpreval()).intValue())).intValue();//sysj\recyclingStationController.sysj line: 82, column: 5
      recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 84, column: 4
      currsigs.addElement(recyclingStatus);
      recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 84, column: 4
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
    else {
      recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 84, column: 4
      currsigs.addElement(recyclingStatus);
      recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 84, column: 4
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
      switch(S166183){
        case 0 : 
          S166183=0;
          break RUN;
        
        case 1 : 
          S166183=2;
          S166183=2;
          stationState_1.setClear();//sysj\recyclingStationController.sysj line: 76, column: 2
          thread166185(tdone,ends);
          thread166186(tdone,ends);
          int biggest166187 = 0;
          if(ends[2]>=biggest166187){
            biggest166187=ends[2];
          }
          if(ends[3]>=biggest166187){
            biggest166187=ends[3];
          }
          if(biggest166187 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          stationState_1.setClear();//sysj\recyclingStationController.sysj line: 76, column: 2
          thread166188(tdone,ends);
          thread166189(tdone,ends);
          int biggest166190 = 0;
          if(ends[2]>=biggest166190){
            biggest166190=ends[2];
          }
          if(ends[3]>=biggest166190){
            biggest166190=ends[3];
          }
          if(biggest166190 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest166190 == 0){
            S166183=0;
            active[1]=0;
            ends[1]=0;
            S166183=0;
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
          df = true;
        }
        runClockDomain();
      }
      recyclingStatus.setpreclear();
      stationState_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
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
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
