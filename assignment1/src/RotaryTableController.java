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
  private TableModel m_thread_3;//sysj\rotaryTableController.sysj line: 157, column: 3
  private WorkpieceTwin w_thread_3;//sysj\rotaryTableController.sysj line: 158, column: 3
  private boolean permitted_thread_2;//sysj\rotaryTableController.sysj line: 128, column: 1
  private int S235265 = 1;
  private int S235099 = 1;
  private int S207824 = 1;
  private int S207638 = 1;
  private int S207645 = 1;
  private int S207640 = 1;
  private int S207869 = 1;
  private int S207967 = 1;
  private int S207962 = 1;
  private int S208341 = 1;
  private int S208336 = 1;
  private int S208759 = 1;
  private int S208754 = 1;
  private int S209221 = 1;
  private int S209216 = 1;
  private int S209727 = 1;
  private int S209722 = 1;
  private int S210277 = 1;
  private int S210272 = 1;
  private int S210871 = 1;
  private int S210866 = 1;
  private int S211509 = 1;
  private int S211504 = 1;
  private int S235263 = 1;
  private int S235123 = 1;
  private int S235107 = 1;
  private int S235102 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread235271(int [] tdone, int [] ends){
        switch(S235263){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S235123){
          case 0 : 
            switch(S235107){
              case 0 : 
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                  S235107=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S235102){
                    case 0 : 
                      if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
                        tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 160, column: 4
                        S235102=1;
                        if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                          ends[3]=2;
                          ;//sysj\rotaryTableController.sysj line: 160, column: 4
                          w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 161, column: 4
                          m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 162, column: 4
                          System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 163, column: 4
                          S235123=1;
                          if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 164, column: 20
                            S235123=2;
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
                      if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
                        tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                        ends[3]=2;
                        ;//sysj\rotaryTableController.sysj line: 160, column: 4
                        w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 161, column: 4
                        m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 162, column: 4
                        System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 163, column: 4
                        S235123=1;
                        if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 164, column: 20
                          S235123=2;
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
                S235107=1;
                S235107=0;
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                  S235107=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S235102=0;
                  if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
                    tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 160, column: 4
                    S235102=1;
                    if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
                      tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                      ends[3]=2;
                      ;//sysj\rotaryTableController.sysj line: 160, column: 4
                      w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 161, column: 4
                      m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 162, column: 4
                      System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 163, column: 4
                      S235123=1;
                      if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 164, column: 20
                        S235123=2;
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
            if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 164, column: 20
              S235123=2;
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
            S235123=2;
            S235123=0;
            S235107=0;
            if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
              tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
              S235107=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S235102=0;
              if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
                tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 160, column: 4
                S235102=1;
                if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                  ends[3]=2;
                  ;//sysj\rotaryTableController.sysj line: 160, column: 4
                  w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 161, column: 4
                  m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 162, column: 4
                  System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 163, column: 4
                  S235123=1;
                  if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 164, column: 20
                    S235123=2;
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

  public void thread235270(int [] tdone, int [] ends){
        switch(S235099){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S207824){
          case 0 : 
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 67, column: 20
              S207824=1;
              if(m_thread_2.exitOccupied()){//sysj\rotaryTableController.sysj line: 75, column: 4
                exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj\rotaryTableController.sysj line: 76, column: 5
                m_thread_2.sayUnloading();//sysj\rotaryTableController.sysj line: 77, column: 5
                S207638=0;
                S207645=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 78, column: 5
                  tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                  S207645=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S207640=0;
                  if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                    tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 78, column: 5
                    S207640=1;
                    if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 78, column: 5
                      S207638=1;
                      if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 79, column: 21
                        m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 82, column: 5
                        S207824=2;
                        if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                          if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 89, column: 5
                            S207824=3;
                            if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                              S207869=0;
                              if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                currsigs.addElement(placed_1);
                                S207869=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                                currsigs.addElement(loadPos1);
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              S207824=4;
                              S207967=0;
                              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                S207967=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S207962=0;
                                if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                  startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                  S207962=1;
                                  if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                    S207824=5;
                                    S208341=0;
                                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S208341=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S208336=0;
                                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                        S208336=1;
                                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                          S207824=6;
                                          S208759=0;
                                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S208759=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S208754=0;
                                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                              S208754=1;
                                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                S207824=7;
                                                S209221=0;
                                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  S209221=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S209216=0;
                                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    S209216=1;
                                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      S207824=8;
                                                      S209727=0;
                                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S209727=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S209722=0;
                                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          S209722=1;
                                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            S207824=9;
                                                            S210277=0;
                                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S210277=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S210272=0;
                                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                S210272=1;
                                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  S207824=10;
                                                                  S210871=0;
                                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S210871=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S210866=0;
                                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      S210866=1;
                                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        S207824=11;
                                                                        S211509=0;
                                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          S211509=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S211504=0;
                                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            S211504=1;
                                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                              S207824=12;
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
                          S207824=3;
                          if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                            S207869=0;
                            if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                              m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                              placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                              currsigs.addElement(placed_1);
                              S207869=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                              currsigs.addElement(loadPos1);
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            S207824=4;
                            S207967=0;
                            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                              S207967=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S207962=0;
                              if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                S207962=1;
                                if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                  S207824=5;
                                  S208341=0;
                                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                    S208341=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S208336=0;
                                    if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S208336=1;
                                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                        S207824=6;
                                        S208759=0;
                                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                          S208759=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S208754=0;
                                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S208754=1;
                                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                              S207824=7;
                                              S209221=0;
                                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                S209221=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S209216=0;
                                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  S209216=1;
                                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    S207824=8;
                                                    S209727=0;
                                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S209727=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S209722=0;
                                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S209722=1;
                                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          S207824=9;
                                                          S210277=0;
                                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S210277=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S210272=0;
                                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S210272=1;
                                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                S207824=10;
                                                                S210871=0;
                                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  S210871=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S210866=0;
                                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S210866=1;
                                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      S207824=11;
                                                                      S211509=0;
                                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                        S211509=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S211504=0;
                                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          S211504=1;
                                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                            S207824=12;
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
                        unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 80, column: 6
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
                S207824=2;
                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 89, column: 5
                    S207824=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                      S207869=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                        currsigs.addElement(placed_1);
                        S207869=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S207824=4;
                      S207967=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                        S207967=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S207962=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                          S207962=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 117, column: 4
                            S207824=5;
                            S208341=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                              S208341=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S208336=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                S208336=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S207824=6;
                                  S208759=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S208759=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S208754=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S208754=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S207824=7;
                                        S209221=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S209221=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S209216=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S209216=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                              S207824=8;
                                              S209727=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S209727=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S209722=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S209722=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S207824=9;
                                                    S210277=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S210277=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S210272=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S210272=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S207824=10;
                                                          S210871=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S210871=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S210866=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S210866=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S207824=11;
                                                                S211509=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S211509=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S211504=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    S211504=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                      S207824=12;
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
                  S207824=3;
                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                    S207869=0;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                      currsigs.addElement(placed_1);
                      S207869=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S207824=4;
                    S207967=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                      S207967=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S207962=0;
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                        S207962=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                          S207824=5;
                          S208341=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            S208341=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S208336=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                              S208336=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                S207824=6;
                                S208759=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S208759=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S208754=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S208754=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S207824=7;
                                      S209221=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S209221=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S209216=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S209216=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S207824=8;
                                            S209727=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S209727=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S209722=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S209722=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S207824=9;
                                                  S210277=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S210277=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S210272=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S210272=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S207824=10;
                                                        S210871=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S210871=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S210866=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S210866=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S207824=11;
                                                              S211509=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                S211509=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S211504=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S211504=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                    S207824=12;
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
            switch(S207638){
              case 0 : 
                switch(S207645){
                  case 0 : 
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 78, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                      S207645=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      switch(S207640){
                        case 0 : 
                          if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                            tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 78, column: 5
                            S207640=1;
                            if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                              tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 78, column: 5
                              S207638=1;
                              if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 79, column: 21
                                m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 82, column: 5
                                S207824=2;
                                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 89, column: 5
                                    S207824=3;
                                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                                      S207869=0;
                                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                        currsigs.addElement(placed_1);
                                        S207869=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                                        currsigs.addElement(loadPos1);
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                    }
                                    else {
                                      S207824=4;
                                      S207967=0;
                                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                        S207967=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S207962=0;
                                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                          S207962=1;
                                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                            S207824=5;
                                            S208341=0;
                                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                              S208341=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S208336=0;
                                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                                S208336=1;
                                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  S207824=6;
                                                  S208759=0;
                                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    S208759=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S208754=0;
                                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      S208754=1;
                                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        S207824=7;
                                                        S209221=0;
                                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          S209221=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S209216=0;
                                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            S209216=1;
                                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                              S207824=8;
                                                              S209727=0;
                                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                S209727=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S209722=0;
                                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  S209722=1;
                                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    S207824=9;
                                                                    S210277=0;
                                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      S210277=1;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      S210272=0;
                                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        S210272=1;
                                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          ends[2]=2;
                                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          S207824=10;
                                                                          S210871=0;
                                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            S210871=1;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S210866=0;
                                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              S210866=1;
                                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                ends[2]=2;
                                                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                S207824=11;
                                                                                S211509=0;
                                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  S211509=1;
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                                else {
                                                                                  S211504=0;
                                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    S211504=1;
                                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                      ends[2]=2;
                                                                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                                      S207824=12;
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
                                  S207824=3;
                                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                                    S207869=0;
                                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                      currsigs.addElement(placed_1);
                                      S207869=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                                      currsigs.addElement(loadPos1);
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    S207824=4;
                                    S207967=0;
                                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                      S207967=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S207962=0;
                                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                        S207962=1;
                                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                          S207824=5;
                                          S208341=0;
                                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                            S208341=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S208336=0;
                                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                              S208336=1;
                                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                                S207824=6;
                                                S208759=0;
                                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  S208759=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S208754=0;
                                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    S208754=1;
                                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      S207824=7;
                                                      S209221=0;
                                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        S209221=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S209216=0;
                                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          S209216=1;
                                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            S207824=8;
                                                            S209727=0;
                                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              S209727=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S209722=0;
                                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                S209722=1;
                                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  S207824=9;
                                                                  S210277=0;
                                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    S210277=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S210272=0;
                                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      S210272=1;
                                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        S207824=10;
                                                                        S210871=0;
                                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          S210871=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S210866=0;
                                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            S210866=1;
                                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              S207824=11;
                                                                              S211509=0;
                                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                S211509=1;
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                              else {
                                                                                S211504=0;
                                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  S211504=1;
                                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    ends[2]=2;
                                                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                                    S207824=12;
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
                                unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 80, column: 6
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
                          if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                            tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 78, column: 5
                            S207638=1;
                            if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 79, column: 21
                              m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 82, column: 5
                              S207824=2;
                              if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                                if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 89, column: 5
                                  S207824=3;
                                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                                    S207869=0;
                                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                      currsigs.addElement(placed_1);
                                      S207869=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                                      currsigs.addElement(loadPos1);
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                  }
                                  else {
                                    S207824=4;
                                    S207967=0;
                                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                      S207967=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S207962=0;
                                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                        S207962=1;
                                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                          S207824=5;
                                          S208341=0;
                                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                            S208341=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S208336=0;
                                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                              S208336=1;
                                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                                S207824=6;
                                                S208759=0;
                                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  S208759=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S208754=0;
                                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    S208754=1;
                                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      S207824=7;
                                                      S209221=0;
                                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        S209221=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S209216=0;
                                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          S209216=1;
                                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            S207824=8;
                                                            S209727=0;
                                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              S209727=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S209722=0;
                                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                S209722=1;
                                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  S207824=9;
                                                                  S210277=0;
                                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    S210277=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S210272=0;
                                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      S210272=1;
                                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        S207824=10;
                                                                        S210871=0;
                                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          S210871=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S210866=0;
                                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            S210866=1;
                                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              S207824=11;
                                                                              S211509=0;
                                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                S211509=1;
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                              else {
                                                                                S211504=0;
                                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  S211504=1;
                                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    ends[2]=2;
                                                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                                    S207824=12;
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
                                S207824=3;
                                if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                                  S207869=0;
                                  if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                    m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                    placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                    currsigs.addElement(placed_1);
                                    S207869=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                                    currsigs.addElement(loadPos1);
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  S207824=4;
                                  S207967=0;
                                  if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                    S207967=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S207962=0;
                                    if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                      startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                      S207962=1;
                                      if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                        S207824=5;
                                        S208341=0;
                                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                          S208341=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S208336=0;
                                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                            startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                            S208336=1;
                                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                              S207824=6;
                                              S208759=0;
                                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                S208759=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S208754=0;
                                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  S208754=1;
                                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    S207824=7;
                                                    S209221=0;
                                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      S209221=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S209216=0;
                                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        S209216=1;
                                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          S207824=8;
                                                          S209727=0;
                                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            S209727=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S209722=0;
                                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              S209722=1;
                                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                S207824=9;
                                                                S210277=0;
                                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  S210277=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S210272=0;
                                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    S210272=1;
                                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      S207824=10;
                                                                      S210871=0;
                                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        S210871=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S210866=0;
                                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          S210866=1;
                                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            S207824=11;
                                                                            S211509=0;
                                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              S211509=1;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              S211504=0;
                                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                S211504=1;
                                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  ends[2]=2;
                                                                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                                  S207824=12;
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
                              unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 80, column: 6
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
                    S207645=1;
                    S207645=0;
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 78, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                      S207645=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S207640=0;
                      if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                        tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 78, column: 5
                        S207640=1;
                        if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                          tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 78, column: 5
                          S207638=1;
                          if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 79, column: 21
                            m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 82, column: 5
                            S207824=2;
                            if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                              if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 89, column: 5
                                S207824=3;
                                if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                                  S207869=0;
                                  if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                    m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                    placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                    currsigs.addElement(placed_1);
                                    S207869=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                                    currsigs.addElement(loadPos1);
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                }
                                else {
                                  S207824=4;
                                  S207967=0;
                                  if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                    S207967=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S207962=0;
                                    if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                      startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                      S207962=1;
                                      if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                        S207824=5;
                                        S208341=0;
                                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                          S208341=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S208336=0;
                                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                            startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                            S208336=1;
                                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                              S207824=6;
                                              S208759=0;
                                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                S208759=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S208754=0;
                                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  S208754=1;
                                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    S207824=7;
                                                    S209221=0;
                                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      S209221=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S209216=0;
                                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        S209216=1;
                                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          S207824=8;
                                                          S209727=0;
                                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            S209727=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S209722=0;
                                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              S209722=1;
                                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                S207824=9;
                                                                S210277=0;
                                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  S210277=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S210272=0;
                                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    S210272=1;
                                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      S207824=10;
                                                                      S210871=0;
                                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        S210871=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S210866=0;
                                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          S210866=1;
                                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            S207824=11;
                                                                            S211509=0;
                                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              S211509=1;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              S211504=0;
                                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                S211504=1;
                                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  ends[2]=2;
                                                                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                                  S207824=12;
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
                              S207824=3;
                              if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                                S207869=0;
                                if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                  m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                  placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                  currsigs.addElement(placed_1);
                                  S207869=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                                  currsigs.addElement(loadPos1);
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                              }
                              else {
                                S207824=4;
                                S207967=0;
                                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                  S207967=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S207962=0;
                                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                    S207962=1;
                                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                      S207824=5;
                                      S208341=0;
                                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                        S208341=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S208336=0;
                                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                          S208336=1;
                                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                            S207824=6;
                                            S208759=0;
                                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                              S208759=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S208754=0;
                                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                S208754=1;
                                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  S207824=7;
                                                  S209221=0;
                                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    S209221=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S209216=0;
                                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      S209216=1;
                                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        S207824=8;
                                                        S209727=0;
                                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          S209727=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S209722=0;
                                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            S209722=1;
                                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              S207824=9;
                                                              S210277=0;
                                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                S210277=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S210272=0;
                                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  S210272=1;
                                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    S207824=10;
                                                                    S210871=0;
                                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      S210871=1;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      S210866=0;
                                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        S210866=1;
                                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          ends[2]=2;
                                                                          ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          S207824=11;
                                                                          S211509=0;
                                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            S211509=1;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S211504=0;
                                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              S211504=1;
                                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                ends[2]=2;
                                                                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                                S207824=12;
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
                            unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 80, column: 6
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
                if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 79, column: 21
                  m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 82, column: 5
                  S207824=2;
                  if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                    if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 89, column: 5
                      S207824=3;
                      if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                        S207869=0;
                        if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                          m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                          placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                          currsigs.addElement(placed_1);
                          S207869=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                          currsigs.addElement(loadPos1);
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                      }
                      else {
                        S207824=4;
                        S207967=0;
                        if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                          S207967=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S207962=0;
                          if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                            S207962=1;
                            if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 117, column: 4
                              S207824=5;
                              S208341=0;
                              if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                S208341=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S208336=0;
                                if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S208336=1;
                                  if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                    S207824=6;
                                    S208759=0;
                                    if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S208759=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S208754=0;
                                      if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S208754=1;
                                        if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                          S207824=7;
                                          S209221=0;
                                          if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S209221=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S209216=0;
                                            if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                              startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                              S209216=1;
                                              if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                S207824=8;
                                                S209727=0;
                                                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S209727=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S209722=0;
                                                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S209722=1;
                                                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S207824=9;
                                                      S210277=0;
                                                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S210277=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S210272=0;
                                                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S210272=1;
                                                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S207824=10;
                                                            S210871=0;
                                                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S210871=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S210866=0;
                                                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S210866=1;
                                                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  S207824=11;
                                                                  S211509=0;
                                                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    S211509=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S211504=0;
                                                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      S211504=1;
                                                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                        permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                        S207824=12;
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
                    S207824=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                      S207869=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                        currsigs.addElement(placed_1);
                        S207869=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S207824=4;
                      S207967=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                        S207967=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S207962=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                          S207962=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 117, column: 4
                            S207824=5;
                            S208341=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                              S208341=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S208336=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                S208336=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S207824=6;
                                  S208759=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S208759=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S208754=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S208754=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S207824=7;
                                        S209221=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S209221=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S209216=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S209216=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                              S207824=8;
                                              S209727=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S209727=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S209722=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S209722=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S207824=9;
                                                    S210277=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S210277=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S210272=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S210272=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S207824=10;
                                                          S210871=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S210871=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S210866=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S210866=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S207824=11;
                                                                S211509=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S211509=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S211504=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    S211504=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                      S207824=12;
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
                  unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 80, column: 6
                  currsigs.addElement(unloadExit);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
          case 2 : 
            if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              ends[2]=2;
              ;//sysj\rotaryTableController.sysj line: 89, column: 5
              S207824=3;
              if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                S207869=0;
                if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                  m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                  placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                  currsigs.addElement(placed_1);
                  S207869=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                  currsigs.addElement(loadPos1);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
              else {
                S207824=4;
                S207967=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                  S207967=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S207962=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                    S207962=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 117, column: 4
                      S207824=5;
                      S208341=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                        S208341=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S208336=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                          S208336=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 118, column: 4
                            S207824=6;
                            S208759=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                              S208759=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S208754=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                S208754=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S207824=7;
                                  S209221=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S209221=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S209216=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S209216=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S207824=8;
                                        S209727=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S209727=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S209722=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S209722=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S207824=9;
                                              S210277=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S210277=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S210272=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S210272=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S207824=10;
                                                    S210871=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S210871=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S210866=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S210866=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S207824=11;
                                                          S211509=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S211509=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S211504=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              S211504=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                S207824=12;
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
            switch(S207869){
              case 0 : 
                if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                  m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                  placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                  currsigs.addElement(placed_1);
                  S207869=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                  currsigs.addElement(loadPos1);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S207869=1;
                S207824=4;
                S207967=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                  S207967=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S207962=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                    S207962=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 117, column: 4
                      S207824=5;
                      S208341=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                        S208341=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S208336=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                          S208336=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 118, column: 4
                            S207824=6;
                            S208759=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                              S208759=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S208754=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                S208754=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S207824=7;
                                  S209221=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S209221=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S209216=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S209216=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S207824=8;
                                        S209727=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S209727=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S209722=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S209722=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S207824=9;
                                              S210277=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S210277=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S210272=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S210272=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S207824=10;
                                                    S210871=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S210871=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S210866=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S210866=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S207824=11;
                                                          S211509=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S211509=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S211504=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              S211504=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                S207824=12;
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
            switch(S207967){
              case 0 : 
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                  S207967=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S207962){
                    case 0 : 
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                        S207962=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                          S207824=5;
                          S208341=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            S208341=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S208336=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                              S208336=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                S207824=6;
                                S208759=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S208759=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S208754=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S208754=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S207824=7;
                                      S209221=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S209221=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S209216=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S209216=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S207824=8;
                                            S209727=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S209727=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S209722=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S209722=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S207824=9;
                                                  S210277=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S210277=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S210272=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S210272=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S207824=10;
                                                        S210871=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S210871=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S210866=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S210866=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S207824=11;
                                                              S211509=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                S211509=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S211504=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S211504=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                    S207824=12;
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
                      if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 117, column: 4
                        S207824=5;
                        S208341=0;
                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                          S208341=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S208336=0;
                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                            S208336=1;
                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 118, column: 4
                              S207824=6;
                              S208759=0;
                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                S208759=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S208754=0;
                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S208754=1;
                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S207824=7;
                                    S209221=0;
                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S209221=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S209216=0;
                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S209216=1;
                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S207824=8;
                                          S209727=0;
                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S209727=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S209722=0;
                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S209722=1;
                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S207824=9;
                                                S210277=0;
                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S210277=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S210272=0;
                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S210272=1;
                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S207824=10;
                                                      S210871=0;
                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S210871=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S210866=0;
                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S210866=1;
                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S207824=11;
                                                            S211509=0;
                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              S211509=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S211504=0;
                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                S211504=1;
                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                  S207824=12;
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
                S207967=1;
                S207967=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                  S207967=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S207962=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                    S207962=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 117, column: 4
                      S207824=5;
                      S208341=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                        S208341=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S208336=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                          S208336=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 118, column: 4
                            S207824=6;
                            S208759=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                              S208759=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S208754=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                S208754=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S207824=7;
                                  S209221=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S209221=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S209216=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S209216=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S207824=8;
                                        S209727=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S209727=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S209722=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S209722=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S207824=9;
                                              S210277=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S210277=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S210272=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S210272=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S207824=10;
                                                    S210871=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S210871=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S210866=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S210866=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S207824=11;
                                                          S211509=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S211509=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S211504=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              S211504=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                S207824=12;
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
            switch(S208341){
              case 0 : 
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                  S208341=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S208336){
                    case 0 : 
                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                        S208336=1;
                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 118, column: 4
                          S207824=6;
                          S208759=0;
                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                            S208759=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S208754=0;
                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                              S208754=1;
                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                S207824=7;
                                S209221=0;
                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S209221=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S209216=0;
                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S209216=1;
                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S207824=8;
                                      S209727=0;
                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S209727=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S209722=0;
                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S209722=1;
                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S207824=9;
                                            S210277=0;
                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S210277=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S210272=0;
                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S210272=1;
                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S207824=10;
                                                  S210871=0;
                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    S210871=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S210866=0;
                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S210866=1;
                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S207824=11;
                                                        S211509=0;
                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          S211509=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S211504=0;
                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S211504=1;
                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                              S207824=12;
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
                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 118, column: 4
                        S207824=6;
                        S208759=0;
                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                          S208759=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S208754=0;
                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                            S208754=1;
                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 119, column: 4
                              S207824=7;
                              S209221=0;
                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                S209221=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S209216=0;
                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S209216=1;
                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S207824=8;
                                    S209727=0;
                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S209727=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S209722=0;
                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S209722=1;
                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S207824=9;
                                          S210277=0;
                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S210277=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S210272=0;
                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S210272=1;
                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S207824=10;
                                                S210871=0;
                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  S210871=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S210866=0;
                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    S210866=1;
                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S207824=11;
                                                      S211509=0;
                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        S211509=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S211504=0;
                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          S211504=1;
                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                            S207824=12;
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
                S208341=1;
                S208341=0;
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                  S208341=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S208336=0;
                  if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                    startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                    S208336=1;
                    if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 118, column: 4
                      S207824=6;
                      S208759=0;
                      if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                        S208759=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S208754=0;
                        if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                          startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                          S208754=1;
                          if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 119, column: 4
                            S207824=7;
                            S209221=0;
                            if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                              S209221=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S209216=0;
                              if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                S209216=1;
                                if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S207824=8;
                                  S209727=0;
                                  if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S209727=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S209722=0;
                                    if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S209722=1;
                                      if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S207824=9;
                                        S210277=0;
                                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S210277=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S210272=0;
                                          if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S210272=1;
                                            if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S207824=10;
                                              S210871=0;
                                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                S210871=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S210866=0;
                                                if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  S210866=1;
                                                  if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    S207824=11;
                                                    S211509=0;
                                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      S211509=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S211504=0;
                                                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        S211504=1;
                                                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                          S207824=12;
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
            switch(S208759){
              case 0 : 
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                  S208759=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S208754){
                    case 0 : 
                      if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                        startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                        S208754=1;
                        if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 119, column: 4
                          S207824=7;
                          S209221=0;
                          if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                            S209221=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S209216=0;
                            if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                              startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                              S209216=1;
                              if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                S207824=8;
                                S209727=0;
                                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S209727=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S209722=0;
                                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S209722=1;
                                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S207824=9;
                                      S210277=0;
                                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S210277=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S210272=0;
                                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S210272=1;
                                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S207824=10;
                                            S210871=0;
                                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                              S210871=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S210866=0;
                                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                S210866=1;
                                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  S207824=11;
                                                  S211509=0;
                                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    S211509=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S211504=0;
                                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      S211504=1;
                                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                        S207824=12;
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
                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                        S207824=7;
                        S209221=0;
                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                          S209221=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S209216=0;
                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                            S209216=1;
                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 120, column: 4
                              S207824=8;
                              S209727=0;
                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                S209727=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S209722=0;
                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S209722=1;
                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S207824=9;
                                    S210277=0;
                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                      S210277=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S210272=0;
                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S210272=1;
                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S207824=10;
                                          S210871=0;
                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                            S210871=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S210866=0;
                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                              S210866=1;
                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                S207824=11;
                                                S211509=0;
                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  S211509=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S211504=0;
                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    S211504=1;
                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                      S207824=12;
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
                S208759=1;
                S208759=0;
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                  S208759=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S208754=0;
                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                    S208754=1;
                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                      S207824=7;
                      S209221=0;
                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                        S209221=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S209216=0;
                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                          S209216=1;
                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                            S207824=8;
                            S209727=0;
                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                              S209727=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S209722=0;
                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                S209722=1;
                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S207824=9;
                                  S210277=0;
                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S210277=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S210272=0;
                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                      S210272=1;
                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S207824=10;
                                        S210871=0;
                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                          S210871=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S210866=0;
                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                            S210866=1;
                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                              S207824=11;
                                              S211509=0;
                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                S211509=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S211504=0;
                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  S211504=1;
                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                    S207824=12;
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
            switch(S209221){
              case 0 : 
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                  S209221=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S209216){
                    case 0 : 
                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                        S209216=1;
                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 120, column: 4
                          S207824=8;
                          S209727=0;
                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                            S209727=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S209722=0;
                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                              S209722=1;
                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                S207824=9;
                                S210277=0;
                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                  S210277=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S210272=0;
                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S210272=1;
                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                      S207824=10;
                                      S210871=0;
                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                        S210871=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S210866=0;
                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                          S210866=1;
                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                            S207824=11;
                                            S211509=0;
                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                              S211509=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S211504=0;
                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                S211504=1;
                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                  S207824=12;
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
                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 120, column: 4
                        S207824=8;
                        S209727=0;
                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                          S209727=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S209722=0;
                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                            S209722=1;
                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                              S207824=9;
                              S210277=0;
                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                S210277=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S210272=0;
                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                  S210272=1;
                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S207824=10;
                                    S210871=0;
                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                      S210871=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S210866=0;
                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                        S210866=1;
                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                          S207824=11;
                                          S211509=0;
                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                            S211509=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S211504=0;
                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                              S211504=1;
                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                S207824=12;
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
                S209221=1;
                S209221=0;
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                  S209221=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S209216=0;
                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                    S209216=1;
                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 120, column: 4
                      S207824=8;
                      S209727=0;
                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                        S209727=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S209722=0;
                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                          S209722=1;
                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 122, column: 4
                            S207824=9;
                            S210277=0;
                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                              S210277=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S210272=0;
                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                S210272=1;
                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                  S207824=10;
                                  S210871=0;
                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                    S210871=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S210866=0;
                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                      S210866=1;
                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                        S207824=11;
                                        S211509=0;
                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                          S211509=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S211504=0;
                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                            S211504=1;
                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                              S207824=12;
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
            switch(S209727){
              case 0 : 
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                  S209727=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S209722){
                    case 0 : 
                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                        S209722=1;
                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                          S207824=9;
                          S210277=0;
                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                            S210277=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S210272=0;
                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                              S210272=1;
                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                S207824=10;
                                S210871=0;
                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                  S210871=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S210866=0;
                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                    S210866=1;
                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                      S207824=11;
                                      S211509=0;
                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                        S211509=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S211504=0;
                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                          S211504=1;
                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                            S207824=12;
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
                      if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                        S207824=9;
                        S210277=0;
                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                          S210277=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S210272=0;
                          if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                            doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                            S210272=1;
                            if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                              S207824=10;
                              S210871=0;
                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                S210871=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S210866=0;
                                if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                  doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                  S210866=1;
                                  if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                    S207824=11;
                                    S211509=0;
                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                      S211509=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S211504=0;
                                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                        S211504=1;
                                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                          permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                          S207824=12;
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
                S209727=1;
                S209727=0;
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                  S209727=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S209722=0;
                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                    S209722=1;
                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                      S207824=9;
                      S210277=0;
                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                        S210277=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S210272=0;
                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                          S210272=1;
                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                            S207824=10;
                            S210871=0;
                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                              S210871=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S210866=0;
                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                S210866=1;
                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                  S207824=11;
                                  S211509=0;
                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                    S211509=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S211504=0;
                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                      S211504=1;
                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                        permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                        S207824=12;
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
            switch(S210277){
              case 0 : 
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                  S210277=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S210272){
                    case 0 : 
                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                        S210272=1;
                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                          S207824=10;
                          S210871=0;
                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                            S210871=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S210866=0;
                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                              S210866=1;
                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                S207824=11;
                                S211509=0;
                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                  S211509=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S211504=0;
                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                    S211504=1;
                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                      S207824=12;
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
                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                        S207824=10;
                        S210871=0;
                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                          S210871=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S210866=0;
                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                            S210866=1;
                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                              S207824=11;
                              S211509=0;
                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                S211509=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S211504=0;
                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                  S211504=1;
                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                    S207824=12;
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
                S210277=1;
                S210277=0;
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                  S210277=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S210272=0;
                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                    S210272=1;
                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                      S207824=10;
                      S210871=0;
                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                        S210871=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S210866=0;
                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                          S210866=1;
                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                            S207824=11;
                            S211509=0;
                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                              S211509=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S211504=0;
                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                S211504=1;
                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                  permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                  S207824=12;
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
            switch(S210871){
              case 0 : 
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                  S210871=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S210866){
                    case 0 : 
                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                        S210866=1;
                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 124, column: 4
                          S207824=11;
                          S211509=0;
                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                            S211509=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S211504=0;
                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                              S211504=1;
                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                S207824=12;
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
                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 124, column: 4
                        S207824=11;
                        S211509=0;
                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                          S211509=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S211504=0;
                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                            S211504=1;
                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                              S207824=12;
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
                S210871=1;
                S210871=0;
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                  S210871=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S210866=0;
                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                    S210866=1;
                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                      S207824=11;
                      S211509=0;
                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                        S211509=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S211504=0;
                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                          S211504=1;
                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                            S207824=12;
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
            switch(S211509){
              case 0 : 
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                  S211509=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S211504){
                    case 0 : 
                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                        S211504=1;
                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 125, column: 4
                          permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                          S207824=12;
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
                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 125, column: 4
                        permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                        S207824=12;
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
                S211509=1;
                S211509=0;
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                  S211509=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S211504=0;
                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                    S211504=1;
                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                      S207824=12;
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
            S207824=12;
            S207824=13;
            if(!permitted_thread_2){//sysj\rotaryTableController.sysj line: 130, column: 19
              permitted_thread_2 = GuiStep.take("INDEX", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\rotaryTableController.sysj line: 131, column: 17
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              ends[2]=2;
              ;//sysj\rotaryTableController.sysj line: 130, column: 13
              S207824=14;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 13 : 
            if(!permitted_thread_2){//sysj\rotaryTableController.sysj line: 130, column: 19
              permitted_thread_2 = GuiStep.take("INDEX", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\rotaryTableController.sysj line: 131, column: 17
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              ends[2]=2;
              ;//sysj\rotaryTableController.sysj line: 130, column: 13
              S207824=14;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 14 : 
            S207824=14;
            S207824=15;
            if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 139, column: 20
              S207824=16;
              if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 142, column: 20
                m_thread_2.index();//sysj\rotaryTableController.sysj line: 144, column: 4
                m_thread_2.report();//sysj\rotaryTableController.sysj line: 145, column: 4
                step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 146, column: 4
                t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 147, column: 4
                t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 148, column: 4
                if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 149, column: 4
                  twin.setPresent();//sysj\rotaryTableController.sysj line: 150, column: 5
                  currsigs.addElement(twin);
                  twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 150, column: 5
                  S207824=17;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S207824=17;
                  active[2]=1;
                  ends[2]=1;
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
              rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 140, column: 5
              currsigs.addElement(rotaryTrigger);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 15 : 
            if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 139, column: 20
              S207824=16;
              if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 142, column: 20
                m_thread_2.index();//sysj\rotaryTableController.sysj line: 144, column: 4
                m_thread_2.report();//sysj\rotaryTableController.sysj line: 145, column: 4
                step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 146, column: 4
                t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 147, column: 4
                t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 148, column: 4
                if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 149, column: 4
                  twin.setPresent();//sysj\rotaryTableController.sysj line: 150, column: 5
                  currsigs.addElement(twin);
                  twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 150, column: 5
                  S207824=17;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S207824=17;
                  active[2]=1;
                  ends[2]=1;
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
              rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 140, column: 5
              currsigs.addElement(rotaryTrigger);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 16 : 
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 142, column: 20
              m_thread_2.index();//sysj\rotaryTableController.sysj line: 144, column: 4
              m_thread_2.report();//sysj\rotaryTableController.sysj line: 145, column: 4
              step_thread_2 = (step_thread_2 % 6) + 1;//sysj\rotaryTableController.sysj line: 146, column: 4
              t_thread_2.setPosition(step_thread_2);//sysj\rotaryTableController.sysj line: 147, column: 4
              t_thread_2.setRotating(false);//sysj\rotaryTableController.sysj line: 148, column: 4
              if(t_thread_2.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_2)){//sysj\rotaryTableController.sysj line: 149, column: 4
                twin.setPresent();//sysj\rotaryTableController.sysj line: 150, column: 5
                currsigs.addElement(twin);
                twin.setValue(t_thread_2);//sysj\rotaryTableController.sysj line: 150, column: 5
                S207824=17;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S207824=17;
                active[2]=1;
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
          
          case 17 : 
            S207824=17;
            S207824=0;
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 67, column: 20
              S207824=1;
              if(m_thread_2.exitOccupied()){//sysj\rotaryTableController.sysj line: 75, column: 4
                exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj\rotaryTableController.sysj line: 76, column: 5
                m_thread_2.sayUnloading();//sysj\rotaryTableController.sysj line: 77, column: 5
                S207638=0;
                S207645=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 78, column: 5
                  tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                  S207645=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S207640=0;
                  if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                    tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 78, column: 5
                    S207640=1;
                    if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 78, column: 5
                      S207638=1;
                      if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 79, column: 21
                        m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 82, column: 5
                        S207824=2;
                        if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                          if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 89, column: 5
                            S207824=3;
                            if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                              S207869=0;
                              if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                currsigs.addElement(placed_1);
                                S207869=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                                currsigs.addElement(loadPos1);
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                            }
                            else {
                              S207824=4;
                              S207967=0;
                              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                S207967=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S207962=0;
                                if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                  startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                  S207962=1;
                                  if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                    S207824=5;
                                    S208341=0;
                                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S208341=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S208336=0;
                                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                        S208336=1;
                                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                          S207824=6;
                                          S208759=0;
                                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S208759=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S208754=0;
                                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                              S208754=1;
                                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                S207824=7;
                                                S209221=0;
                                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  S209221=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S209216=0;
                                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    S209216=1;
                                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      S207824=8;
                                                      S209727=0;
                                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S209727=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S209722=0;
                                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          S209722=1;
                                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            S207824=9;
                                                            S210277=0;
                                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S210277=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S210272=0;
                                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                S210272=1;
                                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  S207824=10;
                                                                  S210871=0;
                                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S210871=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S210866=0;
                                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      S210866=1;
                                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        S207824=11;
                                                                        S211509=0;
                                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          S211509=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S211504=0;
                                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            S211504=1;
                                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                              S207824=12;
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
                          S207824=3;
                          if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                            S207869=0;
                            if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                              m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                              placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                              currsigs.addElement(placed_1);
                              S207869=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                              currsigs.addElement(loadPos1);
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                          }
                          else {
                            S207824=4;
                            S207967=0;
                            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                              S207967=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S207962=0;
                              if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                S207962=1;
                                if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                  S207824=5;
                                  S208341=0;
                                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                    S208341=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S208336=0;
                                    if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S208336=1;
                                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                        S207824=6;
                                        S208759=0;
                                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                          S208759=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S208754=0;
                                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S208754=1;
                                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                              S207824=7;
                                              S209221=0;
                                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                S209221=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S209216=0;
                                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  S209216=1;
                                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    S207824=8;
                                                    S209727=0;
                                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S209727=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S209722=0;
                                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S209722=1;
                                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          S207824=9;
                                                          S210277=0;
                                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S210277=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S210272=0;
                                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S210272=1;
                                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                S207824=10;
                                                                S210871=0;
                                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  S210871=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S210866=0;
                                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S210866=1;
                                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      S207824=11;
                                                                      S211509=0;
                                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                        S211509=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S211504=0;
                                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          S211504=1;
                                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                            S207824=12;
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
                        unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 80, column: 6
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
                S207824=2;
                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 89, column: 5
                    S207824=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                      S207869=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                        currsigs.addElement(placed_1);
                        S207869=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S207824=4;
                      S207967=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                        S207967=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S207962=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                          S207962=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 117, column: 4
                            S207824=5;
                            S208341=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                              S208341=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S208336=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                S208336=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S207824=6;
                                  S208759=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S208759=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S208754=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S208754=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S207824=7;
                                        S209221=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S209221=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S209216=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S209216=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                              S207824=8;
                                              S209727=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S209727=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S209722=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S209722=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S207824=9;
                                                    S210277=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S210277=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S210272=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S210272=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S207824=10;
                                                          S210871=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S210871=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S210866=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S210866=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S207824=11;
                                                                S211509=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S211509=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S211504=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    S211504=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                      S207824=12;
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
                  S207824=3;
                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                    S207869=0;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                      currsigs.addElement(placed_1);
                      S207869=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S207824=4;
                    S207967=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                      S207967=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S207962=0;
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                        S207962=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                          S207824=5;
                          S208341=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            S208341=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S208336=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                              S208336=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                S207824=6;
                                S208759=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S208759=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S208754=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S208754=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S207824=7;
                                      S209221=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S209221=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S209216=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S209216=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S207824=8;
                                            S209727=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S209727=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S209722=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S209722=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S207824=9;
                                                  S210277=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S210277=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S210272=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S210272=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S207824=10;
                                                        S210871=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S210871=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S210866=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S210866=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S207824=11;
                                                              S211509=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                S211509=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S211504=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S211504=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                    S207824=12;
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

  public void thread235268(int [] tdone, int [] ends){
        S235263=1;
    m_thread_3 = TableModel.shared();//sysj\rotaryTableController.sysj line: 157, column: 3
    w_thread_3 = null;//sysj\rotaryTableController.sysj line: 158, column: 3
    S235123=0;
    S235107=0;
    if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
      tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
      S235107=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S235102=0;
      if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
        tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 160, column: 4
        S235102=1;
        if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
          tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
          ends[3]=2;
          ;//sysj\rotaryTableController.sysj line: 160, column: 4
          w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 161, column: 4
          m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 162, column: 4
          System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 163, column: 4
          S235123=1;
          if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 164, column: 20
            S235123=2;
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

  public void thread235267(int [] tdone, int [] ends){
        S235099=1;
    t_thread_2 = new RotaryTableTwin();//sysj\rotaryTableController.sysj line: 60, column: 3
    step_thread_2 = 0;//sysj\rotaryTableController.sysj line: 61, column: 3
    m_thread_2 = TableModel.shared();//sysj\rotaryTableController.sysj line: 62, column: 3
    exiting_thread_2 = null;//sysj\rotaryTableController.sysj line: 63, column: 3
    S207824=0;
    if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 67, column: 20
      S207824=1;
      if(m_thread_2.exitOccupied()){//sysj\rotaryTableController.sysj line: 75, column: 4
        exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj\rotaryTableController.sysj line: 76, column: 5
        m_thread_2.sayUnloading();//sysj\rotaryTableController.sysj line: 77, column: 5
        S207638=0;
        S207645=0;
        if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 78, column: 5
          tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
          S207645=1;
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          S207640=0;
          if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
            tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 78, column: 5
            S207640=1;
            if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
              tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
              ends[2]=2;
              ;//sysj\rotaryTableController.sysj line: 78, column: 5
              S207638=1;
              if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 79, column: 21
                m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 82, column: 5
                S207824=2;
                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 89, column: 5
                    S207824=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                      S207869=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                        currsigs.addElement(placed_1);
                        S207869=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                        currsigs.addElement(loadPos1);
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S207824=4;
                      S207967=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                        S207967=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S207962=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                          S207962=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 117, column: 4
                            S207824=5;
                            S208341=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                              S208341=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S208336=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                S208336=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S207824=6;
                                  S208759=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S208759=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S208754=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S208754=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S207824=7;
                                        S209221=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S209221=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S209216=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S209216=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                              S207824=8;
                                              S209727=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S209727=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S209722=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S209722=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S207824=9;
                                                    S210277=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S210277=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S210272=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S210272=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S207824=10;
                                                          S210871=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S210871=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S210866=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S210866=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S207824=11;
                                                                S211509=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S211509=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S211504=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    S211504=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                      S207824=12;
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
                  S207824=3;
                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                    S207869=0;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                      currsigs.addElement(placed_1);
                      S207869=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                      currsigs.addElement(loadPos1);
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                  }
                  else {
                    S207824=4;
                    S207967=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                      S207967=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S207962=0;
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                        S207962=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                          S207824=5;
                          S208341=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            S208341=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S208336=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                              S208336=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                S207824=6;
                                S208759=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S208759=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S208754=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S208754=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S207824=7;
                                      S209221=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S209221=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S209216=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S209216=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S207824=8;
                                            S209727=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S209727=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S209722=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S209722=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S207824=9;
                                                  S210277=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S210277=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S210272=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S210272=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S207824=10;
                                                        S210871=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S210871=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S210866=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S210866=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S207824=11;
                                                              S211509=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                S211509=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S211504=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S211504=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                    S207824=12;
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
                unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 80, column: 6
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
        S207824=2;
        if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
          if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            ends[2]=2;
            ;//sysj\rotaryTableController.sysj line: 89, column: 5
            S207824=3;
            if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
              S207869=0;
              if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                currsigs.addElement(placed_1);
                S207869=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
                currsigs.addElement(loadPos1);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              S207824=4;
              S207967=0;
              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                S207967=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S207962=0;
                if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                  startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                  S207962=1;
                  if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 117, column: 4
                    S207824=5;
                    S208341=0;
                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                      S208341=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S208336=0;
                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                        S208336=1;
                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 118, column: 4
                          S207824=6;
                          S208759=0;
                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                            S208759=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S208754=0;
                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                              S208754=1;
                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                S207824=7;
                                S209221=0;
                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S209221=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S209216=0;
                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S209216=1;
                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S207824=8;
                                      S209727=0;
                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S209727=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S209722=0;
                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S209722=1;
                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S207824=9;
                                            S210277=0;
                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S210277=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S210272=0;
                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S210272=1;
                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S207824=10;
                                                  S210871=0;
                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    S210871=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S210866=0;
                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S210866=1;
                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S207824=11;
                                                        S211509=0;
                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          S211509=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S211504=0;
                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S211504=1;
                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                              S207824=12;
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
          S207824=3;
          if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
            S207869=0;
            if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
              m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
              placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
              currsigs.addElement(placed_1);
              S207869=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 93, column: 6
              currsigs.addElement(loadPos1);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
          }
          else {
            S207824=4;
            S207967=0;
            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
              S207967=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              S207962=0;
              if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                S207962=1;
                if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                  ends[2]=2;
                  ;//sysj\rotaryTableController.sysj line: 117, column: 4
                  S207824=5;
                  S208341=0;
                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                    S208341=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S208336=0;
                    if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                      startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                      S208336=1;
                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 118, column: 4
                        S207824=6;
                        S208759=0;
                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                          S208759=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S208754=0;
                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                            S208754=1;
                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 119, column: 4
                              S207824=7;
                              S209221=0;
                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                S209221=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S209216=0;
                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S209216=1;
                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S207824=8;
                                    S209727=0;
                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S209727=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S209722=0;
                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S209722=1;
                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S207824=9;
                                          S210277=0;
                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S210277=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S210272=0;
                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S210272=1;
                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S207824=10;
                                                S210871=0;
                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  S210871=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S210866=0;
                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    S210866=1;
                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S207824=11;
                                                      S211509=0;
                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        S211509=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S211504=0;
                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          S211504=1;
                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                            S207824=12;
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
      switch(S235265){
        case 0 : 
          S235265=0;
          break RUN;
        
        case 1 : 
          S235265=2;
          S235265=2;
          placed_1.setClear();//sysj\rotaryTableController.sysj line: 57, column: 2
          thread235267(tdone,ends);
          thread235268(tdone,ends);
          int biggest235269 = 0;
          if(ends[2]>=biggest235269){
            biggest235269=ends[2];
          }
          if(ends[3]>=biggest235269){
            biggest235269=ends[3];
          }
          if(biggest235269 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          placed_1.setClear();//sysj\rotaryTableController.sysj line: 57, column: 2
          thread235270(tdone,ends);
          thread235271(tdone,ends);
          int biggest235272 = 0;
          if(ends[2]>=biggest235272){
            biggest235272=ends[2];
          }
          if(ends[3]>=biggest235272){
            biggest235272=ends[3];
          }
          if(biggest235272 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest235272 == 0){
            S235265=0;
            active[1]=0;
            ends[1]=0;
            S235265=0;
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
