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
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal reset = new Signal("reset", Signal.INPUT);
  public Signal rotaryTriggerM = new Signal("rotaryTriggerM", Signal.INPUT);
  public Signal loadPos1M = new Signal("loadPos1M", Signal.INPUT);
  public Signal unloadExitM = new Signal("unloadExitM", Signal.INPUT);
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
  private Signal auto_1;
  private Signal manual_1;
  private RotaryTableTwin t_thread_4;//sysj\rotaryTableController.sysj line: 91, column: 3
  private int step_thread_4;//sysj\rotaryTableController.sysj line: 92, column: 3
  private TableModel m_thread_4;//sysj\rotaryTableController.sysj line: 93, column: 3
  private WorkpieceTwin exiting_thread_4;//sysj\rotaryTableController.sysj line: 94, column: 3
  private boolean seen2_thread_4;//sysj\rotaryTableController.sysj line: 95, column: 3
  private boolean seen4_thread_4;//sysj\rotaryTableController.sysj line: 96, column: 3
  private boolean seen5_thread_4;//sysj\rotaryTableController.sysj line: 97, column: 3
  private TableModel m_thread_5;//sysj\rotaryTableController.sysj line: 210, column: 3
  private WorkpieceTwin w_thread_5;//sysj\rotaryTableController.sysj line: 211, column: 3
  private int S310923 = 1;
  private int S263363 = 1;
  private int S310921 = 1;
  private int S279215 = 1;
  private int S279049 = 1;
  private int S263636 = 1;
  private int S263366 = 1;
  private int S263373 = 1;
  private int S263368 = 1;
  private int S263669 = 1;
  private int S263749 = 1;
  private int S263744 = 1;
  private int S263859 = 1;
  private int S263854 = 1;
  private int S264013 = 1;
  private int S264008 = 1;
  private int S264211 = 1;
  private int S264206 = 1;
  private int S264453 = 1;
  private int S264448 = 1;
  private int S264739 = 1;
  private int S264734 = 1;
  private int S265069 = 1;
  private int S265064 = 1;
  private int S265443 = 1;
  private int S265438 = 1;
  private int S279213 = 1;
  private int S279073 = 1;
  private int S279057 = 1;
  private int S279052 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread310937(int [] tdone, int [] ends){
        S279213=1;
    m_thread_5 = TableModel.shared();//sysj\rotaryTableController.sysj line: 210, column: 3
    w_thread_5 = null;//sysj\rotaryTableController.sysj line: 211, column: 3
    S279073=0;
    S279057=0;
    if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 213, column: 4
      tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
      S279057=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S279052=0;
      if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
        tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 213, column: 4
        S279052=1;
        if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
          tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
          ends[5]=2;
          ;//sysj\rotaryTableController.sysj line: 213, column: 4
          w_thread_5 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 214, column: 4
          m_thread_5.setPending(w_thread_5);//sysj\rotaryTableController.sysj line: 215, column: 4
          System.out.println("[RT] Accepted " + w_thread_5 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 216, column: 4
          S279073=1;
          if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 217, column: 20
            S279073=2;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
          }
          else {
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
          }
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
      }
      else {
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
    }
  }

  public void thread310936(int [] tdone, int [] ends){
        S279049=1;
    t_thread_4 = new RotaryTableTwin();//sysj\rotaryTableController.sysj line: 91, column: 3
    step_thread_4 = 0;//sysj\rotaryTableController.sysj line: 92, column: 3
    m_thread_4 = TableModel.shared();//sysj\rotaryTableController.sysj line: 93, column: 3
    exiting_thread_4 = null;//sysj\rotaryTableController.sysj line: 94, column: 3
    seen2_thread_4 = false;//sysj\rotaryTableController.sysj line: 95, column: 3
    seen4_thread_4 = false;//sysj\rotaryTableController.sysj line: 96, column: 3
    seen5_thread_4 = false;//sysj\rotaryTableController.sysj line: 97, column: 3
    S263636=0;
    if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 101, column: 20
      S263636=1;
      if(m_thread_4.exitOccupied()){//sysj\rotaryTableController.sysj line: 109, column: 4
        exiting_thread_4 = m_thread_4.exitWorkpiece();//sysj\rotaryTableController.sysj line: 110, column: 5
        m_thread_4.sayUnloading();//sysj\rotaryTableController.sysj line: 111, column: 5
        S263366=0;
        S263373=0;
        if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 112, column: 5
          tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
          S263373=1;
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          S263368=0;
          if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
            tableOutfeed_o.setVal(exiting_thread_4);//sysj\rotaryTableController.sysj line: 112, column: 5
            S263368=1;
            if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
              tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
              ends[4]=2;
              ;//sysj\rotaryTableController.sysj line: 112, column: 5
              S263366=1;
              if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 21
                S263366=2;
                if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                  m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                  S263636=2;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                  currsigs.addElement(unloadExit);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                if(unloadExitM.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 44
                  S263366=2;
                  if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                    m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                    S263636=2;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                    currsigs.addElement(unloadExit);
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
      else {
        S263636=2;
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

  public void thread310934(int [] tdone, int [] ends){
        switch(S279213){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S279073){
          case 0 : 
            switch(S279057){
              case 0 : 
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 213, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
                  S279057=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S279052){
                    case 0 : 
                      if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
                        tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 213, column: 4
                        S279052=1;
                        if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
                          tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
                          ends[5]=2;
                          ;//sysj\rotaryTableController.sysj line: 213, column: 4
                          w_thread_5 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 214, column: 4
                          m_thread_5.setPending(w_thread_5);//sysj\rotaryTableController.sysj line: 215, column: 4
                          System.out.println("[RT] Accepted " + w_thread_5 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 216, column: 4
                          S279073=1;
                          if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 217, column: 20
                            S279073=2;
                            active[5]=1;
                            ends[5]=1;
                            tdone[5]=1;
                          }
                          else {
                            active[5]=1;
                            ends[5]=1;
                            tdone[5]=1;
                          }
                        }
                        else {
                          active[5]=1;
                          ends[5]=1;
                          tdone[5]=1;
                        }
                      }
                      else {
                        active[5]=1;
                        ends[5]=1;
                        tdone[5]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
                        tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
                        ends[5]=2;
                        ;//sysj\rotaryTableController.sysj line: 213, column: 4
                        w_thread_5 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 214, column: 4
                        m_thread_5.setPending(w_thread_5);//sysj\rotaryTableController.sysj line: 215, column: 4
                        System.out.println("[RT] Accepted " + w_thread_5 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 216, column: 4
                        S279073=1;
                        if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 217, column: 20
                          S279073=2;
                          active[5]=1;
                          ends[5]=1;
                          tdone[5]=1;
                        }
                        else {
                          active[5]=1;
                          ends[5]=1;
                          tdone[5]=1;
                        }
                      }
                      else {
                        active[5]=1;
                        ends[5]=1;
                        tdone[5]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S279057=1;
                S279057=0;
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 213, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
                  S279057=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S279052=0;
                  if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
                    tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 213, column: 4
                    S279052=1;
                    if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
                      tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
                      ends[5]=2;
                      ;//sysj\rotaryTableController.sysj line: 213, column: 4
                      w_thread_5 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 214, column: 4
                      m_thread_5.setPending(w_thread_5);//sysj\rotaryTableController.sysj line: 215, column: 4
                      System.out.println("[RT] Accepted " + w_thread_5 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 216, column: 4
                      S279073=1;
                      if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 217, column: 20
                        S279073=2;
                        active[5]=1;
                        ends[5]=1;
                        tdone[5]=1;
                      }
                      else {
                        active[5]=1;
                        ends[5]=1;
                        tdone[5]=1;
                      }
                    }
                    else {
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                  }
                  else {
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 1 : 
            if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 217, column: 20
              S279073=2;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 2 : 
            S279073=2;
            S279073=0;
            S279057=0;
            if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 213, column: 4
              tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
              S279057=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              S279052=0;
              if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
                tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 213, column: 4
                S279052=1;
                if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
                  ends[5]=2;
                  ;//sysj\rotaryTableController.sysj line: 213, column: 4
                  w_thread_5 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 214, column: 4
                  m_thread_5.setPending(w_thread_5);//sysj\rotaryTableController.sysj line: 215, column: 4
                  System.out.println("[RT] Accepted " + w_thread_5 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 216, column: 4
                  S279073=1;
                  if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 217, column: 20
                    S279073=2;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                }
                else {
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
              }
              else {
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread310933(int [] tdone, int [] ends){
        switch(S279049){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S263636){
          case 0 : 
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 101, column: 20
              S263636=1;
              if(m_thread_4.exitOccupied()){//sysj\rotaryTableController.sysj line: 109, column: 4
                exiting_thread_4 = m_thread_4.exitWorkpiece();//sysj\rotaryTableController.sysj line: 110, column: 5
                m_thread_4.sayUnloading();//sysj\rotaryTableController.sysj line: 111, column: 5
                S263366=0;
                S263373=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 112, column: 5
                  tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                  S263373=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S263368=0;
                  if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                    tableOutfeed_o.setVal(exiting_thread_4);//sysj\rotaryTableController.sysj line: 112, column: 5
                    S263368=1;
                    if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 112, column: 5
                      S263366=1;
                      if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 21
                        S263366=2;
                        if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                          m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                          S263636=2;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                          currsigs.addElement(unloadExit);
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        if(unloadExitM.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 44
                          S263366=2;
                          if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                            m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                            S263636=2;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                            currsigs.addElement(unloadExit);
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
              else {
                S263636=2;
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
            switch(S263366){
              case 0 : 
                switch(S263373){
                  case 0 : 
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 112, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                      S263373=1;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      switch(S263368){
                        case 0 : 
                          if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                            tableOutfeed_o.setVal(exiting_thread_4);//sysj\rotaryTableController.sysj line: 112, column: 5
                            S263368=1;
                            if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                              tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 112, column: 5
                              S263366=1;
                              if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 21
                                S263366=2;
                                if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                                  m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                                  S263636=2;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                                  currsigs.addElement(unloadExit);
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                              }
                              else {
                                if(unloadExitM.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 44
                                  S263366=2;
                                  if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                                    m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                                    S263636=2;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                                    currsigs.addElement(unloadExit);
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
                          if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                            tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 112, column: 5
                            S263366=1;
                            if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 21
                              S263366=2;
                              if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                                m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                                S263636=2;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                                currsigs.addElement(unloadExit);
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                            }
                            else {
                              if(unloadExitM.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 44
                                S263366=2;
                                if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                                  m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                                  S263636=2;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                                  currsigs.addElement(unloadExit);
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
                    S263373=1;
                    S263373=0;
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 112, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                      S263373=1;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263368=0;
                      if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                        tableOutfeed_o.setVal(exiting_thread_4);//sysj\rotaryTableController.sysj line: 112, column: 5
                        S263368=1;
                        if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                          tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 112, column: 5
                          S263366=1;
                          if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 21
                            S263366=2;
                            if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                              m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                              S263636=2;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                              currsigs.addElement(unloadExit);
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                          }
                          else {
                            if(unloadExitM.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 44
                              S263366=2;
                              if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                                m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                                S263636=2;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                                currsigs.addElement(unloadExit);
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
              
              case 1 : 
                if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 21
                  S263366=2;
                  if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                    m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                    S263636=2;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                    currsigs.addElement(unloadExit);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  if(unloadExitM.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 44
                    S263366=2;
                    if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                      m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                      S263636=2;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                      currsigs.addElement(unloadExit);
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
              
              case 2 : 
                if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                  m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                  S263636=2;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                  currsigs.addElement(unloadExit);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 2 : 
            S263636=2;
            S263636=3;
            if(m_thread_4.idle()){//sysj\rotaryTableController.sysj line: 129, column: 4
              if(!m_thread_4.hasPending()){//sysj\rotaryTableController.sysj line: 130, column: 11
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                ends[4]=2;
                ;//sysj\rotaryTableController.sysj line: 130, column: 5
                S263636=4;
                if(m_thread_4.readyToPlace()){//sysj\rotaryTableController.sysj line: 132, column: 4
                  S263669=0;
                  if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 21
                    S263669=1;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                      m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                      currsigs.addElement(placed_1);
                      S263669=2;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 135, column: 6
                      currsigs.addElement(loadPos1);
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    if(loadPos1M.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 44
                      S263669=1;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                        m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                        currsigs.addElement(placed_1);
                        S263669=2;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 135, column: 6
                        currsigs.addElement(loadPos1);
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
                  S263636=5;
                  S263749=0;
                  if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 159, column: 4
                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                    S263749=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S263744=0;
                    if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                      startFiller1_o.setVal(m_thread_4.at(1));//sysj\rotaryTableController.sysj line: 159, column: 4
                      S263744=1;
                      if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                        ends[4]=2;
                        ;//sysj\rotaryTableController.sysj line: 159, column: 4
                        S263636=6;
                        S263859=0;
                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                          S263859=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263854=0;
                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                            startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                            S263854=1;
                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 160, column: 4
                              S263636=7;
                              S264013=0;
                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                S264013=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S264008=0;
                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                  startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                                  S264008=1;
                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                    ends[4]=2;
                                    ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                    S263636=8;
                                    S264211=0;
                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                      S264211=1;
                                      active[4]=1;
                                      ends[4]=1;
                                      tdone[4]=1;
                                    }
                                    else {
                                      S264206=0;
                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                        startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                        S264206=1;
                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                          ends[4]=2;
                                          ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                          S263636=9;
                                          S264453=0;
                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                            S264453=1;
                                            active[4]=1;
                                            ends[4]=1;
                                            tdone[4]=1;
                                          }
                                          else {
                                            S264448=0;
                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                              S264448=1;
                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                                ends[4]=2;
                                                ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                                S263636=10;
                                                S264739=0;
                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  S264739=1;
                                                  active[4]=1;
                                                  ends[4]=1;
                                                  tdone[4]=1;
                                                }
                                                else {
                                                  S264734=0;
                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    S264734=1;
                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      ends[4]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      S263636=11;
                                                      S265069=0;
                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        S265069=1;
                                                        active[4]=1;
                                                        ends[4]=1;
                                                        tdone[4]=1;
                                                      }
                                                      else {
                                                        S265064=0;
                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          S265064=1;
                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            ends[4]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            S263636=12;
                                                            S265443=0;
                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              S265443=1;
                                                              active[4]=1;
                                                              ends[4]=1;
                                                              tdone[4]=1;
                                                            }
                                                            else {
                                                              S265438=0;
                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                S265438=1;
                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  ends[4]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  S263636=13;
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
            }
            else {
              S263636=4;
              if(m_thread_4.readyToPlace()){//sysj\rotaryTableController.sysj line: 132, column: 4
                S263669=0;
                if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 21
                  S263669=1;
                  if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                    m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                    placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                    currsigs.addElement(placed_1);
                    S263669=2;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 135, column: 6
                    currsigs.addElement(loadPos1);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  if(loadPos1M.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 44
                    S263669=1;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                      m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                      currsigs.addElement(placed_1);
                      S263669=2;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 135, column: 6
                      currsigs.addElement(loadPos1);
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
                S263636=5;
                S263749=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 159, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                  S263749=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S263744=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                    startFiller1_o.setVal(m_thread_4.at(1));//sysj\rotaryTableController.sysj line: 159, column: 4
                    S263744=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 159, column: 4
                      S263636=6;
                      S263859=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                        S263859=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263854=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                          S263854=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 160, column: 4
                            S263636=7;
                            S264013=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                              S264013=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S264008=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                                S264008=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                  S263636=8;
                                  S264211=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                    S264211=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S264206=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                      startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                      S264206=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                        S263636=9;
                                        S264453=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                          S264453=1;
                                          active[4]=1;
                                          ends[4]=1;
                                          tdone[4]=1;
                                        }
                                        else {
                                          S264448=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                            S264448=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                              ends[4]=2;
                                              ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                              S263636=10;
                                              S264739=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                S264739=1;
                                                active[4]=1;
                                                ends[4]=1;
                                                tdone[4]=1;
                                              }
                                              else {
                                                S264734=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  S264734=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    ends[4]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    S263636=11;
                                                    S265069=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      S265069=1;
                                                      active[4]=1;
                                                      ends[4]=1;
                                                      tdone[4]=1;
                                                    }
                                                    else {
                                                      S265064=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        S265064=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          ends[4]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          S263636=12;
                                                          S265443=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            S265443=1;
                                                            active[4]=1;
                                                            ends[4]=1;
                                                            tdone[4]=1;
                                                          }
                                                          else {
                                                            S265438=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              S265438=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                ends[4]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                S263636=13;
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
            break;
          
          case 3 : 
            if(!m_thread_4.hasPending()){//sysj\rotaryTableController.sysj line: 130, column: 11
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              ends[4]=2;
              ;//sysj\rotaryTableController.sysj line: 130, column: 5
              S263636=4;
              if(m_thread_4.readyToPlace()){//sysj\rotaryTableController.sysj line: 132, column: 4
                S263669=0;
                if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 21
                  S263669=1;
                  if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                    m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                    placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                    currsigs.addElement(placed_1);
                    S263669=2;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 135, column: 6
                    currsigs.addElement(loadPos1);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  if(loadPos1M.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 44
                    S263669=1;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                      m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                      currsigs.addElement(placed_1);
                      S263669=2;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 135, column: 6
                      currsigs.addElement(loadPos1);
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
                S263636=5;
                S263749=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 159, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                  S263749=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S263744=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                    startFiller1_o.setVal(m_thread_4.at(1));//sysj\rotaryTableController.sysj line: 159, column: 4
                    S263744=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 159, column: 4
                      S263636=6;
                      S263859=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                        S263859=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263854=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                          S263854=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 160, column: 4
                            S263636=7;
                            S264013=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                              S264013=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S264008=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                                S264008=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                  S263636=8;
                                  S264211=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                    S264211=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S264206=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                      startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                      S264206=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                        S263636=9;
                                        S264453=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                          S264453=1;
                                          active[4]=1;
                                          ends[4]=1;
                                          tdone[4]=1;
                                        }
                                        else {
                                          S264448=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                            S264448=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                              ends[4]=2;
                                              ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                              S263636=10;
                                              S264739=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                S264739=1;
                                                active[4]=1;
                                                ends[4]=1;
                                                tdone[4]=1;
                                              }
                                              else {
                                                S264734=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  S264734=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    ends[4]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    S263636=11;
                                                    S265069=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      S265069=1;
                                                      active[4]=1;
                                                      ends[4]=1;
                                                      tdone[4]=1;
                                                    }
                                                    else {
                                                      S265064=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        S265064=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          ends[4]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          S263636=12;
                                                          S265443=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            S265443=1;
                                                            active[4]=1;
                                                            ends[4]=1;
                                                            tdone[4]=1;
                                                          }
                                                          else {
                                                            S265438=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              S265438=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                ends[4]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                S263636=13;
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
            break;
          
          case 4 : 
            switch(S263669){
              case 0 : 
                if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 21
                  S263669=1;
                  if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                    m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                    placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                    currsigs.addElement(placed_1);
                    S263669=2;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 135, column: 6
                    currsigs.addElement(loadPos1);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  if(loadPos1M.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 44
                    S263669=1;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                      m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                      currsigs.addElement(placed_1);
                      S263669=2;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 135, column: 6
                      currsigs.addElement(loadPos1);
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
              
              case 1 : 
                if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                  m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                  placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                  currsigs.addElement(placed_1);
                  S263669=2;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  loadPos1.setPresent();//sysj\rotaryTableController.sysj line: 135, column: 6
                  currsigs.addElement(loadPos1);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 2 : 
                S263669=2;
                S263636=5;
                S263749=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 159, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                  S263749=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S263744=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                    startFiller1_o.setVal(m_thread_4.at(1));//sysj\rotaryTableController.sysj line: 159, column: 4
                    S263744=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 159, column: 4
                      S263636=6;
                      S263859=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                        S263859=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263854=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                          S263854=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 160, column: 4
                            S263636=7;
                            S264013=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                              S264013=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S264008=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                                S264008=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                  S263636=8;
                                  S264211=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                    S264211=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S264206=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                      startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                      S264206=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                        S263636=9;
                                        S264453=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                          S264453=1;
                                          active[4]=1;
                                          ends[4]=1;
                                          tdone[4]=1;
                                        }
                                        else {
                                          S264448=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                            S264448=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                              ends[4]=2;
                                              ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                              S263636=10;
                                              S264739=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                S264739=1;
                                                active[4]=1;
                                                ends[4]=1;
                                                tdone[4]=1;
                                              }
                                              else {
                                                S264734=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  S264734=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    ends[4]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    S263636=11;
                                                    S265069=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      S265069=1;
                                                      active[4]=1;
                                                      ends[4]=1;
                                                      tdone[4]=1;
                                                    }
                                                    else {
                                                      S265064=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        S265064=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          ends[4]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          S263636=12;
                                                          S265443=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            S265443=1;
                                                            active[4]=1;
                                                            ends[4]=1;
                                                            tdone[4]=1;
                                                          }
                                                          else {
                                                            S265438=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              S265438=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                ends[4]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                S263636=13;
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
            switch(S263749){
              case 0 : 
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 159, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                  S263749=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S263744){
                    case 0 : 
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                        startFiller1_o.setVal(m_thread_4.at(1));//sysj\rotaryTableController.sysj line: 159, column: 4
                        S263744=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 159, column: 4
                          S263636=6;
                          S263859=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                            S263859=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263854=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                              startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                              S263854=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                                ends[4]=2;
                                ;//sysj\rotaryTableController.sysj line: 160, column: 4
                                S263636=7;
                                S264013=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                  S264013=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S264008=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                    startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                                    S264008=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                      ends[4]=2;
                                      ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                      S263636=8;
                                      S264211=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                        S264211=1;
                                        active[4]=1;
                                        ends[4]=1;
                                        tdone[4]=1;
                                      }
                                      else {
                                        S264206=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                          startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                          S264206=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                            ends[4]=2;
                                            ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                            S263636=9;
                                            S264453=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                              S264453=1;
                                              active[4]=1;
                                              ends[4]=1;
                                              tdone[4]=1;
                                            }
                                            else {
                                              S264448=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                                S264448=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                                  ends[4]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                                  S263636=10;
                                                  S264739=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    S264739=1;
                                                    active[4]=1;
                                                    ends[4]=1;
                                                    tdone[4]=1;
                                                  }
                                                  else {
                                                    S264734=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      S264734=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                        ends[4]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                        S263636=11;
                                                        S265069=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          S265069=1;
                                                          active[4]=1;
                                                          ends[4]=1;
                                                          tdone[4]=1;
                                                        }
                                                        else {
                                                          S265064=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            S265064=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                              ends[4]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                              S263636=12;
                                                              S265443=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                S265443=1;
                                                                active[4]=1;
                                                                ends[4]=1;
                                                                tdone[4]=1;
                                                              }
                                                              else {
                                                                S265438=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  S265438=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                    ends[4]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                    S263636=13;
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
                      if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                        ends[4]=2;
                        ;//sysj\rotaryTableController.sysj line: 159, column: 4
                        S263636=6;
                        S263859=0;
                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                          S263859=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263854=0;
                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                            startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                            S263854=1;
                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 160, column: 4
                              S263636=7;
                              S264013=0;
                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                S264013=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S264008=0;
                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                  startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                                  S264008=1;
                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                    ends[4]=2;
                                    ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                    S263636=8;
                                    S264211=0;
                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                      S264211=1;
                                      active[4]=1;
                                      ends[4]=1;
                                      tdone[4]=1;
                                    }
                                    else {
                                      S264206=0;
                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                        startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                        S264206=1;
                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                          ends[4]=2;
                                          ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                          S263636=9;
                                          S264453=0;
                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                            S264453=1;
                                            active[4]=1;
                                            ends[4]=1;
                                            tdone[4]=1;
                                          }
                                          else {
                                            S264448=0;
                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                              S264448=1;
                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                                ends[4]=2;
                                                ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                                S263636=10;
                                                S264739=0;
                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  S264739=1;
                                                  active[4]=1;
                                                  ends[4]=1;
                                                  tdone[4]=1;
                                                }
                                                else {
                                                  S264734=0;
                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    S264734=1;
                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      ends[4]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      S263636=11;
                                                      S265069=0;
                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        S265069=1;
                                                        active[4]=1;
                                                        ends[4]=1;
                                                        tdone[4]=1;
                                                      }
                                                      else {
                                                        S265064=0;
                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          S265064=1;
                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            ends[4]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            S263636=12;
                                                            S265443=0;
                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              S265443=1;
                                                              active[4]=1;
                                                              ends[4]=1;
                                                              tdone[4]=1;
                                                            }
                                                            else {
                                                              S265438=0;
                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                S265438=1;
                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  ends[4]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  S263636=13;
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
                S263749=1;
                S263749=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 159, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                  S263749=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S263744=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                    startFiller1_o.setVal(m_thread_4.at(1));//sysj\rotaryTableController.sysj line: 159, column: 4
                    S263744=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 159, column: 4
                      S263636=6;
                      S263859=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                        S263859=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263854=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                          S263854=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 160, column: 4
                            S263636=7;
                            S264013=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                              S264013=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S264008=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                                S264008=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                  S263636=8;
                                  S264211=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                    S264211=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S264206=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                      startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                      S264206=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                        S263636=9;
                                        S264453=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                          S264453=1;
                                          active[4]=1;
                                          ends[4]=1;
                                          tdone[4]=1;
                                        }
                                        else {
                                          S264448=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                            S264448=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                              ends[4]=2;
                                              ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                              S263636=10;
                                              S264739=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                S264739=1;
                                                active[4]=1;
                                                ends[4]=1;
                                                tdone[4]=1;
                                              }
                                              else {
                                                S264734=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  S264734=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    ends[4]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    S263636=11;
                                                    S265069=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      S265069=1;
                                                      active[4]=1;
                                                      ends[4]=1;
                                                      tdone[4]=1;
                                                    }
                                                    else {
                                                      S265064=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        S265064=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          ends[4]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          S263636=12;
                                                          S265443=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            S265443=1;
                                                            active[4]=1;
                                                            ends[4]=1;
                                                            tdone[4]=1;
                                                          }
                                                          else {
                                                            S265438=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              S265438=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                ends[4]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                S263636=13;
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
          
          case 6 : 
            switch(S263859){
              case 0 : 
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                  S263859=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S263854){
                    case 0 : 
                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                        startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                        S263854=1;
                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 160, column: 4
                          S263636=7;
                          S264013=0;
                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                            S264013=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S264008=0;
                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                              startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                              S264008=1;
                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                ends[4]=2;
                                ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                S263636=8;
                                S264211=0;
                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                  S264211=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S264206=0;
                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                    startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                    S264206=1;
                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                      ends[4]=2;
                                      ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                      S263636=9;
                                      S264453=0;
                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                        S264453=1;
                                        active[4]=1;
                                        ends[4]=1;
                                        tdone[4]=1;
                                      }
                                      else {
                                        S264448=0;
                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                          S264448=1;
                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                            ends[4]=2;
                                            ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                            S263636=10;
                                            S264739=0;
                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                              S264739=1;
                                              active[4]=1;
                                              ends[4]=1;
                                              tdone[4]=1;
                                            }
                                            else {
                                              S264734=0;
                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                S264734=1;
                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  ends[4]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  S263636=11;
                                                  S265069=0;
                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                    S265069=1;
                                                    active[4]=1;
                                                    ends[4]=1;
                                                    tdone[4]=1;
                                                  }
                                                  else {
                                                    S265064=0;
                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      S265064=1;
                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        ends[4]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        S263636=12;
                                                        S265443=0;
                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                          S265443=1;
                                                          active[4]=1;
                                                          ends[4]=1;
                                                          tdone[4]=1;
                                                        }
                                                        else {
                                                          S265438=0;
                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            S265438=1;
                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              ends[4]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              S263636=13;
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
                      if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                        ends[4]=2;
                        ;//sysj\rotaryTableController.sysj line: 160, column: 4
                        S263636=7;
                        S264013=0;
                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                          S264013=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S264008=0;
                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                            startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                            S264008=1;
                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 161, column: 4
                              S263636=8;
                              S264211=0;
                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                S264211=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S264206=0;
                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                  startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                  S264206=1;
                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                    ends[4]=2;
                                    ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                    S263636=9;
                                    S264453=0;
                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                      S264453=1;
                                      active[4]=1;
                                      ends[4]=1;
                                      tdone[4]=1;
                                    }
                                    else {
                                      S264448=0;
                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                        S264448=1;
                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                          ends[4]=2;
                                          ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                          S263636=10;
                                          S264739=0;
                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                            S264739=1;
                                            active[4]=1;
                                            ends[4]=1;
                                            tdone[4]=1;
                                          }
                                          else {
                                            S264734=0;
                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                              S264734=1;
                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                ends[4]=2;
                                                ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                S263636=11;
                                                S265069=0;
                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                  S265069=1;
                                                  active[4]=1;
                                                  ends[4]=1;
                                                  tdone[4]=1;
                                                }
                                                else {
                                                  S265064=0;
                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                    S265064=1;
                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      ends[4]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      S263636=12;
                                                      S265443=0;
                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                        S265443=1;
                                                        active[4]=1;
                                                        ends[4]=1;
                                                        tdone[4]=1;
                                                      }
                                                      else {
                                                        S265438=0;
                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                          S265438=1;
                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            ends[4]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            S263636=13;
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
                S263859=1;
                S263859=0;
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                  S263859=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S263854=0;
                  if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                    startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                    S263854=1;
                    if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 160, column: 4
                      S263636=7;
                      S264013=0;
                      if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                        S264013=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S264008=0;
                        if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                          startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                          S264008=1;
                          if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 161, column: 4
                            S263636=8;
                            S264211=0;
                            if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                              S264211=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S264206=0;
                              if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                S264206=1;
                                if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                  S263636=9;
                                  S264453=0;
                                  if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                    S264453=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S264448=0;
                                    if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                      doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                      S264448=1;
                                      if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                        S263636=10;
                                        S264739=0;
                                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                          S264739=1;
                                          active[4]=1;
                                          ends[4]=1;
                                          tdone[4]=1;
                                        }
                                        else {
                                          S264734=0;
                                          if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                            doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                            S264734=1;
                                            if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                              ends[4]=2;
                                              ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                              S263636=11;
                                              S265069=0;
                                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                S265069=1;
                                                active[4]=1;
                                                ends[4]=1;
                                                tdone[4]=1;
                                              }
                                              else {
                                                S265064=0;
                                                if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                  doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                  S265064=1;
                                                  if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                    ends[4]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                    S263636=12;
                                                    S265443=0;
                                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                      S265443=1;
                                                      active[4]=1;
                                                      ends[4]=1;
                                                      tdone[4]=1;
                                                    }
                                                    else {
                                                      S265438=0;
                                                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                        S265438=1;
                                                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                          ends[4]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                          S263636=13;
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
          
          case 7 : 
            switch(S264013){
              case 0 : 
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                  S264013=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S264008){
                    case 0 : 
                      if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                        startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                        S264008=1;
                        if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 161, column: 4
                          S263636=8;
                          S264211=0;
                          if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                            S264211=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S264206=0;
                            if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                              startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                              S264206=1;
                              if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                ends[4]=2;
                                ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                S263636=9;
                                S264453=0;
                                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                  S264453=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S264448=0;
                                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                    S264448=1;
                                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                      ends[4]=2;
                                      ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                      S263636=10;
                                      S264739=0;
                                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                        S264739=1;
                                        active[4]=1;
                                        ends[4]=1;
                                        tdone[4]=1;
                                      }
                                      else {
                                        S264734=0;
                                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                          S264734=1;
                                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                            ends[4]=2;
                                            ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                            S263636=11;
                                            S265069=0;
                                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                              S265069=1;
                                              active[4]=1;
                                              ends[4]=1;
                                              tdone[4]=1;
                                            }
                                            else {
                                              S265064=0;
                                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                S265064=1;
                                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                  ends[4]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                  S263636=12;
                                                  S265443=0;
                                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                    S265443=1;
                                                    active[4]=1;
                                                    ends[4]=1;
                                                    tdone[4]=1;
                                                  }
                                                  else {
                                                    S265438=0;
                                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                      S265438=1;
                                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                        ends[4]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                        S263636=13;
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
                      if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                        ends[4]=2;
                        ;//sysj\rotaryTableController.sysj line: 161, column: 4
                        S263636=8;
                        S264211=0;
                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                          S264211=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S264206=0;
                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                            startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                            S264206=1;
                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 162, column: 4
                              S263636=9;
                              S264453=0;
                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                S264453=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S264448=0;
                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                  S264448=1;
                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                    ends[4]=2;
                                    ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                    S263636=10;
                                    S264739=0;
                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                      S264739=1;
                                      active[4]=1;
                                      ends[4]=1;
                                      tdone[4]=1;
                                    }
                                    else {
                                      S264734=0;
                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                        S264734=1;
                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                          ends[4]=2;
                                          ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                          S263636=11;
                                          S265069=0;
                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                            S265069=1;
                                            active[4]=1;
                                            ends[4]=1;
                                            tdone[4]=1;
                                          }
                                          else {
                                            S265064=0;
                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                              S265064=1;
                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                ends[4]=2;
                                                ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                S263636=12;
                                                S265443=0;
                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                  S265443=1;
                                                  active[4]=1;
                                                  ends[4]=1;
                                                  tdone[4]=1;
                                                }
                                                else {
                                                  S265438=0;
                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                    S265438=1;
                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                      ends[4]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                      S263636=13;
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
                S264013=1;
                S264013=0;
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                  S264013=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S264008=0;
                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                    startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                    S264008=1;
                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 161, column: 4
                      S263636=8;
                      S264211=0;
                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                        S264211=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S264206=0;
                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                          startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                          S264206=1;
                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 162, column: 4
                            S263636=9;
                            S264453=0;
                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                              S264453=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S264448=0;
                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                S264448=1;
                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                  S263636=10;
                                  S264739=0;
                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                    S264739=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S264734=0;
                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                      S264734=1;
                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                        S263636=11;
                                        S265069=0;
                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                          S265069=1;
                                          active[4]=1;
                                          ends[4]=1;
                                          tdone[4]=1;
                                        }
                                        else {
                                          S265064=0;
                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                            S265064=1;
                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                              ends[4]=2;
                                              ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                              S263636=12;
                                              S265443=0;
                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                S265443=1;
                                                active[4]=1;
                                                ends[4]=1;
                                                tdone[4]=1;
                                              }
                                              else {
                                                S265438=0;
                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                  S265438=1;
                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                    ends[4]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                    S263636=13;
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
            switch(S264211){
              case 0 : 
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                  S264211=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S264206){
                    case 0 : 
                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                        startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                        S264206=1;
                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 162, column: 4
                          S263636=9;
                          S264453=0;
                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                            S264453=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S264448=0;
                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                              S264448=1;
                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                ends[4]=2;
                                ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                S263636=10;
                                S264739=0;
                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                  S264739=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S264734=0;
                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                    S264734=1;
                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                      ends[4]=2;
                                      ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                      S263636=11;
                                      S265069=0;
                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                        S265069=1;
                                        active[4]=1;
                                        ends[4]=1;
                                        tdone[4]=1;
                                      }
                                      else {
                                        S265064=0;
                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                          S265064=1;
                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                            ends[4]=2;
                                            ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                            S263636=12;
                                            S265443=0;
                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                              S265443=1;
                                              active[4]=1;
                                              ends[4]=1;
                                              tdone[4]=1;
                                            }
                                            else {
                                              S265438=0;
                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                S265438=1;
                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                  ends[4]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                  S263636=13;
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
                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                        ends[4]=2;
                        ;//sysj\rotaryTableController.sysj line: 162, column: 4
                        S263636=9;
                        S264453=0;
                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                          S264453=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S264448=0;
                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                            S264448=1;
                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 164, column: 4
                              S263636=10;
                              S264739=0;
                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                S264739=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S264734=0;
                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                  S264734=1;
                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                    ends[4]=2;
                                    ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                    S263636=11;
                                    S265069=0;
                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                      S265069=1;
                                      active[4]=1;
                                      ends[4]=1;
                                      tdone[4]=1;
                                    }
                                    else {
                                      S265064=0;
                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                        S265064=1;
                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                          ends[4]=2;
                                          ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                          S263636=12;
                                          S265443=0;
                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                            S265443=1;
                                            active[4]=1;
                                            ends[4]=1;
                                            tdone[4]=1;
                                          }
                                          else {
                                            S265438=0;
                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                              S265438=1;
                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                ends[4]=2;
                                                ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                S263636=13;
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
                S264211=1;
                S264211=0;
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                  S264211=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S264206=0;
                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                    startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                    S264206=1;
                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 162, column: 4
                      S263636=9;
                      S264453=0;
                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                        S264453=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S264448=0;
                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                          S264448=1;
                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 164, column: 4
                            S263636=10;
                            S264739=0;
                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                              S264739=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S264734=0;
                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                S264734=1;
                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                  S263636=11;
                                  S265069=0;
                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                    S265069=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S265064=0;
                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                      S265064=1;
                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                        S263636=12;
                                        S265443=0;
                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                          S265443=1;
                                          active[4]=1;
                                          ends[4]=1;
                                          tdone[4]=1;
                                        }
                                        else {
                                          S265438=0;
                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                            S265438=1;
                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                              ends[4]=2;
                                              ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                              S263636=13;
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
            switch(S264453){
              case 0 : 
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                  S264453=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S264448){
                    case 0 : 
                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                        S264448=1;
                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 164, column: 4
                          S263636=10;
                          S264739=0;
                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                            S264739=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S264734=0;
                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                              S264734=1;
                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                ends[4]=2;
                                ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                S263636=11;
                                S265069=0;
                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                  S265069=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S265064=0;
                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                    S265064=1;
                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                      ends[4]=2;
                                      ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                      S263636=12;
                                      S265443=0;
                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                        S265443=1;
                                        active[4]=1;
                                        ends[4]=1;
                                        tdone[4]=1;
                                      }
                                      else {
                                        S265438=0;
                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                          S265438=1;
                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                            ends[4]=2;
                                            ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                            S263636=13;
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
                      if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                        ends[4]=2;
                        ;//sysj\rotaryTableController.sysj line: 164, column: 4
                        S263636=10;
                        S264739=0;
                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                          S264739=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S264734=0;
                          if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                            doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                            S264734=1;
                            if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 165, column: 4
                              S263636=11;
                              S265069=0;
                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                S265069=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S265064=0;
                                if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                  doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                  S265064=1;
                                  if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                    ends[4]=2;
                                    ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                    S263636=12;
                                    S265443=0;
                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                      S265443=1;
                                      active[4]=1;
                                      ends[4]=1;
                                      tdone[4]=1;
                                    }
                                    else {
                                      S265438=0;
                                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                        S265438=1;
                                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                          ends[4]=2;
                                          ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                          S263636=13;
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
                S264453=1;
                S264453=0;
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                  S264453=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S264448=0;
                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                    S264448=1;
                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 164, column: 4
                      S263636=10;
                      S264739=0;
                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                        S264739=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S264734=0;
                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                          S264734=1;
                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 165, column: 4
                            S263636=11;
                            S265069=0;
                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                              S265069=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S265064=0;
                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                S265064=1;
                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                  S263636=12;
                                  S265443=0;
                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                    S265443=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S265438=0;
                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                      S265438=1;
                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                        S263636=13;
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
          
          case 10 : 
            switch(S264739){
              case 0 : 
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                  S264739=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S264734){
                    case 0 : 
                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                        S264734=1;
                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 165, column: 4
                          S263636=11;
                          S265069=0;
                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                            S265069=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S265064=0;
                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                              S265064=1;
                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                ends[4]=2;
                                ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                S263636=12;
                                S265443=0;
                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                  S265443=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S265438=0;
                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                    S265438=1;
                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                      ends[4]=2;
                                      ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                      S263636=13;
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
                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                        ends[4]=2;
                        ;//sysj\rotaryTableController.sysj line: 165, column: 4
                        S263636=11;
                        S265069=0;
                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                          S265069=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S265064=0;
                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                            S265064=1;
                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 166, column: 4
                              S263636=12;
                              S265443=0;
                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                S265443=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S265438=0;
                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                  S265438=1;
                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                    ends[4]=2;
                                    ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                    S263636=13;
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
                S264739=1;
                S264739=0;
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                  S264739=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S264734=0;
                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                    S264734=1;
                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 165, column: 4
                      S263636=11;
                      S265069=0;
                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                        S265069=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S265064=0;
                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                          S265064=1;
                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 166, column: 4
                            S263636=12;
                            S265443=0;
                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                              S265443=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S265438=0;
                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                S265438=1;
                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                  S263636=13;
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
            switch(S265069){
              case 0 : 
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                  S265069=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265064){
                    case 0 : 
                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                        S265064=1;
                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 166, column: 4
                          S263636=12;
                          S265443=0;
                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                            S265443=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S265438=0;
                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                              S265438=1;
                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                ends[4]=2;
                                ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                S263636=13;
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
                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                        ends[4]=2;
                        ;//sysj\rotaryTableController.sysj line: 166, column: 4
                        S263636=12;
                        S265443=0;
                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                          S265443=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S265438=0;
                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                            S265438=1;
                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 167, column: 4
                              S263636=13;
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
                S265069=1;
                S265069=0;
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                  S265069=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265064=0;
                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                    S265064=1;
                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 166, column: 4
                      S263636=12;
                      S265443=0;
                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                        S265443=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S265438=0;
                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                          S265438=1;
                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 167, column: 4
                            S263636=13;
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
          
          case 12 : 
            switch(S265443){
              case 0 : 
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                  S265443=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265438){
                    case 0 : 
                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                        S265438=1;
                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 167, column: 4
                          S263636=13;
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
                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                        ends[4]=2;
                        ;//sysj\rotaryTableController.sysj line: 167, column: 4
                        S263636=13;
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
                S265443=1;
                S265443=0;
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                  S265443=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265438=0;
                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                    S265438=1;
                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 167, column: 4
                      S263636=13;
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
          
          case 13 : 
            S263636=13;
            S263636=14;
            if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 181, column: 20
              S263636=15;
              if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 182, column: 20
                S263636=16;
                if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 185, column: 20
                  m_thread_4.index();//sysj\rotaryTableController.sysj line: 187, column: 4
                  m_thread_4.report();//sysj\rotaryTableController.sysj line: 188, column: 4
                  seen2_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 4
                  seen4_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 19
                  seen5_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 34
                  if(bottleAtPos2.getprestatus()){//sysj\rotaryTableController.sysj line: 195, column: 12
                    seen2_thread_4 = true;//sysj\rotaryTableController.sysj line: 195, column: 27
                    if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 196, column: 12
                      seen4_thread_4 = true;//sysj\rotaryTableController.sysj line: 196, column: 27
                      if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                        seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                    }
                    else {
                      if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                        seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                    }
                  }
                  else {
                    if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 196, column: 12
                      seen4_thread_4 = true;//sysj\rotaryTableController.sysj line: 196, column: 27
                      if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                        seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                    }
                    else {
                      if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                        seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
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
                rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 183, column: 5
                currsigs.addElement(rotaryTrigger);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              if(rotaryTriggerM.getprestatus()){//sysj\rotaryTableController.sysj line: 181, column: 43
                S263636=15;
                if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 182, column: 20
                  S263636=16;
                  if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 185, column: 20
                    m_thread_4.index();//sysj\rotaryTableController.sysj line: 187, column: 4
                    m_thread_4.report();//sysj\rotaryTableController.sysj line: 188, column: 4
                    seen2_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 4
                    seen4_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 19
                    seen5_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 34
                    if(bottleAtPos2.getprestatus()){//sysj\rotaryTableController.sysj line: 195, column: 12
                      seen2_thread_4 = true;//sysj\rotaryTableController.sysj line: 195, column: 27
                      if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 196, column: 12
                        seen4_thread_4 = true;//sysj\rotaryTableController.sysj line: 196, column: 27
                        if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                          seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                        else {
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                      else {
                        if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                          seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                        else {
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 196, column: 12
                        seen4_thread_4 = true;//sysj\rotaryTableController.sysj line: 196, column: 27
                        if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                          seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                        else {
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                      else {
                        if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                          seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                        else {
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
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
                  rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 183, column: 5
                  currsigs.addElement(rotaryTrigger);
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
          
          case 14 : 
            if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 181, column: 20
              S263636=15;
              if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 182, column: 20
                S263636=16;
                if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 185, column: 20
                  m_thread_4.index();//sysj\rotaryTableController.sysj line: 187, column: 4
                  m_thread_4.report();//sysj\rotaryTableController.sysj line: 188, column: 4
                  seen2_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 4
                  seen4_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 19
                  seen5_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 34
                  if(bottleAtPos2.getprestatus()){//sysj\rotaryTableController.sysj line: 195, column: 12
                    seen2_thread_4 = true;//sysj\rotaryTableController.sysj line: 195, column: 27
                    if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 196, column: 12
                      seen4_thread_4 = true;//sysj\rotaryTableController.sysj line: 196, column: 27
                      if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                        seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                    }
                    else {
                      if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                        seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                    }
                  }
                  else {
                    if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 196, column: 12
                      seen4_thread_4 = true;//sysj\rotaryTableController.sysj line: 196, column: 27
                      if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                        seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                    }
                    else {
                      if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                        seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                        step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                        t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                        t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                        if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                          twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                          currsigs.addElement(twin);
                          twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263636=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
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
                rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 183, column: 5
                currsigs.addElement(rotaryTrigger);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              if(rotaryTriggerM.getprestatus()){//sysj\rotaryTableController.sysj line: 181, column: 43
                S263636=15;
                if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 182, column: 20
                  S263636=16;
                  if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 185, column: 20
                    m_thread_4.index();//sysj\rotaryTableController.sysj line: 187, column: 4
                    m_thread_4.report();//sysj\rotaryTableController.sysj line: 188, column: 4
                    seen2_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 4
                    seen4_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 19
                    seen5_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 34
                    if(bottleAtPos2.getprestatus()){//sysj\rotaryTableController.sysj line: 195, column: 12
                      seen2_thread_4 = true;//sysj\rotaryTableController.sysj line: 195, column: 27
                      if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 196, column: 12
                        seen4_thread_4 = true;//sysj\rotaryTableController.sysj line: 196, column: 27
                        if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                          seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                        else {
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                      else {
                        if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                          seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                        else {
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                    }
                    else {
                      if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 196, column: 12
                        seen4_thread_4 = true;//sysj\rotaryTableController.sysj line: 196, column: 27
                        if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                          seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                        else {
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                      }
                      else {
                        if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                          seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                        else {
                          m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                          step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                          t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                          t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                          if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                            twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                            currsigs.addElement(twin);
                            twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263636=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
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
                  rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 183, column: 5
                  currsigs.addElement(rotaryTrigger);
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
          
          case 15 : 
            if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 182, column: 20
              S263636=16;
              if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 185, column: 20
                m_thread_4.index();//sysj\rotaryTableController.sysj line: 187, column: 4
                m_thread_4.report();//sysj\rotaryTableController.sysj line: 188, column: 4
                seen2_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 4
                seen4_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 19
                seen5_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 34
                if(bottleAtPos2.getprestatus()){//sysj\rotaryTableController.sysj line: 195, column: 12
                  seen2_thread_4 = true;//sysj\rotaryTableController.sysj line: 195, column: 27
                  if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 196, column: 12
                    seen4_thread_4 = true;//sysj\rotaryTableController.sysj line: 196, column: 27
                    if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                      seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                      m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                      step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                      t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                      t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                      if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                    else {
                      m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                      step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                      t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                      t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                      if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                  }
                  else {
                    if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                      seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                      m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                      step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                      t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                      t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                      if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                    else {
                      m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                      step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                      t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                      t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                      if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                  }
                }
                else {
                  if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 196, column: 12
                    seen4_thread_4 = true;//sysj\rotaryTableController.sysj line: 196, column: 27
                    if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                      seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                      m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                      step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                      t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                      t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                      if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                    else {
                      m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                      step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                      t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                      t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                      if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                  }
                  else {
                    if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                      seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                      m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                      step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                      t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                      t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                      if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                    else {
                      m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                      step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                      t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                      t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                      if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                        twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                        currsigs.addElement(twin);
                        twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263636=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
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
              rotaryTrigger.setPresent();//sysj\rotaryTableController.sysj line: 183, column: 5
              currsigs.addElement(rotaryTrigger);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 16 : 
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 185, column: 20
              m_thread_4.index();//sysj\rotaryTableController.sysj line: 187, column: 4
              m_thread_4.report();//sysj\rotaryTableController.sysj line: 188, column: 4
              seen2_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 4
              seen4_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 19
              seen5_thread_4 = false;//sysj\rotaryTableController.sysj line: 194, column: 34
              if(bottleAtPos2.getprestatus()){//sysj\rotaryTableController.sysj line: 195, column: 12
                seen2_thread_4 = true;//sysj\rotaryTableController.sysj line: 195, column: 27
                if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 196, column: 12
                  seen4_thread_4 = true;//sysj\rotaryTableController.sysj line: 196, column: 27
                  if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                    seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                    m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                    step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                    t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                    t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                    if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                    step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                    t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                    t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                    if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                }
                else {
                  if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                    seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                    m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                    step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                    t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                    t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                    if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                    step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                    t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                    t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                    if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                }
              }
              else {
                if(bottleAtPos4.getprestatus()){//sysj\rotaryTableController.sysj line: 196, column: 12
                  seen4_thread_4 = true;//sysj\rotaryTableController.sysj line: 196, column: 27
                  if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                    seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                    m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                    step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                    t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                    t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                    if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                    step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                    t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                    t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                    if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                }
                else {
                  if(bottleAtPos5.getprestatus()){//sysj\rotaryTableController.sysj line: 197, column: 12
                    seen5_thread_4 = true;//sysj\rotaryTableController.sysj line: 197, column: 27
                    m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                    step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                    t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                    t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                    if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    m_thread_4.checkAgainstSensors(seen2_thread_4, seen4_thread_4, seen5_thread_4);//sysj\rotaryTableController.sysj line: 198, column: 4
                    step_thread_4 = (step_thread_4 % 6) + 1;//sysj\rotaryTableController.sysj line: 199, column: 4
                    t_thread_4.setPosition(step_thread_4);//sysj\rotaryTableController.sysj line: 200, column: 4
                    t_thread_4.setRotating(false);//sysj\rotaryTableController.sysj line: 201, column: 4
                    if(t_thread_4.update(PlantClock.now(), MachineStatus.WORKING, "index", "aligned at " + step_thread_4)){//sysj\rotaryTableController.sysj line: 202, column: 4
                      twin.setPresent();//sysj\rotaryTableController.sysj line: 203, column: 5
                      currsigs.addElement(twin);
                      twin.setValue(t_thread_4);//sysj\rotaryTableController.sysj line: 203, column: 5
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263636=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                }
              }
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 17 : 
            S263636=17;
            S263636=0;
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 101, column: 20
              S263636=1;
              if(m_thread_4.exitOccupied()){//sysj\rotaryTableController.sysj line: 109, column: 4
                exiting_thread_4 = m_thread_4.exitWorkpiece();//sysj\rotaryTableController.sysj line: 110, column: 5
                m_thread_4.sayUnloading();//sysj\rotaryTableController.sysj line: 111, column: 5
                S263366=0;
                S263373=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 112, column: 5
                  tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                  S263373=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S263368=0;
                  if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                    tableOutfeed_o.setVal(exiting_thread_4);//sysj\rotaryTableController.sysj line: 112, column: 5
                    S263368=1;
                    if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 112, column: 5
                      S263366=1;
                      if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 21
                        S263366=2;
                        if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                          m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                          S263636=2;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                          currsigs.addElement(unloadExit);
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                      }
                      else {
                        if(unloadExitM.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 44
                          S263366=2;
                          if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                            m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                            S263636=2;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                            currsigs.addElement(unloadExit);
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
              else {
                S263636=2;
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
          
        }
        break;
      
    }
  }

  public void thread310932(int [] tdone, int [] ends){
        switch(S310921){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S279215){
          case 0 : 
            if(reset.getprestatus()){//sysj\rotaryTableController.sysj line: 89, column: 20
              doneFiller1_in.setPreempted();
              doneFiller2_in.setPreempted();
              doneLid_in.setPreempted();
              doneCapper_in.setPreempted();
              tableInfeed_in.setPreempted();
              tableOutfeed_o.setPreempted();
              startFiller1_o.setPreempted();
              startFiller2_o.setPreempted();
              startLid_o.setPreempted();
              startCapper_o.setPreempted();
              S279215=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              thread310933(tdone,ends);
              thread310934(tdone,ends);
              int biggest310935 = 0;
              if(ends[4]>=biggest310935){
                biggest310935=ends[4];
              }
              if(ends[5]>=biggest310935){
                biggest310935=ends[5];
              }
              if(biggest310935 == 1){
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              //FINXME code
              if(biggest310935 == 0){
                S279215=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 1 : 
            S279215=1;
            S279215=0;
            if(reset.getprestatus()){//sysj\rotaryTableController.sysj line: 89, column: 20
              doneFiller1_in.setPreempted();
              doneFiller2_in.setPreempted();
              doneLid_in.setPreempted();
              doneCapper_in.setPreempted();
              tableInfeed_in.setPreempted();
              tableOutfeed_o.setPreempted();
              startFiller1_o.setPreempted();
              startFiller2_o.setPreempted();
              startLid_o.setPreempted();
              startCapper_o.setPreempted();
              S279215=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              thread310936(tdone,ends);
              thread310937(tdone,ends);
              int biggest310938 = 0;
              if(ends[4]>=biggest310938){
                biggest310938=ends[4];
              }
              if(ends[5]>=biggest310938){
                biggest310938=ends[5];
              }
              if(biggest310938 == 1){
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

  public void thread310931(int [] tdone, int [] ends){
        switch(S263363){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\rotaryTableController.sysj line: 73, column: 12
          if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\rotaryTableController.sysj line: 76, column: 8
            auto_1.setPresent();//sysj\rotaryTableController.sysj line: 76, column: 30
            currsigs.addElement(auto_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
          }
          else {
            if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\rotaryTableController.sysj line: 77, column: 13
              manual_1.setPresent();//sysj\rotaryTableController.sysj line: 77, column: 35
              currsigs.addElement(manual_1);
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
        }
        else {
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread310928(int [] tdone, int [] ends){
        S279213=1;
    m_thread_5 = TableModel.shared();//sysj\rotaryTableController.sysj line: 210, column: 3
    w_thread_5 = null;//sysj\rotaryTableController.sysj line: 211, column: 3
    S279073=0;
    S279057=0;
    if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 213, column: 4
      tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
      S279057=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S279052=0;
      if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
        tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 213, column: 4
        S279052=1;
        if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
          tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
          ends[5]=2;
          ;//sysj\rotaryTableController.sysj line: 213, column: 4
          w_thread_5 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 214, column: 4
          m_thread_5.setPending(w_thread_5);//sysj\rotaryTableController.sysj line: 215, column: 4
          System.out.println("[RT] Accepted " + w_thread_5 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 216, column: 4
          S279073=1;
          if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 217, column: 20
            S279073=2;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
          }
          else {
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
          }
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
      }
      else {
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
    }
  }

  public void thread310927(int [] tdone, int [] ends){
        S279049=1;
    t_thread_4 = new RotaryTableTwin();//sysj\rotaryTableController.sysj line: 91, column: 3
    step_thread_4 = 0;//sysj\rotaryTableController.sysj line: 92, column: 3
    m_thread_4 = TableModel.shared();//sysj\rotaryTableController.sysj line: 93, column: 3
    exiting_thread_4 = null;//sysj\rotaryTableController.sysj line: 94, column: 3
    seen2_thread_4 = false;//sysj\rotaryTableController.sysj line: 95, column: 3
    seen4_thread_4 = false;//sysj\rotaryTableController.sysj line: 96, column: 3
    seen5_thread_4 = false;//sysj\rotaryTableController.sysj line: 97, column: 3
    S263636=0;
    if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 101, column: 20
      S263636=1;
      if(m_thread_4.exitOccupied()){//sysj\rotaryTableController.sysj line: 109, column: 4
        exiting_thread_4 = m_thread_4.exitWorkpiece();//sysj\rotaryTableController.sysj line: 110, column: 5
        m_thread_4.sayUnloading();//sysj\rotaryTableController.sysj line: 111, column: 5
        S263366=0;
        S263373=0;
        if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 112, column: 5
          tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
          S263373=1;
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          S263368=0;
          if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
            tableOutfeed_o.setVal(exiting_thread_4);//sysj\rotaryTableController.sysj line: 112, column: 5
            S263368=1;
            if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
              tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
              ends[4]=2;
              ;//sysj\rotaryTableController.sysj line: 112, column: 5
              S263366=1;
              if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 21
                S263366=2;
                if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                  m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                  S263636=2;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                  currsigs.addElement(unloadExit);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
              }
              else {
                if(unloadExitM.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 44
                  S263366=2;
                  if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                    m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                    S263636=2;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    unloadExit.setPresent();//sysj\rotaryTableController.sysj line: 115, column: 6
                    currsigs.addElement(unloadExit);
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
      else {
        S263636=2;
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

  public void thread310926(int [] tdone, int [] ends){
        S310921=1;
    S279215=0;
    if(reset.getprestatus()){//sysj\rotaryTableController.sysj line: 89, column: 20
      doneFiller1_in.setPreempted();
      doneFiller2_in.setPreempted();
      doneLid_in.setPreempted();
      doneCapper_in.setPreempted();
      tableInfeed_in.setPreempted();
      tableOutfeed_o.setPreempted();
      startFiller1_o.setPreempted();
      startFiller2_o.setPreempted();
      startLid_o.setPreempted();
      startCapper_o.setPreempted();
      S279215=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      thread310927(tdone,ends);
      thread310928(tdone,ends);
      int biggest310929 = 0;
      if(ends[4]>=biggest310929){
        biggest310929=ends[4];
      }
      if(ends[5]>=biggest310929){
        biggest310929=ends[5];
      }
      if(biggest310929 == 1){
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
    }
  }

  public void thread310925(int [] tdone, int [] ends){
        S263363=1;
    if(mode.getprestatus()){//sysj\rotaryTableController.sysj line: 73, column: 12
      if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\rotaryTableController.sysj line: 76, column: 8
        auto_1.setPresent();//sysj\rotaryTableController.sysj line: 76, column: 30
        currsigs.addElement(auto_1);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        if((Integer)(mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 1){//sysj\rotaryTableController.sysj line: 77, column: 13
          manual_1.setPresent();//sysj\rotaryTableController.sysj line: 77, column: 35
          currsigs.addElement(manual_1);
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
      switch(S310923){
        case 0 : 
          S310923=0;
          break RUN;
        
        case 1 : 
          S310923=2;
          S310923=2;
          placed_1.setClear();//sysj\rotaryTableController.sysj line: 68, column: 2
          auto_1.setClear();//sysj\rotaryTableController.sysj line: 69, column: 2
          manual_1.setClear();//sysj\rotaryTableController.sysj line: 69, column: 2
          thread310925(tdone,ends);
          thread310926(tdone,ends);
          int biggest310930 = 0;
          if(ends[2]>=biggest310930){
            biggest310930=ends[2];
          }
          if(ends[3]>=biggest310930){
            biggest310930=ends[3];
          }
          if(biggest310930 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          placed_1.setClear();//sysj\rotaryTableController.sysj line: 68, column: 2
          auto_1.setClear();//sysj\rotaryTableController.sysj line: 69, column: 2
          manual_1.setClear();//sysj\rotaryTableController.sysj line: 69, column: 2
          thread310931(tdone,ends);
          thread310932(tdone,ends);
          int biggest310939 = 0;
          if(ends[2]>=biggest310939){
            biggest310939=ends[2];
          }
          if(ends[3]>=biggest310939){
            biggest310939=ends[3];
          }
          if(biggest310939 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest310939 == 0){
            S310923=0;
            active[1]=0;
            ends[1]=0;
            S310923=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    placed_1 = new Signal();
    auto_1 = new Signal();
    manual_1 = new Signal();
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
          mode.gethook();
          reset.gethook();
          rotaryTriggerM.gethook();
          loadPos1M.gethook();
          unloadExitM.gethook();
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
      mode.setpreclear();
      reset.setpreclear();
      rotaryTriggerM.setpreclear();
      loadPos1M.setpreclear();
      unloadExitM.setpreclear();
      twin.setpreclear();
      rotaryTrigger.setpreclear();
      loadPos1.setpreclear();
      unloadExit.setpreclear();
      placed_1.setpreclear();
      auto_1.setpreclear();
      manual_1.setpreclear();
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
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      dummyint = reset.getStatus() ? reset.setprepresent() : reset.setpreclear();
      reset.setpreval(reset.getValue());
      reset.setClear();
      dummyint = rotaryTriggerM.getStatus() ? rotaryTriggerM.setprepresent() : rotaryTriggerM.setpreclear();
      rotaryTriggerM.setpreval(rotaryTriggerM.getValue());
      rotaryTriggerM.setClear();
      dummyint = loadPos1M.getStatus() ? loadPos1M.setprepresent() : loadPos1M.setpreclear();
      loadPos1M.setpreval(loadPos1M.getValue());
      loadPos1M.setClear();
      dummyint = unloadExitM.getStatus() ? unloadExitM.setprepresent() : unloadExitM.setpreclear();
      unloadExitM.setpreval(unloadExitM.getValue());
      unloadExitM.setClear();
      twin.sethook();
      twin.setClear();
      rotaryTrigger.sethook();
      rotaryTrigger.setClear();
      loadPos1.sethook();
      loadPos1.setClear();
      unloadExit.sethook();
      unloadExit.setClear();
      placed_1.setClear();
      auto_1.setClear();
      manual_1.setClear();
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
        mode.gethook();
        reset.gethook();
        rotaryTriggerM.gethook();
        loadPos1M.gethook();
        unloadExitM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
