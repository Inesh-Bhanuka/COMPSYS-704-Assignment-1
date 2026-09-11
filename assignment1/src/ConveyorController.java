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
  public Signal operatorPermit = new Signal("operatorPermit", Signal.INPUT);
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
  private BeltQueue q_thread_2;//sysj\conveyorController.sysj line: 47, column: 3
  private WorkpieceTwin w_thread_2;//sysj\conveyorController.sysj line: 48, column: 3
  private ConveyorTwin t_thread_3;//sysj\conveyorController.sysj line: 72, column: 3
  private BeltQueue q_thread_4;//sysj\conveyorController.sysj line: 84, column: 3
  private WorkpieceTwin w_thread_4;//sysj\conveyorController.sysj line: 85, column: 3
  private WorkpieceTwin w_thread_5;//sysj\conveyorController.sysj line: 108, column: 3
  private boolean permitted_thread_5;//sysj\conveyorController.sysj line: 114, column: 1
  private int S30734 = 1;
  private int S29112 = 1;
  private int S28651 = 1;
  private int S28591 = 1;
  private int S28586 = 1;
  private int S29144 = 1;
  private int S29118 = 1;
  private int S29674 = 1;
  private int S29147 = 1;
  private int S29154 = 1;
  private int S29149 = 1;
  private int S30732 = 1;
  private int S29742 = 1;
  private int S29682 = 1;
  private int S29677 = 1;
  private int S29791 = 1;
  private int S29786 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread30744(int [] tdone, int [] ends){
        switch(S30732){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S29742){
          case 0 : 
            if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 110, column: 20
              S29742=1;
              S29682=0;
              if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 112, column: 4
                tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                S29682=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S29677=0;
                if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                  tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 112, column: 4
                  S29677=1;
                  if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                    tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                    ends[5]=2;
                    ;//sysj\conveyorController.sysj line: 112, column: 4
                    w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 113, column: 4
                    permitted_thread_5 = false;//sysj\conveyorController.sysj line: 114, column: 1
                    S29742=2;
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
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            switch(S29682){
              case 0 : 
                if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 112, column: 4
                  tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                  S29682=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S29677){
                    case 0 : 
                      if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                        tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 112, column: 4
                        S29677=1;
                        if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                          tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                          ends[5]=2;
                          ;//sysj\conveyorController.sysj line: 112, column: 4
                          w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 113, column: 4
                          permitted_thread_5 = false;//sysj\conveyorController.sysj line: 114, column: 1
                          S29742=2;
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
                      if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                        tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                        ends[5]=2;
                        ;//sysj\conveyorController.sysj line: 112, column: 4
                        w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 113, column: 4
                        permitted_thread_5 = false;//sysj\conveyorController.sysj line: 114, column: 1
                        S29742=2;
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
                S29682=1;
                S29682=0;
                if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 112, column: 4
                  tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                  S29682=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S29677=0;
                  if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                    tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 112, column: 4
                    S29677=1;
                    if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                      tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                      ends[5]=2;
                      ;//sysj\conveyorController.sysj line: 112, column: 4
                      w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 113, column: 4
                      permitted_thread_5 = false;//sysj\conveyorController.sysj line: 114, column: 1
                      S29742=2;
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
          
          case 2 : 
            S29742=2;
            S29742=3;
            if(!permitted_thread_5){//sysj\conveyorController.sysj line: 116, column: 19
              permitted_thread_5 = GuiStep.take("OUTFEED", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\conveyorController.sysj line: 117, column: 17
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              ends[5]=2;
              ;//sysj\conveyorController.sysj line: 116, column: 13
              S29742=4;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 3 : 
            if(!permitted_thread_5){//sysj\conveyorController.sysj line: 116, column: 19
              permitted_thread_5 = GuiStep.take("OUTFEED", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\conveyorController.sysj line: 117, column: 17
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              ends[5]=2;
              ;//sysj\conveyorController.sysj line: 116, column: 13
              S29742=4;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 4 : 
            S29742=4;
            System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj\conveyorController.sysj line: 122, column: 4
            S29742=5;
            if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 124, column: 20
              S29742=6;
              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 129, column: 5
              currsigs.addElement(motOutfeed);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 125, column: 5
              currsigs.addElement(injectOutfeed);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 5 : 
            if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 124, column: 20
              S29742=6;
              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 129, column: 5
              currsigs.addElement(motOutfeed);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 125, column: 5
              currsigs.addElement(injectOutfeed);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 6 : 
            if(bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 128, column: 10
              S29742=7;
              if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 132, column: 20
                System.out.println("[CV] " + w_thread_5 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 135, column: 4
                S29742=8;
                S29791=0;
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 137, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                  S29791=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S29786=0;
                  if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                    bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 137, column: 4
                    S29786=1;
                    if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                      bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                      ends[5]=2;
                      ;//sysj\conveyorController.sysj line: 137, column: 4
                      S29742=9;
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
                collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 133, column: 5
                currsigs.addElement(collectFromEnd);
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
            }
            else {
              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 129, column: 5
              currsigs.addElement(motOutfeed);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 7 : 
            if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 132, column: 20
              System.out.println("[CV] " + w_thread_5 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 135, column: 4
              S29742=8;
              S29791=0;
              if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 137, column: 4
                bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                S29791=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S29786=0;
                if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                  bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 137, column: 4
                  S29786=1;
                  if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                    bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                    ends[5]=2;
                    ;//sysj\conveyorController.sysj line: 137, column: 4
                    S29742=9;
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
              collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 133, column: 5
              currsigs.addElement(collectFromEnd);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 8 : 
            switch(S29791){
              case 0 : 
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 137, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                  S29791=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S29786){
                    case 0 : 
                      if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                        bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 137, column: 4
                        S29786=1;
                        if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                          bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                          ends[5]=2;
                          ;//sysj\conveyorController.sysj line: 137, column: 4
                          S29742=9;
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
                      if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                        bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                        ends[5]=2;
                        ;//sysj\conveyorController.sysj line: 137, column: 4
                        S29742=9;
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
                S29791=1;
                S29791=0;
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 137, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                  S29791=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S29786=0;
                  if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                    bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 137, column: 4
                    S29786=1;
                    if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                      bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                      ends[5]=2;
                      ;//sysj\conveyorController.sysj line: 137, column: 4
                      S29742=9;
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
          
          case 9 : 
            S29742=9;
            S29742=0;
            if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 110, column: 20
              S29742=1;
              S29682=0;
              if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 112, column: 4
                tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                S29682=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S29677=0;
                if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                  tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 112, column: 4
                  S29677=1;
                  if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                    tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                    ends[5]=2;
                    ;//sysj\conveyorController.sysj line: 112, column: 4
                    w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 113, column: 4
                    permitted_thread_5 = false;//sysj\conveyorController.sysj line: 114, column: 1
                    S29742=2;
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
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread30743(int [] tdone, int [] ends){
        switch(S29674){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S29147){
          case 0 : 
            if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 87, column: 20
              w_thread_4 = q_thread_4.peek();//sysj\conveyorController.sysj line: 89, column: 4
              if(w_thread_4 != null) {//sysj\conveyorController.sysj line: 90, column: 17
                w_thread_4.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 90, column: 19
              }
              System.out.println("[CV] " + w_thread_4 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 91, column: 4
              S29147=1;
              S29154=0;
              if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 94, column: 4
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                S29154=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S29149=0;
                if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                  tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 94, column: 4
                  S29149=1;
                  if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                    ends[4]=2;
                    ;//sysj\conveyorController.sysj line: 94, column: 4
                    q_thread_4.pop();//sysj\conveyorController.sysj line: 95, column: 4
                    S29147=2;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 99, column: 20
                      System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 102, column: 4
                      S29147=3;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 100, column: 5
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
            switch(S29154){
              case 0 : 
                if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 94, column: 4
                  tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                  S29154=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S29149){
                    case 0 : 
                      if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                        tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 94, column: 4
                        S29149=1;
                        if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                          tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                          ends[4]=2;
                          ;//sysj\conveyorController.sysj line: 94, column: 4
                          q_thread_4.pop();//sysj\conveyorController.sysj line: 95, column: 4
                          S29147=2;
                          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 99, column: 20
                            System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 102, column: 4
                            S29147=3;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 100, column: 5
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
                      if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                        ends[4]=2;
                        ;//sysj\conveyorController.sysj line: 94, column: 4
                        q_thread_4.pop();//sysj\conveyorController.sysj line: 95, column: 4
                        S29147=2;
                        if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 99, column: 20
                          System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 102, column: 4
                          S29147=3;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 100, column: 5
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
                S29154=1;
                S29154=0;
                if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 94, column: 4
                  tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                  S29154=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S29149=0;
                  if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                    tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 94, column: 4
                    S29149=1;
                    if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                      tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                      ends[4]=2;
                      ;//sysj\conveyorController.sysj line: 94, column: 4
                      q_thread_4.pop();//sysj\conveyorController.sysj line: 95, column: 4
                      S29147=2;
                      if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 99, column: 20
                        System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 102, column: 4
                        S29147=3;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 100, column: 5
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
            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 99, column: 20
              System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 102, column: 4
              S29147=3;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 100, column: 5
              currsigs.addElement(takeFromPos1);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 3 : 
            S29147=3;
            S29147=0;
            if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 87, column: 20
              w_thread_4 = q_thread_4.peek();//sysj\conveyorController.sysj line: 89, column: 4
              if(w_thread_4 != null) {//sysj\conveyorController.sysj line: 90, column: 17
                w_thread_4.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 90, column: 19
              }
              System.out.println("[CV] " + w_thread_4 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 91, column: 4
              S29147=1;
              S29154=0;
              if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 94, column: 4
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                S29154=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S29149=0;
                if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                  tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 94, column: 4
                  S29149=1;
                  if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                    ends[4]=2;
                    ;//sysj\conveyorController.sysj line: 94, column: 4
                    q_thread_4.pop();//sysj\conveyorController.sysj line: 95, column: 4
                    S29147=2;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 99, column: 20
                      System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 102, column: 4
                      S29147=3;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 100, column: 5
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

  public void thread30742(int [] tdone, int [] ends){
        switch(S29144){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S29118){
          case 0 : 
            S29118=0;
            if(GuiStep.infeedEnabled((GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())))){//sysj\conveyorController.sysj line: 75, column: 4
              motInfeed.setPresent();//sysj\conveyorController.sysj line: 75, column: 59
              currsigs.addElement(motInfeed);
              if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 76, column: 4
                twin.setPresent();//sysj\conveyorController.sysj line: 77, column: 5
                currsigs.addElement(twin);
                twin.setValue(t_thread_3);//sysj\conveyorController.sysj line: 77, column: 5
                S29118=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S29118=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            else {
              if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 76, column: 4
                twin.setPresent();//sysj\conveyorController.sysj line: 77, column: 5
                currsigs.addElement(twin);
                twin.setValue(t_thread_3);//sysj\conveyorController.sysj line: 77, column: 5
                S29118=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S29118=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 1 : 
            S29118=1;
            S29118=0;
            if(GuiStep.infeedEnabled((GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())))){//sysj\conveyorController.sysj line: 75, column: 4
              motInfeed.setPresent();//sysj\conveyorController.sysj line: 75, column: 59
              currsigs.addElement(motInfeed);
              if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 76, column: 4
                twin.setPresent();//sysj\conveyorController.sysj line: 77, column: 5
                currsigs.addElement(twin);
                twin.setValue(t_thread_3);//sysj\conveyorController.sysj line: 77, column: 5
                S29118=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S29118=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            else {
              if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 76, column: 4
                twin.setPresent();//sysj\conveyorController.sysj line: 77, column: 5
                currsigs.addElement(twin);
                twin.setValue(t_thread_3);//sysj\conveyorController.sysj line: 77, column: 5
                S29118=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S29118=1;
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

  public void thread30741(int [] tdone, int [] ends){
        switch(S29112){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S28651){
          case 0 : 
            if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 52, column: 20
              S28651=1;
              S28591=0;
              if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 54, column: 4
                bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                S28591=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S28586=0;
                if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                  bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 54, column: 4
                  S28586=1;
                  if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                    bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                    ends[2]=2;
                    ;//sysj\conveyorController.sysj line: 54, column: 4
                    w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 55, column: 4
                    q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 56, column: 4
                    System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 57, column: 4
                    S28651=2;
                    if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 64, column: 20
                      S28651=3;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      injectInfeed.setPresent();//sysj\conveyorController.sysj line: 65, column: 5
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
            switch(S28591){
              case 0 : 
                if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 54, column: 4
                  bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                  S28591=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S28586){
                    case 0 : 
                      if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                        bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 54, column: 4
                        S28586=1;
                        if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                          bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                          ends[2]=2;
                          ;//sysj\conveyorController.sysj line: 54, column: 4
                          w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 55, column: 4
                          q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 56, column: 4
                          System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 57, column: 4
                          S28651=2;
                          if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 64, column: 20
                            S28651=3;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            injectInfeed.setPresent();//sysj\conveyorController.sysj line: 65, column: 5
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
                      if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                        bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                        ends[2]=2;
                        ;//sysj\conveyorController.sysj line: 54, column: 4
                        w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 55, column: 4
                        q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 56, column: 4
                        System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 57, column: 4
                        S28651=2;
                        if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 64, column: 20
                          S28651=3;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          injectInfeed.setPresent();//sysj\conveyorController.sysj line: 65, column: 5
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
                S28591=1;
                S28591=0;
                if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 54, column: 4
                  bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                  S28591=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S28586=0;
                  if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                    bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 54, column: 4
                    S28586=1;
                    if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                      bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                      ends[2]=2;
                      ;//sysj\conveyorController.sysj line: 54, column: 4
                      w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 55, column: 4
                      q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 56, column: 4
                      System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 57, column: 4
                      S28651=2;
                      if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 64, column: 20
                        S28651=3;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        injectInfeed.setPresent();//sysj\conveyorController.sysj line: 65, column: 5
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
            if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 64, column: 20
              S28651=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              injectInfeed.setPresent();//sysj\conveyorController.sysj line: 65, column: 5
              currsigs.addElement(injectInfeed);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            S28651=3;
            S28651=0;
            if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 52, column: 20
              S28651=1;
              S28591=0;
              if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 54, column: 4
                bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                S28591=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S28586=0;
                if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                  bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 54, column: 4
                  S28586=1;
                  if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                    bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                    ends[2]=2;
                    ;//sysj\conveyorController.sysj line: 54, column: 4
                    w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 55, column: 4
                    q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 56, column: 4
                    System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 57, column: 4
                    S28651=2;
                    if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 64, column: 20
                      S28651=3;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      injectInfeed.setPresent();//sysj\conveyorController.sysj line: 65, column: 5
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

  public void thread30739(int [] tdone, int [] ends){
        S30732=1;
    w_thread_5 = null;//sysj\conveyorController.sysj line: 108, column: 3
    S29742=0;
    if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 110, column: 20
      S29742=1;
      S29682=0;
      if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 112, column: 4
        tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
        S29682=1;
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
        S29677=0;
        if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
          tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 112, column: 4
          S29677=1;
          if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
            tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
            ends[5]=2;
            ;//sysj\conveyorController.sysj line: 112, column: 4
            w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 113, column: 4
            permitted_thread_5 = false;//sysj\conveyorController.sysj line: 114, column: 1
            S29742=2;
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
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread30738(int [] tdone, int [] ends){
        S29674=1;
    q_thread_4 = BeltQueue.shared();//sysj\conveyorController.sysj line: 84, column: 3
    w_thread_4 = null;//sysj\conveyorController.sysj line: 85, column: 3
    S29147=0;
    if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 87, column: 20
      w_thread_4 = q_thread_4.peek();//sysj\conveyorController.sysj line: 89, column: 4
      if(w_thread_4 != null) {//sysj\conveyorController.sysj line: 90, column: 17
        w_thread_4.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 90, column: 19
      }
      System.out.println("[CV] " + w_thread_4 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 91, column: 4
      S29147=1;
      S29154=0;
      if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 94, column: 4
        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
        S29154=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S29149=0;
        if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
          tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 94, column: 4
          S29149=1;
          if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
            ends[4]=2;
            ;//sysj\conveyorController.sysj line: 94, column: 4
            q_thread_4.pop();//sysj\conveyorController.sysj line: 95, column: 4
            S29147=2;
            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 99, column: 20
              System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 102, column: 4
              S29147=3;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 100, column: 5
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

  public void thread30737(int [] tdone, int [] ends){
        S29144=1;
    t_thread_3 = new ConveyorTwin();//sysj\conveyorController.sysj line: 72, column: 3
    t_thread_3.setMoving(true);//sysj\conveyorController.sysj line: 73, column: 3
    S29118=0;
    if(GuiStep.infeedEnabled((GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())))){//sysj\conveyorController.sysj line: 75, column: 4
      motInfeed.setPresent();//sysj\conveyorController.sysj line: 75, column: 59
      currsigs.addElement(motInfeed);
      if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 76, column: 4
        twin.setPresent();//sysj\conveyorController.sysj line: 77, column: 5
        currsigs.addElement(twin);
        twin.setValue(t_thread_3);//sysj\conveyorController.sysj line: 77, column: 5
        S29118=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S29118=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
    }
    else {
      if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 76, column: 4
        twin.setPresent();//sysj\conveyorController.sysj line: 77, column: 5
        currsigs.addElement(twin);
        twin.setValue(t_thread_3);//sysj\conveyorController.sysj line: 77, column: 5
        S29118=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S29118=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
    }
  }

  public void thread30736(int [] tdone, int [] ends){
        S29112=1;
    q_thread_2 = BeltQueue.shared();//sysj\conveyorController.sysj line: 47, column: 3
    w_thread_2 = null;//sysj\conveyorController.sysj line: 48, column: 3
    S28651=0;
    if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 52, column: 20
      S28651=1;
      S28591=0;
      if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 54, column: 4
        bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
        S28591=1;
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        S28586=0;
        if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
          bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 54, column: 4
          S28586=1;
          if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
            bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
            ends[2]=2;
            ;//sysj\conveyorController.sysj line: 54, column: 4
            w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 55, column: 4
            q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 56, column: 4
            System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 57, column: 4
            S28651=2;
            if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 64, column: 20
              S28651=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              injectInfeed.setPresent();//sysj\conveyorController.sysj line: 65, column: 5
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
      switch(S30734){
        case 0 : 
          S30734=0;
          break RUN;
        
        case 1 : 
          S30734=2;
          S30734=2;
          thread30736(tdone,ends);
          thread30737(tdone,ends);
          thread30738(tdone,ends);
          thread30739(tdone,ends);
          int biggest30740 = 0;
          if(ends[2]>=biggest30740){
            biggest30740=ends[2];
          }
          if(ends[3]>=biggest30740){
            biggest30740=ends[3];
          }
          if(ends[4]>=biggest30740){
            biggest30740=ends[4];
          }
          if(ends[5]>=biggest30740){
            biggest30740=ends[5];
          }
          if(biggest30740 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread30741(tdone,ends);
          thread30742(tdone,ends);
          thread30743(tdone,ends);
          thread30744(tdone,ends);
          int biggest30745 = 0;
          if(ends[2]>=biggest30745){
            biggest30745=ends[2];
          }
          if(ends[3]>=biggest30745){
            biggest30745=ends[3];
          }
          if(ends[4]>=biggest30745){
            biggest30745=ends[4];
          }
          if(ends[5]>=biggest30745){
            biggest30745=ends[5];
          }
          if(biggest30745 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest30745 == 0){
            S30734=0;
            active[1]=0;
            ends[1]=0;
            S30734=0;
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
          operatorPermit.gethook();
          bottleAtPos1.gethook();
          infeedClear.gethook();
          infeedAdmitted.gethook();
          bottleAtOutfeedEnd.gethook();
          outfeedClear.gethook();
          df = true;
        }
        runClockDomain();
      }
      operatorPermit.setpreclear();
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
      dummyint = operatorPermit.getStatus() ? operatorPermit.setprepresent() : operatorPermit.setpreclear();
      operatorPermit.setpreval(operatorPermit.getValue());
      operatorPermit.setClear();
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
        operatorPermit.gethook();
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
