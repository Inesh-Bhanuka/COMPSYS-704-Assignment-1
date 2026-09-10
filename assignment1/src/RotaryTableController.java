import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class RotaryTableController extends ClockDomain{
  public RotaryTableController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal tableAligned = new Signal("tableAligned", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.INPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.INPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.INPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.INPUT);
  public Signal exitCleared = new Signal("exitCleared", Signal.INPUT);
  public Signal twin = new Signal("twin", Signal.OUTPUT);
  public Signal rotaryTrigger = new Signal("rotaryTrigger", Signal.OUTPUT);
  public Signal loadPos1 = new Signal("loadPos1", Signal.OUTPUT);
  public Signal unloadExit = new Signal("unloadExit", Signal.OUTPUT);
  public input_Channel tableInfeed_in = new input_Channel();
  public input_Channel doneFiller1_in = new input_Channel();
  public input_Channel doneFiller2_in = new input_Channel();
  public input_Channel doneLid_in = new input_Channel();
  public input_Channel doneCapper_in = new input_Channel();
  public output_Channel tableOutfeed_o = new output_Channel();
  public output_Channel startFiller1_o = new output_Channel();
  public output_Channel startFiller2_o = new output_Channel();
  public output_Channel startLid_o = new output_Channel();
  public output_Channel startCapper_o = new output_Channel();
  private Signal placed_1;
  private RotaryTableTwin t_thread_2;//sysj\rotaryTableController.sysj line: 59, column: 3
  private int step_thread_2;//sysj\rotaryTableController.sysj line: 60, column: 3
  private TableModel m_thread_2;//sysj\rotaryTableController.sysj line: 61, column: 3
  private WorkpieceTwin exiting_thread_2;//sysj\rotaryTableController.sysj line: 62, column: 3
  private TableModel m_thread_3;//sysj\rotaryTableController.sysj line: 148, column: 3
  private WorkpieceTwin w_thread_3;//sysj\rotaryTableController.sysj line: 149, column: 3
  private int S194853 = 1;
  private int S194687 = 1;
  private int S166380 = 1;
  private int S166194 = 1;
  private int S166201 = 1;
  private int S166196 = 1;
  private int S166425 = 1;
  private int S166523 = 1;
  private int S166518 = 1;
  private int S166897 = 1;
  private int S166892 = 1;
  private int S167315 = 1;
  private int S167310 = 1;
  private int S167777 = 1;
  private int S167772 = 1;
  private int S168283 = 1;
  private int S168278 = 1;
  private int S168833 = 1;
  private int S168828 = 1;
  private int S169427 = 1;
  private int S169422 = 1;
  private int S170065 = 1;
  private int S170060 = 1;
  private int S194851 = 1;
  private int S194711 = 1;
  private int S194695 = 1;
  private int S194690 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread194859(int [] tdone, int [] ends){
        switch(S194851){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S194711){
          case 0 : 
            switch(S194695){
              case 0 : 
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 151, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 151, column: 4
                  S194695=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S194690){
                    case 0 : 
                      if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 151, column: 4
                        tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 151, column: 4
                        S194690=1;
                        if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 151, column: 4
                          tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 151, column: 4
                          ends[3]=2;
                          ;//sysj\rotaryTableController.sysj line: 151, column: 4
                          w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 152, column: 4
                          m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 153, column: 4
                          System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 154, column: 4
                          S194711=1;
                          if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 155, column: 20
                            S194711=2;
                            active[3]=1;
                            ends[3]=1;
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
                      else {
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 151, column: 4
                        tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 151, column: 4
                        ends[3]=2;
                        ;//sysj\rotaryTableController.sysj line: 151, column: 4
                        w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 152, column: 4
                        m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 153, column: 4
                        System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 154, column: 4
                        S194711=1;
                        if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 155, column: 20
                          S194711=2;
                          active[3]=1;
                          ends[3]=1;
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
                    
                  }
                }
                break;
              
              case 1 : 
                S194695=1;
                S194695=0;
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 151, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 151, column: 4
                  S194695=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S194690=0;
                  if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 151, column: 4
                    tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 151, column: 4
                    S194690=1;
                    if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 151, column: 4
                      tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 151, column: 4
                      ends[3]=2;
                      ;//sysj\rotaryTableController.sysj line: 151, column: 4
                      w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 152, column: 4
                      m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 153, column: 4
                      System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 154, column: 4
                      S194711=1;
                      if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 155, column: 20
                        S194711=2;
                        active[3]=1;
                        ends[3]=1;
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
            if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 155, column: 20
              S194711=2;
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
          
          case 2 : 
            S194711=2;
            S194711=0;
            S194695=0;
            if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 151, column: 4
              tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 151, column: 4
              S194695=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S194690=0;
              if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 151, column: 4
                tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 151, column: 4
                S194690=1;
                if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 151, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 151, column: 4
                  ends[3]=2;
                  ;//sysj\rotaryTableController.sysj line: 151, column: 4
                  w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 152, column: 4
                  m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 153, column: 4
                  System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 154, column: 4
                  S194711=1;
                  if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 155, column: 20
                    S194711=2;
                    active[3]=1;
                    ends[3]=1;
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

  public void thread194858(int [] tdone, int [] ends){
        switch(S194687){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S166380){
          case 0 : 
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 66, column: 20
              S166380=1;
              if(m_thread_2.exitOccupied()){//sysj\rotaryTableController.sysj line: 74, column: 4
                exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj\rotaryTableController.sysj line: 75, column: 5
                m_thread_2.sayUnloading();//sysj\rotaryTableController.sysj line: 76, column: 5
                S166194=0;
                S166201=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 77, column: 5
                  tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 77, column: 5
                  S166201=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S166196=0;
                  if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 77, column: 5
                    tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 77, column: 5
                    S166196=1;
                    if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 77, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 77, column: 5
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 77, column: 5
                      S166194=1;
                      if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 78, column: 21
                        m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 81, column: 5
                        S166380=2;
                        if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 87, column: 4
                          if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 88, column: 11
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 88, column: 5
                            S166380=3;
                            if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                              S166425=0;
                              if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                                m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                                placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                                currsigs.addElement(placed_1);
                                S166425=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                                currsigs.addElement(loadPos1);
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              S166380=4;
                              S166523=0;
                              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                S166523=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S166518=0;
                                if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                  startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                                  S166518=1;
                                  if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 116, column: 4
                                    S166380=5;
                                    S166897=0;
                                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                      S166897=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S166892=0;
                                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                                        S166892=1;
                                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                          S166380=6;
                                          S167315=0;
                                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                            S167315=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S167310=0;
                                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                              S167310=1;
                                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                                S166380=7;
                                                S167777=0;
                                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  S167777=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S167772=0;
                                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    S167772=1;
                                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      S166380=8;
                                                      S168283=0;
                                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                        S168283=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S168278=0;
                                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                          S168278=1;
                                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                            S166380=9;
                                                            S168833=0;
                                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              S168833=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S168828=0;
                                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                S168828=1;
                                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  S166380=10;
                                                                  S169427=0;
                                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    S169427=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S169422=0;
                                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      S169422=1;
                                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        S166380=11;
                                                                        S170065=0;
                                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          S170065=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S170060=0;
                                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            S170060=1;
                                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              S166380=12;
                                                                              if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                                S166380=13;
                                                                                if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                                  m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                                  m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                                  step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                                  t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                                  t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                                  if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                                    twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                    currsigs.addElement(twin);
                                                                                    twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                    S166380=14;
                                                                                    active[2]=1;
                                                                                    ends[2]=1;
                                                                                    tdone[2]=1;
                                                                                  }
                                                                                  else {
                                                                                    S166380=14;
                                                                                    active[2]=1;
                                                                                    ends[2]=1;
                                                                                    tdone[2]=1;
                                                                                  }
                                                                                }
                                                                                else {
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                              }
                                                                              else {
                                                                                rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                                currsigs.addElement(rotaryTrigger);
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                            }
                                                                            else {
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                          }
                                                                          else {
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                        }
                                                                      }
                                                                      else {
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                }
                                                                else {
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                            }
                          }
                        }
                        else {
                          S166380=3;
                          if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                            S166425=0;
                            if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                              m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                              placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                              currsigs.addElement(placed_1);
                              S166425=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                              currsigs.addElement(loadPos1);
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            S166380=4;
                            S166523=0;
                            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                              S166523=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S166518=0;
                              if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                                S166518=1;
                                if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 116, column: 4
                                  S166380=5;
                                  S166897=0;
                                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                    S166897=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S166892=0;
                                    if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                      startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                                      S166892=1;
                                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                        S166380=6;
                                        S167315=0;
                                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                          S167315=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S167310=0;
                                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                            S167310=1;
                                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                              S166380=7;
                                              S167777=0;
                                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                S167777=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S167772=0;
                                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  S167772=1;
                                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    S166380=8;
                                                    S168283=0;
                                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                      S168283=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S168278=0;
                                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                        S168278=1;
                                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                          S166380=9;
                                                          S168833=0;
                                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            S168833=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S168828=0;
                                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              S168828=1;
                                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                S166380=10;
                                                                S169427=0;
                                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  S169427=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S169422=0;
                                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    S169422=1;
                                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      S166380=11;
                                                                      S170065=0;
                                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        S170065=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S170060=0;
                                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          S170060=1;
                                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            S166380=12;
                                                                            if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                              S166380=13;
                                                                              if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                                m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                                m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                                step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                                t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                                t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                                if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                                  twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                  currsigs.addElement(twin);
                                                                                  twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                  S166380=14;
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                                else {
                                                                                  S166380=14;
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                              }
                                                                              else {
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                            }
                                                                            else {
                                                                              rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                              currsigs.addElement(rotaryTrigger);
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                          }
                                                                          else {
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                        }
                                                                        else {
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                      }
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                          }
                        }
                      }
                      else {
                        unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 79, column: 6
                        currsigs.addElement(unloadExit);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
              }
              else {
                S166380=2;
                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 87, column: 4
                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 88, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 88, column: 5
                    S166380=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                      S166425=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                        currsigs.addElement(placed_1);
                        S166425=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S166380=4;
                      S166523=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                        S166523=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S166518=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                          S166518=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 116, column: 4
                            S166380=5;
                            S166897=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                              S166897=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S166892=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                                S166892=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                  S166380=6;
                                  S167315=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                    S167315=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S167310=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S167310=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                        S166380=7;
                                        S167777=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                          S167777=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S167772=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S167772=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                              S166380=8;
                                              S168283=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                S168283=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S168278=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  S168278=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                    S166380=9;
                                                    S168833=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S168833=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S168828=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S168828=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          S166380=10;
                                                          S169427=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S169427=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S169422=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S169422=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                S166380=11;
                                                                S170065=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  S170065=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S170060=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S170060=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      S166380=12;
                                                                      if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                        S166380=13;
                                                                        if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                          m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                          m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                          step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                          t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                          t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                          if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                            twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                            currsigs.addElement(twin);
                                                                            twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                            S166380=14;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S166380=14;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                        }
                                                                        else {
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                      }
                                                                      else {
                                                                        rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                        currsigs.addElement(rotaryTrigger);
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                  }
                }
                else {
                  S166380=3;
                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                    S166425=0;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                      currsigs.addElement(placed_1);
                      S166425=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S166380=4;
                    S166523=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                      S166523=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S166518=0;
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                        S166518=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 116, column: 4
                          S166380=5;
                          S166897=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                            S166897=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S166892=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                              S166892=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                S166380=6;
                                S167315=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S167315=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S167310=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                    S167310=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S166380=7;
                                      S167777=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S167777=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S167772=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                          S167772=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S166380=8;
                                            S168283=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                              S168283=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S168278=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                S168278=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  S166380=9;
                                                  S168833=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S168833=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S168828=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S168828=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S166380=10;
                                                        S169427=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S169427=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S169422=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S169422=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S166380=11;
                                                              S170065=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S170065=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S170060=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  S170060=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S166380=12;
                                                                    if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                      S166380=13;
                                                                      if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                        m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                        m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                        step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                        t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                        t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                        if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                          twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                          currsigs.addElement(twin);
                                                                          twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                          S166380=14;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S166380=14;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                      }
                                                                      else {
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                    else {
                                                                      rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                      currsigs.addElement(rotaryTrigger);
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                                else {
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                }
              }
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            switch(S166194){
              case 0 : 
                switch(S166201){
                  case 0 : 
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 77, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 77, column: 5
                      S166201=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      switch(S166196){
                        case 0 : 
                          if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 77, column: 5
                            tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 77, column: 5
                            S166196=1;
                            if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 77, column: 5
                              tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 77, column: 5
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 77, column: 5
                              S166194=1;
                              if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 78, column: 21
                                m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 81, column: 5
                                S166380=2;
                                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 87, column: 4
                                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 88, column: 11
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 88, column: 5
                                    S166380=3;
                                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                                      S166425=0;
                                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                                        currsigs.addElement(placed_1);
                                        S166425=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                                        currsigs.addElement(loadPos1);
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      S166380=4;
                                      S166523=0;
                                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                        S166523=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S166518=0;
                                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                                          S166518=1;
                                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 116, column: 4
                                            S166380=5;
                                            S166897=0;
                                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                              S166897=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S166892=0;
                                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                                                S166892=1;
                                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                                  S166380=6;
                                                  S167315=0;
                                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                    S167315=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S167310=0;
                                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                                      S167310=1;
                                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                                        S166380=7;
                                                        S167777=0;
                                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                          S167777=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S167772=0;
                                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                            S167772=1;
                                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                              S166380=8;
                                                              S168283=0;
                                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                S168283=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S168278=0;
                                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                  S168278=1;
                                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                    S166380=9;
                                                                    S168833=0;
                                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                      S168833=1;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      S168828=0;
                                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                        S168828=1;
                                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                          ends[2]=2;
                                                                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                          S166380=10;
                                                                          S169427=0;
                                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                            S169427=1;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S169422=0;
                                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                              S169422=1;
                                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                                ends[2]=2;
                                                                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                                S166380=11;
                                                                                S170065=0;
                                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                  S170065=1;
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                                else {
                                                                                  S170060=0;
                                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                    S170060=1;
                                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                      ends[2]=2;
                                                                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                      S166380=12;
                                                                                      if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                                        S166380=13;
                                                                                        if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                                          m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                                          m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                                          step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                                          t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                                          t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                                          if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                                            twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                            currsigs.addElement(twin);
                                                                                            twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                            S166380=14;
                                                                                            active[2]=1;
                                                                                            ends[2]=1;
                                                                                            tdone[2]=1;
                                                                                          }
                                                                                          else {
                                                                                            S166380=14;
                                                                                            active[2]=1;
                                                                                            ends[2]=1;
                                                                                            tdone[2]=1;
                                                                                          }
                                                                                        }
                                                                                        else {
                                                                                          active[2]=1;
                                                                                          ends[2]=1;
                                                                                          tdone[2]=1;
                                                                                        }
                                                                                      }
                                                                                      else {
                                                                                        rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                                        currsigs.addElement(rotaryTrigger);
                                                                                        active[2]=1;
                                                                                        ends[2]=1;
                                                                                        tdone[2]=1;
                                                                                      }
                                                                                    }
                                                                                    else {
                                                                                      active[2]=1;
                                                                                      ends[2]=1;
                                                                                      tdone[2]=1;
                                                                                    }
                                                                                  }
                                                                                  else {
                                                                                    active[2]=1;
                                                                                    ends[2]=1;
                                                                                    tdone[2]=1;
                                                                                  }
                                                                                }
                                                                              }
                                                                              else {
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                            }
                                                                            else {
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                          }
                                                                        }
                                                                        else {
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                      }
                                                                      else {
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                                else {
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                    }
                                  }
                                }
                                else {
                                  S166380=3;
                                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                                    S166425=0;
                                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                                      currsigs.addElement(placed_1);
                                      S166425=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                                      currsigs.addElement(loadPos1);
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    S166380=4;
                                    S166523=0;
                                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                      S166523=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S166518=0;
                                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                                        S166518=1;
                                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 116, column: 4
                                          S166380=5;
                                          S166897=0;
                                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                            S166897=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S166892=0;
                                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                                              S166892=1;
                                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                                S166380=6;
                                                S167315=0;
                                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  S167315=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S167310=0;
                                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                                    S167310=1;
                                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                                      S166380=7;
                                                      S167777=0;
                                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        S167777=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S167772=0;
                                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                          S167772=1;
                                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                            S166380=8;
                                                            S168283=0;
                                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                              S168283=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S168278=0;
                                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                S168278=1;
                                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                  S166380=9;
                                                                  S168833=0;
                                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    S168833=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S168828=0;
                                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                      S168828=1;
                                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                        S166380=10;
                                                                        S169427=0;
                                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          S169427=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S169422=0;
                                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                            S169422=1;
                                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                              S166380=11;
                                                                              S170065=0;
                                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                S170065=1;
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                              else {
                                                                                S170060=0;
                                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                  S170060=1;
                                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                    ends[2]=2;
                                                                                    ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                    S166380=12;
                                                                                    if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                                      S166380=13;
                                                                                      if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                                        m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                                        m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                                        step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                                        t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                                        t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                                        if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                                          twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                          currsigs.addElement(twin);
                                                                                          twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                          S166380=14;
                                                                                          active[2]=1;
                                                                                          ends[2]=1;
                                                                                          tdone[2]=1;
                                                                                        }
                                                                                        else {
                                                                                          S166380=14;
                                                                                          active[2]=1;
                                                                                          ends[2]=1;
                                                                                          tdone[2]=1;
                                                                                        }
                                                                                      }
                                                                                      else {
                                                                                        active[2]=1;
                                                                                        ends[2]=1;
                                                                                        tdone[2]=1;
                                                                                      }
                                                                                    }
                                                                                    else {
                                                                                      rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                                      currsigs.addElement(rotaryTrigger);
                                                                                      active[2]=1;
                                                                                      ends[2]=1;
                                                                                      tdone[2]=1;
                                                                                    }
                                                                                  }
                                                                                  else {
                                                                                    active[2]=1;
                                                                                    ends[2]=1;
                                                                                    tdone[2]=1;
                                                                                  }
                                                                                }
                                                                                else {
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                              }
                                                                            }
                                                                            else {
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                          }
                                                                          else {
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                        }
                                                                      }
                                                                      else {
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                }
                                                                else {
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                  }
                                }
                              }
                              else {
                                unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 79, column: 6
                                currsigs.addElement(unloadExit);
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          break;
                        
                        case 1 : 
                          if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 77, column: 5
                            tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 77, column: 5
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 77, column: 5
                            S166194=1;
                            if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 78, column: 21
                              m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 81, column: 5
                              S166380=2;
                              if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 87, column: 4
                                if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 88, column: 11
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 88, column: 5
                                  S166380=3;
                                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                                    S166425=0;
                                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                                      currsigs.addElement(placed_1);
                                      S166425=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                                      currsigs.addElement(loadPos1);
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    S166380=4;
                                    S166523=0;
                                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                      S166523=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S166518=0;
                                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                                        S166518=1;
                                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 116, column: 4
                                          S166380=5;
                                          S166897=0;
                                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                            S166897=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S166892=0;
                                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                                              S166892=1;
                                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                                S166380=6;
                                                S167315=0;
                                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  S167315=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S167310=0;
                                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                                    S167310=1;
                                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                                      S166380=7;
                                                      S167777=0;
                                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        S167777=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S167772=0;
                                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                          S167772=1;
                                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                            S166380=8;
                                                            S168283=0;
                                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                              S168283=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S168278=0;
                                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                S168278=1;
                                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                  S166380=9;
                                                                  S168833=0;
                                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    S168833=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S168828=0;
                                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                      S168828=1;
                                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                        S166380=10;
                                                                        S169427=0;
                                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          S169427=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S169422=0;
                                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                            S169422=1;
                                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                              S166380=11;
                                                                              S170065=0;
                                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                S170065=1;
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                              else {
                                                                                S170060=0;
                                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                  S170060=1;
                                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                    ends[2]=2;
                                                                                    ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                    S166380=12;
                                                                                    if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                                      S166380=13;
                                                                                      if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                                        m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                                        m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                                        step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                                        t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                                        t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                                        if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                                          twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                          currsigs.addElement(twin);
                                                                                          twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                          S166380=14;
                                                                                          active[2]=1;
                                                                                          ends[2]=1;
                                                                                          tdone[2]=1;
                                                                                        }
                                                                                        else {
                                                                                          S166380=14;
                                                                                          active[2]=1;
                                                                                          ends[2]=1;
                                                                                          tdone[2]=1;
                                                                                        }
                                                                                      }
                                                                                      else {
                                                                                        active[2]=1;
                                                                                        ends[2]=1;
                                                                                        tdone[2]=1;
                                                                                      }
                                                                                    }
                                                                                    else {
                                                                                      rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                                      currsigs.addElement(rotaryTrigger);
                                                                                      active[2]=1;
                                                                                      ends[2]=1;
                                                                                      tdone[2]=1;
                                                                                    }
                                                                                  }
                                                                                  else {
                                                                                    active[2]=1;
                                                                                    ends[2]=1;
                                                                                    tdone[2]=1;
                                                                                  }
                                                                                }
                                                                                else {
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                              }
                                                                            }
                                                                            else {
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                          }
                                                                          else {
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                        }
                                                                      }
                                                                      else {
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                }
                                                                else {
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                  }
                                }
                              }
                              else {
                                S166380=3;
                                if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                                  S166425=0;
                                  if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                                    m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                                    placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                                    currsigs.addElement(placed_1);
                                    S166425=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                                    currsigs.addElement(loadPos1);
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  S166380=4;
                                  S166523=0;
                                  if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                    S166523=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S166518=0;
                                    if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                      startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                                      S166518=1;
                                      if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 116, column: 4
                                        S166380=5;
                                        S166897=0;
                                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                          S166897=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S166892=0;
                                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                            startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                                            S166892=1;
                                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                              S166380=6;
                                              S167315=0;
                                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                S167315=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S167310=0;
                                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  S167310=1;
                                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                                    S166380=7;
                                                    S167777=0;
                                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      S167777=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S167772=0;
                                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        S167772=1;
                                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                          S166380=8;
                                                          S168283=0;
                                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                            S168283=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S168278=0;
                                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                              S168278=1;
                                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                S166380=9;
                                                                S168833=0;
                                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  S168833=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S168828=0;
                                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    S168828=1;
                                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                      S166380=10;
                                                                      S169427=0;
                                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        S169427=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S169422=0;
                                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          S169422=1;
                                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                            S166380=11;
                                                                            S170065=0;
                                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              S170065=1;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              S170060=0;
                                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                S170060=1;
                                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                  ends[2]=2;
                                                                                  ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                  S166380=12;
                                                                                  if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                                    S166380=13;
                                                                                    if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                                      m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                                      m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                                        twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                        currsigs.addElement(twin);
                                                                                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                        S166380=14;
                                                                                        active[2]=1;
                                                                                        ends[2]=1;
                                                                                        tdone[2]=1;
                                                                                      }
                                                                                      else {
                                                                                        S166380=14;
                                                                                        active[2]=1;
                                                                                        ends[2]=1;
                                                                                        tdone[2]=1;
                                                                                      }
                                                                                    }
                                                                                    else {
                                                                                      active[2]=1;
                                                                                      ends[2]=1;
                                                                                      tdone[2]=1;
                                                                                    }
                                                                                  }
                                                                                  else {
                                                                                    rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                                    currsigs.addElement(rotaryTrigger);
                                                                                    active[2]=1;
                                                                                    ends[2]=1;
                                                                                    tdone[2]=1;
                                                                                  }
                                                                                }
                                                                                else {
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                              }
                                                                              else {
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                            }
                                                                          }
                                                                          else {
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                        }
                                                                        else {
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                      }
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                }
                              }
                            }
                            else {
                              unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 79, column: 6
                              currsigs.addElement(unloadExit);
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          break;
                        
                      }
                    }
                    break;
                  
                  case 1 : 
                    S166201=1;
                    S166201=0;
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 77, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 77, column: 5
                      S166201=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S166196=0;
                      if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 77, column: 5
                        tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 77, column: 5
                        S166196=1;
                        if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 77, column: 5
                          tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 77, column: 5
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 77, column: 5
                          S166194=1;
                          if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 78, column: 21
                            m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 81, column: 5
                            S166380=2;
                            if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 87, column: 4
                              if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 88, column: 11
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 88, column: 5
                                S166380=3;
                                if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                                  S166425=0;
                                  if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                                    m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                                    placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                                    currsigs.addElement(placed_1);
                                    S166425=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                                    currsigs.addElement(loadPos1);
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  S166380=4;
                                  S166523=0;
                                  if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                    S166523=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S166518=0;
                                    if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                      startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                                      S166518=1;
                                      if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 116, column: 4
                                        S166380=5;
                                        S166897=0;
                                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                          S166897=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S166892=0;
                                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                            startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                                            S166892=1;
                                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                              S166380=6;
                                              S167315=0;
                                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                S167315=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S167310=0;
                                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  S167310=1;
                                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                                    S166380=7;
                                                    S167777=0;
                                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      S167777=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S167772=0;
                                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        S167772=1;
                                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                          S166380=8;
                                                          S168283=0;
                                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                            S168283=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S168278=0;
                                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                              S168278=1;
                                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                                S166380=9;
                                                                S168833=0;
                                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  S168833=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S168828=0;
                                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    S168828=1;
                                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                      S166380=10;
                                                                      S169427=0;
                                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        S169427=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S169422=0;
                                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          S169422=1;
                                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                            S166380=11;
                                                                            S170065=0;
                                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              S170065=1;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              S170060=0;
                                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                S170060=1;
                                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                  ends[2]=2;
                                                                                  ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                  S166380=12;
                                                                                  if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                                    S166380=13;
                                                                                    if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                                      m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                                      m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                                        twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                        currsigs.addElement(twin);
                                                                                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                        S166380=14;
                                                                                        active[2]=1;
                                                                                        ends[2]=1;
                                                                                        tdone[2]=1;
                                                                                      }
                                                                                      else {
                                                                                        S166380=14;
                                                                                        active[2]=1;
                                                                                        ends[2]=1;
                                                                                        tdone[2]=1;
                                                                                      }
                                                                                    }
                                                                                    else {
                                                                                      active[2]=1;
                                                                                      ends[2]=1;
                                                                                      tdone[2]=1;
                                                                                    }
                                                                                  }
                                                                                  else {
                                                                                    rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                                    currsigs.addElement(rotaryTrigger);
                                                                                    active[2]=1;
                                                                                    ends[2]=1;
                                                                                    tdone[2]=1;
                                                                                  }
                                                                                }
                                                                                else {
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                              }
                                                                              else {
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                            }
                                                                          }
                                                                          else {
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                        }
                                                                        else {
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                      }
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                }
                              }
                            }
                            else {
                              S166380=3;
                              if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                                S166425=0;
                                if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                                  m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                                  placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                                  currsigs.addElement(placed_1);
                                  S166425=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                                  currsigs.addElement(loadPos1);
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                S166380=4;
                                S166523=0;
                                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                  S166523=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S166518=0;
                                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                                    S166518=1;
                                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 116, column: 4
                                      S166380=5;
                                      S166897=0;
                                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                        S166897=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S166892=0;
                                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                                          S166892=1;
                                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                            S166380=6;
                                            S167315=0;
                                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                              S167315=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S167310=0;
                                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                                S167310=1;
                                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  S166380=7;
                                                  S167777=0;
                                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    S167777=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S167772=0;
                                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      S167772=1;
                                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        S166380=8;
                                                        S168283=0;
                                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                          S168283=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S168278=0;
                                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                            S168278=1;
                                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                              S166380=9;
                                                              S168833=0;
                                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                S168833=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S168828=0;
                                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  S168828=1;
                                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    S166380=10;
                                                                    S169427=0;
                                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      S169427=1;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      S169422=0;
                                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        S169422=1;
                                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          ends[2]=2;
                                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          S166380=11;
                                                                          S170065=0;
                                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            S170065=1;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S170060=0;
                                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              S170060=1;
                                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                ends[2]=2;
                                                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                S166380=12;
                                                                                if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                                  S166380=13;
                                                                                  if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                                    m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                                    m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                                    step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                                    t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                                    t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                                    if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                                      twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                      currsigs.addElement(twin);
                                                                                      twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                      S166380=14;
                                                                                      active[2]=1;
                                                                                      ends[2]=1;
                                                                                      tdone[2]=1;
                                                                                    }
                                                                                    else {
                                                                                      S166380=14;
                                                                                      active[2]=1;
                                                                                      ends[2]=1;
                                                                                      tdone[2]=1;
                                                                                    }
                                                                                  }
                                                                                  else {
                                                                                    active[2]=1;
                                                                                    ends[2]=1;
                                                                                    tdone[2]=1;
                                                                                  }
                                                                                }
                                                                                else {
                                                                                  rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                                  currsigs.addElement(rotaryTrigger);
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                              }
                                                                              else {
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                            }
                                                                            else {
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                          }
                                                                        }
                                                                        else {
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                      }
                                                                      else {
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                                else {
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                              }
                            }
                          }
                          else {
                            unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 79, column: 6
                            currsigs.addElement(unloadExit);
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    break;
                  
                }
                break;
              
              case 1 : 
                if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 78, column: 21
                  m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 81, column: 5
                  S166380=2;
                  if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 87, column: 4
                    if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 88, column: 11
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 88, column: 5
                      S166380=3;
                      if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                        S166425=0;
                        if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                          m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                          placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                          currsigs.addElement(placed_1);
                          S166425=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                          currsigs.addElement(loadPos1);
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        S166380=4;
                        S166523=0;
                        if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                          S166523=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S166518=0;
                          if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                            startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                            S166518=1;
                            if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 116, column: 4
                              S166380=5;
                              S166897=0;
                              if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                S166897=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S166892=0;
                                if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                  startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                                  S166892=1;
                                  if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                    S166380=6;
                                    S167315=0;
                                    if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S167315=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S167310=0;
                                      if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                        startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                        S167310=1;
                                        if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                          S166380=7;
                                          S167777=0;
                                          if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S167777=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S167772=0;
                                            if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                              startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                              S167772=1;
                                              if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                S166380=8;
                                                S168283=0;
                                                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  S168283=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S168278=0;
                                                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                    S168278=1;
                                                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                      S166380=9;
                                                      S168833=0;
                                                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S168833=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S168828=0;
                                                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          S168828=1;
                                                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            S166380=10;
                                                            S169427=0;
                                                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S169427=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S169422=0;
                                                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                S169422=1;
                                                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  S166380=11;
                                                                  S170065=0;
                                                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S170065=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S170060=0;
                                                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      S170060=1;
                                                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        S166380=12;
                                                                        if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                          S166380=13;
                                                                          if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                            m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                            m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                            step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                            t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                            t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                            if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                              twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                              currsigs.addElement(twin);
                                                                              twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                              S166380=14;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              S166380=14;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                          }
                                                                          else {
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                        }
                                                                        else {
                                                                          rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                          currsigs.addElement(rotaryTrigger);
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                      }
                                                                      else {
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                }
                                                                else {
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    S166380=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                      S166425=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                        currsigs.addElement(placed_1);
                        S166425=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S166380=4;
                      S166523=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                        S166523=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S166518=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                          S166518=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 116, column: 4
                            S166380=5;
                            S166897=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                              S166897=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S166892=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                                S166892=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                  S166380=6;
                                  S167315=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                    S167315=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S167310=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S167310=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                        S166380=7;
                                        S167777=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                          S167777=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S167772=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S167772=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                              S166380=8;
                                              S168283=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                S168283=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S168278=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  S168278=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                    S166380=9;
                                                    S168833=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S168833=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S168828=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S168828=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          S166380=10;
                                                          S169427=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S169427=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S169422=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S169422=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                S166380=11;
                                                                S170065=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  S170065=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S170060=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S170060=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      S166380=12;
                                                                      if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                        S166380=13;
                                                                        if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                          m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                          m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                          step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                          t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                          t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                          if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                            twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                            currsigs.addElement(twin);
                                                                            twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                            S166380=14;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S166380=14;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                        }
                                                                        else {
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                      }
                                                                      else {
                                                                        rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                        currsigs.addElement(rotaryTrigger);
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                  }
                }
                else {
                  unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 79, column: 6
                  currsigs.addElement(unloadExit);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
          case 2 : 
            if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 88, column: 11
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              ends[2]=2;
              ;//sysj\rotaryTableController.sysj line: 88, column: 5
              S166380=3;
              if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                S166425=0;
                if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                  m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                  placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                  currsigs.addElement(placed_1);
                  S166425=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                  currsigs.addElement(loadPos1);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
              else {
                S166380=4;
                S166523=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                  S166523=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S166518=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                    S166518=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 116, column: 4
                      S166380=5;
                      S166897=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                        S166897=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S166892=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                          S166892=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 117, column: 4
                            S166380=6;
                            S167315=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                              S167315=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S167310=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                S167310=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S166380=7;
                                  S167777=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S167777=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S167772=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S167772=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S166380=8;
                                        S168283=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                          S168283=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S168278=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                            S168278=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                              S166380=9;
                                              S168833=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S168833=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S168828=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S168828=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S166380=10;
                                                    S169427=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S169427=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S169422=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S169422=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S166380=11;
                                                          S170065=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S170065=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S170060=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S170060=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S166380=12;
                                                                if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                  S166380=13;
                                                                  if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                    m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                    m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                    step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                    t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                    t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                    if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                      twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                      currsigs.addElement(twin);
                                                                      twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                      S166380=14;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      S166380=14;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                                else {
                                                                  rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                  currsigs.addElement(rotaryTrigger);
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                    else {
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
              }
            }
            break;
          
          case 3 : 
            switch(S166425){
              case 0 : 
                if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                  m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                  placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                  currsigs.addElement(placed_1);
                  S166425=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                  currsigs.addElement(loadPos1);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S166425=1;
                S166380=4;
                S166523=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                  S166523=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S166518=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                    S166518=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 116, column: 4
                      S166380=5;
                      S166897=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                        S166897=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S166892=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                          S166892=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 117, column: 4
                            S166380=6;
                            S167315=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                              S167315=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S167310=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                S167310=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S166380=7;
                                  S167777=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S167777=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S167772=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S167772=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S166380=8;
                                        S168283=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                          S168283=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S168278=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                            S168278=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                              S166380=9;
                                              S168833=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S168833=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S168828=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S168828=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S166380=10;
                                                    S169427=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S169427=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S169422=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S169422=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S166380=11;
                                                          S170065=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S170065=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S170060=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S170060=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S166380=12;
                                                                if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                  S166380=13;
                                                                  if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                    m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                    m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                    step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                    t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                    t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                    if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                      twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                      currsigs.addElement(twin);
                                                                      twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                      S166380=14;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      S166380=14;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                                else {
                                                                  rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                  currsigs.addElement(rotaryTrigger);
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                    else {
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 4 : 
            switch(S166523){
              case 0 : 
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                  S166523=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S166518){
                    case 0 : 
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                        S166518=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 116, column: 4
                          S166380=5;
                          S166897=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                            S166897=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S166892=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                              S166892=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                S166380=6;
                                S167315=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S167315=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S167310=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                    S167310=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S166380=7;
                                      S167777=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S167777=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S167772=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                          S167772=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S166380=8;
                                            S168283=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                              S168283=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S168278=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                S168278=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  S166380=9;
                                                  S168833=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S168833=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S168828=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S168828=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S166380=10;
                                                        S169427=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S169427=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S169422=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S169422=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S166380=11;
                                                              S170065=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S170065=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S170060=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  S170060=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S166380=12;
                                                                    if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                      S166380=13;
                                                                      if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                        m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                        m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                        step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                        t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                        t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                        if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                          twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                          currsigs.addElement(twin);
                                                                          twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                          S166380=14;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S166380=14;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                      }
                                                                      else {
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                    else {
                                                                      rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                      currsigs.addElement(rotaryTrigger);
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                                else {
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 116, column: 4
                        S166380=5;
                        S166897=0;
                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                          S166897=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S166892=0;
                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                            S166892=1;
                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 117, column: 4
                              S166380=6;
                              S167315=0;
                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                S167315=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S167310=0;
                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S167310=1;
                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                    S166380=7;
                                    S167777=0;
                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S167777=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S167772=0;
                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S167772=1;
                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                          S166380=8;
                                          S168283=0;
                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                            S168283=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S168278=0;
                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                              S168278=1;
                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                S166380=9;
                                                S168833=0;
                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S168833=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S168828=0;
                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S168828=1;
                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S166380=10;
                                                      S169427=0;
                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S169427=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S169422=0;
                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S169422=1;
                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S166380=11;
                                                            S170065=0;
                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S170065=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S170060=0;
                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S170060=1;
                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  S166380=12;
                                                                  if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                    S166380=13;
                                                                    if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                      m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                      m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                        twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                        currsigs.addElement(twin);
                                                                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                        S166380=14;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S166380=14;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                    currsigs.addElement(rotaryTrigger);
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                                else {
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S166523=1;
                S166523=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                  S166523=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S166518=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                    S166518=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 116, column: 4
                      S166380=5;
                      S166897=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                        S166897=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S166892=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                          S166892=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 117, column: 4
                            S166380=6;
                            S167315=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                              S167315=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S167310=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                S167310=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S166380=7;
                                  S167777=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S167777=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S167772=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S167772=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S166380=8;
                                        S168283=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                          S168283=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S168278=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                            S168278=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                              S166380=9;
                                              S168833=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S168833=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S168828=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S168828=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S166380=10;
                                                    S169427=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S169427=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S169422=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S169422=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S166380=11;
                                                          S170065=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S170065=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S170060=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S170060=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S166380=12;
                                                                if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                  S166380=13;
                                                                  if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                    m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                    m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                    step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                    t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                    t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                    if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                      twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                      currsigs.addElement(twin);
                                                                      twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                      S166380=14;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      S166380=14;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                                else {
                                                                  rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                  currsigs.addElement(rotaryTrigger);
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                    else {
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 5 : 
            switch(S166897){
              case 0 : 
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                  S166897=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S166892){
                    case 0 : 
                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                        S166892=1;
                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                          S166380=6;
                          S167315=0;
                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            S167315=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S167310=0;
                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                              S167310=1;
                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                S166380=7;
                                S167777=0;
                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S167777=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S167772=0;
                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S167772=1;
                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S166380=8;
                                      S168283=0;
                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                        S168283=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S168278=0;
                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                          S168278=1;
                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                            S166380=9;
                                            S168833=0;
                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S168833=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S168828=0;
                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S168828=1;
                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S166380=10;
                                                  S169427=0;
                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S169427=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S169422=0;
                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S169422=1;
                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S166380=11;
                                                        S170065=0;
                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S170065=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S170060=0;
                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S170060=1;
                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S166380=12;
                                                              if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                S166380=13;
                                                                if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                  m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                  m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                  step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                  t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                  t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                  if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                    twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                    currsigs.addElement(twin);
                                                                    twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                    S166380=14;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S166380=14;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                                else {
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                              else {
                                                                rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                currsigs.addElement(rotaryTrigger);
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 117, column: 4
                        S166380=6;
                        S167315=0;
                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                          S167315=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S167310=0;
                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                            S167310=1;
                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 118, column: 4
                              S166380=7;
                              S167777=0;
                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                S167777=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S167772=0;
                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S167772=1;
                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S166380=8;
                                    S168283=0;
                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                      S168283=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S168278=0;
                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                        S168278=1;
                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                          S166380=9;
                                          S168833=0;
                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S168833=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S168828=0;
                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S168828=1;
                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S166380=10;
                                                S169427=0;
                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S169427=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S169422=0;
                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S169422=1;
                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S166380=11;
                                                      S170065=0;
                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S170065=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S170060=0;
                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S170060=1;
                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S166380=12;
                                                            if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                              S166380=13;
                                                              if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                  twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                  currsigs.addElement(twin);
                                                                  twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                  S166380=14;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S166380=14;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                              currsigs.addElement(rotaryTrigger);
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S166897=1;
                S166897=0;
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                  S166897=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S166892=0;
                  if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                    startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                    S166892=1;
                    if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 117, column: 4
                      S166380=6;
                      S167315=0;
                      if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                        S167315=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S167310=0;
                        if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                          S167310=1;
                          if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 118, column: 4
                            S166380=7;
                            S167777=0;
                            if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                              S167777=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S167772=0;
                              if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                S167772=1;
                                if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S166380=8;
                                  S168283=0;
                                  if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                    S168283=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S168278=0;
                                    if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                      doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                      S168278=1;
                                      if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                        S166380=9;
                                        S168833=0;
                                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S168833=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S168828=0;
                                          if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S168828=1;
                                            if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S166380=10;
                                              S169427=0;
                                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S169427=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S169422=0;
                                                if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S169422=1;
                                                  if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S166380=11;
                                                    S170065=0;
                                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S170065=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S170060=0;
                                                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S170060=1;
                                                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S166380=12;
                                                          if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                            S166380=13;
                                                            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                              m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                              m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                              step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                              t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                              t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                              if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                currsigs.addElement(twin);
                                                                twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                S166380=14;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S166380=14;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                          else {
                                                            rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                            currsigs.addElement(rotaryTrigger);
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                    else {
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 6 : 
            switch(S167315){
              case 0 : 
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                  S167315=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S167310){
                    case 0 : 
                      if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                        S167310=1;
                        if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 118, column: 4
                          S166380=7;
                          S167777=0;
                          if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                            S167777=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S167772=0;
                            if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                              S167772=1;
                              if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                S166380=8;
                                S168283=0;
                                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                  S168283=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S168278=0;
                                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                    S168278=1;
                                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                      S166380=9;
                                      S168833=0;
                                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S168833=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S168828=0;
                                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S168828=1;
                                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S166380=10;
                                            S169427=0;
                                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S169427=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S169422=0;
                                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S169422=1;
                                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S166380=11;
                                                  S170065=0;
                                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    S170065=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S170060=0;
                                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S170060=1;
                                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S166380=12;
                                                        if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                          S166380=13;
                                                          if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                            m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                            m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                            step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                            t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                            t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                            if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                              twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                              currsigs.addElement(twin);
                                                              twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                              S166380=14;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S166380=14;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                        else {
                                                          rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                          currsigs.addElement(rotaryTrigger);
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 118, column: 4
                        S166380=7;
                        S167777=0;
                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                          S167777=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S167772=0;
                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                            S167772=1;
                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 119, column: 4
                              S166380=8;
                              S168283=0;
                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                S168283=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S168278=0;
                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                  S168278=1;
                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                    S166380=9;
                                    S168833=0;
                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S168833=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S168828=0;
                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S168828=1;
                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S166380=10;
                                          S169427=0;
                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S169427=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S169422=0;
                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S169422=1;
                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S166380=11;
                                                S170065=0;
                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  S170065=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S170060=0;
                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    S170060=1;
                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S166380=12;
                                                      if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                        S166380=13;
                                                        if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                          m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                          m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                          step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                          t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                          t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                          if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                            twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                            currsigs.addElement(twin);
                                                            twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                            S166380=14;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S166380=14;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                      else {
                                                        rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                        currsigs.addElement(rotaryTrigger);
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S167315=1;
                S167315=0;
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                  S167315=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S167310=0;
                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                    S167310=1;
                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 118, column: 4
                      S166380=7;
                      S167777=0;
                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                        S167777=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S167772=0;
                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                          S167772=1;
                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 119, column: 4
                            S166380=8;
                            S168283=0;
                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                              S168283=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S168278=0;
                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                S168278=1;
                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                  S166380=9;
                                  S168833=0;
                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S168833=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S168828=0;
                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S168828=1;
                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S166380=10;
                                        S169427=0;
                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S169427=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S169422=0;
                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S169422=1;
                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S166380=11;
                                              S170065=0;
                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                S170065=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S170060=0;
                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  S170060=1;
                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    S166380=12;
                                                    if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                      S166380=13;
                                                      if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                        m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                        m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                        step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                        t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                        t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                        if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                          twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                          currsigs.addElement(twin);
                                                          twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                          S166380=14;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S166380=14;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                    else {
                                                      rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                      currsigs.addElement(rotaryTrigger);
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                    else {
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 7 : 
            switch(S167777){
              case 0 : 
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                  S167777=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S167772){
                    case 0 : 
                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                        S167772=1;
                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 119, column: 4
                          S166380=8;
                          S168283=0;
                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                            S168283=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S168278=0;
                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                              S168278=1;
                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                S166380=9;
                                S168833=0;
                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S168833=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S168828=0;
                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S168828=1;
                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S166380=10;
                                      S169427=0;
                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S169427=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S169422=0;
                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S169422=1;
                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S166380=11;
                                            S170065=0;
                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                              S170065=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S170060=0;
                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                S170060=1;
                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  S166380=12;
                                                  if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                    S166380=13;
                                                    if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                      m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                      m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                        twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                        currsigs.addElement(twin);
                                                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                        S166380=14;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S166380=14;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                  else {
                                                    rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                    currsigs.addElement(rotaryTrigger);
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                        S166380=8;
                        S168283=0;
                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                          S168283=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S168278=0;
                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                            S168278=1;
                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 121, column: 4
                              S166380=9;
                              S168833=0;
                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                S168833=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S168828=0;
                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S168828=1;
                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S166380=10;
                                    S169427=0;
                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                      S169427=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S169422=0;
                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S169422=1;
                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S166380=11;
                                          S170065=0;
                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                            S170065=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S170060=0;
                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                              S170060=1;
                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                S166380=12;
                                                if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                  S166380=13;
                                                  if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                    m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                    m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                    step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                    t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                    t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                    if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                      twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                      currsigs.addElement(twin);
                                                      twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                      S166380=14;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S166380=14;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                  currsigs.addElement(rotaryTrigger);
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S167777=1;
                S167777=0;
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                  S167777=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S167772=0;
                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                    S167772=1;
                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                      S166380=8;
                      S168283=0;
                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                        S168283=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S168278=0;
                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                          S168278=1;
                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 121, column: 4
                            S166380=9;
                            S168833=0;
                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                              S168833=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S168828=0;
                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                S168828=1;
                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S166380=10;
                                  S169427=0;
                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S169427=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S169422=0;
                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                      S169422=1;
                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S166380=11;
                                        S170065=0;
                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                          S170065=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S170060=0;
                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                            S170060=1;
                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                              S166380=12;
                                              if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                S166380=13;
                                                if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                  m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                  m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                  step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                  t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                  t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                  if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                    twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                    currsigs.addElement(twin);
                                                    twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                    S166380=14;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S166380=14;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                              else {
                                                rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                currsigs.addElement(rotaryTrigger);
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                    else {
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 8 : 
            switch(S168283){
              case 0 : 
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                  S168283=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S168278){
                    case 0 : 
                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                        S168278=1;
                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 121, column: 4
                          S166380=9;
                          S168833=0;
                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                            S168833=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S168828=0;
                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                              S168828=1;
                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                S166380=10;
                                S169427=0;
                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                  S169427=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S169422=0;
                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S169422=1;
                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                      S166380=11;
                                      S170065=0;
                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                        S170065=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S170060=0;
                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                          S170060=1;
                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                            S166380=12;
                                            if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                              S166380=13;
                                              if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                  twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                  currsigs.addElement(twin);
                                                  twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                  S166380=14;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S166380=14;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                            else {
                                              rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                              currsigs.addElement(rotaryTrigger);
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 121, column: 4
                        S166380=9;
                        S168833=0;
                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                          S168833=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S168828=0;
                          if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                            doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                            S168828=1;
                            if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                              S166380=10;
                              S169427=0;
                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                S169427=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S169422=0;
                                if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                  doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                  S169422=1;
                                  if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S166380=11;
                                    S170065=0;
                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                      S170065=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S170060=0;
                                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                        S170060=1;
                                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                          S166380=12;
                                          if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                            S166380=13;
                                            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                              m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                              m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                              step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                              t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                              t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                              if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                currsigs.addElement(twin);
                                                twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                S166380=14;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S166380=14;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                            currsigs.addElement(rotaryTrigger);
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S168283=1;
                S168283=0;
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                  S168283=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S168278=0;
                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                    S168278=1;
                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 121, column: 4
                      S166380=9;
                      S168833=0;
                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                        S168833=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S168828=0;
                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                          S168828=1;
                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 122, column: 4
                            S166380=10;
                            S169427=0;
                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                              S169427=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S169422=0;
                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                S169422=1;
                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                  S166380=11;
                                  S170065=0;
                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                    S170065=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S170060=0;
                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                      S170060=1;
                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                        S166380=12;
                                        if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                          S166380=13;
                                          if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                            m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                            m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                            step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                            t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                            t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                            if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                              twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                              currsigs.addElement(twin);
                                              twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                              S166380=14;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S166380=14;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                        else {
                                          rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                          currsigs.addElement(rotaryTrigger);
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                    else {
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 9 : 
            switch(S168833){
              case 0 : 
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                  S168833=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S168828){
                    case 0 : 
                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                        S168828=1;
                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                          S166380=10;
                          S169427=0;
                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                            S169427=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S169422=0;
                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                              S169422=1;
                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                S166380=11;
                                S170065=0;
                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                  S170065=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S170060=0;
                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                    S170060=1;
                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                      S166380=12;
                                      if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                        S166380=13;
                                        if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                          m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                          m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                          step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                          t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                          t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                          if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                            twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                            currsigs.addElement(twin);
                                            twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                            S166380=14;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S166380=14;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                      else {
                                        rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                        currsigs.addElement(rotaryTrigger);
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                        S166380=10;
                        S169427=0;
                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                          S169427=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S169422=0;
                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                            S169422=1;
                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                              S166380=11;
                              S170065=0;
                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                S170065=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S170060=0;
                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                  S170060=1;
                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                    S166380=12;
                                    if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                      S166380=13;
                                      if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                        m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                        m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                        step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                        t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                        t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                        if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                          twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                          currsigs.addElement(twin);
                                          twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                          S166380=14;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S166380=14;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                      currsigs.addElement(rotaryTrigger);
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S168833=1;
                S168833=0;
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                  S168833=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S168828=0;
                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                    S168828=1;
                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                      S166380=10;
                      S169427=0;
                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                        S169427=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S169422=0;
                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                          S169422=1;
                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                            S166380=11;
                            S170065=0;
                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                              S170065=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S170060=0;
                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                S170060=1;
                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                  S166380=12;
                                  if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                    S166380=13;
                                    if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                      m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                      m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                        twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                        currsigs.addElement(twin);
                                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                        S166380=14;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S166380=14;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                    currsigs.addElement(rotaryTrigger);
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                    else {
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 10 : 
            switch(S169427){
              case 0 : 
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                  S169427=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S169422){
                    case 0 : 
                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                        S169422=1;
                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                          S166380=11;
                          S170065=0;
                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                            S170065=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S170060=0;
                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                              S170060=1;
                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                S166380=12;
                                if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                  S166380=13;
                                  if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                    m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                    m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                    step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                    t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                    t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                    if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                      twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                      currsigs.addElement(twin);
                                      twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                      S166380=14;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S166380=14;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                  currsigs.addElement(rotaryTrigger);
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                        S166380=11;
                        S170065=0;
                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                          S170065=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S170060=0;
                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                            S170060=1;
                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                              S166380=12;
                              if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                S166380=13;
                                if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                  m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                  m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                  step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                  t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                  t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                  if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                    twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                    currsigs.addElement(twin);
                                    twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                    S166380=14;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S166380=14;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                currsigs.addElement(rotaryTrigger);
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S169427=1;
                S169427=0;
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                  S169427=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S169422=0;
                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                    S169422=1;
                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                      S166380=11;
                      S170065=0;
                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                        S170065=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S170060=0;
                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                          S170060=1;
                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                            S166380=12;
                            if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                              S166380=13;
                              if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                  twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                  currsigs.addElement(twin);
                                  twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                  S166380=14;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S166380=14;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                              currsigs.addElement(rotaryTrigger);
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                    else {
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 11 : 
            switch(S170065){
              case 0 : 
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                  S170065=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S170060){
                    case 0 : 
                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                        S170060=1;
                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 124, column: 4
                          S166380=12;
                          if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                            S166380=13;
                            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                              m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                              m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                              step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                              t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                              t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                              if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                currsigs.addElement(twin);
                                twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                S166380=14;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S166380=14;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                            currsigs.addElement(rotaryTrigger);
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 124, column: 4
                        S166380=12;
                        if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                          S166380=13;
                          if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                            m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                            m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                            step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                            t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                            t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                            if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                              twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                              currsigs.addElement(twin);
                              twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                              S166380=14;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S166380=14;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                          currsigs.addElement(rotaryTrigger);
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S170065=1;
                S170065=0;
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                  S170065=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S170060=0;
                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                    S170060=1;
                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                      S166380=12;
                      if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                        S166380=13;
                        if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                          m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                          m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                          step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                          t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                          t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                          if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                            S166380=14;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S166380=14;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                        currsigs.addElement(rotaryTrigger);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 12 : 
            if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
              S166380=13;
              if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                  twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                  currsigs.addElement(twin);
                  twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                  S166380=14;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S166380=14;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
              else {
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
              currsigs.addElement(rotaryTrigger);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 13 : 
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
              m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
              m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
              step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
              t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
              t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
              if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                currsigs.addElement(twin);
                twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                S166380=14;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S166380=14;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 14 : 
            S166380=14;
            S166380=0;
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 66, column: 20
              S166380=1;
              if(m_thread_2.exitOccupied()){//sysj\rotaryTableController.sysj line: 74, column: 4
                exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj\rotaryTableController.sysj line: 75, column: 5
                m_thread_2.sayUnloading();//sysj\rotaryTableController.sysj line: 76, column: 5
                S166194=0;
                S166201=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 77, column: 5
                  tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 77, column: 5
                  S166201=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S166196=0;
                  if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 77, column: 5
                    tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 77, column: 5
                    S166196=1;
                    if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 77, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 77, column: 5
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 77, column: 5
                      S166194=1;
                      if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 78, column: 21
                        m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 81, column: 5
                        S166380=2;
                        if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 87, column: 4
                          if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 88, column: 11
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 88, column: 5
                            S166380=3;
                            if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                              S166425=0;
                              if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                                m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                                placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                                currsigs.addElement(placed_1);
                                S166425=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                                currsigs.addElement(loadPos1);
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              S166380=4;
                              S166523=0;
                              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                S166523=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S166518=0;
                                if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                  startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                                  S166518=1;
                                  if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 116, column: 4
                                    S166380=5;
                                    S166897=0;
                                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                      S166897=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S166892=0;
                                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                                        S166892=1;
                                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                          S166380=6;
                                          S167315=0;
                                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                            S167315=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S167310=0;
                                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                              S167310=1;
                                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                                S166380=7;
                                                S167777=0;
                                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  S167777=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S167772=0;
                                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    S167772=1;
                                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      S166380=8;
                                                      S168283=0;
                                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                        S168283=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S168278=0;
                                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                          S168278=1;
                                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                            S166380=9;
                                                            S168833=0;
                                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              S168833=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S168828=0;
                                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                S168828=1;
                                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  S166380=10;
                                                                  S169427=0;
                                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    S169427=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S169422=0;
                                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      S169422=1;
                                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        S166380=11;
                                                                        S170065=0;
                                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          S170065=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S170060=0;
                                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            S170060=1;
                                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              S166380=12;
                                                                              if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                                S166380=13;
                                                                                if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                                  m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                                  m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                                  step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                                  t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                                  t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                                  if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                                    twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                    currsigs.addElement(twin);
                                                                                    twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                    S166380=14;
                                                                                    active[2]=1;
                                                                                    ends[2]=1;
                                                                                    tdone[2]=1;
                                                                                  }
                                                                                  else {
                                                                                    S166380=14;
                                                                                    active[2]=1;
                                                                                    ends[2]=1;
                                                                                    tdone[2]=1;
                                                                                  }
                                                                                }
                                                                                else {
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                              }
                                                                              else {
                                                                                rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                                currsigs.addElement(rotaryTrigger);
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                            }
                                                                            else {
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                          }
                                                                          else {
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                        }
                                                                      }
                                                                      else {
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                }
                                                                else {
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                            }
                          }
                        }
                        else {
                          S166380=3;
                          if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                            S166425=0;
                            if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                              m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                              placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                              currsigs.addElement(placed_1);
                              S166425=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                              currsigs.addElement(loadPos1);
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            S166380=4;
                            S166523=0;
                            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                              S166523=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S166518=0;
                              if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                                S166518=1;
                                if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 116, column: 4
                                  S166380=5;
                                  S166897=0;
                                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                    S166897=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S166892=0;
                                    if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                      startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                                      S166892=1;
                                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                        S166380=6;
                                        S167315=0;
                                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                          S167315=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S167310=0;
                                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                            S167310=1;
                                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                              S166380=7;
                                              S167777=0;
                                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                S167777=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S167772=0;
                                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  S167772=1;
                                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    S166380=8;
                                                    S168283=0;
                                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                      S168283=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S168278=0;
                                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                        S168278=1;
                                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                          S166380=9;
                                                          S168833=0;
                                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            S168833=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S168828=0;
                                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              S168828=1;
                                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                S166380=10;
                                                                S169427=0;
                                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  S169427=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S169422=0;
                                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    S169422=1;
                                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      S166380=11;
                                                                      S170065=0;
                                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        S170065=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S170060=0;
                                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          S170060=1;
                                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            S166380=12;
                                                                            if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                              S166380=13;
                                                                              if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                                m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                                m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                                step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                                t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                                t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                                if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                                  twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                  currsigs.addElement(twin);
                                                                                  twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                                  S166380=14;
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                                else {
                                                                                  S166380=14;
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                              }
                                                                              else {
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                            }
                                                                            else {
                                                                              rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                              currsigs.addElement(rotaryTrigger);
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                          }
                                                                          else {
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                        }
                                                                        else {
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                      }
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                          }
                        }
                      }
                      else {
                        unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 79, column: 6
                        currsigs.addElement(unloadExit);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
              }
              else {
                S166380=2;
                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 87, column: 4
                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 88, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 88, column: 5
                    S166380=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                      S166425=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                        currsigs.addElement(placed_1);
                        S166425=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S166380=4;
                      S166523=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                        S166523=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S166518=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                          S166518=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 116, column: 4
                            S166380=5;
                            S166897=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                              S166897=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S166892=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                                S166892=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                  S166380=6;
                                  S167315=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                    S167315=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S167310=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S167310=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                        S166380=7;
                                        S167777=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                          S167777=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S167772=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S167772=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                              S166380=8;
                                              S168283=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                S168283=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S168278=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  S168278=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                    S166380=9;
                                                    S168833=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S168833=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S168828=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S168828=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          S166380=10;
                                                          S169427=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S169427=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S169422=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S169422=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                S166380=11;
                                                                S170065=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  S170065=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S170060=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S170060=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      S166380=12;
                                                                      if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                        S166380=13;
                                                                        if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                          m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                          m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                          step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                          t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                          t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                          if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                            twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                            currsigs.addElement(twin);
                                                                            twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                            S166380=14;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S166380=14;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                        }
                                                                        else {
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                      }
                                                                      else {
                                                                        rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                        currsigs.addElement(rotaryTrigger);
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                  }
                }
                else {
                  S166380=3;
                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                    S166425=0;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                      currsigs.addElement(placed_1);
                      S166425=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S166380=4;
                    S166523=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                      S166523=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S166518=0;
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                        S166518=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 116, column: 4
                          S166380=5;
                          S166897=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                            S166897=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S166892=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                              S166892=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                S166380=6;
                                S167315=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S167315=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S167310=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                    S167310=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S166380=7;
                                      S167777=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S167777=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S167772=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                          S167772=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S166380=8;
                                            S168283=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                              S168283=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S168278=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                S168278=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  S166380=9;
                                                  S168833=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S168833=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S168828=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S168828=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S166380=10;
                                                        S169427=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S169427=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S169422=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S169422=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S166380=11;
                                                              S170065=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S170065=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S170060=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  S170060=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S166380=12;
                                                                    if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                      S166380=13;
                                                                      if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                        m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                        m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                        step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                        t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                        t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                        if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                          twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                          currsigs.addElement(twin);
                                                                          twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                          S166380=14;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S166380=14;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                      }
                                                                      else {
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                    else {
                                                                      rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                      currsigs.addElement(rotaryTrigger);
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                                else {
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                }
              }
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread194856(int [] tdone, int [] ends){
        S194851=1;
    m_thread_3 = TableModel.shared();//sysj\rotaryTableController.sysj line: 148, column: 3
    w_thread_3 = null;//sysj\rotaryTableController.sysj line: 149, column: 3
    S194711=0;
    S194695=0;
    if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 151, column: 4
      tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 151, column: 4
      S194695=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S194690=0;
      if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 151, column: 4
        tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 151, column: 4
        S194690=1;
        if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 151, column: 4
          tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 151, column: 4
          ends[3]=2;
          ;//sysj\rotaryTableController.sysj line: 151, column: 4
          w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 152, column: 4
          m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 153, column: 4
          System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 154, column: 4
          S194711=1;
          if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 155, column: 20
            S194711=2;
            active[3]=1;
            ends[3]=1;
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
      else {
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
    }
  }

  public void thread194855(int [] tdone, int [] ends){
        S194687=1;
    t_thread_2 = new RotaryTableTwin();//sysj\rotaryTableController.sysj line: 59, column: 3
    step_thread_2 = 0;//sysj\rotaryTableController.sysj line: 60, column: 3
    m_thread_2 = TableModel.shared();//sysj\rotaryTableController.sysj line: 61, column: 3
    exiting_thread_2 = null;//sysj\rotaryTableController.sysj line: 62, column: 3
    S166380=0;
    if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 66, column: 20
      S166380=1;
      if(m_thread_2.exitOccupied()){//sysj\rotaryTableController.sysj line: 74, column: 4
        exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj\rotaryTableController.sysj line: 75, column: 5
        m_thread_2.sayUnloading();//sysj\rotaryTableController.sysj line: 76, column: 5
        S166194=0;
        S166201=0;
        if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 77, column: 5
          tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 77, column: 5
          S166201=1;
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          S166196=0;
          if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 77, column: 5
            tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 77, column: 5
            S166196=1;
            if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 77, column: 5
              tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 77, column: 5
              ends[2]=2;
              ;//sysj\rotaryTableController.sysj line: 77, column: 5
              S166194=1;
              if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 78, column: 21
                m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 81, column: 5
                S166380=2;
                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 87, column: 4
                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 88, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 88, column: 5
                    S166380=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                      S166425=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                        currsigs.addElement(placed_1);
                        S166425=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S166380=4;
                      S166523=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                        S166523=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S166518=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                          S166518=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 116, column: 4
                            S166380=5;
                            S166897=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                              S166897=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S166892=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                                S166892=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                  S166380=6;
                                  S167315=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                    S167315=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S167310=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S167310=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                        S166380=7;
                                        S167777=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                          S167777=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S167772=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S167772=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                              S166380=8;
                                              S168283=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                S168283=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S168278=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  S168278=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                    S166380=9;
                                                    S168833=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S168833=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S168828=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S168828=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          S166380=10;
                                                          S169427=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S169427=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S169422=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S169422=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                S166380=11;
                                                                S170065=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  S170065=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S170060=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S170060=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      S166380=12;
                                                                      if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                        S166380=13;
                                                                        if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                          m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                          m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                          step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                          t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                          t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                          if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                            twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                            currsigs.addElement(twin);
                                                                            twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                            S166380=14;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S166380=14;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                        }
                                                                        else {
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                      }
                                                                      else {
                                                                        rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                        currsigs.addElement(rotaryTrigger);
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                    }
                  }
                }
                else {
                  S166380=3;
                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
                    S166425=0;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                      currsigs.addElement(placed_1);
                      S166425=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S166380=4;
                    S166523=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                      S166523=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S166518=0;
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                        S166518=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 116, column: 4
                          S166380=5;
                          S166897=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                            S166897=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S166892=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                              S166892=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                S166380=6;
                                S167315=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S167315=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S167310=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                                    S167310=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S166380=7;
                                      S167777=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S167777=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S167772=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                          S167772=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S166380=8;
                                            S168283=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                              S168283=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S168278=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                S168278=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  S166380=9;
                                                  S168833=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S168833=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S168828=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S168828=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S166380=10;
                                                        S169427=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S169427=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S169422=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S169422=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S166380=11;
                                                              S170065=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S170065=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S170060=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  S170060=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S166380=12;
                                                                    if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                      S166380=13;
                                                                      if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                        m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                        m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                        step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                        t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                        t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                        if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                          twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                          currsigs.addElement(twin);
                                                                          twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                          S166380=14;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S166380=14;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                      }
                                                                      else {
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                    }
                                                                    else {
                                                                      rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                      currsigs.addElement(rotaryTrigger);
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                                else {
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                }
              }
              else {
                unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 79, column: 6
                currsigs.addElement(unloadExit);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
          }
          else {
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
        }
      }
      else {
        S166380=2;
        if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 87, column: 4
          if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 88, column: 11
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            ends[2]=2;
            ;//sysj\rotaryTableController.sysj line: 88, column: 5
            S166380=3;
            if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
              S166425=0;
              if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
                m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
                placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
                currsigs.addElement(placed_1);
                S166425=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
                currsigs.addElement(loadPos1);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              S166380=4;
              S166523=0;
              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
                startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                S166523=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S166518=0;
                if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                  startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                  S166518=1;
                  if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 116, column: 4
                    S166380=5;
                    S166897=0;
                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                      S166897=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S166892=0;
                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                        S166892=1;
                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                          S166380=6;
                          S167315=0;
                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            S167315=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S167310=0;
                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                              S167310=1;
                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                S166380=7;
                                S167777=0;
                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S167777=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S167772=0;
                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S167772=1;
                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S166380=8;
                                      S168283=0;
                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                        S168283=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S168278=0;
                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                          S168278=1;
                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                            S166380=9;
                                            S168833=0;
                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S168833=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S168828=0;
                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S168828=1;
                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S166380=10;
                                                  S169427=0;
                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S169427=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S169422=0;
                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S169422=1;
                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S166380=11;
                                                        S170065=0;
                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S170065=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S170060=0;
                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S170060=1;
                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S166380=12;
                                                              if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                                S166380=13;
                                                                if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                  m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                  m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                  step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                  t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                  t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                  if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                    twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                    currsigs.addElement(twin);
                                                                    twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                    S166380=14;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S166380=14;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                }
                                                                else {
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                              else {
                                                                rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                                currsigs.addElement(rotaryTrigger);
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                        }
                        else {
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
            }
          }
        }
        else {
          S166380=3;
          if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 90, column: 4
            S166425=0;
            if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 91, column: 21
              m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 94, column: 5
              placed_1.setPresent();//sysj\rotaryTableController.sysj line: 95, column: 5
              currsigs.addElement(placed_1);
              S166425=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 92, column: 6
              currsigs.addElement(loadPos1);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
          }
          else {
            S166380=4;
            S166523=0;
            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 116, column: 4
              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
              S166523=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              S166518=0;
              if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 116, column: 4
                S166518=1;
                if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 116, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 116, column: 4
                  ends[2]=2;
                  ;//sysj\rotaryTableController.sysj line: 116, column: 4
                  S166380=5;
                  S166897=0;
                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                    S166897=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S166892=0;
                    if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                      startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 117, column: 4
                      S166892=1;
                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 117, column: 4
                        S166380=6;
                        S167315=0;
                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                          S167315=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S167310=0;
                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 118, column: 4
                            S167310=1;
                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 118, column: 4
                              S166380=7;
                              S167777=0;
                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                S167777=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S167772=0;
                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S167772=1;
                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S166380=8;
                                    S168283=0;
                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                      S168283=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S168278=0;
                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 121, column: 4
                                        S168278=1;
                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                          S166380=9;
                                          S168833=0;
                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S168833=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S168828=0;
                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S168828=1;
                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S166380=10;
                                                S169427=0;
                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S169427=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S169422=0;
                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S169422=1;
                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S166380=11;
                                                      S170065=0;
                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S170065=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S170060=0;
                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S170060=1;
                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S166380=12;
                                                            if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 130, column: 20
                                                              S166380=13;
                                                              if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 20
                                                                m_thread_2.index();//sysj\rotaryTableController.sysj line: 135, column: 4
                                                                m_thread_2.report();//sysj\rotaryTableController.sysj line: 136, column: 4
                                                                step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 137, column: 4
                                                                t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 138, column: 4
                                                                t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 139, column: 4
                                                                if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 140, column: 4
                                                                  twin.setPresent();//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                  currsigs.addElement(twin);
                                                                  twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 141, column: 5
                                                                  S166380=14;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S166380=14;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                            }
                                                            else {
                                                              rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 131, column: 5
                                                              currsigs.addElement(rotaryTrigger);
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                      }
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                }
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                          }
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                        }
                      }
                      else {
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                }
                else {
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
              else {
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
          }
        }
      }
    }
    else {
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
      switch(S194853){
        case 0 : 
          S194853=0;
          break RUN;
        
        case 1 : 
          S194853=2;
          S194853=2;
          placed_1.setClear();//sysj\rotaryTableController.sysj line: 56, column: 2
          thread194855(tdone,ends);
          thread194856(tdone,ends);
          int biggest194857 = 0;
          if(ends[2]>=biggest194857){
            biggest194857=ends[2];
          }
          if(ends[3]>=biggest194857){
            biggest194857=ends[3];
          }
          if(biggest194857 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          placed_1.setClear();//sysj\rotaryTableController.sysj line: 56, column: 2
          thread194858(tdone,ends);
          thread194859(tdone,ends);
          int biggest194860 = 0;
          if(ends[2]>=biggest194860){
            biggest194860=ends[2];
          }
          if(ends[3]>=biggest194860){
            biggest194860=ends[3];
          }
          if(biggest194860 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest194860 == 0){
            S194853=0;
            active[1]=0;
            ends[1]=0;
            S194853=0;
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
    placed_1 = new Signal();
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
          tableInfeed_in.gethook();
          doneFiller1_in.gethook();
          doneFiller2_in.gethook();
          doneLid_in.gethook();
          doneCapper_in.gethook();
          tableOutfeed_o.gethook();
          startFiller1_o.gethook();
          startFiller2_o.gethook();
          startLid_o.gethook();
          startCapper_o.gethook();
          tableAligned.gethook();
          bottleAtPos1.gethook();
          bottleAtPos2.gethook();
          bottleAtPos4.gethook();
          bottleAtPos5.gethook();
          exitCleared.gethook();
          df = true;
        }
        runClockDomain();
      }
      tableAligned.setpreclear();
      bottleAtPos1.setpreclear();
      bottleAtPos2.setpreclear();
      bottleAtPos4.setpreclear();
      bottleAtPos5.setpreclear();
      exitCleared.setpreclear();
      twin.setpreclear();
      rotaryTrigger.setpreclear();
      loadPos1.setpreclear();
      unloadExit.setpreclear();
      placed_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = tableAligned.getStatus() ? tableAligned.setprepresent() : tableAligned.setpreclear();
      tableAligned.setpreval(tableAligned.getValue());
      tableAligned.setClear();
      dummyint = bottleAtPos1.getStatus() ? bottleAtPos1.setprepresent() : bottleAtPos1.setpreclear();
      bottleAtPos1.setpreval(bottleAtPos1.getValue());
      bottleAtPos1.setClear();
      dummyint = bottleAtPos2.getStatus() ? bottleAtPos2.setprepresent() : bottleAtPos2.setpreclear();
      bottleAtPos2.setpreval(bottleAtPos2.getValue());
      bottleAtPos2.setClear();
      dummyint = bottleAtPos4.getStatus() ? bottleAtPos4.setprepresent() : bottleAtPos4.setpreclear();
      bottleAtPos4.setpreval(bottleAtPos4.getValue());
      bottleAtPos4.setClear();
      dummyint = bottleAtPos5.getStatus() ? bottleAtPos5.setprepresent() : bottleAtPos5.setpreclear();
      bottleAtPos5.setpreval(bottleAtPos5.getValue());
      bottleAtPos5.setClear();
      dummyint = exitCleared.getStatus() ? exitCleared.setprepresent() : exitCleared.setpreclear();
      exitCleared.setpreval(exitCleared.getValue());
      exitCleared.setClear();
      twin.sethook();
      twin.setClear();
      rotaryTrigger.sethook();
      rotaryTrigger.setClear();
      loadPos1.sethook();
      loadPos1.setClear();
      unloadExit.sethook();
      unloadExit.setClear();
      placed_1.setClear();
      tableInfeed_in.sethook();
      doneFiller1_in.sethook();
      doneFiller2_in.sethook();
      doneLid_in.sethook();
      doneCapper_in.sethook();
      tableOutfeed_o.sethook();
      startFiller1_o.sethook();
      startFiller2_o.sethook();
      startLid_o.sethook();
      startCapper_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        tableInfeed_in.gethook();
        doneFiller1_in.gethook();
        doneFiller2_in.gethook();
        doneLid_in.gethook();
        doneCapper_in.gethook();
        tableOutfeed_o.gethook();
        startFiller1_o.gethook();
        startFiller2_o.gethook();
        startLid_o.gethook();
        startCapper_o.gethook();
        tableAligned.gethook();
        bottleAtPos1.gethook();
        bottleAtPos2.gethook();
        bottleAtPos4.gethook();
        bottleAtPos5.gethook();
        exitCleared.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
