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
  private int S34514 = 1;
  private int S32892 = 1;
  private int S32431 = 1;
  private int S32371 = 1;
  private int S32366 = 1;
  private int S32924 = 1;
  private int S32898 = 1;
  private int S33454 = 1;
  private int S32927 = 1;
  private int S32934 = 1;
  private int S32929 = 1;
  private int S34512 = 1;
  private int S33522 = 1;
  private int S33462 = 1;
  private int S33457 = 1;
  private int S33571 = 1;
  private int S33566 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread34524(int [] tdone, int [] ends){
        switch(S34512){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S33522){
          case 0 : 
            if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 110, column: 20
              S33522=1;
              S33462=0;
              if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 112, column: 4
                tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                S33462=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S33457=0;
                if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                  tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 112, column: 4
                  S33457=1;
                  if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                    tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                    ends[5]=2;
                    ;//sysj\conveyorController.sysj line: 112, column: 4
                    w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 113, column: 4
                    permitted_thread_5 = false;//sysj\conveyorController.sysj line: 114, column: 1
                    S33522=2;
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
            switch(S33462){
              case 0 : 
                if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 112, column: 4
                  tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                  S33462=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S33457){
                    case 0 : 
                      if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                        tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 112, column: 4
                        S33457=1;
                        if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                          tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                          ends[5]=2;
                          ;//sysj\conveyorController.sysj line: 112, column: 4
                          w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 113, column: 4
                          permitted_thread_5 = false;//sysj\conveyorController.sysj line: 114, column: 1
                          S33522=2;
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
                        S33522=2;
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
                S33462=1;
                S33462=0;
                if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 112, column: 4
                  tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                  S33462=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S33457=0;
                  if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                    tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 112, column: 4
                    S33457=1;
                    if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                      tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                      ends[5]=2;
                      ;//sysj\conveyorController.sysj line: 112, column: 4
                      w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 113, column: 4
                      permitted_thread_5 = false;//sysj\conveyorController.sysj line: 114, column: 1
                      S33522=2;
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
            S33522=2;
            S33522=3;
            if(!permitted_thread_5){//sysj\conveyorController.sysj line: 116, column: 19
              permitted_thread_5 = GuiStep.take("OUTFEED", (GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())));//sysj\conveyorController.sysj line: 117, column: 17
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              ends[5]=2;
              ;//sysj\conveyorController.sysj line: 116, column: 13
              S33522=4;
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
              S33522=4;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 4 : 
            S33522=4;
            System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj\conveyorController.sysj line: 122, column: 4
            S33522=5;
            if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 124, column: 20
              S33522=6;
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
              S33522=6;
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
              S33522=7;
              if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 132, column: 20
                System.out.println("[CV] " + w_thread_5 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 135, column: 4
                S33522=8;
                S33571=0;
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 137, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                  S33571=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S33566=0;
                  if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                    bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 137, column: 4
                    S33566=1;
                    if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                      bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                      ends[5]=2;
                      ;//sysj\conveyorController.sysj line: 137, column: 4
                      S33522=9;
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
              S33522=8;
              S33571=0;
              if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 137, column: 4
                bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                S33571=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S33566=0;
                if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                  bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 137, column: 4
                  S33566=1;
                  if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                    bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                    ends[5]=2;
                    ;//sysj\conveyorController.sysj line: 137, column: 4
                    S33522=9;
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
            switch(S33571){
              case 0 : 
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 137, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                  S33571=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S33566){
                    case 0 : 
                      if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                        bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 137, column: 4
                        S33566=1;
                        if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                          bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                          ends[5]=2;
                          ;//sysj\conveyorController.sysj line: 137, column: 4
                          S33522=9;
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
                        S33522=9;
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
                S33571=1;
                S33571=0;
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 137, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                  S33571=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S33566=0;
                  if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                    bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 137, column: 4
                    S33566=1;
                    if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 137, column: 4
                      bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 137, column: 4
                      ends[5]=2;
                      ;//sysj\conveyorController.sysj line: 137, column: 4
                      S33522=9;
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
            S33522=9;
            S33522=0;
            if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 110, column: 20
              S33522=1;
              S33462=0;
              if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 112, column: 4
                tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                S33462=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S33457=0;
                if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                  tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 112, column: 4
                  S33457=1;
                  if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
                    tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
                    ends[5]=2;
                    ;//sysj\conveyorController.sysj line: 112, column: 4
                    w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 113, column: 4
                    permitted_thread_5 = false;//sysj\conveyorController.sysj line: 114, column: 1
                    S33522=2;
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

  public void thread34523(int [] tdone, int [] ends){
        switch(S33454){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S32927){
          case 0 : 
            if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 87, column: 20
              w_thread_4 = q_thread_4.peek();//sysj\conveyorController.sysj line: 89, column: 4
              if(w_thread_4 != null) {//sysj\conveyorController.sysj line: 90, column: 17
                w_thread_4.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 90, column: 19
              }
              System.out.println("[CV] " + w_thread_4 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 91, column: 4
              S32927=1;
              S32934=0;
              if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 94, column: 4
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                S32934=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S32929=0;
                if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                  tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 94, column: 4
                  S32929=1;
                  if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                    ends[4]=2;
                    ;//sysj\conveyorController.sysj line: 94, column: 4
                    q_thread_4.pop();//sysj\conveyorController.sysj line: 95, column: 4
                    S32927=2;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 99, column: 20
                      System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 102, column: 4
                      S32927=3;
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
            switch(S32934){
              case 0 : 
                if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 94, column: 4
                  tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                  S32934=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S32929){
                    case 0 : 
                      if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                        tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 94, column: 4
                        S32929=1;
                        if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                          tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                          ends[4]=2;
                          ;//sysj\conveyorController.sysj line: 94, column: 4
                          q_thread_4.pop();//sysj\conveyorController.sysj line: 95, column: 4
                          S32927=2;
                          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 99, column: 20
                            System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 102, column: 4
                            S32927=3;
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
                        S32927=2;
                        if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 99, column: 20
                          System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 102, column: 4
                          S32927=3;
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
                S32934=1;
                S32934=0;
                if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 94, column: 4
                  tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                  S32934=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S32929=0;
                  if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                    tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 94, column: 4
                    S32929=1;
                    if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                      tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                      ends[4]=2;
                      ;//sysj\conveyorController.sysj line: 94, column: 4
                      q_thread_4.pop();//sysj\conveyorController.sysj line: 95, column: 4
                      S32927=2;
                      if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 99, column: 20
                        System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 102, column: 4
                        S32927=3;
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
              S32927=3;
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
            S32927=3;
            S32927=0;
            if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 87, column: 20
              w_thread_4 = q_thread_4.peek();//sysj\conveyorController.sysj line: 89, column: 4
              if(w_thread_4 != null) {//sysj\conveyorController.sysj line: 90, column: 17
                w_thread_4.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 90, column: 19
              }
              System.out.println("[CV] " + w_thread_4 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 91, column: 4
              S32927=1;
              S32934=0;
              if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 94, column: 4
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                S32934=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S32929=0;
                if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                  tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 94, column: 4
                  S32929=1;
                  if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
                    ends[4]=2;
                    ;//sysj\conveyorController.sysj line: 94, column: 4
                    q_thread_4.pop();//sysj\conveyorController.sysj line: 95, column: 4
                    S32927=2;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 99, column: 20
                      System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 102, column: 4
                      S32927=3;
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

  public void thread34522(int [] tdone, int [] ends){
        switch(S32924){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S32898){
          case 0 : 
            S32898=0;
            if(GuiStep.infeedEnabled((GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())))){//sysj\conveyorController.sysj line: 75, column: 4
              motInfeed.setPresent();//sysj\conveyorController.sysj line: 75, column: 59
              currsigs.addElement(motInfeed);
              if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 76, column: 4
                twin.setPresent();//sysj\conveyorController.sysj line: 77, column: 5
                currsigs.addElement(twin);
                twin.setValue(t_thread_3);//sysj\conveyorController.sysj line: 77, column: 5
                S32898=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S32898=1;
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
                S32898=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S32898=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
            }
            break;
          
          case 1 : 
            S32898=1;
            S32898=0;
            if(GuiStep.infeedEnabled((GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())))){//sysj\conveyorController.sysj line: 75, column: 4
              motInfeed.setPresent();//sysj\conveyorController.sysj line: 75, column: 59
              currsigs.addElement(motInfeed);
              if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 76, column: 4
                twin.setPresent();//sysj\conveyorController.sysj line: 77, column: 5
                currsigs.addElement(twin);
                twin.setValue(t_thread_3);//sysj\conveyorController.sysj line: 77, column: 5
                S32898=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S32898=1;
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
                S32898=1;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                S32898=1;
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

  public void thread34521(int [] tdone, int [] ends){
        switch(S32892){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S32431){
          case 0 : 
            if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 52, column: 20
              S32431=1;
              S32371=0;
              if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 54, column: 4
                bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                S32371=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S32366=0;
                if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                  bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 54, column: 4
                  S32366=1;
                  if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                    bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                    ends[2]=2;
                    ;//sysj\conveyorController.sysj line: 54, column: 4
                    w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 55, column: 4
                    q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 56, column: 4
                    System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 57, column: 4
                    S32431=2;
                    if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 64, column: 20
                      S32431=3;
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
            switch(S32371){
              case 0 : 
                if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 54, column: 4
                  bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                  S32371=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S32366){
                    case 0 : 
                      if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                        bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 54, column: 4
                        S32366=1;
                        if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                          bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                          ends[2]=2;
                          ;//sysj\conveyorController.sysj line: 54, column: 4
                          w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 55, column: 4
                          q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 56, column: 4
                          System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 57, column: 4
                          S32431=2;
                          if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 64, column: 20
                            S32431=3;
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
                        S32431=2;
                        if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 64, column: 20
                          S32431=3;
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
                S32371=1;
                S32371=0;
                if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 54, column: 4
                  bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                  S32371=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S32366=0;
                  if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                    bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 54, column: 4
                    S32366=1;
                    if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                      bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                      ends[2]=2;
                      ;//sysj\conveyorController.sysj line: 54, column: 4
                      w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 55, column: 4
                      q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 56, column: 4
                      System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 57, column: 4
                      S32431=2;
                      if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 64, column: 20
                        S32431=3;
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
              S32431=3;
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
            S32431=3;
            S32431=0;
            if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 52, column: 20
              S32431=1;
              S32371=0;
              if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 54, column: 4
                bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                S32371=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S32366=0;
                if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                  bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 54, column: 4
                  S32366=1;
                  if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
                    bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
                    ends[2]=2;
                    ;//sysj\conveyorController.sysj line: 54, column: 4
                    w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 55, column: 4
                    q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 56, column: 4
                    System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 57, column: 4
                    S32431=2;
                    if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 64, column: 20
                      S32431=3;
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

  public void thread34519(int [] tdone, int [] ends){
        S34512=1;
    w_thread_5 = null;//sysj\conveyorController.sysj line: 108, column: 3
    S33522=0;
    if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 110, column: 20
      S33522=1;
      S33462=0;
      if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 112, column: 4
        tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
        S33462=1;
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
        S33457=0;
        if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
          tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 112, column: 4
          S33457=1;
          if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 112, column: 4
            tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 112, column: 4
            ends[5]=2;
            ;//sysj\conveyorController.sysj line: 112, column: 4
            w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 113, column: 4
            permitted_thread_5 = false;//sysj\conveyorController.sysj line: 114, column: 1
            S33522=2;
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

  public void thread34518(int [] tdone, int [] ends){
        S33454=1;
    q_thread_4 = BeltQueue.shared();//sysj\conveyorController.sysj line: 84, column: 3
    w_thread_4 = null;//sysj\conveyorController.sysj line: 85, column: 3
    S32927=0;
    if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 87, column: 20
      w_thread_4 = q_thread_4.peek();//sysj\conveyorController.sysj line: 89, column: 4
      if(w_thread_4 != null) {//sysj\conveyorController.sysj line: 90, column: 17
        w_thread_4.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 90, column: 19
      }
      System.out.println("[CV] " + w_thread_4 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 91, column: 4
      S32927=1;
      S32934=0;
      if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 94, column: 4
        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
        S32934=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S32929=0;
        if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
          tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 94, column: 4
          S32929=1;
          if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 94, column: 4
            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 94, column: 4
            ends[4]=2;
            ;//sysj\conveyorController.sysj line: 94, column: 4
            q_thread_4.pop();//sysj\conveyorController.sysj line: 95, column: 4
            S32927=2;
            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 99, column: 20
              System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 102, column: 4
              S32927=3;
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

  public void thread34517(int [] tdone, int [] ends){
        S32924=1;
    t_thread_3 = new ConveyorTwin();//sysj\conveyorController.sysj line: 72, column: 3
    t_thread_3.setMoving(true);//sysj\conveyorController.sysj line: 73, column: 3
    S32898=0;
    if(GuiStep.infeedEnabled((GuiPermit)(operatorPermit.getpreval() == null ? null : ((GuiPermit)operatorPermit.getpreval())))){//sysj\conveyorController.sysj line: 75, column: 4
      motInfeed.setPresent();//sysj\conveyorController.sysj line: 75, column: 59
      currsigs.addElement(motInfeed);
      if(t_thread_3.update(PlantClock.now(), MachineStatus.WORKING, "motInfeed", "running")){//sysj\conveyorController.sysj line: 76, column: 4
        twin.setPresent();//sysj\conveyorController.sysj line: 77, column: 5
        currsigs.addElement(twin);
        twin.setValue(t_thread_3);//sysj\conveyorController.sysj line: 77, column: 5
        S32898=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S32898=1;
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
        S32898=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
      else {
        S32898=1;
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
      }
    }
  }

  public void thread34516(int [] tdone, int [] ends){
        S32892=1;
    q_thread_2 = BeltQueue.shared();//sysj\conveyorController.sysj line: 47, column: 3
    w_thread_2 = null;//sysj\conveyorController.sysj line: 48, column: 3
    S32431=0;
    if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 52, column: 20
      S32431=1;
      S32371=0;
      if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 54, column: 4
        bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
        S32371=1;
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        S32366=0;
        if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
          bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 54, column: 4
          S32366=1;
          if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 54, column: 4
            bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 54, column: 4
            ends[2]=2;
            ;//sysj\conveyorController.sysj line: 54, column: 4
            w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 55, column: 4
            q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 56, column: 4
            System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 57, column: 4
            S32431=2;
            if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 64, column: 20
              S32431=3;
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
      switch(S34514){
        case 0 : 
          S34514=0;
          break RUN;
        
        case 1 : 
          S34514=2;
          S34514=2;
          thread34516(tdone,ends);
          thread34517(tdone,ends);
          thread34518(tdone,ends);
          thread34519(tdone,ends);
          int biggest34520 = 0;
          if(ends[2]>=biggest34520){
            biggest34520=ends[2];
          }
          if(ends[3]>=biggest34520){
            biggest34520=ends[3];
          }
          if(ends[4]>=biggest34520){
            biggest34520=ends[4];
          }
          if(ends[5]>=biggest34520){
            biggest34520=ends[5];
          }
          if(biggest34520 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread34521(tdone,ends);
          thread34522(tdone,ends);
          thread34523(tdone,ends);
          thread34524(tdone,ends);
          int biggest34525 = 0;
          if(ends[2]>=biggest34525){
            biggest34525=ends[2];
          }
          if(ends[3]>=biggest34525){
            biggest34525=ends[3];
          }
          if(ends[4]>=biggest34525){
            biggest34525=ends[4];
          }
          if(ends[5]>=biggest34525){
            biggest34525=ends[5];
          }
          if(biggest34525 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest34525 == 0){
            S34514=0;
            active[1]=0;
            ends[1]=0;
            S34514=0;
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
