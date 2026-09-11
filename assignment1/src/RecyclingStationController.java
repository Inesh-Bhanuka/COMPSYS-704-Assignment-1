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
  private int S165666 = 1;
  private int S157916 = 1;
  private int S165664 = 1;
  private int S157940 = 1;
  private int S157924 = 1;
  private int S157919 = 1;
  private int S157947 = 1;
  private int S157942 = 1;
  private int S158035 = 1;
  private int S158030 = 1;
  private int S158231 = 1;
  private int S158226 = 1;
  private int S158275 = 1;
  private int S158270 = 1;
  private int S158363 = 1;
  private int S158358 = 1;
  private int S158407 = 1;
  private int S158402 = 1;
  private int S158495 = 1;
  private int S158490 = 1;
  private int S158539 = 1;
  private int S158534 = 1;
  private int S158627 = 1;
  private int S158622 = 1;
  private int S158671 = 1;
  private int S158666 = 1;
  private int S158759 = 1;
  private int S158754 = 1;
  private int S158803 = 1;
  private int S158798 = 1;
  private int S158891 = 1;
  private int S158886 = 1;
  private int S158935 = 1;
  private int S158930 = 1;
  private int S159023 = 1;
  private int S159018 = 1;
  private int S159067 = 1;
  private int S159062 = 1;
  private int S159155 = 1;
  private int S159150 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread165672(int [] tdone, int [] ends){
        switch(S165664){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S157940){
          case 0 : 
            switch(S157924){
              case 0 : 
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 123, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                  S157924=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S157919){
                    case 0 : 
                      if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                        bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 123, column: 4
                        S157919=1;
                        if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                          bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 123, column: 4
                          w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 124, column: 4
                          m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 125, column: 4
                          stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 126, column: 4
                          currsigs.addElement(stationState_1);
                          stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 126, column: 4
                          S157940=1;
                          S157947=0;
                          if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                            enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                            S157947=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S157942=0;
                            if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                              enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                              S157942=1;
                              if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                                enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 129, column: 4
                                S157940=2;
                                S158035=0;
                                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                  S158035=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S158030=0;
                                  if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                    statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                                    S158030=1;
                                    if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                      statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                      ends[3]=2;
                                      ;//sysj\recyclingStationController.sysj line: 130, column: 4
                                      m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                                      S157940=3;
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
                                        S157940=4;
                                        active[3]=1;
                                        ends[3]=1;
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
                        S157940=1;
                        S157947=0;
                        if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                          enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                          S157947=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S157942=0;
                          if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                            enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                            S157942=1;
                            if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                              enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 129, column: 4
                              S157940=2;
                              S158035=0;
                              if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                S158035=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S158030=0;
                                if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                  statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                                  S158030=1;
                                  if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                    statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                    ends[3]=2;
                                    ;//sysj\recyclingStationController.sysj line: 130, column: 4
                                    m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                                    S157940=3;
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
                                      S157940=4;
                                      active[3]=1;
                                      ends[3]=1;
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
                S157924=1;
                S157924=0;
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 123, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                  S157924=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S157919=0;
                  if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                    bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 123, column: 4
                    S157919=1;
                    if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                      bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 123, column: 4
                      w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 124, column: 4
                      m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 125, column: 4
                      stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 126, column: 4
                      currsigs.addElement(stationState_1);
                      stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 126, column: 4
                      S157940=1;
                      S157947=0;
                      if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                        enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                        S157947=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S157942=0;
                        if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                          enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                          S157942=1;
                          if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                            enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 129, column: 4
                            S157940=2;
                            S158035=0;
                            if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                              statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                              S158035=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S158030=0;
                              if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                                S158030=1;
                                if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                  ends[3]=2;
                                  ;//sysj\recyclingStationController.sysj line: 130, column: 4
                                  m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                                  S157940=3;
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
                                    S157940=4;
                                    active[3]=1;
                                    ends[3]=1;
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
            switch(S157947){
              case 0 : 
                if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                  enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                  S157947=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S157942){
                    case 0 : 
                      if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                        enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                        S157942=1;
                        if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                          enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 129, column: 4
                          S157940=2;
                          S158035=0;
                          if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                            statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                            S158035=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S158030=0;
                            if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                              statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                              S158030=1;
                              if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 130, column: 4
                                m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                                S157940=3;
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
                                  S157940=4;
                                  active[3]=1;
                                  ends[3]=1;
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
                        S157940=2;
                        S158035=0;
                        if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                          statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                          S158035=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S158030=0;
                          if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                            statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                            S158030=1;
                            if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                              statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 130, column: 4
                              m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                              S157940=3;
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
                                S157940=4;
                                active[3]=1;
                                ends[3]=1;
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
                S157947=1;
                S157947=0;
                if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                  enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                  S157947=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S157942=0;
                  if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                    enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                    S157942=1;
                    if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                      enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 129, column: 4
                      S157940=2;
                      S158035=0;
                      if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                        statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                        S158035=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S158030=0;
                        if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                          statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                          S158030=1;
                          if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                            statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 130, column: 4
                            m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                            S157940=3;
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
                              S157940=4;
                              active[3]=1;
                              ends[3]=1;
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
            switch(S158035){
              case 0 : 
                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                  S158035=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158030){
                    case 0 : 
                      if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                        statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                        S158030=1;
                        if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                          statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 130, column: 4
                          m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                          S157940=3;
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
                            S157940=4;
                            active[3]=1;
                            ends[3]=1;
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
                        S157940=3;
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
                          S157940=4;
                          active[3]=1;
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
                S158035=1;
                S158035=0;
                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                  S158035=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158030=0;
                  if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                    statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                    S158030=1;
                    if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                      statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 130, column: 4
                      m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                      S157940=3;
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
                        S157940=4;
                        active[3]=1;
                        ends[3]=1;
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
            S157940=4;
            S157940=5;
            S158231=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 147, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
              S158231=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S158226=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                enableConveyor_o.setVal(new Integer(TO_LID_thread_3));//sysj\recyclingStationController.sysj line: 147, column: 4
                S158226=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 147, column: 4
                  S157940=6;
                  S158275=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                    S158275=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S158270=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                      S158270=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 148, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                        S157940=7;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            switch(S158231){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 147, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                  S158231=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158226){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                        enableConveyor_o.setVal(new Integer(TO_LID_thread_3));//sysj\recyclingStationController.sysj line: 147, column: 4
                        S158226=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 147, column: 4
                          S157940=6;
                          S158275=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                            S158275=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S158270=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                              S158270=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 148, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                                S157940=7;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                        S157940=6;
                        S158275=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                          S158275=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S158270=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                            S158270=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 148, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                              S157940=7;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
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
                S158231=1;
                S158231=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 147, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                  S158231=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158226=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                    enableConveyor_o.setVal(new Integer(TO_LID_thread_3));//sysj\recyclingStationController.sysj line: 147, column: 4
                    S158226=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 147, column: 4
                      S157940=6;
                      S158275=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                        S158275=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S158270=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                          S158270=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 148, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                            S157940=7;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            switch(S158275){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                  S158275=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158270){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                        S158270=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 148, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                          S157940=7;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S157940=7;
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
                S158275=1;
                S158275=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                  S158275=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158270=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                    S158270=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 148, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                      S157940=7;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S157940=7;
            S157940=8;
            S158363=0;
            if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 153, column: 4
              enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
              S158363=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S158358=0;
              if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                enableLidRemoval_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 153, column: 4
                S158358=1;
                if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 153, column: 4
                  S157940=9;
                  S158407=0;
                  if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                    statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                    S158407=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S158402=0;
                    if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                      statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                      S158402=1;
                      if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 154, column: 4
                        m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                        S157940=10;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            switch(S158363){
              case 0 : 
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 153, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                  S158363=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158358){
                    case 0 : 
                      if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                        enableLidRemoval_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 153, column: 4
                        S158358=1;
                        if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                          enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 153, column: 4
                          S157940=9;
                          S158407=0;
                          if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                            S158407=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S158402=0;
                            if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                              statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                              S158402=1;
                              if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                                statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 154, column: 4
                                m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                                S157940=10;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                        S157940=9;
                        S158407=0;
                        if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                          S158407=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S158402=0;
                          if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                            statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                            S158402=1;
                            if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                              statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 154, column: 4
                              m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                              S157940=10;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
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
                S158363=1;
                S158363=0;
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 153, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                  S158363=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158358=0;
                  if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                    enableLidRemoval_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 153, column: 4
                    S158358=1;
                    if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                      enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 153, column: 4
                      S157940=9;
                      S158407=0;
                      if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                        S158407=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S158402=0;
                        if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                          statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                          S158402=1;
                          if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 154, column: 4
                            m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                            S157940=10;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            switch(S158407){
              case 0 : 
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                  S158407=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158402){
                    case 0 : 
                      if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                        statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                        S158402=1;
                        if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 154, column: 4
                          m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                          S157940=10;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S157940=10;
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
                S158407=1;
                S158407=0;
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                  S158407=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158402=0;
                  if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                    statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                    S158402=1;
                    if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                      statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 154, column: 4
                      m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                      S157940=10;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S157940=10;
            S157940=11;
            S158495=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 159, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
              S158495=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S158490=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                enableConveyor_o.setVal(new Integer(TO_DUMP_thread_3));//sysj\recyclingStationController.sysj line: 159, column: 4
                S158490=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 159, column: 4
                  S157940=12;
                  S158539=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                    S158539=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S158534=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                      S158534=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 160, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                        S157940=13;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            switch(S158495){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 159, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                  S158495=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158490){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                        enableConveyor_o.setVal(new Integer(TO_DUMP_thread_3));//sysj\recyclingStationController.sysj line: 159, column: 4
                        S158490=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 159, column: 4
                          S157940=12;
                          S158539=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                            S158539=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S158534=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                              S158534=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 160, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                                S157940=13;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                        S157940=12;
                        S158539=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                          S158539=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S158534=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                            S158534=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 160, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                              S157940=13;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
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
                S158495=1;
                S158495=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 159, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                  S158495=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158490=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                    enableConveyor_o.setVal(new Integer(TO_DUMP_thread_3));//sysj\recyclingStationController.sysj line: 159, column: 4
                    S158490=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 159, column: 4
                      S157940=12;
                      S158539=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                        S158539=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S158534=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                          S158534=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 160, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                            S157940=13;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            switch(S158539){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                  S158539=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158534){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                        S158534=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 160, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                          S157940=13;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S157940=13;
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
                S158539=1;
                S158539=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                  S158539=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158534=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                    S158534=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 160, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                      S157940=13;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S157940=13;
            S157940=14;
            S158627=0;
            if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 165, column: 4
              enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
              S158627=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S158622=0;
              if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                enableDumper_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 165, column: 4
                S158622=1;
                if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 165, column: 4
                  S157940=15;
                  S158671=0;
                  if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                    statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                    S158671=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S158666=0;
                    if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                      statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                      S158666=1;
                      if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 166, column: 4
                        m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                        S157940=16;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            switch(S158627){
              case 0 : 
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 165, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                  S158627=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158622){
                    case 0 : 
                      if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                        enableDumper_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 165, column: 4
                        S158622=1;
                        if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                          enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 165, column: 4
                          S157940=15;
                          S158671=0;
                          if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                            S158671=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S158666=0;
                            if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                              statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                              S158666=1;
                              if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                                statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 166, column: 4
                                m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                                S157940=16;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                        S157940=15;
                        S158671=0;
                        if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                          S158671=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S158666=0;
                          if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                            statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                            S158666=1;
                            if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                              statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 166, column: 4
                              m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                              S157940=16;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
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
                S158627=1;
                S158627=0;
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 165, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                  S158627=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158622=0;
                  if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                    enableDumper_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 165, column: 4
                    S158622=1;
                    if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                      enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 165, column: 4
                      S157940=15;
                      S158671=0;
                      if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                        S158671=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S158666=0;
                        if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                          statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                          S158666=1;
                          if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 166, column: 4
                            m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                            S157940=16;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            switch(S158671){
              case 0 : 
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                  S158671=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158666){
                    case 0 : 
                      if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                        statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                        S158666=1;
                        if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 166, column: 4
                          m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                          S157940=16;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S157940=16;
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
                S158671=1;
                S158671=0;
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                  S158671=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158666=0;
                  if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                    statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                    S158666=1;
                    if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                      statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 166, column: 4
                      m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                      S157940=16;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S157940=16;
            S157940=17;
            S158759=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 171, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
              S158759=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S158754=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                enableConveyor_o.setVal(new Integer(TO_RETURN_thread_3));//sysj\recyclingStationController.sysj line: 171, column: 4
                S158754=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 171, column: 4
                  S157940=18;
                  S158803=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                    S158803=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S158798=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                      S158798=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 172, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                        S157940=19;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            switch(S158759){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 171, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                  S158759=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158754){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                        enableConveyor_o.setVal(new Integer(TO_RETURN_thread_3));//sysj\recyclingStationController.sysj line: 171, column: 4
                        S158754=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 171, column: 4
                          S157940=18;
                          S158803=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                            S158803=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S158798=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                              S158798=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 172, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                                S157940=19;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                        S157940=18;
                        S158803=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                          S158803=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S158798=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                            S158798=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 172, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                              S157940=19;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
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
                S158759=1;
                S158759=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 171, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                  S158759=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158754=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                    enableConveyor_o.setVal(new Integer(TO_RETURN_thread_3));//sysj\recyclingStationController.sysj line: 171, column: 4
                    S158754=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 171, column: 4
                      S157940=18;
                      S158803=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                        S158803=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S158798=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                          S158798=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 172, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                            S157940=19;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            switch(S158803){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                  S158803=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158798){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                        S158798=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 172, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                          S157940=19;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S157940=19;
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
                S158803=1;
                S158803=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                  S158803=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158798=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                    S158798=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 172, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                      S157940=19;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S157940=19;
            S157940=20;
            S158891=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 177, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
              S158891=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S158886=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                enableConveyor_o.setVal(new Integer(DISCHARGE_thread_3));//sysj\recyclingStationController.sysj line: 177, column: 4
                S158886=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 177, column: 4
                  S157940=21;
                  S158935=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                    S158935=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S158930=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                      S158930=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 178, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                        S157940=22;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            switch(S158891){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 177, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                  S158891=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158886){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                        enableConveyor_o.setVal(new Integer(DISCHARGE_thread_3));//sysj\recyclingStationController.sysj line: 177, column: 4
                        S158886=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 177, column: 4
                          S157940=21;
                          S158935=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                            S158935=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S158930=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                              S158930=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 178, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                                S157940=22;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                        S157940=21;
                        S158935=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                          S158935=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S158930=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                            S158930=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 178, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                              S157940=22;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
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
                S158891=1;
                S158891=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 177, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                  S158891=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158886=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                    enableConveyor_o.setVal(new Integer(DISCHARGE_thread_3));//sysj\recyclingStationController.sysj line: 177, column: 4
                    S158886=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 177, column: 4
                      S157940=21;
                      S158935=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                        S158935=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S158930=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                          S158930=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 178, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                            S157940=22;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            switch(S158935){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                  S158935=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S158930){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                        S158930=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 178, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                          S157940=22;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S157940=22;
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
                S158935=1;
                S158935=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                  S158935=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158930=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                    S158930=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 178, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                      S157940=22;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S157940=22;
            S157940=23;
            S159023=0;
            if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 183, column: 4
              enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
              S159023=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S159018=0;
              if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                enableReturn_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 183, column: 4
                S159018=1;
                if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 183, column: 4
                  S157940=24;
                  S159067=0;
                  if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                    statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                    S159067=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S159062=0;
                    if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                      statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                      S159062=1;
                      if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 184, column: 4
                        m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                        S157940=25;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            switch(S159023){
              case 0 : 
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 183, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                  S159023=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S159018){
                    case 0 : 
                      if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                        enableReturn_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 183, column: 4
                        S159018=1;
                        if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                          enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 183, column: 4
                          S157940=24;
                          S159067=0;
                          if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                            S159067=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S159062=0;
                            if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                              statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                              S159062=1;
                              if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                                statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 184, column: 4
                                m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                                S157940=25;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                        S157940=24;
                        S159067=0;
                        if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                          S159067=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S159062=0;
                          if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                            statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                            S159062=1;
                            if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                              statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 184, column: 4
                              m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                              S157940=25;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
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
                S159023=1;
                S159023=0;
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 183, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                  S159023=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S159018=0;
                  if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                    enableReturn_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 183, column: 4
                    S159018=1;
                    if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                      enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 183, column: 4
                      S157940=24;
                      S159067=0;
                      if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                        S159067=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S159062=0;
                        if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                          statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                          S159062=1;
                          if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 184, column: 4
                            m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                            S157940=25;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            switch(S159067){
              case 0 : 
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                  S159067=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S159062){
                    case 0 : 
                      if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                        statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                        S159062=1;
                        if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 184, column: 4
                          m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                          S157940=25;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S157940=25;
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
                S159067=1;
                S159067=0;
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                  S159067=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S159062=0;
                  if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                    statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                    S159062=1;
                    if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                      statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 184, column: 4
                      m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                      S157940=25;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S157940=25;
            m_thread_3.reportRecovered();//sysj\recyclingStationController.sysj line: 189, column: 4
            S157940=26;
            S159155=0;
            if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 190, column: 4
              bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
              S159155=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S159150=0;
              if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                bottleRecycled_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 190, column: 4
                S159150=1;
                if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 190, column: 4
                  S157940=27;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  active[3]=1;
                  ends[3]=1;
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
            switch(S159155){
              case 0 : 
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 190, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                  S159155=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S159150){
                    case 0 : 
                      if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                        bottleRecycled_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 190, column: 4
                        S159150=1;
                        if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                          bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 190, column: 4
                          S157940=27;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S157940=27;
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
                S159155=1;
                S159155=0;
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 190, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                  S159155=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S159150=0;
                  if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                    bottleRecycled_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 190, column: 4
                    S159150=1;
                    if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                      bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 190, column: 4
                      S157940=27;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S157940=27;
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 195, column: 4
            currsigs.addElement(stationState_1);
            stationState_1.setValue(m_thread_3.restingState());//sysj\recyclingStationController.sysj line: 195, column: 4
            S157940=28;
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
              S157940=29;
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
            S157940=29;
            S157940=0;
            S157924=0;
            if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 123, column: 4
              bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
              S157924=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S157919=0;
              if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 123, column: 4
                S157919=1;
                if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 123, column: 4
                  w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 124, column: 4
                  m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 125, column: 4
                  stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 126, column: 4
                  currsigs.addElement(stationState_1);
                  stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 126, column: 4
                  S157940=1;
                  S157947=0;
                  if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                    enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                    S157947=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S157942=0;
                    if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                      enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                      S157942=1;
                      if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                        enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 129, column: 4
                        S157940=2;
                        S158035=0;
                        if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                          statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                          S158035=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S158030=0;
                          if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                            statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                            S158030=1;
                            if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                              statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 130, column: 4
                              m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                              S157940=3;
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
                                S157940=4;
                                active[3]=1;
                                ends[3]=1;
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

  public void thread165671(int [] tdone, int [] ends){
        switch(S157916){
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

  public void thread165669(int [] tdone, int [] ends){
        S165664=1;
    m_thread_3 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 107, column: 3
    TO_LID_thread_3 = 1;//sysj\recyclingStationController.sysj line: 110, column: 3
    TO_DUMP_thread_3 = 2;//sysj\recyclingStationController.sysj line: 111, column: 3
    TO_RETURN_thread_3 = 3;//sysj\recyclingStationController.sysj line: 112, column: 3
    DISCHARGE_thread_3 = 4;//sysj\recyclingStationController.sysj line: 113, column: 3
    w_thread_3 = null;//sysj\recyclingStationController.sysj line: 115, column: 3
    S157940=0;
    S157924=0;
    if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 123, column: 4
      bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
      S157924=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S157919=0;
      if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
        bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 123, column: 4
        S157919=1;
        if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
          bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
          ends[3]=2;
          ;//sysj\recyclingStationController.sysj line: 123, column: 4
          w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 124, column: 4
          m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 125, column: 4
          stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 126, column: 4
          currsigs.addElement(stationState_1);
          stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 126, column: 4
          S157940=1;
          S157947=0;
          if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
            enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
            S157947=1;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
          else {
            S157942=0;
            if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
              enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
              S157942=1;
              if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                ends[3]=2;
                ;//sysj\recyclingStationController.sysj line: 129, column: 4
                S157940=2;
                S158035=0;
                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                  S158035=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S158030=0;
                  if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                    statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                    S158030=1;
                    if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                      statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 130, column: 4
                      m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                      S157940=3;
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
                        S157940=4;
                        active[3]=1;
                        ends[3]=1;
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

  public void thread165668(int [] tdone, int [] ends){
        S157916=1;
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
      switch(S165666){
        case 0 : 
          S165666=0;
          break RUN;
        
        case 1 : 
          S165666=2;
          S165666=2;
          stationState_1.setClear();//sysj\recyclingStationController.sysj line: 76, column: 2
          thread165668(tdone,ends);
          thread165669(tdone,ends);
          int biggest165670 = 0;
          if(ends[2]>=biggest165670){
            biggest165670=ends[2];
          }
          if(ends[3]>=biggest165670){
            biggest165670=ends[3];
          }
          if(biggest165670 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          stationState_1.setClear();//sysj\recyclingStationController.sysj line: 76, column: 2
          thread165671(tdone,ends);
          thread165672(tdone,ends);
          int biggest165673 = 0;
          if(ends[2]>=biggest165673){
            biggest165673=ends[2];
          }
          if(ends[3]>=biggest165673){
            biggest165673=ends[3];
          }
          if(biggest165673 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest165673 == 0){
            S165666=0;
            active[1]=0;
            ends[1]=0;
            S165666=0;
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
