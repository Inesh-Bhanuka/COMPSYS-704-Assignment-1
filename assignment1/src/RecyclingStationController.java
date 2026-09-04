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
  private Workpiece w_thread_3;//sysj\recyclingStationController.sysj line: 115, column: 3
  private int S128319 = 1;
  private int S120569 = 1;
  private int S128317 = 1;
  private int S120593 = 1;
  private int S120577 = 1;
  private int S120572 = 1;
  private int S120600 = 1;
  private int S120595 = 1;
  private int S120688 = 1;
  private int S120683 = 1;
  private int S120884 = 1;
  private int S120879 = 1;
  private int S120928 = 1;
  private int S120923 = 1;
  private int S121016 = 1;
  private int S121011 = 1;
  private int S121060 = 1;
  private int S121055 = 1;
  private int S121148 = 1;
  private int S121143 = 1;
  private int S121192 = 1;
  private int S121187 = 1;
  private int S121280 = 1;
  private int S121275 = 1;
  private int S121324 = 1;
  private int S121319 = 1;
  private int S121412 = 1;
  private int S121407 = 1;
  private int S121456 = 1;
  private int S121451 = 1;
  private int S121544 = 1;
  private int S121539 = 1;
  private int S121588 = 1;
  private int S121583 = 1;
  private int S121676 = 1;
  private int S121671 = 1;
  private int S121720 = 1;
  private int S121715 = 1;
  private int S121808 = 1;
  private int S121803 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread128325(int [] tdone, int [] ends){
        switch(S128317){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S120593){
          case 0 : 
            switch(S120577){
              case 0 : 
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 123, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                  S120577=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S120572){
                    case 0 : 
                      if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                        bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 123, column: 4
                        S120572=1;
                        if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                          bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 123, column: 4
                          w_thread_3 = (Workpiece)(bottleRejected_in.getVal() == null ? null : ((Workpiece)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 124, column: 4
                          m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 125, column: 4
                          stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 126, column: 4
                          currsigs.addElement(stationState_1);
                          stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 126, column: 4
                          S120593=1;
                          S120600=0;
                          if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                            enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                            S120600=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S120595=0;
                            if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                              enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                              S120595=1;
                              if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                                enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 129, column: 4
                                S120593=2;
                                S120688=0;
                                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                  S120688=1;
                                  active[3]=1;
                                  ends[3]=1;
                                  tdone[3]=1;
                                }
                                else {
                                  S120683=0;
                                  if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                    statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                                    S120683=1;
                                    if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                      statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                      ends[3]=2;
                                      ;//sysj\recyclingStationController.sysj line: 130, column: 4
                                      m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                                      S120593=3;
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
                                        S120593=4;
                                        active[3]=1;
                                        ends[3]=1;
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
                        w_thread_3 = (Workpiece)(bottleRejected_in.getVal() == null ? null : ((Workpiece)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 124, column: 4
                        m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 125, column: 4
                        stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 126, column: 4
                        currsigs.addElement(stationState_1);
                        stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 126, column: 4
                        S120593=1;
                        S120600=0;
                        if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                          enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                          S120600=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S120595=0;
                          if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                            enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                            S120595=1;
                            if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                              enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 129, column: 4
                              S120593=2;
                              S120688=0;
                              if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                S120688=1;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                S120683=0;
                                if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                  statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                                  S120683=1;
                                  if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                    statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                    ends[3]=2;
                                    ;//sysj\recyclingStationController.sysj line: 130, column: 4
                                    m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                                    S120593=3;
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
                                      S120593=4;
                                      active[3]=1;
                                      ends[3]=1;
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
                S120577=1;
                S120577=0;
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 123, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                  S120577=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S120572=0;
                  if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                    bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 123, column: 4
                    S120572=1;
                    if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                      bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 123, column: 4
                      w_thread_3 = (Workpiece)(bottleRejected_in.getVal() == null ? null : ((Workpiece)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 124, column: 4
                      m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 125, column: 4
                      stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 126, column: 4
                      currsigs.addElement(stationState_1);
                      stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 126, column: 4
                      S120593=1;
                      S120600=0;
                      if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                        enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                        S120600=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S120595=0;
                        if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                          enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                          S120595=1;
                          if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                            enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 129, column: 4
                            S120593=2;
                            S120688=0;
                            if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                              statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                              S120688=1;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              S120683=0;
                              if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                                S120683=1;
                                if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                  ends[3]=2;
                                  ;//sysj\recyclingStationController.sysj line: 130, column: 4
                                  m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                                  S120593=3;
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
                                    S120593=4;
                                    active[3]=1;
                                    ends[3]=1;
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
            switch(S120600){
              case 0 : 
                if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                  enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                  S120600=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S120595){
                    case 0 : 
                      if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                        enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                        S120595=1;
                        if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                          enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 129, column: 4
                          S120593=2;
                          S120688=0;
                          if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                            statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                            S120688=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S120683=0;
                            if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                              statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                              S120683=1;
                              if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                                statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 130, column: 4
                                m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                                S120593=3;
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
                                  S120593=4;
                                  active[3]=1;
                                  ends[3]=1;
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
                        S120593=2;
                        S120688=0;
                        if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                          statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                          S120688=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S120683=0;
                          if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                            statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                            S120683=1;
                            if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                              statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 130, column: 4
                              m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                              S120593=3;
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
                                S120593=4;
                                active[3]=1;
                                ends[3]=1;
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
                S120600=1;
                S120600=0;
                if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                  enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                  S120600=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S120595=0;
                  if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                    enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                    S120595=1;
                    if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                      enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 129, column: 4
                      S120593=2;
                      S120688=0;
                      if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                        statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                        S120688=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S120683=0;
                        if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                          statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                          S120683=1;
                          if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                            statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 130, column: 4
                            m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                            S120593=3;
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
                              S120593=4;
                              active[3]=1;
                              ends[3]=1;
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
            switch(S120688){
              case 0 : 
                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                  S120688=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S120683){
                    case 0 : 
                      if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                        statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                        S120683=1;
                        if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                          statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 130, column: 4
                          m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                          S120593=3;
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
                            S120593=4;
                            active[3]=1;
                            ends[3]=1;
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
                        S120593=3;
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
                          S120593=4;
                          active[3]=1;
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
                S120688=1;
                S120688=0;
                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                  S120688=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S120683=0;
                  if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                    statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                    S120683=1;
                    if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                      statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 130, column: 4
                      m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                      S120593=3;
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
                        S120593=4;
                        active[3]=1;
                        ends[3]=1;
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
            S120593=4;
            S120593=5;
            S120884=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 147, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
              S120884=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S120879=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                enableConveyor_o.setVal(new Integer(TO_LID_thread_3));//sysj\recyclingStationController.sysj line: 147, column: 4
                S120879=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 147, column: 4
                  S120593=6;
                  S120928=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                    S120928=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S120923=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                      S120923=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 148, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                        S120593=7;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            switch(S120884){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 147, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                  S120884=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S120879){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                        enableConveyor_o.setVal(new Integer(TO_LID_thread_3));//sysj\recyclingStationController.sysj line: 147, column: 4
                        S120879=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 147, column: 4
                          S120593=6;
                          S120928=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                            S120928=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S120923=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                              S120923=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 148, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                                S120593=7;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                        S120593=6;
                        S120928=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                          S120928=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S120923=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                            S120923=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 148, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                              S120593=7;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
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
                S120884=1;
                S120884=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 147, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                  S120884=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S120879=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                    enableConveyor_o.setVal(new Integer(TO_LID_thread_3));//sysj\recyclingStationController.sysj line: 147, column: 4
                    S120879=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 147, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 147, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 147, column: 4
                      S120593=6;
                      S120928=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                        S120928=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S120923=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                          S120923=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 148, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                            S120593=7;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            switch(S120928){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                  S120928=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S120923){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                        S120923=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 148, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                          S120593=7;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S120593=7;
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
                S120928=1;
                S120928=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 148, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                  S120928=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S120923=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 148, column: 4
                    S120923=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 148, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 148, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 148, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 149, column: 4
                      S120593=7;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S120593=7;
            S120593=8;
            S121016=0;
            if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 153, column: 4
              enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
              S121016=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S121011=0;
              if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                enableLidRemoval_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 153, column: 4
                S121011=1;
                if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 153, column: 4
                  S120593=9;
                  S121060=0;
                  if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                    statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                    S121060=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S121055=0;
                    if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                      statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                      S121055=1;
                      if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 154, column: 4
                        m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                        S120593=10;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            switch(S121016){
              case 0 : 
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 153, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                  S121016=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S121011){
                    case 0 : 
                      if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                        enableLidRemoval_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 153, column: 4
                        S121011=1;
                        if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                          enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 153, column: 4
                          S120593=9;
                          S121060=0;
                          if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                            S121060=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S121055=0;
                            if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                              statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                              S121055=1;
                              if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                                statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 154, column: 4
                                m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                                S120593=10;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                        S120593=9;
                        S121060=0;
                        if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                          S121060=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S121055=0;
                          if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                            statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                            S121055=1;
                            if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                              statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 154, column: 4
                              m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                              S120593=10;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
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
                S121016=1;
                S121016=0;
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 153, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                  S121016=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S121011=0;
                  if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                    enableLidRemoval_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 153, column: 4
                    S121011=1;
                    if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 153, column: 4
                      enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 153, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 153, column: 4
                      S120593=9;
                      S121060=0;
                      if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                        S121060=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S121055=0;
                        if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                          statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                          S121055=1;
                          if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 154, column: 4
                            m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                            S120593=10;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            switch(S121060){
              case 0 : 
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                  S121060=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S121055){
                    case 0 : 
                      if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                        statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                        S121055=1;
                        if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 154, column: 4
                          m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                          S120593=10;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S120593=10;
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
                S121060=1;
                S121060=0;
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 154, column: 4
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                  S121060=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S121055=0;
                  if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                    statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 154, column: 4
                    S121055=1;
                    if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 154, column: 4
                      statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 154, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 154, column: 4
                      m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 155, column: 4
                      S120593=10;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S120593=10;
            S120593=11;
            S121148=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 159, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
              S121148=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S121143=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                enableConveyor_o.setVal(new Integer(TO_DUMP_thread_3));//sysj\recyclingStationController.sysj line: 159, column: 4
                S121143=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 159, column: 4
                  S120593=12;
                  S121192=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                    S121192=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S121187=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                      S121187=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 160, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                        S120593=13;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            switch(S121148){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 159, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                  S121148=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S121143){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                        enableConveyor_o.setVal(new Integer(TO_DUMP_thread_3));//sysj\recyclingStationController.sysj line: 159, column: 4
                        S121143=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 159, column: 4
                          S120593=12;
                          S121192=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                            S121192=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S121187=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                              S121187=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 160, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                                S120593=13;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                        S120593=12;
                        S121192=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                          S121192=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S121187=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                            S121187=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 160, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                              S120593=13;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
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
                S121148=1;
                S121148=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 159, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                  S121148=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S121143=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                    enableConveyor_o.setVal(new Integer(TO_DUMP_thread_3));//sysj\recyclingStationController.sysj line: 159, column: 4
                    S121143=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 159, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 159, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 159, column: 4
                      S120593=12;
                      S121192=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                        S121192=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S121187=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                          S121187=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 160, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                            S120593=13;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            switch(S121192){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                  S121192=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S121187){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                        S121187=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 160, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                          S120593=13;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S120593=13;
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
                S121192=1;
                S121192=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 160, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                  S121192=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S121187=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 160, column: 4
                    S121187=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 160, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 160, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 160, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 161, column: 4
                      S120593=13;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S120593=13;
            S120593=14;
            S121280=0;
            if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 165, column: 4
              enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
              S121280=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S121275=0;
              if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                enableDumper_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 165, column: 4
                S121275=1;
                if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 165, column: 4
                  S120593=15;
                  S121324=0;
                  if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                    statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                    S121324=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S121319=0;
                    if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                      statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                      S121319=1;
                      if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 166, column: 4
                        m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                        S120593=16;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            switch(S121280){
              case 0 : 
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 165, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                  S121280=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S121275){
                    case 0 : 
                      if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                        enableDumper_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 165, column: 4
                        S121275=1;
                        if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                          enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 165, column: 4
                          S120593=15;
                          S121324=0;
                          if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                            S121324=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S121319=0;
                            if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                              statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                              S121319=1;
                              if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                                statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 166, column: 4
                                m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                                S120593=16;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                        S120593=15;
                        S121324=0;
                        if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                          S121324=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S121319=0;
                          if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                            statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                            S121319=1;
                            if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                              statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 166, column: 4
                              m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                              S120593=16;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
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
                S121280=1;
                S121280=0;
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 165, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                  S121280=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S121275=0;
                  if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                    enableDumper_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 165, column: 4
                    S121275=1;
                    if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 165, column: 4
                      enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 165, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 165, column: 4
                      S120593=15;
                      S121324=0;
                      if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                        S121324=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S121319=0;
                        if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                          statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                          S121319=1;
                          if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 166, column: 4
                            m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                            S120593=16;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            switch(S121324){
              case 0 : 
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                  S121324=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S121319){
                    case 0 : 
                      if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                        statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                        S121319=1;
                        if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 166, column: 4
                          m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                          S120593=16;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S120593=16;
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
                S121324=1;
                S121324=0;
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 166, column: 4
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                  S121324=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S121319=0;
                  if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                    statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 166, column: 4
                    S121319=1;
                    if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 166, column: 4
                      statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 166, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 166, column: 4
                      m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 167, column: 4
                      S120593=16;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S120593=16;
            S120593=17;
            S121412=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 171, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
              S121412=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S121407=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                enableConveyor_o.setVal(new Integer(TO_RETURN_thread_3));//sysj\recyclingStationController.sysj line: 171, column: 4
                S121407=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 171, column: 4
                  S120593=18;
                  S121456=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                    S121456=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S121451=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                      S121451=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 172, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                        S120593=19;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            switch(S121412){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 171, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                  S121412=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S121407){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                        enableConveyor_o.setVal(new Integer(TO_RETURN_thread_3));//sysj\recyclingStationController.sysj line: 171, column: 4
                        S121407=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 171, column: 4
                          S120593=18;
                          S121456=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                            S121456=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S121451=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                              S121451=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 172, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                                S120593=19;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                        S120593=18;
                        S121456=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                          S121456=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S121451=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                            S121451=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 172, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                              S120593=19;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
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
                S121412=1;
                S121412=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 171, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                  S121412=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S121407=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                    enableConveyor_o.setVal(new Integer(TO_RETURN_thread_3));//sysj\recyclingStationController.sysj line: 171, column: 4
                    S121407=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 171, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 171, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 171, column: 4
                      S120593=18;
                      S121456=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                        S121456=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S121451=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                          S121451=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 172, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                            S120593=19;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            switch(S121456){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                  S121456=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S121451){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                        S121451=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 172, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                          S120593=19;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S120593=19;
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
                S121456=1;
                S121456=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                  S121456=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S121451=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 172, column: 4
                    S121451=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 172, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 172, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 172, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 173, column: 4
                      S120593=19;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S120593=19;
            S120593=20;
            S121544=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 177, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
              S121544=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S121539=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                enableConveyor_o.setVal(new Integer(DISCHARGE_thread_3));//sysj\recyclingStationController.sysj line: 177, column: 4
                S121539=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 177, column: 4
                  S120593=21;
                  S121588=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                    S121588=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S121583=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                      S121583=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 178, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                        S120593=22;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            switch(S121544){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 177, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                  S121544=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S121539){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                        enableConveyor_o.setVal(new Integer(DISCHARGE_thread_3));//sysj\recyclingStationController.sysj line: 177, column: 4
                        S121539=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 177, column: 4
                          S120593=21;
                          S121588=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                            S121588=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S121583=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                              S121583=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 178, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                                S120593=22;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                        S120593=21;
                        S121588=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                          S121588=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S121583=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                            S121583=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 178, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                              S120593=22;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
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
                S121544=1;
                S121544=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 177, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                  S121544=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S121539=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                    enableConveyor_o.setVal(new Integer(DISCHARGE_thread_3));//sysj\recyclingStationController.sysj line: 177, column: 4
                    S121539=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 177, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 177, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 177, column: 4
                      S120593=21;
                      S121588=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                        S121588=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S121583=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                          S121583=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 178, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                            S120593=22;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            switch(S121588){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                  S121588=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S121583){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                        S121583=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 178, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                          S120593=22;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S120593=22;
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
                S121588=1;
                S121588=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                  S121588=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S121583=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 178, column: 4
                    S121583=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 178, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 178, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 178, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 179, column: 4
                      S120593=22;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S120593=22;
            S120593=23;
            S121676=0;
            if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 183, column: 4
              enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
              S121676=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S121671=0;
              if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                enableReturn_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 183, column: 4
                S121671=1;
                if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 183, column: 4
                  S120593=24;
                  S121720=0;
                  if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                    statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                    S121720=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S121715=0;
                    if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                      statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                      S121715=1;
                      if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 184, column: 4
                        m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                        S120593=25;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            switch(S121676){
              case 0 : 
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 183, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                  S121676=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S121671){
                    case 0 : 
                      if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                        enableReturn_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 183, column: 4
                        S121671=1;
                        if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                          enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 183, column: 4
                          S120593=24;
                          S121720=0;
                          if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                            S121720=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S121715=0;
                            if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                              statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                              S121715=1;
                              if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                                statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 184, column: 4
                                m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                                S120593=25;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
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
                        S120593=24;
                        S121720=0;
                        if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                          S121720=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S121715=0;
                          if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                            statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                            S121715=1;
                            if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                              statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 184, column: 4
                              m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                              S120593=25;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
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
                S121676=1;
                S121676=0;
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 183, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                  S121676=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S121671=0;
                  if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                    enableReturn_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 183, column: 4
                    S121671=1;
                    if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 183, column: 4
                      enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 183, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 183, column: 4
                      S120593=24;
                      S121720=0;
                      if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                        S121720=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S121715=0;
                        if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                          statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                          S121715=1;
                          if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 184, column: 4
                            m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                            S120593=25;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
            switch(S121720){
              case 0 : 
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                  S121720=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S121715){
                    case 0 : 
                      if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                        statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                        S121715=1;
                        if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 184, column: 4
                          m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                          S120593=25;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S120593=25;
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
                S121720=1;
                S121720=0;
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 4
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                  S121720=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S121715=0;
                  if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                    statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 184, column: 4
                    S121715=1;
                    if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 184, column: 4
                      statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 184, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 184, column: 4
                      m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 185, column: 4
                      S120593=25;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S120593=25;
            m_thread_3.reportRecovered();//sysj\recyclingStationController.sysj line: 189, column: 4
            S120593=26;
            S121808=0;
            if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 190, column: 4
              bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
              S121808=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S121803=0;
              if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                bottleRecycled_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 190, column: 4
                S121803=1;
                if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 190, column: 4
                  S120593=27;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  active[3]=1;
                  ends[3]=1;
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
            switch(S121808){
              case 0 : 
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 190, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                  S121808=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S121803){
                    case 0 : 
                      if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                        bottleRecycled_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 190, column: 4
                        S121803=1;
                        if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                          bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 190, column: 4
                          S120593=27;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S120593=27;
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
                S121808=1;
                S121808=0;
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 190, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                  S121808=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S121803=0;
                  if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                    bottleRecycled_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 190, column: 4
                    S121803=1;
                    if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 4
                      bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 190, column: 4
                      S120593=27;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S120593=27;
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 195, column: 4
            currsigs.addElement(stationState_1);
            stationState_1.setValue(m_thread_3.restingState());//sysj\recyclingStationController.sysj line: 195, column: 4
            S120593=28;
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
              S120593=29;
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
            S120593=29;
            S120593=0;
            S120577=0;
            if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 123, column: 4
              bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
              S120577=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S120572=0;
              if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 123, column: 4
                S120572=1;
                if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 123, column: 4
                  w_thread_3 = (Workpiece)(bottleRejected_in.getVal() == null ? null : ((Workpiece)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 124, column: 4
                  m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 125, column: 4
                  stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 126, column: 4
                  currsigs.addElement(stationState_1);
                  stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 126, column: 4
                  S120593=1;
                  S120600=0;
                  if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
                    enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                    S120600=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S120595=0;
                    if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                      enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
                      S120595=1;
                      if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                        enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 129, column: 4
                        S120593=2;
                        S120688=0;
                        if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                          statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                          S120688=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S120683=0;
                          if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                            statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                            S120683=1;
                            if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                              statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 130, column: 4
                              m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                              S120593=3;
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
                                S120593=4;
                                active[3]=1;
                                ends[3]=1;
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

  public void thread128324(int [] tdone, int [] ends){
        switch(S120569){
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

  public void thread128322(int [] tdone, int [] ends){
        S128317=1;
    m_thread_3 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 107, column: 3
    TO_LID_thread_3 = 1;//sysj\recyclingStationController.sysj line: 110, column: 3
    TO_DUMP_thread_3 = 2;//sysj\recyclingStationController.sysj line: 111, column: 3
    TO_RETURN_thread_3 = 3;//sysj\recyclingStationController.sysj line: 112, column: 3
    DISCHARGE_thread_3 = 4;//sysj\recyclingStationController.sysj line: 113, column: 3
    w_thread_3 = null;//sysj\recyclingStationController.sysj line: 115, column: 3
    S120593=0;
    S120577=0;
    if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 123, column: 4
      bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
      S120577=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S120572=0;
      if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
        bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 123, column: 4
        S120572=1;
        if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 123, column: 4
          bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 123, column: 4
          ends[3]=2;
          ;//sysj\recyclingStationController.sysj line: 123, column: 4
          w_thread_3 = (Workpiece)(bottleRejected_in.getVal() == null ? null : ((Workpiece)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 124, column: 4
          m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 125, column: 4
          stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 126, column: 4
          currsigs.addElement(stationState_1);
          stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 126, column: 4
          S120593=1;
          S120600=0;
          if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 129, column: 4
            enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
            S120600=1;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
          else {
            S120595=0;
            if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
              enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 129, column: 4
              S120595=1;
              if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 129, column: 4
                enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 129, column: 4
                ends[3]=2;
                ;//sysj\recyclingStationController.sysj line: 129, column: 4
                S120593=2;
                S120688=0;
                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 130, column: 4
                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                  S120688=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S120683=0;
                  if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                    statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 130, column: 4
                    S120683=1;
                    if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 130, column: 4
                      statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 130, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 130, column: 4
                      m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 131, column: 4
                      S120593=3;
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
                        S120593=4;
                        active[3]=1;
                        ends[3]=1;
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

  public void thread128321(int [] tdone, int [] ends){
        S120569=1;
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
      switch(S128319){
        case 0 : 
          S128319=0;
          break RUN;
        
        case 1 : 
          S128319=2;
          S128319=2;
          stationState_1.setClear();//sysj\recyclingStationController.sysj line: 76, column: 2
          thread128321(tdone,ends);
          thread128322(tdone,ends);
          int biggest128323 = 0;
          if(ends[2]>=biggest128323){
            biggest128323=ends[2];
          }
          if(ends[3]>=biggest128323){
            biggest128323=ends[3];
          }
          if(biggest128323 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          stationState_1.setClear();//sysj\recyclingStationController.sysj line: 76, column: 2
          thread128324(tdone,ends);
          thread128325(tdone,ends);
          int biggest128326 = 0;
          if(ends[2]>=biggest128326){
            biggest128326=ends[2];
          }
          if(ends[3]>=biggest128326){
            biggest128326=ends[3];
          }
          if(biggest128326 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest128326 == 0){
            S128319=0;
            active[1]=0;
            ends[1]=0;
            S128319=0;
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
