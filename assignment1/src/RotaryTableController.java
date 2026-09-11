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
  private int S213059 = 1;
  private int S212893 = 1;
  private int S185618 = 1;
  private int S185432 = 1;
  private int S185439 = 1;
  private int S185434 = 1;
  private int S185663 = 1;
  private int S185761 = 1;
  private int S185756 = 1;
  private int S186135 = 1;
  private int S186130 = 1;
  private int S186553 = 1;
  private int S186548 = 1;
  private int S187015 = 1;
  private int S187010 = 1;
  private int S187521 = 1;
  private int S187516 = 1;
  private int S188071 = 1;
  private int S188066 = 1;
  private int S188665 = 1;
  private int S188660 = 1;
  private int S189303 = 1;
  private int S189298 = 1;
  private int S213057 = 1;
  private int S212917 = 1;
  private int S212901 = 1;
  private int S212896 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread213065(int [] tdone, int [] ends){
        switch(S213057){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S212917){
          case 0 : 
            switch(S212901){
              case 0 : 
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                  S212901=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  switch(S212896){
                    case 0 : 
                      if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
                        tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 160, column: 4
                        S212896=1;
                        if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                          ends[3]=2;
                          ;//sysj\rotaryTableController.sysj line: 160, column: 4
                          w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 161, column: 4
                          m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 162, column: 4
                          System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 163, column: 4
                          S212917=1;
                          if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 164, column: 20
                            S212917=2;
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
                        S212917=1;
                        if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 164, column: 20
                          S212917=2;
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
                S212901=1;
                S212901=0;
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                  S212901=1;
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  S212896=0;
                  if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
                    tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 160, column: 4
                    S212896=1;
                    if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
                      tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                      ends[3]=2;
                      ;//sysj\rotaryTableController.sysj line: 160, column: 4
                      w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 161, column: 4
                      m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 162, column: 4
                      System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 163, column: 4
                      S212917=1;
                      if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 164, column: 20
                        S212917=2;
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
              S212917=2;
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
            S212917=2;
            S212917=0;
            S212901=0;
            if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
              tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
              S212901=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              S212896=0;
              if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
                tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 160, column: 4
                S212896=1;
                if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                  ends[3]=2;
                  ;//sysj\rotaryTableController.sysj line: 160, column: 4
                  w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 161, column: 4
                  m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 162, column: 4
                  System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 163, column: 4
                  S212917=1;
                  if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 164, column: 20
                    S212917=2;
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

  public void thread213064(int [] tdone, int [] ends){
        switch(S212893){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S185618){
          case 0 : 
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 67, column: 20
              S185618=1;
              if(m_thread_2.exitOccupied()){//sysj\rotaryTableController.sysj line: 75, column: 4
                exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj\rotaryTableController.sysj line: 76, column: 5
                m_thread_2.sayUnloading();//sysj\rotaryTableController.sysj line: 77, column: 5
                S185432=0;
                S185439=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 78, column: 5
                  tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                  S185439=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S185434=0;
                  if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                    tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 78, column: 5
                    S185434=1;
                    if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 78, column: 5
                      S185432=1;
                      if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 79, column: 21
                        m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 82, column: 5
                        S185618=2;
                        if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                          if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 89, column: 5
                            S185618=3;
                            if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                              S185663=0;
                              if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                currsigs.addElement(placed_1);
                                S185663=1;
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
                              S185618=4;
                              S185761=0;
                              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                S185761=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S185756=0;
                                if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                  startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                  S185756=1;
                                  if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                    S185618=5;
                                    S186135=0;
                                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S186135=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S186130=0;
                                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                        S186130=1;
                                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                          S185618=6;
                                          S186553=0;
                                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S186553=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S186548=0;
                                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                              S186548=1;
                                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                S185618=7;
                                                S187015=0;
                                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  S187015=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S187010=0;
                                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    S187010=1;
                                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      S185618=8;
                                                      S187521=0;
                                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S187521=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S187516=0;
                                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          S187516=1;
                                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            S185618=9;
                                                            S188071=0;
                                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S188071=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S188066=0;
                                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                S188066=1;
                                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  S185618=10;
                                                                  S188665=0;
                                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S188665=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S188660=0;
                                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      S188660=1;
                                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        S185618=11;
                                                                        S189303=0;
                                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          S189303=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S189298=0;
                                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            S189298=1;
                                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                              S185618=12;
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
                          S185618=3;
                          if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                            S185663=0;
                            if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                              m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                              placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                              currsigs.addElement(placed_1);
                              S185663=1;
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
                            S185618=4;
                            S185761=0;
                            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                              S185761=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S185756=0;
                              if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                S185756=1;
                                if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                  S185618=5;
                                  S186135=0;
                                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                    S186135=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S186130=0;
                                    if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S186130=1;
                                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                        S185618=6;
                                        S186553=0;
                                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                          S186553=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S186548=0;
                                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S186548=1;
                                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                              S185618=7;
                                              S187015=0;
                                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                S187015=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S187010=0;
                                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  S187010=1;
                                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    S185618=8;
                                                    S187521=0;
                                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S187521=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S187516=0;
                                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S187516=1;
                                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          S185618=9;
                                                          S188071=0;
                                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S188071=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S188066=0;
                                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S188066=1;
                                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                S185618=10;
                                                                S188665=0;
                                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  S188665=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S188660=0;
                                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S188660=1;
                                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      S185618=11;
                                                                      S189303=0;
                                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                        S189303=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S189298=0;
                                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          S189298=1;
                                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                            S185618=12;
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
                S185618=2;
                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 89, column: 5
                    S185618=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                      S185663=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                        currsigs.addElement(placed_1);
                        S185663=1;
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
                      S185618=4;
                      S185761=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                        S185761=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S185756=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                          S185756=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 117, column: 4
                            S185618=5;
                            S186135=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                              S186135=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S186130=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                S186130=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S185618=6;
                                  S186553=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S186553=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S186548=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S186548=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S185618=7;
                                        S187015=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S187015=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S187010=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S187010=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                              S185618=8;
                                              S187521=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S187521=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S187516=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S187516=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S185618=9;
                                                    S188071=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S188071=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S188066=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S188066=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S185618=10;
                                                          S188665=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S188665=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S188660=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S188660=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S185618=11;
                                                                S189303=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S189303=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S189298=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    S189298=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                      S185618=12;
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
                  S185618=3;
                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                    S185663=0;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                      currsigs.addElement(placed_1);
                      S185663=1;
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
                    S185618=4;
                    S185761=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                      S185761=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S185756=0;
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                        S185756=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                          S185618=5;
                          S186135=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            S186135=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S186130=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                              S186130=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                S185618=6;
                                S186553=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S186553=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S186548=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S186548=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S185618=7;
                                      S187015=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S187015=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S187010=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S187010=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S185618=8;
                                            S187521=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S187521=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S187516=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S187516=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S185618=9;
                                                  S188071=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S188071=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S188066=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S188066=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S185618=10;
                                                        S188665=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S188665=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S188660=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S188660=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S185618=11;
                                                              S189303=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                S189303=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S189298=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S189298=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                    S185618=12;
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
            switch(S185432){
              case 0 : 
                switch(S185439){
                  case 0 : 
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 78, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                      S185439=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      switch(S185434){
                        case 0 : 
                          if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                            tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 78, column: 5
                            S185434=1;
                            if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                              tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 78, column: 5
                              S185432=1;
                              if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 79, column: 21
                                m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 82, column: 5
                                S185618=2;
                                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 89, column: 5
                                    S185618=3;
                                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                                      S185663=0;
                                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                        currsigs.addElement(placed_1);
                                        S185663=1;
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
                                      S185618=4;
                                      S185761=0;
                                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                        S185761=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S185756=0;
                                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                          S185756=1;
                                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                            S185618=5;
                                            S186135=0;
                                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                              S186135=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S186130=0;
                                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                                S186130=1;
                                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                                  S185618=6;
                                                  S186553=0;
                                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    S186553=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S186548=0;
                                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      S186548=1;
                                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                        S185618=7;
                                                        S187015=0;
                                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          S187015=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S187010=0;
                                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            S187010=1;
                                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                              S185618=8;
                                                              S187521=0;
                                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                S187521=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S187516=0;
                                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  S187516=1;
                                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                    S185618=9;
                                                                    S188071=0;
                                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      S188071=1;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      S188066=0;
                                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        S188066=1;
                                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          ends[2]=2;
                                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                          S185618=10;
                                                                          S188665=0;
                                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            S188665=1;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S188660=0;
                                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              S188660=1;
                                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                ends[2]=2;
                                                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                                S185618=11;
                                                                                S189303=0;
                                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  S189303=1;
                                                                                  active[2]=1;
                                                                                  ends[2]=1;
                                                                                  tdone[2]=1;
                                                                                }
                                                                                else {
                                                                                  S189298=0;
                                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    S189298=1;
                                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                      ends[2]=2;
                                                                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                                      S185618=12;
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
                                  S185618=3;
                                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                                    S185663=0;
                                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                      currsigs.addElement(placed_1);
                                      S185663=1;
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
                                    S185618=4;
                                    S185761=0;
                                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                      S185761=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S185756=0;
                                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                        S185756=1;
                                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                          S185618=5;
                                          S186135=0;
                                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                            S186135=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S186130=0;
                                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                              S186130=1;
                                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                                S185618=6;
                                                S186553=0;
                                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  S186553=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S186548=0;
                                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    S186548=1;
                                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      S185618=7;
                                                      S187015=0;
                                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        S187015=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S187010=0;
                                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          S187010=1;
                                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            S185618=8;
                                                            S187521=0;
                                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              S187521=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S187516=0;
                                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                S187516=1;
                                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  S185618=9;
                                                                  S188071=0;
                                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    S188071=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S188066=0;
                                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      S188066=1;
                                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        S185618=10;
                                                                        S188665=0;
                                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          S188665=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S188660=0;
                                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            S188660=1;
                                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              S185618=11;
                                                                              S189303=0;
                                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                S189303=1;
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                              else {
                                                                                S189298=0;
                                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  S189298=1;
                                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    ends[2]=2;
                                                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                                    S185618=12;
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
                            S185432=1;
                            if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 79, column: 21
                              m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 82, column: 5
                              S185618=2;
                              if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                                if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 89, column: 5
                                  S185618=3;
                                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                                    S185663=0;
                                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                      currsigs.addElement(placed_1);
                                      S185663=1;
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
                                    S185618=4;
                                    S185761=0;
                                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                      S185761=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S185756=0;
                                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                        S185756=1;
                                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                          S185618=5;
                                          S186135=0;
                                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                            S186135=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S186130=0;
                                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                              S186130=1;
                                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                                S185618=6;
                                                S186553=0;
                                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  S186553=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S186548=0;
                                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    S186548=1;
                                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                      S185618=7;
                                                      S187015=0;
                                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        S187015=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S187010=0;
                                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          S187010=1;
                                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                            S185618=8;
                                                            S187521=0;
                                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              S187521=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S187516=0;
                                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                S187516=1;
                                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                  S185618=9;
                                                                  S188071=0;
                                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    S188071=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S188066=0;
                                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      S188066=1;
                                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                        S185618=10;
                                                                        S188665=0;
                                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          S188665=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S188660=0;
                                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            S188660=1;
                                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                              S185618=11;
                                                                              S189303=0;
                                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                S189303=1;
                                                                                active[2]=1;
                                                                                ends[2]=1;
                                                                                tdone[2]=1;
                                                                              }
                                                                              else {
                                                                                S189298=0;
                                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  S189298=1;
                                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    ends[2]=2;
                                                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                                    S185618=12;
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
                                S185618=3;
                                if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                                  S185663=0;
                                  if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                    m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                    placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                    currsigs.addElement(placed_1);
                                    S185663=1;
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
                                  S185618=4;
                                  S185761=0;
                                  if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                    S185761=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S185756=0;
                                    if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                      startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                      S185756=1;
                                      if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                        S185618=5;
                                        S186135=0;
                                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                          S186135=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S186130=0;
                                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                            startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                            S186130=1;
                                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                              S185618=6;
                                              S186553=0;
                                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                S186553=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S186548=0;
                                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  S186548=1;
                                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    S185618=7;
                                                    S187015=0;
                                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      S187015=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S187010=0;
                                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        S187010=1;
                                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          S185618=8;
                                                          S187521=0;
                                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            S187521=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S187516=0;
                                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              S187516=1;
                                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                S185618=9;
                                                                S188071=0;
                                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  S188071=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S188066=0;
                                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    S188066=1;
                                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      S185618=10;
                                                                      S188665=0;
                                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        S188665=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S188660=0;
                                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          S188660=1;
                                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            S185618=11;
                                                                            S189303=0;
                                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              S189303=1;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              S189298=0;
                                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                S189298=1;
                                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  ends[2]=2;
                                                                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                                  S185618=12;
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
                    S185439=1;
                    S185439=0;
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 78, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                      S185439=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S185434=0;
                      if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                        tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 78, column: 5
                        S185434=1;
                        if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                          tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 78, column: 5
                          S185432=1;
                          if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 79, column: 21
                            m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 82, column: 5
                            S185618=2;
                            if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                              if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 89, column: 5
                                S185618=3;
                                if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                                  S185663=0;
                                  if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                    m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                    placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                    currsigs.addElement(placed_1);
                                    S185663=1;
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
                                  S185618=4;
                                  S185761=0;
                                  if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                    S185761=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S185756=0;
                                    if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                      startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                      S185756=1;
                                      if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                        S185618=5;
                                        S186135=0;
                                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                          S186135=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S186130=0;
                                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                            startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                            S186130=1;
                                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                              S185618=6;
                                              S186553=0;
                                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                S186553=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S186548=0;
                                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  S186548=1;
                                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                    S185618=7;
                                                    S187015=0;
                                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      S187015=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S187010=0;
                                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        S187010=1;
                                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                          S185618=8;
                                                          S187521=0;
                                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            S187521=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S187516=0;
                                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              S187516=1;
                                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                                S185618=9;
                                                                S188071=0;
                                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  S188071=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S188066=0;
                                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    S188066=1;
                                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                      S185618=10;
                                                                      S188665=0;
                                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        S188665=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S188660=0;
                                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          S188660=1;
                                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                            S185618=11;
                                                                            S189303=0;
                                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              S189303=1;
                                                                              active[2]=1;
                                                                              ends[2]=1;
                                                                              tdone[2]=1;
                                                                            }
                                                                            else {
                                                                              S189298=0;
                                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                S189298=1;
                                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  ends[2]=2;
                                                                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                  permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                                  S185618=12;
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
                              S185618=3;
                              if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                                S185663=0;
                                if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                  m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                  placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                  currsigs.addElement(placed_1);
                                  S185663=1;
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
                                S185618=4;
                                S185761=0;
                                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                  S185761=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S185756=0;
                                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                    S185756=1;
                                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                      S185618=5;
                                      S186135=0;
                                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                        S186135=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S186130=0;
                                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                          S186130=1;
                                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                            S185618=6;
                                            S186553=0;
                                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                              S186553=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S186548=0;
                                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                                S186548=1;
                                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                  S185618=7;
                                                  S187015=0;
                                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    S187015=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S187010=0;
                                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      S187010=1;
                                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                        S185618=8;
                                                        S187521=0;
                                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          S187521=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S187516=0;
                                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            S187516=1;
                                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                              S185618=9;
                                                              S188071=0;
                                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                S188071=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S188066=0;
                                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  S188066=1;
                                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                    S185618=10;
                                                                    S188665=0;
                                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      S188665=1;
                                                                      active[2]=1;
                                                                      ends[2]=1;
                                                                      tdone[2]=1;
                                                                    }
                                                                    else {
                                                                      S188660=0;
                                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        S188660=1;
                                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          ends[2]=2;
                                                                          ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                          S185618=11;
                                                                          S189303=0;
                                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            S189303=1;
                                                                            active[2]=1;
                                                                            ends[2]=1;
                                                                            tdone[2]=1;
                                                                          }
                                                                          else {
                                                                            S189298=0;
                                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              S189298=1;
                                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                ends[2]=2;
                                                                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                                S185618=12;
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
                  S185618=2;
                  if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                    if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 89, column: 5
                      S185618=3;
                      if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                        S185663=0;
                        if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                          m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                          placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                          currsigs.addElement(placed_1);
                          S185663=1;
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
                        S185618=4;
                        S185761=0;
                        if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                          S185761=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S185756=0;
                          if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                            S185756=1;
                            if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 117, column: 4
                              S185618=5;
                              S186135=0;
                              if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                S186135=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S186130=0;
                                if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S186130=1;
                                  if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                    S185618=6;
                                    S186553=0;
                                    if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S186553=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S186548=0;
                                      if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S186548=1;
                                        if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                          S185618=7;
                                          S187015=0;
                                          if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S187015=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S187010=0;
                                            if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                              startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                              S187010=1;
                                              if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                S185618=8;
                                                S187521=0;
                                                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S187521=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S187516=0;
                                                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S187516=1;
                                                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S185618=9;
                                                      S188071=0;
                                                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S188071=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S188066=0;
                                                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S188066=1;
                                                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S185618=10;
                                                            S188665=0;
                                                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S188665=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S188660=0;
                                                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S188660=1;
                                                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  S185618=11;
                                                                  S189303=0;
                                                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    S189303=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S189298=0;
                                                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      S189298=1;
                                                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                        permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                        S185618=12;
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
                    S185618=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                      S185663=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                        currsigs.addElement(placed_1);
                        S185663=1;
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
                      S185618=4;
                      S185761=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                        S185761=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S185756=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                          S185756=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 117, column: 4
                            S185618=5;
                            S186135=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                              S186135=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S186130=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                S186130=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S185618=6;
                                  S186553=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S186553=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S186548=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S186548=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S185618=7;
                                        S187015=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S187015=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S187010=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S187010=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                              S185618=8;
                                              S187521=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S187521=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S187516=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S187516=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S185618=9;
                                                    S188071=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S188071=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S188066=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S188066=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S185618=10;
                                                          S188665=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S188665=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S188660=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S188660=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S185618=11;
                                                                S189303=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S189303=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S189298=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    S189298=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                      S185618=12;
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
              S185618=3;
              if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                S185663=0;
                if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                  m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                  placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                  currsigs.addElement(placed_1);
                  S185663=1;
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
                S185618=4;
                S185761=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                  S185761=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S185756=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                    S185756=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 117, column: 4
                      S185618=5;
                      S186135=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                        S186135=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S186130=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                          S186130=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 118, column: 4
                            S185618=6;
                            S186553=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                              S186553=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S186548=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                S186548=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S185618=7;
                                  S187015=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S187015=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S187010=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S187010=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S185618=8;
                                        S187521=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S187521=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S187516=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S187516=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S185618=9;
                                              S188071=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S188071=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S188066=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S188066=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S185618=10;
                                                    S188665=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S188665=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S188660=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S188660=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S185618=11;
                                                          S189303=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S189303=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S189298=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              S189298=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                S185618=12;
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
            switch(S185663){
              case 0 : 
                if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                  m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                  placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                  currsigs.addElement(placed_1);
                  S185663=1;
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
                S185663=1;
                S185618=4;
                S185761=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                  S185761=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S185756=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                    S185756=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 117, column: 4
                      S185618=5;
                      S186135=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                        S186135=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S186130=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                          S186130=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 118, column: 4
                            S185618=6;
                            S186553=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                              S186553=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S186548=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                S186548=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S185618=7;
                                  S187015=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S187015=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S187010=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S187010=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S185618=8;
                                        S187521=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S187521=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S187516=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S187516=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S185618=9;
                                              S188071=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S188071=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S188066=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S188066=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S185618=10;
                                                    S188665=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S188665=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S188660=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S188660=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S185618=11;
                                                          S189303=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S189303=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S189298=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              S189298=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                S185618=12;
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
            switch(S185761){
              case 0 : 
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                  S185761=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S185756){
                    case 0 : 
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                        S185756=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                          S185618=5;
                          S186135=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            S186135=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S186130=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                              S186130=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                S185618=6;
                                S186553=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S186553=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S186548=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S186548=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S185618=7;
                                      S187015=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S187015=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S187010=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S187010=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S185618=8;
                                            S187521=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S187521=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S187516=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S187516=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S185618=9;
                                                  S188071=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S188071=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S188066=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S188066=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S185618=10;
                                                        S188665=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S188665=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S188660=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S188660=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S185618=11;
                                                              S189303=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                S189303=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S189298=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S189298=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                    S185618=12;
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
                        S185618=5;
                        S186135=0;
                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                          S186135=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S186130=0;
                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                            S186130=1;
                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 118, column: 4
                              S185618=6;
                              S186553=0;
                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                S186553=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S186548=0;
                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S186548=1;
                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S185618=7;
                                    S187015=0;
                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S187015=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S187010=0;
                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S187010=1;
                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S185618=8;
                                          S187521=0;
                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S187521=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S187516=0;
                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S187516=1;
                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S185618=9;
                                                S188071=0;
                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S188071=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S188066=0;
                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S188066=1;
                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S185618=10;
                                                      S188665=0;
                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S188665=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S188660=0;
                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S188660=1;
                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S185618=11;
                                                            S189303=0;
                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              S189303=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S189298=0;
                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                S189298=1;
                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                  S185618=12;
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
                S185761=1;
                S185761=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                  S185761=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S185756=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                    startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                    S185756=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 117, column: 4
                      S185618=5;
                      S186135=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                        S186135=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S186130=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                          S186130=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 118, column: 4
                            S185618=6;
                            S186553=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                              S186553=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S186548=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                S186548=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S185618=7;
                                  S187015=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S187015=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S187010=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S187010=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S185618=8;
                                        S187521=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S187521=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S187516=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S187516=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S185618=9;
                                              S188071=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S188071=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S188066=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S188066=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S185618=10;
                                                    S188665=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S188665=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S188660=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S188660=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S185618=11;
                                                          S189303=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S189303=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S189298=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              S189298=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                S185618=12;
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
            switch(S186135){
              case 0 : 
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                  S186135=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S186130){
                    case 0 : 
                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                        S186130=1;
                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 118, column: 4
                          S185618=6;
                          S186553=0;
                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                            S186553=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S186548=0;
                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                              S186548=1;
                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                S185618=7;
                                S187015=0;
                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S187015=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S187010=0;
                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S187010=1;
                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S185618=8;
                                      S187521=0;
                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S187521=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S187516=0;
                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S187516=1;
                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S185618=9;
                                            S188071=0;
                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S188071=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S188066=0;
                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S188066=1;
                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S185618=10;
                                                  S188665=0;
                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    S188665=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S188660=0;
                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S188660=1;
                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S185618=11;
                                                        S189303=0;
                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          S189303=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S189298=0;
                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S189298=1;
                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                              S185618=12;
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
                        S185618=6;
                        S186553=0;
                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                          S186553=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S186548=0;
                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                            S186548=1;
                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 119, column: 4
                              S185618=7;
                              S187015=0;
                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                S187015=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S187010=0;
                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S187010=1;
                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S185618=8;
                                    S187521=0;
                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S187521=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S187516=0;
                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S187516=1;
                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S185618=9;
                                          S188071=0;
                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S188071=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S188066=0;
                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S188066=1;
                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S185618=10;
                                                S188665=0;
                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  S188665=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S188660=0;
                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    S188660=1;
                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S185618=11;
                                                      S189303=0;
                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        S189303=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S189298=0;
                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          S189298=1;
                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                            S185618=12;
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
                S186135=1;
                S186135=0;
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                  S186135=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S186130=0;
                  if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                    startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                    S186130=1;
                    if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 118, column: 4
                      S185618=6;
                      S186553=0;
                      if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                        S186553=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S186548=0;
                        if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                          startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                          S186548=1;
                          if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 119, column: 4
                            S185618=7;
                            S187015=0;
                            if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                              S187015=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S187010=0;
                              if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                S187010=1;
                                if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S185618=8;
                                  S187521=0;
                                  if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S187521=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S187516=0;
                                    if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S187516=1;
                                      if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S185618=9;
                                        S188071=0;
                                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S188071=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S188066=0;
                                          if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S188066=1;
                                            if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S185618=10;
                                              S188665=0;
                                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                S188665=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S188660=0;
                                                if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  S188660=1;
                                                  if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    S185618=11;
                                                    S189303=0;
                                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      S189303=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S189298=0;
                                                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        S189298=1;
                                                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                          S185618=12;
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
            switch(S186553){
              case 0 : 
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                  S186553=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S186548){
                    case 0 : 
                      if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                        startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                        S186548=1;
                        if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 119, column: 4
                          S185618=7;
                          S187015=0;
                          if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                            S187015=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S187010=0;
                            if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                              startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                              S187010=1;
                              if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                S185618=8;
                                S187521=0;
                                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S187521=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S187516=0;
                                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S187516=1;
                                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S185618=9;
                                      S188071=0;
                                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S188071=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S188066=0;
                                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S188066=1;
                                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S185618=10;
                                            S188665=0;
                                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                              S188665=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S188660=0;
                                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                S188660=1;
                                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  S185618=11;
                                                  S189303=0;
                                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    S189303=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S189298=0;
                                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      S189298=1;
                                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                        S185618=12;
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
                        S185618=7;
                        S187015=0;
                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                          S187015=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S187010=0;
                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                            S187010=1;
                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 120, column: 4
                              S185618=8;
                              S187521=0;
                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                S187521=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S187516=0;
                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S187516=1;
                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                    S185618=9;
                                    S188071=0;
                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                      S188071=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S188066=0;
                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S188066=1;
                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                          S185618=10;
                                          S188665=0;
                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                            S188665=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S188660=0;
                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                              S188660=1;
                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                S185618=11;
                                                S189303=0;
                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  S189303=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S189298=0;
                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    S189298=1;
                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                      S185618=12;
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
                S186553=1;
                S186553=0;
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                  S186553=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S186548=0;
                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                    S186548=1;
                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                      S185618=7;
                      S187015=0;
                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                        S187015=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S187010=0;
                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                          S187010=1;
                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                            S185618=8;
                            S187521=0;
                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                              S187521=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S187516=0;
                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                S187516=1;
                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                  S185618=9;
                                  S188071=0;
                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S188071=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S188066=0;
                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                      S188066=1;
                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                        S185618=10;
                                        S188665=0;
                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                          S188665=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S188660=0;
                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                            S188660=1;
                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                              S185618=11;
                                              S189303=0;
                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                S189303=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S189298=0;
                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  S189298=1;
                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                    S185618=12;
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
            switch(S187015){
              case 0 : 
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                  S187015=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S187010){
                    case 0 : 
                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                        startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                        S187010=1;
                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 120, column: 4
                          S185618=8;
                          S187521=0;
                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                            S187521=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S187516=0;
                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                              S187516=1;
                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                S185618=9;
                                S188071=0;
                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                  S188071=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S188066=0;
                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S188066=1;
                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                      S185618=10;
                                      S188665=0;
                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                        S188665=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S188660=0;
                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                          S188660=1;
                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                            S185618=11;
                                            S189303=0;
                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                              S189303=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S189298=0;
                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                S189298=1;
                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                  permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                  S185618=12;
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
                        S185618=8;
                        S187521=0;
                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                          S187521=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S187516=0;
                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                            S187516=1;
                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 122, column: 4
                              S185618=9;
                              S188071=0;
                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                S188071=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S188066=0;
                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                  S188066=1;
                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                    S185618=10;
                                    S188665=0;
                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                      S188665=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S188660=0;
                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                        S188660=1;
                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                          S185618=11;
                                          S189303=0;
                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                            S189303=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S189298=0;
                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                              S189298=1;
                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                S185618=12;
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
                S187015=1;
                S187015=0;
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                  S187015=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S187010=0;
                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                    S187010=1;
                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 120, column: 4
                      S185618=8;
                      S187521=0;
                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                        S187521=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S187516=0;
                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                          S187516=1;
                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 122, column: 4
                            S185618=9;
                            S188071=0;
                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                              S188071=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S188066=0;
                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                S188066=1;
                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                  S185618=10;
                                  S188665=0;
                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                    S188665=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S188660=0;
                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                      S188660=1;
                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                        S185618=11;
                                        S189303=0;
                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                          S189303=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S189298=0;
                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                            S189298=1;
                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                              S185618=12;
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
            switch(S187521){
              case 0 : 
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                  S187521=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S187516){
                    case 0 : 
                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                        S187516=1;
                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                          S185618=9;
                          S188071=0;
                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                            S188071=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S188066=0;
                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                              S188066=1;
                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                S185618=10;
                                S188665=0;
                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                  S188665=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S188660=0;
                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                    S188660=1;
                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                      S185618=11;
                                      S189303=0;
                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                        S189303=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S189298=0;
                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                          S189298=1;
                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                            S185618=12;
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
                        S185618=9;
                        S188071=0;
                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                          S188071=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S188066=0;
                          if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                            doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                            S188066=1;
                            if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 123, column: 4
                              S185618=10;
                              S188665=0;
                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                S188665=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S188660=0;
                                if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                  doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                  S188660=1;
                                  if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                    S185618=11;
                                    S189303=0;
                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                      S189303=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S189298=0;
                                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                        S189298=1;
                                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                          permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                          S185618=12;
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
                S187521=1;
                S187521=0;
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                  S187521=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S187516=0;
                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                    S187516=1;
                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 122, column: 4
                      S185618=9;
                      S188071=0;
                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                        S188071=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S188066=0;
                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                          S188066=1;
                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 123, column: 4
                            S185618=10;
                            S188665=0;
                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                              S188665=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S188660=0;
                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                S188660=1;
                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                  S185618=11;
                                  S189303=0;
                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                    S189303=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S189298=0;
                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                      S189298=1;
                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                        permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                        S185618=12;
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
            switch(S188071){
              case 0 : 
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                  S188071=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S188066){
                    case 0 : 
                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                        S188066=1;
                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                          S185618=10;
                          S188665=0;
                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                            S188665=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S188660=0;
                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                              S188660=1;
                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                S185618=11;
                                S189303=0;
                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                  S189303=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S189298=0;
                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                    S189298=1;
                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                      S185618=12;
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
                        S185618=10;
                        S188665=0;
                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                          S188665=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S188660=0;
                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                            S188660=1;
                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                              S185618=11;
                              S189303=0;
                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                S189303=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S189298=0;
                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                  S189298=1;
                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                    S185618=12;
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
                S188071=1;
                S188071=0;
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                  S188071=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S188066=0;
                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                    S188066=1;
                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 123, column: 4
                      S185618=10;
                      S188665=0;
                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                        S188665=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S188660=0;
                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                          S188660=1;
                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 124, column: 4
                            S185618=11;
                            S189303=0;
                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                              S189303=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S189298=0;
                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                S189298=1;
                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                  permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                  S185618=12;
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
            switch(S188665){
              case 0 : 
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                  S188665=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S188660){
                    case 0 : 
                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                        S188660=1;
                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 124, column: 4
                          S185618=11;
                          S189303=0;
                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                            S189303=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S189298=0;
                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                              S189298=1;
                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                S185618=12;
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
                        S185618=11;
                        S189303=0;
                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                          S189303=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S189298=0;
                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                            S189298=1;
                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                              S185618=12;
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
                S188665=1;
                S188665=0;
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                  S188665=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S188660=0;
                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                    S188660=1;
                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                      S185618=11;
                      S189303=0;
                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                        S189303=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S189298=0;
                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                          S189298=1;
                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                            S185618=12;
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
            switch(S189303){
              case 0 : 
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                  S189303=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S189298){
                    case 0 : 
                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                        S189298=1;
                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 125, column: 4
                          permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                          S185618=12;
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
                        S185618=12;
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
                S189303=1;
                S189303=0;
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                  S189303=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S189298=0;
                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                    S189298=1;
                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                      S185618=12;
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
            S185618=12;
            S185618=13;
            if(!permitted_thread_2){//sysj\rotaryTableController.sysj line: 130, column: 19
              permitted_thread_2 = GuiStep.take("INDEX", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\rotaryTableController.sysj line: 131, column: 17
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              ends[2]=2;
              ;//sysj\rotaryTableController.sysj line: 130, column: 13
              S185618=14;
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
              S185618=14;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 14 : 
            S185618=14;
            S185618=15;
            if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 139, column: 20
              S185618=16;
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
                  S185618=17;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S185618=17;
                  active[2]=1;
                  ends[2]=1;
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
              S185618=16;
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
                  S185618=17;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S185618=17;
                  active[2]=1;
                  ends[2]=1;
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
                S185618=17;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S185618=17;
                active[2]=1;
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
            S185618=17;
            S185618=0;
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 67, column: 20
              S185618=1;
              if(m_thread_2.exitOccupied()){//sysj\rotaryTableController.sysj line: 75, column: 4
                exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj\rotaryTableController.sysj line: 76, column: 5
                m_thread_2.sayUnloading();//sysj\rotaryTableController.sysj line: 77, column: 5
                S185432=0;
                S185439=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 78, column: 5
                  tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                  S185439=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S185434=0;
                  if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                    tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 78, column: 5
                    S185434=1;
                    if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
                      ends[2]=2;
                      ;//sysj\rotaryTableController.sysj line: 78, column: 5
                      S185432=1;
                      if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 79, column: 21
                        m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 82, column: 5
                        S185618=2;
                        if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                          if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 89, column: 5
                            S185618=3;
                            if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                              S185663=0;
                              if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                                m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                                placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                                currsigs.addElement(placed_1);
                                S185663=1;
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
                              S185618=4;
                              S185761=0;
                              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                S185761=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S185756=0;
                                if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                  startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                  S185756=1;
                                  if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                    S185618=5;
                                    S186135=0;
                                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S186135=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S186130=0;
                                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                        S186130=1;
                                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                          S185618=6;
                                          S186553=0;
                                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S186553=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S186548=0;
                                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                              S186548=1;
                                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                                S185618=7;
                                                S187015=0;
                                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  S187015=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S187010=0;
                                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    S187010=1;
                                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                      S185618=8;
                                                      S187521=0;
                                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S187521=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S187516=0;
                                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          S187516=1;
                                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                            S185618=9;
                                                            S188071=0;
                                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S188071=1;
                                                              active[2]=1;
                                                              ends[2]=1;
                                                              tdone[2]=1;
                                                            }
                                                            else {
                                                              S188066=0;
                                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                S188066=1;
                                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  ends[2]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                  S185618=10;
                                                                  S188665=0;
                                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S188665=1;
                                                                    active[2]=1;
                                                                    ends[2]=1;
                                                                    tdone[2]=1;
                                                                  }
                                                                  else {
                                                                    S188660=0;
                                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      S188660=1;
                                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        ends[2]=2;
                                                                        ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                        S185618=11;
                                                                        S189303=0;
                                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          S189303=1;
                                                                          active[2]=1;
                                                                          ends[2]=1;
                                                                          tdone[2]=1;
                                                                        }
                                                                        else {
                                                                          S189298=0;
                                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            S189298=1;
                                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              ends[2]=2;
                                                                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                              S185618=12;
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
                          S185618=3;
                          if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                            S185663=0;
                            if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                              m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                              placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                              currsigs.addElement(placed_1);
                              S185663=1;
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
                            S185618=4;
                            S185761=0;
                            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                              S185761=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S185756=0;
                              if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                                S185756=1;
                                if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 117, column: 4
                                  S185618=5;
                                  S186135=0;
                                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                    S186135=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S186130=0;
                                    if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                      startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                      S186130=1;
                                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                        S185618=6;
                                        S186553=0;
                                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                          S186553=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S186548=0;
                                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                            S186548=1;
                                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                              S185618=7;
                                              S187015=0;
                                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                S187015=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S187010=0;
                                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                                  S187010=1;
                                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                                    S185618=8;
                                                    S187521=0;
                                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                      S187521=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S187516=0;
                                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                        S187516=1;
                                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                          S185618=9;
                                                          S188071=0;
                                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                            S188071=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S188066=0;
                                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                              S188066=1;
                                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                                S185618=10;
                                                                S188665=0;
                                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                  S188665=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S188660=0;
                                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                    S188660=1;
                                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                      S185618=11;
                                                                      S189303=0;
                                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                        S189303=1;
                                                                        active[2]=1;
                                                                        ends[2]=1;
                                                                        tdone[2]=1;
                                                                      }
                                                                      else {
                                                                        S189298=0;
                                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                          S189298=1;
                                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            ends[2]=2;
                                                                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                            S185618=12;
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
                S185618=2;
                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 89, column: 5
                    S185618=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                      S185663=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                        currsigs.addElement(placed_1);
                        S185663=1;
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
                      S185618=4;
                      S185761=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                        S185761=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S185756=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                          S185756=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 117, column: 4
                            S185618=5;
                            S186135=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                              S186135=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S186130=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                S186130=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S185618=6;
                                  S186553=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S186553=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S186548=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S186548=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S185618=7;
                                        S187015=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S187015=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S187010=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S187010=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                              S185618=8;
                                              S187521=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S187521=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S187516=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S187516=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S185618=9;
                                                    S188071=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S188071=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S188066=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S188066=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S185618=10;
                                                          S188665=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S188665=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S188660=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S188660=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S185618=11;
                                                                S189303=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S189303=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S189298=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    S189298=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                      S185618=12;
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
                  S185618=3;
                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                    S185663=0;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                      currsigs.addElement(placed_1);
                      S185663=1;
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
                    S185618=4;
                    S185761=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                      S185761=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S185756=0;
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                        S185756=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                          S185618=5;
                          S186135=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            S186135=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S186130=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                              S186130=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                S185618=6;
                                S186553=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S186553=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S186548=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S186548=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S185618=7;
                                      S187015=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S187015=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S187010=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S187010=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S185618=8;
                                            S187521=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S187521=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S187516=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S187516=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S185618=9;
                                                  S188071=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S188071=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S188066=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S188066=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S185618=10;
                                                        S188665=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S188665=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S188660=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S188660=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S185618=11;
                                                              S189303=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                S189303=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S189298=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S189298=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                    S185618=12;
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

  public void thread213062(int [] tdone, int [] ends){
        S213057=1;
    m_thread_3 = TableModel.shared();//sysj\rotaryTableController.sysj line: 157, column: 3
    w_thread_3 = null;//sysj\rotaryTableController.sysj line: 158, column: 3
    S212917=0;
    S212901=0;
    if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
      tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
      S212901=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S212896=0;
      if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
        tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 160, column: 4
        S212896=1;
        if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 160, column: 4
          tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 160, column: 4
          ends[3]=2;
          ;//sysj\rotaryTableController.sysj line: 160, column: 4
          w_thread_3 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 161, column: 4
          m_thread_3.setPending(w_thread_3);//sysj\rotaryTableController.sysj line: 162, column: 4
          System.out.println("[RT] Accepted " + w_thread_3 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 163, column: 4
          S212917=1;
          if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 164, column: 20
            S212917=2;
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

  public void thread213061(int [] tdone, int [] ends){
        S212893=1;
    t_thread_2 = new RotaryTableTwin();//sysj\rotaryTableController.sysj line: 60, column: 3
    step_thread_2 = 0;//sysj\rotaryTableController.sysj line: 61, column: 3
    m_thread_2 = TableModel.shared();//sysj\rotaryTableController.sysj line: 62, column: 3
    exiting_thread_2 = null;//sysj\rotaryTableController.sysj line: 63, column: 3
    S185618=0;
    if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 67, column: 20
      S185618=1;
      if(m_thread_2.exitOccupied()){//sysj\rotaryTableController.sysj line: 75, column: 4
        exiting_thread_2 = m_thread_2.exitWorkpiece();//sysj\rotaryTableController.sysj line: 76, column: 5
        m_thread_2.sayUnloading();//sysj\rotaryTableController.sysj line: 77, column: 5
        S185432=0;
        S185439=0;
        if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 78, column: 5
          tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
          S185439=1;
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          S185434=0;
          if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
            tableOutfeed_o.setVal(exiting_thread_2);//sysj\rotaryTableController.sysj line: 78, column: 5
            S185434=1;
            if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 78, column: 5
              tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 78, column: 5
              ends[2]=2;
              ;//sysj\rotaryTableController.sysj line: 78, column: 5
              S185432=1;
              if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 79, column: 21
                m_thread_2.clearExit();//sysj\rotaryTableController.sysj line: 82, column: 5
                S185618=2;
                if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
                  if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 89, column: 5
                    S185618=3;
                    if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                      S185663=0;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                        m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                        currsigs.addElement(placed_1);
                        S185663=1;
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
                      S185618=4;
                      S185761=0;
                      if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                        S185761=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        S185756=0;
                        if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                          S185756=1;
                          if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                            startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                            ends[2]=2;
                            ;//sysj\rotaryTableController.sysj line: 117, column: 4
                            S185618=5;
                            S186135=0;
                            if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                              S186135=1;
                              active[2]=1;
                              ends[2]=1;
                              tdone[2]=1;
                            }
                            else {
                              S186130=0;
                              if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                                S186130=1;
                                if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                  ends[2]=2;
                                  ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                  S185618=6;
                                  S186553=0;
                                  if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S186553=1;
                                    active[2]=1;
                                    ends[2]=1;
                                    tdone[2]=1;
                                  }
                                  else {
                                    S186548=0;
                                    if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S186548=1;
                                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                        ends[2]=2;
                                        ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                        S185618=7;
                                        S187015=0;
                                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S187015=1;
                                          active[2]=1;
                                          ends[2]=1;
                                          tdone[2]=1;
                                        }
                                        else {
                                          S187010=0;
                                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S187010=1;
                                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                              ends[2]=2;
                                              ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                              S185618=8;
                                              S187521=0;
                                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S187521=1;
                                                active[2]=1;
                                                ends[2]=1;
                                                tdone[2]=1;
                                              }
                                              else {
                                                S187516=0;
                                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S187516=1;
                                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    ends[2]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                    S185618=9;
                                                    S188071=0;
                                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S188071=1;
                                                      active[2]=1;
                                                      ends[2]=1;
                                                      tdone[2]=1;
                                                    }
                                                    else {
                                                      S188066=0;
                                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S188066=1;
                                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          ends[2]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                          S185618=10;
                                                          S188665=0;
                                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S188665=1;
                                                            active[2]=1;
                                                            ends[2]=1;
                                                            tdone[2]=1;
                                                          }
                                                          else {
                                                            S188660=0;
                                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S188660=1;
                                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                ends[2]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                                S185618=11;
                                                                S189303=0;
                                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S189303=1;
                                                                  active[2]=1;
                                                                  ends[2]=1;
                                                                  tdone[2]=1;
                                                                }
                                                                else {
                                                                  S189298=0;
                                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    S189298=1;
                                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      ends[2]=2;
                                                                      ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                      permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                      S185618=12;
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
                  S185618=3;
                  if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
                    S185663=0;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                      m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                      currsigs.addElement(placed_1);
                      S185663=1;
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
                    S185618=4;
                    S185761=0;
                    if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                      S185761=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S185756=0;
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                        startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                        S185756=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 117, column: 4
                          S185618=5;
                          S186135=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                            S186135=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S186130=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                              startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                              S186130=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 118, column: 4
                                S185618=6;
                                S186553=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                  S186553=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S186548=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                    startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                                    S186548=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                      S185618=7;
                                      S187015=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                        S187015=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S187010=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                          startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                          S187010=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                            S185618=8;
                                            S187521=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                              S187521=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S187516=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                S187516=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                                  S185618=9;
                                                  S188071=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                    S188071=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S188066=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                      S188066=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                        S185618=10;
                                                        S188665=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                          S188665=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S188660=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                            S188660=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                              S185618=11;
                                                              S189303=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                S189303=1;
                                                                active[2]=1;
                                                                ends[2]=1;
                                                                tdone[2]=1;
                                                              }
                                                              else {
                                                                S189298=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                  S189298=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    ends[2]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                                    permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                                    S185618=12;
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
        S185618=2;
        if(m_thread_2.idle()){//sysj\rotaryTableController.sysj line: 88, column: 4
          if(!m_thread_2.hasPending()){//sysj\rotaryTableController.sysj line: 89, column: 11
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            ends[2]=2;
            ;//sysj\rotaryTableController.sysj line: 89, column: 5
            S185618=3;
            if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
              S185663=0;
              if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
                m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
                placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
                currsigs.addElement(placed_1);
                S185663=1;
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
              S185618=4;
              S185761=0;
              if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
                startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                S185761=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S185756=0;
                if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                  startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                  S185756=1;
                  if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                    ends[2]=2;
                    ;//sysj\rotaryTableController.sysj line: 117, column: 4
                    S185618=5;
                    S186135=0;
                    if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                      S186135=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      S186130=0;
                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                        S186130=1;
                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                          ends[2]=2;
                          ;//sysj\rotaryTableController.sysj line: 118, column: 4
                          S185618=6;
                          S186553=0;
                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                            S186553=1;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            S186548=0;
                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                              S186548=1;
                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                                ends[2]=2;
                                ;//sysj\rotaryTableController.sysj line: 119, column: 4
                                S185618=7;
                                S187015=0;
                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S187015=1;
                                  active[2]=1;
                                  ends[2]=1;
                                  tdone[2]=1;
                                }
                                else {
                                  S187010=0;
                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S187010=1;
                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                      ends[2]=2;
                                      ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                      S185618=8;
                                      S187521=0;
                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S187521=1;
                                        active[2]=1;
                                        ends[2]=1;
                                        tdone[2]=1;
                                      }
                                      else {
                                        S187516=0;
                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S187516=1;
                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                            ends[2]=2;
                                            ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                            S185618=9;
                                            S188071=0;
                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S188071=1;
                                              active[2]=1;
                                              ends[2]=1;
                                              tdone[2]=1;
                                            }
                                            else {
                                              S188066=0;
                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S188066=1;
                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  ends[2]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                  S185618=10;
                                                  S188665=0;
                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    S188665=1;
                                                    active[2]=1;
                                                    ends[2]=1;
                                                    tdone[2]=1;
                                                  }
                                                  else {
                                                    S188660=0;
                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S188660=1;
                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        ends[2]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                        S185618=11;
                                                        S189303=0;
                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          S189303=1;
                                                          active[2]=1;
                                                          ends[2]=1;
                                                          tdone[2]=1;
                                                        }
                                                        else {
                                                          S189298=0;
                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            S189298=1;
                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              ends[2]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                              permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                              S185618=12;
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
          S185618=3;
          if(m_thread_2.readyToPlace()){//sysj\rotaryTableController.sysj line: 91, column: 4
            S185663=0;
            if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 92, column: 21
              m_thread_2.commitPending();//sysj\rotaryTableController.sysj line: 95, column: 5
              placed_1.setPresent();//sysj\rotaryTableController.sysj line: 96, column: 5
              currsigs.addElement(placed_1);
              S185663=1;
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
            S185618=4;
            S185761=0;
            if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 117, column: 4
              startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
              S185761=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              S185756=0;
              if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                startFiller1_o.setVal(m_thread_2.at(1));//sysj\rotaryTableController.sysj line: 117, column: 4
                S185756=1;
                if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 117, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 117, column: 4
                  ends[2]=2;
                  ;//sysj\rotaryTableController.sysj line: 117, column: 4
                  S185618=5;
                  S186135=0;
                  if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 118, column: 4
                    startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                    S186135=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S186130=0;
                    if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                      startFiller2_o.setVal(m_thread_2.at(2));//sysj\rotaryTableController.sysj line: 118, column: 4
                      S186130=1;
                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 118, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 118, column: 4
                        ends[2]=2;
                        ;//sysj\rotaryTableController.sysj line: 118, column: 4
                        S185618=6;
                        S186553=0;
                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 119, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                          S186553=1;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          S186548=0;
                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                            startLid_o.setVal(m_thread_2.at(3));//sysj\rotaryTableController.sysj line: 119, column: 4
                            S186548=1;
                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 119, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 119, column: 4
                              ends[2]=2;
                              ;//sysj\rotaryTableController.sysj line: 119, column: 4
                              S185618=7;
                              S187015=0;
                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                S187015=1;
                                active[2]=1;
                                ends[2]=1;
                                tdone[2]=1;
                              }
                              else {
                                S187010=0;
                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                  startCapper_o.setVal(m_thread_2.at(4));//sysj\rotaryTableController.sysj line: 120, column: 4
                                  S187010=1;
                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 120, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 120, column: 4
                                    ends[2]=2;
                                    ;//sysj\rotaryTableController.sysj line: 120, column: 4
                                    S185618=8;
                                    S187521=0;
                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                      S187521=1;
                                      active[2]=1;
                                      ends[2]=1;
                                      tdone[2]=1;
                                    }
                                    else {
                                      S187516=0;
                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 122, column: 4
                                        S187516=1;
                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 122, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 122, column: 4
                                          ends[2]=2;
                                          ;//sysj\rotaryTableController.sysj line: 122, column: 4
                                          S185618=9;
                                          S188071=0;
                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                            S188071=1;
                                            active[2]=1;
                                            ends[2]=1;
                                            tdone[2]=1;
                                          }
                                          else {
                                            S188066=0;
                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 123, column: 4
                                              S188066=1;
                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 123, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 123, column: 4
                                                ends[2]=2;
                                                ;//sysj\rotaryTableController.sysj line: 123, column: 4
                                                S185618=10;
                                                S188665=0;
                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                  S188665=1;
                                                  active[2]=1;
                                                  ends[2]=1;
                                                  tdone[2]=1;
                                                }
                                                else {
                                                  S188660=0;
                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                    S188660=1;
                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      ends[2]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 124, column: 4
                                                      S185618=11;
                                                      S189303=0;
                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                        S189303=1;
                                                        active[2]=1;
                                                        ends[2]=1;
                                                        tdone[2]=1;
                                                      }
                                                      else {
                                                        S189298=0;
                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                          S189298=1;
                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            ends[2]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 125, column: 4
                                                            permitted_thread_2 = false;//sysj\rotaryTableController.sysj line: 128, column: 1
                                                            S185618=12;
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
      switch(S213059){
        case 0 : 
          S213059=0;
          break RUN;
        
        case 1 : 
          S213059=2;
          S213059=2;
          placed_1.setClear();//sysj\rotaryTableController.sysj line: 57, column: 2
          thread213061(tdone,ends);
          thread213062(tdone,ends);
          int biggest213063 = 0;
          if(ends[2]>=biggest213063){
            biggest213063=ends[2];
          }
          if(ends[3]>=biggest213063){
            biggest213063=ends[3];
          }
          if(biggest213063 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          placed_1.setClear();//sysj\rotaryTableController.sysj line: 57, column: 2
          thread213064(tdone,ends);
          thread213065(tdone,ends);
          int biggest213066 = 0;
          if(ends[2]>=biggest213066){
            biggest213066=ends[2];
          }
          if(ends[3]>=biggest213066){
            biggest213066=ends[3];
          }
          if(biggest213066 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest213066 == 0){
            S213059=0;
            active[1]=0;
            ends[1]=0;
            S213059=0;
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
