import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class ConveyorController extends ClockDomain{
  public ConveyorController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.INPUT);
  public Signal infeedClear = new Signal("infeedClear", Signal.INPUT);
  public Signal infeedAdmitted = new Signal("infeedAdmitted", Signal.INPUT);
  public Signal bottleAtOutfeedEnd = new Signal("bottleAtOutfeedEnd", Signal.INPUT);
  public Signal outfeedClear = new Signal("outfeedClear", Signal.INPUT);
  public Signal twin = new Signal("twin", Signal.OUTPUT);
  public Signal motInfeed = new Signal("motInfeed", Signal.OUTPUT);
  public Signal injectInfeed = new Signal("injectInfeed", Signal.OUTPUT);
  public Signal takeFromPos1 = new Signal("takeFromPos1", Signal.OUTPUT);
  public Signal motOutfeed = new Signal("motOutfeed", Signal.OUTPUT);
  public Signal injectOutfeed = new Signal("injectOutfeed", Signal.OUTPUT);
  public Signal collectFromEnd = new Signal("collectFromEnd", Signal.OUTPUT);
  public input_Channel bottleHandoff_in = new input_Channel();
  public input_Channel tableOutfeed_in = new input_Channel();
  public output_Channel tableInfeed_o = new output_Channel();
  public output_Channel bottleDone_o = new output_Channel();
  private BeltQueue q_thread_2;//sysj/conveyorController.sysj line: 46, column: 3
  private WorkpieceTwin w_thread_2;//sysj/conveyorController.sysj line: 47, column: 3
  private ConveyorTwin t_thread_3;//sysj/conveyorController.sysj line: 71, column: 3
  private BeltQueue q_thread_4;//sysj/conveyorController.sysj line: 83, column: 3
  private WorkpieceTwin w_thread_4;//sysj/conveyorController.sysj line: 84, column: 3
  private WorkpieceTwin w_thread_5;//sysj/conveyorController.sysj line: 107, column: 3
  private int S26618 = 1;
  private int S24948 = 1;
  private int S24487 = 1;
  private int S24427 = 1;
  private int S24422 = 1;
  private int S24968 = 1;
  private int S25498 = 1;
  private int S24971 = 1;
  private int S24978 = 1;
  private int S24973 = 1;
  private int S26616 = 1;
  private int S25566 = 1;
  private int S25506 = 1;
  private int S25501 = 1;
  private int S25625 = 1;
  private int S25620 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread26628(int [] tdone, int [] ends){
        switch(S26616){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S25566){
          case 0 : 
            if(outfeedClear.getprestatus()){//sysj/conveyorController.sysj line: 109, column: 20
              S25566=1;
              S25506=0;
              if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj/conveyorController.sysj line: 111, column: 4
                tableOutfeed_in.setACK(false);//sysj/conveyorController.sysj line: 111, column: 4
                S25506=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S25501=0;
                if(!tableOutfeed_in.isREQ()){//sysj/conveyorController.sysj line: 111, column: 4
                  tableOutfeed_in.setACK(true);//sysj/conveyorController.sysj line: 111, column: 4
                  S25501=1;
                  if(tableOutfeed_in.isREQ()){//sysj/conveyorController.sysj line: 111, column: 4
                    tableOutfeed_in.setACK(false);//sysj/conveyorController.sysj line: 111, column: 4
                    ends[5]=2;
                    ;//sysj/conveyorController.sysj line: 111, column: 4
                    w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj/conveyorController.sysj line: 112, column: 4
                    System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj/conveyorController.sysj line: 113, column: 4
                    S25566=2;
                    if(!outfeedClear.getprestatus()){//sysj/conveyorController.sysj line: 115, column: 20
                      S25566=3;
                      motOutfeed.setPresent();//sysj/conveyorController.sysj line: 120, column: 5
                      currsigs.addElement(motOutfeed);
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    else {
                      injectOutfeed.setPresent();//sysj/conveyorController.sysj line: 116, column: 5
                      currsigs.addElement(injectOutfeed);
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
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            switch(S25506){
              case 0 : 
                if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj/conveyorController.sysj line: 111, column: 4
                  tableOutfeed_in.setACK(false);//sysj/conveyorController.sysj line: 111, column: 4
                  S25506=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S25501){
                    case 0 : 
                      if(!tableOutfeed_in.isREQ()){//sysj/conveyorController.sysj line: 111, column: 4
                        tableOutfeed_in.setACK(true);//sysj/conveyorController.sysj line: 111, column: 4
                        S25501=1;
                        if(tableOutfeed_in.isREQ()){//sysj/conveyorController.sysj line: 111, column: 4
                          tableOutfeed_in.setACK(false);//sysj/conveyorController.sysj line: 111, column: 4
                          ends[5]=2;
                          ;//sysj/conveyorController.sysj line: 111, column: 4
                          w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj/conveyorController.sysj line: 112, column: 4
                          System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj/conveyorController.sysj line: 113, column: 4
                          S25566=2;
                          if(!outfeedClear.getprestatus()){//sysj/conveyorController.sysj line: 115, column: 20
                            S25566=3;
                            motOutfeed.setPresent();//sysj/conveyorController.sysj line: 120, column: 5
                            currsigs.addElement(motOutfeed);
                            active[5]=1;
                            ends[5]=1;
                            tdone[5]=1;
                          }
                          else {
                            injectOutfeed.setPresent();//sysj/conveyorController.sysj line: 116, column: 5
                            currsigs.addElement(injectOutfeed);
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
                      if(tableOutfeed_in.isREQ()){//sysj/conveyorController.sysj line: 111, column: 4
                        tableOutfeed_in.setACK(false);//sysj/conveyorController.sysj line: 111, column: 4
                        ends[5]=2;
                        ;//sysj/conveyorController.sysj line: 111, column: 4
                        w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj/conveyorController.sysj line: 112, column: 4
                        System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj/conveyorController.sysj line: 113, column: 4
                        S25566=2;
                        if(!outfeedClear.getprestatus()){//sysj/conveyorController.sysj line: 115, column: 20
                          S25566=3;
                          motOutfeed.setPresent();//sysj/conveyorController.sysj line: 120, column: 5
                          currsigs.addElement(motOutfeed);
                          active[5]=1;
                          ends[5]=1;
                          tdone[5]=1;
                        }
                        else {
                          injectOutfeed.setPresent();//sysj/conveyorController.sysj line: 116, column: 5
                          currsigs.addElement(injectOutfeed);
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
                S25506=1;
                S25506=0;
                if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj/conveyorController.sysj line: 111, column: 4
                  tableOutfeed_in.setACK(false);//sysj/conveyorController.sysj line: 111, column: 4
                  S25506=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S25501=0;
                  if(!tableOutfeed_in.isREQ()){//sysj/conveyorController.sysj line: 111, column: 4
                    tableOutfeed_in.setACK(true);//sysj/conveyorController.sysj line: 111, column: 4
                    S25501=1;
                    if(tableOutfeed_in.isREQ()){//sysj/conveyorController.sysj line: 111, column: 4
                      tableOutfeed_in.setACK(false);//sysj/conveyorController.sysj line: 111, column: 4
                      ends[5]=2;
                      ;//sysj/conveyorController.sysj line: 111, column: 4
                      w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj/conveyorController.sysj line: 112, column: 4
                      System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj/conveyorController.sysj line: 113, column: 4
                      S25566=2;
                      if(!outfeedClear.getprestatus()){//sysj/conveyorController.sysj line: 115, column: 20
                        S25566=3;
                        motOutfeed.setPresent();//sysj/conveyorController.sysj line: 120, column: 5
                        currsigs.addElement(motOutfeed);
                        active[5]=1;
                        ends[5]=1;
                        tdone[5]=1;
                      }
                      else {
                        injectOutfeed.setPresent();//sysj/conveyorController.sysj line: 116, column: 5
                        currsigs.addElement(injectOutfeed);
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
          
          case 2 : 
            if(!outfeedClear.getprestatus()){//sysj/conveyorController.sysj line: 115, column: 20
              S25566=3;
              motOutfeed.setPresent();//sysj/conveyorController.sysj line: 120, column: 5
              currsigs.addElement(motOutfeed);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              injectOutfeed.setPresent();//sysj/conveyorController.sysj line: 116, column: 5
              currsigs.addElement(injectOutfeed);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 3 : 
            if(bottleAtOutfeedEnd.getprestatus()){//sysj/conveyorController.sysj line: 119, column: 10
              S25566=4;
              if(!bottleAtOutfeedEnd.getprestatus()){//sysj/conveyorController.sysj line: 123, column: 20
                System.out.println("[CV] " + w_thread_5 + " delivered to the labeller point.");//sysj/conveyorController.sysj line: 126, column: 4
                S25566=5;
                S25625=0;
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj/conveyorController.sysj line: 128, column: 4
                  bottleDone_o.setREQ(false);//sysj/conveyorController.sysj line: 128, column: 4
                  S25625=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S25620=0;
                  if(bottleDone_o.isACK()){//sysj/conveyorController.sysj line: 128, column: 4
                    bottleDone_o.setVal(w_thread_5);//sysj/conveyorController.sysj line: 128, column: 4
                    S25620=1;
                    if(!bottleDone_o.isACK()){//sysj/conveyorController.sysj line: 128, column: 4
                      bottleDone_o.setREQ(false);//sysj/conveyorController.sysj line: 128, column: 4
                      ends[5]=2;
                      ;//sysj/conveyorController.sysj line: 128, column: 4
                      S25566=6;
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
              }
              else {
                collectFromEnd.setPresent();//sysj/conveyorController.sysj line: 124, column: 5
                currsigs.addElement(collectFromEnd);
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
            }
            else {
              motOutfeed.setPresent();//sysj/conveyorController.sysj line: 120, column: 5
              currsigs.addElement(motOutfeed);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 4 : 
            if(!bottleAtOutfeedEnd.getprestatus()){//sysj/conveyorController.sysj line: 123, column: 20
              System.out.println("[CV] " + w_thread_5 + " delivered to the labeller point.");//sysj/conveyorController.sysj line: 126, column: 4
              S25566=5;
              S25625=0;
              if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj/conveyorController.sysj line: 128, column: 4
                bottleDone_o.setREQ(false);//sysj/conveyorController.sysj line: 128, column: 4
                S25625=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S25620=0;
                if(bottleDone_o.isACK()){//sysj/conveyorController.sysj line: 128, column: 4
                  bottleDone_o.setVal(w_thread_5);//sysj/conveyorController.sysj line: 128, column: 4
                  S25620=1;
                  if(!bottleDone_o.isACK()){//sysj/conveyorController.sysj line: 128, column: 4
                    bottleDone_o.setREQ(false);//sysj/conveyorController.sysj line: 128, column: 4
                    ends[5]=2;
                    ;//sysj/conveyorController.sysj line: 128, column: 4
                    S25566=6;
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
            }
            else {
              collectFromEnd.setPresent();//sysj/conveyorController.sysj line: 124, column: 5
              currsigs.addElement(collectFromEnd);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 5 : 
            switch(S25625){
              case 0 : 
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj/conveyorController.sysj line: 128, column: 4
                  bottleDone_o.setREQ(false);//sysj/conveyorController.sysj line: 128, column: 4
                  S25625=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S25620){
                    case 0 : 
                      if(bottleDone_o.isACK()){//sysj/conveyorController.sysj line: 128, column: 4
                        bottleDone_o.setVal(w_thread_5);//sysj/conveyorController.sysj line: 128, column: 4
                        S25620=1;
                        if(!bottleDone_o.isACK()){//sysj/conveyorController.sysj line: 128, column: 4
                          bottleDone_o.setREQ(false);//sysj/conveyorController.sysj line: 128, column: 4
                          ends[5]=2;
                          ;//sysj/conveyorController.sysj line: 128, column: 4
                          S25566=6;
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
                    
                    case 1 : 
                      if(!bottleDone_o.isACK()){//sysj/conveyorController.sysj line: 128, column: 4
                        bottleDone_o.setREQ(false);//sysj/conveyorController.sysj line: 128, column: 4
                        ends[5]=2;
                        ;//sysj/conveyorController.sysj line: 128, column: 4
                        S25566=6;
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
                    
                  }
                }
                break;
              
              case 1 : 
                S25625=1;
                S25625=0;
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj/conveyorController.sysj line: 128, column: 4
                  bottleDone_o.setREQ(false);//sysj/conveyorController.sysj line: 128, column: 4
                  S25625=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S25620=0;
                  if(bottleDone_o.isACK()){//sysj/conveyorController.sysj line: 128, column: 4
                    bottleDone_o.setVal(w_thread_5);//sysj/conveyorController.sysj line: 128, column: 4
                    S25620=1;
                    if(!bottleDone_o.isACK()){//sysj/conveyorController.sysj line: 128, column: 4
                      bottleDone_o.setREQ(false);//sysj/conveyorController.sysj line: 128, column: 4
                      ends[5]=2;
                      ;//sysj/conveyorController.sysj line: 128, column: 4
                      S25566=6;
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
                break;
              
            }
            break;
          
          case 6 : 
            S25566=6;
            S25566=0;
            if(outfeedClear.getprestatus()){//sysj/conveyorController.sysj line: 109, column: 20
              S25566=1;
              S25506=0;
              if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj/conveyorController.sysj line: 111, column: 4
                tableOutfeed_in.setACK(false);//sysj/conveyorController.sysj line: 111, column: 4
                S25506=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S25501=0;
                if(!tableOutfeed_in.isREQ()){//sysj/conveyorController.sysj line: 111, column: 4
                  tableOutfeed_in.setACK(true);//sysj/conveyorController.sysj line: 111, column: 4
                  S25501=1;
                  if(tableOutfeed_in.isREQ()){//sysj/conveyorController.sysj line: 111, column: 4
                    tableOutfeed_in.setACK(false);//sysj/conveyorController.sysj line: 111, column: 4
                    ends[5]=2;
                    ;//sysj/conveyorController.sysj line: 111, column: 4
                    w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj/conveyorController.sysj line: 112, column: 4
                    System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj/conveyorController.sysj line: 113, column: 4
                    S25566=2;
                    if(!outfeedClear.getprestatus()){//sysj/conveyorController.sysj line: 115, column: 20
                      S25566=3;
                      motOutfeed.setPresent();//sysj/conveyorController.sysj line: 120, column: 5
                      currsigs.addElement(motOutfeed);
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    else {
                      injectOutfeed.setPresent();//sysj/conveyorController.sysj line: 116, column: 5
                      currsigs.addElement(injectOutfeed);
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
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread26627(int [] tdone, int [] ends){
        switch(S25498){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S24971){
          case 0 : 
            if(bottleAtPos1.getprestatus()){//sysj/conveyorController.sysj line: 86, column: 20
              w_thread_4 = q_thread_4.peek();//sysj/conveyorController.sysj line: 88, column: 4
              if(w_thread_4 != null) {//sysj/conveyorController.sysj line: 89, column: 17
                w_thread_4.arrived(Machine.CONVEYOR);//sysj/conveyorController.sysj line: 89, column: 19
              }
              System.out.println("[CV] " + w_thread_4 + " at position 1, offering to the table.");//sysj/conveyorController.sysj line: 90, column: 4
              S24971=1;
              S24978=0;
              if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj/conveyorController.sysj line: 93, column: 4
                tableInfeed_o.setREQ(false);//sysj/conveyorController.sysj line: 93, column: 4
                S24978=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S24973=0;
                if(tableInfeed_o.isACK()){//sysj/conveyorController.sysj line: 93, column: 4
                  tableInfeed_o.setVal(w_thread_4);//sysj/conveyorController.sysj line: 93, column: 4
                  S24973=1;
                  if(!tableInfeed_o.isACK()){//sysj/conveyorController.sysj line: 93, column: 4
                    tableInfeed_o.setREQ(false);//sysj/conveyorController.sysj line: 93, column: 4
                    ends[4]=2;
                    ;//sysj/conveyorController.sysj line: 93, column: 4
                    q_thread_4.pop();//sysj/conveyorController.sysj line: 94, column: 4
                    S24971=2;
                    if(!bottleAtPos1.getprestatus()){//sysj/conveyorController.sysj line: 98, column: 20
                      System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj/conveyorController.sysj line: 101, column: 4
                      S24971=3;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      takeFromPos1.setPresent();//sysj/conveyorController.sysj line: 99, column: 5
                      currsigs.addElement(takeFromPos1);
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  active[4]=1;
                  ends[4]=1;
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
          
          case 1 : 
            switch(S24978){
              case 0 : 
                if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj/conveyorController.sysj line: 93, column: 4
                  tableInfeed_o.setREQ(false);//sysj/conveyorController.sysj line: 93, column: 4
                  S24978=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S24973){
                    case 0 : 
                      if(tableInfeed_o.isACK()){//sysj/conveyorController.sysj line: 93, column: 4
                        tableInfeed_o.setVal(w_thread_4);//sysj/conveyorController.sysj line: 93, column: 4
                        S24973=1;
                        if(!tableInfeed_o.isACK()){//sysj/conveyorController.sysj line: 93, column: 4
                          tableInfeed_o.setREQ(false);//sysj/conveyorController.sysj line: 93, column: 4
                          ends[4]=2;
                          ;//sysj/conveyorController.sysj line: 93, column: 4
                          q_thread_4.pop();//sysj/conveyorController.sysj line: 94, column: 4
                          S24971=2;
                          if(!bottleAtPos1.getprestatus()){//sysj/conveyorController.sysj line: 98, column: 20
                            System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj/conveyorController.sysj line: 101, column: 4
                            S24971=3;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            takeFromPos1.setPresent();//sysj/conveyorController.sysj line: 99, column: 5
                            currsigs.addElement(takeFromPos1);
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                        }
                        else {
                          active[4]=1;
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
                      if(!tableInfeed_o.isACK()){//sysj/conveyorController.sysj line: 93, column: 4
                        tableInfeed_o.setREQ(false);//sysj/conveyorController.sysj line: 93, column: 4
                        ends[4]=2;
                        ;//sysj/conveyorController.sysj line: 93, column: 4
                        q_thread_4.pop();//sysj/conveyorController.sysj line: 94, column: 4
                        S24971=2;
                        if(!bottleAtPos1.getprestatus()){//sysj/conveyorController.sysj line: 98, column: 20
                          System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj/conveyorController.sysj line: 101, column: 4
                          S24971=3;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          takeFromPos1.setPresent();//sysj/conveyorController.sysj line: 99, column: 5
                          currsigs.addElement(takeFromPos1);
                          active[4]=1;
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
                }
                break;
              
              case 1 : 
                S24978=1;
                S24978=0;
                if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj/conveyorController.sysj line: 93, column: 4
                  tableInfeed_o.setREQ(false);//sysj/conveyorController.sysj line: 93, column: 4
                  S24978=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S24973=0;
                  if(tableInfeed_o.isACK()){//sysj/conveyorController.sysj line: 93, column: 4
                    tableInfeed_o.setVal(w_thread_4);//sysj/conveyorController.sysj line: 93, column: 4
                    S24973=1;
                    if(!tableInfeed_o.isACK()){//sysj/conveyorController.sysj line: 93, column: 4
                      tableInfeed_o.setREQ(false);//sysj/conveyorController.sysj line: 93, column: 4
                      ends[4]=2;
                      ;//sysj/conveyorController.sysj line: 93, column: 4
                      q_thread_4.pop();//sysj/conveyorController.sysj line: 94, column: 4
                      S24971=2;
                      if(!bottleAtPos1.getprestatus()){//sysj/conveyorController.sysj line: 98, column: 20
                        System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj/conveyorController.sysj line: 101, column: 4
                        S24971=3;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        takeFromPos1.setPresent();//sysj/conveyorController.sysj line: 99, column: 5
                        currsigs.addElement(takeFromPos1);
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                    }
                    else {
                      active[4]=1;
                      ends[4]=1;
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
            if(!bottleAtPos1.getprestatus()){//sysj/conveyorController.sysj line: 98, column: 20
              System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj/conveyorController.sysj line: 101, column: 4
              S24971=3;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              takeFromPos1.setPresent();//sysj/conveyorController.sysj line: 99, column: 5
              currsigs.addElement(takeFromPos1);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 3 : 
            S24971=3;
            S24971=0;
            if(bottleAtPos1.getprestatus()){//sysj/conveyorController.sysj line: 86, column: 20
              w_thread_4 = q_thread_4.peek();//sysj/conveyorController.sysj line: 88, column: 4
              if(w_thread_4 != null) {//sysj/conveyorController.sysj line: 89, column: 17
                w_thread_4.arrived(Machine.CONVEYOR);//sysj/conveyorController.sysj line: 89, column: 19
              }
              System.out.println("[CV] " + w_thread_4 + " at position 1, offering to the table.");//sysj/conveyorController.sysj line: 90, column: 4
              S24971=1;
              S24978=0;
              if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj/conveyorController.sysj line: 93, column: 4
                tableInfeed_o.setREQ(false);//sysj/conveyorController.sysj line: 93, column: 4
                S24978=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S24973=0;
                if(tableInfeed_o.isACK()){//sysj/conveyorController.sysj line: 93, column: 4
                  tableInfeed_o.setVal(w_thread_4);//sysj/conveyorController.sysj line: 93, column: 4
                  S24973=1;
                  if(!tableInfeed_o.isACK()){//sysj/conveyorController.sysj line: 93, column: 4
                    tableInfeed_o.setREQ(false);//sysj/conveyorController.sysj line: 93, column: 4
                    ends[4]=2;
                    ;//sysj/conveyorController.sysj line: 93, column: 4
                    q_thread_4.pop();//sysj/conveyorController.sysj line: 94, column: 4
                    S24971=2;
                    if(!bottleAtPos1.getprestatus()){//sysj/conveyorController.sysj line: 98, column: 20
                      System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj/conveyorController.sysj line: 101, column: 4
                      S24971=3;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      takeFromPos1.setPresent();//sysj/conveyorController.sysj line: 99, column: 5
                      currsigs.addElement(takeFromPos1);
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                  }
                  else {
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  active[4]=1;
                  ends[4]=1;
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
        break;
      
    }
  }

  public void thread26626(int [] tdone, int [] ends){
        switch(S24968){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        motInfeed.setPresent();//sysj/conveyorController.sysj line: 74, column: 4
        currsigs.addElement(motInfeed);
        if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj/conveyorController.sysj line: 75, column: 4
          twin.setPresent();//sysj/conveyorController.sysj line: 76, column: 5
          currsigs.addElement(twin);
          twin.setValue(t_thread_3);//sysj/conveyorController.sysj line: 76, column: 5
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

  public void thread26625(int [] tdone, int [] ends){
        switch(S24948){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S24487){
          case 0 : 
            if(infeedClear.getprestatus()){//sysj/conveyorController.sysj line: 51, column: 20
              S24487=1;
              S24427=0;
              if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj/conveyorController.sysj line: 53, column: 4
                bottleHandoff_in.setACK(false);//sysj/conveyorController.sysj line: 53, column: 4
                S24427=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S24422=0;
                if(!bottleHandoff_in.isREQ()){//sysj/conveyorController.sysj line: 53, column: 4
                  bottleHandoff_in.setACK(true);//sysj/conveyorController.sysj line: 53, column: 4
                  S24422=1;
                  if(bottleHandoff_in.isREQ()){//sysj/conveyorController.sysj line: 53, column: 4
                    bottleHandoff_in.setACK(false);//sysj/conveyorController.sysj line: 53, column: 4
                    ends[2]=2;
                    ;//sysj/conveyorController.sysj line: 53, column: 4
                    w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj/conveyorController.sysj line: 54, column: 4
                    q_thread_2.push(w_thread_2);//sysj/conveyorController.sysj line: 55, column: 4
                    System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj/conveyorController.sysj line: 56, column: 4
                    S24487=2;
                    if(infeedAdmitted.getprestatus()){//sysj/conveyorController.sysj line: 63, column: 20
                      S24487=3;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      injectInfeed.setPresent();//sysj/conveyorController.sysj line: 64, column: 5
                      currsigs.addElement(injectInfeed);
                      active[2]=1;
                      ends[2]=1;
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
          
          case 1 : 
            switch(S24427){
              case 0 : 
                if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj/conveyorController.sysj line: 53, column: 4
                  bottleHandoff_in.setACK(false);//sysj/conveyorController.sysj line: 53, column: 4
                  S24427=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S24422){
                    case 0 : 
                      if(!bottleHandoff_in.isREQ()){//sysj/conveyorController.sysj line: 53, column: 4
                        bottleHandoff_in.setACK(true);//sysj/conveyorController.sysj line: 53, column: 4
                        S24422=1;
                        if(bottleHandoff_in.isREQ()){//sysj/conveyorController.sysj line: 53, column: 4
                          bottleHandoff_in.setACK(false);//sysj/conveyorController.sysj line: 53, column: 4
                          ends[2]=2;
                          ;//sysj/conveyorController.sysj line: 53, column: 4
                          w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj/conveyorController.sysj line: 54, column: 4
                          q_thread_2.push(w_thread_2);//sysj/conveyorController.sysj line: 55, column: 4
                          System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj/conveyorController.sysj line: 56, column: 4
                          S24487=2;
                          if(infeedAdmitted.getprestatus()){//sysj/conveyorController.sysj line: 63, column: 20
                            S24487=3;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            injectInfeed.setPresent();//sysj/conveyorController.sysj line: 64, column: 5
                            currsigs.addElement(injectInfeed);
                            active[2]=1;
                            ends[2]=1;
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
                      if(bottleHandoff_in.isREQ()){//sysj/conveyorController.sysj line: 53, column: 4
                        bottleHandoff_in.setACK(false);//sysj/conveyorController.sysj line: 53, column: 4
                        ends[2]=2;
                        ;//sysj/conveyorController.sysj line: 53, column: 4
                        w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj/conveyorController.sysj line: 54, column: 4
                        q_thread_2.push(w_thread_2);//sysj/conveyorController.sysj line: 55, column: 4
                        System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj/conveyorController.sysj line: 56, column: 4
                        S24487=2;
                        if(infeedAdmitted.getprestatus()){//sysj/conveyorController.sysj line: 63, column: 20
                          S24487=3;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          injectInfeed.setPresent();//sysj/conveyorController.sysj line: 64, column: 5
                          currsigs.addElement(injectInfeed);
                          active[2]=1;
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
                S24427=1;
                S24427=0;
                if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj/conveyorController.sysj line: 53, column: 4
                  bottleHandoff_in.setACK(false);//sysj/conveyorController.sysj line: 53, column: 4
                  S24427=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S24422=0;
                  if(!bottleHandoff_in.isREQ()){//sysj/conveyorController.sysj line: 53, column: 4
                    bottleHandoff_in.setACK(true);//sysj/conveyorController.sysj line: 53, column: 4
                    S24422=1;
                    if(bottleHandoff_in.isREQ()){//sysj/conveyorController.sysj line: 53, column: 4
                      bottleHandoff_in.setACK(false);//sysj/conveyorController.sysj line: 53, column: 4
                      ends[2]=2;
                      ;//sysj/conveyorController.sysj line: 53, column: 4
                      w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj/conveyorController.sysj line: 54, column: 4
                      q_thread_2.push(w_thread_2);//sysj/conveyorController.sysj line: 55, column: 4
                      System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj/conveyorController.sysj line: 56, column: 4
                      S24487=2;
                      if(infeedAdmitted.getprestatus()){//sysj/conveyorController.sysj line: 63, column: 20
                        S24487=3;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        injectInfeed.setPresent();//sysj/conveyorController.sysj line: 64, column: 5
                        currsigs.addElement(injectInfeed);
                        active[2]=1;
                        ends[2]=1;
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
          
          case 2 : 
            if(infeedAdmitted.getprestatus()){//sysj/conveyorController.sysj line: 63, column: 20
              S24487=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              injectInfeed.setPresent();//sysj/conveyorController.sysj line: 64, column: 5
              currsigs.addElement(injectInfeed);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            S24487=3;
            S24487=0;
            if(infeedClear.getprestatus()){//sysj/conveyorController.sysj line: 51, column: 20
              S24487=1;
              S24427=0;
              if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj/conveyorController.sysj line: 53, column: 4
                bottleHandoff_in.setACK(false);//sysj/conveyorController.sysj line: 53, column: 4
                S24427=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S24422=0;
                if(!bottleHandoff_in.isREQ()){//sysj/conveyorController.sysj line: 53, column: 4
                  bottleHandoff_in.setACK(true);//sysj/conveyorController.sysj line: 53, column: 4
                  S24422=1;
                  if(bottleHandoff_in.isREQ()){//sysj/conveyorController.sysj line: 53, column: 4
                    bottleHandoff_in.setACK(false);//sysj/conveyorController.sysj line: 53, column: 4
                    ends[2]=2;
                    ;//sysj/conveyorController.sysj line: 53, column: 4
                    w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj/conveyorController.sysj line: 54, column: 4
                    q_thread_2.push(w_thread_2);//sysj/conveyorController.sysj line: 55, column: 4
                    System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj/conveyorController.sysj line: 56, column: 4
                    S24487=2;
                    if(infeedAdmitted.getprestatus()){//sysj/conveyorController.sysj line: 63, column: 20
                      S24487=3;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      injectInfeed.setPresent();//sysj/conveyorController.sysj line: 64, column: 5
                      currsigs.addElement(injectInfeed);
                      active[2]=1;
                      ends[2]=1;
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
        break;
      
    }
  }

  public void thread26623(int [] tdone, int [] ends){
        S26616=1;
    w_thread_5 = null;//sysj/conveyorController.sysj line: 107, column: 3
    S25566=0;
    if(outfeedClear.getprestatus()){//sysj/conveyorController.sysj line: 109, column: 20
      S25566=1;
      S25506=0;
      if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj/conveyorController.sysj line: 111, column: 4
        tableOutfeed_in.setACK(false);//sysj/conveyorController.sysj line: 111, column: 4
        S25506=1;
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
        S25501=0;
        if(!tableOutfeed_in.isREQ()){//sysj/conveyorController.sysj line: 111, column: 4
          tableOutfeed_in.setACK(true);//sysj/conveyorController.sysj line: 111, column: 4
          S25501=1;
          if(tableOutfeed_in.isREQ()){//sysj/conveyorController.sysj line: 111, column: 4
            tableOutfeed_in.setACK(false);//sysj/conveyorController.sysj line: 111, column: 4
            ends[5]=2;
            ;//sysj/conveyorController.sysj line: 111, column: 4
            w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj/conveyorController.sysj line: 112, column: 4
            System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj/conveyorController.sysj line: 113, column: 4
            S25566=2;
            if(!outfeedClear.getprestatus()){//sysj/conveyorController.sysj line: 115, column: 20
              S25566=3;
              motOutfeed.setPresent();//sysj/conveyorController.sysj line: 120, column: 5
              currsigs.addElement(motOutfeed);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              injectOutfeed.setPresent();//sysj/conveyorController.sysj line: 116, column: 5
              currsigs.addElement(injectOutfeed);
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
    else {
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread26622(int [] tdone, int [] ends){
        S25498=1;
    q_thread_4 = BeltQueue.shared();//sysj/conveyorController.sysj line: 83, column: 3
    w_thread_4 = null;//sysj/conveyorController.sysj line: 84, column: 3
    S24971=0;
    if(bottleAtPos1.getprestatus()){//sysj/conveyorController.sysj line: 86, column: 20
      w_thread_4 = q_thread_4.peek();//sysj/conveyorController.sysj line: 88, column: 4
      if(w_thread_4 != null) {//sysj/conveyorController.sysj line: 89, column: 17
        w_thread_4.arrived(Machine.CONVEYOR);//sysj/conveyorController.sysj line: 89, column: 19
      }
      System.out.println("[CV] " + w_thread_4 + " at position 1, offering to the table.");//sysj/conveyorController.sysj line: 90, column: 4
      S24971=1;
      S24978=0;
      if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj/conveyorController.sysj line: 93, column: 4
        tableInfeed_o.setREQ(false);//sysj/conveyorController.sysj line: 93, column: 4
        S24978=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S24973=0;
        if(tableInfeed_o.isACK()){//sysj/conveyorController.sysj line: 93, column: 4
          tableInfeed_o.setVal(w_thread_4);//sysj/conveyorController.sysj line: 93, column: 4
          S24973=1;
          if(!tableInfeed_o.isACK()){//sysj/conveyorController.sysj line: 93, column: 4
            tableInfeed_o.setREQ(false);//sysj/conveyorController.sysj line: 93, column: 4
            ends[4]=2;
            ;//sysj/conveyorController.sysj line: 93, column: 4
            q_thread_4.pop();//sysj/conveyorController.sysj line: 94, column: 4
            S24971=2;
            if(!bottleAtPos1.getprestatus()){//sysj/conveyorController.sysj line: 98, column: 20
              System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj/conveyorController.sysj line: 101, column: 4
              S24971=3;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              takeFromPos1.setPresent();//sysj/conveyorController.sysj line: 99, column: 5
              currsigs.addElement(takeFromPos1);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
          }
          else {
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
        }
        else {
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
      }
    }
    else {
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread26621(int [] tdone, int [] ends){
        S24968=1;
    t_thread_3 = new ConveyorTwin();//sysj/conveyorController.sysj line: 71, column: 3
    t_thread_3.setMoving(true);//sysj/conveyorController.sysj line: 72, column: 3
    motInfeed.setPresent();//sysj/conveyorController.sysj line: 74, column: 4
    currsigs.addElement(motInfeed);
    if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj/conveyorController.sysj line: 75, column: 4
      twin.setPresent();//sysj/conveyorController.sysj line: 76, column: 5
      currsigs.addElement(twin);
      twin.setValue(t_thread_3);//sysj/conveyorController.sysj line: 76, column: 5
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

  public void thread26620(int [] tdone, int [] ends){
        S24948=1;
    q_thread_2 = BeltQueue.shared();//sysj/conveyorController.sysj line: 46, column: 3
    w_thread_2 = null;//sysj/conveyorController.sysj line: 47, column: 3
    S24487=0;
    if(infeedClear.getprestatus()){//sysj/conveyorController.sysj line: 51, column: 20
      S24487=1;
      S24427=0;
      if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj/conveyorController.sysj line: 53, column: 4
        bottleHandoff_in.setACK(false);//sysj/conveyorController.sysj line: 53, column: 4
        S24427=1;
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        S24422=0;
        if(!bottleHandoff_in.isREQ()){//sysj/conveyorController.sysj line: 53, column: 4
          bottleHandoff_in.setACK(true);//sysj/conveyorController.sysj line: 53, column: 4
          S24422=1;
          if(bottleHandoff_in.isREQ()){//sysj/conveyorController.sysj line: 53, column: 4
            bottleHandoff_in.setACK(false);//sysj/conveyorController.sysj line: 53, column: 4
            ends[2]=2;
            ;//sysj/conveyorController.sysj line: 53, column: 4
            w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj/conveyorController.sysj line: 54, column: 4
            q_thread_2.push(w_thread_2);//sysj/conveyorController.sysj line: 55, column: 4
            System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj/conveyorController.sysj line: 56, column: 4
            S24487=2;
            if(infeedAdmitted.getprestatus()){//sysj/conveyorController.sysj line: 63, column: 20
              S24487=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              injectInfeed.setPresent();//sysj/conveyorController.sysj line: 64, column: 5
              currsigs.addElement(injectInfeed);
              active[2]=1;
              ends[2]=1;
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

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S26618){
        case 0 : 
          S26618=0;
          break RUN;
        
        case 1 : 
          S26618=2;
          S26618=2;
          thread26620(tdone,ends);
          thread26621(tdone,ends);
          thread26622(tdone,ends);
          thread26623(tdone,ends);
          int biggest26624 = 0;
          if(ends[2]>=biggest26624){
            biggest26624=ends[2];
          }
          if(ends[3]>=biggest26624){
            biggest26624=ends[3];
          }
          if(ends[4]>=biggest26624){
            biggest26624=ends[4];
          }
          if(ends[5]>=biggest26624){
            biggest26624=ends[5];
          }
          if(biggest26624 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread26625(tdone,ends);
          thread26626(tdone,ends);
          thread26627(tdone,ends);
          thread26628(tdone,ends);
          int biggest26629 = 0;
          if(ends[2]>=biggest26629){
            biggest26629=ends[2];
          }
          if(ends[3]>=biggest26629){
            biggest26629=ends[3];
          }
          if(ends[4]>=biggest26629){
            biggest26629=ends[4];
          }
          if(ends[5]>=biggest26629){
            biggest26629=ends[5];
          }
          if(biggest26629 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest26629 == 0){
            S26618=0;
            active[1]=0;
            ends[1]=0;
            S26618=0;
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
          bottleHandoff_in.gethook();
          tableOutfeed_in.gethook();
          tableInfeed_o.gethook();
          bottleDone_o.gethook();
          bottleAtPos1.gethook();
          infeedClear.gethook();
          infeedAdmitted.gethook();
          bottleAtOutfeedEnd.gethook();
          outfeedClear.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos1.setpreclear();
      infeedClear.setpreclear();
      infeedAdmitted.setpreclear();
      bottleAtOutfeedEnd.setpreclear();
      outfeedClear.setpreclear();
      twin.setpreclear();
      motInfeed.setpreclear();
      injectInfeed.setpreclear();
      takeFromPos1.setpreclear();
      motOutfeed.setpreclear();
      injectOutfeed.setpreclear();
      collectFromEnd.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos1.getStatus() ? bottleAtPos1.setprepresent() : bottleAtPos1.setpreclear();
      bottleAtPos1.setpreval(bottleAtPos1.getValue());
      bottleAtPos1.setClear();
      dummyint = infeedClear.getStatus() ? infeedClear.setprepresent() : infeedClear.setpreclear();
      infeedClear.setpreval(infeedClear.getValue());
      infeedClear.setClear();
      dummyint = infeedAdmitted.getStatus() ? infeedAdmitted.setprepresent() : infeedAdmitted.setpreclear();
      infeedAdmitted.setpreval(infeedAdmitted.getValue());
      infeedAdmitted.setClear();
      dummyint = bottleAtOutfeedEnd.getStatus() ? bottleAtOutfeedEnd.setprepresent() : bottleAtOutfeedEnd.setpreclear();
      bottleAtOutfeedEnd.setpreval(bottleAtOutfeedEnd.getValue());
      bottleAtOutfeedEnd.setClear();
      dummyint = outfeedClear.getStatus() ? outfeedClear.setprepresent() : outfeedClear.setpreclear();
      outfeedClear.setpreval(outfeedClear.getValue());
      outfeedClear.setClear();
      twin.sethook();
      twin.setClear();
      motInfeed.sethook();
      motInfeed.setClear();
      injectInfeed.sethook();
      injectInfeed.setClear();
      takeFromPos1.sethook();
      takeFromPos1.setClear();
      motOutfeed.sethook();
      motOutfeed.setClear();
      injectOutfeed.sethook();
      injectOutfeed.setClear();
      collectFromEnd.sethook();
      collectFromEnd.setClear();
      bottleHandoff_in.sethook();
      tableOutfeed_in.sethook();
      tableInfeed_o.sethook();
      bottleDone_o.sethook();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleHandoff_in.gethook();
        tableOutfeed_in.gethook();
        tableInfeed_o.gethook();
        bottleDone_o.gethook();
        bottleAtPos1.gethook();
        infeedClear.gethook();
        infeedAdmitted.gethook();
        bottleAtOutfeedEnd.gethook();
        outfeedClear.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
