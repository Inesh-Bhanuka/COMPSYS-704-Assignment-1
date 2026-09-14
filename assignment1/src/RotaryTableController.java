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
  private int S310926 = 1;
  private int S263366 = 1;
  private int S310924 = 1;
  private int S279218 = 1;
  private int S279052 = 1;
  private int S263639 = 1;
  private int S263369 = 1;
  private int S263376 = 1;
  private int S263371 = 1;
  private int S263672 = 1;
  private int S263752 = 1;
  private int S263747 = 1;
  private int S263862 = 1;
  private int S263857 = 1;
  private int S264016 = 1;
  private int S264011 = 1;
  private int S264214 = 1;
  private int S264209 = 1;
  private int S264456 = 1;
  private int S264451 = 1;
  private int S264742 = 1;
  private int S264737 = 1;
  private int S265072 = 1;
  private int S265067 = 1;
  private int S265446 = 1;
  private int S265441 = 1;
  private int S279216 = 1;
  private int S279076 = 1;
  private int S279060 = 1;
  private int S279055 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread310940(int [] tdone, int [] ends){
        S279216=1;
    m_thread_5 = TableModel.shared();//sysj\rotaryTableController.sysj line: 210, column: 3
    w_thread_5 = null;//sysj\rotaryTableController.sysj line: 211, column: 3
    S279076=0;
    S279060=0;
    if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 213, column: 4
      tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
      S279060=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S279055=0;
      if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
        tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 213, column: 4
        S279055=1;
        if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
          tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
          ends[5]=2;
          ;//sysj\rotaryTableController.sysj line: 213, column: 4
          w_thread_5 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 214, column: 4
          m_thread_5.setPending(w_thread_5);//sysj\rotaryTableController.sysj line: 215, column: 4
          System.out.println("[RT] Accepted " + w_thread_5 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 216, column: 4
          S279076=1;
          if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 217, column: 20
            S279076=2;
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

  public void thread310939(int [] tdone, int [] ends){
        S279052=1;
    t_thread_4 = new RotaryTableTwin();//sysj\rotaryTableController.sysj line: 91, column: 3
    step_thread_4 = 0;//sysj\rotaryTableController.sysj line: 92, column: 3
    m_thread_4 = TableModel.shared();//sysj\rotaryTableController.sysj line: 93, column: 3
    exiting_thread_4 = null;//sysj\rotaryTableController.sysj line: 94, column: 3
    seen2_thread_4 = false;//sysj\rotaryTableController.sysj line: 95, column: 3
    seen4_thread_4 = false;//sysj\rotaryTableController.sysj line: 96, column: 3
    seen5_thread_4 = false;//sysj\rotaryTableController.sysj line: 97, column: 3
    S263639=0;
    if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 101, column: 20
      S263639=1;
      if(m_thread_4.exitOccupied()){//sysj\rotaryTableController.sysj line: 109, column: 4
        exiting_thread_4 = m_thread_4.exitWorkpiece();//sysj\rotaryTableController.sysj line: 110, column: 5
        m_thread_4.sayUnloading();//sysj\rotaryTableController.sysj line: 111, column: 5
        S263369=0;
        S263376=0;
        if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 112, column: 5
          tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
          S263376=1;
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          S263371=0;
          if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
            tableOutfeed_o.setVal(exiting_thread_4);//sysj\rotaryTableController.sysj line: 112, column: 5
            S263371=1;
            if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
              tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
              ends[4]=2;
              ;//sysj\rotaryTableController.sysj line: 112, column: 5
              S263369=1;
              if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 21
                S263369=2;
                if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                  m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                  S263639=2;
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
                  S263369=2;
                  if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                    m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                    S263639=2;
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
        S263639=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread310937(int [] tdone, int [] ends){
        switch(S279216){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S279076){
          case 0 : 
            switch(S279060){
              case 0 : 
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 213, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
                  S279060=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S279055){
                    case 0 : 
                      if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
                        tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 213, column: 4
                        S279055=1;
                        if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
                          tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
                          ends[5]=2;
                          ;//sysj\rotaryTableController.sysj line: 213, column: 4
                          w_thread_5 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 214, column: 4
                          m_thread_5.setPending(w_thread_5);//sysj\rotaryTableController.sysj line: 215, column: 4
                          System.out.println("[RT] Accepted " + w_thread_5 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 216, column: 4
                          S279076=1;
                          if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 217, column: 20
                            S279076=2;
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
                        S279076=1;
                        if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 217, column: 20
                          S279076=2;
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
                S279060=1;
                S279060=0;
                if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 213, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
                  S279060=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S279055=0;
                  if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
                    tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 213, column: 4
                    S279055=1;
                    if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
                      tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
                      ends[5]=2;
                      ;//sysj\rotaryTableController.sysj line: 213, column: 4
                      w_thread_5 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 214, column: 4
                      m_thread_5.setPending(w_thread_5);//sysj\rotaryTableController.sysj line: 215, column: 4
                      System.out.println("[RT] Accepted " + w_thread_5 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 216, column: 4
                      S279076=1;
                      if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 217, column: 20
                        S279076=2;
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
              S279076=2;
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
            S279076=2;
            S279076=0;
            S279060=0;
            if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 213, column: 4
              tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
              S279060=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              S279055=0;
              if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
                tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 213, column: 4
                S279055=1;
                if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
                  tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
                  ends[5]=2;
                  ;//sysj\rotaryTableController.sysj line: 213, column: 4
                  w_thread_5 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 214, column: 4
                  m_thread_5.setPending(w_thread_5);//sysj\rotaryTableController.sysj line: 215, column: 4
                  System.out.println("[RT] Accepted " + w_thread_5 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 216, column: 4
                  S279076=1;
                  if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 217, column: 20
                    S279076=2;
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

  public void thread310936(int [] tdone, int [] ends){
        switch(S279052){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S263639){
          case 0 : 
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 101, column: 20
              S263639=1;
              if(m_thread_4.exitOccupied()){//sysj\rotaryTableController.sysj line: 109, column: 4
                exiting_thread_4 = m_thread_4.exitWorkpiece();//sysj\rotaryTableController.sysj line: 110, column: 5
                m_thread_4.sayUnloading();//sysj\rotaryTableController.sysj line: 111, column: 5
                S263369=0;
                S263376=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 112, column: 5
                  tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                  S263376=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S263371=0;
                  if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                    tableOutfeed_o.setVal(exiting_thread_4);//sysj\rotaryTableController.sysj line: 112, column: 5
                    S263371=1;
                    if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 112, column: 5
                      S263369=1;
                      if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 21
                        S263369=2;
                        if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                          m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                          S263639=2;
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
                          S263369=2;
                          if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                            m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                            S263639=2;
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
                S263639=2;
                active[4]=1;
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
            switch(S263369){
              case 0 : 
                switch(S263376){
                  case 0 : 
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 112, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                      S263376=1;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      switch(S263371){
                        case 0 : 
                          if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                            tableOutfeed_o.setVal(exiting_thread_4);//sysj\rotaryTableController.sysj line: 112, column: 5
                            S263371=1;
                            if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                              tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 112, column: 5
                              S263369=1;
                              if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 21
                                S263369=2;
                                if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                                  m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                                  S263639=2;
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
                                  S263369=2;
                                  if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                                    m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                                    S263639=2;
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
                            S263369=1;
                            if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 21
                              S263369=2;
                              if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                                m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                                S263639=2;
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
                                S263369=2;
                                if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                                  m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                                  S263639=2;
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
                    S263376=1;
                    S263376=0;
                    if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 112, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                      S263376=1;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263371=0;
                      if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                        tableOutfeed_o.setVal(exiting_thread_4);//sysj\rotaryTableController.sysj line: 112, column: 5
                        S263371=1;
                        if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                          tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 112, column: 5
                          S263369=1;
                          if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 21
                            S263369=2;
                            if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                              m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                              S263639=2;
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
                              S263369=2;
                              if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                                m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                                S263639=2;
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
                  S263369=2;
                  if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                    m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                    S263639=2;
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
                    S263369=2;
                    if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                      m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                      S263639=2;
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
                  S263639=2;
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
            S263639=2;
            S263639=3;
            if(m_thread_4.idle()){//sysj\rotaryTableController.sysj line: 129, column: 4
              if(!m_thread_4.hasPending()){//sysj\rotaryTableController.sysj line: 130, column: 11
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                ends[4]=2;
                ;//sysj\rotaryTableController.sysj line: 130, column: 5
                S263639=4;
                if(m_thread_4.readyToPlace()){//sysj\rotaryTableController.sysj line: 132, column: 4
                  S263672=0;
                  if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 21
                    S263672=1;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                      m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                      currsigs.addElement(placed_1);
                      S263672=2;
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
                      S263672=1;
                      if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                        m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                        placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                        currsigs.addElement(placed_1);
                        S263672=2;
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
                  S263639=5;
                  S263752=0;
                  if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 159, column: 4
                    startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                    S263752=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S263747=0;
                    if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                      startFiller1_o.setVal(m_thread_4.at(1));//sysj\rotaryTableController.sysj line: 159, column: 4
                      S263747=1;
                      if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                        startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                        ends[4]=2;
                        ;//sysj\rotaryTableController.sysj line: 159, column: 4
                        S263639=6;
                        S263862=0;
                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                          S263862=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263857=0;
                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                            startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                            S263857=1;
                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 160, column: 4
                              S263639=7;
                              S264016=0;
                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                S264016=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S264011=0;
                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                  startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                                  S264011=1;
                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                    ends[4]=2;
                                    ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                    S263639=8;
                                    S264214=0;
                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                      S264214=1;
                                      active[4]=1;
                                      ends[4]=1;
                                      tdone[4]=1;
                                    }
                                    else {
                                      S264209=0;
                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                        startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                        S264209=1;
                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                          ends[4]=2;
                                          ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                          S263639=9;
                                          S264456=0;
                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                            S264456=1;
                                            active[4]=1;
                                            ends[4]=1;
                                            tdone[4]=1;
                                          }
                                          else {
                                            S264451=0;
                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                              S264451=1;
                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                                ends[4]=2;
                                                ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                                S263639=10;
                                                S264742=0;
                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  S264742=1;
                                                  active[4]=1;
                                                  ends[4]=1;
                                                  tdone[4]=1;
                                                }
                                                else {
                                                  S264737=0;
                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    S264737=1;
                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      ends[4]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      S263639=11;
                                                      S265072=0;
                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        S265072=1;
                                                        active[4]=1;
                                                        ends[4]=1;
                                                        tdone[4]=1;
                                                      }
                                                      else {
                                                        S265067=0;
                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          S265067=1;
                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            ends[4]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            S263639=12;
                                                            S265446=0;
                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              S265446=1;
                                                              active[4]=1;
                                                              ends[4]=1;
                                                              tdone[4]=1;
                                                            }
                                                            else {
                                                              S265441=0;
                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                S265441=1;
                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  ends[4]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  S263639=13;
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
              S263639=4;
              if(m_thread_4.readyToPlace()){//sysj\rotaryTableController.sysj line: 132, column: 4
                S263672=0;
                if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 21
                  S263672=1;
                  if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                    m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                    placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                    currsigs.addElement(placed_1);
                    S263672=2;
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
                    S263672=1;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                      m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                      currsigs.addElement(placed_1);
                      S263672=2;
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
                S263639=5;
                S263752=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 159, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                  S263752=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S263747=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                    startFiller1_o.setVal(m_thread_4.at(1));//sysj\rotaryTableController.sysj line: 159, column: 4
                    S263747=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 159, column: 4
                      S263639=6;
                      S263862=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                        S263862=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263857=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                          S263857=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 160, column: 4
                            S263639=7;
                            S264016=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                              S264016=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S264011=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                                S264011=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                  S263639=8;
                                  S264214=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                    S264214=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S264209=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                      startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                      S264209=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                        S263639=9;
                                        S264456=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                          S264456=1;
                                          active[4]=1;
                                          ends[4]=1;
                                          tdone[4]=1;
                                        }
                                        else {
                                          S264451=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                            S264451=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                              ends[4]=2;
                                              ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                              S263639=10;
                                              S264742=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                S264742=1;
                                                active[4]=1;
                                                ends[4]=1;
                                                tdone[4]=1;
                                              }
                                              else {
                                                S264737=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  S264737=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    ends[4]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    S263639=11;
                                                    S265072=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      S265072=1;
                                                      active[4]=1;
                                                      ends[4]=1;
                                                      tdone[4]=1;
                                                    }
                                                    else {
                                                      S265067=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        S265067=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          ends[4]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          S263639=12;
                                                          S265446=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            S265446=1;
                                                            active[4]=1;
                                                            ends[4]=1;
                                                            tdone[4]=1;
                                                          }
                                                          else {
                                                            S265441=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              S265441=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                ends[4]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                S263639=13;
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
              S263639=4;
              if(m_thread_4.readyToPlace()){//sysj\rotaryTableController.sysj line: 132, column: 4
                S263672=0;
                if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 21
                  S263672=1;
                  if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                    m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                    placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                    currsigs.addElement(placed_1);
                    S263672=2;
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
                    S263672=1;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                      m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                      currsigs.addElement(placed_1);
                      S263672=2;
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
                S263639=5;
                S263752=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 159, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                  S263752=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S263747=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                    startFiller1_o.setVal(m_thread_4.at(1));//sysj\rotaryTableController.sysj line: 159, column: 4
                    S263747=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 159, column: 4
                      S263639=6;
                      S263862=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                        S263862=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263857=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                          S263857=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 160, column: 4
                            S263639=7;
                            S264016=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                              S264016=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S264011=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                                S264011=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                  S263639=8;
                                  S264214=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                    S264214=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S264209=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                      startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                      S264209=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                        S263639=9;
                                        S264456=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                          S264456=1;
                                          active[4]=1;
                                          ends[4]=1;
                                          tdone[4]=1;
                                        }
                                        else {
                                          S264451=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                            S264451=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                              ends[4]=2;
                                              ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                              S263639=10;
                                              S264742=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                S264742=1;
                                                active[4]=1;
                                                ends[4]=1;
                                                tdone[4]=1;
                                              }
                                              else {
                                                S264737=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  S264737=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    ends[4]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    S263639=11;
                                                    S265072=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      S265072=1;
                                                      active[4]=1;
                                                      ends[4]=1;
                                                      tdone[4]=1;
                                                    }
                                                    else {
                                                      S265067=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        S265067=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          ends[4]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          S263639=12;
                                                          S265446=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            S265446=1;
                                                            active[4]=1;
                                                            ends[4]=1;
                                                            tdone[4]=1;
                                                          }
                                                          else {
                                                            S265441=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              S265441=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                ends[4]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                S263639=13;
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
            switch(S263672){
              case 0 : 
                if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 133, column: 21
                  S263672=1;
                  if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                    m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                    placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                    currsigs.addElement(placed_1);
                    S263672=2;
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
                    S263672=1;
                    if(bottleAtPos1.getprestatus()){//sysj\rotaryTableController.sysj line: 134, column: 21
                      m_thread_4.commitPending();//sysj\rotaryTableController.sysj line: 137, column: 5
                      placed_1.setPresent();//sysj\rotaryTableController.sysj line: 138, column: 5
                      currsigs.addElement(placed_1);
                      S263672=2;
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
                  S263672=2;
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
                S263672=2;
                S263639=5;
                S263752=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 159, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                  S263752=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S263747=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                    startFiller1_o.setVal(m_thread_4.at(1));//sysj\rotaryTableController.sysj line: 159, column: 4
                    S263747=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 159, column: 4
                      S263639=6;
                      S263862=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                        S263862=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263857=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                          S263857=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 160, column: 4
                            S263639=7;
                            S264016=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                              S264016=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S264011=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                                S264011=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                  S263639=8;
                                  S264214=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                    S264214=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S264209=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                      startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                      S264209=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                        S263639=9;
                                        S264456=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                          S264456=1;
                                          active[4]=1;
                                          ends[4]=1;
                                          tdone[4]=1;
                                        }
                                        else {
                                          S264451=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                            S264451=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                              ends[4]=2;
                                              ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                              S263639=10;
                                              S264742=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                S264742=1;
                                                active[4]=1;
                                                ends[4]=1;
                                                tdone[4]=1;
                                              }
                                              else {
                                                S264737=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  S264737=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    ends[4]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    S263639=11;
                                                    S265072=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      S265072=1;
                                                      active[4]=1;
                                                      ends[4]=1;
                                                      tdone[4]=1;
                                                    }
                                                    else {
                                                      S265067=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        S265067=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          ends[4]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          S263639=12;
                                                          S265446=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            S265446=1;
                                                            active[4]=1;
                                                            ends[4]=1;
                                                            tdone[4]=1;
                                                          }
                                                          else {
                                                            S265441=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              S265441=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                ends[4]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                S263639=13;
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
            switch(S263752){
              case 0 : 
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 159, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                  S263752=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S263747){
                    case 0 : 
                      if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                        startFiller1_o.setVal(m_thread_4.at(1));//sysj\rotaryTableController.sysj line: 159, column: 4
                        S263747=1;
                        if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                          startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 159, column: 4
                          S263639=6;
                          S263862=0;
                          if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                            S263862=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263857=0;
                            if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                              startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                              S263857=1;
                              if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                                startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                                ends[4]=2;
                                ;//sysj\rotaryTableController.sysj line: 160, column: 4
                                S263639=7;
                                S264016=0;
                                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                  S264016=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S264011=0;
                                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                    startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                                    S264011=1;
                                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                      ends[4]=2;
                                      ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                      S263639=8;
                                      S264214=0;
                                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                        S264214=1;
                                        active[4]=1;
                                        ends[4]=1;
                                        tdone[4]=1;
                                      }
                                      else {
                                        S264209=0;
                                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                          startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                          S264209=1;
                                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                            ends[4]=2;
                                            ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                            S263639=9;
                                            S264456=0;
                                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                              S264456=1;
                                              active[4]=1;
                                              ends[4]=1;
                                              tdone[4]=1;
                                            }
                                            else {
                                              S264451=0;
                                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                                S264451=1;
                                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                                  ends[4]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                                  S263639=10;
                                                  S264742=0;
                                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    S264742=1;
                                                    active[4]=1;
                                                    ends[4]=1;
                                                    tdone[4]=1;
                                                  }
                                                  else {
                                                    S264737=0;
                                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      S264737=1;
                                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                        ends[4]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                        S263639=11;
                                                        S265072=0;
                                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          S265072=1;
                                                          active[4]=1;
                                                          ends[4]=1;
                                                          tdone[4]=1;
                                                        }
                                                        else {
                                                          S265067=0;
                                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            S265067=1;
                                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                              ends[4]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                              S263639=12;
                                                              S265446=0;
                                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                S265446=1;
                                                                active[4]=1;
                                                                ends[4]=1;
                                                                tdone[4]=1;
                                                              }
                                                              else {
                                                                S265441=0;
                                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  S265441=1;
                                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                    ends[4]=2;
                                                                    ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                    S263639=13;
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
                        S263639=6;
                        S263862=0;
                        if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                          S263862=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263857=0;
                          if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                            startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                            S263857=1;
                            if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                              startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 160, column: 4
                              S263639=7;
                              S264016=0;
                              if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                S264016=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S264011=0;
                                if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                  startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                                  S264011=1;
                                  if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                    startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                    ends[4]=2;
                                    ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                    S263639=8;
                                    S264214=0;
                                    if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                      S264214=1;
                                      active[4]=1;
                                      ends[4]=1;
                                      tdone[4]=1;
                                    }
                                    else {
                                      S264209=0;
                                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                        startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                        S264209=1;
                                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                          ends[4]=2;
                                          ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                          S263639=9;
                                          S264456=0;
                                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                            S264456=1;
                                            active[4]=1;
                                            ends[4]=1;
                                            tdone[4]=1;
                                          }
                                          else {
                                            S264451=0;
                                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                              S264451=1;
                                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                                ends[4]=2;
                                                ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                                S263639=10;
                                                S264742=0;
                                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  S264742=1;
                                                  active[4]=1;
                                                  ends[4]=1;
                                                  tdone[4]=1;
                                                }
                                                else {
                                                  S264737=0;
                                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    S264737=1;
                                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      ends[4]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                      S263639=11;
                                                      S265072=0;
                                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        S265072=1;
                                                        active[4]=1;
                                                        ends[4]=1;
                                                        tdone[4]=1;
                                                      }
                                                      else {
                                                        S265067=0;
                                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          S265067=1;
                                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            ends[4]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                            S263639=12;
                                                            S265446=0;
                                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              S265446=1;
                                                              active[4]=1;
                                                              ends[4]=1;
                                                              tdone[4]=1;
                                                            }
                                                            else {
                                                              S265441=0;
                                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                S265441=1;
                                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  ends[4]=2;
                                                                  ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                  S263639=13;
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
                S263752=1;
                S263752=0;
                if(!startFiller1_o.isPartnerPresent() || startFiller1_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 159, column: 4
                  startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                  S263752=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S263747=0;
                  if(startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                    startFiller1_o.setVal(m_thread_4.at(1));//sysj\rotaryTableController.sysj line: 159, column: 4
                    S263747=1;
                    if(!startFiller1_o.isACK()){//sysj\rotaryTableController.sysj line: 159, column: 4
                      startFiller1_o.setREQ(false);//sysj\rotaryTableController.sysj line: 159, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 159, column: 4
                      S263639=6;
                      S263862=0;
                      if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                        startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                        S263862=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263857=0;
                        if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                          S263857=1;
                          if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                            startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 160, column: 4
                            S263639=7;
                            S264016=0;
                            if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                              S264016=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S264011=0;
                              if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                                S264011=1;
                                if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                  S263639=8;
                                  S264214=0;
                                  if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                    S264214=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S264209=0;
                                    if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                      startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                      S264209=1;
                                      if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                        S263639=9;
                                        S264456=0;
                                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                          S264456=1;
                                          active[4]=1;
                                          ends[4]=1;
                                          tdone[4]=1;
                                        }
                                        else {
                                          S264451=0;
                                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                            S264451=1;
                                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                              ends[4]=2;
                                              ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                              S263639=10;
                                              S264742=0;
                                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                S264742=1;
                                                active[4]=1;
                                                ends[4]=1;
                                                tdone[4]=1;
                                              }
                                              else {
                                                S264737=0;
                                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  S264737=1;
                                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    ends[4]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                    S263639=11;
                                                    S265072=0;
                                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      S265072=1;
                                                      active[4]=1;
                                                      ends[4]=1;
                                                      tdone[4]=1;
                                                    }
                                                    else {
                                                      S265067=0;
                                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        S265067=1;
                                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          ends[4]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                          S263639=12;
                                                          S265446=0;
                                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            S265446=1;
                                                            active[4]=1;
                                                            ends[4]=1;
                                                            tdone[4]=1;
                                                          }
                                                          else {
                                                            S265441=0;
                                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              S265441=1;
                                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                ends[4]=2;
                                                                ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                                S263639=13;
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
            switch(S263862){
              case 0 : 
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                  S263862=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S263857){
                    case 0 : 
                      if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                        startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                        S263857=1;
                        if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                          startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 160, column: 4
                          S263639=7;
                          S264016=0;
                          if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                            S264016=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S264011=0;
                            if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                              startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                              S264011=1;
                              if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                                startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                                ends[4]=2;
                                ;//sysj\rotaryTableController.sysj line: 161, column: 4
                                S263639=8;
                                S264214=0;
                                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                  S264214=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S264209=0;
                                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                    startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                    S264209=1;
                                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                      ends[4]=2;
                                      ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                      S263639=9;
                                      S264456=0;
                                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                        S264456=1;
                                        active[4]=1;
                                        ends[4]=1;
                                        tdone[4]=1;
                                      }
                                      else {
                                        S264451=0;
                                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                          S264451=1;
                                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                            ends[4]=2;
                                            ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                            S263639=10;
                                            S264742=0;
                                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                              S264742=1;
                                              active[4]=1;
                                              ends[4]=1;
                                              tdone[4]=1;
                                            }
                                            else {
                                              S264737=0;
                                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                S264737=1;
                                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  ends[4]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                  S263639=11;
                                                  S265072=0;
                                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                    S265072=1;
                                                    active[4]=1;
                                                    ends[4]=1;
                                                    tdone[4]=1;
                                                  }
                                                  else {
                                                    S265067=0;
                                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      S265067=1;
                                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        ends[4]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                        S263639=12;
                                                        S265446=0;
                                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                          S265446=1;
                                                          active[4]=1;
                                                          ends[4]=1;
                                                          tdone[4]=1;
                                                        }
                                                        else {
                                                          S265441=0;
                                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            S265441=1;
                                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              ends[4]=2;
                                                              ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                              S263639=13;
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
                        S263639=7;
                        S264016=0;
                        if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                          S264016=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S264011=0;
                          if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                            startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                            S264011=1;
                            if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                              startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 161, column: 4
                              S263639=8;
                              S264214=0;
                              if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                S264214=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S264209=0;
                                if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                  startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                  S264209=1;
                                  if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                    startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                    ends[4]=2;
                                    ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                    S263639=9;
                                    S264456=0;
                                    if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                      S264456=1;
                                      active[4]=1;
                                      ends[4]=1;
                                      tdone[4]=1;
                                    }
                                    else {
                                      S264451=0;
                                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                        S264451=1;
                                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                          ends[4]=2;
                                          ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                          S263639=10;
                                          S264742=0;
                                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                            S264742=1;
                                            active[4]=1;
                                            ends[4]=1;
                                            tdone[4]=1;
                                          }
                                          else {
                                            S264737=0;
                                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                              S264737=1;
                                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                                ends[4]=2;
                                                ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                                S263639=11;
                                                S265072=0;
                                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                  S265072=1;
                                                  active[4]=1;
                                                  ends[4]=1;
                                                  tdone[4]=1;
                                                }
                                                else {
                                                  S265067=0;
                                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                    S265067=1;
                                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      ends[4]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                      S263639=12;
                                                      S265446=0;
                                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                        S265446=1;
                                                        active[4]=1;
                                                        ends[4]=1;
                                                        tdone[4]=1;
                                                      }
                                                      else {
                                                        S265441=0;
                                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                          S265441=1;
                                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            ends[4]=2;
                                                            ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                            S263639=13;
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
                S263862=1;
                S263862=0;
                if(!startFiller2_o.isPartnerPresent() || startFiller2_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 160, column: 4
                  startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                  S263862=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S263857=0;
                  if(startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                    startFiller2_o.setVal(m_thread_4.at(2));//sysj\rotaryTableController.sysj line: 160, column: 4
                    S263857=1;
                    if(!startFiller2_o.isACK()){//sysj\rotaryTableController.sysj line: 160, column: 4
                      startFiller2_o.setREQ(false);//sysj\rotaryTableController.sysj line: 160, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 160, column: 4
                      S263639=7;
                      S264016=0;
                      if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                        startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                        S264016=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S264011=0;
                        if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                          startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                          S264011=1;
                          if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                            startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 161, column: 4
                            S263639=8;
                            S264214=0;
                            if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                              S264214=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S264209=0;
                              if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                                S264209=1;
                                if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                  S263639=9;
                                  S264456=0;
                                  if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                    S264456=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S264451=0;
                                    if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                      doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                      S264451=1;
                                      if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                        S263639=10;
                                        S264742=0;
                                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                          S264742=1;
                                          active[4]=1;
                                          ends[4]=1;
                                          tdone[4]=1;
                                        }
                                        else {
                                          S264737=0;
                                          if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                            doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                            S264737=1;
                                            if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                              ends[4]=2;
                                              ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                              S263639=11;
                                              S265072=0;
                                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                S265072=1;
                                                active[4]=1;
                                                ends[4]=1;
                                                tdone[4]=1;
                                              }
                                              else {
                                                S265067=0;
                                                if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                  doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                  S265067=1;
                                                  if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                    ends[4]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                    S263639=12;
                                                    S265446=0;
                                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                      S265446=1;
                                                      active[4]=1;
                                                      ends[4]=1;
                                                      tdone[4]=1;
                                                    }
                                                    else {
                                                      S265441=0;
                                                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                        S265441=1;
                                                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                          ends[4]=2;
                                                          ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                          S263639=13;
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
            switch(S264016){
              case 0 : 
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                  S264016=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S264011){
                    case 0 : 
                      if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                        startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                        S264011=1;
                        if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                          startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 161, column: 4
                          S263639=8;
                          S264214=0;
                          if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                            S264214=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S264209=0;
                            if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                              startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                              S264209=1;
                              if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                                startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                                ends[4]=2;
                                ;//sysj\rotaryTableController.sysj line: 162, column: 4
                                S263639=9;
                                S264456=0;
                                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                  S264456=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S264451=0;
                                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                    S264451=1;
                                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                      ends[4]=2;
                                      ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                      S263639=10;
                                      S264742=0;
                                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                        S264742=1;
                                        active[4]=1;
                                        ends[4]=1;
                                        tdone[4]=1;
                                      }
                                      else {
                                        S264737=0;
                                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                          S264737=1;
                                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                            ends[4]=2;
                                            ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                            S263639=11;
                                            S265072=0;
                                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                              S265072=1;
                                              active[4]=1;
                                              ends[4]=1;
                                              tdone[4]=1;
                                            }
                                            else {
                                              S265067=0;
                                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                S265067=1;
                                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                  ends[4]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                  S263639=12;
                                                  S265446=0;
                                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                    S265446=1;
                                                    active[4]=1;
                                                    ends[4]=1;
                                                    tdone[4]=1;
                                                  }
                                                  else {
                                                    S265441=0;
                                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                      S265441=1;
                                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                        ends[4]=2;
                                                        ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                        S263639=13;
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
                        S263639=8;
                        S264214=0;
                        if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                          S264214=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S264209=0;
                          if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                            startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                            S264209=1;
                            if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                              startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 162, column: 4
                              S263639=9;
                              S264456=0;
                              if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                S264456=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S264451=0;
                                if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                  doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                  S264451=1;
                                  if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                    doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                    ends[4]=2;
                                    ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                    S263639=10;
                                    S264742=0;
                                    if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                      S264742=1;
                                      active[4]=1;
                                      ends[4]=1;
                                      tdone[4]=1;
                                    }
                                    else {
                                      S264737=0;
                                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                        S264737=1;
                                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                          ends[4]=2;
                                          ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                          S263639=11;
                                          S265072=0;
                                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                            S265072=1;
                                            active[4]=1;
                                            ends[4]=1;
                                            tdone[4]=1;
                                          }
                                          else {
                                            S265067=0;
                                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                              S265067=1;
                                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                                ends[4]=2;
                                                ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                                S263639=12;
                                                S265446=0;
                                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                  S265446=1;
                                                  active[4]=1;
                                                  ends[4]=1;
                                                  tdone[4]=1;
                                                }
                                                else {
                                                  S265441=0;
                                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                    S265441=1;
                                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                      ends[4]=2;
                                                      ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                      S263639=13;
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
                S264016=1;
                S264016=0;
                if(!startLid_o.isPartnerPresent() || startLid_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 161, column: 4
                  startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                  S264016=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S264011=0;
                  if(startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                    startLid_o.setVal(m_thread_4.at(3));//sysj\rotaryTableController.sysj line: 161, column: 4
                    S264011=1;
                    if(!startLid_o.isACK()){//sysj\rotaryTableController.sysj line: 161, column: 4
                      startLid_o.setREQ(false);//sysj\rotaryTableController.sysj line: 161, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 161, column: 4
                      S263639=8;
                      S264214=0;
                      if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                        startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                        S264214=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S264209=0;
                        if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                          startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                          S264209=1;
                          if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                            startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 162, column: 4
                            S263639=9;
                            S264456=0;
                            if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                              S264456=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S264451=0;
                              if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                                S264451=1;
                                if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                  S263639=10;
                                  S264742=0;
                                  if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                    S264742=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S264737=0;
                                    if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                      doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                      S264737=1;
                                      if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                        S263639=11;
                                        S265072=0;
                                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                          S265072=1;
                                          active[4]=1;
                                          ends[4]=1;
                                          tdone[4]=1;
                                        }
                                        else {
                                          S265067=0;
                                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                            S265067=1;
                                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                              ends[4]=2;
                                              ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                              S263639=12;
                                              S265446=0;
                                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                S265446=1;
                                                active[4]=1;
                                                ends[4]=1;
                                                tdone[4]=1;
                                              }
                                              else {
                                                S265441=0;
                                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                  S265441=1;
                                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                    ends[4]=2;
                                                    ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                    S263639=13;
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
            switch(S264214){
              case 0 : 
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                  S264214=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S264209){
                    case 0 : 
                      if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                        startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                        S264209=1;
                        if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                          startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 162, column: 4
                          S263639=9;
                          S264456=0;
                          if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                            S264456=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S264451=0;
                            if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                              doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                              S264451=1;
                              if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                                doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                                ends[4]=2;
                                ;//sysj\rotaryTableController.sysj line: 164, column: 4
                                S263639=10;
                                S264742=0;
                                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                  S264742=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S264737=0;
                                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                    S264737=1;
                                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                      ends[4]=2;
                                      ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                      S263639=11;
                                      S265072=0;
                                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                        S265072=1;
                                        active[4]=1;
                                        ends[4]=1;
                                        tdone[4]=1;
                                      }
                                      else {
                                        S265067=0;
                                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                          S265067=1;
                                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                            ends[4]=2;
                                            ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                            S263639=12;
                                            S265446=0;
                                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                              S265446=1;
                                              active[4]=1;
                                              ends[4]=1;
                                              tdone[4]=1;
                                            }
                                            else {
                                              S265441=0;
                                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                S265441=1;
                                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                  ends[4]=2;
                                                  ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                  S263639=13;
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
                        S263639=9;
                        S264456=0;
                        if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                          S264456=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S264451=0;
                          if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                            doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                            S264451=1;
                            if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                              doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 164, column: 4
                              S263639=10;
                              S264742=0;
                              if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                S264742=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S264737=0;
                                if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                  doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                  S264737=1;
                                  if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                    doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                    ends[4]=2;
                                    ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                    S263639=11;
                                    S265072=0;
                                    if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                      S265072=1;
                                      active[4]=1;
                                      ends[4]=1;
                                      tdone[4]=1;
                                    }
                                    else {
                                      S265067=0;
                                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                        S265067=1;
                                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                          ends[4]=2;
                                          ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                          S263639=12;
                                          S265446=0;
                                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                            S265446=1;
                                            active[4]=1;
                                            ends[4]=1;
                                            tdone[4]=1;
                                          }
                                          else {
                                            S265441=0;
                                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                              S265441=1;
                                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                                ends[4]=2;
                                                ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                                S263639=13;
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
                S264214=1;
                S264214=0;
                if(!startCapper_o.isPartnerPresent() || startCapper_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 162, column: 4
                  startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                  S264214=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S264209=0;
                  if(startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                    startCapper_o.setVal(m_thread_4.at(4));//sysj\rotaryTableController.sysj line: 162, column: 4
                    S264209=1;
                    if(!startCapper_o.isACK()){//sysj\rotaryTableController.sysj line: 162, column: 4
                      startCapper_o.setREQ(false);//sysj\rotaryTableController.sysj line: 162, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 162, column: 4
                      S263639=9;
                      S264456=0;
                      if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                        doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                        S264456=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S264451=0;
                        if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                          doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                          S264451=1;
                          if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                            doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 164, column: 4
                            S263639=10;
                            S264742=0;
                            if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                              S264742=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S264737=0;
                              if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                                S264737=1;
                                if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                  S263639=11;
                                  S265072=0;
                                  if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                    S265072=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S265067=0;
                                    if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                      doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                      S265067=1;
                                      if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                        S263639=12;
                                        S265446=0;
                                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                          S265446=1;
                                          active[4]=1;
                                          ends[4]=1;
                                          tdone[4]=1;
                                        }
                                        else {
                                          S265441=0;
                                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                            S265441=1;
                                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                              ends[4]=2;
                                              ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                              S263639=13;
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
            switch(S264456){
              case 0 : 
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                  S264456=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S264451){
                    case 0 : 
                      if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                        doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                        S264451=1;
                        if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                          doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 164, column: 4
                          S263639=10;
                          S264742=0;
                          if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                            S264742=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S264737=0;
                            if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                              doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                              S264737=1;
                              if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                                doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                                ends[4]=2;
                                ;//sysj\rotaryTableController.sysj line: 165, column: 4
                                S263639=11;
                                S265072=0;
                                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                  S265072=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S265067=0;
                                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                    S265067=1;
                                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                      ends[4]=2;
                                      ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                      S263639=12;
                                      S265446=0;
                                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                        S265446=1;
                                        active[4]=1;
                                        ends[4]=1;
                                        tdone[4]=1;
                                      }
                                      else {
                                        S265441=0;
                                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                          S265441=1;
                                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                            ends[4]=2;
                                            ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                            S263639=13;
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
                        S263639=10;
                        S264742=0;
                        if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                          S264742=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S264737=0;
                          if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                            doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                            S264737=1;
                            if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                              doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 165, column: 4
                              S263639=11;
                              S265072=0;
                              if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                S265072=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S265067=0;
                                if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                  doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                  S265067=1;
                                  if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                    doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                    ends[4]=2;
                                    ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                    S263639=12;
                                    S265446=0;
                                    if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                      S265446=1;
                                      active[4]=1;
                                      ends[4]=1;
                                      tdone[4]=1;
                                    }
                                    else {
                                      S265441=0;
                                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                        S265441=1;
                                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                          ends[4]=2;
                                          ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                          S263639=13;
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
                S264456=1;
                S264456=0;
                if(!doneFiller1_in.isPartnerPresent() || doneFiller1_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 164, column: 4
                  doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                  S264456=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S264451=0;
                  if(!doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                    doneFiller1_in.setACK(true);//sysj\rotaryTableController.sysj line: 164, column: 4
                    S264451=1;
                    if(doneFiller1_in.isREQ()){//sysj\rotaryTableController.sysj line: 164, column: 4
                      doneFiller1_in.setACK(false);//sysj\rotaryTableController.sysj line: 164, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 164, column: 4
                      S263639=10;
                      S264742=0;
                      if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                        doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                        S264742=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S264737=0;
                        if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                          doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                          S264737=1;
                          if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                            doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 165, column: 4
                            S263639=11;
                            S265072=0;
                            if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                              S265072=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S265067=0;
                              if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                                S265067=1;
                                if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                  S263639=12;
                                  S265446=0;
                                  if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                    S265446=1;
                                    active[4]=1;
                                    ends[4]=1;
                                    tdone[4]=1;
                                  }
                                  else {
                                    S265441=0;
                                    if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                      doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                      S265441=1;
                                      if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                        ends[4]=2;
                                        ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                        S263639=13;
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
            switch(S264742){
              case 0 : 
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                  S264742=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S264737){
                    case 0 : 
                      if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                        doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                        S264737=1;
                        if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                          doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 165, column: 4
                          S263639=11;
                          S265072=0;
                          if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                            S265072=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S265067=0;
                            if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                              doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                              S265067=1;
                              if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                                doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                                ends[4]=2;
                                ;//sysj\rotaryTableController.sysj line: 166, column: 4
                                S263639=12;
                                S265446=0;
                                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                  S265446=1;
                                  active[4]=1;
                                  ends[4]=1;
                                  tdone[4]=1;
                                }
                                else {
                                  S265441=0;
                                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                    S265441=1;
                                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                      ends[4]=2;
                                      ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                      S263639=13;
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
                        S263639=11;
                        S265072=0;
                        if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                          S265072=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S265067=0;
                          if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                            doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                            S265067=1;
                            if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                              doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 166, column: 4
                              S263639=12;
                              S265446=0;
                              if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                S265446=1;
                                active[4]=1;
                                ends[4]=1;
                                tdone[4]=1;
                              }
                              else {
                                S265441=0;
                                if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                  doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                  S265441=1;
                                  if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                    doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                    ends[4]=2;
                                    ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                    S263639=13;
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
                S264742=1;
                S264742=0;
                if(!doneFiller2_in.isPartnerPresent() || doneFiller2_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 165, column: 4
                  doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                  S264742=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S264737=0;
                  if(!doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                    doneFiller2_in.setACK(true);//sysj\rotaryTableController.sysj line: 165, column: 4
                    S264737=1;
                    if(doneFiller2_in.isREQ()){//sysj\rotaryTableController.sysj line: 165, column: 4
                      doneFiller2_in.setACK(false);//sysj\rotaryTableController.sysj line: 165, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 165, column: 4
                      S263639=11;
                      S265072=0;
                      if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                        doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                        S265072=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S265067=0;
                        if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                          doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                          S265067=1;
                          if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                            doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 166, column: 4
                            S263639=12;
                            S265446=0;
                            if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                              S265446=1;
                              active[4]=1;
                              ends[4]=1;
                              tdone[4]=1;
                            }
                            else {
                              S265441=0;
                              if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                                S265441=1;
                                if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                  ends[4]=2;
                                  ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                  S263639=13;
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
            switch(S265072){
              case 0 : 
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                  S265072=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265067){
                    case 0 : 
                      if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                        doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                        S265067=1;
                        if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                          doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 166, column: 4
                          S263639=12;
                          S265446=0;
                          if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                            S265446=1;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S265441=0;
                            if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                              doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                              S265441=1;
                              if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                                doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                                ends[4]=2;
                                ;//sysj\rotaryTableController.sysj line: 167, column: 4
                                S263639=13;
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
                        S263639=12;
                        S265446=0;
                        if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                          S265446=1;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S265441=0;
                          if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                            doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                            S265441=1;
                            if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                              doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                              ends[4]=2;
                              ;//sysj\rotaryTableController.sysj line: 167, column: 4
                              S263639=13;
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
                S265072=1;
                S265072=0;
                if(!doneLid_in.isPartnerPresent() || doneLid_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 166, column: 4
                  doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                  S265072=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265067=0;
                  if(!doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                    doneLid_in.setACK(true);//sysj\rotaryTableController.sysj line: 166, column: 4
                    S265067=1;
                    if(doneLid_in.isREQ()){//sysj\rotaryTableController.sysj line: 166, column: 4
                      doneLid_in.setACK(false);//sysj\rotaryTableController.sysj line: 166, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 166, column: 4
                      S263639=12;
                      S265446=0;
                      if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                        doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                        S265446=1;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S265441=0;
                        if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                          doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                          S265441=1;
                          if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                            doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                            ends[4]=2;
                            ;//sysj\rotaryTableController.sysj line: 167, column: 4
                            S263639=13;
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
            switch(S265446){
              case 0 : 
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                  S265446=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S265441){
                    case 0 : 
                      if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                        doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                        S265441=1;
                        if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                          doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                          ends[4]=2;
                          ;//sysj\rotaryTableController.sysj line: 167, column: 4
                          S263639=13;
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
                        S263639=13;
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
                S265446=1;
                S265446=0;
                if(!doneCapper_in.isPartnerPresent() || doneCapper_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 167, column: 4
                  doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                  S265446=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S265441=0;
                  if(!doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                    doneCapper_in.setACK(true);//sysj\rotaryTableController.sysj line: 167, column: 4
                    S265441=1;
                    if(doneCapper_in.isREQ()){//sysj\rotaryTableController.sysj line: 167, column: 4
                      doneCapper_in.setACK(false);//sysj\rotaryTableController.sysj line: 167, column: 4
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 167, column: 4
                      S263639=13;
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
            S263639=13;
            S263639=14;
            if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 181, column: 20
              S263639=15;
              if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 182, column: 20
                S263639=16;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                S263639=15;
                if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 182, column: 20
                  S263639=16;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
              S263639=15;
              if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 182, column: 20
                S263639=16;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                          S263639=17;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          S263639=17;
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
                S263639=15;
                if(!tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 182, column: 20
                  S263639=16;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
                            S263639=17;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            S263639=17;
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
              S263639=16;
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
                        S263639=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263639=17;
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
                        S263639=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263639=17;
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
                        S263639=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263639=17;
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
                        S263639=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263639=17;
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
                        S263639=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263639=17;
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
                        S263639=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263639=17;
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
                        S263639=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263639=17;
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
                        S263639=17;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        S263639=17;
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
                      S263639=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263639=17;
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
                      S263639=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263639=17;
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
                      S263639=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263639=17;
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
                      S263639=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263639=17;
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
                      S263639=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263639=17;
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
                      S263639=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263639=17;
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
                      S263639=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263639=17;
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
                      S263639=17;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      S263639=17;
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
            S263639=17;
            S263639=0;
            if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 101, column: 20
              S263639=1;
              if(m_thread_4.exitOccupied()){//sysj\rotaryTableController.sysj line: 109, column: 4
                exiting_thread_4 = m_thread_4.exitWorkpiece();//sysj\rotaryTableController.sysj line: 110, column: 5
                m_thread_4.sayUnloading();//sysj\rotaryTableController.sysj line: 111, column: 5
                S263369=0;
                S263376=0;
                if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 112, column: 5
                  tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                  S263376=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S263371=0;
                  if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                    tableOutfeed_o.setVal(exiting_thread_4);//sysj\rotaryTableController.sysj line: 112, column: 5
                    S263371=1;
                    if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
                      tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
                      ends[4]=2;
                      ;//sysj\rotaryTableController.sysj line: 112, column: 5
                      S263369=1;
                      if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 21
                        S263369=2;
                        if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                          m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                          S263639=2;
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
                          S263369=2;
                          if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                            m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                            S263639=2;
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
                S263639=2;
                active[4]=1;
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

  public void thread310935(int [] tdone, int [] ends){
        switch(S310924){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S279218){
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
              S279218=1;
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
              //FINXME code
              if(biggest310938 == 0){
                S279218=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 1 : 
            S279218=1;
            S279218=0;
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
              S279218=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              thread310939(tdone,ends);
              thread310940(tdone,ends);
              int biggest310941 = 0;
              if(ends[4]>=biggest310941){
                biggest310941=ends[4];
              }
              if(ends[5]>=biggest310941){
                biggest310941=ends[5];
              }
              if(biggest310941 == 1){
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

  public void thread310934(int [] tdone, int [] ends){
        switch(S263366){
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

  public void thread310931(int [] tdone, int [] ends){
        S279216=1;
    m_thread_5 = TableModel.shared();//sysj\rotaryTableController.sysj line: 210, column: 3
    w_thread_5 = null;//sysj\rotaryTableController.sysj line: 211, column: 3
    S279076=0;
    S279060=0;
    if(!tableInfeed_in.isPartnerPresent() || tableInfeed_in.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 213, column: 4
      tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
      S279060=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S279055=0;
      if(!tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
        tableInfeed_in.setACK(true);//sysj\rotaryTableController.sysj line: 213, column: 4
        S279055=1;
        if(tableInfeed_in.isREQ()){//sysj\rotaryTableController.sysj line: 213, column: 4
          tableInfeed_in.setACK(false);//sysj\rotaryTableController.sysj line: 213, column: 4
          ends[5]=2;
          ;//sysj\rotaryTableController.sysj line: 213, column: 4
          w_thread_5 = (WorkpieceTwin)(tableInfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableInfeed_in.getVal()));//sysj\rotaryTableController.sysj line: 214, column: 4
          m_thread_5.setPending(w_thread_5);//sysj\rotaryTableController.sysj line: 215, column: 4
          System.out.println("[RT] Accepted " + w_thread_5 + " from the conveyor.");//sysj\rotaryTableController.sysj line: 216, column: 4
          S279076=1;
          if(placed_1.getprestatus()){//sysj\rotaryTableController.sysj line: 217, column: 20
            S279076=2;
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

  public void thread310930(int [] tdone, int [] ends){
        S279052=1;
    t_thread_4 = new RotaryTableTwin();//sysj\rotaryTableController.sysj line: 91, column: 3
    step_thread_4 = 0;//sysj\rotaryTableController.sysj line: 92, column: 3
    m_thread_4 = TableModel.shared();//sysj\rotaryTableController.sysj line: 93, column: 3
    exiting_thread_4 = null;//sysj\rotaryTableController.sysj line: 94, column: 3
    seen2_thread_4 = false;//sysj\rotaryTableController.sysj line: 95, column: 3
    seen4_thread_4 = false;//sysj\rotaryTableController.sysj line: 96, column: 3
    seen5_thread_4 = false;//sysj\rotaryTableController.sysj line: 97, column: 3
    S263639=0;
    if(tableAligned.getprestatus()){//sysj\rotaryTableController.sysj line: 101, column: 20
      S263639=1;
      if(m_thread_4.exitOccupied()){//sysj\rotaryTableController.sysj line: 109, column: 4
        exiting_thread_4 = m_thread_4.exitWorkpiece();//sysj\rotaryTableController.sysj line: 110, column: 5
        m_thread_4.sayUnloading();//sysj\rotaryTableController.sysj line: 111, column: 5
        S263369=0;
        S263376=0;
        if(!tableOutfeed_o.isPartnerPresent() || tableOutfeed_o.isPartnerPreempted()){//sysj\rotaryTableController.sysj line: 112, column: 5
          tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
          S263376=1;
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          S263371=0;
          if(tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
            tableOutfeed_o.setVal(exiting_thread_4);//sysj\rotaryTableController.sysj line: 112, column: 5
            S263371=1;
            if(!tableOutfeed_o.isACK()){//sysj\rotaryTableController.sysj line: 112, column: 5
              tableOutfeed_o.setREQ(false);//sysj\rotaryTableController.sysj line: 112, column: 5
              ends[4]=2;
              ;//sysj\rotaryTableController.sysj line: 112, column: 5
              S263369=1;
              if(auto_1.getprestatus()){//sysj\rotaryTableController.sysj line: 113, column: 21
                S263369=2;
                if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                  m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                  S263639=2;
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
                  S263369=2;
                  if(exitCleared.getprestatus()){//sysj\rotaryTableController.sysj line: 114, column: 21
                    m_thread_4.clearExit();//sysj\rotaryTableController.sysj line: 117, column: 5
                    S263639=2;
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
        S263639=2;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread310929(int [] tdone, int [] ends){
        S310924=1;
    S279218=0;
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
      S279218=1;
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      thread310930(tdone,ends);
      thread310931(tdone,ends);
      int biggest310932 = 0;
      if(ends[4]>=biggest310932){
        biggest310932=ends[4];
      }
      if(ends[5]>=biggest310932){
        biggest310932=ends[5];
      }
      if(biggest310932 == 1){
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
    }
  }

  public void thread310928(int [] tdone, int [] ends){
        S263366=1;
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
      switch(S310926){
        case 0 : 
          S310926=0;
          break RUN;
        
        case 1 : 
          S310926=2;
          S310926=2;
          placed_1.setClear();//sysj\rotaryTableController.sysj line: 68, column: 2
          auto_1.setClear();//sysj\rotaryTableController.sysj line: 69, column: 2
          manual_1.setClear();//sysj\rotaryTableController.sysj line: 69, column: 2
          thread310928(tdone,ends);
          thread310929(tdone,ends);
          int biggest310933 = 0;
          if(ends[2]>=biggest310933){
            biggest310933=ends[2];
          }
          if(ends[3]>=biggest310933){
            biggest310933=ends[3];
          }
          if(biggest310933 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          placed_1.setClear();//sysj\rotaryTableController.sysj line: 68, column: 2
          auto_1.setClear();//sysj\rotaryTableController.sysj line: 69, column: 2
          manual_1.setClear();//sysj\rotaryTableController.sysj line: 69, column: 2
          thread310934(tdone,ends);
          thread310935(tdone,ends);
          int biggest310942 = 0;
          if(ends[2]>=biggest310942){
            biggest310942=ends[2];
          }
          if(ends[3]>=biggest310942){
            biggest310942=ends[3];
          }
          if(biggest310942 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest310942 == 0){
            S310926=0;
            active[1]=0;
            ends[1]=0;
            S310926=0;
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
