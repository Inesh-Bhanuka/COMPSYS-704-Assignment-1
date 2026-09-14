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
  private int S263336 = 1;
  private int S250044 = 1;
  private int S243414 = 1;
  private int S243842 = 1;
  private int S243486 = 1;
  private int S243426 = 1;
  private int S243421 = 1;
  private int S250042 = 1;
  private int S243848 = 1;
  private int S243855 = 1;
  private int S243850 = 1;
  private int S243921 = 1;
  private int S243916 = 1;
  private int S244031 = 1;
  private int S244026 = 1;
  private int S244075 = 1;
  private int S244070 = 1;
  private int S244163 = 1;
  private int S244158 = 1;
  private int S244207 = 1;
  private int S244202 = 1;
  private int S244295 = 1;
  private int S244290 = 1;
  private int S244339 = 1;
  private int S244334 = 1;
  private int S244427 = 1;
  private int S244422 = 1;
  private int S244471 = 1;
  private int S244466 = 1;
  private int S244559 = 1;
  private int S244554 = 1;
  private int S244603 = 1;
  private int S244598 = 1;
  private int S244691 = 1;
  private int S244686 = 1;
  private int S244735 = 1;
  private int S244730 = 1;
  private int S244823 = 1;
  private int S244818 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread263348(int [] tdone, int [] ends){
        S250042=1;
    q_thread_4 = RecyclingQueue.shared();//sysj\recyclingStationController.sysj line: 101, column: 4
    m_thread_4 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 102, column: 4
    TO_LID_thread_4 = 1;//sysj\recyclingStationController.sysj line: 105, column: 4
    TO_DUMP_thread_4 = 2;//sysj\recyclingStationController.sysj line: 106, column: 4
    TO_RETURN_thread_4 = 3;//sysj\recyclingStationController.sysj line: 107, column: 4
    DISCHARGE_thread_4 = 4;//sysj\recyclingStationController.sysj line: 108, column: 4
    w_thread_4 = null;//sysj\recyclingStationController.sysj line: 110, column: 4
    permitted_thread_4 = false;//sysj\recyclingStationController.sysj line: 111, column: 4
    S243848=0;
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
      S243848=1;
      S243855=0;
      if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 5
        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
        S243855=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S243850=0;
        if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
          enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 126, column: 5
          S243850=1;
          if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
            enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
            ends[4]=2;
            ;//sysj\recyclingStationController.sysj line: 126, column: 5
            S243848=2;
            S243921=0;
            if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
              S243921=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S243916=0;
              if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                S243916=1;
                if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 127, column: 5
                  m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                  S243848=3;
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

  public void thread263347(int [] tdone, int [] ends){
        S243842=1;
    q_thread_3 = RecyclingQueue.shared();//sysj\recyclingStationController.sysj line: 78, column: 4
    m_thread_3 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 79, column: 4
    w_thread_3 = null;//sysj\recyclingStationController.sysj line: 80, column: 4
    S243486=0;
    if(!q_thread_3.hasRoom()){//sysj\recyclingStationController.sysj line: 83, column: 11
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      ends[3]=2;
      ;//sysj\recyclingStationController.sysj line: 83, column: 5
      S243486=1;
      S243426=0;
      if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 86, column: 5
        bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
        S243426=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S243421=0;
        if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
          bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 86, column: 5
          S243421=1;
          if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
            bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
            ends[3]=2;
            ;//sysj\recyclingStationController.sysj line: 86, column: 5
            w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 87, column: 5
            w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 93, column: 5
            m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 94, column: 5
            q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 95, column: 5
            S243486=2;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
          else {
            active[3]=1;
            ends[3]=1;
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

  public void thread263346(int [] tdone, int [] ends){
        S243414=1;
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

  public void thread263344(int [] tdone, int [] ends){
        switch(S250042){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S243848){
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
              S243848=1;
              S243855=0;
              if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 5
                enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                S243855=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S243850=0;
                if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                  enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 126, column: 5
                  S243850=1;
                  if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                    enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                    ends[4]=2;
                    ;//sysj\recyclingStationController.sysj line: 126, column: 5
                    S243848=2;
                    S243921=0;
                    if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                      S243921=1;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S243916=0;
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                        S243916=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 127, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                          S243848=3;
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
            switch(S243855){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                  S243855=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S243850){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                        enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 126, column: 5
                        S243850=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 126, column: 5
                          S243848=2;
                          S243921=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                            S243921=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S243916=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                              S243916=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 127, column: 5
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                                S243848=3;
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
                        S243848=2;
                        S243921=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                          S243921=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S243916=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                            S243916=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 127, column: 5
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                              S243848=3;
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
                S243855=1;
                S243855=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                  S243855=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S243850=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                    enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 126, column: 5
                    S243850=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 126, column: 5
                      S243848=2;
                      S243921=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                        S243921=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S243916=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                          S243916=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 127, column: 5
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                            S243848=3;
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
            switch(S243921){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                  S243921=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S243916){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                        S243916=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 127, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                          S243848=3;
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
                        S243848=3;
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
                S243921=1;
                S243921=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                  S243921=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S243916=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                    S243916=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 127, column: 5
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                      S243848=3;
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
            S243848=3;
            S243848=4;
            S244031=0;
            if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 132, column: 5
              enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 132, column: 5
              S244031=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S244026=0;
              if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 132, column: 5
                enableLidRemoval_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 132, column: 5
                S244026=1;
                if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 132, column: 5
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 132, column: 5
                  S243848=5;
                  S244075=0;
                  if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 133, column: 5
                    statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                    S244075=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S244070=0;
                    if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                      statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 133, column: 5
                      S244070=1;
                      if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 133, column: 5
                        m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 134, column: 5
                        S243848=6;
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
            switch(S244031){
              case 0 : 
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 132, column: 5
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                  S244031=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244026){
                    case 0 : 
                      if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 132, column: 5
                        enableLidRemoval_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 132, column: 5
                        S244026=1;
                        if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 132, column: 5
                          enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 132, column: 5
                          S243848=5;
                          S244075=0;
                          if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 133, column: 5
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                            S244075=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S244070=0;
                            if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                              statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 133, column: 5
                              S244070=1;
                              if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                                statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 133, column: 5
                                m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 134, column: 5
                                S243848=6;
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
                        S243848=5;
                        S244075=0;
                        if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 133, column: 5
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                          S244075=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S244070=0;
                          if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                            statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 133, column: 5
                            S244070=1;
                            if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                              statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 133, column: 5
                              m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 134, column: 5
                              S243848=6;
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
                S244031=1;
                S244031=0;
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 132, column: 5
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                  S244031=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244026=0;
                  if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 132, column: 5
                    enableLidRemoval_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 132, column: 5
                    S244026=1;
                    if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 132, column: 5
                      enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 132, column: 5
                      S243848=5;
                      S244075=0;
                      if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 133, column: 5
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                        S244075=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S244070=0;
                        if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                          statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 133, column: 5
                          S244070=1;
                          if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 133, column: 5
                            m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 134, column: 5
                            S243848=6;
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
            switch(S244075){
              case 0 : 
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 133, column: 5
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                  S244075=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244070){
                    case 0 : 
                      if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                        statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 133, column: 5
                        S244070=1;
                        if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 133, column: 5
                          m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 134, column: 5
                          S243848=6;
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
                        S243848=6;
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
                S244075=1;
                S244075=0;
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 133, column: 5
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                  S244075=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244070=0;
                  if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                    statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 133, column: 5
                    S244070=1;
                    if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 133, column: 5
                      statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 133, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 133, column: 5
                      m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 134, column: 5
                      S243848=6;
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
            S243848=6;
            S243848=7;
            S244163=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 138, column: 5
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 5
              S244163=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S244158=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 5
                enableConveyor_o.setVal(new Integer(TO_DUMP_thread_4));//sysj\recyclingStationController.sysj line: 138, column: 5
                S244158=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 138, column: 5
                  S243848=8;
                  S244207=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 5
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                    S244207=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S244202=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 5
                      S244202=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 139, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 5
                        S243848=9;
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
            switch(S244163){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 138, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 5
                  S244163=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244158){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 5
                        enableConveyor_o.setVal(new Integer(TO_DUMP_thread_4));//sysj\recyclingStationController.sysj line: 138, column: 5
                        S244158=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 5
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 138, column: 5
                          S243848=8;
                          S244207=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                            S244207=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S244202=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 5
                              S244202=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 139, column: 5
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 5
                                S243848=9;
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
                        S243848=8;
                        S244207=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                          S244207=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S244202=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 5
                            S244202=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 139, column: 5
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 5
                              S243848=9;
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
                S244163=1;
                S244163=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 138, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 5
                  S244163=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244158=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 5
                    enableConveyor_o.setVal(new Integer(TO_DUMP_thread_4));//sysj\recyclingStationController.sysj line: 138, column: 5
                    S244158=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 138, column: 5
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 138, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 138, column: 5
                      S243848=8;
                      S244207=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                        S244207=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S244202=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 5
                          S244202=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 139, column: 5
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 5
                            S243848=9;
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
            switch(S244207){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                  S244207=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244202){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 5
                        S244202=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 139, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 5
                          S243848=9;
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
                        S243848=9;
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
                S244207=1;
                S244207=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 139, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                  S244207=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244202=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 139, column: 5
                    S244202=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 139, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 139, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 139, column: 5
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 140, column: 5
                      S243848=9;
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
            S243848=9;
            S243848=10;
            S244295=0;
            if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 144, column: 5
              enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 144, column: 5
              S244295=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S244290=0;
              if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 144, column: 5
                enableDumper_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 144, column: 5
                S244290=1;
                if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 144, column: 5
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 144, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 144, column: 5
                  S243848=11;
                  S244339=0;
                  if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 145, column: 5
                    statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                    S244339=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S244334=0;
                    if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                      statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 145, column: 5
                      S244334=1;
                      if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 145, column: 5
                        m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 146, column: 5
                        S243848=12;
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
            switch(S244295){
              case 0 : 
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 144, column: 5
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 144, column: 5
                  S244295=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244290){
                    case 0 : 
                      if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 144, column: 5
                        enableDumper_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 144, column: 5
                        S244290=1;
                        if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 144, column: 5
                          enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 144, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 144, column: 5
                          S243848=11;
                          S244339=0;
                          if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 145, column: 5
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                            S244339=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S244334=0;
                            if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                              statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 145, column: 5
                              S244334=1;
                              if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                                statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 145, column: 5
                                m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 146, column: 5
                                S243848=12;
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
                        S243848=11;
                        S244339=0;
                        if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 145, column: 5
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                          S244339=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S244334=0;
                          if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                            statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 145, column: 5
                            S244334=1;
                            if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                              statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 145, column: 5
                              m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 146, column: 5
                              S243848=12;
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
                S244295=1;
                S244295=0;
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 144, column: 5
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 144, column: 5
                  S244295=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244290=0;
                  if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 144, column: 5
                    enableDumper_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 144, column: 5
                    S244290=1;
                    if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 144, column: 5
                      enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 144, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 144, column: 5
                      S243848=11;
                      S244339=0;
                      if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 145, column: 5
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                        S244339=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S244334=0;
                        if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                          statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 145, column: 5
                          S244334=1;
                          if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 145, column: 5
                            m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 146, column: 5
                            S243848=12;
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
            switch(S244339){
              case 0 : 
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 145, column: 5
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                  S244339=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244334){
                    case 0 : 
                      if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                        statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 145, column: 5
                        S244334=1;
                        if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 145, column: 5
                          m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 146, column: 5
                          S243848=12;
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
                        S243848=12;
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
                S244339=1;
                S244339=0;
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 145, column: 5
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                  S244339=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244334=0;
                  if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                    statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 145, column: 5
                    S244334=1;
                    if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 145, column: 5
                      statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 145, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 145, column: 5
                      m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 146, column: 5
                      S243848=12;
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
            S243848=12;
            S243848=13;
            S244427=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 150, column: 5
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 150, column: 5
              S244427=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S244422=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 150, column: 5
                enableConveyor_o.setVal(new Integer(TO_RETURN_thread_4));//sysj\recyclingStationController.sysj line: 150, column: 5
                S244422=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 150, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 150, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 150, column: 5
                  S243848=14;
                  S244471=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 151, column: 5
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                    S244471=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S244466=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 151, column: 5
                      S244466=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 151, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 152, column: 5
                        S243848=15;
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
            switch(S244427){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 150, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 150, column: 5
                  S244427=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244422){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 150, column: 5
                        enableConveyor_o.setVal(new Integer(TO_RETURN_thread_4));//sysj\recyclingStationController.sysj line: 150, column: 5
                        S244422=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 150, column: 5
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 150, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 150, column: 5
                          S243848=14;
                          S244471=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 151, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                            S244471=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S244466=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 151, column: 5
                              S244466=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 151, column: 5
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 152, column: 5
                                S243848=15;
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
                        S243848=14;
                        S244471=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 151, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                          S244471=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S244466=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 151, column: 5
                            S244466=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 151, column: 5
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 152, column: 5
                              S243848=15;
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
                S244427=1;
                S244427=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 150, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 150, column: 5
                  S244427=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244422=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 150, column: 5
                    enableConveyor_o.setVal(new Integer(TO_RETURN_thread_4));//sysj\recyclingStationController.sysj line: 150, column: 5
                    S244422=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 150, column: 5
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 150, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 150, column: 5
                      S243848=14;
                      S244471=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 151, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                        S244471=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S244466=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 151, column: 5
                          S244466=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 151, column: 5
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 152, column: 5
                            S243848=15;
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
            switch(S244471){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 151, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                  S244471=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244466){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 151, column: 5
                        S244466=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 151, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 152, column: 5
                          S243848=15;
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
                        S243848=15;
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
                S244471=1;
                S244471=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 151, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                  S244471=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244466=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 151, column: 5
                    S244466=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 151, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 151, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 151, column: 5
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 152, column: 5
                      S243848=15;
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
            S243848=15;
            S243848=16;
            S244559=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 156, column: 5
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 5
              S244559=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S244554=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 5
                enableConveyor_o.setVal(new Integer(DISCHARGE_thread_4));//sysj\recyclingStationController.sysj line: 156, column: 5
                S244554=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 156, column: 5
                  S243848=17;
                  S244603=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 5
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                    S244603=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S244598=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 5
                      S244598=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 157, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 5
                        S243848=18;
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
            switch(S244559){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 156, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 5
                  S244559=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244554){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 5
                        enableConveyor_o.setVal(new Integer(DISCHARGE_thread_4));//sysj\recyclingStationController.sysj line: 156, column: 5
                        S244554=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 5
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 156, column: 5
                          S243848=17;
                          S244603=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                            S244603=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S244598=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 5
                              S244598=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 157, column: 5
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 5
                                S243848=18;
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
                        S243848=17;
                        S244603=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                          S244603=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S244598=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 5
                            S244598=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 157, column: 5
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 5
                              S243848=18;
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
                S244559=1;
                S244559=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 156, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 5
                  S244559=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244554=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 5
                    enableConveyor_o.setVal(new Integer(DISCHARGE_thread_4));//sysj\recyclingStationController.sysj line: 156, column: 5
                    S244554=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 156, column: 5
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 156, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 156, column: 5
                      S243848=17;
                      S244603=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                        S244603=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S244598=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 5
                          S244598=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 157, column: 5
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 5
                            S243848=18;
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
            switch(S244603){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                  S244603=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244598){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 5
                        S244598=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 157, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 5
                          S243848=18;
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
                        S243848=18;
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
                S244603=1;
                S244603=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 157, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                  S244603=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244598=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 157, column: 5
                    S244598=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 157, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 157, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 157, column: 5
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 158, column: 5
                      S243848=18;
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
            S243848=18;
            S243848=19;
            S244691=0;
            if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 162, column: 5
              enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 5
              S244691=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S244686=0;
              if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 5
                enableReturn_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 162, column: 5
                S244686=1;
                if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 5
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 162, column: 5
                  S243848=20;
                  S244735=0;
                  if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 5
                    statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                    S244735=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S244730=0;
                    if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                      statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 5
                      S244730=1;
                      if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 163, column: 5
                        m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 5
                        S243848=21;
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
            switch(S244691){
              case 0 : 
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 162, column: 5
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 5
                  S244691=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244686){
                    case 0 : 
                      if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 5
                        enableReturn_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 162, column: 5
                        S244686=1;
                        if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 5
                          enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 162, column: 5
                          S243848=20;
                          S244735=0;
                          if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 5
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                            S244735=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S244730=0;
                            if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                              statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 5
                              S244730=1;
                              if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                                statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 163, column: 5
                                m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 5
                                S243848=21;
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
                        S243848=20;
                        S244735=0;
                        if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 5
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                          S244735=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S244730=0;
                          if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                            statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 5
                            S244730=1;
                            if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                              statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 163, column: 5
                              m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 5
                              S243848=21;
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
                S244691=1;
                S244691=0;
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 162, column: 5
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 5
                  S244691=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244686=0;
                  if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 5
                    enableReturn_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 162, column: 5
                    S244686=1;
                    if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 162, column: 5
                      enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 162, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 162, column: 5
                      S243848=20;
                      S244735=0;
                      if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 5
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                        S244735=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S244730=0;
                        if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                          statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 5
                          S244730=1;
                          if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 163, column: 5
                            m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 5
                            S243848=21;
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
            switch(S244735){
              case 0 : 
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 5
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                  S244735=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244730){
                    case 0 : 
                      if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                        statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 5
                        S244730=1;
                        if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 163, column: 5
                          m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 5
                          S243848=21;
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
                        S243848=21;
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
                S244735=1;
                S244735=0;
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 163, column: 5
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                  S244735=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244730=0;
                  if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                    statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 163, column: 5
                    S244730=1;
                    if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 163, column: 5
                      statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 163, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 163, column: 5
                      m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 164, column: 5
                      S243848=21;
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
            S243848=21;
            m_thread_4.recovered(w_thread_4);//sysj\recyclingStationController.sysj line: 168, column: 5
            S243848=22;
            S244823=0;
            if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 5
              bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 169, column: 5
              S244823=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S244818=0;
              if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 169, column: 5
                bottleRecycled_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 169, column: 5
                S244818=1;
                if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 169, column: 5
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 169, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 169, column: 5
                  S243848=23;
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
            switch(S244823){
              case 0 : 
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 5
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 169, column: 5
                  S244823=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S244818){
                    case 0 : 
                      if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 169, column: 5
                        bottleRecycled_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 169, column: 5
                        S244818=1;
                        if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 169, column: 5
                          bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 169, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 169, column: 5
                          S243848=23;
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
                        S243848=23;
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
                S244823=1;
                S244823=0;
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 169, column: 5
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 169, column: 5
                  S244823=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S244818=0;
                  if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 169, column: 5
                    bottleRecycled_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 169, column: 5
                    S244818=1;
                    if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 169, column: 5
                      bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 169, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 169, column: 5
                      S243848=23;
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
            S243848=23;
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 174, column: 5
            currsigs.addElement(stationState_1);
            stationState_1.setValue(m_thread_4.levelFor(q_thread_4.hasWork()));//sysj\recyclingStationController.sysj line: 174, column: 5
            S243848=24;
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
              S243848=25;
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
            S243848=25;
            S243848=0;
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
              S243848=1;
              S243855=0;
              if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 5
                enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                S243855=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S243850=0;
                if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                  enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 126, column: 5
                  S243850=1;
                  if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
                    enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
                    ends[4]=2;
                    ;//sysj\recyclingStationController.sysj line: 126, column: 5
                    S243848=2;
                    S243921=0;
                    if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                      S243921=1;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S243916=0;
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                        S243916=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 127, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                          S243848=3;
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

  public void thread263343(int [] tdone, int [] ends){
        switch(S243842){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S243486){
          case 0 : 
            if(!q_thread_3.hasRoom()){//sysj\recyclingStationController.sysj line: 83, column: 11
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              ends[3]=2;
              ;//sysj\recyclingStationController.sysj line: 83, column: 5
              S243486=1;
              S243426=0;
              if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 86, column: 5
                bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                S243426=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S243421=0;
                if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                  bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 86, column: 5
                  S243421=1;
                  if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                    bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                    ends[3]=2;
                    ;//sysj\recyclingStationController.sysj line: 86, column: 5
                    w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 87, column: 5
                    w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 93, column: 5
                    m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 94, column: 5
                    q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 95, column: 5
                    S243486=2;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
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
            switch(S243426){
              case 0 : 
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 86, column: 5
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                  S243426=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S243421){
                    case 0 : 
                      if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                        bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 86, column: 5
                        S243421=1;
                        if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                          bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 86, column: 5
                          w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 87, column: 5
                          w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 93, column: 5
                          m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 94, column: 5
                          q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 95, column: 5
                          S243486=2;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                        S243486=2;
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
                S243426=1;
                S243426=0;
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 86, column: 5
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                  S243426=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S243421=0;
                  if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                    bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 86, column: 5
                    S243421=1;
                    if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                      bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 86, column: 5
                      w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 87, column: 5
                      w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 93, column: 5
                      m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 94, column: 5
                      q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 95, column: 5
                      S243486=2;
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      active[3]=1;
                      ends[3]=1;
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
            S243486=2;
            S243486=0;
            if(!q_thread_3.hasRoom()){//sysj\recyclingStationController.sysj line: 83, column: 11
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              ends[3]=2;
              ;//sysj\recyclingStationController.sysj line: 83, column: 5
              S243486=1;
              S243426=0;
              if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 86, column: 5
                bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                S243426=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S243421=0;
                if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                  bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 86, column: 5
                  S243421=1;
                  if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
                    bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
                    ends[3]=2;
                    ;//sysj\recyclingStationController.sysj line: 86, column: 5
                    w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 87, column: 5
                    w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 93, column: 5
                    m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 94, column: 5
                    q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 95, column: 5
                    S243486=2;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
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

  public void thread263342(int [] tdone, int [] ends){
        switch(S243414){
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

  public void thread263340(int [] tdone, int [] ends){
        S250042=1;
    q_thread_4 = RecyclingQueue.shared();//sysj\recyclingStationController.sysj line: 101, column: 4
    m_thread_4 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 102, column: 4
    TO_LID_thread_4 = 1;//sysj\recyclingStationController.sysj line: 105, column: 4
    TO_DUMP_thread_4 = 2;//sysj\recyclingStationController.sysj line: 106, column: 4
    TO_RETURN_thread_4 = 3;//sysj\recyclingStationController.sysj line: 107, column: 4
    DISCHARGE_thread_4 = 4;//sysj\recyclingStationController.sysj line: 108, column: 4
    w_thread_4 = null;//sysj\recyclingStationController.sysj line: 110, column: 4
    permitted_thread_4 = false;//sysj\recyclingStationController.sysj line: 111, column: 4
    S243848=0;
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
      S243848=1;
      S243855=0;
      if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 126, column: 5
        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
        S243855=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S243850=0;
        if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
          enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 126, column: 5
          S243850=1;
          if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 126, column: 5
            enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 126, column: 5
            ends[4]=2;
            ;//sysj\recyclingStationController.sysj line: 126, column: 5
            S243848=2;
            S243921=0;
            if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 127, column: 5
              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
              S243921=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S243916=0;
              if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 127, column: 5
                S243916=1;
                if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 127, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 127, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 127, column: 5
                  m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 128, column: 5
                  S243848=3;
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

  public void thread263339(int [] tdone, int [] ends){
        S243842=1;
    q_thread_3 = RecyclingQueue.shared();//sysj\recyclingStationController.sysj line: 78, column: 4
    m_thread_3 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 79, column: 4
    w_thread_3 = null;//sysj\recyclingStationController.sysj line: 80, column: 4
    S243486=0;
    if(!q_thread_3.hasRoom()){//sysj\recyclingStationController.sysj line: 83, column: 11
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      ends[3]=2;
      ;//sysj\recyclingStationController.sysj line: 83, column: 5
      S243486=1;
      S243426=0;
      if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 86, column: 5
        bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
        S243426=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S243421=0;
        if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
          bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 86, column: 5
          S243421=1;
          if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 86, column: 5
            bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 86, column: 5
            ends[3]=2;
            ;//sysj\recyclingStationController.sysj line: 86, column: 5
            w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 87, column: 5
            w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 93, column: 5
            m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 94, column: 5
            q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 95, column: 5
            S243486=2;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
          else {
            active[3]=1;
            ends[3]=1;
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

  public void thread263338(int [] tdone, int [] ends){
        S243414=1;
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
      switch(S263336){
        case 0 : 
          S263336=0;
          break RUN;
        
        case 1 : 
          S263336=2;
          S263336=2;
          S250044=0;
          if(reset.getprestatus()){//sysj\recyclingStationController.sysj line: 54, column: 19
            bottleRejected_in.setPreempted();
            statusConveyor_in.setPreempted();
            statusLidRemoval_in.setPreempted();
            enableConveyor_o.setPreempted();
            enableLidRemoval_o.setPreempted();
            S250044=1;
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          else {
            stationState_1.setClear();//sysj\recyclingStationController.sysj line: 58, column: 3
            thread263338(tdone,ends);
            thread263339(tdone,ends);
            thread263340(tdone,ends);
            int biggest263341 = 0;
            if(ends[2]>=biggest263341){
              biggest263341=ends[2];
            }
            if(ends[3]>=biggest263341){
              biggest263341=ends[3];
            }
            if(ends[4]>=biggest263341){
              biggest263341=ends[4];
            }
            if(biggest263341 == 1){
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
        
        case 2 : 
          switch(S250044){
            case 0 : 
              if(reset.getprestatus()){//sysj\recyclingStationController.sysj line: 54, column: 19
                bottleRejected_in.setPreempted();
                statusConveyor_in.setPreempted();
                statusLidRemoval_in.setPreempted();
                enableConveyor_o.setPreempted();
                enableLidRemoval_o.setPreempted();
                S250044=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                stationState_1.setClear();//sysj\recyclingStationController.sysj line: 58, column: 3
                thread263342(tdone,ends);
                thread263343(tdone,ends);
                thread263344(tdone,ends);
                int biggest263345 = 0;
                if(ends[2]>=biggest263345){
                  biggest263345=ends[2];
                }
                if(ends[3]>=biggest263345){
                  biggest263345=ends[3];
                }
                if(ends[4]>=biggest263345){
                  biggest263345=ends[4];
                }
                if(biggest263345 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest263345 == 0){
                  S250044=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 1 : 
              S250044=1;
              S250044=0;
              if(reset.getprestatus()){//sysj\recyclingStationController.sysj line: 54, column: 19
                bottleRejected_in.setPreempted();
                statusConveyor_in.setPreempted();
                statusLidRemoval_in.setPreempted();
                enableConveyor_o.setPreempted();
                enableLidRemoval_o.setPreempted();
                S250044=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                stationState_1.setClear();//sysj\recyclingStationController.sysj line: 58, column: 3
                thread263346(tdone,ends);
                thread263347(tdone,ends);
                thread263348(tdone,ends);
                int biggest263349 = 0;
                if(ends[2]>=biggest263349){
                  biggest263349=ends[2];
                }
                if(ends[3]>=biggest263349){
                  biggest263349=ends[3];
                }
                if(ends[4]>=biggest263349){
                  biggest263349=ends[4];
                }
                if(biggest263349 == 1){
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
