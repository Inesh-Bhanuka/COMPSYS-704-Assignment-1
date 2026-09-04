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
  private TableModel m_thread_2;//sysj/rotaryTableController.sysj line: 56, column: 3
  private Workpiece exiting_thread_2;//sysj/rotaryTableController.sysj line: 57, column: 3
  private TableModel m_thread_3;//sysj/rotaryTableController.sysj line: 137, column: 3
  private Workpiece w_thread_3;//sysj/rotaryTableController.sysj line: 138, column: 3
  private int S69149 = 1;
  private int S68983 = 1;
  private int S40886 = 1;
  private int S40700 = 1;
  private int S40707 = 1;
  private int S40702 = 1;
  private int S40931 = 1;
  private int S41029 = 1;
  private int S41024 = 1;
  private int S41403 = 1;
  private int S41398 = 1;
  private int S41821 = 1;
  private int S41816 = 1;
  private int S42283 = 1;
  private int S42278 = 1;
  private int S42789 = 1;
  private int S42784 = 1;
  private int S43339 = 1;
  private int S43334 = 1;
  private int S43933 = 1;
  private int S43928 = 1;
  private int S44571 = 1;
  private int S44566 = 1;
  private int S69147 = 1;
  private int S69007 = 1;
  private int S68991 = 1;
  private int S68986 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread69155(int [] tdone, int [] ends){
        switch(S69147){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S69007){
          case 0 : 
            switch(S68991){
              case 0 : 
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 140, column: 4
                  tableInfeed_in.setACK(false);//sysj/rotaryTableController.sysj line: 140, column: 4
                  S68991=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S68986){
                    case 0 : 
                      if(!tableInfeed_in.isREQ()){//sysj/rotaryTableController.sysj line: 140, column: 4
                        tableInfeed_in.setACK(true);//sysj/rotaryTableController.sysj line: 140, column: 4
                        S68986=1;
                        if(tableInfeed_in.isREQ()){//sysj/rotaryTableController.sysj line: 140, column: 4
                          tableInfeed_in.setACK(false);//sysj/rotaryTableController.sysj line: 140, column: 4
                          ends[3]=2;
                          ;//sysj/rotaryTableController.sysj line: 140, column: 4
                          w_thread_3 = (Workpiece)(tableInfeed_in.getVal() == null ? null : ((Workpiece)tableInfeed_in.getVal()));//sysj/rotaryTableController.sysj line: 141, column: 4
                          m_thread_3.setPending(w_thread_3);//sysj/rotaryTableController.sysj line: 142, column: 4
                          System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj/rotaryTableController.sysj line: 143, column: 4
                          S69007=1;
                          if(placed_1.getprestatus()){//sysj/rotaryTableController.sysj line: 144, column: 20
                            S69007=2;
                            active[3]=1;
                            ends[3]=1;
                            tdone[3]=1;
                          }
                          else {
                            active[3]=1;
                            ends[3]=1;
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
                      if(tableInfeed_in.isREQ()){//sysj/rotaryTableController.sysj line: 140, column: 4
                        tableInfeed_in.setACK(false);//sysj/rotaryTableController.sysj line: 140, column: 4
                        ends[3]=2;
                        ;//sysj/rotaryTableController.sysj line: 140, column: 4
                        w_thread_3 = (Workpiece)(tableInfeed_in.getVal() == null ? null : ((Workpiece)tableInfeed_in.getVal()));//sysj/rotaryTableController.sysj line: 141, column: 4
                        m_thread_3.setPending(w_thread_3);//sysj/rotaryTableController.sysj line: 142, column: 4
                        System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj/rotaryTableController.sysj line: 143, column: 4
                        S69007=1;
                        if(placed_1.getprestatus()){//sysj/rotaryTableController.sysj line: 144, column: 20
                          S69007=2;
                          active[3]=1;
                          ends[3]=1;
                          tdone[3]=1;
                        }
                        else {
                          active[3]=1;
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
                S68991=1;
                S68991=0;
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 140, column: 4
                  tableInfeed_in.setACK(false);//sysj/rotaryTableController.sysj line: 140, column: 4
                  S68991=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S68986=0;
                  if(!tableInfeed_in.isREQ()){//sysj/rotaryTableController.sysj line: 140, column: 4
                    tableInfeed_in.setACK(true);//sysj/rotaryTableController.sysj line: 140, column: 4
                    S68986=1;
                    if(tableInfeed_in.isREQ()){//sysj/rotaryTableController.sysj line: 140, column: 4
                      tableInfeed_in.setACK(false);//sysj/rotaryTableController.sysj line: 140, column: 4
                      ends[3]=2;
                      ;//sysj/rotaryTableController.sysj line: 140, column: 4
                      w_thread_3 = (Workpiece)(tableInfeed_in.getVal() == null ? null : ((Workpiece)tableInfeed_in.getVal()));//sysj/rotaryTableController.sysj line: 141, column: 4
                      m_thread_3.setPending(w_thread_3);//sysj/rotaryTableController.sysj line: 142, column: 4
                      System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj/rotaryTableController.sysj line: 143, column: 4
                      S69007=1;
                      if(placed_1.getprestatus()){//sysj/rotaryTableController.sysj line: 144, column: 20
                        S69007=2;
                        active[3]=1;
                        ends[3]=1;
                        tdone[3]=1;
                      }
                      else {
                        active[3]=1;
                        ends[3]=1;
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
            if(placed_1.getprestatus()){//sysj/rotaryTableController.sysj line: 144, column: 20
              S69007=2;
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
            S69007=2;
            S69007=0;
            S68991=0;
            if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 140, column: 4
              tableInfeed_in.setACK(false);//sysj/rotaryTableController.sysj line: 140, column: 4
              S68991=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S68986=0;
              if(!tableInfeed_in.isREQ()){//sysj/rotaryTableController.sysj line: 140, column: 4
                tableInfeed_in.setACK(true);//sysj/rotaryTableController.sysj line: 140, column: 4
                S68986=1;
                if(tableInfeed_in.isREQ()){//sysj/rotaryTableController.sysj line: 140, column: 4
                  tableInfeed_in.setACK(false);//sysj/rotaryTableController.sysj line: 140, column: 4
                  ends[3]=2;
                  ;//sysj/rotaryTableController.sysj line: 140, column: 4
                  w_thread_3 = (Workpiece)(tableInfeed_in.getVal() == null ? null : ((Workpiece)tableInfeed_in.getVal()));//sysj/rotaryTableController.sysj line: 141, column: 4
                  m_thread_3.setPending(w_thread_3);//sysj/rotaryTableController.sysj line: 142, column: 4
                  System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj/rotaryTableController.sysj line: 143, column: 4
                  S69007=1;
                  if(placed_1.getprestatus()){//sysj/rotaryTableController.sysj line: 144, column: 20
                    S69007=2;
                    active[3]=1;
                    ends[3]=1;
                    tdone[3]=1;
                  }
                  else {
                    active[3]=1;
                    ends[3]=1;
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

  public void thread69154(int [] tdone, int [] ends){
        switch(S68983){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S40886){
          case 0 : 
            if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 61, column: 20
              S40886=1;
              if(m_thread_2.exitOccupied()){//sysj/rotaryTableController.sysj line: 69, column: 4
                exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj/rotaryTableController.sysj line: 70, column: 5
                m_thread_2.sayUnloading();//sysj/rotaryTableController.sysj line: 71, column: 5
                S40700=0;
                S40707=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 72, column: 5
                  tableOutfeed_o.setREQ(false);//sysj/rotaryTableController.sysj line: 72, column: 5
                  S40707=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S40702=0;
                  if(tableOutfeed_o.isACK()){//sysj/rotaryTableController.sysj line: 72, column: 5
                    tableOutfeed_o.setVal(exiting_thread_2);//sysj/rotaryTableController.sysj line: 72, column: 5
                    S40702=1;
                    if(!tableOutfeed_o.isACK()){//sysj/rotaryTableController.sysj line: 72, column: 5
                      tableOutfeed_o.setREQ(false);//sysj/rotaryTableController.sysj line: 72, column: 5
                      ends[2]=2;
                      ;//sysj/rotaryTableController.sysj line: 72, column: 5
                      S40700=1;
                      if(exitCleared.getprestatus()){//sysj/rotaryTableController.sysj line: 73, column: 21
                        m_thread_2.clearExit();//sysj/rotaryTableController.sysj line: 76, column: 5
                        S40886=2;
                        if(m_thread_2.idle()){//sysj/rotaryTableController.sysj line: 82, column: 4
                          if(!m_thread_2.hasPending()){//sysj/rotaryTableController.sysj line: 83, column: 11
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 83, column: 5
                            S40886=3;
                            if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                              S40931=0;
                              if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                                m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                                placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                                currsigs.addElement(placed_1);
                                S40931=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                                currsigs.addElement(loadPos1);
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              S40886=4;
                              S41029=0;
                              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                S41029=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S41024=0;
                                if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                  startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                                  S41024=1;
                                  if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                    startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                    ends[2]=2;
                                    ;//sysj/rotaryTableController.sysj line: 111, column: 4
                                    S40886=5;
                                    S41403=0;
                                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                      startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                      S41403=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S41398=0;
                                      if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                        startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                                        S41398=1;
                                        if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                          startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                          ends[2]=2;
                                          ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                          S40886=6;
                                          S41821=0;
                                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                            startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                            S41821=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S41816=0;
                                            if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                              startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                              S41816=1;
                                              if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                                ends[2]=2;
                                                ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                                S40886=7;
                                                S42283=0;
                                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                  startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                  S42283=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S42278=0;
                                                  if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                    startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                                    S42278=1;
                                                    if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                      startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                                      S40886=8;
                                                      S42789=0;
                                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                        doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                        S42789=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S42784=0;
                                                        if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                          doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                          S42784=1;
                                                          if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                            doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                            S40886=9;
                                                            S43339=0;
                                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                              doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                              S43339=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S43334=0;
                                                              if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                S43334=1;
                                                                if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                  S40886=10;
                                                                  S43933=0;
                                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                    doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                    S43933=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S43928=0;
                                                                    if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                      doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                      S43928=1;
                                                                      if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                        doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                        S40886=11;
                                                                        S44571=0;
                                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                          doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                          S44571=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S44566=0;
                                                                          if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                            doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                            S44566=1;
                                                                            if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                              doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                              S40886=12;
                                                                              if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                                S40886=13;
                                                                                if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                                  m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                                  m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                                  S40886=14;
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
                                                                                rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                          S40886=3;
                          if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                            S40931=0;
                            if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                              m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                              placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                              currsigs.addElement(placed_1);
                              S40931=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                              currsigs.addElement(loadPos1);
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            S40886=4;
                            S41029=0;
                            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                              startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                              S41029=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S41024=0;
                              if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                                S41024=1;
                                if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                  startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                  ends[2]=2;
                                  ;//sysj/rotaryTableController.sysj line: 111, column: 4
                                  S40886=5;
                                  S41403=0;
                                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                    startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                    S41403=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S41398=0;
                                    if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                      startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                                      S41398=1;
                                      if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                        startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                        ends[2]=2;
                                        ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                        S40886=6;
                                        S41821=0;
                                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                          startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                          S41821=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S41816=0;
                                          if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                            startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                            S41816=1;
                                            if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                              startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                              ends[2]=2;
                                              ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                              S40886=7;
                                              S42283=0;
                                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                S42283=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S42278=0;
                                                if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                  startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                                  S42278=1;
                                                  if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                    startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                                    S40886=8;
                                                    S42789=0;
                                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                      doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                      S42789=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S42784=0;
                                                      if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                        doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                        S42784=1;
                                                        if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                          doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                          S40886=9;
                                                          S43339=0;
                                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                            doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                            S43339=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S43334=0;
                                                            if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                              doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                              S43334=1;
                                                              if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                S40886=10;
                                                                S43933=0;
                                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                  doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                  S43933=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S43928=0;
                                                                  if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                    doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                    S43928=1;
                                                                    if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                      doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                      S40886=11;
                                                                      S44571=0;
                                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                        doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                        S44571=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S44566=0;
                                                                        if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                          doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                          S44566=1;
                                                                          if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                            doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                            S40886=12;
                                                                            if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                              S40886=13;
                                                                              if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                                m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                                m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                                S40886=14;
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
                                                                              rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                        unloadExit.setPresent();//sysj/rotaryTableController.sysj line: 74, column: 6
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
                S40886=2;
                if(m_thread_2.idle()){//sysj/rotaryTableController.sysj line: 82, column: 4
                  if(!m_thread_2.hasPending()){//sysj/rotaryTableController.sysj line: 83, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj/rotaryTableController.sysj line: 83, column: 5
                    S40886=3;
                    if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                      S40931=0;
                      if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                        m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                        placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                        currsigs.addElement(placed_1);
                        S40931=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S40886=4;
                      S41029=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                        startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                        S41029=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S41024=0;
                        if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                          S41024=1;
                          if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                            startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 111, column: 4
                            S40886=5;
                            S41403=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                              startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                              S41403=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S41398=0;
                              if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                                S41398=1;
                                if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                  startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                  ends[2]=2;
                                  ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                  S40886=6;
                                  S41821=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                    startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                    S41821=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S41816=0;
                                    if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                      S41816=1;
                                      if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                        startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                        ends[2]=2;
                                        ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                        S40886=7;
                                        S42283=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                          startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                          S42283=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S42278=0;
                                          if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                            S42278=1;
                                            if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                              startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                              ends[2]=2;
                                              ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                              S40886=8;
                                              S42789=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                S42789=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S42784=0;
                                                if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  S42784=1;
                                                  if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                    doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                    S40886=9;
                                                    S43339=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      S43339=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S43334=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        S43334=1;
                                                        if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                          doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                          S40886=10;
                                                          S43933=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            S43933=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S43928=0;
                                                            if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              S43928=1;
                                                              if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                S40886=11;
                                                                S44571=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  S44571=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S44566=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    S44566=1;
                                                                    if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                      doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                      S40886=12;
                                                                      if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                        S40886=13;
                                                                        if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                          m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                          m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                          S40886=14;
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
                                                                        rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                  S40886=3;
                  if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                    S40931=0;
                    if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                      m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                      placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                      currsigs.addElement(placed_1);
                      S40931=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S40886=4;
                    S41029=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                      startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                      S41029=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S41024=0;
                      if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                        S41024=1;
                        if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                          startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                          ends[2]=2;
                          ;//sysj/rotaryTableController.sysj line: 111, column: 4
                          S40886=5;
                          S41403=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                            startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                            S41403=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S41398=0;
                            if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                              S41398=1;
                              if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                ends[2]=2;
                                ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                S40886=6;
                                S41821=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                  startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                  S41821=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S41816=0;
                                  if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                    S41816=1;
                                    if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                      startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                      ends[2]=2;
                                      ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                      S40886=7;
                                      S42283=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                        startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                        S42283=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S42278=0;
                                        if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                          S42278=1;
                                          if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                            startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                            ends[2]=2;
                                            ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                            S40886=8;
                                            S42789=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                              S42789=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S42784=0;
                                              if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                S42784=1;
                                                if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  S40886=9;
                                                  S43339=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    S43339=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S43334=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      S43334=1;
                                                      if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        S40886=10;
                                                        S43933=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          S43933=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S43928=0;
                                                          if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            S43928=1;
                                                            if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              S40886=11;
                                                              S44571=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                S44571=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S44566=0;
                                                                if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  S44566=1;
                                                                  if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    S40886=12;
                                                                    if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                      S40886=13;
                                                                      if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                        m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                        m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                        S40886=14;
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
                                                                      rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
            switch(S40700){
              case 0 : 
                switch(S40707){
                  case 0 : 
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 72, column: 5
                      tableOutfeed_o.setREQ(false);//sysj/rotaryTableController.sysj line: 72, column: 5
                      S40707=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      switch(S40702){
                        case 0 : 
                          if(tableOutfeed_o.isACK()){//sysj/rotaryTableController.sysj line: 72, column: 5
                            tableOutfeed_o.setVal(exiting_thread_2);//sysj/rotaryTableController.sysj line: 72, column: 5
                            S40702=1;
                            if(!tableOutfeed_o.isACK()){//sysj/rotaryTableController.sysj line: 72, column: 5
                              tableOutfeed_o.setREQ(false);//sysj/rotaryTableController.sysj line: 72, column: 5
                              ends[2]=2;
                              ;//sysj/rotaryTableController.sysj line: 72, column: 5
                              S40700=1;
                              if(exitCleared.getprestatus()){//sysj/rotaryTableController.sysj line: 73, column: 21
                                m_thread_2.clearExit();//sysj/rotaryTableController.sysj line: 76, column: 5
                                S40886=2;
                                if(m_thread_2.idle()){//sysj/rotaryTableController.sysj line: 82, column: 4
                                  if(!m_thread_2.hasPending()){//sysj/rotaryTableController.sysj line: 83, column: 11
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    ends[2]=2;
                                    ;//sysj/rotaryTableController.sysj line: 83, column: 5
                                    S40886=3;
                                    if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                                      S40931=0;
                                      if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                                        m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                                        placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                                        currsigs.addElement(placed_1);
                                        S40931=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                                        currsigs.addElement(loadPos1);
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      S40886=4;
                                      S41029=0;
                                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                        startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                        S41029=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S41024=0;
                                        if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                          startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                                          S41024=1;
                                          if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                            startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                            ends[2]=2;
                                            ;//sysj/rotaryTableController.sysj line: 111, column: 4
                                            S40886=5;
                                            S41403=0;
                                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                              startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                              S41403=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S41398=0;
                                              if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                                startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                                                S41398=1;
                                                if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                                  startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                                  S40886=6;
                                                  S41821=0;
                                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                    startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                                    S41821=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S41816=0;
                                                    if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                      startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                                      S41816=1;
                                                      if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                        startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                                        S40886=7;
                                                        S42283=0;
                                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                          startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                          S42283=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S42278=0;
                                                          if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                            startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                                            S42278=1;
                                                            if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                              startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                                              S40886=8;
                                                              S42789=0;
                                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                S42789=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S42784=0;
                                                                if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                  doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                  S42784=1;
                                                                  if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                    doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                    S40886=9;
                                                                    S43339=0;
                                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                      S43339=1;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      S43334=0;
                                                                      if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                        doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                        S43334=1;
                                                                        if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                          doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                          ends[2]=2;
                                                                          ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                          S40886=10;
                                                                          S43933=0;
                                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                            doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                            S43933=1;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S43928=0;
                                                                            if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                              doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                              S43928=1;
                                                                              if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                                doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                                ends[2]=2;
                                                                                ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                                S40886=11;
                                                                                S44571=0;
                                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                  S44571=1;
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                                else {
                                                                                  S44566=0;
                                                                                  if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                    doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                    S44566=1;
                                                                                    if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                      doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                      ends[2]=2;
                                                                                      ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                      S40886=12;
                                                                                      if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                                        S40886=13;
                                                                                        if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                                          m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                                          m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                                          S40886=14;
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
                                                                                        rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                                  S40886=3;
                                  if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                                    S40931=0;
                                    if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                                      m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                                      placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                                      currsigs.addElement(placed_1);
                                      S40931=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                                      currsigs.addElement(loadPos1);
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    S40886=4;
                                    S41029=0;
                                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                      startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                      S41029=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S41024=0;
                                      if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                        startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                                        S41024=1;
                                        if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                          startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                          ends[2]=2;
                                          ;//sysj/rotaryTableController.sysj line: 111, column: 4
                                          S40886=5;
                                          S41403=0;
                                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                            startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                            S41403=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S41398=0;
                                            if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                              startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                                              S41398=1;
                                              if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                                startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                                ends[2]=2;
                                                ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                                S40886=6;
                                                S41821=0;
                                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                  startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                                  S41821=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S41816=0;
                                                  if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                    startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                                    S41816=1;
                                                    if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                      startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                                      S40886=7;
                                                      S42283=0;
                                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                        startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                        S42283=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S42278=0;
                                                        if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                          startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                                          S42278=1;
                                                          if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                            startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                                            S40886=8;
                                                            S42789=0;
                                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                              doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                              S42789=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S42784=0;
                                                              if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                S42784=1;
                                                                if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                  doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                  S40886=9;
                                                                  S43339=0;
                                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                    S43339=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S43334=0;
                                                                    if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                      doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                      S43334=1;
                                                                      if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                        doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                        S40886=10;
                                                                        S43933=0;
                                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                          doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                          S43933=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S43928=0;
                                                                          if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                            doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                            S43928=1;
                                                                            if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                              doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                              S40886=11;
                                                                              S44571=0;
                                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                S44571=1;
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                              else {
                                                                                S44566=0;
                                                                                if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                  doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                  S44566=1;
                                                                                  if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                    doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                    ends[2]=2;
                                                                                    ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                    S40886=12;
                                                                                    if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                                      S40886=13;
                                                                                      if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                                        m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                                        m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                                        S40886=14;
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
                                                                                      rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                                unloadExit.setPresent();//sysj/rotaryTableController.sysj line: 74, column: 6
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
                          if(!tableOutfeed_o.isACK()){//sysj/rotaryTableController.sysj line: 72, column: 5
                            tableOutfeed_o.setREQ(false);//sysj/rotaryTableController.sysj line: 72, column: 5
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 72, column: 5
                            S40700=1;
                            if(exitCleared.getprestatus()){//sysj/rotaryTableController.sysj line: 73, column: 21
                              m_thread_2.clearExit();//sysj/rotaryTableController.sysj line: 76, column: 5
                              S40886=2;
                              if(m_thread_2.idle()){//sysj/rotaryTableController.sysj line: 82, column: 4
                                if(!m_thread_2.hasPending()){//sysj/rotaryTableController.sysj line: 83, column: 11
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  ends[2]=2;
                                  ;//sysj/rotaryTableController.sysj line: 83, column: 5
                                  S40886=3;
                                  if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                                    S40931=0;
                                    if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                                      m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                                      placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                                      currsigs.addElement(placed_1);
                                      S40931=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                                      currsigs.addElement(loadPos1);
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    S40886=4;
                                    S41029=0;
                                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                      startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                      S41029=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S41024=0;
                                      if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                        startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                                        S41024=1;
                                        if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                          startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                          ends[2]=2;
                                          ;//sysj/rotaryTableController.sysj line: 111, column: 4
                                          S40886=5;
                                          S41403=0;
                                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                            startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                            S41403=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S41398=0;
                                            if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                              startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                                              S41398=1;
                                              if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                                startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                                ends[2]=2;
                                                ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                                S40886=6;
                                                S41821=0;
                                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                  startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                                  S41821=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S41816=0;
                                                  if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                    startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                                    S41816=1;
                                                    if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                      startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                                      S40886=7;
                                                      S42283=0;
                                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                        startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                        S42283=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S42278=0;
                                                        if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                          startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                                          S42278=1;
                                                          if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                            startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                                            S40886=8;
                                                            S42789=0;
                                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                              doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                              S42789=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S42784=0;
                                                              if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                S42784=1;
                                                                if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                  doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                  S40886=9;
                                                                  S43339=0;
                                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                    S43339=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S43334=0;
                                                                    if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                      doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                      S43334=1;
                                                                      if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                        doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                        S40886=10;
                                                                        S43933=0;
                                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                          doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                          S43933=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S43928=0;
                                                                          if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                            doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                            S43928=1;
                                                                            if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                              doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                              S40886=11;
                                                                              S44571=0;
                                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                S44571=1;
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                              else {
                                                                                S44566=0;
                                                                                if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                  doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                  S44566=1;
                                                                                  if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                    doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                    ends[2]=2;
                                                                                    ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                    S40886=12;
                                                                                    if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                                      S40886=13;
                                                                                      if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                                        m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                                        m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                                        S40886=14;
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
                                                                                      rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                                S40886=3;
                                if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                                  S40931=0;
                                  if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                                    m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                                    placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                                    currsigs.addElement(placed_1);
                                    S40931=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                                    currsigs.addElement(loadPos1);
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  S40886=4;
                                  S41029=0;
                                  if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                    startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                    S41029=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S41024=0;
                                    if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                      startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                                      S41024=1;
                                      if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                        startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                        ends[2]=2;
                                        ;//sysj/rotaryTableController.sysj line: 111, column: 4
                                        S40886=5;
                                        S41403=0;
                                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                          startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                          S41403=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S41398=0;
                                          if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                            startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                                            S41398=1;
                                            if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                              startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                              ends[2]=2;
                                              ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                              S40886=6;
                                              S41821=0;
                                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                                S41821=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S41816=0;
                                                if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                  startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                                  S41816=1;
                                                  if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                    startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                                    S40886=7;
                                                    S42283=0;
                                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                      startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                      S42283=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S42278=0;
                                                      if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                        startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                                        S42278=1;
                                                        if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                          startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                                          S40886=8;
                                                          S42789=0;
                                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                            doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                            S42789=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S42784=0;
                                                            if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                              doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                              S42784=1;
                                                              if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                S40886=9;
                                                                S43339=0;
                                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                  S43339=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S43334=0;
                                                                  if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                    doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                    S43334=1;
                                                                    if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                      S40886=10;
                                                                      S43933=0;
                                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                        doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                        S43933=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S43928=0;
                                                                        if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                          doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                          S43928=1;
                                                                          if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                            doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                            S40886=11;
                                                                            S44571=0;
                                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                              doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                              S44571=1;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              S44566=0;
                                                                              if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                S44566=1;
                                                                                if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                  ends[2]=2;
                                                                                  ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                  S40886=12;
                                                                                  if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                                    S40886=13;
                                                                                    if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                                      m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                                      m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                                      S40886=14;
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
                                                                                    rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                              unloadExit.setPresent();//sysj/rotaryTableController.sysj line: 74, column: 6
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
                    S40707=1;
                    S40707=0;
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 72, column: 5
                      tableOutfeed_o.setREQ(false);//sysj/rotaryTableController.sysj line: 72, column: 5
                      S40707=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S40702=0;
                      if(tableOutfeed_o.isACK()){//sysj/rotaryTableController.sysj line: 72, column: 5
                        tableOutfeed_o.setVal(exiting_thread_2);//sysj/rotaryTableController.sysj line: 72, column: 5
                        S40702=1;
                        if(!tableOutfeed_o.isACK()){//sysj/rotaryTableController.sysj line: 72, column: 5
                          tableOutfeed_o.setREQ(false);//sysj/rotaryTableController.sysj line: 72, column: 5
                          ends[2]=2;
                          ;//sysj/rotaryTableController.sysj line: 72, column: 5
                          S40700=1;
                          if(exitCleared.getprestatus()){//sysj/rotaryTableController.sysj line: 73, column: 21
                            m_thread_2.clearExit();//sysj/rotaryTableController.sysj line: 76, column: 5
                            S40886=2;
                            if(m_thread_2.idle()){//sysj/rotaryTableController.sysj line: 82, column: 4
                              if(!m_thread_2.hasPending()){//sysj/rotaryTableController.sysj line: 83, column: 11
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                ends[2]=2;
                                ;//sysj/rotaryTableController.sysj line: 83, column: 5
                                S40886=3;
                                if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                                  S40931=0;
                                  if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                                    m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                                    placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                                    currsigs.addElement(placed_1);
                                    S40931=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                                    currsigs.addElement(loadPos1);
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  S40886=4;
                                  S41029=0;
                                  if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                    startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                    S41029=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S41024=0;
                                    if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                      startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                                      S41024=1;
                                      if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                        startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                        ends[2]=2;
                                        ;//sysj/rotaryTableController.sysj line: 111, column: 4
                                        S40886=5;
                                        S41403=0;
                                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                          startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                          S41403=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S41398=0;
                                          if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                            startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                                            S41398=1;
                                            if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                              startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                              ends[2]=2;
                                              ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                              S40886=6;
                                              S41821=0;
                                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                                S41821=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S41816=0;
                                                if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                  startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                                  S41816=1;
                                                  if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                    startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                                    S40886=7;
                                                    S42283=0;
                                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                      startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                      S42283=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S42278=0;
                                                      if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                        startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                                        S42278=1;
                                                        if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                          startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                                          S40886=8;
                                                          S42789=0;
                                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                            doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                            S42789=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S42784=0;
                                                            if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                              doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                              S42784=1;
                                                              if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                                S40886=9;
                                                                S43339=0;
                                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                  S43339=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S43334=0;
                                                                  if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                    doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                    S43334=1;
                                                                    if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                      S40886=10;
                                                                      S43933=0;
                                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                        doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                        S43933=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S43928=0;
                                                                        if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                          doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                          S43928=1;
                                                                          if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                            doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                            S40886=11;
                                                                            S44571=0;
                                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                              doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                              S44571=1;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              S44566=0;
                                                                              if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                S44566=1;
                                                                                if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                  ends[2]=2;
                                                                                  ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                  S40886=12;
                                                                                  if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                                    S40886=13;
                                                                                    if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                                      m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                                      m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                                      S40886=14;
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
                                                                                    rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                              S40886=3;
                              if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                                S40931=0;
                                if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                                  m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                                  placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                                  currsigs.addElement(placed_1);
                                  S40931=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                                  currsigs.addElement(loadPos1);
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                S40886=4;
                                S41029=0;
                                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                  startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                  S41029=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S41024=0;
                                  if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                    startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                                    S41024=1;
                                    if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                      startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                      ends[2]=2;
                                      ;//sysj/rotaryTableController.sysj line: 111, column: 4
                                      S40886=5;
                                      S41403=0;
                                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                        startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                        S41403=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S41398=0;
                                        if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                          startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                                          S41398=1;
                                          if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                            startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                            ends[2]=2;
                                            ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                            S40886=6;
                                            S41821=0;
                                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                              startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                              S41821=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S41816=0;
                                              if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                                S41816=1;
                                                if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                  startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                                  S40886=7;
                                                  S42283=0;
                                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                    startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                    S42283=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S42278=0;
                                                    if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                      startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                                      S42278=1;
                                                      if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                        startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                                        S40886=8;
                                                        S42789=0;
                                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                          doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                          S42789=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S42784=0;
                                                          if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                            doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                            S42784=1;
                                                            if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                              doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                              S40886=9;
                                                              S43339=0;
                                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                S43339=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S43334=0;
                                                                if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                  doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                  S43334=1;
                                                                  if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                    S40886=10;
                                                                    S43933=0;
                                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                      doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                      S43933=1;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      S43928=0;
                                                                      if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                        doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                        S43928=1;
                                                                        if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                          doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                          ends[2]=2;
                                                                          ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                          S40886=11;
                                                                          S44571=0;
                                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                            doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                            S44571=1;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S44566=0;
                                                                            if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                              doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                              S44566=1;
                                                                              if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                ends[2]=2;
                                                                                ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                                S40886=12;
                                                                                if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                                  S40886=13;
                                                                                  if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                                    m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                                    m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                                    S40886=14;
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
                                                                                  rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                            unloadExit.setPresent();//sysj/rotaryTableController.sysj line: 74, column: 6
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
                if(exitCleared.getprestatus()){//sysj/rotaryTableController.sysj line: 73, column: 21
                  m_thread_2.clearExit();//sysj/rotaryTableController.sysj line: 76, column: 5
                  S40886=2;
                  if(m_thread_2.idle()){//sysj/rotaryTableController.sysj line: 82, column: 4
                    if(!m_thread_2.hasPending()){//sysj/rotaryTableController.sysj line: 83, column: 11
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      ends[2]=2;
                      ;//sysj/rotaryTableController.sysj line: 83, column: 5
                      S40886=3;
                      if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                        S40931=0;
                        if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                          m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                          placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                          currsigs.addElement(placed_1);
                          S40931=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                          currsigs.addElement(loadPos1);
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        S40886=4;
                        S41029=0;
                        if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                          startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                          S41029=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S41024=0;
                          if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                            startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                            S41024=1;
                            if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                              startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                              ends[2]=2;
                              ;//sysj/rotaryTableController.sysj line: 111, column: 4
                              S40886=5;
                              S41403=0;
                              if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                S41403=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S41398=0;
                                if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                  startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                                  S41398=1;
                                  if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                    startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                    ends[2]=2;
                                    ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                    S40886=6;
                                    S41821=0;
                                    if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                      startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                      S41821=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S41816=0;
                                      if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                        startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                        S41816=1;
                                        if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                          startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                          ends[2]=2;
                                          ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                          S40886=7;
                                          S42283=0;
                                          if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                            startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                            S42283=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S42278=0;
                                            if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                              startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                              S42278=1;
                                              if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                ends[2]=2;
                                                ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                                S40886=8;
                                                S42789=0;
                                                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  S42789=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S42784=0;
                                                  if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                    doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                    S42784=1;
                                                    if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                      doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                      S40886=9;
                                                      S43339=0;
                                                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        S43339=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S43334=0;
                                                        if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                          doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                          S43334=1;
                                                          if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                            doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                            S40886=10;
                                                            S43933=0;
                                                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              S43933=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S43928=0;
                                                              if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                S43928=1;
                                                                if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                  doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                  S40886=11;
                                                                  S44571=0;
                                                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    S44571=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S44566=0;
                                                                    if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                      doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                      S44566=1;
                                                                      if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                        doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                        S40886=12;
                                                                        if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                          S40886=13;
                                                                          if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                            m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                            m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                            S40886=14;
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
                                                                          rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                    S40886=3;
                    if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                      S40931=0;
                      if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                        m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                        placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                        currsigs.addElement(placed_1);
                        S40931=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S40886=4;
                      S41029=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                        startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                        S41029=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S41024=0;
                        if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                          S41024=1;
                          if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                            startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 111, column: 4
                            S40886=5;
                            S41403=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                              startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                              S41403=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S41398=0;
                              if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                                S41398=1;
                                if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                  startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                  ends[2]=2;
                                  ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                  S40886=6;
                                  S41821=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                    startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                    S41821=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S41816=0;
                                    if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                      S41816=1;
                                      if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                        startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                        ends[2]=2;
                                        ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                        S40886=7;
                                        S42283=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                          startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                          S42283=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S42278=0;
                                          if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                            S42278=1;
                                            if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                              startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                              ends[2]=2;
                                              ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                              S40886=8;
                                              S42789=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                S42789=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S42784=0;
                                                if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  S42784=1;
                                                  if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                    doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                    S40886=9;
                                                    S43339=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      S43339=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S43334=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        S43334=1;
                                                        if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                          doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                          S40886=10;
                                                          S43933=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            S43933=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S43928=0;
                                                            if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              S43928=1;
                                                              if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                S40886=11;
                                                                S44571=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  S44571=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S44566=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    S44566=1;
                                                                    if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                      doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                      S40886=12;
                                                                      if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                        S40886=13;
                                                                        if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                          m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                          m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                          S40886=14;
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
                                                                        rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                  unloadExit.setPresent();//sysj/rotaryTableController.sysj line: 74, column: 6
                  currsigs.addElement(unloadExit);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
          case 2 : 
            if(!m_thread_2.hasPending()){//sysj/rotaryTableController.sysj line: 83, column: 11
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              ends[2]=2;
              ;//sysj/rotaryTableController.sysj line: 83, column: 5
              S40886=3;
              if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                S40931=0;
                if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                  m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                  placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                  currsigs.addElement(placed_1);
                  S40931=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                  currsigs.addElement(loadPos1);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
              else {
                S40886=4;
                S41029=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                  startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                  S41029=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S41024=0;
                  if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                    startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                    S41024=1;
                    if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                      startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                      ends[2]=2;
                      ;//sysj/rotaryTableController.sysj line: 111, column: 4
                      S40886=5;
                      S41403=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                        startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                        S41403=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S41398=0;
                        if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                          startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                          S41398=1;
                          if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                            startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 112, column: 4
                            S40886=6;
                            S41821=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                              startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                              S41821=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S41816=0;
                              if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                S41816=1;
                                if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                  startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                  ends[2]=2;
                                  ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                  S40886=7;
                                  S42283=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                    startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                    S42283=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S42278=0;
                                    if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                      startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                      S42278=1;
                                      if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                        startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                        ends[2]=2;
                                        ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                        S40886=8;
                                        S42789=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                          doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                          S42789=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S42784=0;
                                          if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                            doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                            S42784=1;
                                            if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                              ends[2]=2;
                                              ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                              S40886=9;
                                              S43339=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                S43339=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S43334=0;
                                                if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                  doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                  S43334=1;
                                                  if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    S40886=10;
                                                    S43933=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      S43933=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S43928=0;
                                                      if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                        doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                        S43928=1;
                                                        if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          S40886=11;
                                                          S44571=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            S44571=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S44566=0;
                                                            if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                              doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                              S44566=1;
                                                              if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                S40886=12;
                                                                if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                  S40886=13;
                                                                  if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                    m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                    m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                    S40886=14;
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
                                                                  rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
            switch(S40931){
              case 0 : 
                if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                  m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                  placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                  currsigs.addElement(placed_1);
                  S40931=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                  currsigs.addElement(loadPos1);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S40931=1;
                S40886=4;
                S41029=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                  startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                  S41029=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S41024=0;
                  if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                    startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                    S41024=1;
                    if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                      startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                      ends[2]=2;
                      ;//sysj/rotaryTableController.sysj line: 111, column: 4
                      S40886=5;
                      S41403=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                        startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                        S41403=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S41398=0;
                        if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                          startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                          S41398=1;
                          if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                            startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 112, column: 4
                            S40886=6;
                            S41821=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                              startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                              S41821=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S41816=0;
                              if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                S41816=1;
                                if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                  startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                  ends[2]=2;
                                  ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                  S40886=7;
                                  S42283=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                    startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                    S42283=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S42278=0;
                                    if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                      startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                      S42278=1;
                                      if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                        startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                        ends[2]=2;
                                        ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                        S40886=8;
                                        S42789=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                          doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                          S42789=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S42784=0;
                                          if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                            doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                            S42784=1;
                                            if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                              ends[2]=2;
                                              ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                              S40886=9;
                                              S43339=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                S43339=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S43334=0;
                                                if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                  doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                  S43334=1;
                                                  if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    S40886=10;
                                                    S43933=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      S43933=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S43928=0;
                                                      if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                        doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                        S43928=1;
                                                        if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          S40886=11;
                                                          S44571=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            S44571=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S44566=0;
                                                            if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                              doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                              S44566=1;
                                                              if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                S40886=12;
                                                                if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                  S40886=13;
                                                                  if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                    m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                    m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                    S40886=14;
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
                                                                  rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
            switch(S41029){
              case 0 : 
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                  startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                  S41029=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S41024){
                    case 0 : 
                      if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                        S41024=1;
                        if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                          startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                          ends[2]=2;
                          ;//sysj/rotaryTableController.sysj line: 111, column: 4
                          S40886=5;
                          S41403=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                            startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                            S41403=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S41398=0;
                            if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                              S41398=1;
                              if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                ends[2]=2;
                                ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                S40886=6;
                                S41821=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                  startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                  S41821=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S41816=0;
                                  if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                    S41816=1;
                                    if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                      startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                      ends[2]=2;
                                      ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                      S40886=7;
                                      S42283=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                        startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                        S42283=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S42278=0;
                                        if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                          S42278=1;
                                          if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                            startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                            ends[2]=2;
                                            ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                            S40886=8;
                                            S42789=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                              S42789=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S42784=0;
                                              if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                S42784=1;
                                                if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  S40886=9;
                                                  S43339=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    S43339=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S43334=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      S43334=1;
                                                      if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        S40886=10;
                                                        S43933=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          S43933=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S43928=0;
                                                          if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            S43928=1;
                                                            if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              S40886=11;
                                                              S44571=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                S44571=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S44566=0;
                                                                if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  S44566=1;
                                                                  if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    S40886=12;
                                                                    if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                      S40886=13;
                                                                      if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                        m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                        m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                        S40886=14;
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
                                                                      rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                      if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                        startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                        ends[2]=2;
                        ;//sysj/rotaryTableController.sysj line: 111, column: 4
                        S40886=5;
                        S41403=0;
                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                          startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                          S41403=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S41398=0;
                          if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                            startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                            S41398=1;
                            if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                              startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                              ends[2]=2;
                              ;//sysj/rotaryTableController.sysj line: 112, column: 4
                              S40886=6;
                              S41821=0;
                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                S41821=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S41816=0;
                                if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                  startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                  S41816=1;
                                  if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                    startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                    ends[2]=2;
                                    ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                    S40886=7;
                                    S42283=0;
                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                      startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                      S42283=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S42278=0;
                                      if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                        startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                        S42278=1;
                                        if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                          startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                          ends[2]=2;
                                          ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                          S40886=8;
                                          S42789=0;
                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                            doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                            S42789=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S42784=0;
                                            if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                              S42784=1;
                                              if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                ends[2]=2;
                                                ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                S40886=9;
                                                S43339=0;
                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                  doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                  S43339=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S43334=0;
                                                  if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    S43334=1;
                                                    if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      S40886=10;
                                                      S43933=0;
                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                        doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                        S43933=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S43928=0;
                                                        if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          S43928=1;
                                                          if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            S40886=11;
                                                            S44571=0;
                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                              doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                              S44571=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S44566=0;
                                                              if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                S44566=1;
                                                                if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  S40886=12;
                                                                  if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                    S40886=13;
                                                                    if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                      m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                      m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                      S40886=14;
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
                                                                    rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                S41029=1;
                S41029=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                  startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                  S41029=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S41024=0;
                  if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                    startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                    S41024=1;
                    if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                      startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                      ends[2]=2;
                      ;//sysj/rotaryTableController.sysj line: 111, column: 4
                      S40886=5;
                      S41403=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                        startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                        S41403=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S41398=0;
                        if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                          startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                          S41398=1;
                          if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                            startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 112, column: 4
                            S40886=6;
                            S41821=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                              startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                              S41821=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S41816=0;
                              if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                S41816=1;
                                if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                  startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                  ends[2]=2;
                                  ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                  S40886=7;
                                  S42283=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                    startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                    S42283=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S42278=0;
                                    if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                      startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                      S42278=1;
                                      if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                        startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                        ends[2]=2;
                                        ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                        S40886=8;
                                        S42789=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                          doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                          S42789=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S42784=0;
                                          if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                            doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                            S42784=1;
                                            if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                              ends[2]=2;
                                              ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                              S40886=9;
                                              S43339=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                S43339=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S43334=0;
                                                if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                  doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                  S43334=1;
                                                  if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    S40886=10;
                                                    S43933=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      S43933=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S43928=0;
                                                      if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                        doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                        S43928=1;
                                                        if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          S40886=11;
                                                          S44571=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            S44571=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S44566=0;
                                                            if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                              doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                              S44566=1;
                                                              if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                S40886=12;
                                                                if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                  S40886=13;
                                                                  if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                    m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                    m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                    S40886=14;
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
                                                                  rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
            switch(S41403){
              case 0 : 
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                  startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                  S41403=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S41398){
                    case 0 : 
                      if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                        startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                        S41398=1;
                        if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                          startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                          ends[2]=2;
                          ;//sysj/rotaryTableController.sysj line: 112, column: 4
                          S40886=6;
                          S41821=0;
                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                            startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                            S41821=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S41816=0;
                            if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                              startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                              S41816=1;
                              if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                ends[2]=2;
                                ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                S40886=7;
                                S42283=0;
                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                  startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                  S42283=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S42278=0;
                                  if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                    startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                    S42278=1;
                                    if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                      startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                      ends[2]=2;
                                      ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                      S40886=8;
                                      S42789=0;
                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                        doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                        S42789=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S42784=0;
                                        if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                          doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                          S42784=1;
                                          if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                            doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                            ends[2]=2;
                                            ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                            S40886=9;
                                            S43339=0;
                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                              doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                              S43339=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S43334=0;
                                              if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                S43334=1;
                                                if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                  doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                  S40886=10;
                                                  S43933=0;
                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                    doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                    S43933=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S43928=0;
                                                    if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      S43928=1;
                                                      if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                        doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                        S40886=11;
                                                        S44571=0;
                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                          doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                          S44571=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S44566=0;
                                                          if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            S44566=1;
                                                            if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                              doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                              S40886=12;
                                                              if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                S40886=13;
                                                                if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                  m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                  m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                  S40886=14;
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
                                                                rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                      if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                        startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                        ends[2]=2;
                        ;//sysj/rotaryTableController.sysj line: 112, column: 4
                        S40886=6;
                        S41821=0;
                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                          startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                          S41821=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S41816=0;
                          if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                            startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                            S41816=1;
                            if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                              startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                              ends[2]=2;
                              ;//sysj/rotaryTableController.sysj line: 113, column: 4
                              S40886=7;
                              S42283=0;
                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                S42283=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S42278=0;
                                if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                  startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                  S42278=1;
                                  if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                    startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                    ends[2]=2;
                                    ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                    S40886=8;
                                    S42789=0;
                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                      doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                      S42789=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S42784=0;
                                      if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                        doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                        S42784=1;
                                        if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                          doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                          ends[2]=2;
                                          ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                          S40886=9;
                                          S43339=0;
                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                            doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                            S43339=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S43334=0;
                                            if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                              doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                              S43334=1;
                                              if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                ends[2]=2;
                                                ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                S40886=10;
                                                S43933=0;
                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                  doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                  S43933=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S43928=0;
                                                  if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                    doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                    S43928=1;
                                                    if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      S40886=11;
                                                      S44571=0;
                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                        doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                        S44571=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S44566=0;
                                                        if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                          doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                          S44566=1;
                                                          if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            S40886=12;
                                                            if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                              S40886=13;
                                                              if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                S40886=14;
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
                                                              rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                S41403=1;
                S41403=0;
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                  startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                  S41403=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S41398=0;
                  if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                    startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                    S41398=1;
                    if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                      startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                      ends[2]=2;
                      ;//sysj/rotaryTableController.sysj line: 112, column: 4
                      S40886=6;
                      S41821=0;
                      if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                        startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                        S41821=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S41816=0;
                        if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                          startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                          S41816=1;
                          if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                            startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 113, column: 4
                            S40886=7;
                            S42283=0;
                            if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                              startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                              S42283=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S42278=0;
                              if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                S42278=1;
                                if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                  startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                  ends[2]=2;
                                  ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                  S40886=8;
                                  S42789=0;
                                  if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                    doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                    S42789=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S42784=0;
                                    if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                      doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                      S42784=1;
                                      if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                        doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                        ends[2]=2;
                                        ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                        S40886=9;
                                        S43339=0;
                                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                          doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                          S43339=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S43334=0;
                                          if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                            doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                            S43334=1;
                                            if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                              doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                              ends[2]=2;
                                              ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                              S40886=10;
                                              S43933=0;
                                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                S43933=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S43928=0;
                                                if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                  doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                  S43928=1;
                                                  if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                    doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                    S40886=11;
                                                    S44571=0;
                                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                      doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                      S44571=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S44566=0;
                                                      if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                        doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                        S44566=1;
                                                        if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                          doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                          S40886=12;
                                                          if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                            S40886=13;
                                                            if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                              m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                              m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                              S40886=14;
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
                                                            rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
            switch(S41821){
              case 0 : 
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                  startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                  S41821=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S41816){
                    case 0 : 
                      if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                        startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                        S41816=1;
                        if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                          startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                          ends[2]=2;
                          ;//sysj/rotaryTableController.sysj line: 113, column: 4
                          S40886=7;
                          S42283=0;
                          if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                            startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                            S42283=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S42278=0;
                            if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                              startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                              S42278=1;
                              if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                ends[2]=2;
                                ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                S40886=8;
                                S42789=0;
                                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                  doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                  S42789=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S42784=0;
                                  if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                    doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                    S42784=1;
                                    if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                      doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                      ends[2]=2;
                                      ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                      S40886=9;
                                      S43339=0;
                                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                        doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                        S43339=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S43334=0;
                                        if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                          doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                          S43334=1;
                                          if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                            doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                            ends[2]=2;
                                            ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                            S40886=10;
                                            S43933=0;
                                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                              doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                              S43933=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S43928=0;
                                              if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                S43928=1;
                                                if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                  doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                  S40886=11;
                                                  S44571=0;
                                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                    doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                    S44571=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S44566=0;
                                                    if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                      doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                      S44566=1;
                                                      if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                        doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                        S40886=12;
                                                        if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                          S40886=13;
                                                          if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                            m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                            m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                            S40886=14;
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
                                                          rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                      if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                        startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                        ends[2]=2;
                        ;//sysj/rotaryTableController.sysj line: 113, column: 4
                        S40886=7;
                        S42283=0;
                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                          startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                          S42283=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S42278=0;
                          if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                            startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                            S42278=1;
                            if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                              startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                              ends[2]=2;
                              ;//sysj/rotaryTableController.sysj line: 114, column: 4
                              S40886=8;
                              S42789=0;
                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                S42789=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S42784=0;
                                if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                  doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                  S42784=1;
                                  if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                    doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                    ends[2]=2;
                                    ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                    S40886=9;
                                    S43339=0;
                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                      doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                      S43339=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S43334=0;
                                      if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                        doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                        S43334=1;
                                        if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                          doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                          ends[2]=2;
                                          ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                          S40886=10;
                                          S43933=0;
                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                            doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                            S43933=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S43928=0;
                                            if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                              doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                              S43928=1;
                                              if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                ends[2]=2;
                                                ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                S40886=11;
                                                S44571=0;
                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                  doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                  S44571=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S44566=0;
                                                  if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                    doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                    S44566=1;
                                                    if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                      doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                      S40886=12;
                                                      if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                        S40886=13;
                                                        if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                          m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                          m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                          S40886=14;
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
                                                        rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                S41821=1;
                S41821=0;
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                  startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                  S41821=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S41816=0;
                  if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                    startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                    S41816=1;
                    if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                      startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                      ends[2]=2;
                      ;//sysj/rotaryTableController.sysj line: 113, column: 4
                      S40886=7;
                      S42283=0;
                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                        startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                        S42283=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S42278=0;
                        if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                          startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                          S42278=1;
                          if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                            startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 114, column: 4
                            S40886=8;
                            S42789=0;
                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                              doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                              S42789=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S42784=0;
                              if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                S42784=1;
                                if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                  doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                  ends[2]=2;
                                  ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                  S40886=9;
                                  S43339=0;
                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                    doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                    S43339=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S43334=0;
                                    if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                      doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                      S43334=1;
                                      if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                        doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                        ends[2]=2;
                                        ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                        S40886=10;
                                        S43933=0;
                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                          doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                          S43933=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S43928=0;
                                          if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                            doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                            S43928=1;
                                            if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                              doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                              ends[2]=2;
                                              ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                              S40886=11;
                                              S44571=0;
                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                S44571=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S44566=0;
                                                if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                  doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                  S44566=1;
                                                  if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                    doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                    S40886=12;
                                                    if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                      S40886=13;
                                                      if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                        m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                        m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                        S40886=14;
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
                                                      rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
            switch(S42283){
              case 0 : 
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                  startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                  S42283=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S42278){
                    case 0 : 
                      if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                        startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                        S42278=1;
                        if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                          startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                          ends[2]=2;
                          ;//sysj/rotaryTableController.sysj line: 114, column: 4
                          S40886=8;
                          S42789=0;
                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                            doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                            S42789=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S42784=0;
                            if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                              doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                              S42784=1;
                              if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                ends[2]=2;
                                ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                S40886=9;
                                S43339=0;
                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                  doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                  S43339=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S43334=0;
                                  if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                    doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                    S43334=1;
                                    if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                      doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                      ends[2]=2;
                                      ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                      S40886=10;
                                      S43933=0;
                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                        doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                        S43933=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S43928=0;
                                        if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                          doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                          S43928=1;
                                          if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                            doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                            ends[2]=2;
                                            ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                            S40886=11;
                                            S44571=0;
                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                              doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                              S44571=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S44566=0;
                                              if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                S44566=1;
                                                if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                  doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                  S40886=12;
                                                  if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                    S40886=13;
                                                    if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                      m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                      m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                      S40886=14;
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
                                                    rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                      if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                        startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                        ends[2]=2;
                        ;//sysj/rotaryTableController.sysj line: 114, column: 4
                        S40886=8;
                        S42789=0;
                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                          doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                          S42789=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S42784=0;
                          if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                            doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                            S42784=1;
                            if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                              doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                              ends[2]=2;
                              ;//sysj/rotaryTableController.sysj line: 116, column: 4
                              S40886=9;
                              S43339=0;
                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                S43339=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S43334=0;
                                if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                  doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                  S43334=1;
                                  if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                    doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                    ends[2]=2;
                                    ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                    S40886=10;
                                    S43933=0;
                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                      doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                      S43933=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S43928=0;
                                      if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                        doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                        S43928=1;
                                        if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                          doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                          ends[2]=2;
                                          ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                          S40886=11;
                                          S44571=0;
                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                            doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                            S44571=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S44566=0;
                                            if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                              doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                              S44566=1;
                                              if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                ends[2]=2;
                                                ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                S40886=12;
                                                if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                  S40886=13;
                                                  if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                    m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                    m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                    S40886=14;
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
                                                  rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                S42283=1;
                S42283=0;
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                  startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                  S42283=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S42278=0;
                  if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                    startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                    S42278=1;
                    if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                      startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                      ends[2]=2;
                      ;//sysj/rotaryTableController.sysj line: 114, column: 4
                      S40886=8;
                      S42789=0;
                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                        doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                        S42789=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S42784=0;
                        if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                          doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                          S42784=1;
                          if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                            doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 116, column: 4
                            S40886=9;
                            S43339=0;
                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                              doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                              S43339=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S43334=0;
                              if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                S43334=1;
                                if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                  doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                  ends[2]=2;
                                  ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                  S40886=10;
                                  S43933=0;
                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                    doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                    S43933=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S43928=0;
                                    if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                      doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                      S43928=1;
                                      if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                        doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                        ends[2]=2;
                                        ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                        S40886=11;
                                        S44571=0;
                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                          doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                          S44571=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S44566=0;
                                          if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                            doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                            S44566=1;
                                            if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                              doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                              ends[2]=2;
                                              ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                              S40886=12;
                                              if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                S40886=13;
                                                if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                  m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                  m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                  S40886=14;
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
                                                rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
            switch(S42789){
              case 0 : 
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                  doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                  S42789=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S42784){
                    case 0 : 
                      if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                        doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                        S42784=1;
                        if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                          doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                          ends[2]=2;
                          ;//sysj/rotaryTableController.sysj line: 116, column: 4
                          S40886=9;
                          S43339=0;
                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                            doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                            S43339=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S43334=0;
                            if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                              doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                              S43334=1;
                              if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                ends[2]=2;
                                ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                S40886=10;
                                S43933=0;
                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                  doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                  S43933=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S43928=0;
                                  if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                    doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                    S43928=1;
                                    if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                      doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                      ends[2]=2;
                                      ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                      S40886=11;
                                      S44571=0;
                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                        doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                        S44571=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S44566=0;
                                        if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                          doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                          S44566=1;
                                          if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                            doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                            ends[2]=2;
                                            ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                            S40886=12;
                                            if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                              S40886=13;
                                              if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                S40886=14;
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
                                              rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                      if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                        doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                        ends[2]=2;
                        ;//sysj/rotaryTableController.sysj line: 116, column: 4
                        S40886=9;
                        S43339=0;
                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                          doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                          S43339=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S43334=0;
                          if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                            doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                            S43334=1;
                            if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                              doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                              ends[2]=2;
                              ;//sysj/rotaryTableController.sysj line: 117, column: 4
                              S40886=10;
                              S43933=0;
                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                S43933=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S43928=0;
                                if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                  doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                  S43928=1;
                                  if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                    doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                    ends[2]=2;
                                    ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                    S40886=11;
                                    S44571=0;
                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                      doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                      S44571=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S44566=0;
                                      if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                        doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                        S44566=1;
                                        if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                          doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                          ends[2]=2;
                                          ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                          S40886=12;
                                          if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                            S40886=13;
                                            if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                              m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                              m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                              S40886=14;
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
                                            rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                S42789=1;
                S42789=0;
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                  doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                  S42789=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S42784=0;
                  if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                    doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                    S42784=1;
                    if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                      doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                      ends[2]=2;
                      ;//sysj/rotaryTableController.sysj line: 116, column: 4
                      S40886=9;
                      S43339=0;
                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                        doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                        S43339=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S43334=0;
                        if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                          doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                          S43334=1;
                          if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                            doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 117, column: 4
                            S40886=10;
                            S43933=0;
                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                              doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                              S43933=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S43928=0;
                              if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                S43928=1;
                                if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                  doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                  ends[2]=2;
                                  ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                  S40886=11;
                                  S44571=0;
                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                    doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                    S44571=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S44566=0;
                                    if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                      doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                      S44566=1;
                                      if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                        doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                        ends[2]=2;
                                        ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                        S40886=12;
                                        if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                          S40886=13;
                                          if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                            m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                            m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                            S40886=14;
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
                                          rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
            switch(S43339){
              case 0 : 
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                  doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                  S43339=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S43334){
                    case 0 : 
                      if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                        doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                        S43334=1;
                        if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                          doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                          ends[2]=2;
                          ;//sysj/rotaryTableController.sysj line: 117, column: 4
                          S40886=10;
                          S43933=0;
                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                            doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                            S43933=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S43928=0;
                            if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                              doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                              S43928=1;
                              if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                ends[2]=2;
                                ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                S40886=11;
                                S44571=0;
                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                  doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                  S44571=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S44566=0;
                                  if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                    doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                    S44566=1;
                                    if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                      doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                      ends[2]=2;
                                      ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                      S40886=12;
                                      if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                        S40886=13;
                                        if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                          m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                          m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                          S40886=14;
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
                                        rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                      if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                        doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                        ends[2]=2;
                        ;//sysj/rotaryTableController.sysj line: 117, column: 4
                        S40886=10;
                        S43933=0;
                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                          doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                          S43933=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S43928=0;
                          if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                            doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                            S43928=1;
                            if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                              doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                              ends[2]=2;
                              ;//sysj/rotaryTableController.sysj line: 118, column: 4
                              S40886=11;
                              S44571=0;
                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                S44571=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S44566=0;
                                if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                  doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                  S44566=1;
                                  if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                    doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                    ends[2]=2;
                                    ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                    S40886=12;
                                    if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                      S40886=13;
                                      if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                        m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                        m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                        S40886=14;
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
                                      rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                S43339=1;
                S43339=0;
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                  doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                  S43339=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S43334=0;
                  if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                    doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                    S43334=1;
                    if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                      doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                      ends[2]=2;
                      ;//sysj/rotaryTableController.sysj line: 117, column: 4
                      S40886=10;
                      S43933=0;
                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                        doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                        S43933=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S43928=0;
                        if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                          doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                          S43928=1;
                          if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                            doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 118, column: 4
                            S40886=11;
                            S44571=0;
                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                              doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                              S44571=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S44566=0;
                              if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                S44566=1;
                                if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                  doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                  ends[2]=2;
                                  ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                  S40886=12;
                                  if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                    S40886=13;
                                    if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                      m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                      m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                      S40886=14;
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
                                    rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
            switch(S43933){
              case 0 : 
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                  doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                  S43933=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S43928){
                    case 0 : 
                      if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                        doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                        S43928=1;
                        if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                          doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                          ends[2]=2;
                          ;//sysj/rotaryTableController.sysj line: 118, column: 4
                          S40886=11;
                          S44571=0;
                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                            doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                            S44571=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S44566=0;
                            if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                              doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                              S44566=1;
                              if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                ends[2]=2;
                                ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                S40886=12;
                                if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                  S40886=13;
                                  if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                    m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                    m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                    S40886=14;
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
                                  rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                      if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                        doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                        ends[2]=2;
                        ;//sysj/rotaryTableController.sysj line: 118, column: 4
                        S40886=11;
                        S44571=0;
                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                          doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                          S44571=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S44566=0;
                          if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                            doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                            S44566=1;
                            if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                              doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                              ends[2]=2;
                              ;//sysj/rotaryTableController.sysj line: 119, column: 4
                              S40886=12;
                              if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                S40886=13;
                                if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                  m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                  m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                  S40886=14;
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
                                rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                S43933=1;
                S43933=0;
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                  doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                  S43933=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S43928=0;
                  if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                    doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                    S43928=1;
                    if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                      doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                      ends[2]=2;
                      ;//sysj/rotaryTableController.sysj line: 118, column: 4
                      S40886=11;
                      S44571=0;
                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                        doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                        S44571=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S44566=0;
                        if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                          doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                          S44566=1;
                          if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                            doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 119, column: 4
                            S40886=12;
                            if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                              S40886=13;
                              if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                S40886=14;
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
                              rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
            switch(S44571){
              case 0 : 
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                  doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                  S44571=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S44566){
                    case 0 : 
                      if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                        doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                        S44566=1;
                        if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                          doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                          ends[2]=2;
                          ;//sysj/rotaryTableController.sysj line: 119, column: 4
                          S40886=12;
                          if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                            S40886=13;
                            if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                              m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                              m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                              S40886=14;
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
                            rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                      if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                        doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                        ends[2]=2;
                        ;//sysj/rotaryTableController.sysj line: 119, column: 4
                        S40886=12;
                        if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                          S40886=13;
                          if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                            m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                            m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                            S40886=14;
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
                          rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                S44571=1;
                S44571=0;
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                  doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                  S44571=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S44566=0;
                  if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                    doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                    S44566=1;
                    if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                      doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                      ends[2]=2;
                      ;//sysj/rotaryTableController.sysj line: 119, column: 4
                      S40886=12;
                      if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                        S40886=13;
                        if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                          m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                          m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                          S40886=14;
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
                        rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
            if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
              S40886=13;
              if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                S40886=14;
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
              rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
              currsigs.addElement(rotaryTrigger);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 13 : 
            if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
              m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
              m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
              S40886=14;
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
          
          case 14 : 
            S40886=14;
            S40886=0;
            if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 61, column: 20
              S40886=1;
              if(m_thread_2.exitOccupied()){//sysj/rotaryTableController.sysj line: 69, column: 4
                exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj/rotaryTableController.sysj line: 70, column: 5
                m_thread_2.sayUnloading();//sysj/rotaryTableController.sysj line: 71, column: 5
                S40700=0;
                S40707=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 72, column: 5
                  tableOutfeed_o.setREQ(false);//sysj/rotaryTableController.sysj line: 72, column: 5
                  S40707=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S40702=0;
                  if(tableOutfeed_o.isACK()){//sysj/rotaryTableController.sysj line: 72, column: 5
                    tableOutfeed_o.setVal(exiting_thread_2);//sysj/rotaryTableController.sysj line: 72, column: 5
                    S40702=1;
                    if(!tableOutfeed_o.isACK()){//sysj/rotaryTableController.sysj line: 72, column: 5
                      tableOutfeed_o.setREQ(false);//sysj/rotaryTableController.sysj line: 72, column: 5
                      ends[2]=2;
                      ;//sysj/rotaryTableController.sysj line: 72, column: 5
                      S40700=1;
                      if(exitCleared.getprestatus()){//sysj/rotaryTableController.sysj line: 73, column: 21
                        m_thread_2.clearExit();//sysj/rotaryTableController.sysj line: 76, column: 5
                        S40886=2;
                        if(m_thread_2.idle()){//sysj/rotaryTableController.sysj line: 82, column: 4
                          if(!m_thread_2.hasPending()){//sysj/rotaryTableController.sysj line: 83, column: 11
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 83, column: 5
                            S40886=3;
                            if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                              S40931=0;
                              if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                                m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                                placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                                currsigs.addElement(placed_1);
                                S40931=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                                currsigs.addElement(loadPos1);
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              S40886=4;
                              S41029=0;
                              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                S41029=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S41024=0;
                                if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                  startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                                  S41024=1;
                                  if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                    startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                    ends[2]=2;
                                    ;//sysj/rotaryTableController.sysj line: 111, column: 4
                                    S40886=5;
                                    S41403=0;
                                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                      startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                      S41403=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S41398=0;
                                      if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                        startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                                        S41398=1;
                                        if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                          startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                          ends[2]=2;
                                          ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                          S40886=6;
                                          S41821=0;
                                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                            startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                            S41821=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S41816=0;
                                            if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                              startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                              S41816=1;
                                              if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                                startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                                ends[2]=2;
                                                ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                                S40886=7;
                                                S42283=0;
                                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                  startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                  S42283=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S42278=0;
                                                  if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                    startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                                    S42278=1;
                                                    if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                      startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                                      S40886=8;
                                                      S42789=0;
                                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                        doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                        S42789=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S42784=0;
                                                        if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                          doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                          S42784=1;
                                                          if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                            doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                            S40886=9;
                                                            S43339=0;
                                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                              doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                              S43339=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S43334=0;
                                                              if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                S43334=1;
                                                                if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                  S40886=10;
                                                                  S43933=0;
                                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                    doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                    S43933=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S43928=0;
                                                                    if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                      doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                      S43928=1;
                                                                      if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                        doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                        S40886=11;
                                                                        S44571=0;
                                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                          doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                          S44571=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S44566=0;
                                                                          if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                            doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                            S44566=1;
                                                                            if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                              doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                              S40886=12;
                                                                              if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                                S40886=13;
                                                                                if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                                  m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                                  m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                                  S40886=14;
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
                                                                                rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                          S40886=3;
                          if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                            S40931=0;
                            if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                              m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                              placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                              currsigs.addElement(placed_1);
                              S40931=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                              currsigs.addElement(loadPos1);
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            S40886=4;
                            S41029=0;
                            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                              startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                              S41029=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S41024=0;
                              if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                                S41024=1;
                                if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                                  startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                                  ends[2]=2;
                                  ;//sysj/rotaryTableController.sysj line: 111, column: 4
                                  S40886=5;
                                  S41403=0;
                                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                    startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                    S41403=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S41398=0;
                                    if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                      startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                                      S41398=1;
                                      if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                        startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                        ends[2]=2;
                                        ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                        S40886=6;
                                        S41821=0;
                                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                          startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                          S41821=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S41816=0;
                                          if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                            startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                            S41816=1;
                                            if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                              startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                              ends[2]=2;
                                              ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                              S40886=7;
                                              S42283=0;
                                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                S42283=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S42278=0;
                                                if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                  startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                                  S42278=1;
                                                  if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                                    startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                                    S40886=8;
                                                    S42789=0;
                                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                      doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                      S42789=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S42784=0;
                                                      if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                        doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                        S42784=1;
                                                        if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                          doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                          S40886=9;
                                                          S43339=0;
                                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                            doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                            S43339=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S43334=0;
                                                            if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                              doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                              S43334=1;
                                                              if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                                S40886=10;
                                                                S43933=0;
                                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                  doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                  S43933=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S43928=0;
                                                                  if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                    doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                    S43928=1;
                                                                    if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                      doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                      S40886=11;
                                                                      S44571=0;
                                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                        doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                        S44571=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S44566=0;
                                                                        if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                          doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                          S44566=1;
                                                                          if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                            doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                            S40886=12;
                                                                            if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                              S40886=13;
                                                                              if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                                m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                                m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                                S40886=14;
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
                                                                              rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                        unloadExit.setPresent();//sysj/rotaryTableController.sysj line: 74, column: 6
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
                S40886=2;
                if(m_thread_2.idle()){//sysj/rotaryTableController.sysj line: 82, column: 4
                  if(!m_thread_2.hasPending()){//sysj/rotaryTableController.sysj line: 83, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj/rotaryTableController.sysj line: 83, column: 5
                    S40886=3;
                    if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                      S40931=0;
                      if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                        m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                        placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                        currsigs.addElement(placed_1);
                        S40931=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S40886=4;
                      S41029=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                        startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                        S41029=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S41024=0;
                        if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                          S41024=1;
                          if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                            startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 111, column: 4
                            S40886=5;
                            S41403=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                              startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                              S41403=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S41398=0;
                              if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                                S41398=1;
                                if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                  startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                  ends[2]=2;
                                  ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                  S40886=6;
                                  S41821=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                    startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                    S41821=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S41816=0;
                                    if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                      S41816=1;
                                      if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                        startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                        ends[2]=2;
                                        ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                        S40886=7;
                                        S42283=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                          startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                          S42283=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S42278=0;
                                          if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                            S42278=1;
                                            if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                              startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                              ends[2]=2;
                                              ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                              S40886=8;
                                              S42789=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                S42789=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S42784=0;
                                                if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  S42784=1;
                                                  if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                    doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                    S40886=9;
                                                    S43339=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      S43339=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S43334=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        S43334=1;
                                                        if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                          doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                          S40886=10;
                                                          S43933=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            S43933=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S43928=0;
                                                            if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              S43928=1;
                                                              if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                S40886=11;
                                                                S44571=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  S44571=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S44566=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    S44566=1;
                                                                    if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                      doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                      S40886=12;
                                                                      if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                        S40886=13;
                                                                        if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                          m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                          m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                          S40886=14;
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
                                                                        rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                  S40886=3;
                  if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                    S40931=0;
                    if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                      m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                      placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                      currsigs.addElement(placed_1);
                      S40931=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S40886=4;
                    S41029=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                      startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                      S41029=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S41024=0;
                      if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                        S41024=1;
                        if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                          startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                          ends[2]=2;
                          ;//sysj/rotaryTableController.sysj line: 111, column: 4
                          S40886=5;
                          S41403=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                            startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                            S41403=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S41398=0;
                            if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                              S41398=1;
                              if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                ends[2]=2;
                                ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                S40886=6;
                                S41821=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                  startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                  S41821=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S41816=0;
                                  if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                    S41816=1;
                                    if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                      startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                      ends[2]=2;
                                      ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                      S40886=7;
                                      S42283=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                        startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                        S42283=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S42278=0;
                                        if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                          S42278=1;
                                          if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                            startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                            ends[2]=2;
                                            ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                            S40886=8;
                                            S42789=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                              S42789=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S42784=0;
                                              if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                S42784=1;
                                                if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  S40886=9;
                                                  S43339=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    S43339=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S43334=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      S43334=1;
                                                      if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        S40886=10;
                                                        S43933=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          S43933=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S43928=0;
                                                          if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            S43928=1;
                                                            if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              S40886=11;
                                                              S44571=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                S44571=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S44566=0;
                                                                if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  S44566=1;
                                                                  if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    S40886=12;
                                                                    if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                      S40886=13;
                                                                      if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                        m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                        m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                        S40886=14;
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
                                                                      rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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

  public void thread69152(int [] tdone, int [] ends){
        S69147=1;
    m_thread_3 = TableModel.shared();//sysj/rotaryTableController.sysj line: 137, column: 3
    w_thread_3 = null;//sysj/rotaryTableController.sysj line: 138, column: 3
    S69007=0;
    S68991=0;
    if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 140, column: 4
      tableInfeed_in.setACK(false);//sysj/rotaryTableController.sysj line: 140, column: 4
      S68991=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S68986=0;
      if(!tableInfeed_in.isREQ()){//sysj/rotaryTableController.sysj line: 140, column: 4
        tableInfeed_in.setACK(true);//sysj/rotaryTableController.sysj line: 140, column: 4
        S68986=1;
        if(tableInfeed_in.isREQ()){//sysj/rotaryTableController.sysj line: 140, column: 4
          tableInfeed_in.setACK(false);//sysj/rotaryTableController.sysj line: 140, column: 4
          ends[3]=2;
          ;//sysj/rotaryTableController.sysj line: 140, column: 4
          w_thread_3 = (Workpiece)(tableInfeed_in.getVal() == null ? null : ((Workpiece)tableInfeed_in.getVal()));//sysj/rotaryTableController.sysj line: 141, column: 4
          m_thread_3.setPending(w_thread_3);//sysj/rotaryTableController.sysj line: 142, column: 4
          System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj/rotaryTableController.sysj line: 143, column: 4
          S69007=1;
          if(placed_1.getprestatus()){//sysj/rotaryTableController.sysj line: 144, column: 20
            S69007=2;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
          }
          else {
            active[3]=1;
            ends[3]=1;
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

  public void thread69151(int [] tdone, int [] ends){
        S68983=1;
    m_thread_2 = TableModel.shared();//sysj/rotaryTableController.sysj line: 56, column: 3
    exiting_thread_2 = null;//sysj/rotaryTableController.sysj line: 57, column: 3
    S40886=0;
    if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 61, column: 20
      S40886=1;
      if(m_thread_2.exitOccupied()){//sysj/rotaryTableController.sysj line: 69, column: 4
        exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj/rotaryTableController.sysj line: 70, column: 5
        m_thread_2.sayUnloading();//sysj/rotaryTableController.sysj line: 71, column: 5
        S40700=0;
        S40707=0;
        if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 72, column: 5
          tableOutfeed_o.setREQ(false);//sysj/rotaryTableController.sysj line: 72, column: 5
          S40707=1;
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          S40702=0;
          if(tableOutfeed_o.isACK()){//sysj/rotaryTableController.sysj line: 72, column: 5
            tableOutfeed_o.setVal(exiting_thread_2);//sysj/rotaryTableController.sysj line: 72, column: 5
            S40702=1;
            if(!tableOutfeed_o.isACK()){//sysj/rotaryTableController.sysj line: 72, column: 5
              tableOutfeed_o.setREQ(false);//sysj/rotaryTableController.sysj line: 72, column: 5
              ends[2]=2;
              ;//sysj/rotaryTableController.sysj line: 72, column: 5
              S40700=1;
              if(exitCleared.getprestatus()){//sysj/rotaryTableController.sysj line: 73, column: 21
                m_thread_2.clearExit();//sysj/rotaryTableController.sysj line: 76, column: 5
                S40886=2;
                if(m_thread_2.idle()){//sysj/rotaryTableController.sysj line: 82, column: 4
                  if(!m_thread_2.hasPending()){//sysj/rotaryTableController.sysj line: 83, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj/rotaryTableController.sysj line: 83, column: 5
                    S40886=3;
                    if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                      S40931=0;
                      if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                        m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                        placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                        currsigs.addElement(placed_1);
                        S40931=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S40886=4;
                      S41029=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                        startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                        S41029=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S41024=0;
                        if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                          S41024=1;
                          if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                            startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                            ends[2]=2;
                            ;//sysj/rotaryTableController.sysj line: 111, column: 4
                            S40886=5;
                            S41403=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                              startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                              S41403=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S41398=0;
                              if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                                S41398=1;
                                if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                  startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                  ends[2]=2;
                                  ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                  S40886=6;
                                  S41821=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                    startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                    S41821=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S41816=0;
                                    if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                      S41816=1;
                                      if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                        startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                        ends[2]=2;
                                        ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                        S40886=7;
                                        S42283=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                          startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                          S42283=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S42278=0;
                                          if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                            S42278=1;
                                            if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                              startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                              ends[2]=2;
                                              ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                              S40886=8;
                                              S42789=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                S42789=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S42784=0;
                                                if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  S42784=1;
                                                  if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                    doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                    ends[2]=2;
                                                    ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                    S40886=9;
                                                    S43339=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      S43339=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S43334=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        S43334=1;
                                                        if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                          doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                          ends[2]=2;
                                                          ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                          S40886=10;
                                                          S43933=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            S43933=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S43928=0;
                                                            if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              S43928=1;
                                                              if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                ends[2]=2;
                                                                ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                                S40886=11;
                                                                S44571=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  S44571=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S44566=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    S44566=1;
                                                                    if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                      doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                      S40886=12;
                                                                      if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                        S40886=13;
                                                                        if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                          m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                          m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                          S40886=14;
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
                                                                        rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                  S40886=3;
                  if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
                    S40931=0;
                    if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                      m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                      placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                      currsigs.addElement(placed_1);
                      S40931=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S40886=4;
                    S41029=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                      startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                      S41029=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S41024=0;
                      if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                        S41024=1;
                        if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                          startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                          ends[2]=2;
                          ;//sysj/rotaryTableController.sysj line: 111, column: 4
                          S40886=5;
                          S41403=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                            startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                            S41403=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S41398=0;
                            if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                              S41398=1;
                              if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                                startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                                ends[2]=2;
                                ;//sysj/rotaryTableController.sysj line: 112, column: 4
                                S40886=6;
                                S41821=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                  startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                  S41821=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S41816=0;
                                  if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                                    S41816=1;
                                    if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                      startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                      ends[2]=2;
                                      ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                      S40886=7;
                                      S42283=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                        startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                        S42283=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S42278=0;
                                        if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                          S42278=1;
                                          if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                            startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                            ends[2]=2;
                                            ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                            S40886=8;
                                            S42789=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                              doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                              S42789=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S42784=0;
                                              if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                S42784=1;
                                                if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                                  S40886=9;
                                                  S43339=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                    S43339=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S43334=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                      S43334=1;
                                                      if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                        S40886=10;
                                                        S43933=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                          S43933=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S43928=0;
                                                          if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                            S43928=1;
                                                            if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                              S40886=11;
                                                              S44571=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                S44571=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S44566=0;
                                                                if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                  S44566=1;
                                                                  if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                                    S40886=12;
                                                                    if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                      S40886=13;
                                                                      if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                        m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                        m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                        S40886=14;
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
                                                                      rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
                unloadExit.setPresent();//sysj/rotaryTableController.sysj line: 74, column: 6
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
        S40886=2;
        if(m_thread_2.idle()){//sysj/rotaryTableController.sysj line: 82, column: 4
          if(!m_thread_2.hasPending()){//sysj/rotaryTableController.sysj line: 83, column: 11
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            ends[2]=2;
            ;//sysj/rotaryTableController.sysj line: 83, column: 5
            S40886=3;
            if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
              S40931=0;
              if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
                m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
                placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
                currsigs.addElement(placed_1);
                S40931=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
                currsigs.addElement(loadPos1);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              S40886=4;
              S41029=0;
              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
                startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                S41029=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S41024=0;
                if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                  startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                  S41024=1;
                  if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                    startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                    ends[2]=2;
                    ;//sysj/rotaryTableController.sysj line: 111, column: 4
                    S40886=5;
                    S41403=0;
                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                      startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                      S41403=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S41398=0;
                      if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                        startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                        S41398=1;
                        if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                          startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                          ends[2]=2;
                          ;//sysj/rotaryTableController.sysj line: 112, column: 4
                          S40886=6;
                          S41821=0;
                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                            startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                            S41821=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S41816=0;
                            if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                              startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                              S41816=1;
                              if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                                startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                                ends[2]=2;
                                ;//sysj/rotaryTableController.sysj line: 113, column: 4
                                S40886=7;
                                S42283=0;
                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                  startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                  S42283=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S42278=0;
                                  if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                    startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                    S42278=1;
                                    if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                      startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                      ends[2]=2;
                                      ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                      S40886=8;
                                      S42789=0;
                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                        doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                        S42789=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S42784=0;
                                        if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                          doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                          S42784=1;
                                          if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                            doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                            ends[2]=2;
                                            ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                            S40886=9;
                                            S43339=0;
                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                              doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                              S43339=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S43334=0;
                                              if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                S43334=1;
                                                if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                  doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                  ends[2]=2;
                                                  ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                  S40886=10;
                                                  S43933=0;
                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                    doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                    S43933=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S43928=0;
                                                    if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      S43928=1;
                                                      if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                        doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                        ends[2]=2;
                                                        ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                        S40886=11;
                                                        S44571=0;
                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                          doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                          S44571=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S44566=0;
                                                          if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            S44566=1;
                                                            if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                              doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                              ends[2]=2;
                                                              ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                              S40886=12;
                                                              if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                                S40886=13;
                                                                if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                  m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                  m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                  S40886=14;
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
                                                                rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
          S40886=3;
          if(m_thread_2.readyToPlace()){//sysj/rotaryTableController.sysj line: 85, column: 4
            S40931=0;
            if(bottleAtPos1.getprestatus()){//sysj/rotaryTableController.sysj line: 86, column: 21
              m_thread_2.commitPending();//sysj/rotaryTableController.sysj line: 89, column: 5
              placed_1.setPresent();//sysj/rotaryTableController.sysj line: 90, column: 5
              currsigs.addElement(placed_1);
              S40931=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              loadPos1.setPresent();//sysj/rotaryTableController.sysj line: 87, column: 6
              currsigs.addElement(loadPos1);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
          }
          else {
            S40886=4;
            S41029=0;
            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 111, column: 4
              startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
              S41029=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              S41024=0;
              if(startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                startFiller1_o.setVal(m_thread_2.at(1));//sysj/rotaryTableController.sysj line: 111, column: 4
                S41024=1;
                if(!startFiller1_o.isACK()){//sysj/rotaryTableController.sysj line: 111, column: 4
                  startFiller1_o.setREQ(false);//sysj/rotaryTableController.sysj line: 111, column: 4
                  ends[2]=2;
                  ;//sysj/rotaryTableController.sysj line: 111, column: 4
                  S40886=5;
                  S41403=0;
                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 112, column: 4
                    startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                    S41403=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S41398=0;
                    if(startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                      startFiller2_o.setVal(m_thread_2.at(2));//sysj/rotaryTableController.sysj line: 112, column: 4
                      S41398=1;
                      if(!startFiller2_o.isACK()){//sysj/rotaryTableController.sysj line: 112, column: 4
                        startFiller2_o.setREQ(false);//sysj/rotaryTableController.sysj line: 112, column: 4
                        ends[2]=2;
                        ;//sysj/rotaryTableController.sysj line: 112, column: 4
                        S40886=6;
                        S41821=0;
                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 113, column: 4
                          startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                          S41821=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S41816=0;
                          if(startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                            startLid_o.setVal(m_thread_2.at(3));//sysj/rotaryTableController.sysj line: 113, column: 4
                            S41816=1;
                            if(!startLid_o.isACK()){//sysj/rotaryTableController.sysj line: 113, column: 4
                              startLid_o.setREQ(false);//sysj/rotaryTableController.sysj line: 113, column: 4
                              ends[2]=2;
                              ;//sysj/rotaryTableController.sysj line: 113, column: 4
                              S40886=7;
                              S42283=0;
                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                S42283=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S42278=0;
                                if(startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                  startCapper_o.setVal(m_thread_2.at(4));//sysj/rotaryTableController.sysj line: 114, column: 4
                                  S42278=1;
                                  if(!startCapper_o.isACK()){//sysj/rotaryTableController.sysj line: 114, column: 4
                                    startCapper_o.setREQ(false);//sysj/rotaryTableController.sysj line: 114, column: 4
                                    ends[2]=2;
                                    ;//sysj/rotaryTableController.sysj line: 114, column: 4
                                    S40886=8;
                                    S42789=0;
                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                      doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                      S42789=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S42784=0;
                                      if(!doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                        doneFiller1_in.setACK(true);//sysj/rotaryTableController.sysj line: 116, column: 4
                                        S42784=1;
                                        if(doneFiller1_in.isREQ()){//sysj/rotaryTableController.sysj line: 116, column: 4
                                          doneFiller1_in.setACK(false);//sysj/rotaryTableController.sysj line: 116, column: 4
                                          ends[2]=2;
                                          ;//sysj/rotaryTableController.sysj line: 116, column: 4
                                          S40886=9;
                                          S43339=0;
                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                            doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                            S43339=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S43334=0;
                                            if(!doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                              doneFiller2_in.setACK(true);//sysj/rotaryTableController.sysj line: 117, column: 4
                                              S43334=1;
                                              if(doneFiller2_in.isREQ()){//sysj/rotaryTableController.sysj line: 117, column: 4
                                                doneFiller2_in.setACK(false);//sysj/rotaryTableController.sysj line: 117, column: 4
                                                ends[2]=2;
                                                ;//sysj/rotaryTableController.sysj line: 117, column: 4
                                                S40886=10;
                                                S43933=0;
                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                  doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                  S43933=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S43928=0;
                                                  if(!doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                    doneLid_in.setACK(true);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                    S43928=1;
                                                    if(doneLid_in.isREQ()){//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      doneLid_in.setACK(false);//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      ends[2]=2;
                                                      ;//sysj/rotaryTableController.sysj line: 118, column: 4
                                                      S40886=11;
                                                      S44571=0;
                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                        doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                        S44571=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S44566=0;
                                                        if(!doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                          doneCapper_in.setACK(true);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                          S44566=1;
                                                          if(doneCapper_in.isREQ()){//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            doneCapper_in.setACK(false);//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            ends[2]=2;
                                                            ;//sysj/rotaryTableController.sysj line: 119, column: 4
                                                            S40886=12;
                                                            if(!tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 125, column: 20
                                                              S40886=13;
                                                              if(tableAligned.getprestatus()){//sysj/rotaryTableController.sysj line: 128, column: 20
                                                                m_thread_2.index();//sysj/rotaryTableController.sysj line: 130, column: 4
                                                                m_thread_2.report();//sysj/rotaryTableController.sysj line: 131, column: 4
                                                                S40886=14;
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
                                                              rotaryTrigger.setPresent();//sysj/rotaryTableController.sysj line: 126, column: 5
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
      switch(S69149){
        case 0 : 
          S69149=0;
          break RUN;
        
        case 1 : 
          S69149=2;
          S69149=2;
          placed_1.setClear();//sysj/rotaryTableController.sysj line: 53, column: 2
          thread69151(tdone,ends);
          thread69152(tdone,ends);
          int biggest69153 = 0;
          if(ends[2]>=biggest69153){
            biggest69153=ends[2];
          }
          if(ends[3]>=biggest69153){
            biggest69153=ends[3];
          }
          if(biggest69153 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          placed_1.setClear();//sysj/rotaryTableController.sysj line: 53, column: 2
          thread69154(tdone,ends);
          thread69155(tdone,ends);
          int biggest69156 = 0;
          if(ends[2]>=biggest69156){
            biggest69156=ends[2];
          }
          if(ends[3]>=biggest69156){
            biggest69156=ends[3];
          }
          if(biggest69156 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest69156 == 0){
            S69149=0;
            active[1]=0;
            ends[1]=0;
            S69149=0;
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
