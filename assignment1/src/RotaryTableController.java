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
  public Signal operatorPermit = new Signal("operatorPermit", Signal.INPUT);
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
  private RotaryTableTwin t_thread_2;//sysj\rotaryTableController.sysj line: 60, column: 3
  private int step_thread_2;//sysj\rotaryTableController.sysj line: 61, column: 3
  private TableModel m_thread_2;//sysj\rotaryTableController.sysj line: 62, column: 3
  private WorkpieceTwin exiting_thread_2;//sysj\rotaryTableController.sysj line: 63, column: 3
  private boolean seen2_thread_2;//sysj\rotaryTableController.sysj line: 64, column: 3
  private boolean seen4_thread_2;//sysj\rotaryTableController.sysj line: 65, column: 3
  private boolean seen5_thread_2;//sysj\rotaryTableController.sysj line: 66, column: 3
  private TableModel m_thread_3;//sysj\rotaryTableController.sysj line: 174, column: 3
  private WorkpieceTwin w_thread_3;//sysj\rotaryTableController.sysj line: 175, column: 3
  private boolean permitted_thread_2;//sysj\rotaryTableController.sysj line: 131, column: 1
  private int S298914 = 1;
  private int S298748 = 1;
  private int S271203 = 1;
  private int S271017 = 1;
  private int S271024 = 1;
  private int S271019 = 1;
  private int S271248 = 1;
  private int S271346 = 1;
  private int S271341 = 1;
  private int S271720 = 1;
  private int S271715 = 1;
  private int S272138 = 1;
  private int S272133 = 1;
  private int S272600 = 1;
  private int S272595 = 1;
  private int S273106 = 1;
  private int S273101 = 1;
  private int S273656 = 1;
  private int S273651 = 1;
  private int S274250 = 1;
  private int S274245 = 1;
  private int S274888 = 1;
  private int S274883 = 1;
  private int S298912 = 1;
  private int S298772 = 1;
  private int S298756 = 1;
  private int S298751 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread298920(int [] tdone, int [] ends){
        switch(S298912){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S298772){
          case 0 : 
            switch(S298756){
              case 0 : 
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 177, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 177, column: 4
                  S298756=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S298751){
                    case 0 : 
                      if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 177, column: 4
                        tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 177, column: 4
                        S298751=1;
                        if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 177, column: 4
                          tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 177, column: 4
                          ends[3]=2;
                          ;//sysj\rotaryTableController.sysj line: 177, column: 4
                          w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 178, column: 4
                          m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 179, column: 4
                          System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 180, column: 4
                          S298772=1;
                          if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 181, column: 20
                            S298772=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                      if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 177, column: 4
                        tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 177, column: 4
                        ends[3]=2;
                        ;//sysj\rotaryTableController.sysj line: 177, column: 4
                        w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 178, column: 4
                        m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 179, column: 4
                        System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 180, column: 4
                        S298772=1;
                        if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 181, column: 20
                          S298772=2;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                S298756=1;
                S298756=0;
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 177, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 177, column: 4
                  S298756=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S298751=0;
                  if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 177, column: 4
                    tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 177, column: 4
                    S298751=1;
                    if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 177, column: 4
                      tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 177, column: 4
                      ends[3]=2;
                      ;//sysj\rotaryTableController.sysj line: 177, column: 4
                      w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 178, column: 4
                      m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 179, column: 4
                      System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 180, column: 4
                      S298772=1;
                      if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 181, column: 20
                        S298772=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 181, column: 20
              S298772=2;
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
            S298772=2;
            S298772=0;
            S298756=0;
            if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 177, column: 4
              tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 177, column: 4
              S298756=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S298751=0;
              if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 177, column: 4
                tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 177, column: 4
                S298751=1;
                if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 177, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 177, column: 4
                  ends[3]=2;
                  ;//sysj\rotaryTableController.sysj line: 177, column: 4
                  w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 178, column: 4
                  m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 179, column: 4
                  System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 180, column: 4
                  S298772=1;
                  if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 181, column: 20
                    S298772=2;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
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

  public void thread298919(int [] tdone, int [] ends){
        switch(S298748){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S271203){
          case 0 : 
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 70, column: 20
              S271203=1;
              if(m_thread_2.exitOccupied()){//sysj\rotaryTableController.sysj line: 78, column: 4
                exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj\rotaryTableController.sysj line: 79, column: 5
                m_thread_2.sayUnloading();//sysj\rotaryTableController.sysj line: 80, column: 5
                S271017=0;
                S271024=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 81, column: 5
                  tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 81, column: 5
                  S271024=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S271019=0;
                  if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 81, column: 5
                    tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 81, column: 5
                    S271019=1;
                    if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 81, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 81, column: 5
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 81, column: 5
                      S271017=1;
                      if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 82, column: 21
                        m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 85, column: 5
                        S271203=2;
                        if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 91, column: 4
                          if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 92, column: 11
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 92, column: 5
                            S271203=3;
                            if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                              S271248=0;
                              if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                                m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                                placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                                currsigs.addElement(placed_1);
                                S271248=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                                currsigs.addElement(loadPos1);
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              S271203=4;
                              S271346=0;
                              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                S271346=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S271341=0;
                                if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S271341=1;
                                  if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S271203=5;
                                    S271720=0;
                                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                      S271720=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S271715=0;
                                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                        S271715=1;
                                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                          S271203=6;
                                          S272138=0;
                                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S272138=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S272133=0;
                                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S272133=1;
                                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S271203=7;
                                                S272600=0;
                                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S272600=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S272595=0;
                                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S272595=1;
                                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S271203=8;
                                                      S273106=0;
                                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        S273106=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S273101=0;
                                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          S273101=1;
                                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S271203=9;
                                                            S273656=0;
                                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                              S273656=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S273651=0;
                                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                S273651=1;
                                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                  S271203=10;
                                                                  S274250=0;
                                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                    S274250=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S274245=0;
                                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      S274245=1;
                                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                        S271203=11;
                                                                        S274888=0;
                                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                          S274888=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S274883=0;
                                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            S274883=1;
                                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                              S271203=12;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
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
                          S271203=3;
                          if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                            S271248=0;
                            if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                              m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                              placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                              currsigs.addElement(placed_1);
                              S271248=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                              currsigs.addElement(loadPos1);
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            S271203=4;
                            S271346=0;
                            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                              S271346=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S271341=0;
                              if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                                S271341=1;
                                if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S271203=5;
                                  S271720=0;
                                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                    S271720=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S271715=0;
                                    if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                      startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                      S271715=1;
                                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                        S271203=6;
                                        S272138=0;
                                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S272138=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S272133=0;
                                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S272133=1;
                                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S271203=7;
                                              S272600=0;
                                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S272600=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S272595=0;
                                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S272595=1;
                                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S271203=8;
                                                    S273106=0;
                                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      S273106=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S273101=0;
                                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        S273101=1;
                                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          S271203=9;
                                                          S273656=0;
                                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                            S273656=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S273651=0;
                                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                              S273651=1;
                                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                S271203=10;
                                                                S274250=0;
                                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                  S274250=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S274245=0;
                                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                    S274245=1;
                                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      S271203=11;
                                                                      S274888=0;
                                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                        S274888=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S274883=0;
                                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                          S274883=1;
                                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                            S271203=12;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
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
                        unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 83, column: 6
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
                S271203=2;
                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 91, column: 4
                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 92, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 92, column: 5
                    S271203=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                      S271248=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                        currsigs.addElement(placed_1);
                        S271248=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S271203=4;
                      S271346=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                        S271346=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271341=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                          S271341=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                            S271203=5;
                            S271720=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                              S271720=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S271715=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                S271715=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                  S271203=6;
                                  S272138=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S272138=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S272133=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S272133=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S271203=7;
                                        S272600=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S272600=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S272595=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S272595=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S271203=8;
                                              S273106=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                S273106=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S273101=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  S273101=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    S271203=9;
                                                    S273656=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      S273656=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S273651=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        S273651=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          S271203=10;
                                                          S274250=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            S274250=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S274245=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              S274245=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                S271203=11;
                                                                S274888=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  S274888=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S274883=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    S274883=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                      S271203=12;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
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
                  S271203=3;
                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                    S271248=0;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                      currsigs.addElement(placed_1);
                      S271248=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S271203=4;
                    S271346=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                      S271346=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S271341=0;
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                        S271341=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 120, column: 4
                          S271203=5;
                          S271720=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                            S271720=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S271715=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                              S271715=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                S271203=6;
                                S272138=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S272138=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S272133=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S272133=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S271203=7;
                                      S272600=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S272600=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S272595=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S272595=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S271203=8;
                                            S273106=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                              S273106=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S273101=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                S273101=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  S271203=9;
                                                  S273656=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    S273656=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S273651=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      S273651=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        S271203=10;
                                                        S274250=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          S274250=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S274245=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            S274245=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              S271203=11;
                                                              S274888=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                S274888=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S274883=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  S274883=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                    S271203=12;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
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
            switch(S271017){
              case 0 : 
                switch(S271024){
                  case 0 : 
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 81, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 81, column: 5
                      S271024=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      switch(S271019){
                        case 0 : 
                          if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 81, column: 5
                            tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 81, column: 5
                            S271019=1;
                            if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 81, column: 5
                              tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 81, column: 5
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 81, column: 5
                              S271017=1;
                              if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 82, column: 21
                                m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 85, column: 5
                                S271203=2;
                                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 91, column: 4
                                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 92, column: 11
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 92, column: 5
                                    S271203=3;
                                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                                      S271248=0;
                                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                                        currsigs.addElement(placed_1);
                                        S271248=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                                        currsigs.addElement(loadPos1);
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      S271203=4;
                                      S271346=0;
                                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S271346=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S271341=0;
                                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S271341=1;
                                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S271203=5;
                                            S271720=0;
                                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                              S271720=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S271715=0;
                                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                                S271715=1;
                                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                  S271203=6;
                                                  S272138=0;
                                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S272138=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S272133=0;
                                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S272133=1;
                                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S271203=7;
                                                        S272600=0;
                                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S272600=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S272595=0;
                                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S272595=1;
                                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S271203=8;
                                                              S273106=0;
                                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                S273106=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S273101=0;
                                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S273101=1;
                                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    S271203=9;
                                                                    S273656=0;
                                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                      S273656=1;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      S273651=0;
                                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                        S273651=1;
                                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                          ends[2]=2;
                                                                          ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                          S271203=10;
                                                                          S274250=0;
                                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                            S274250=1;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S274245=0;
                                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                              S274245=1;
                                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                                ends[2]=2;
                                                                                ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                                S271203=11;
                                                                                S274888=0;
                                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                  S274888=1;
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                                else {
                                                                                  S274883=0;
                                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                    S274883=1;
                                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                      ends[2]=2;
                                                                                      ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                                      S271203=12;
                                                                                      active[2]=1;
                                                                                      ends[2]=1;
                                                                                      tdone[2]=1;
                                                                                    }
                                                                                    else {
                                                                                      active[2]=1;
                                                                                      ends[2]=1;
                                                                                      tdone[2]=1;
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
                                  S271203=3;
                                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                                    S271248=0;
                                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                                      currsigs.addElement(placed_1);
                                      S271248=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                                      currsigs.addElement(loadPos1);
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    S271203=4;
                                    S271346=0;
                                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S271346=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S271341=0;
                                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S271341=1;
                                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S271203=5;
                                          S271720=0;
                                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                            S271720=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S271715=0;
                                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                              S271715=1;
                                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                S271203=6;
                                                S272138=0;
                                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S272138=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S272133=0;
                                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S272133=1;
                                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S271203=7;
                                                      S272600=0;
                                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S272600=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S272595=0;
                                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S272595=1;
                                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S271203=8;
                                                            S273106=0;
                                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              S273106=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S273101=0;
                                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                S273101=1;
                                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S271203=9;
                                                                  S273656=0;
                                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                    S273656=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S273651=0;
                                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                      S273651=1;
                                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                        S271203=10;
                                                                        S274250=0;
                                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                          S274250=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S274245=0;
                                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                            S274245=1;
                                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                              S271203=11;
                                                                              S274888=0;
                                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                S274888=1;
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                              else {
                                                                                S274883=0;
                                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                  S274883=1;
                                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                    ends[2]=2;
                                                                                    ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                                    S271203=12;
                                                                                    active[2]=1;
                                                                                    ends[2]=1;
                                                                                    tdone[2]=1;
                                                                                  }
                                                                                  else {
                                                                                    active[2]=1;
                                                                                    ends[2]=1;
                                                                                    tdone[2]=1;
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
                                unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 83, column: 6
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
                          if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 81, column: 5
                            tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 81, column: 5
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 81, column: 5
                            S271017=1;
                            if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 82, column: 21
                              m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 85, column: 5
                              S271203=2;
                              if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 91, column: 4
                                if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 92, column: 11
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 92, column: 5
                                  S271203=3;
                                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                                    S271248=0;
                                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                                      currsigs.addElement(placed_1);
                                      S271248=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                                      currsigs.addElement(loadPos1);
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    S271203=4;
                                    S271346=0;
                                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S271346=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S271341=0;
                                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S271341=1;
                                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S271203=5;
                                          S271720=0;
                                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                            S271720=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S271715=0;
                                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                              S271715=1;
                                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                                S271203=6;
                                                S272138=0;
                                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S272138=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S272133=0;
                                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S272133=1;
                                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S271203=7;
                                                      S272600=0;
                                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S272600=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S272595=0;
                                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S272595=1;
                                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S271203=8;
                                                            S273106=0;
                                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              S273106=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S273101=0;
                                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                S273101=1;
                                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S271203=9;
                                                                  S273656=0;
                                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                    S273656=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S273651=0;
                                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                      S273651=1;
                                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                        S271203=10;
                                                                        S274250=0;
                                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                          S274250=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S274245=0;
                                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                            S274245=1;
                                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                              S271203=11;
                                                                              S274888=0;
                                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                S274888=1;
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                              else {
                                                                                S274883=0;
                                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                  S274883=1;
                                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                    ends[2]=2;
                                                                                    ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                                    S271203=12;
                                                                                    active[2]=1;
                                                                                    ends[2]=1;
                                                                                    tdone[2]=1;
                                                                                  }
                                                                                  else {
                                                                                    active[2]=1;
                                                                                    ends[2]=1;
                                                                                    tdone[2]=1;
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
                                S271203=3;
                                if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                                  S271248=0;
                                  if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                                    m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                                    placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                                    currsigs.addElement(placed_1);
                                    S271248=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                                    currsigs.addElement(loadPos1);
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  S271203=4;
                                  S271346=0;
                                  if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S271346=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S271341=0;
                                    if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S271341=1;
                                      if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S271203=5;
                                        S271720=0;
                                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                          S271720=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S271715=0;
                                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                            startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                            S271715=1;
                                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                              S271203=6;
                                              S272138=0;
                                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S272138=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S272133=0;
                                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S272133=1;
                                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S271203=7;
                                                    S272600=0;
                                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S272600=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S272595=0;
                                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S272595=1;
                                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S271203=8;
                                                          S273106=0;
                                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S273106=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S273101=0;
                                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              S273101=1;
                                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                S271203=9;
                                                                S273656=0;
                                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                  S273656=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S273651=0;
                                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                    S273651=1;
                                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                      S271203=10;
                                                                      S274250=0;
                                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                        S274250=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S274245=0;
                                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                          S274245=1;
                                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                            S271203=11;
                                                                            S274888=0;
                                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                              S274888=1;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              S274883=0;
                                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                S274883=1;
                                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                  ends[2]=2;
                                                                                  ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                  permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                                  S271203=12;
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                                else {
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
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
                              unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 83, column: 6
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
                    S271024=1;
                    S271024=0;
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 81, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 81, column: 5
                      S271024=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S271019=0;
                      if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 81, column: 5
                        tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 81, column: 5
                        S271019=1;
                        if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 81, column: 5
                          tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 81, column: 5
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 81, column: 5
                          S271017=1;
                          if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 82, column: 21
                            m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 85, column: 5
                            S271203=2;
                            if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 91, column: 4
                              if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 92, column: 11
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 92, column: 5
                                S271203=3;
                                if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                                  S271248=0;
                                  if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                                    m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                                    placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                                    currsigs.addElement(placed_1);
                                    S271248=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                                    currsigs.addElement(loadPos1);
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  S271203=4;
                                  S271346=0;
                                  if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S271346=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S271341=0;
                                    if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S271341=1;
                                      if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S271203=5;
                                        S271720=0;
                                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                          S271720=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S271715=0;
                                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                            startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                            S271715=1;
                                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                              S271203=6;
                                              S272138=0;
                                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S272138=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S272133=0;
                                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S272133=1;
                                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S271203=7;
                                                    S272600=0;
                                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S272600=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S272595=0;
                                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S272595=1;
                                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S271203=8;
                                                          S273106=0;
                                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S273106=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S273101=0;
                                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              S273101=1;
                                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                S271203=9;
                                                                S273656=0;
                                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                  S273656=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S273651=0;
                                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                    S273651=1;
                                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                      S271203=10;
                                                                      S274250=0;
                                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                        S274250=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S274245=0;
                                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                          S274245=1;
                                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                            S271203=11;
                                                                            S274888=0;
                                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                              S274888=1;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              S274883=0;
                                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                S274883=1;
                                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                  ends[2]=2;
                                                                                  ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                  permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                                  S271203=12;
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                                else {
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
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
                              S271203=3;
                              if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                                S271248=0;
                                if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                                  m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                                  placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                                  currsigs.addElement(placed_1);
                                  S271248=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                                  currsigs.addElement(loadPos1);
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                S271203=4;
                                S271346=0;
                                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S271346=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S271341=0;
                                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S271341=1;
                                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S271203=5;
                                      S271720=0;
                                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                        S271720=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S271715=0;
                                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                          S271715=1;
                                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                            S271203=6;
                                            S272138=0;
                                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S272138=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S272133=0;
                                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S272133=1;
                                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S271203=7;
                                                  S272600=0;
                                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S272600=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S272595=0;
                                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S272595=1;
                                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S271203=8;
                                                        S273106=0;
                                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          S273106=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S273101=0;
                                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S273101=1;
                                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              S271203=9;
                                                              S273656=0;
                                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                S273656=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S273651=0;
                                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                  S273651=1;
                                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                    S271203=10;
                                                                    S274250=0;
                                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      S274250=1;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      S274245=0;
                                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                        S274245=1;
                                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                          ends[2]=2;
                                                                          ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                          S271203=11;
                                                                          S274888=0;
                                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            S274888=1;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S274883=0;
                                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                              S274883=1;
                                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                ends[2]=2;
                                                                                ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                                S271203=12;
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                              else {
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
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
                            unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 83, column: 6
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
                if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 82, column: 21
                  m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 85, column: 5
                  S271203=2;
                  if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 91, column: 4
                    if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 92, column: 11
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 92, column: 5
                      S271203=3;
                      if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                        S271248=0;
                        if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                          m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                          placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                          currsigs.addElement(placed_1);
                          S271248=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                          currsigs.addElement(loadPos1);
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        S271203=4;
                        S271346=0;
                        if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                          S271346=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S271341=0;
                          if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                            startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                            S271341=1;
                            if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 120, column: 4
                              S271203=5;
                              S271720=0;
                              if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                S271720=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S271715=0;
                                if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                  startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                  S271715=1;
                                  if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                    S271203=6;
                                    S272138=0;
                                    if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S272138=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S272133=0;
                                      if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S272133=1;
                                        if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S271203=7;
                                          S272600=0;
                                          if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S272600=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S272595=0;
                                            if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S272595=1;
                                              if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S271203=8;
                                                S273106=0;
                                                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  S273106=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S273101=0;
                                                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    S273101=1;
                                                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      S271203=9;
                                                      S273656=0;
                                                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        S273656=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S273651=0;
                                                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          S273651=1;
                                                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                            S271203=10;
                                                            S274250=0;
                                                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              S274250=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S274245=0;
                                                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                S274245=1;
                                                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                  S271203=11;
                                                                  S274888=0;
                                                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    S274888=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S274883=0;
                                                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      S274883=1;
                                                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                        permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                        S271203=12;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
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
                    S271203=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                      S271248=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                        currsigs.addElement(placed_1);
                        S271248=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S271203=4;
                      S271346=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                        S271346=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271341=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                          S271341=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                            S271203=5;
                            S271720=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                              S271720=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S271715=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                S271715=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                  S271203=6;
                                  S272138=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S272138=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S272133=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S272133=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S271203=7;
                                        S272600=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S272600=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S272595=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S272595=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S271203=8;
                                              S273106=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                S273106=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S273101=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  S273101=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    S271203=9;
                                                    S273656=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      S273656=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S273651=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        S273651=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          S271203=10;
                                                          S274250=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            S274250=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S274245=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              S274245=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                S271203=11;
                                                                S274888=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  S274888=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S274883=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    S274883=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                      S271203=12;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
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
                  unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 83, column: 6
                  currsigs.addElement(unloadExit);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
          case 2 : 
            if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 92, column: 11
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              ends[2]=2;
              ;//sysj\rotaryTableController.sysj line: 92, column: 5
              S271203=3;
              if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                S271248=0;
                if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                  m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                  placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                  currsigs.addElement(placed_1);
                  S271248=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                  currsigs.addElement(loadPos1);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
              else {
                S271203=4;
                S271346=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                  S271346=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S271341=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                    S271341=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 120, column: 4
                      S271203=5;
                      S271720=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                        S271720=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271715=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                          S271715=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 121, column: 4
                            S271203=6;
                            S272138=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                              S272138=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S272133=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                S272133=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S271203=7;
                                  S272600=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S272600=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S272595=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                      S272595=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S271203=8;
                                        S273106=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                          S273106=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S273101=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                            S273101=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                              S271203=9;
                                              S273656=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                S273656=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S273651=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                  S273651=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    S271203=10;
                                                    S274250=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      S274250=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S274245=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                        S274245=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          S271203=11;
                                                          S274888=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            S274888=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S274883=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                              S274883=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                S271203=12;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
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
            switch(S271248){
              case 0 : 
                if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                  m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                  placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                  currsigs.addElement(placed_1);
                  S271248=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                  currsigs.addElement(loadPos1);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S271248=1;
                S271203=4;
                S271346=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                  S271346=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S271341=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                    S271341=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 120, column: 4
                      S271203=5;
                      S271720=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                        S271720=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271715=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                          S271715=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 121, column: 4
                            S271203=6;
                            S272138=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                              S272138=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S272133=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                S272133=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S271203=7;
                                  S272600=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S272600=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S272595=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                      S272595=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S271203=8;
                                        S273106=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                          S273106=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S273101=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                            S273101=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                              S271203=9;
                                              S273656=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                S273656=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S273651=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                  S273651=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    S271203=10;
                                                    S274250=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      S274250=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S274245=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                        S274245=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          S271203=11;
                                                          S274888=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            S274888=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S274883=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                              S274883=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                S271203=12;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
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
            switch(S271346){
              case 0 : 
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                  S271346=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S271341){
                    case 0 : 
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                        S271341=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 120, column: 4
                          S271203=5;
                          S271720=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                            S271720=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S271715=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                              S271715=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                S271203=6;
                                S272138=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S272138=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S272133=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S272133=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S271203=7;
                                      S272600=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S272600=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S272595=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S272595=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S271203=8;
                                            S273106=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                              S273106=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S273101=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                S273101=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  S271203=9;
                                                  S273656=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    S273656=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S273651=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      S273651=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        S271203=10;
                                                        S274250=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          S274250=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S274245=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            S274245=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              S271203=11;
                                                              S274888=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                S274888=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S274883=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  S274883=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                    S271203=12;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
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
                      if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 120, column: 4
                        S271203=5;
                        S271720=0;
                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                          S271720=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S271715=0;
                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                            startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                            S271715=1;
                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 121, column: 4
                              S271203=6;
                              S272138=0;
                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                S272138=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S272133=0;
                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S272133=1;
                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S271203=7;
                                    S272600=0;
                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                      S272600=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S272595=0;
                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S272595=1;
                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S271203=8;
                                          S273106=0;
                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                            S273106=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S273101=0;
                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                              S273101=1;
                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                S271203=9;
                                                S273656=0;
                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                  S273656=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S273651=0;
                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    S273651=1;
                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      S271203=10;
                                                      S274250=0;
                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                        S274250=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S274245=0;
                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          S274245=1;
                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            S271203=11;
                                                            S274888=0;
                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                              S274888=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S274883=0;
                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                S274883=1;
                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                  S271203=12;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
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
                S271346=1;
                S271346=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                  S271346=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S271341=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                    S271341=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 120, column: 4
                      S271203=5;
                      S271720=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                        S271720=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271715=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                          S271715=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 121, column: 4
                            S271203=6;
                            S272138=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                              S272138=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S272133=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                S272133=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S271203=7;
                                  S272600=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S272600=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S272595=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                      S272595=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S271203=8;
                                        S273106=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                          S273106=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S273101=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                            S273101=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                              S271203=9;
                                              S273656=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                S273656=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S273651=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                  S273651=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    S271203=10;
                                                    S274250=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      S274250=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S274245=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                        S274245=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          S271203=11;
                                                          S274888=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            S274888=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S274883=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                              S274883=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                S271203=12;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
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
            switch(S271720){
              case 0 : 
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                  S271720=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S271715){
                    case 0 : 
                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                        S271715=1;
                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 121, column: 4
                          S271203=6;
                          S272138=0;
                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                            S272138=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S272133=0;
                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                              S272133=1;
                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                S271203=7;
                                S272600=0;
                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                  S272600=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S272595=0;
                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S272595=1;
                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                      S271203=8;
                                      S273106=0;
                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                        S273106=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S273101=0;
                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                          S273101=1;
                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                            S271203=9;
                                            S273656=0;
                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                              S273656=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S273651=0;
                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                S273651=1;
                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                  S271203=10;
                                                  S274250=0;
                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                    S274250=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S274245=0;
                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      S274245=1;
                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                        S271203=11;
                                                        S274888=0;
                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                          S274888=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S274883=0;
                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            S274883=1;
                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                              S271203=12;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
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
                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 121, column: 4
                        S271203=6;
                        S272138=0;
                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                          S272138=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S272133=0;
                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                            S272133=1;
                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                              S271203=7;
                              S272600=0;
                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                S272600=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S272595=0;
                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                  S272595=1;
                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S271203=8;
                                    S273106=0;
                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                      S273106=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S273101=0;
                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                        S273101=1;
                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                          S271203=9;
                                          S273656=0;
                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                            S273656=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S273651=0;
                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                              S273651=1;
                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                S271203=10;
                                                S274250=0;
                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                  S274250=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S274245=0;
                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                    S274245=1;
                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      S271203=11;
                                                      S274888=0;
                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                        S274888=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S274883=0;
                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                          S274883=1;
                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                            S271203=12;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
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
                S271720=1;
                S271720=0;
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                  S271720=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S271715=0;
                  if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                    startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                    S271715=1;
                    if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 121, column: 4
                      S271203=6;
                      S272138=0;
                      if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                        S272138=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S272133=0;
                        if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                          startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                          S272133=1;
                          if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 122, column: 4
                            S271203=7;
                            S272600=0;
                            if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                              S272600=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S272595=0;
                              if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                S272595=1;
                                if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                  S271203=8;
                                  S273106=0;
                                  if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                    S273106=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S273101=0;
                                    if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                      doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                      S273101=1;
                                      if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                        S271203=9;
                                        S273656=0;
                                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                          S273656=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S273651=0;
                                          if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                            doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                            S273651=1;
                                            if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                              S271203=10;
                                              S274250=0;
                                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                S274250=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S274245=0;
                                                if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                  doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                  S274245=1;
                                                  if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                    S271203=11;
                                                    S274888=0;
                                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                      S274888=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S274883=0;
                                                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                        S274883=1;
                                                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                          permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                          S271203=12;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
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
            switch(S272138){
              case 0 : 
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                  S272138=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S272133){
                    case 0 : 
                      if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                        startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                        S272133=1;
                        if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                          S271203=7;
                          S272600=0;
                          if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                            S272600=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S272595=0;
                            if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                              startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                              S272595=1;
                              if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                S271203=8;
                                S273106=0;
                                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                  S273106=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S273101=0;
                                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                    S273101=1;
                                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                      S271203=9;
                                      S273656=0;
                                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                        S273656=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S273651=0;
                                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                          S273651=1;
                                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                            S271203=10;
                                            S274250=0;
                                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                              S274250=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S274245=0;
                                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                S274245=1;
                                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                  S271203=11;
                                                  S274888=0;
                                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                    S274888=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S274883=0;
                                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                      S274883=1;
                                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                        permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                        S271203=12;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
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
                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                        S271203=7;
                        S272600=0;
                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                          S272600=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S272595=0;
                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                            S272595=1;
                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                              S271203=8;
                              S273106=0;
                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                S273106=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S273101=0;
                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                  S273101=1;
                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                    S271203=9;
                                    S273656=0;
                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                      S273656=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S273651=0;
                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                        S273651=1;
                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                          S271203=10;
                                          S274250=0;
                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                            S274250=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S274245=0;
                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                              S274245=1;
                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                S271203=11;
                                                S274888=0;
                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                  S274888=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S274883=0;
                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                    S274883=1;
                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                      S271203=12;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
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
                S272138=1;
                S272138=0;
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                  S272138=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S272133=0;
                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                    S272133=1;
                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                      S271203=7;
                      S272600=0;
                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                        S272600=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S272595=0;
                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                          S272595=1;
                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                            S271203=8;
                            S273106=0;
                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                              S273106=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S273101=0;
                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                S273101=1;
                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                  S271203=9;
                                  S273656=0;
                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                    S273656=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S273651=0;
                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                      S273651=1;
                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                        S271203=10;
                                        S274250=0;
                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                          S274250=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S274245=0;
                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                            S274245=1;
                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                              S271203=11;
                                              S274888=0;
                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                S274888=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S274883=0;
                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                  S274883=1;
                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                    S271203=12;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
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
            switch(S272600){
              case 0 : 
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                  S272600=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S272595){
                    case 0 : 
                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                        S272595=1;
                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                          S271203=8;
                          S273106=0;
                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                            S273106=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S273101=0;
                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                              S273101=1;
                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                S271203=9;
                                S273656=0;
                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                  S273656=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S273651=0;
                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                    S273651=1;
                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                      S271203=10;
                                      S274250=0;
                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                        S274250=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S274245=0;
                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                          S274245=1;
                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                            S271203=11;
                                            S274888=0;
                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                              S274888=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S274883=0;
                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                S274883=1;
                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                  permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                  S271203=12;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
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
                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                        S271203=8;
                        S273106=0;
                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                          S273106=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S273101=0;
                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                            S273101=1;
                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                              S271203=9;
                              S273656=0;
                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                S273656=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S273651=0;
                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                  S273651=1;
                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                    S271203=10;
                                    S274250=0;
                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                      S274250=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S274245=0;
                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                        S274245=1;
                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                          S271203=11;
                                          S274888=0;
                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                            S274888=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S274883=0;
                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                              S274883=1;
                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                S271203=12;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
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
                S272600=1;
                S272600=0;
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                  S272600=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S272595=0;
                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                    S272595=1;
                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                      S271203=8;
                      S273106=0;
                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                        S273106=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S273101=0;
                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                          S273101=1;
                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                            S271203=9;
                            S273656=0;
                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                              S273656=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S273651=0;
                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                S273651=1;
                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                  S271203=10;
                                  S274250=0;
                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                    S274250=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S274245=0;
                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                      S274245=1;
                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                        S271203=11;
                                        S274888=0;
                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                          S274888=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S274883=0;
                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                            S274883=1;
                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                              S271203=12;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
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
            switch(S273106){
              case 0 : 
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                  S273106=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S273101){
                    case 0 : 
                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                        S273101=1;
                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 125, column: 4
                          S271203=9;
                          S273656=0;
                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                            S273656=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S273651=0;
                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                              S273651=1;
                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                S271203=10;
                                S274250=0;
                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                  S274250=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S274245=0;
                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                    S274245=1;
                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                      S271203=11;
                                      S274888=0;
                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                        S274888=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S274883=0;
                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                          S274883=1;
                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                            S271203=12;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
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
                      if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 125, column: 4
                        S271203=9;
                        S273656=0;
                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                          S273656=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S273651=0;
                          if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                            doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                            S273651=1;
                            if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 126, column: 4
                              S271203=10;
                              S274250=0;
                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                S274250=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S274245=0;
                                if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                  doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                  S274245=1;
                                  if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                    S271203=11;
                                    S274888=0;
                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                      S274888=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S274883=0;
                                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                        S274883=1;
                                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                          permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                          S271203=12;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
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
                S273106=1;
                S273106=0;
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                  S273106=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S273101=0;
                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                    S273101=1;
                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                      S271203=9;
                      S273656=0;
                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                        S273656=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S273651=0;
                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                          S273651=1;
                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 126, column: 4
                            S271203=10;
                            S274250=0;
                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                              S274250=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S274245=0;
                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                S274245=1;
                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                  S271203=11;
                                  S274888=0;
                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                    S274888=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S274883=0;
                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                      S274883=1;
                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                        permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                        S271203=12;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
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
            switch(S273656){
              case 0 : 
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                  S273656=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S273651){
                    case 0 : 
                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                        S273651=1;
                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 126, column: 4
                          S271203=10;
                          S274250=0;
                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                            S274250=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S274245=0;
                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                              S274245=1;
                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                S271203=11;
                                S274888=0;
                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                  S274888=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S274883=0;
                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                    S274883=1;
                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                      S271203=12;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
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
                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 126, column: 4
                        S271203=10;
                        S274250=0;
                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                          S274250=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S274245=0;
                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                            S274245=1;
                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 127, column: 4
                              S271203=11;
                              S274888=0;
                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                S274888=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S274883=0;
                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                  S274883=1;
                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                    S271203=12;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
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
                S273656=1;
                S273656=0;
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                  S273656=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S273651=0;
                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                    S273651=1;
                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 126, column: 4
                      S271203=10;
                      S274250=0;
                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                        S274250=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S274245=0;
                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                          S274245=1;
                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 127, column: 4
                            S271203=11;
                            S274888=0;
                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                              S274888=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S274883=0;
                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                S274883=1;
                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                  permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                  S271203=12;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
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
            switch(S274250){
              case 0 : 
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                  S274250=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S274245){
                    case 0 : 
                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                        S274245=1;
                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 127, column: 4
                          S271203=11;
                          S274888=0;
                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                            S274888=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S274883=0;
                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                              S274883=1;
                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                S271203=12;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
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
                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 127, column: 4
                        S271203=11;
                        S274888=0;
                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                          S274888=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S274883=0;
                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                            S274883=1;
                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 128, column: 4
                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                              S271203=12;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
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
                S274250=1;
                S274250=0;
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                  S274250=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S274245=0;
                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                    S274245=1;
                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 127, column: 4
                      S271203=11;
                      S274888=0;
                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                        S274888=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S274883=0;
                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                          S274883=1;
                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 128, column: 4
                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                            S271203=12;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
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
            switch(S274888){
              case 0 : 
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                  S274888=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S274883){
                    case 0 : 
                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                        S274883=1;
                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 128, column: 4
                          permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                          S271203=12;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          active[2]=1;
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
                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 128, column: 4
                        permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                        S271203=12;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
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
                S274888=1;
                S274888=0;
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                  S274888=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S274883=0;
                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                    S274883=1;
                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 128, column: 4
                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                      S271203=12;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      active[2]=1;
                      ends[2]=1;
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
            S271203=12;
            S271203=13;
            if(!permitted_thread_2){//sysj\rotaryTableController.sysj line: 133, column: 19
              permitted_thread_2 = GuiStep.take("INDEX", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\rotaryTableController.sysj line: 134, column: 17
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              ends[2]=2;
              ;//sysj\rotaryTableController.sysj line: 133, column: 13
              S271203=14;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 13 : 
            if(!permitted_thread_2){//sysj\rotaryTableController.sysj line: 133, column: 19
              permitted_thread_2 = GuiStep.take("INDEX", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\rotaryTableController.sysj line: 134, column: 17
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              ends[2]=2;
              ;//sysj\rotaryTableController.sysj line: 133, column: 13
              S271203=14;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 14 : 
            S271203=14;
            S271203=15;
            if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 142, column: 20
              S271203=16;
              if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 145, column: 20
                m_thread_2.index();//sysj\rotaryTableController.sysj line: 147, column: 4
                m_thread_2.report();//sysj\rotaryTableController.sysj line: 148, column: 4
                seen2_thread_2 = false;//sysj\rotaryTableController.sysj line: 158, column: 4
                seen4_thread_2 = false;//sysj\rotaryTableController.sysj line: 158, column: 19
                seen5_thread_2 = false;//sysj\rotaryTableController.sysj line: 158, column: 34
                S271203=17;
                if(bottleAtPos2.getprestatus()){//sysj\rotaryTableController.sysj line: 159, column: 12
                  seen2_thread_2 = true;//sysj\rotaryTableController.sysj line: 159, column: 27
                  if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 160, column: 12
                    seen4_thread_2 = true;//sysj\rotaryTableController.sysj line: 160, column: 27
                    if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 161, column: 12
                      seen5_thread_2 = true;//sysj\rotaryTableController.sysj line: 161, column: 27
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                  else {
                    if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 161, column: 12
                      seen5_thread_2 = true;//sysj\rotaryTableController.sysj line: 161, column: 27
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                }
                else {
                  if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 160, column: 12
                    seen4_thread_2 = true;//sysj\rotaryTableController.sysj line: 160, column: 27
                    if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 161, column: 12
                      seen5_thread_2 = true;//sysj\rotaryTableController.sysj line: 161, column: 27
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                  else {
                    if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 161, column: 12
                      seen5_thread_2 = true;//sysj\rotaryTableController.sysj line: 161, column: 27
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
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
            else {
              rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 143, column: 5
              currsigs.addElement(rotaryTrigger);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 15 : 
            if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 142, column: 20
              S271203=16;
              if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 145, column: 20
                m_thread_2.index();//sysj\rotaryTableController.sysj line: 147, column: 4
                m_thread_2.report();//sysj\rotaryTableController.sysj line: 148, column: 4
                seen2_thread_2 = false;//sysj\rotaryTableController.sysj line: 158, column: 4
                seen4_thread_2 = false;//sysj\rotaryTableController.sysj line: 158, column: 19
                seen5_thread_2 = false;//sysj\rotaryTableController.sysj line: 158, column: 34
                S271203=17;
                if(bottleAtPos2.getprestatus()){//sysj\rotaryTableController.sysj line: 159, column: 12
                  seen2_thread_2 = true;//sysj\rotaryTableController.sysj line: 159, column: 27
                  if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 160, column: 12
                    seen4_thread_2 = true;//sysj\rotaryTableController.sysj line: 160, column: 27
                    if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 161, column: 12
                      seen5_thread_2 = true;//sysj\rotaryTableController.sysj line: 161, column: 27
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                  else {
                    if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 161, column: 12
                      seen5_thread_2 = true;//sysj\rotaryTableController.sysj line: 161, column: 27
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                }
                else {
                  if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 160, column: 12
                    seen4_thread_2 = true;//sysj\rotaryTableController.sysj line: 160, column: 27
                    if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 161, column: 12
                      seen5_thread_2 = true;//sysj\rotaryTableController.sysj line: 161, column: 27
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                  }
                  else {
                    if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 161, column: 12
                      seen5_thread_2 = true;//sysj\rotaryTableController.sysj line: 161, column: 27
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                      step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                      t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                      t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271203=18;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
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
            else {
              rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 143, column: 5
              currsigs.addElement(rotaryTrigger);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 16 : 
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 145, column: 20
              m_thread_2.index();//sysj\rotaryTableController.sysj line: 147, column: 4
              m_thread_2.report();//sysj\rotaryTableController.sysj line: 148, column: 4
              seen2_thread_2 = false;//sysj\rotaryTableController.sysj line: 158, column: 4
              seen4_thread_2 = false;//sysj\rotaryTableController.sysj line: 158, column: 19
              seen5_thread_2 = false;//sysj\rotaryTableController.sysj line: 158, column: 34
              S271203=17;
              if(bottleAtPos2.getprestatus()){//sysj\rotaryTableController.sysj line: 159, column: 12
                seen2_thread_2 = true;//sysj\rotaryTableController.sysj line: 159, column: 27
                if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 160, column: 12
                  seen4_thread_2 = true;//sysj\rotaryTableController.sysj line: 160, column: 27
                  if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 161, column: 12
                    seen5_thread_2 = true;//sysj\rotaryTableController.sysj line: 161, column: 27
                    m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                    step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                    t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                    t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                    if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                    step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                    t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                    t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                    if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                }
                else {
                  if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 161, column: 12
                    seen5_thread_2 = true;//sysj\rotaryTableController.sysj line: 161, column: 27
                    m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                    step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                    t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                    t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                    if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                    step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                    t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                    t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                    if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                }
              }
              else {
                if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 160, column: 12
                  seen4_thread_2 = true;//sysj\rotaryTableController.sysj line: 160, column: 27
                  if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 161, column: 12
                    seen5_thread_2 = true;//sysj\rotaryTableController.sysj line: 161, column: 27
                    m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                    step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                    t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                    t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                    if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                    step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                    t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                    t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                    if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                }
                else {
                  if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 161, column: 12
                    seen5_thread_2 = true;//sysj\rotaryTableController.sysj line: 161, column: 27
                    m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                    step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                    t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                    t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                    if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    m_thread_2.checkAgainstSensors(seen2_thread_2, seen4_thread_2, seen5_thread_2);//sysj\rotaryTableController.sysj line: 162, column: 4
                    step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 163, column: 4
                    t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 164, column: 4
                    t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                    if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 166, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 167, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 167, column: 5
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S271203=18;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
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
          
          case 17 : 
            S271203=0;
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 70, column: 20
              S271203=1;
              if(m_thread_2.exitOccupied()){//sysj\rotaryTableController.sysj line: 78, column: 4
                exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj\rotaryTableController.sysj line: 79, column: 5
                m_thread_2.sayUnloading();//sysj\rotaryTableController.sysj line: 80, column: 5
                S271017=0;
                S271024=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 81, column: 5
                  tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 81, column: 5
                  S271024=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S271019=0;
                  if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 81, column: 5
                    tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 81, column: 5
                    S271019=1;
                    if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 81, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 81, column: 5
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 81, column: 5
                      S271017=1;
                      if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 82, column: 21
                        m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 85, column: 5
                        S271203=2;
                        if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 91, column: 4
                          if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 92, column: 11
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 92, column: 5
                            S271203=3;
                            if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                              S271248=0;
                              if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                                m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                                placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                                currsigs.addElement(placed_1);
                                S271248=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                                currsigs.addElement(loadPos1);
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              S271203=4;
                              S271346=0;
                              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                S271346=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S271341=0;
                                if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S271341=1;
                                  if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S271203=5;
                                    S271720=0;
                                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                      S271720=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S271715=0;
                                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                        S271715=1;
                                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                          S271203=6;
                                          S272138=0;
                                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S272138=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S272133=0;
                                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S272133=1;
                                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S271203=7;
                                                S272600=0;
                                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S272600=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S272595=0;
                                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S272595=1;
                                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S271203=8;
                                                      S273106=0;
                                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        S273106=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S273101=0;
                                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          S273101=1;
                                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S271203=9;
                                                            S273656=0;
                                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                              S273656=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S273651=0;
                                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                S273651=1;
                                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                  S271203=10;
                                                                  S274250=0;
                                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                    S274250=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S274245=0;
                                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      S274245=1;
                                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                        S271203=11;
                                                                        S274888=0;
                                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                          S274888=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S274883=0;
                                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            S274883=1;
                                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                              S271203=12;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
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
                          S271203=3;
                          if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                            S271248=0;
                            if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                              m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                              placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                              currsigs.addElement(placed_1);
                              S271248=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                              currsigs.addElement(loadPos1);
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            S271203=4;
                            S271346=0;
                            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                              S271346=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S271341=0;
                              if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                                S271341=1;
                                if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S271203=5;
                                  S271720=0;
                                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                    S271720=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S271715=0;
                                    if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                      startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                      S271715=1;
                                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                        S271203=6;
                                        S272138=0;
                                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S272138=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S272133=0;
                                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S272133=1;
                                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S271203=7;
                                              S272600=0;
                                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S272600=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S272595=0;
                                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S272595=1;
                                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S271203=8;
                                                    S273106=0;
                                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      S273106=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S273101=0;
                                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        S273101=1;
                                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          S271203=9;
                                                          S273656=0;
                                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                            S273656=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S273651=0;
                                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                              S273651=1;
                                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                S271203=10;
                                                                S274250=0;
                                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                  S274250=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S274245=0;
                                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                    S274245=1;
                                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      S271203=11;
                                                                      S274888=0;
                                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                        S274888=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S274883=0;
                                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                          S274883=1;
                                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                            S271203=12;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
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
                        unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 83, column: 6
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
                S271203=2;
                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 91, column: 4
                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 92, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 92, column: 5
                    S271203=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                      S271248=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                        currsigs.addElement(placed_1);
                        S271248=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S271203=4;
                      S271346=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                        S271346=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271341=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                          S271341=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                            S271203=5;
                            S271720=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                              S271720=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S271715=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                S271715=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                  S271203=6;
                                  S272138=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S272138=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S272133=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S272133=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S271203=7;
                                        S272600=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S272600=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S272595=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S272595=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S271203=8;
                                              S273106=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                S273106=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S273101=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  S273101=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    S271203=9;
                                                    S273656=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      S273656=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S273651=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        S273651=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          S271203=10;
                                                          S274250=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            S274250=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S274245=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              S274245=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                S271203=11;
                                                                S274888=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  S274888=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S274883=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    S274883=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                      S271203=12;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
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
                  S271203=3;
                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                    S271248=0;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                      currsigs.addElement(placed_1);
                      S271248=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S271203=4;
                    S271346=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                      S271346=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S271341=0;
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                        S271341=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 120, column: 4
                          S271203=5;
                          S271720=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                            S271720=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S271715=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                              S271715=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                S271203=6;
                                S272138=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S272138=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S272133=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S272133=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S271203=7;
                                      S272600=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S272600=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S272595=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S272595=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S271203=8;
                                            S273106=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                              S273106=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S273101=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                S273101=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  S271203=9;
                                                  S273656=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    S273656=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S273651=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      S273651=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        S271203=10;
                                                        S274250=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          S274250=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S274245=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            S274245=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              S271203=11;
                                                              S274888=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                S274888=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S274883=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  S274883=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                    S271203=12;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
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
          
          case 18 : 
            S271203=18;
            S271203=0;
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 70, column: 20
              S271203=1;
              if(m_thread_2.exitOccupied()){//sysj\rotaryTableController.sysj line: 78, column: 4
                exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj\rotaryTableController.sysj line: 79, column: 5
                m_thread_2.sayUnloading();//sysj\rotaryTableController.sysj line: 80, column: 5
                S271017=0;
                S271024=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 81, column: 5
                  tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 81, column: 5
                  S271024=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S271019=0;
                  if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 81, column: 5
                    tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 81, column: 5
                    S271019=1;
                    if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 81, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 81, column: 5
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 81, column: 5
                      S271017=1;
                      if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 82, column: 21
                        m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 85, column: 5
                        S271203=2;
                        if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 91, column: 4
                          if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 92, column: 11
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 92, column: 5
                            S271203=3;
                            if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                              S271248=0;
                              if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                                m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                                placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                                currsigs.addElement(placed_1);
                                S271248=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                                currsigs.addElement(loadPos1);
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              S271203=4;
                              S271346=0;
                              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                S271346=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S271341=0;
                                if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S271341=1;
                                  if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S271203=5;
                                    S271720=0;
                                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                      S271720=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S271715=0;
                                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                        S271715=1;
                                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                          S271203=6;
                                          S272138=0;
                                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S272138=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S272133=0;
                                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S272133=1;
                                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S271203=7;
                                                S272600=0;
                                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S272600=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S272595=0;
                                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S272595=1;
                                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S271203=8;
                                                      S273106=0;
                                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        S273106=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S273101=0;
                                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          S273101=1;
                                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S271203=9;
                                                            S273656=0;
                                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                              S273656=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S273651=0;
                                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                S273651=1;
                                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                  S271203=10;
                                                                  S274250=0;
                                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                    S274250=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S274245=0;
                                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      S274245=1;
                                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                        S271203=11;
                                                                        S274888=0;
                                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                          S274888=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S274883=0;
                                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            S274883=1;
                                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                              S271203=12;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
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
                          S271203=3;
                          if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                            S271248=0;
                            if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                              m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                              placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                              currsigs.addElement(placed_1);
                              S271248=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                              currsigs.addElement(loadPos1);
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            S271203=4;
                            S271346=0;
                            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                              S271346=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S271341=0;
                              if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                                S271341=1;
                                if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S271203=5;
                                  S271720=0;
                                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                    S271720=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S271715=0;
                                    if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                      startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                      S271715=1;
                                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                        S271203=6;
                                        S272138=0;
                                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S272138=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S272133=0;
                                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S272133=1;
                                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S271203=7;
                                              S272600=0;
                                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S272600=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S272595=0;
                                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S272595=1;
                                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S271203=8;
                                                    S273106=0;
                                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      S273106=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S273101=0;
                                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        S273101=1;
                                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          S271203=9;
                                                          S273656=0;
                                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                            S273656=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S273651=0;
                                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                              S273651=1;
                                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                                S271203=10;
                                                                S274250=0;
                                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                  S274250=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S274245=0;
                                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                    S274245=1;
                                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                      S271203=11;
                                                                      S274888=0;
                                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                        S274888=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S274883=0;
                                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                          S274883=1;
                                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                            S271203=12;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
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
                        unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 83, column: 6
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
                S271203=2;
                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 91, column: 4
                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 92, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 92, column: 5
                    S271203=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                      S271248=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                        currsigs.addElement(placed_1);
                        S271248=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S271203=4;
                      S271346=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                        S271346=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271341=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                          S271341=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                            S271203=5;
                            S271720=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                              S271720=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S271715=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                S271715=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                  S271203=6;
                                  S272138=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S272138=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S272133=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S272133=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S271203=7;
                                        S272600=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S272600=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S272595=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S272595=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S271203=8;
                                              S273106=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                S273106=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S273101=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  S273101=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    S271203=9;
                                                    S273656=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      S273656=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S273651=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        S273651=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          S271203=10;
                                                          S274250=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            S274250=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S274245=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              S274245=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                S271203=11;
                                                                S274888=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  S274888=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S274883=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    S274883=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                      S271203=12;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
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
                  S271203=3;
                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                    S271248=0;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                      currsigs.addElement(placed_1);
                      S271248=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S271203=4;
                    S271346=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                      S271346=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S271341=0;
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                        S271341=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 120, column: 4
                          S271203=5;
                          S271720=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                            S271720=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S271715=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                              S271715=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                S271203=6;
                                S272138=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S272138=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S272133=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S272133=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S271203=7;
                                      S272600=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S272600=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S272595=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S272595=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S271203=8;
                                            S273106=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                              S273106=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S273101=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                S273101=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  S271203=9;
                                                  S273656=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    S273656=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S273651=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      S273651=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        S271203=10;
                                                        S274250=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          S274250=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S274245=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            S274245=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              S271203=11;
                                                              S274888=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                S274888=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S274883=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  S274883=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                    S271203=12;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
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

  public void thread298917(int [] tdone, int [] ends){
        S298912=1;
    m_thread_3 = TableModel.shared();//sysj\rotaryTableController.sysj line: 174, column: 3
    w_thread_3 = null;//sysj\rotaryTableController.sysj line: 175, column: 3
    S298772=0;
    S298756=0;
    if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 177, column: 4
      tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 177, column: 4
      S298756=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S298751=0;
      if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 177, column: 4
        tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 177, column: 4
        S298751=1;
        if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 177, column: 4
          tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 177, column: 4
          ends[3]=2;
          ;//sysj\rotaryTableController.sysj line: 177, column: 4
          w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 178, column: 4
          m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 179, column: 4
          System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 180, column: 4
          S298772=1;
          if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 181, column: 20
            S298772=2;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
          else {
            active[3]=1;
            ends[3]=1;
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

  public void thread298916(int [] tdone, int [] ends){
        S298748=1;
    t_thread_2 = new RotaryTableTwin();//sysj\rotaryTableController.sysj line: 60, column: 3
    step_thread_2 = 0;//sysj\rotaryTableController.sysj line: 61, column: 3
    m_thread_2 = TableModel.shared();//sysj\rotaryTableController.sysj line: 62, column: 3
    exiting_thread_2 = null;//sysj\rotaryTableController.sysj line: 63, column: 3
    seen2_thread_2 = false;//sysj\rotaryTableController.sysj line: 64, column: 3
    seen4_thread_2 = false;//sysj\rotaryTableController.sysj line: 65, column: 3
    seen5_thread_2 = false;//sysj\rotaryTableController.sysj line: 66, column: 3
    S271203=0;
    if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 70, column: 20
      S271203=1;
      if(m_thread_2.exitOccupied()){//sysj\rotaryTableController.sysj line: 78, column: 4
        exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj\rotaryTableController.sysj line: 79, column: 5
        m_thread_2.sayUnloading();//sysj\rotaryTableController.sysj line: 80, column: 5
        S271017=0;
        S271024=0;
        if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 81, column: 5
          tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 81, column: 5
          S271024=1;
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          S271019=0;
          if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 81, column: 5
            tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 81, column: 5
            S271019=1;
            if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 81, column: 5
              tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 81, column: 5
              ends[2]=2;
              ;//sysj\rotaryTableController.sysj line: 81, column: 5
              S271017=1;
              if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 82, column: 21
                m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 85, column: 5
                S271203=2;
                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 91, column: 4
                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 92, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 92, column: 5
                    S271203=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                      S271248=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                        currsigs.addElement(placed_1);
                        S271248=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S271203=4;
                      S271346=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                        S271346=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S271341=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                          S271341=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                            S271203=5;
                            S271720=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                              S271720=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S271715=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                                S271715=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                  S271203=6;
                                  S272138=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S272138=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S272133=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S272133=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S271203=7;
                                        S272600=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S272600=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S272595=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S272595=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S271203=8;
                                              S273106=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                S273106=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S273101=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  S273101=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    S271203=9;
                                                    S273656=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      S273656=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S273651=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        S273651=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                          S271203=10;
                                                          S274250=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            S274250=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S274245=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              S274245=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                                S271203=11;
                                                                S274888=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  S274888=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S274883=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    S274883=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                      S271203=12;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
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
                  S271203=3;
                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
                    S271248=0;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                      currsigs.addElement(placed_1);
                      S271248=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S271203=4;
                    S271346=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                      S271346=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S271341=0;
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                        S271341=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 120, column: 4
                          S271203=5;
                          S271720=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                            S271720=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S271715=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                              S271715=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 121, column: 4
                                S271203=6;
                                S272138=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S272138=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S272133=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S272133=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S271203=7;
                                      S272600=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S272600=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S272595=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S272595=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S271203=8;
                                            S273106=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                              S273106=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S273101=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                S273101=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  S271203=9;
                                                  S273656=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                    S273656=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S273651=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                      S273651=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                        S271203=10;
                                                        S274250=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                          S274250=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S274245=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                            S274245=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                              S271203=11;
                                                              S274888=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                S274888=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S274883=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                  S274883=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                                    S271203=12;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
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
                unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 83, column: 6
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
        S271203=2;
        if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 91, column: 4
          if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 92, column: 11
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            ends[2]=2;
            ;//sysj\rotaryTableController.sysj line: 92, column: 5
            S271203=3;
            if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
              S271248=0;
              if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
                m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
                placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
                currsigs.addElement(placed_1);
                S271248=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
                currsigs.addElement(loadPos1);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              S271203=4;
              S271346=0;
              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                S271346=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S271341=0;
                if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                  startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                  S271341=1;
                  if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 120, column: 4
                    S271203=5;
                    S271720=0;
                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                      S271720=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S271715=0;
                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                        S271715=1;
                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 121, column: 4
                          S271203=6;
                          S272138=0;
                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                            S272138=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S272133=0;
                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                              S272133=1;
                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                S271203=7;
                                S272600=0;
                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                  S272600=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S272595=0;
                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S272595=1;
                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                      S271203=8;
                                      S273106=0;
                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                        S273106=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S273101=0;
                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                          S273101=1;
                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                            S271203=9;
                                            S273656=0;
                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                              S273656=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S273651=0;
                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                S273651=1;
                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                  S271203=10;
                                                  S274250=0;
                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                    S274250=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S274245=0;
                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      S274245=1;
                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                        S271203=11;
                                                        S274888=0;
                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                          S274888=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S274883=0;
                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            S274883=1;
                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                              S271203=12;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
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
          S271203=3;
          if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 94, column: 4
            S271248=0;
            if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 95, column: 21
              m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 98, column: 5
              placed_1.setPresent();//sysj\rotaryTableController.sysj line: 99, column: 5
              currsigs.addElement(placed_1);
              S271248=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 6
              currsigs.addElement(loadPos1);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
          }
          else {
            S271203=4;
            S271346=0;
            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
              S271346=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              S271341=0;
              if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 120, column: 4
                S271341=1;
                if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                  ends[2]=2;
                  ;//sysj\rotaryTableController.sysj line: 120, column: 4
                  S271203=5;
                  S271720=0;
                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 121, column: 4
                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                    S271720=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S271715=0;
                    if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                      startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 121, column: 4
                      S271715=1;
                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 121, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 121, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 121, column: 4
                        S271203=6;
                        S272138=0;
                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                          S272138=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S272133=0;
                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 122, column: 4
                            S272133=1;
                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                              S271203=7;
                              S272600=0;
                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                S272600=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S272595=0;
                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 123, column: 4
                                  S272595=1;
                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S271203=8;
                                    S273106=0;
                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                      S273106=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S273101=0;
                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                        S273101=1;
                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                          S271203=9;
                                          S273656=0;
                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                            S273656=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S273651=0;
                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 126, column: 4
                                              S273651=1;
                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 126, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 126, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 126, column: 4
                                                S271203=10;
                                                S274250=0;
                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                  S274250=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S274245=0;
                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                    S274245=1;
                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 127, column: 4
                                                      S271203=11;
                                                      S274888=0;
                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                        S274888=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S274883=0;
                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                          S274883=1;
                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 128, column: 4
                                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 131, column: 1
                                                            S271203=12;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
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
      switch(S298914){
        case 0 : 
          S298914=0;
          break RUN;
        
        case 1 : 
          S298914=2;
          S298914=2;
          placed_1.setClear();//sysj\rotaryTableController.sysj line: 57, column: 2
          thread298916(tdone,ends);
          thread298917(tdone,ends);
          int biggest298918 = 0;
          if(ends[2]>=biggest298918){
            biggest298918=ends[2];
          }
          if(ends[3]>=biggest298918){
            biggest298918=ends[3];
          }
          if(biggest298918 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          placed_1.setClear();//sysj\rotaryTableController.sysj line: 57, column: 2
          thread298919(tdone,ends);
          thread298920(tdone,ends);
          int biggest298921 = 0;
          if(ends[2]>=biggest298921){
            biggest298921=ends[2];
          }
          if(ends[3]>=biggest298921){
            biggest298921=ends[3];
          }
          if(biggest298921 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest298921 == 0){
            S298914=0;
            active[1]=0;
            ends[1]=0;
            S298914=0;
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
          operatorPermit.gethook();
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
      operatorPermit.setpreclear();
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
      dummyint = operatorPermit.getStatus() ? operatorPermit.setprepresent() : operatorPermit.setpreclear();
      operatorPermit.setpreval(operatorPermit.getValue());
      operatorPermit.setClear();
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
        operatorPermit.gethook();
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
