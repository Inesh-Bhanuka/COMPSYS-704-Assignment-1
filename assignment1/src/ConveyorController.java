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
  private BeltQueue q_thread_2;//sysj\conveyorController.sysj line: 43, column: 3
  private Workpiece w_thread_2;//sysj\conveyorController.sysj line: 44, column: 3
  private BeltQueue q_thread_4;//sysj\conveyorController.sysj line: 75, column: 3
  private Workpiece w_thread_4;//sysj\conveyorController.sysj line: 76, column: 3
  private Workpiece w_thread_5;//sysj\conveyorController.sysj line: 98, column: 3
  private int S19691 = 1;
  private int S18036 = 1;
  private int S17575 = 1;
  private int S17515 = 1;
  private int S17510 = 1;
  private int S18041 = 1;
  private int S18571 = 1;
  private int S18044 = 1;
  private int S18051 = 1;
  private int S18046 = 1;
  private int S19689 = 1;
  private int S18639 = 1;
  private int S18579 = 1;
  private int S18574 = 1;
  private int S18698 = 1;
  private int S18693 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread19701(int [] tdone, int [] ends){
        switch(S19689){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S18639){
          case 0 : 
            if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 100, column: 20
              S18639=1;
              S18579=0;
              if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 102, column: 4
                tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 102, column: 4
                S18579=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S18574=0;
                if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 102, column: 4
                  tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 102, column: 4
                  S18574=1;
                  if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 102, column: 4
                    tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 102, column: 4
                    ends[5]=2;
                    ;//sysj\conveyorController.sysj line: 102, column: 4
                    w_thread_5 = (Workpiece)(tableOutfeed_in.getVal() == null ? null : ((Workpiece)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 103, column: 4
                    System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj\conveyorController.sysj line: 104, column: 4
                    S18639=2;
                    if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 106, column: 20
                      S18639=3;
                      motOutfeed.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
                      currsigs.addElement(motOutfeed);
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    else {
                      injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 107, column: 5
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
            switch(S18579){
              case 0 : 
                if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 102, column: 4
                  tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 102, column: 4
                  S18579=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S18574){
                    case 0 : 
                      if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 102, column: 4
                        tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 102, column: 4
                        S18574=1;
                        if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 102, column: 4
                          tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 102, column: 4
                          ends[5]=2;
                          ;//sysj\conveyorController.sysj line: 102, column: 4
                          w_thread_5 = (Workpiece)(tableOutfeed_in.getVal() == null ? null : ((Workpiece)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 103, column: 4
                          System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj\conveyorController.sysj line: 104, column: 4
                          S18639=2;
                          if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 106, column: 20
                            S18639=3;
                            motOutfeed.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
                            currsigs.addElement(motOutfeed);
                            active[5]=1;
                            ends[5]=1;
                            tdone[5]=1;
                          }
                          else {
                            injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 107, column: 5
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
                      if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 102, column: 4
                        tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 102, column: 4
                        ends[5]=2;
                        ;//sysj\conveyorController.sysj line: 102, column: 4
                        w_thread_5 = (Workpiece)(tableOutfeed_in.getVal() == null ? null : ((Workpiece)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 103, column: 4
                        System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj\conveyorController.sysj line: 104, column: 4
                        S18639=2;
                        if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 106, column: 20
                          S18639=3;
                          motOutfeed.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
                          currsigs.addElement(motOutfeed);
                          active[5]=1;
                          ends[5]=1;
                          tdone[5]=1;
                        }
                        else {
                          injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 107, column: 5
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
                S18579=1;
                S18579=0;
                if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 102, column: 4
                  tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 102, column: 4
                  S18579=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S18574=0;
                  if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 102, column: 4
                    tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 102, column: 4
                    S18574=1;
                    if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 102, column: 4
                      tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 102, column: 4
                      ends[5]=2;
                      ;//sysj\conveyorController.sysj line: 102, column: 4
                      w_thread_5 = (Workpiece)(tableOutfeed_in.getVal() == null ? null : ((Workpiece)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 103, column: 4
                      System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj\conveyorController.sysj line: 104, column: 4
                      S18639=2;
                      if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 106, column: 20
                        S18639=3;
                        motOutfeed.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
                        currsigs.addElement(motOutfeed);
                        active[5]=1;
                        ends[5]=1;
                        tdone[5]=1;
                      }
                      else {
                        injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 107, column: 5
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
            if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 106, column: 20
              S18639=3;
              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
              currsigs.addElement(motOutfeed);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 107, column: 5
              currsigs.addElement(injectOutfeed);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 3 : 
            if(bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 110, column: 10
              S18639=4;
              if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 114, column: 20
                System.out.println("[CV] " + w_thread_5 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 117, column: 4
                S18639=5;
                S18698=0;
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 119, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 119, column: 4
                  S18698=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S18693=0;
                  if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 119, column: 4
                    bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 119, column: 4
                    S18693=1;
                    if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 119, column: 4
                      bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 119, column: 4
                      ends[5]=2;
                      ;//sysj\conveyorController.sysj line: 119, column: 4
                      S18639=6;
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
                collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 115, column: 5
                currsigs.addElement(collectFromEnd);
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
            }
            else {
              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
              currsigs.addElement(motOutfeed);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 4 : 
            if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 114, column: 20
              System.out.println("[CV] " + w_thread_5 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 117, column: 4
              S18639=5;
              S18698=0;
              if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 119, column: 4
                bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 119, column: 4
                S18698=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S18693=0;
                if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 119, column: 4
                  bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 119, column: 4
                  S18693=1;
                  if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 119, column: 4
                    bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 119, column: 4
                    ends[5]=2;
                    ;//sysj\conveyorController.sysj line: 119, column: 4
                    S18639=6;
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
              collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 115, column: 5
              currsigs.addElement(collectFromEnd);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 5 : 
            switch(S18698){
              case 0 : 
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 119, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 119, column: 4
                  S18698=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S18693){
                    case 0 : 
                      if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 119, column: 4
                        bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 119, column: 4
                        S18693=1;
                        if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 119, column: 4
                          bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 119, column: 4
                          ends[5]=2;
                          ;//sysj\conveyorController.sysj line: 119, column: 4
                          S18639=6;
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
                      if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 119, column: 4
                        bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 119, column: 4
                        ends[5]=2;
                        ;//sysj\conveyorController.sysj line: 119, column: 4
                        S18639=6;
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
                S18698=1;
                S18698=0;
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 119, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 119, column: 4
                  S18698=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S18693=0;
                  if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 119, column: 4
                    bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 119, column: 4
                    S18693=1;
                    if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 119, column: 4
                      bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 119, column: 4
                      ends[5]=2;
                      ;//sysj\conveyorController.sysj line: 119, column: 4
                      S18639=6;
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
            S18639=6;
            S18639=0;
            if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 100, column: 20
              S18639=1;
              S18579=0;
              if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 102, column: 4
                tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 102, column: 4
                S18579=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S18574=0;
                if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 102, column: 4
                  tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 102, column: 4
                  S18574=1;
                  if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 102, column: 4
                    tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 102, column: 4
                    ends[5]=2;
                    ;//sysj\conveyorController.sysj line: 102, column: 4
                    w_thread_5 = (Workpiece)(tableOutfeed_in.getVal() == null ? null : ((Workpiece)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 103, column: 4
                    System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj\conveyorController.sysj line: 104, column: 4
                    S18639=2;
                    if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 106, column: 20
                      S18639=3;
                      motOutfeed.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
                      currsigs.addElement(motOutfeed);
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    else {
                      injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 107, column: 5
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

  public void thread19700(int [] tdone, int [] ends){
        switch(S18571){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S18044){
          case 0 : 
            if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 78, column: 20
              w_thread_4 = q_thread_4.peek();//sysj\conveyorController.sysj line: 80, column: 4
              System.out.println("[CV] " + w_thread_4 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 81, column: 4
              S18044=1;
              S18051=0;
              if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 84, column: 4
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 84, column: 4
                S18051=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S18046=0;
                if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 84, column: 4
                  tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 84, column: 4
                  S18046=1;
                  if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 84, column: 4
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 84, column: 4
                    ends[4]=2;
                    ;//sysj\conveyorController.sysj line: 84, column: 4
                    q_thread_4.pop();//sysj\conveyorController.sysj line: 85, column: 4
                    S18044=2;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 89, column: 20
                      System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 92, column: 4
                      S18044=3;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 90, column: 5
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
            switch(S18051){
              case 0 : 
                if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 84, column: 4
                  tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 84, column: 4
                  S18051=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S18046){
                    case 0 : 
                      if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 84, column: 4
                        tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 84, column: 4
                        S18046=1;
                        if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 84, column: 4
                          tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 84, column: 4
                          ends[4]=2;
                          ;//sysj\conveyorController.sysj line: 84, column: 4
                          q_thread_4.pop();//sysj\conveyorController.sysj line: 85, column: 4
                          S18044=2;
                          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 89, column: 20
                            System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 92, column: 4
                            S18044=3;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 90, column: 5
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
                      if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 84, column: 4
                        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 84, column: 4
                        ends[4]=2;
                        ;//sysj\conveyorController.sysj line: 84, column: 4
                        q_thread_4.pop();//sysj\conveyorController.sysj line: 85, column: 4
                        S18044=2;
                        if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 89, column: 20
                          System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 92, column: 4
                          S18044=3;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 90, column: 5
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
                S18051=1;
                S18051=0;
                if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 84, column: 4
                  tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 84, column: 4
                  S18051=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S18046=0;
                  if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 84, column: 4
                    tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 84, column: 4
                    S18046=1;
                    if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 84, column: 4
                      tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 84, column: 4
                      ends[4]=2;
                      ;//sysj\conveyorController.sysj line: 84, column: 4
                      q_thread_4.pop();//sysj\conveyorController.sysj line: 85, column: 4
                      S18044=2;
                      if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 89, column: 20
                        System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 92, column: 4
                        S18044=3;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 90, column: 5
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
            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 89, column: 20
              System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 92, column: 4
              S18044=3;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 90, column: 5
              currsigs.addElement(takeFromPos1);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 3 : 
            S18044=3;
            S18044=0;
            if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 78, column: 20
              w_thread_4 = q_thread_4.peek();//sysj\conveyorController.sysj line: 80, column: 4
              System.out.println("[CV] " + w_thread_4 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 81, column: 4
              S18044=1;
              S18051=0;
              if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 84, column: 4
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 84, column: 4
                S18051=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S18046=0;
                if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 84, column: 4
                  tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 84, column: 4
                  S18046=1;
                  if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 84, column: 4
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 84, column: 4
                    ends[4]=2;
                    ;//sysj\conveyorController.sysj line: 84, column: 4
                    q_thread_4.pop();//sysj\conveyorController.sysj line: 85, column: 4
                    S18044=2;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 89, column: 20
                      System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 92, column: 4
                      S18044=3;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 90, column: 5
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

  public void thread19699(int [] tdone, int [] ends){
        switch(S18041){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        motInfeed.setPresent();//sysj\conveyorController.sysj line: 69, column: 4
        currsigs.addElement(motInfeed);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread19698(int [] tdone, int [] ends){
        switch(S18036){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S17575){
          case 0 : 
            if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 48, column: 20
              S17575=1;
              S17515=0;
              if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 50, column: 4
                bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 50, column: 4
                S17515=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S17510=0;
                if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 50, column: 4
                  bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 50, column: 4
                  S17510=1;
                  if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 50, column: 4
                    bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 50, column: 4
                    ends[2]=2;
                    ;//sysj\conveyorController.sysj line: 50, column: 4
                    w_thread_2 = (Workpiece)(bottleHandoff_in.getVal() == null ? null : ((Workpiece)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 51, column: 4
                    q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 52, column: 4
                    System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 53, column: 4
                    S17575=2;
                    if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 60, column: 20
                      S17575=3;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      injectInfeed.setPresent();//sysj\conveyorController.sysj line: 61, column: 5
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
            switch(S17515){
              case 0 : 
                if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 50, column: 4
                  bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 50, column: 4
                  S17515=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S17510){
                    case 0 : 
                      if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 50, column: 4
                        bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 50, column: 4
                        S17510=1;
                        if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 50, column: 4
                          bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 50, column: 4
                          ends[2]=2;
                          ;//sysj\conveyorController.sysj line: 50, column: 4
                          w_thread_2 = (Workpiece)(bottleHandoff_in.getVal() == null ? null : ((Workpiece)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 51, column: 4
                          q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 52, column: 4
                          System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 53, column: 4
                          S17575=2;
                          if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 60, column: 20
                            S17575=3;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            injectInfeed.setPresent();//sysj\conveyorController.sysj line: 61, column: 5
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
                      if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 50, column: 4
                        bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 50, column: 4
                        ends[2]=2;
                        ;//sysj\conveyorController.sysj line: 50, column: 4
                        w_thread_2 = (Workpiece)(bottleHandoff_in.getVal() == null ? null : ((Workpiece)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 51, column: 4
                        q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 52, column: 4
                        System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 53, column: 4
                        S17575=2;
                        if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 60, column: 20
                          S17575=3;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          injectInfeed.setPresent();//sysj\conveyorController.sysj line: 61, column: 5
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
                S17515=1;
                S17515=0;
                if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 50, column: 4
                  bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 50, column: 4
                  S17515=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S17510=0;
                  if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 50, column: 4
                    bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 50, column: 4
                    S17510=1;
                    if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 50, column: 4
                      bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 50, column: 4
                      ends[2]=2;
                      ;//sysj\conveyorController.sysj line: 50, column: 4
                      w_thread_2 = (Workpiece)(bottleHandoff_in.getVal() == null ? null : ((Workpiece)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 51, column: 4
                      q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 52, column: 4
                      System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 53, column: 4
                      S17575=2;
                      if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 60, column: 20
                        S17575=3;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        injectInfeed.setPresent();//sysj\conveyorController.sysj line: 61, column: 5
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
            if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 60, column: 20
              S17575=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              injectInfeed.setPresent();//sysj\conveyorController.sysj line: 61, column: 5
              currsigs.addElement(injectInfeed);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            S17575=3;
            S17575=0;
            if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 48, column: 20
              S17575=1;
              S17515=0;
              if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 50, column: 4
                bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 50, column: 4
                S17515=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S17510=0;
                if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 50, column: 4
                  bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 50, column: 4
                  S17510=1;
                  if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 50, column: 4
                    bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 50, column: 4
                    ends[2]=2;
                    ;//sysj\conveyorController.sysj line: 50, column: 4
                    w_thread_2 = (Workpiece)(bottleHandoff_in.getVal() == null ? null : ((Workpiece)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 51, column: 4
                    q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 52, column: 4
                    System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 53, column: 4
                    S17575=2;
                    if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 60, column: 20
                      S17575=3;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      injectInfeed.setPresent();//sysj\conveyorController.sysj line: 61, column: 5
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

  public void thread19696(int [] tdone, int [] ends){
        S19689=1;
    w_thread_5 = null;//sysj\conveyorController.sysj line: 98, column: 3
    S18639=0;
    if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 100, column: 20
      S18639=1;
      S18579=0;
      if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 102, column: 4
        tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 102, column: 4
        S18579=1;
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
        S18574=0;
        if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 102, column: 4
          tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 102, column: 4
          S18574=1;
          if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 102, column: 4
            tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 102, column: 4
            ends[5]=2;
            ;//sysj\conveyorController.sysj line: 102, column: 4
            w_thread_5 = (Workpiece)(tableOutfeed_in.getVal() == null ? null : ((Workpiece)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 103, column: 4
            System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj\conveyorController.sysj line: 104, column: 4
            S18639=2;
            if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 106, column: 20
              S18639=3;
              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 111, column: 5
              currsigs.addElement(motOutfeed);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 107, column: 5
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

  public void thread19695(int [] tdone, int [] ends){
        S18571=1;
    q_thread_4 = BeltQueue.shared();//sysj\conveyorController.sysj line: 75, column: 3
    w_thread_4 = null;//sysj\conveyorController.sysj line: 76, column: 3
    S18044=0;
    if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 78, column: 20
      w_thread_4 = q_thread_4.peek();//sysj\conveyorController.sysj line: 80, column: 4
      System.out.println("[CV] " + w_thread_4 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 81, column: 4
      S18044=1;
      S18051=0;
      if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 84, column: 4
        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 84, column: 4
        S18051=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S18046=0;
        if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 84, column: 4
          tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 84, column: 4
          S18046=1;
          if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 84, column: 4
            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 84, column: 4
            ends[4]=2;
            ;//sysj\conveyorController.sysj line: 84, column: 4
            q_thread_4.pop();//sysj\conveyorController.sysj line: 85, column: 4
            S18044=2;
            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 89, column: 20
              System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 92, column: 4
              S18044=3;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 90, column: 5
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

  public void thread19694(int [] tdone, int [] ends){
        S18041=1;
    motInfeed.setPresent();//sysj\conveyorController.sysj line: 69, column: 4
    currsigs.addElement(motInfeed);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread19693(int [] tdone, int [] ends){
        S18036=1;
    q_thread_2 = BeltQueue.shared();//sysj\conveyorController.sysj line: 43, column: 3
    w_thread_2 = null;//sysj\conveyorController.sysj line: 44, column: 3
    S17575=0;
    if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 48, column: 20
      S17575=1;
      S17515=0;
      if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 50, column: 4
        bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 50, column: 4
        S17515=1;
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        S17510=0;
        if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 50, column: 4
          bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 50, column: 4
          S17510=1;
          if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 50, column: 4
            bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 50, column: 4
            ends[2]=2;
            ;//sysj\conveyorController.sysj line: 50, column: 4
            w_thread_2 = (Workpiece)(bottleHandoff_in.getVal() == null ? null : ((Workpiece)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 51, column: 4
            q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 52, column: 4
            System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 53, column: 4
            S17575=2;
            if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 60, column: 20
              S17575=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              injectInfeed.setPresent();//sysj\conveyorController.sysj line: 61, column: 5
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
      switch(S19691){
        case 0 : 
          S19691=0;
          break RUN;
        
        case 1 : 
          S19691=2;
          S19691=2;
          thread19693(tdone,ends);
          thread19694(tdone,ends);
          thread19695(tdone,ends);
          thread19696(tdone,ends);
          int biggest19697 = 0;
          if(ends[2]>=biggest19697){
            biggest19697=ends[2];
          }
          if(ends[3]>=biggest19697){
            biggest19697=ends[3];
          }
          if(ends[4]>=biggest19697){
            biggest19697=ends[4];
          }
          if(ends[5]>=biggest19697){
            biggest19697=ends[5];
          }
          if(biggest19697 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread19698(tdone,ends);
          thread19699(tdone,ends);
          thread19700(tdone,ends);
          thread19701(tdone,ends);
          int biggest19702 = 0;
          if(ends[2]>=biggest19702){
            biggest19702=ends[2];
          }
          if(ends[3]>=biggest19702){
            biggest19702=ends[3];
          }
          if(ends[4]>=biggest19702){
            biggest19702=ends[4];
          }
          if(ends[5]>=biggest19702){
            biggest19702=ends[5];
          }
          if(biggest19702 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest19702 == 0){
            S19691=0;
            active[1]=0;
            ends[1]=0;
            S19691=0;
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
