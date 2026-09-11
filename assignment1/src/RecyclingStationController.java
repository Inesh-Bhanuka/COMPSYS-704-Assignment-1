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
  private int S185421 = 1;
  private int S178211 = 1;
  private int S185419 = 1;
  private int S178235 = 1;
  private int S178219 = 1;
  private int S178214 = 1;
  private int S178256 = 1;
  private int S178251 = 1;
  private int S178300 = 1;
  private int S178295 = 1;
  private int S178436 = 1;
  private int S178431 = 1;
  private int S178480 = 1;
  private int S178475 = 1;
  private int S178568 = 1;
  private int S178563 = 1;
  private int S178612 = 1;
  private int S178607 = 1;
  private int S178700 = 1;
  private int S178695 = 1;
  private int S178744 = 1;
  private int S178739 = 1;
  private int S178832 = 1;
  private int S178827 = 1;
  private int S178876 = 1;
  private int S178871 = 1;
  private int S178964 = 1;
  private int S178959 = 1;
  private int S179008 = 1;
  private int S179003 = 1;
  private int S179096 = 1;
  private int S179091 = 1;
  private int S179140 = 1;
  private int S179135 = 1;
  private int S179228 = 1;
  private int S179223 = 1;
  private int S179272 = 1;
  private int S179267 = 1;
  private int S179360 = 1;
  private int S179355 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread185427(int [] tdone, int [] ends){
        switch(S185419){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S178235){
          case 0 : 
            switch(S178219){
              case 0 : 
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 124, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
                  S178219=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S178214){
                    case 0 : 
                      if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
                        bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 124, column: 4
                        S178214=1;
                        if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
                          bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 124, column: 4
                          w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 125, column: 4
                          permitted_thread_3 = false;//sysj\recyclingStationController.sysj line: 126, column: 1
                          S178235=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S178235=1;
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
                S178219=1;
                S178219=0;
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 124, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
                  S178219=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S178214=0;
                  if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
                    bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 124, column: 4
                    S178214=1;
                    if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
                      bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 124, column: 4
                      w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 125, column: 4
                      permitted_thread_3 = false;//sysj\recyclingStationController.sysj line: 126, column: 1
                      S178235=1;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S178235=1;
            S178235=2;
            if(!permitted_thread_3){//sysj\recyclingStationController.sysj line: 128, column: 19
              permitted_thread_3 = GuiStep.take("RECYCLE", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\recyclingStationController.sysj line: 129, column: 17
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              ends[3]=2;
              ;//sysj\recyclingStationController.sysj line: 128, column: 13
              S178235=3;
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
              S178235=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            S178235=3;
            m_thread_3.begin(w_thread_3);//sysj\recyclingStationController.sysj line: 134, column: 4
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 135, column: 4
            currsigs.addElement(stationState_1);
            stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 135, column: 4
            S178235=4;
            S178256=0;
            if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 138, column: 4
              enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 4
              S178256=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S178251=0;
              if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 4
                enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 138, column: 4
                S178251=1;
                if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 4
                  enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 138, column: 4
                  S178235=5;
                  S178300=0;
                  if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 4
                    statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                    S178300=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S178295=0;
                    if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                      statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 4
                      S178295=1;
                      if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                        statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 139, column: 4
                        m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 4
                        S178235=6;
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
                          S178235=7;
                          active[3]=1;
                          ends[3]=1;
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
            switch(S178256){
              case 0 : 
                if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 138, column: 4
                  enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 4
                  S178256=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S178251){
                    case 0 : 
                      if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 4
                        enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 138, column: 4
                        S178251=1;
                        if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 4
                          enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 138, column: 4
                          S178235=5;
                          S178300=0;
                          if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 4
                            statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                            S178300=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S178295=0;
                            if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                              statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 4
                              S178295=1;
                              if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                                statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 139, column: 4
                                m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 4
                                S178235=6;
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
                                  S178235=7;
                                  active[3]=1;
                                  ends[3]=1;
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
                        S178235=5;
                        S178300=0;
                        if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 4
                          statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                          S178300=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S178295=0;
                          if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                            statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 4
                            S178295=1;
                            if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                              statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 139, column: 4
                              m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 4
                              S178235=6;
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
                                S178235=7;
                                active[3]=1;
                                ends[3]=1;
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
                S178256=1;
                S178256=0;
                if(!enableSplitter_o.isPartnerPresent() || enableSplitter_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 138, column: 4
                  enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 4
                  S178256=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S178251=0;
                  if(enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 4
                    enableSplitter_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 138, column: 4
                    S178251=1;
                    if(!enableSplitter_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 4
                      enableSplitter_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 138, column: 4
                      S178235=5;
                      S178300=0;
                      if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 4
                        statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                        S178300=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S178295=0;
                        if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                          statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 4
                          S178295=1;
                          if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                            statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 139, column: 4
                            m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 4
                            S178235=6;
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
                              S178235=7;
                              active[3]=1;
                              ends[3]=1;
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
            switch(S178300){
              case 0 : 
                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 4
                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                  S178300=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S178295){
                    case 0 : 
                      if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                        statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 4
                        S178295=1;
                        if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                          statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 139, column: 4
                          m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 4
                          S178235=6;
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
                            S178235=7;
                            active[3]=1;
                            ends[3]=1;
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
                        S178235=6;
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
                          S178235=7;
                          active[3]=1;
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
                S178300=1;
                S178300=0;
                if(!statusSplitter_in.isPartnerPresent() || statusSplitter_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 4
                  statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                  S178300=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S178295=0;
                  if(!statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                    statusSplitter_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 4
                    S178295=1;
                    if(statusSplitter_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 4
                      statusSplitter_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 139, column: 4
                      m_thread_3.record(((Integer)(statusSplitter_in.getVal() == null ? null : ((Integer)statusSplitter_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 4
                      S178235=6;
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
                        S178235=7;
                        active[3]=1;
                        ends[3]=1;
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
            S178235=7;
            S178235=8;
            S178436=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 156, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 4
              S178436=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S178431=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 4
                enableConveyor_o.setVal(new Integer(TO_LID_thread_3));//sysj\recyclingStationController.sysj line: 156, column: 4
                S178431=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 156, column: 4
                  S178235=9;
                  S178480=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                    S178480=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S178475=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 4
                      S178475=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 157, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 4
                        S178235=10;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
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
            switch(S178436){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 156, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 4
                  S178436=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S178431){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 4
                        enableConveyor_o.setVal(new Integer(TO_LID_thread_3));//sysj\recyclingStationController.sysj line: 156, column: 4
                        S178431=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 156, column: 4
                          S178235=9;
                          S178480=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                            S178480=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S178475=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 4
                              S178475=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 157, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 4
                                S178235=10;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                        S178235=9;
                        S178480=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                          S178480=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S178475=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 4
                            S178475=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 157, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 4
                              S178235=10;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                S178436=1;
                S178436=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 156, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 4
                  S178436=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S178431=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 4
                    enableConveyor_o.setVal(new Integer(TO_LID_thread_3));//sysj\recyclingStationController.sysj line: 156, column: 4
                    S178431=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 156, column: 4
                      S178235=9;
                      S178480=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                        S178480=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S178475=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 4
                          S178475=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 157, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 4
                            S178235=10;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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
            switch(S178480){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                  S178480=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S178475){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 4
                        S178475=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 157, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 4
                          S178235=10;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S178235=10;
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
                S178480=1;
                S178480=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                  S178480=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S178475=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 4
                    S178475=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 157, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 4
                      S178235=10;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S178235=10;
            S178235=11;
            S178568=0;
            if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 162, column: 4
              enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 4
              S178568=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S178563=0;
              if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 4
                enableLidRemoval_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 162, column: 4
                S178563=1;
                if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 162, column: 4
                  S178235=12;
                  S178612=0;
                  if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 4
                    statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                    S178612=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S178607=0;
                    if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                      statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 4
                      S178607=1;
                      if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 163, column: 4
                        m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 4
                        S178235=13;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
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
            switch(S178568){
              case 0 : 
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 162, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 4
                  S178568=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S178563){
                    case 0 : 
                      if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 4
                        enableLidRemoval_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 162, column: 4
                        S178563=1;
                        if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 4
                          enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 162, column: 4
                          S178235=12;
                          S178612=0;
                          if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 4
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                            S178612=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S178607=0;
                            if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                              statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 4
                              S178607=1;
                              if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                                statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 163, column: 4
                                m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 4
                                S178235=13;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                        S178235=12;
                        S178612=0;
                        if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 4
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                          S178612=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S178607=0;
                          if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                            statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 4
                            S178607=1;
                            if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                              statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 163, column: 4
                              m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 4
                              S178235=13;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                S178568=1;
                S178568=0;
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 162, column: 4
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 4
                  S178568=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S178563=0;
                  if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 4
                    enableLidRemoval_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 162, column: 4
                    S178563=1;
                    if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 4
                      enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 162, column: 4
                      S178235=12;
                      S178612=0;
                      if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 4
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                        S178612=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S178607=0;
                        if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                          statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 4
                          S178607=1;
                          if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 163, column: 4
                            m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 4
                            S178235=13;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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
            switch(S178612){
              case 0 : 
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 4
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                  S178612=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S178607){
                    case 0 : 
                      if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                        statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 4
                        S178607=1;
                        if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 163, column: 4
                          m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 4
                          S178235=13;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S178235=13;
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
                S178612=1;
                S178612=0;
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 4
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                  S178612=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S178607=0;
                  if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                    statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 4
                    S178607=1;
                    if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 4
                      statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 163, column: 4
                      m_thread_3.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 4
                      S178235=13;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S178235=13;
            S178235=14;
            S178700=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 168, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 168, column: 4
              S178700=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S178695=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 168, column: 4
                enableConveyor_o.setVal(new Integer(TO_DUMP_thread_3));//sysj\recyclingStationController.sysj line: 168, column: 4
                S178695=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 168, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 168, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 168, column: 4
                  S178235=15;
                  S178744=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                    S178744=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S178739=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 169, column: 4
                      S178739=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 169, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 170, column: 4
                        S178235=16;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
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
            switch(S178700){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 168, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 168, column: 4
                  S178700=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S178695){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 168, column: 4
                        enableConveyor_o.setVal(new Integer(TO_DUMP_thread_3));//sysj\recyclingStationController.sysj line: 168, column: 4
                        S178695=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 168, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 168, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 168, column: 4
                          S178235=15;
                          S178744=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                            S178744=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S178739=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 169, column: 4
                              S178739=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 169, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 170, column: 4
                                S178235=16;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                        S178235=15;
                        S178744=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                          S178744=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S178739=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 169, column: 4
                            S178739=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 169, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 170, column: 4
                              S178235=16;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                S178700=1;
                S178700=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 168, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 168, column: 4
                  S178700=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S178695=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 168, column: 4
                    enableConveyor_o.setVal(new Integer(TO_DUMP_thread_3));//sysj\recyclingStationController.sysj line: 168, column: 4
                    S178695=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 168, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 168, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 168, column: 4
                      S178235=15;
                      S178744=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                        S178744=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S178739=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 169, column: 4
                          S178739=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 169, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 170, column: 4
                            S178235=16;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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
            switch(S178744){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                  S178744=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S178739){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 169, column: 4
                        S178739=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 169, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 170, column: 4
                          S178235=16;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S178235=16;
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
                S178744=1;
                S178744=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                  S178744=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S178739=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 169, column: 4
                    S178739=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 169, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 169, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 169, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 170, column: 4
                      S178235=16;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S178235=16;
            S178235=17;
            S178832=0;
            if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 174, column: 4
              enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 174, column: 4
              S178832=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S178827=0;
              if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 174, column: 4
                enableDumper_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 174, column: 4
                S178827=1;
                if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 174, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 174, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 174, column: 4
                  S178235=18;
                  S178876=0;
                  if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 175, column: 4
                    statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                    S178876=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S178871=0;
                    if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                      statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 175, column: 4
                      S178871=1;
                      if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 175, column: 4
                        m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 176, column: 4
                        S178235=19;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
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
            switch(S178832){
              case 0 : 
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 174, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 174, column: 4
                  S178832=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S178827){
                    case 0 : 
                      if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 174, column: 4
                        enableDumper_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 174, column: 4
                        S178827=1;
                        if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 174, column: 4
                          enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 174, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 174, column: 4
                          S178235=18;
                          S178876=0;
                          if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 175, column: 4
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                            S178876=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S178871=0;
                            if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                              statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 175, column: 4
                              S178871=1;
                              if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                                statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 175, column: 4
                                m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 176, column: 4
                                S178235=19;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                        S178235=18;
                        S178876=0;
                        if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 175, column: 4
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                          S178876=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S178871=0;
                          if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                            statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 175, column: 4
                            S178871=1;
                            if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                              statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 175, column: 4
                              m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 176, column: 4
                              S178235=19;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                S178832=1;
                S178832=0;
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 174, column: 4
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 174, column: 4
                  S178832=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S178827=0;
                  if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 174, column: 4
                    enableDumper_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 174, column: 4
                    S178827=1;
                    if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 174, column: 4
                      enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 174, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 174, column: 4
                      S178235=18;
                      S178876=0;
                      if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 175, column: 4
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                        S178876=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S178871=0;
                        if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                          statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 175, column: 4
                          S178871=1;
                          if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 175, column: 4
                            m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 176, column: 4
                            S178235=19;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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
            switch(S178876){
              case 0 : 
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 175, column: 4
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                  S178876=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S178871){
                    case 0 : 
                      if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                        statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 175, column: 4
                        S178871=1;
                        if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 175, column: 4
                          m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 176, column: 4
                          S178235=19;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S178235=19;
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
                S178876=1;
                S178876=0;
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 175, column: 4
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                  S178876=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S178871=0;
                  if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                    statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 175, column: 4
                    S178871=1;
                    if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 175, column: 4
                      statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 175, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 175, column: 4
                      m_thread_3.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 176, column: 4
                      S178235=19;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S178235=19;
            S178235=20;
            S178964=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 180, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 180, column: 4
              S178964=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S178959=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 180, column: 4
                enableConveyor_o.setVal(new Integer(TO_RETURN_thread_3));//sysj\recyclingStationController.sysj line: 180, column: 4
                S178959=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 180, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 180, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 180, column: 4
                  S178235=21;
                  S179008=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 181, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                    S179008=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S179003=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 181, column: 4
                      S179003=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 181, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 182, column: 4
                        S178235=22;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
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
            switch(S178964){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 180, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 180, column: 4
                  S178964=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S178959){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 180, column: 4
                        enableConveyor_o.setVal(new Integer(TO_RETURN_thread_3));//sysj\recyclingStationController.sysj line: 180, column: 4
                        S178959=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 180, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 180, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 180, column: 4
                          S178235=21;
                          S179008=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 181, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                            S179008=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S179003=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 181, column: 4
                              S179003=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 181, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 182, column: 4
                                S178235=22;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                        S178235=21;
                        S179008=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 181, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                          S179008=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S179003=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 181, column: 4
                            S179003=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 181, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 182, column: 4
                              S178235=22;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                S178964=1;
                S178964=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 180, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 180, column: 4
                  S178964=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S178959=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 180, column: 4
                    enableConveyor_o.setVal(new Integer(TO_RETURN_thread_3));//sysj\recyclingStationController.sysj line: 180, column: 4
                    S178959=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 180, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 180, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 180, column: 4
                      S178235=21;
                      S179008=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 181, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                        S179008=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S179003=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 181, column: 4
                          S179003=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 181, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 182, column: 4
                            S178235=22;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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
            switch(S179008){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 181, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                  S179008=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S179003){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 181, column: 4
                        S179003=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 181, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 182, column: 4
                          S178235=22;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S178235=22;
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
                S179008=1;
                S179008=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 181, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                  S179008=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S179003=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 181, column: 4
                    S179003=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 181, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 181, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 181, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 182, column: 4
                      S178235=22;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S178235=22;
            S178235=23;
            S179096=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 186, column: 4
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 186, column: 4
              S179096=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S179091=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 186, column: 4
                enableConveyor_o.setVal(new Integer(DISCHARGE_thread_3));//sysj\recyclingStationController.sysj line: 186, column: 4
                S179091=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 186, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 186, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 186, column: 4
                  S178235=24;
                  S179140=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 187, column: 4
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                    S179140=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S179135=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 187, column: 4
                      S179135=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 187, column: 4
                        m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 188, column: 4
                        S178235=25;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
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
            switch(S179096){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 186, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 186, column: 4
                  S179096=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S179091){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 186, column: 4
                        enableConveyor_o.setVal(new Integer(DISCHARGE_thread_3));//sysj\recyclingStationController.sysj line: 186, column: 4
                        S179091=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 186, column: 4
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 186, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 186, column: 4
                          S178235=24;
                          S179140=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 187, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                            S179140=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S179135=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 187, column: 4
                              S179135=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 187, column: 4
                                m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 188, column: 4
                                S178235=25;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                        S178235=24;
                        S179140=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 187, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                          S179140=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S179135=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 187, column: 4
                            S179135=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 187, column: 4
                              m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 188, column: 4
                              S178235=25;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                S179096=1;
                S179096=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 186, column: 4
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 186, column: 4
                  S179096=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S179091=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 186, column: 4
                    enableConveyor_o.setVal(new Integer(DISCHARGE_thread_3));//sysj\recyclingStationController.sysj line: 186, column: 4
                    S179091=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 186, column: 4
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 186, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 186, column: 4
                      S178235=24;
                      S179140=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 187, column: 4
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                        S179140=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S179135=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 187, column: 4
                          S179135=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 187, column: 4
                            m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 188, column: 4
                            S178235=25;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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
            switch(S179140){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 187, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                  S179140=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S179135){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 187, column: 4
                        S179135=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 187, column: 4
                          m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 188, column: 4
                          S178235=25;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S178235=25;
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
                S179140=1;
                S179140=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 187, column: 4
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                  S179140=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S179135=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 187, column: 4
                    S179135=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 187, column: 4
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 187, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 187, column: 4
                      m_thread_3.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 188, column: 4
                      S178235=25;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S178235=25;
            S178235=26;
            S179228=0;
            if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 192, column: 4
              enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 192, column: 4
              S179228=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S179223=0;
              if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 192, column: 4
                enableReturn_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 192, column: 4
                S179223=1;
                if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 192, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 192, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 192, column: 4
                  S178235=27;
                  S179272=0;
                  if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 193, column: 4
                    statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                    S179272=1;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    S179267=0;
                    if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                      statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 193, column: 4
                      S179267=1;
                      if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 193, column: 4
                        m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 194, column: 4
                        S178235=28;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
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
            switch(S179228){
              case 0 : 
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 192, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 192, column: 4
                  S179228=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S179223){
                    case 0 : 
                      if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 192, column: 4
                        enableReturn_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 192, column: 4
                        S179223=1;
                        if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 192, column: 4
                          enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 192, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 192, column: 4
                          S178235=27;
                          S179272=0;
                          if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 193, column: 4
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                            S179272=1;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            S179267=0;
                            if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                              statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 193, column: 4
                              S179267=1;
                              if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                                statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                                ends[3]=2;
                                ;//sysj\recyclingStationController.sysj line: 193, column: 4
                                m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 194, column: 4
                                S178235=28;
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
                              }
                              else {
                                active[3]=1;
                                ends[3]=1;
                                tdone[3]=1;
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
                        S178235=27;
                        S179272=0;
                        if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 193, column: 4
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                          S179272=1;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          S179267=0;
                          if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                            statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 193, column: 4
                            S179267=1;
                            if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                              statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                              ends[3]=2;
                              ;//sysj\recyclingStationController.sysj line: 193, column: 4
                              m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 194, column: 4
                              S178235=28;
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
                            }
                            else {
                              active[3]=1;
                              ends[3]=1;
                              tdone[3]=1;
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
                S179228=1;
                S179228=0;
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 192, column: 4
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 192, column: 4
                  S179228=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S179223=0;
                  if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 192, column: 4
                    enableReturn_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 192, column: 4
                    S179223=1;
                    if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 192, column: 4
                      enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 192, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 192, column: 4
                      S178235=27;
                      S179272=0;
                      if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 193, column: 4
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                        S179272=1;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        S179267=0;
                        if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                          statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 193, column: 4
                          S179267=1;
                          if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                            ends[3]=2;
                            ;//sysj\recyclingStationController.sysj line: 193, column: 4
                            m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 194, column: 4
                            S178235=28;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
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
            switch(S179272){
              case 0 : 
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 193, column: 4
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                  S179272=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S179267){
                    case 0 : 
                      if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                        statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 193, column: 4
                        S179267=1;
                        if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 193, column: 4
                          m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 194, column: 4
                          S178235=28;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S178235=28;
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
                S179272=1;
                S179272=0;
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 193, column: 4
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                  S179272=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S179267=0;
                  if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                    statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 193, column: 4
                    S179267=1;
                    if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 193, column: 4
                      statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 193, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 193, column: 4
                      m_thread_3.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 194, column: 4
                      S178235=28;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S178235=28;
            m_thread_3.reportRecovered();//sysj\recyclingStationController.sysj line: 198, column: 4
            S178235=29;
            S179360=0;
            if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 199, column: 4
              bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 199, column: 4
              S179360=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S179355=0;
              if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 199, column: 4
                bottleRecycled_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 199, column: 4
                S179355=1;
                if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 199, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 199, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 199, column: 4
                  S178235=30;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  active[3]=1;
                  ends[3]=1;
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
            switch(S179360){
              case 0 : 
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 199, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 199, column: 4
                  S179360=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S179355){
                    case 0 : 
                      if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 199, column: 4
                        bottleRecycled_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 199, column: 4
                        S179355=1;
                        if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 199, column: 4
                          bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 199, column: 4
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 199, column: 4
                          S178235=30;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S178235=30;
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
                S179360=1;
                S179360=0;
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 199, column: 4
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 199, column: 4
                  S179360=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S179355=0;
                  if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 199, column: 4
                    bottleRecycled_o.setVal(w_thread_3);//sysj\recyclingStationController.sysj line: 199, column: 4
                    S179355=1;
                    if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 199, column: 4
                      bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 199, column: 4
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 199, column: 4
                      S178235=30;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S178235=30;
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 204, column: 4
            currsigs.addElement(stationState_1);
            stationState_1.setValue(m_thread_3.restingState());//sysj\recyclingStationController.sysj line: 204, column: 4
            S178235=31;
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
              S178235=32;
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
            S178235=32;
            S178235=0;
            S178219=0;
            if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 124, column: 4
              bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
              S178219=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S178214=0;
              if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
                bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 124, column: 4
                S178214=1;
                if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
                  ends[3]=2;
                  ;//sysj\recyclingStationController.sysj line: 124, column: 4
                  w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 125, column: 4
                  permitted_thread_3 = false;//sysj\recyclingStationController.sysj line: 126, column: 1
                  S178235=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  active[3]=1;
                  ends[3]=1;
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

  public void thread185426(int [] tdone, int [] ends){
        switch(S178211){
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

  public void thread185424(int [] tdone, int [] ends){
        S185419=1;
    m_thread_3 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 108, column: 3
    TO_LID_thread_3 = 1;//sysj\recyclingStationController.sysj line: 111, column: 3
    TO_DUMP_thread_3 = 2;//sysj\recyclingStationController.sysj line: 112, column: 3
    TO_RETURN_thread_3 = 3;//sysj\recyclingStationController.sysj line: 113, column: 3
    DISCHARGE_thread_3 = 4;//sysj\recyclingStationController.sysj line: 114, column: 3
    w_thread_3 = null;//sysj\recyclingStationController.sysj line: 116, column: 3
    S178235=0;
    S178219=0;
    if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 124, column: 4
      bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
      S178219=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S178214=0;
      if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
        bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 124, column: 4
        S178214=1;
        if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 124, column: 4
          bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 124, column: 4
          ends[3]=2;
          ;//sysj\recyclingStationController.sysj line: 124, column: 4
          w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 125, column: 4
          permitted_thread_3 = false;//sysj\recyclingStationController.sysj line: 126, column: 1
          S178235=1;
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
      }
      else {
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
    }
  }

  public void thread185423(int [] tdone, int [] ends){
        S178211=1;
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
      switch(S185421){
        case 0 : 
          S185421=0;
          break RUN;
        
        case 1 : 
          S185421=2;
          S185421=2;
          stationState_1.setClear();//sysj\recyclingStationController.sysj line: 77, column: 2
          thread185423(tdone,ends);
          thread185424(tdone,ends);
          int biggest185425 = 0;
          if(ends[2]>=biggest185425){
            biggest185425=ends[2];
          }
          if(ends[3]>=biggest185425){
            biggest185425=ends[3];
          }
          if(biggest185425 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          stationState_1.setClear();//sysj\recyclingStationController.sysj line: 77, column: 2
          thread185426(tdone,ends);
          thread185427(tdone,ends);
          int biggest185428 = 0;
          if(ends[2]>=biggest185428){
            biggest185428=ends[2];
          }
          if(ends[3]>=biggest185428){
            biggest185428=ends[3];
          }
          if(biggest185428 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest185428 == 0){
            S185421=0;
            active[1]=0;
            ends[1]=0;
            S185421=0;
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
