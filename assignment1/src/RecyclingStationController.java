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
  private int cur_thread_2;//sysj\recyclingStationController.sysj line: 107, column: 4
  private RecyclingQueue q_thread_3;//sysj\recyclingStationController.sysj line: 124, column: 4
  private RecyclingRecord m_thread_3;//sysj\recyclingStationController.sysj line: 125, column: 4
  private WorkpieceTwin w_thread_3;//sysj\recyclingStationController.sysj line: 126, column: 4
  private RecyclingQueue q_thread_4;//sysj\recyclingStationController.sysj line: 147, column: 4
  private RecyclingRecord m_thread_4;//sysj\recyclingStationController.sysj line: 148, column: 4
  private int TO_LID_thread_4;//sysj\recyclingStationController.sysj line: 151, column: 4
  private int TO_DUMP_thread_4;//sysj\recyclingStationController.sysj line: 152, column: 4
  private int TO_RETURN_thread_4;//sysj\recyclingStationController.sysj line: 153, column: 4
  private int DISCHARGE_thread_4;//sysj\recyclingStationController.sysj line: 154, column: 4
  private WorkpieceTwin w_thread_4;//sysj\recyclingStationController.sysj line: 156, column: 4
  private boolean permitted_thread_4;//sysj\recyclingStationController.sysj line: 157, column: 4
  private int S262046 = 1;
  private int S248754 = 1;
  private int S242124 = 1;
  private int S242552 = 1;
  private int S242196 = 1;
  private int S242136 = 1;
  private int S242131 = 1;
  private int S248752 = 1;
  private int S242558 = 1;
  private int S242565 = 1;
  private int S242560 = 1;
  private int S242631 = 1;
  private int S242626 = 1;
  private int S242741 = 1;
  private int S242736 = 1;
  private int S242785 = 1;
  private int S242780 = 1;
  private int S242873 = 1;
  private int S242868 = 1;
  private int S242917 = 1;
  private int S242912 = 1;
  private int S243005 = 1;
  private int S243000 = 1;
  private int S243049 = 1;
  private int S243044 = 1;
  private int S243137 = 1;
  private int S243132 = 1;
  private int S243181 = 1;
  private int S243176 = 1;
  private int S243269 = 1;
  private int S243264 = 1;
  private int S243313 = 1;
  private int S243308 = 1;
  private int S243401 = 1;
  private int S243396 = 1;
  private int S243445 = 1;
  private int S243440 = 1;
  private int S243533 = 1;
  private int S243528 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread262058(int [] tdone, int [] ends){
        S248752=1;
    q_thread_4 = RecyclingQueue.shared();//sysj\recyclingStationController.sysj line: 147, column: 4
    m_thread_4 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 148, column: 4
    TO_LID_thread_4 = 1;//sysj\recyclingStationController.sysj line: 151, column: 4
    TO_DUMP_thread_4 = 2;//sysj\recyclingStationController.sysj line: 152, column: 4
    TO_RETURN_thread_4 = 3;//sysj\recyclingStationController.sysj line: 153, column: 4
    DISCHARGE_thread_4 = 4;//sysj\recyclingStationController.sysj line: 154, column: 4
    w_thread_4 = null;//sysj\recyclingStationController.sysj line: 156, column: 4
    permitted_thread_4 = false;//sysj\recyclingStationController.sysj line: 157, column: 4
    S242558=0;
    if(!q_thread_4.hasWork()){//sysj\recyclingStationController.sysj line: 162, column: 11
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      ends[4]=2;
      ;//sysj\recyclingStationController.sysj line: 162, column: 5
      w_thread_4 = q_thread_4.take();//sysj\recyclingStationController.sysj line: 166, column: 5
      m_thread_4.beginCycle(w_thread_4);//sysj\recyclingStationController.sysj line: 167, column: 5
      stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 168, column: 5
      currsigs.addElement(stationState_1);
      stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 168, column: 5
      S242558=1;
      S242565=0;
      if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 5
        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 172, column: 5
        S242565=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S242560=0;
        if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 172, column: 5
          enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 172, column: 5
          S242560=1;
          if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 172, column: 5
            enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 172, column: 5
            ends[4]=2;
            ;//sysj\recyclingStationController.sysj line: 172, column: 5
            S242558=2;
            S242631=0;
            if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 173, column: 5
              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
              S242631=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S242626=0;
              if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 173, column: 5
                S242626=1;
                if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 173, column: 5
                  m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 174, column: 5
                  S242558=3;
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

  public void thread262057(int [] tdone, int [] ends){
        S242552=1;
    q_thread_3 = RecyclingQueue.shared();//sysj\recyclingStationController.sysj line: 124, column: 4
    m_thread_3 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 125, column: 4
    w_thread_3 = null;//sysj\recyclingStationController.sysj line: 126, column: 4
    S242196=0;
    if(!q_thread_3.hasRoom()){//sysj\recyclingStationController.sysj line: 129, column: 11
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      ends[3]=2;
      ;//sysj\recyclingStationController.sysj line: 129, column: 5
      S242196=1;
      S242136=0;
      if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 132, column: 5
        bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 132, column: 5
        S242136=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S242131=0;
        if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 132, column: 5
          bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 132, column: 5
          S242131=1;
          if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 132, column: 5
            bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 132, column: 5
            ends[3]=2;
            ;//sysj\recyclingStationController.sysj line: 132, column: 5
            w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 133, column: 5
            w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 139, column: 5
            m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 140, column: 5
            q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 141, column: 5
            S242196=2;
            active[3]=1;
            ends[3]=1;
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

  public void thread262056(int [] tdone, int [] ends){
        S242124=1;
    cur_thread_2 = 0;//sysj\recyclingStationController.sysj line: 107, column: 4
    if(stationState_1.getprestatus()){//sysj\recyclingStationController.sysj line: 109, column: 13
      cur_thread_2 = ((Integer)(stationState_1.getpreval() == null ? 0 : ((Integer)stationState_1.getpreval()).intValue())).intValue();//sysj\recyclingStationController.sysj line: 110, column: 6
      recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 112, column: 5
      currsigs.addElement(recyclingStatus);
      recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 112, column: 5
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
    else {
      recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 112, column: 5
      currsigs.addElement(recyclingStatus);
      recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 112, column: 5
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
  }

  public void thread262054(int [] tdone, int [] ends){
        switch(S248752){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S242558){
          case 0 : 
            if(!q_thread_4.hasWork()){//sysj\recyclingStationController.sysj line: 162, column: 11
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj\recyclingStationController.sysj line: 162, column: 5
              w_thread_4 = q_thread_4.take();//sysj\recyclingStationController.sysj line: 166, column: 5
              m_thread_4.beginCycle(w_thread_4);//sysj\recyclingStationController.sysj line: 167, column: 5
              stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 168, column: 5
              currsigs.addElement(stationState_1);
              stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 168, column: 5
              S242558=1;
              S242565=0;
              if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 5
                enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 172, column: 5
                S242565=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S242560=0;
                if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 172, column: 5
                  enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 172, column: 5
                  S242560=1;
                  if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 172, column: 5
                    enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 172, column: 5
                    ends[4]=2;
                    ;//sysj\recyclingStationController.sysj line: 172, column: 5
                    S242558=2;
                    S242631=0;
                    if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 173, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                      S242631=1;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S242626=0;
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 173, column: 5
                        S242626=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 173, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 174, column: 5
                          S242558=3;
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
            switch(S242565){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 172, column: 5
                  S242565=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S242560){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 172, column: 5
                        enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 172, column: 5
                        S242560=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 172, column: 5
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 172, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 172, column: 5
                          S242558=2;
                          S242631=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 173, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                            S242631=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S242626=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 173, column: 5
                              S242626=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 173, column: 5
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 174, column: 5
                                S242558=3;
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
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 172, column: 5
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 172, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 172, column: 5
                        S242558=2;
                        S242631=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 173, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                          S242631=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S242626=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 173, column: 5
                            S242626=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 173, column: 5
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 174, column: 5
                              S242558=3;
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
                S242565=1;
                S242565=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 172, column: 5
                  S242565=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S242560=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 172, column: 5
                    enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 172, column: 5
                    S242560=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 172, column: 5
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 172, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 172, column: 5
                      S242558=2;
                      S242631=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 173, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                        S242631=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S242626=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 173, column: 5
                          S242626=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 173, column: 5
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 174, column: 5
                            S242558=3;
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
            switch(S242631){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 173, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                  S242631=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S242626){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 173, column: 5
                        S242626=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 173, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 174, column: 5
                          S242558=3;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 173, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 174, column: 5
                        S242558=3;
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
                S242631=1;
                S242631=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 173, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                  S242631=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S242626=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 173, column: 5
                    S242626=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 173, column: 5
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 174, column: 5
                      S242558=3;
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
            S242558=3;
            S242558=4;
            S242741=0;
            if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 5
              enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 178, column: 5
              S242741=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S242736=0;
              if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 178, column: 5
                enableLidRemoval_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 178, column: 5
                S242736=1;
                if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 178, column: 5
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 178, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 178, column: 5
                  S242558=5;
                  S242785=0;
                  if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 179, column: 5
                    statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 179, column: 5
                    S242785=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S242780=0;
                    if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 179, column: 5
                      statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 179, column: 5
                      S242780=1;
                      if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 179, column: 5
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 179, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 179, column: 5
                        m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 180, column: 5
                        S242558=6;
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
            switch(S242741){
              case 0 : 
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 5
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 178, column: 5
                  S242741=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S242736){
                    case 0 : 
                      if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 178, column: 5
                        enableLidRemoval_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 178, column: 5
                        S242736=1;
                        if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 178, column: 5
                          enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 178, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 178, column: 5
                          S242558=5;
                          S242785=0;
                          if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 179, column: 5
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 179, column: 5
                            S242785=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S242780=0;
                            if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 179, column: 5
                              statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 179, column: 5
                              S242780=1;
                              if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 179, column: 5
                                statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 179, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 179, column: 5
                                m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 180, column: 5
                                S242558=6;
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
                      if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 178, column: 5
                        enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 178, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 178, column: 5
                        S242558=5;
                        S242785=0;
                        if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 179, column: 5
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 179, column: 5
                          S242785=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S242780=0;
                          if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 179, column: 5
                            statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 179, column: 5
                            S242780=1;
                            if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 179, column: 5
                              statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 179, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 179, column: 5
                              m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 180, column: 5
                              S242558=6;
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
                S242741=1;
                S242741=0;
                if(!enableLidRemoval_o.isPartnerPresent() || enableLidRemoval_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 178, column: 5
                  enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 178, column: 5
                  S242741=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S242736=0;
                  if(enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 178, column: 5
                    enableLidRemoval_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 178, column: 5
                    S242736=1;
                    if(!enableLidRemoval_o.isACK()){//sysj\recyclingStationController.sysj line: 178, column: 5
                      enableLidRemoval_o.setREQ(false);//sysj\recyclingStationController.sysj line: 178, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 178, column: 5
                      S242558=5;
                      S242785=0;
                      if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 179, column: 5
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 179, column: 5
                        S242785=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S242780=0;
                        if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 179, column: 5
                          statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 179, column: 5
                          S242780=1;
                          if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 179, column: 5
                            statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 179, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 179, column: 5
                            m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 180, column: 5
                            S242558=6;
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
            switch(S242785){
              case 0 : 
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 179, column: 5
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 179, column: 5
                  S242785=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S242780){
                    case 0 : 
                      if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 179, column: 5
                        statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 179, column: 5
                        S242780=1;
                        if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 179, column: 5
                          statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 179, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 179, column: 5
                          m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 180, column: 5
                          S242558=6;
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
                      if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 179, column: 5
                        statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 179, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 179, column: 5
                        m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 180, column: 5
                        S242558=6;
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
                S242785=1;
                S242785=0;
                if(!statusLidRemoval_in.isPartnerPresent() || statusLidRemoval_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 179, column: 5
                  statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 179, column: 5
                  S242785=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S242780=0;
                  if(!statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 179, column: 5
                    statusLidRemoval_in.setACK(true);//sysj\recyclingStationController.sysj line: 179, column: 5
                    S242780=1;
                    if(statusLidRemoval_in.isREQ()){//sysj\recyclingStationController.sysj line: 179, column: 5
                      statusLidRemoval_in.setACK(false);//sysj\recyclingStationController.sysj line: 179, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 179, column: 5
                      m_thread_4.record(((Integer)(statusLidRemoval_in.getVal() == null ? null : ((Integer)statusLidRemoval_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 180, column: 5
                      S242558=6;
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
            S242558=6;
            S242558=7;
            S242873=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 5
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 184, column: 5
              S242873=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S242868=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 184, column: 5
                enableConveyor_o.setVal(new Integer(TO_DUMP_thread_4));//sysj\recyclingStationController.sysj line: 184, column: 5
                S242868=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 184, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 184, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 184, column: 5
                  S242558=8;
                  S242917=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 185, column: 5
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 185, column: 5
                    S242917=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S242912=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 185, column: 5
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 185, column: 5
                      S242912=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 185, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 185, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 185, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 186, column: 5
                        S242558=9;
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
            switch(S242873){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 184, column: 5
                  S242873=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S242868){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 184, column: 5
                        enableConveyor_o.setVal(new Integer(TO_DUMP_thread_4));//sysj\recyclingStationController.sysj line: 184, column: 5
                        S242868=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 184, column: 5
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 184, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 184, column: 5
                          S242558=8;
                          S242917=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 185, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 185, column: 5
                            S242917=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S242912=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 185, column: 5
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 185, column: 5
                              S242912=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 185, column: 5
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 185, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 185, column: 5
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 186, column: 5
                                S242558=9;
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
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 184, column: 5
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 184, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 184, column: 5
                        S242558=8;
                        S242917=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 185, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 185, column: 5
                          S242917=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S242912=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 185, column: 5
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 185, column: 5
                            S242912=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 185, column: 5
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 185, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 185, column: 5
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 186, column: 5
                              S242558=9;
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
                S242873=1;
                S242873=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 184, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 184, column: 5
                  S242873=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S242868=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 184, column: 5
                    enableConveyor_o.setVal(new Integer(TO_DUMP_thread_4));//sysj\recyclingStationController.sysj line: 184, column: 5
                    S242868=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 184, column: 5
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 184, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 184, column: 5
                      S242558=8;
                      S242917=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 185, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 185, column: 5
                        S242917=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S242912=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 185, column: 5
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 185, column: 5
                          S242912=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 185, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 185, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 185, column: 5
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 186, column: 5
                            S242558=9;
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
            switch(S242917){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 185, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 185, column: 5
                  S242917=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S242912){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 185, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 185, column: 5
                        S242912=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 185, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 185, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 185, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 186, column: 5
                          S242558=9;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 185, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 185, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 185, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 186, column: 5
                        S242558=9;
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
                S242917=1;
                S242917=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 185, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 185, column: 5
                  S242917=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S242912=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 185, column: 5
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 185, column: 5
                    S242912=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 185, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 185, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 185, column: 5
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 186, column: 5
                      S242558=9;
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
            S242558=9;
            S242558=10;
            S243005=0;
            if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 190, column: 5
              enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 5
              S243005=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S243000=0;
              if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 5
                enableDumper_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 190, column: 5
                S243000=1;
                if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 5
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 190, column: 5
                  S242558=11;
                  S243049=0;
                  if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 191, column: 5
                    statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 191, column: 5
                    S243049=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S243044=0;
                    if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 191, column: 5
                      statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 191, column: 5
                      S243044=1;
                      if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 191, column: 5
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 191, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 191, column: 5
                        m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 192, column: 5
                        S242558=12;
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
            switch(S243005){
              case 0 : 
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 190, column: 5
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 5
                  S243005=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S243000){
                    case 0 : 
                      if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 5
                        enableDumper_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 190, column: 5
                        S243000=1;
                        if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 5
                          enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 190, column: 5
                          S242558=11;
                          S243049=0;
                          if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 191, column: 5
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 191, column: 5
                            S243049=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S243044=0;
                            if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 191, column: 5
                              statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 191, column: 5
                              S243044=1;
                              if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 191, column: 5
                                statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 191, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 191, column: 5
                                m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 192, column: 5
                                S242558=12;
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
                      if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 5
                        enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 190, column: 5
                        S242558=11;
                        S243049=0;
                        if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 191, column: 5
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 191, column: 5
                          S243049=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S243044=0;
                          if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 191, column: 5
                            statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 191, column: 5
                            S243044=1;
                            if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 191, column: 5
                              statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 191, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 191, column: 5
                              m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 192, column: 5
                              S242558=12;
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
                S243005=1;
                S243005=0;
                if(!enableDumper_o.isPartnerPresent() || enableDumper_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 190, column: 5
                  enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 5
                  S243005=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S243000=0;
                  if(enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 5
                    enableDumper_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 190, column: 5
                    S243000=1;
                    if(!enableDumper_o.isACK()){//sysj\recyclingStationController.sysj line: 190, column: 5
                      enableDumper_o.setREQ(false);//sysj\recyclingStationController.sysj line: 190, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 190, column: 5
                      S242558=11;
                      S243049=0;
                      if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 191, column: 5
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 191, column: 5
                        S243049=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S243044=0;
                        if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 191, column: 5
                          statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 191, column: 5
                          S243044=1;
                          if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 191, column: 5
                            statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 191, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 191, column: 5
                            m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 192, column: 5
                            S242558=12;
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
            switch(S243049){
              case 0 : 
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 191, column: 5
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 191, column: 5
                  S243049=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S243044){
                    case 0 : 
                      if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 191, column: 5
                        statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 191, column: 5
                        S243044=1;
                        if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 191, column: 5
                          statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 191, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 191, column: 5
                          m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 192, column: 5
                          S242558=12;
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
                      if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 191, column: 5
                        statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 191, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 191, column: 5
                        m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 192, column: 5
                        S242558=12;
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
                S243049=1;
                S243049=0;
                if(!statusDumper_in.isPartnerPresent() || statusDumper_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 191, column: 5
                  statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 191, column: 5
                  S243049=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S243044=0;
                  if(!statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 191, column: 5
                    statusDumper_in.setACK(true);//sysj\recyclingStationController.sysj line: 191, column: 5
                    S243044=1;
                    if(statusDumper_in.isREQ()){//sysj\recyclingStationController.sysj line: 191, column: 5
                      statusDumper_in.setACK(false);//sysj\recyclingStationController.sysj line: 191, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 191, column: 5
                      m_thread_4.record(((Integer)(statusDumper_in.getVal() == null ? null : ((Integer)statusDumper_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 192, column: 5
                      S242558=12;
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
            S242558=12;
            S242558=13;
            S243137=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 196, column: 5
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 196, column: 5
              S243137=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S243132=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 196, column: 5
                enableConveyor_o.setVal(new Integer(TO_RETURN_thread_4));//sysj\recyclingStationController.sysj line: 196, column: 5
                S243132=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 196, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 196, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 196, column: 5
                  S242558=14;
                  S243181=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 197, column: 5
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 197, column: 5
                    S243181=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S243176=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 197, column: 5
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 197, column: 5
                      S243176=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 197, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 197, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 197, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 198, column: 5
                        S242558=15;
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
            switch(S243137){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 196, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 196, column: 5
                  S243137=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S243132){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 196, column: 5
                        enableConveyor_o.setVal(new Integer(TO_RETURN_thread_4));//sysj\recyclingStationController.sysj line: 196, column: 5
                        S243132=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 196, column: 5
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 196, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 196, column: 5
                          S242558=14;
                          S243181=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 197, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 197, column: 5
                            S243181=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S243176=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 197, column: 5
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 197, column: 5
                              S243176=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 197, column: 5
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 197, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 197, column: 5
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 198, column: 5
                                S242558=15;
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
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 196, column: 5
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 196, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 196, column: 5
                        S242558=14;
                        S243181=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 197, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 197, column: 5
                          S243181=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S243176=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 197, column: 5
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 197, column: 5
                            S243176=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 197, column: 5
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 197, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 197, column: 5
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 198, column: 5
                              S242558=15;
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
                S243137=1;
                S243137=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 196, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 196, column: 5
                  S243137=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S243132=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 196, column: 5
                    enableConveyor_o.setVal(new Integer(TO_RETURN_thread_4));//sysj\recyclingStationController.sysj line: 196, column: 5
                    S243132=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 196, column: 5
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 196, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 196, column: 5
                      S242558=14;
                      S243181=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 197, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 197, column: 5
                        S243181=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S243176=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 197, column: 5
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 197, column: 5
                          S243176=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 197, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 197, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 197, column: 5
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 198, column: 5
                            S242558=15;
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
            switch(S243181){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 197, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 197, column: 5
                  S243181=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S243176){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 197, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 197, column: 5
                        S243176=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 197, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 197, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 197, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 198, column: 5
                          S242558=15;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 197, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 197, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 197, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 198, column: 5
                        S242558=15;
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
                S243181=1;
                S243181=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 197, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 197, column: 5
                  S243181=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S243176=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 197, column: 5
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 197, column: 5
                    S243176=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 197, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 197, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 197, column: 5
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 198, column: 5
                      S242558=15;
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
            S242558=15;
            S242558=16;
            S243269=0;
            if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 202, column: 5
              enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 202, column: 5
              S243269=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S243264=0;
              if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 202, column: 5
                enableConveyor_o.setVal(new Integer(DISCHARGE_thread_4));//sysj\recyclingStationController.sysj line: 202, column: 5
                S243264=1;
                if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 202, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 202, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 202, column: 5
                  S242558=17;
                  S243313=0;
                  if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 203, column: 5
                    statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 203, column: 5
                    S243313=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S243308=0;
                    if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 203, column: 5
                      statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 203, column: 5
                      S243308=1;
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 203, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 203, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 203, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 204, column: 5
                        S242558=18;
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
            switch(S243269){
              case 0 : 
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 202, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 202, column: 5
                  S243269=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S243264){
                    case 0 : 
                      if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 202, column: 5
                        enableConveyor_o.setVal(new Integer(DISCHARGE_thread_4));//sysj\recyclingStationController.sysj line: 202, column: 5
                        S243264=1;
                        if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 202, column: 5
                          enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 202, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 202, column: 5
                          S242558=17;
                          S243313=0;
                          if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 203, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 203, column: 5
                            S243313=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S243308=0;
                            if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 203, column: 5
                              statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 203, column: 5
                              S243308=1;
                              if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 203, column: 5
                                statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 203, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 203, column: 5
                                m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 204, column: 5
                                S242558=18;
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
                      if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 202, column: 5
                        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 202, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 202, column: 5
                        S242558=17;
                        S243313=0;
                        if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 203, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 203, column: 5
                          S243313=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S243308=0;
                          if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 203, column: 5
                            statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 203, column: 5
                            S243308=1;
                            if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 203, column: 5
                              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 203, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 203, column: 5
                              m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 204, column: 5
                              S242558=18;
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
                S243269=1;
                S243269=0;
                if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 202, column: 5
                  enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 202, column: 5
                  S243269=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S243264=0;
                  if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 202, column: 5
                    enableConveyor_o.setVal(new Integer(DISCHARGE_thread_4));//sysj\recyclingStationController.sysj line: 202, column: 5
                    S243264=1;
                    if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 202, column: 5
                      enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 202, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 202, column: 5
                      S242558=17;
                      S243313=0;
                      if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 203, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 203, column: 5
                        S243313=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S243308=0;
                        if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 203, column: 5
                          statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 203, column: 5
                          S243308=1;
                          if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 203, column: 5
                            statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 203, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 203, column: 5
                            m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 204, column: 5
                            S242558=18;
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
            switch(S243313){
              case 0 : 
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 203, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 203, column: 5
                  S243313=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S243308){
                    case 0 : 
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 203, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 203, column: 5
                        S243308=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 203, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 203, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 203, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 204, column: 5
                          S242558=18;
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
                      if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 203, column: 5
                        statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 203, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 203, column: 5
                        m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 204, column: 5
                        S242558=18;
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
                S243313=1;
                S243313=0;
                if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 203, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 203, column: 5
                  S243313=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S243308=0;
                  if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 203, column: 5
                    statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 203, column: 5
                    S243308=1;
                    if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 203, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 203, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 203, column: 5
                      m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 204, column: 5
                      S242558=18;
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
            S242558=18;
            S242558=19;
            S243401=0;
            if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 208, column: 5
              enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 208, column: 5
              S243401=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S243396=0;
              if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 208, column: 5
                enableReturn_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 208, column: 5
                S243396=1;
                if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 208, column: 5
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 208, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 208, column: 5
                  S242558=20;
                  S243445=0;
                  if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 209, column: 5
                    statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 209, column: 5
                    S243445=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S243440=0;
                    if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 209, column: 5
                      statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 209, column: 5
                      S243440=1;
                      if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 209, column: 5
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 209, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 209, column: 5
                        m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 210, column: 5
                        S242558=21;
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
            switch(S243401){
              case 0 : 
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 208, column: 5
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 208, column: 5
                  S243401=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S243396){
                    case 0 : 
                      if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 208, column: 5
                        enableReturn_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 208, column: 5
                        S243396=1;
                        if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 208, column: 5
                          enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 208, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 208, column: 5
                          S242558=20;
                          S243445=0;
                          if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 209, column: 5
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 209, column: 5
                            S243445=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S243440=0;
                            if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 209, column: 5
                              statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 209, column: 5
                              S243440=1;
                              if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 209, column: 5
                                statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 209, column: 5
                                ends[4]=2;
                                ;//sysj\recyclingStationController.sysj line: 209, column: 5
                                m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 210, column: 5
                                S242558=21;
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
                      if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 208, column: 5
                        enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 208, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 208, column: 5
                        S242558=20;
                        S243445=0;
                        if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 209, column: 5
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 209, column: 5
                          S243445=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S243440=0;
                          if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 209, column: 5
                            statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 209, column: 5
                            S243440=1;
                            if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 209, column: 5
                              statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 209, column: 5
                              ends[4]=2;
                              ;//sysj\recyclingStationController.sysj line: 209, column: 5
                              m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 210, column: 5
                              S242558=21;
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
                S243401=1;
                S243401=0;
                if(!enableReturn_o.isPartnerPresent() || enableReturn_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 208, column: 5
                  enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 208, column: 5
                  S243401=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S243396=0;
                  if(enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 208, column: 5
                    enableReturn_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 208, column: 5
                    S243396=1;
                    if(!enableReturn_o.isACK()){//sysj\recyclingStationController.sysj line: 208, column: 5
                      enableReturn_o.setREQ(false);//sysj\recyclingStationController.sysj line: 208, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 208, column: 5
                      S242558=20;
                      S243445=0;
                      if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 209, column: 5
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 209, column: 5
                        S243445=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S243440=0;
                        if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 209, column: 5
                          statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 209, column: 5
                          S243440=1;
                          if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 209, column: 5
                            statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 209, column: 5
                            ends[4]=2;
                            ;//sysj\recyclingStationController.sysj line: 209, column: 5
                            m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 210, column: 5
                            S242558=21;
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
            switch(S243445){
              case 0 : 
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 209, column: 5
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 209, column: 5
                  S243445=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S243440){
                    case 0 : 
                      if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 209, column: 5
                        statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 209, column: 5
                        S243440=1;
                        if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 209, column: 5
                          statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 209, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 209, column: 5
                          m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 210, column: 5
                          S242558=21;
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
                      if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 209, column: 5
                        statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 209, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 209, column: 5
                        m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 210, column: 5
                        S242558=21;
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
                S243445=1;
                S243445=0;
                if(!statusReturn_in.isPartnerPresent() || statusReturn_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 209, column: 5
                  statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 209, column: 5
                  S243445=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S243440=0;
                  if(!statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 209, column: 5
                    statusReturn_in.setACK(true);//sysj\recyclingStationController.sysj line: 209, column: 5
                    S243440=1;
                    if(statusReturn_in.isREQ()){//sysj\recyclingStationController.sysj line: 209, column: 5
                      statusReturn_in.setACK(false);//sysj\recyclingStationController.sysj line: 209, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 209, column: 5
                      m_thread_4.record(((Integer)(statusReturn_in.getVal() == null ? null : ((Integer)statusReturn_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 210, column: 5
                      S242558=21;
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
            S242558=21;
            m_thread_4.recovered(w_thread_4);//sysj\recyclingStationController.sysj line: 214, column: 5
            S242558=22;
            S243533=0;
            if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 215, column: 5
              bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 215, column: 5
              S243533=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S243528=0;
              if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 215, column: 5
                bottleRecycled_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 215, column: 5
                S243528=1;
                if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 215, column: 5
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 215, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 215, column: 5
                  S242558=23;
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
            switch(S243533){
              case 0 : 
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 215, column: 5
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 215, column: 5
                  S243533=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S243528){
                    case 0 : 
                      if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 215, column: 5
                        bottleRecycled_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 215, column: 5
                        S243528=1;
                        if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 215, column: 5
                          bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 215, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 215, column: 5
                          S242558=23;
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
                      if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 215, column: 5
                        bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 215, column: 5
                        ends[4]=2;
                        ;//sysj\recyclingStationController.sysj line: 215, column: 5
                        S242558=23;
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
                S243533=1;
                S243533=0;
                if(!bottleRecycled_o.isPartnerPresent() || bottleRecycled_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 215, column: 5
                  bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 215, column: 5
                  S243533=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S243528=0;
                  if(bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 215, column: 5
                    bottleRecycled_o.setVal(w_thread_4);//sysj\recyclingStationController.sysj line: 215, column: 5
                    S243528=1;
                    if(!bottleRecycled_o.isACK()){//sysj\recyclingStationController.sysj line: 215, column: 5
                      bottleRecycled_o.setREQ(false);//sysj\recyclingStationController.sysj line: 215, column: 5
                      ends[4]=2;
                      ;//sysj\recyclingStationController.sysj line: 215, column: 5
                      S242558=23;
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
            S242558=23;
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 220, column: 5
            currsigs.addElement(stationState_1);
            stationState_1.setValue(m_thread_4.levelFor(q_thread_4.hasWork()));//sysj\recyclingStationController.sysj line: 220, column: 5
            S242558=24;
            if(m_thread_4.suspended()){//sysj\recyclingStationController.sysj line: 228, column: 5
              m_thread_4.reportSuspension();//sysj\recyclingStationController.sysj line: 229, column: 6
              stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 231, column: 7
              currsigs.addElement(stationState_1);
              stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 231, column: 7
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S242558=25;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 24 : 
            stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 231, column: 7
            currsigs.addElement(stationState_1);
            stationState_1.setValue(2);//sysj\recyclingStationController.sysj line: 231, column: 7
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 25 : 
            S242558=25;
            S242558=0;
            if(!q_thread_4.hasWork()){//sysj\recyclingStationController.sysj line: 162, column: 11
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj\recyclingStationController.sysj line: 162, column: 5
              w_thread_4 = q_thread_4.take();//sysj\recyclingStationController.sysj line: 166, column: 5
              m_thread_4.beginCycle(w_thread_4);//sysj\recyclingStationController.sysj line: 167, column: 5
              stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 168, column: 5
              currsigs.addElement(stationState_1);
              stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 168, column: 5
              S242558=1;
              S242565=0;
              if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 5
                enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 172, column: 5
                S242565=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S242560=0;
                if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 172, column: 5
                  enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 172, column: 5
                  S242560=1;
                  if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 172, column: 5
                    enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 172, column: 5
                    ends[4]=2;
                    ;//sysj\recyclingStationController.sysj line: 172, column: 5
                    S242558=2;
                    S242631=0;
                    if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 173, column: 5
                      statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                      S242631=1;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S242626=0;
                      if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                        statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 173, column: 5
                        S242626=1;
                        if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                          statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                          ends[4]=2;
                          ;//sysj\recyclingStationController.sysj line: 173, column: 5
                          m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 174, column: 5
                          S242558=3;
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

  public void thread262053(int [] tdone, int [] ends){
        switch(S242552){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S242196){
          case 0 : 
            if(!q_thread_3.hasRoom()){//sysj\recyclingStationController.sysj line: 129, column: 11
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              ends[3]=2;
              ;//sysj\recyclingStationController.sysj line: 129, column: 5
              S242196=1;
              S242136=0;
              if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 132, column: 5
                bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                S242136=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S242131=0;
                if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 132, column: 5
                  bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 132, column: 5
                  S242131=1;
                  if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 132, column: 5
                    bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                    ends[3]=2;
                    ;//sysj\recyclingStationController.sysj line: 132, column: 5
                    w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 133, column: 5
                    w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 139, column: 5
                    m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 140, column: 5
                    q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 141, column: 5
                    S242196=2;
                    active[3]=1;
                    ends[3]=1;
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
            switch(S242136){
              case 0 : 
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 132, column: 5
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                  S242136=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S242131){
                    case 0 : 
                      if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 132, column: 5
                        bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 132, column: 5
                        S242131=1;
                        if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 132, column: 5
                          bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                          ends[3]=2;
                          ;//sysj\recyclingStationController.sysj line: 132, column: 5
                          w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 133, column: 5
                          w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 139, column: 5
                          m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 140, column: 5
                          q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 141, column: 5
                          S242196=2;
                          active[3]=1;
                          ends[3]=1;
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
                      if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 132, column: 5
                        bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                        ends[3]=2;
                        ;//sysj\recyclingStationController.sysj line: 132, column: 5
                        w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 133, column: 5
                        w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 139, column: 5
                        m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 140, column: 5
                        q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 141, column: 5
                        S242196=2;
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
                S242136=1;
                S242136=0;
                if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 132, column: 5
                  bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                  S242136=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S242131=0;
                  if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 132, column: 5
                    bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 132, column: 5
                    S242131=1;
                    if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 132, column: 5
                      bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                      ends[3]=2;
                      ;//sysj\recyclingStationController.sysj line: 132, column: 5
                      w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 133, column: 5
                      w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 139, column: 5
                      m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 140, column: 5
                      q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 141, column: 5
                      S242196=2;
                      active[3]=1;
                      ends[3]=1;
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
            S242196=2;
            S242196=0;
            if(!q_thread_3.hasRoom()){//sysj\recyclingStationController.sysj line: 129, column: 11
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              ends[3]=2;
              ;//sysj\recyclingStationController.sysj line: 129, column: 5
              S242196=1;
              S242136=0;
              if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 132, column: 5
                bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                S242136=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S242131=0;
                if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 132, column: 5
                  bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 132, column: 5
                  S242131=1;
                  if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 132, column: 5
                    bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 132, column: 5
                    ends[3]=2;
                    ;//sysj\recyclingStationController.sysj line: 132, column: 5
                    w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 133, column: 5
                    w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 139, column: 5
                    m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 140, column: 5
                    q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 141, column: 5
                    S242196=2;
                    active[3]=1;
                    ends[3]=1;
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

  public void thread262052(int [] tdone, int [] ends){
        switch(S242124){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(stationState_1.getprestatus()){//sysj\recyclingStationController.sysj line: 109, column: 13
          cur_thread_2 = ((Integer)(stationState_1.getpreval() == null ? 0 : ((Integer)stationState_1.getpreval()).intValue())).intValue();//sysj\recyclingStationController.sysj line: 110, column: 6
          recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 112, column: 5
          currsigs.addElement(recyclingStatus);
          recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 112, column: 5
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 112, column: 5
          currsigs.addElement(recyclingStatus);
          recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 112, column: 5
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread262050(int [] tdone, int [] ends){
        S248752=1;
    q_thread_4 = RecyclingQueue.shared();//sysj\recyclingStationController.sysj line: 147, column: 4
    m_thread_4 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 148, column: 4
    TO_LID_thread_4 = 1;//sysj\recyclingStationController.sysj line: 151, column: 4
    TO_DUMP_thread_4 = 2;//sysj\recyclingStationController.sysj line: 152, column: 4
    TO_RETURN_thread_4 = 3;//sysj\recyclingStationController.sysj line: 153, column: 4
    DISCHARGE_thread_4 = 4;//sysj\recyclingStationController.sysj line: 154, column: 4
    w_thread_4 = null;//sysj\recyclingStationController.sysj line: 156, column: 4
    permitted_thread_4 = false;//sysj\recyclingStationController.sysj line: 157, column: 4
    S242558=0;
    if(!q_thread_4.hasWork()){//sysj\recyclingStationController.sysj line: 162, column: 11
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      ends[4]=2;
      ;//sysj\recyclingStationController.sysj line: 162, column: 5
      w_thread_4 = q_thread_4.take();//sysj\recyclingStationController.sysj line: 166, column: 5
      m_thread_4.beginCycle(w_thread_4);//sysj\recyclingStationController.sysj line: 167, column: 5
      stationState_1.setPresent();//sysj\recyclingStationController.sysj line: 168, column: 5
      currsigs.addElement(stationState_1);
      stationState_1.setValue(1);//sysj\recyclingStationController.sysj line: 168, column: 5
      S242558=1;
      S242565=0;
      if(!enableConveyor_o.isPartnerPresent() || enableConveyor_o.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 172, column: 5
        enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 172, column: 5
        S242565=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S242560=0;
        if(enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 172, column: 5
          enableConveyor_o.setVal(new Integer(TO_LID_thread_4));//sysj\recyclingStationController.sysj line: 172, column: 5
          S242560=1;
          if(!enableConveyor_o.isACK()){//sysj\recyclingStationController.sysj line: 172, column: 5
            enableConveyor_o.setREQ(false);//sysj\recyclingStationController.sysj line: 172, column: 5
            ends[4]=2;
            ;//sysj\recyclingStationController.sysj line: 172, column: 5
            S242558=2;
            S242631=0;
            if(!statusConveyor_in.isPartnerPresent() || statusConveyor_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 173, column: 5
              statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
              S242631=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S242626=0;
              if(!statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                statusConveyor_in.setACK(true);//sysj\recyclingStationController.sysj line: 173, column: 5
                S242626=1;
                if(statusConveyor_in.isREQ()){//sysj\recyclingStationController.sysj line: 173, column: 5
                  statusConveyor_in.setACK(false);//sysj\recyclingStationController.sysj line: 173, column: 5
                  ends[4]=2;
                  ;//sysj\recyclingStationController.sysj line: 173, column: 5
                  m_thread_4.record(((Integer)(statusConveyor_in.getVal() == null ? null : ((Integer)statusConveyor_in.getVal()))).intValue());//sysj\recyclingStationController.sysj line: 174, column: 5
                  S242558=3;
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

  public void thread262049(int [] tdone, int [] ends){
        S242552=1;
    q_thread_3 = RecyclingQueue.shared();//sysj\recyclingStationController.sysj line: 124, column: 4
    m_thread_3 = RecyclingRecord.shared();//sysj\recyclingStationController.sysj line: 125, column: 4
    w_thread_3 = null;//sysj\recyclingStationController.sysj line: 126, column: 4
    S242196=0;
    if(!q_thread_3.hasRoom()){//sysj\recyclingStationController.sysj line: 129, column: 11
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      ends[3]=2;
      ;//sysj\recyclingStationController.sysj line: 129, column: 5
      S242196=1;
      S242136=0;
      if(!bottleRejected_in.isPartnerPresent() || bottleRejected_in.isPartnerPreempted()){//sysj\recyclingStationController.sysj line: 132, column: 5
        bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 132, column: 5
        S242136=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S242131=0;
        if(!bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 132, column: 5
          bottleRejected_in.setACK(true);//sysj\recyclingStationController.sysj line: 132, column: 5
          S242131=1;
          if(bottleRejected_in.isREQ()){//sysj\recyclingStationController.sysj line: 132, column: 5
            bottleRejected_in.setACK(false);//sysj\recyclingStationController.sysj line: 132, column: 5
            ends[3]=2;
            ;//sysj\recyclingStationController.sysj line: 132, column: 5
            w_thread_3 = (WorkpieceTwin)(bottleRejected_in.getVal() == null ? null : ((WorkpieceTwin)bottleRejected_in.getVal()));//sysj\recyclingStationController.sysj line: 133, column: 5
            w_thread_3.arrived(Machine.RECYCLING);//sysj\recyclingStationController.sysj line: 139, column: 5
            m_thread_3.accepted(w_thread_3);//sysj\recyclingStationController.sysj line: 140, column: 5
            q_thread_3.push(w_thread_3);//sysj\recyclingStationController.sysj line: 141, column: 5
            S242196=2;
            active[3]=1;
            ends[3]=1;
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

  public void thread262048(int [] tdone, int [] ends){
        S242124=1;
    cur_thread_2 = 0;//sysj\recyclingStationController.sysj line: 107, column: 4
    if(stationState_1.getprestatus()){//sysj\recyclingStationController.sysj line: 109, column: 13
      cur_thread_2 = ((Integer)(stationState_1.getpreval() == null ? 0 : ((Integer)stationState_1.getpreval()).intValue())).intValue();//sysj\recyclingStationController.sysj line: 110, column: 6
      recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 112, column: 5
      currsigs.addElement(recyclingStatus);
      recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 112, column: 5
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
    else {
      recyclingStatus.setPresent();//sysj\recyclingStationController.sysj line: 112, column: 5
      currsigs.addElement(recyclingStatus);
      recyclingStatus.setValue(cur_thread_2);//sysj\recyclingStationController.sysj line: 112, column: 5
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
      switch(S262046){
        case 0 : 
          S262046=0;
          break RUN;
        
        case 1 : 
          S262046=2;
          S262046=2;
          S248754=0;
          if(reset.getprestatus()){//sysj\recyclingStationController.sysj line: 100, column: 19
            bottleRejected_in.setPreempted();
            statusConveyor_in.setPreempted();
            statusLidRemoval_in.setPreempted();
            enableConveyor_o.setPreempted();
            enableLidRemoval_o.setPreempted();
            S248754=1;
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          else {
            stationState_1.setClear();//sysj\recyclingStationController.sysj line: 104, column: 3
            thread262048(tdone,ends);
            thread262049(tdone,ends);
            thread262050(tdone,ends);
            int biggest262051 = 0;
            if(ends[2]>=biggest262051){
              biggest262051=ends[2];
            }
            if(ends[3]>=biggest262051){
              biggest262051=ends[3];
            }
            if(ends[4]>=biggest262051){
              biggest262051=ends[4];
            }
            if(biggest262051 == 1){
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
        
        case 2 : 
          switch(S248754){
            case 0 : 
              if(reset.getprestatus()){//sysj\recyclingStationController.sysj line: 100, column: 19
                bottleRejected_in.setPreempted();
                statusConveyor_in.setPreempted();
                statusLidRemoval_in.setPreempted();
                enableConveyor_o.setPreempted();
                enableLidRemoval_o.setPreempted();
                S248754=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                stationState_1.setClear();//sysj\recyclingStationController.sysj line: 104, column: 3
                thread262052(tdone,ends);
                thread262053(tdone,ends);
                thread262054(tdone,ends);
                int biggest262055 = 0;
                if(ends[2]>=biggest262055){
                  biggest262055=ends[2];
                }
                if(ends[3]>=biggest262055){
                  biggest262055=ends[3];
                }
                if(ends[4]>=biggest262055){
                  biggest262055=ends[4];
                }
                if(biggest262055 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest262055 == 0){
                  S248754=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 1 : 
              S248754=1;
              S248754=0;
              if(reset.getprestatus()){//sysj\recyclingStationController.sysj line: 100, column: 19
                bottleRejected_in.setPreempted();
                statusConveyor_in.setPreempted();
                statusLidRemoval_in.setPreempted();
                enableConveyor_o.setPreempted();
                enableLidRemoval_o.setPreempted();
                S248754=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                stationState_1.setClear();//sysj\recyclingStationController.sysj line: 104, column: 3
                thread262056(tdone,ends);
                thread262057(tdone,ends);
                thread262058(tdone,ends);
                int biggest262059 = 0;
                if(ends[2]>=biggest262059){
                  biggest262059=ends[2];
                }
                if(ends[3]>=biggest262059){
                  biggest262059=ends[3];
                }
                if(ends[4]>=biggest262059){
                  biggest262059=ends[4];
                }
                if(biggest262059 == 1){
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
