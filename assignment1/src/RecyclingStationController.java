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
  public Signal reset = new Signal("reset", Signal.INPUT);
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
  private int cur_thread_2;//sysj\recyclingStationController.sysj line: 61, column: 4
  private RecyclingQueue q_thread_3;//sysj\recyclingStationController.sysj line: 78, column: 4
  private RecyclingRecord m_thread_3;//sysj\recyclingStationController.sysj line: 79, column: 4
  private WorkpieceTwin w_thread_3;//sysj\recyclingStationController.sysj line: 80, column: 4
  private RecyclingQueue q_thread_4;//sysj\recyclingStationController.sysj line: 101, column: 4
  private RecyclingRecord m_thread_4;//sysj\recyclingStationController.sysj line: 102, column: 4
  private int TO_LID_thread_4;//sysj\recyclingStationController.sysj line: 105, column: 4
  private int TO_DUMP_thread_4;//sysj\recyclingStationController.sysj line: 106, column: 4
  private int TO_RETURN_thread_4;//sysj\recyclingStationController.sysj line: 107, column: 4
  private int DISCHARGE_thread_4;//sysj\recyclingStationController.sysj line: 108, column: 4
  private WorkpieceTwin w_thread_4;//sysj\recyclingStationController.sysj line: 110, column: 4
  private boolean permitted_thread_4;//sysj\recyclingStationController.sysj line: 111, column: 4
  private int S263333 = 1;
  private int S250041 = 1;
  private int S243411 = 1;
  private int S243839 = 1;
  private int S243483 = 1;
  private int S243423 = 1;
  private int S243418 = 1;
  private int S250039 = 1;
  private int S243845 = 1;
  private int S243852 = 1;
  private int S243847 = 1;
  private int S243918 = 1;
  private int S243913 = 1;
  private int S244028 = 1;
  private int S244023 = 1;
  private int S244072 = 1;
  private int S244067 = 1;
  private int S244160 = 1;
  private int S244155 = 1;
  private int S244204 = 1;
  private int S244199 = 1;
  private int S244292 = 1;
  private int S244287 = 1;
  private int S244336 = 1;
  private int S244331 = 1;
  private int S244424 = 1;
  private int S244419 = 1;
  private int S244468 = 1;
  private int S244463 = 1;
  private int S244556 = 1;
  private int S244551 = 1;
  private int S244600 = 1;
  private int S244595 = 1;
  private int S244688 = 1;
  private int S244683 = 1;
  private int S244732 = 1;
  private int S244727 = 1;
  private int S244820 = 1;
  private int S244815 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread263345(int [] tdone, int [] ends){
        S250039=1;
    q_thread_4 = RecyclingQueue.shared();//sysj\recyclingStationController.sysj line: 101, column: 4
    m_thread_4 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 102, column: 4
    TO_LID_thread_4 = 1;//sysj\recyclingStationController.sysj line: 105, column: 4
    TO_DUMP_thread_4 = 2;//sysj\recyclingStationController.sysj line: 106, column: 4
    TO_RETURN_thread_4 = 3;//sysj\recyclingStationController.sysj line: 107, column: 4
    DISCHARGE_thread_4 = 4;//sysj\recyclingStationController.sysj line: 108, column: 4
    w_thread_4 = null;//sysj\recyclingStationController.sysj line: 110, column: 4
    permitted_thread_4 = false;//sysj\recyclingStationController.sysj line: 111, column: 4
    S243845=0;
    if(!q_thread_4.hasWork()){//sysj\recyclingStationController.sysj line: 116, column: 11
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      ends[4]=2;
      ;//sysj\recyclingStationController.sysj line: 116, column: 5
      w_thread_4 = q_thread_4.take();//sysj\recyclingStationController.sysj line: 120, column: 5
      m_thread_4.beginCycle(w_thread_4);//sysj\recyclingStationController.sysj line: 121, column: 5
      stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 122, column: 5
      currsigs.addElement(stationState_1);
      stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 122, column: 5
      S243845=1;
      S243852=0;
      if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 5
        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
        S243852=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S243847=0;
        if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
          enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 126, column: 5
          S243847=1;
          if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
            enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
            ends[4]=2;
            ;//sysj\recyclingStationController.sysj line: 126, column: 5
            S243845=2;
            S243918=0;
            if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
              S243918=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S243913=0;
              if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                S243913=1;
                if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 127, column: 5
                  m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                  S243845=3;
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
    }
  }

  public void thread263344(int [] tdone, int [] ends){
        S243839=1;
    q_thread_3 = RecyclingQueue.shared();//sysj\recyclingStationController.sysj line: 78, column: 4
    m_thread_3 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 79, column: 4
    w_thread_3 = null;//sysj\recyclingStationController.sysj line: 80, column: 4
    S243483=0;
    if(!q_thread_3.hasRoom()){//sysj\recyclingStationController.sysj line: 83, column: 11
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      ends[3]=2;
      ;//sysj\recyclingStationController.sysj line: 83, column: 5
      S243483=1;
      S243423=0;
      if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 86, column: 5
        bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
        S243423=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S243418=0;
        if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
          bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 86, column: 5
          S243418=1;
          if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
            bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
            ends[3]=2;
            ;//sysj\recyclingStationController.sysj line: 86, column: 5
            w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 87, column: 5
            w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 93, column: 5
            m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 94, column: 5
            q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 95, column: 5
            S243483=2;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
          else {
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
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

  public void thread263343(int [] tdone, int [] ends){
        S243411=1;
    cur_thread_2 = 0;//sysj\recyclingStationController.sysj line: 61, column: 4
    if(stationState_1.getprestatus()){//sysj\recyclingStationController.sysj line: 63, column: 13
      cur_thread_2 = ((Integer)(stationState_1.getpreval() == null ? 0 : ((Integer)stationState_1.getpreval()).intValue())).intValue();//sysj\recyclingStationController.sysj line: 64, column: 6
      recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 66, column: 5
      currsigs.addElement(recyclingStatus);
      recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 66, column: 5
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
    else {
      recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 66, column: 5
      currsigs.addElement(recyclingStatus);
      recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 66, column: 5
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
  }

  public void thread263341(int [] tdone, int [] ends){
        switch(S250039){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S243845){
          case 0 : 
            if(!q_thread_4.hasWork()){//sysj\recyclingStationController.sysj line: 116, column: 11
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj\recyclingStationController.sysj line: 116, column: 5
              w_thread_4 = q_thread_4.take();//sysj\recyclingStationController.sysj line: 120, column: 5
              m_thread_4.beginCycle(w_thread_4);//sysj\recyclingStationController.sysj line: 121, column: 5
              stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 122, column: 5
              currsigs.addElement(stationState_1);
              stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 122, column: 5
              S243845=1;
              S243852=0;
              if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 5
                enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                S243852=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S243847=0;
                if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                  enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 126, column: 5
                  S243847=1;
                  if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                    enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                    ends[4]=2;
                    ;//sysj\recyclingStationController.sysj line: 126, column: 5
                    S243845=2;
                    S243918=0;
                    if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                      S243918=1;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S243913=0;
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                        S243913=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 127, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                          S243845=3;
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
            }
            break;
          
          case 1 : 
            switch(S243852){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                  S243852=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S243847){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                        enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 126, column: 5
                        S243847=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 126, column: 5
                          S243845=2;
                          S243918=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                            S243918=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S243913=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                              S243913=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 127, column: 5
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                                S243845=3;
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
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 126, column: 5
                        S243845=2;
                        S243918=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                          S243918=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S243913=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                            S243913=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 127, column: 5
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                              S243845=3;
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
                S243852=1;
                S243852=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                  S243852=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S243847=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                    enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 126, column: 5
                    S243847=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 126, column: 5
                      S243845=2;
                      S243918=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                        S243918=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S243913=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                          S243913=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 127, column: 5
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                            S243845=3;
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
          
          case 2 : 
            switch(S243918){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                  S243918=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S243913){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                        S243913=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 127, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                          S243845=3;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 127, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                        S243845=3;
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
                S243918=1;
                S243918=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                  S243918=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S243913=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                    S243913=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 127, column: 5
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                      S243845=3;
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
          
          case 3 : 
            S243845=3;
            S243845=4;
            S244028=0;
            if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 132, column: 5
              enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 132, column: 5
              S244028=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S244023=0;
              if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 132, column: 5
                enableLidRemoval_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 132, column: 5
                S244023=1;
                if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 132, column: 5
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 132, column: 5
                  S243845=5;
                  S244072=0;
                  if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 133, column: 5
                    statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                    S244072=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S244067=0;
                    if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                      statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 133, column: 5
                      S244067=1;
                      if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 133, column: 5
                        m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 134, column: 5
                        S243845=6;
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
            switch(S244028){
              case 0 : 
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 132, column: 5
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                  S244028=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244023){
                    case 0 : 
                      if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 132, column: 5
                        enableLidRemoval_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 132, column: 5
                        S244023=1;
                        if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 132, column: 5
                          enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 132, column: 5
                          S243845=5;
                          S244072=0;
                          if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 133, column: 5
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                            S244072=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S244067=0;
                            if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                              statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 133, column: 5
                              S244067=1;
                              if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                                statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 133, column: 5
                                m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 134, column: 5
                                S243845=6;
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
                      if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 132, column: 5
                        enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 132, column: 5
                        S243845=5;
                        S244072=0;
                        if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 133, column: 5
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                          S244072=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S244067=0;
                          if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                            statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 133, column: 5
                            S244067=1;
                            if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                              statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 133, column: 5
                              m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 134, column: 5
                              S243845=6;
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
                S244028=1;
                S244028=0;
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 132, column: 5
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                  S244028=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244023=0;
                  if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 132, column: 5
                    enableLidRemoval_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 132, column: 5
                    S244023=1;
                    if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 132, column: 5
                      enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 132, column: 5
                      S243845=5;
                      S244072=0;
                      if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 133, column: 5
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                        S244072=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S244067=0;
                        if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                          statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 133, column: 5
                          S244067=1;
                          if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 133, column: 5
                            m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 134, column: 5
                            S243845=6;
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
            switch(S244072){
              case 0 : 
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 133, column: 5
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                  S244072=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244067){
                    case 0 : 
                      if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                        statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 133, column: 5
                        S244067=1;
                        if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 133, column: 5
                          m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 134, column: 5
                          S243845=6;
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
                      if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 133, column: 5
                        m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 134, column: 5
                        S243845=6;
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
                S244072=1;
                S244072=0;
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 133, column: 5
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                  S244072=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244067=0;
                  if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                    statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 133, column: 5
                    S244067=1;
                    if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                      statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 133, column: 5
                      m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 134, column: 5
                      S243845=6;
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
            S243845=6;
            S243845=7;
            S244160=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 138, column: 5
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 5
              S244160=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S244155=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 5
                enableConveyor_o.setVal(new Integer(TO_DUMP_thread_4));//sysj\recyclingStationController.sysj line: 138, column: 5
                S244155=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 138, column: 5
                  S243845=8;
                  S244204=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 5
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                    S244204=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S244199=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 5
                      S244199=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 139, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 5
                        S243845=9;
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
            switch(S244160){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 138, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 5
                  S244160=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244155){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 5
                        enableConveyor_o.setVal(new Integer(TO_DUMP_thread_4));//sysj\recyclingStationController.sysj line: 138, column: 5
                        S244155=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 5
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 138, column: 5
                          S243845=8;
                          S244204=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                            S244204=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S244199=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 5
                              S244199=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 139, column: 5
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 5
                                S243845=9;
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
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 5
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 138, column: 5
                        S243845=8;
                        S244204=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                          S244204=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S244199=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 5
                            S244199=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 139, column: 5
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 5
                              S243845=9;
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
                S244160=1;
                S244160=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 138, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 5
                  S244160=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244155=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 5
                    enableConveyor_o.setVal(new Integer(TO_DUMP_thread_4));//sysj\recyclingStationController.sysj line: 138, column: 5
                    S244155=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 5
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 138, column: 5
                      S243845=8;
                      S244204=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                        S244204=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S244199=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 5
                          S244199=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 139, column: 5
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 5
                            S243845=9;
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
            switch(S244204){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                  S244204=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244199){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 5
                        S244199=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 139, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 5
                          S243845=9;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 139, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 5
                        S243845=9;
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
                S244204=1;
                S244204=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                  S244204=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244199=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 5
                    S244199=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 139, column: 5
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 5
                      S243845=9;
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
            S243845=9;
            S243845=10;
            S244292=0;
            if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 144, column: 5
              enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 144, column: 5
              S244292=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S244287=0;
              if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 144, column: 5
                enableDumper_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 144, column: 5
                S244287=1;
                if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 144, column: 5
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 144, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 144, column: 5
                  S243845=11;
                  S244336=0;
                  if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 145, column: 5
                    statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                    S244336=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S244331=0;
                    if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                      statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 145, column: 5
                      S244331=1;
                      if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 145, column: 5
                        m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 146, column: 5
                        S243845=12;
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
            switch(S244292){
              case 0 : 
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 144, column: 5
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 144, column: 5
                  S244292=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244287){
                    case 0 : 
                      if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 144, column: 5
                        enableDumper_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 144, column: 5
                        S244287=1;
                        if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 144, column: 5
                          enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 144, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 144, column: 5
                          S243845=11;
                          S244336=0;
                          if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 145, column: 5
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                            S244336=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S244331=0;
                            if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                              statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 145, column: 5
                              S244331=1;
                              if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                                statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 145, column: 5
                                m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 146, column: 5
                                S243845=12;
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
                      if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 144, column: 5
                        enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 144, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 144, column: 5
                        S243845=11;
                        S244336=0;
                        if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 145, column: 5
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                          S244336=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S244331=0;
                          if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                            statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 145, column: 5
                            S244331=1;
                            if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                              statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 145, column: 5
                              m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 146, column: 5
                              S243845=12;
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
                S244292=1;
                S244292=0;
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 144, column: 5
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 144, column: 5
                  S244292=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244287=0;
                  if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 144, column: 5
                    enableDumper_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 144, column: 5
                    S244287=1;
                    if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 144, column: 5
                      enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 144, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 144, column: 5
                      S243845=11;
                      S244336=0;
                      if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 145, column: 5
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                        S244336=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S244331=0;
                        if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                          statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 145, column: 5
                          S244331=1;
                          if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 145, column: 5
                            m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 146, column: 5
                            S243845=12;
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
            switch(S244336){
              case 0 : 
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 145, column: 5
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                  S244336=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244331){
                    case 0 : 
                      if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                        statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 145, column: 5
                        S244331=1;
                        if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 145, column: 5
                          m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 146, column: 5
                          S243845=12;
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
                      if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 145, column: 5
                        m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 146, column: 5
                        S243845=12;
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
                S244336=1;
                S244336=0;
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 145, column: 5
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                  S244336=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244331=0;
                  if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                    statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 145, column: 5
                    S244331=1;
                    if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                      statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 145, column: 5
                      m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 146, column: 5
                      S243845=12;
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
            S243845=12;
            S243845=13;
            S244424=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 150, column: 5
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 150, column: 5
              S244424=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S244419=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 150, column: 5
                enableConveyor_o.setVal(new Integer(TO_RETURN_thread_4));//sysj\recyclingStationController.sysj line: 150, column: 5
                S244419=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 150, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 150, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 150, column: 5
                  S243845=14;
                  S244468=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 151, column: 5
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                    S244468=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S244463=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 151, column: 5
                      S244463=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 151, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 152, column: 5
                        S243845=15;
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
            switch(S244424){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 150, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 150, column: 5
                  S244424=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244419){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 150, column: 5
                        enableConveyor_o.setVal(new Integer(TO_RETURN_thread_4));//sysj\recyclingStationController.sysj line: 150, column: 5
                        S244419=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 150, column: 5
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 150, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 150, column: 5
                          S243845=14;
                          S244468=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 151, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                            S244468=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S244463=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 151, column: 5
                              S244463=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 151, column: 5
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 152, column: 5
                                S243845=15;
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
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 150, column: 5
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 150, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 150, column: 5
                        S243845=14;
                        S244468=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 151, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                          S244468=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S244463=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 151, column: 5
                            S244463=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 151, column: 5
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 152, column: 5
                              S243845=15;
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
                S244424=1;
                S244424=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 150, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 150, column: 5
                  S244424=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244419=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 150, column: 5
                    enableConveyor_o.setVal(new Integer(TO_RETURN_thread_4));//sysj\recyclingStationController.sysj line: 150, column: 5
                    S244419=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 150, column: 5
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 150, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 150, column: 5
                      S243845=14;
                      S244468=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 151, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                        S244468=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S244463=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 151, column: 5
                          S244463=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 151, column: 5
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 152, column: 5
                            S243845=15;
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
            switch(S244468){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 151, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                  S244468=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244463){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 151, column: 5
                        S244463=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 151, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 152, column: 5
                          S243845=15;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 151, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 152, column: 5
                        S243845=15;
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
                S244468=1;
                S244468=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 151, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                  S244468=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244463=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 151, column: 5
                    S244463=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 151, column: 5
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 152, column: 5
                      S243845=15;
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
            S243845=15;
            S243845=16;
            S244556=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 156, column: 5
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 5
              S244556=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S244551=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 5
                enableConveyor_o.setVal(new Integer(DISCHARGE_thread_4));//sysj\recyclingStationController.sysj line: 156, column: 5
                S244551=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 156, column: 5
                  S243845=17;
                  S244600=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 5
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                    S244600=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S244595=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 5
                      S244595=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 157, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 5
                        S243845=18;
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
            switch(S244556){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 156, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 5
                  S244556=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244551){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 5
                        enableConveyor_o.setVal(new Integer(DISCHARGE_thread_4));//sysj\recyclingStationController.sysj line: 156, column: 5
                        S244551=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 5
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 156, column: 5
                          S243845=17;
                          S244600=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                            S244600=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S244595=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 5
                              S244595=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 157, column: 5
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 5
                                S243845=18;
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
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 5
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 156, column: 5
                        S243845=17;
                        S244600=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                          S244600=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S244595=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 5
                            S244595=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 157, column: 5
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 5
                              S243845=18;
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
                S244556=1;
                S244556=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 156, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 5
                  S244556=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244551=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 5
                    enableConveyor_o.setVal(new Integer(DISCHARGE_thread_4));//sysj\recyclingStationController.sysj line: 156, column: 5
                    S244551=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 5
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 156, column: 5
                      S243845=17;
                      S244600=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                        S244600=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S244595=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 5
                          S244595=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 157, column: 5
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 5
                            S243845=18;
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
            switch(S244600){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                  S244600=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244595){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 5
                        S244595=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 157, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 5
                          S243845=18;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 157, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 5
                        S243845=18;
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
                S244600=1;
                S244600=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                  S244600=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244595=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 5
                    S244595=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 157, column: 5
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 5
                      S243845=18;
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
            S243845=18;
            S243845=19;
            S244688=0;
            if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 162, column: 5
              enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 5
              S244688=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S244683=0;
              if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 5
                enableReturn_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 162, column: 5
                S244683=1;
                if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 5
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 162, column: 5
                  S243845=20;
                  S244732=0;
                  if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 5
                    statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                    S244732=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S244727=0;
                    if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                      statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 5
                      S244727=1;
                      if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 163, column: 5
                        m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 5
                        S243845=21;
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
            switch(S244688){
              case 0 : 
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 162, column: 5
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 5
                  S244688=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244683){
                    case 0 : 
                      if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 5
                        enableReturn_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 162, column: 5
                        S244683=1;
                        if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 5
                          enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 162, column: 5
                          S243845=20;
                          S244732=0;
                          if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 5
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                            S244732=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S244727=0;
                            if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                              statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 5
                              S244727=1;
                              if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                                statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 163, column: 5
                                m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 5
                                S243845=21;
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
                      if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 5
                        enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 162, column: 5
                        S243845=20;
                        S244732=0;
                        if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 5
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                          S244732=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S244727=0;
                          if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                            statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 5
                            S244727=1;
                            if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                              statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 163, column: 5
                              m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 5
                              S243845=21;
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
                S244688=1;
                S244688=0;
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 162, column: 5
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 5
                  S244688=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244683=0;
                  if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 5
                    enableReturn_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 162, column: 5
                    S244683=1;
                    if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 5
                      enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 162, column: 5
                      S243845=20;
                      S244732=0;
                      if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 5
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                        S244732=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S244727=0;
                        if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                          statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 5
                          S244727=1;
                          if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 163, column: 5
                            m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 5
                            S243845=21;
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
            switch(S244732){
              case 0 : 
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 5
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                  S244732=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244727){
                    case 0 : 
                      if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                        statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 5
                        S244727=1;
                        if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 163, column: 5
                          m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 5
                          S243845=21;
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
                      if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 163, column: 5
                        m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 5
                        S243845=21;
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
                S244732=1;
                S244732=0;
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 5
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                  S244732=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244727=0;
                  if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                    statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 5
                    S244727=1;
                    if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                      statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 163, column: 5
                      m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 5
                      S243845=21;
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
            S243845=21;
            m_thread_4.recovered(w_thread_4);//sysj\recyclingStationController.sysj line: 168, column: 5
            S243845=22;
            S244820=0;
            if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 5
              bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 169, column: 5
              S244820=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S244815=0;
              if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 169, column: 5
                bottleRecycled_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 169, column: 5
                S244815=1;
                if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 169, column: 5
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 169, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 169, column: 5
                  S243845=23;
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
          
          case 22 : 
            switch(S244820){
              case 0 : 
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 5
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 169, column: 5
                  S244820=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244815){
                    case 0 : 
                      if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 169, column: 5
                        bottleRecycled_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 169, column: 5
                        S244815=1;
                        if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 169, column: 5
                          bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 169, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 169, column: 5
                          S243845=23;
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
                      if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 169, column: 5
                        bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 169, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 169, column: 5
                        S243845=23;
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
                S244820=1;
                S244820=0;
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 5
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 169, column: 5
                  S244820=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244815=0;
                  if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 169, column: 5
                    bottleRecycled_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 169, column: 5
                    S244815=1;
                    if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 169, column: 5
                      bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 169, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 169, column: 5
                      S243845=23;
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
          
          case 23 : 
            S243845=23;
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 174, column: 5
            currsigs.addElement(stationState_1);
            stationState_1.setValue(m_thread_4.levelFor(q_thread_4.hasWork()));//sysj\recyclingStationController.sysj line: 174, column: 5
            S243845=24;
            if(m_thread_4.suspended()){//sysj\recyclingStationController.sysj line: 182, column: 5
              m_thread_4.reportSuspension();//sysj\recyclingStationController.sysj line: 183, column: 6
              stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 185, column: 7
              currsigs.addElement(stationState_1);
              stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 185, column: 7
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S243845=25;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 24 : 
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 185, column: 7
            currsigs.addElement(stationState_1);
            stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 185, column: 7
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 25 : 
            S243845=25;
            S243845=0;
            if(!q_thread_4.hasWork()){//sysj\recyclingStationController.sysj line: 116, column: 11
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj\recyclingStationController.sysj line: 116, column: 5
              w_thread_4 = q_thread_4.take();//sysj\recyclingStationController.sysj line: 120, column: 5
              m_thread_4.beginCycle(w_thread_4);//sysj\recyclingStationController.sysj line: 121, column: 5
              stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 122, column: 5
              currsigs.addElement(stationState_1);
              stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 122, column: 5
              S243845=1;
              S243852=0;
              if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 5
                enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                S243852=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S243847=0;
                if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                  enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 126, column: 5
                  S243847=1;
                  if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                    enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                    ends[4]=2;
                    ;//sysj\recyclingStationController.sysj line: 126, column: 5
                    S243845=2;
                    S243918=0;
                    if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                      S243918=1;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S243913=0;
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                        S243913=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 127, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                          S243845=3;
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
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread263340(int [] tdone, int [] ends){
        switch(S243839){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S243483){
          case 0 : 
            if(!q_thread_3.hasRoom()){//sysj\recyclingStationController.sysj line: 83, column: 11
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              ends[3]=2;
              ;//sysj\recyclingStationController.sysj line: 83, column: 5
              S243483=1;
              S243423=0;
              if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 86, column: 5
                bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                S243423=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S243418=0;
                if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                  bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 86, column: 5
                  S243418=1;
                  if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                    bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                    ends[3]=2;
                    ;//sysj\recyclingStationController.sysj line: 86, column: 5
                    w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 87, column: 5
                    w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 93, column: 5
                    m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 94, column: 5
                    q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 95, column: 5
                    S243483=2;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
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
            switch(S243423){
              case 0 : 
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 86, column: 5
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                  S243423=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S243418){
                    case 0 : 
                      if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                        bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 86, column: 5
                        S243418=1;
                        if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                          bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 86, column: 5
                          w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 87, column: 5
                          w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 93, column: 5
                          m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 94, column: 5
                          q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 95, column: 5
                          S243483=2;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                      if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                        bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 86, column: 5
                        w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 87, column: 5
                        w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 93, column: 5
                        m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 94, column: 5
                        q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 95, column: 5
                        S243483=2;
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
                S243423=1;
                S243423=0;
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 86, column: 5
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                  S243423=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S243418=0;
                  if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                    bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 86, column: 5
                    S243418=1;
                    if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                      bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 86, column: 5
                      w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 87, column: 5
                      w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 93, column: 5
                      m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 94, column: 5
                      q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 95, column: 5
                      S243483=2;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S243483=2;
            S243483=0;
            if(!q_thread_3.hasRoom()){//sysj\recyclingStationController.sysj line: 83, column: 11
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              ends[3]=2;
              ;//sysj\recyclingStationController.sysj line: 83, column: 5
              S243483=1;
              S243423=0;
              if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 86, column: 5
                bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                S243423=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S243418=0;
                if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                  bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 86, column: 5
                  S243418=1;
                  if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                    bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                    ends[3]=2;
                    ;//sysj\recyclingStationController.sysj line: 86, column: 5
                    w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 87, column: 5
                    w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 93, column: 5
                    m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 94, column: 5
                    q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 95, column: 5
                    S243483=2;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
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

  public void thread263339(int [] tdone, int [] ends){
        switch(S243411){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(stationState_1.getprestatus()){//sysj\recyclingStationController.sysj line: 63, column: 13
          cur_thread_2 = ((Integer)(stationState_1.getpreval() == null ? 0 : ((Integer)stationState_1.getpreval()).intValue())).intValue();//sysj\recyclingStationController.sysj line: 64, column: 6
          recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 66, column: 5
          currsigs.addElement(recyclingStatus);
          recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 66, column: 5
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 66, column: 5
          currsigs.addElement(recyclingStatus);
          recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 66, column: 5
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread263337(int [] tdone, int [] ends){
        S250039=1;
    q_thread_4 = RecyclingQueue.shared();//sysj\recyclingStationController.sysj line: 101, column: 4
    m_thread_4 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 102, column: 4
    TO_LID_thread_4 = 1;//sysj\recyclingStationController.sysj line: 105, column: 4
    TO_DUMP_thread_4 = 2;//sysj\recyclingStationController.sysj line: 106, column: 4
    TO_RETURN_thread_4 = 3;//sysj\recyclingStationController.sysj line: 107, column: 4
    DISCHARGE_thread_4 = 4;//sysj\recyclingStationController.sysj line: 108, column: 4
    w_thread_4 = null;//sysj\recyclingStationController.sysj line: 110, column: 4
    permitted_thread_4 = false;//sysj\recyclingStationController.sysj line: 111, column: 4
    S243845=0;
    if(!q_thread_4.hasWork()){//sysj\recyclingStationController.sysj line: 116, column: 11
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      ends[4]=2;
      ;//sysj\recyclingStationController.sysj line: 116, column: 5
      w_thread_4 = q_thread_4.take();//sysj\recyclingStationController.sysj line: 120, column: 5
      m_thread_4.beginCycle(w_thread_4);//sysj\recyclingStationController.sysj line: 121, column: 5
      stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 122, column: 5
      currsigs.addElement(stationState_1);
      stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 122, column: 5
      S243845=1;
      S243852=0;
      if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 5
        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
        S243852=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S243847=0;
        if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
          enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 126, column: 5
          S243847=1;
          if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
            enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
            ends[4]=2;
            ;//sysj\recyclingStationController.sysj line: 126, column: 5
            S243845=2;
            S243918=0;
            if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
              S243918=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S243913=0;
              if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                S243913=1;
                if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 127, column: 5
                  m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                  S243845=3;
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
    }
  }

  public void thread263336(int [] tdone, int [] ends){
        S243839=1;
    q_thread_3 = RecyclingQueue.shared();//sysj\recyclingStationController.sysj line: 78, column: 4
    m_thread_3 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 79, column: 4
    w_thread_3 = null;//sysj\recyclingStationController.sysj line: 80, column: 4
    S243483=0;
    if(!q_thread_3.hasRoom()){//sysj\recyclingStationController.sysj line: 83, column: 11
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      ends[3]=2;
      ;//sysj\recyclingStationController.sysj line: 83, column: 5
      S243483=1;
      S243423=0;
      if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 86, column: 5
        bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
        S243423=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S243418=0;
        if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
          bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 86, column: 5
          S243418=1;
          if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
            bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
            ends[3]=2;
            ;//sysj\recyclingStationController.sysj line: 86, column: 5
            w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 87, column: 5
            w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 93, column: 5
            m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 94, column: 5
            q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 95, column: 5
            S243483=2;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
          else {
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
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

  public void thread263335(int [] tdone, int [] ends){
        S243411=1;
    cur_thread_2 = 0;//sysj\recyclingStationController.sysj line: 61, column: 4
    if(stationState_1.getprestatus()){//sysj\recyclingStationController.sysj line: 63, column: 13
      cur_thread_2 = ((Integer)(stationState_1.getpreval() == null ? 0 : ((Integer)stationState_1.getpreval()).intValue())).intValue();//sysj\recyclingStationController.sysj line: 64, column: 6
      recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 66, column: 5
      currsigs.addElement(recyclingStatus);
      recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 66, column: 5
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
    else {
      recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 66, column: 5
      currsigs.addElement(recyclingStatus);
      recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 66, column: 5
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
      switch(S263333){
        case 0 : 
          S263333=0;
          break RUN;
        
        case 1 : 
          S263333=2;
          S263333=2;
          S250041=0;
          if(reset.getprestatus()){//sysj\recyclingStationController.sysj line: 54, column: 19
            bottleRejected_in.setPreempted();
            statusConveyor_in.setPreempted();
            statusLidRemoval_in.setPreempted();
            enableConveyor_o.setPreempted();
            enableLidRemoval_o.setPreempted();
            S250041=1;
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          else {
            stationState_1.setClear();//sysj\recyclingStationController.sysj line: 58, column: 3
            thread263335(tdone,ends);
            thread263336(tdone,ends);
            thread263337(tdone,ends);
            int biggest263338 = 0;
            if(ends[2]>=biggest263338){
              biggest263338=ends[2];
            }
            if(ends[3]>=biggest263338){
              biggest263338=ends[3];
            }
            if(ends[4]>=biggest263338){
              biggest263338=ends[4];
            }
            if(biggest263338 == 1){
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
        
        case 2 : 
          switch(S250041){
            case 0 : 
              if(reset.getprestatus()){//sysj\recyclingStationController.sysj line: 54, column: 19
                bottleRejected_in.setPreempted();
                statusConveyor_in.setPreempted();
                statusLidRemoval_in.setPreempted();
                enableConveyor_o.setPreempted();
                enableLidRemoval_o.setPreempted();
                S250041=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                stationState_1.setClear();//sysj\recyclingStationController.sysj line: 58, column: 3
                thread263339(tdone,ends);
                thread263340(tdone,ends);
                thread263341(tdone,ends);
                int biggest263342 = 0;
                if(ends[2]>=biggest263342){
                  biggest263342=ends[2];
                }
                if(ends[3]>=biggest263342){
                  biggest263342=ends[3];
                }
                if(ends[4]>=biggest263342){
                  biggest263342=ends[4];
                }
                if(biggest263342 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest263342 == 0){
                  S250041=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 1 : 
              S250041=1;
              S250041=0;
              if(reset.getprestatus()){//sysj\recyclingStationController.sysj line: 54, column: 19
                bottleRejected_in.setPreempted();
                statusConveyor_in.setPreempted();
                statusLidRemoval_in.setPreempted();
                enableConveyor_o.setPreempted();
                enableLidRemoval_o.setPreempted();
                S250041=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                stationState_1.setClear();//sysj\recyclingStationController.sysj line: 58, column: 3
                thread263343(tdone,ends);
                thread263344(tdone,ends);
                thread263345(tdone,ends);
                int biggest263346 = 0;
                if(ends[2]>=biggest263346){
                  biggest263346=ends[2];
                }
                if(ends[3]>=biggest263346){
                  biggest263346=ends[3];
                }
                if(ends[4]>=biggest263346){
                  biggest263346=ends[4];
                }
                if(biggest263346 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
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
          reset.gethook();
          df = true;
        }
        runClockDomain();
      }
      reset.setpreclear();
      recyclingStatus.setpreclear();
      stationState_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = reset.getStatus() ? reset.setprepresent() : reset.setpreclear();
      reset.setpreval(reset.getValue());
      reset.setClear();
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
        reset.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
