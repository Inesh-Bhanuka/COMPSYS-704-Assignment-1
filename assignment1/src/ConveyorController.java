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
  public Signal bottlePlaced = new Signal("bottlePlaced", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.INPUT);
  public Signal infeedClear = new Signal("infeedClear", Signal.INPUT);
  public Signal bottleAtOutfeedEnd = new Signal("bottleAtOutfeedEnd", Signal.INPUT);
  public Signal outfeedClear = new Signal("outfeedClear", Signal.INPUT);
  public Signal tableReady = new Signal("tableReady", Signal.INPUT);
  public Signal bottleFromTable = new Signal("bottleFromTable", Signal.INPUT);
  public Signal bottleTaken = new Signal("bottleTaken", Signal.INPUT);
  public Signal conveyorReady = new Signal("conveyorReady", Signal.OUTPUT);
  public Signal motInfeed = new Signal("motInfeed", Signal.OUTPUT);
  public Signal injectInfeed = new Signal("injectInfeed", Signal.OUTPUT);
  public Signal takeFromPos1 = new Signal("takeFromPos1", Signal.OUTPUT);
  public Signal motOutfeed = new Signal("motOutfeed", Signal.OUTPUT);
  public Signal injectOutfeed = new Signal("injectOutfeed", Signal.OUTPUT);
  public Signal collectFromEnd = new Signal("collectFromEnd", Signal.OUTPUT);
<<<<<<< Updated upstream
  public Signal bottleToTable = new Signal("bottleToTable", Signal.OUTPUT);
  public Signal bottleAtLabeller = new Signal("bottleAtLabeller", Signal.OUTPUT);
  private int S1640 = 1;
  private int S1348 = 1;
  private int S1366 = 1;
  private int S1350 = 1;
  private int S1371 = 1;
  private int S1588 = 1;
  private int S1385 = 1;
  private int S1638 = 1;
  private int S1590 = 1;
=======
  public input_Channel bottleHandoff_in = new input_Channel();
  public input_Channel tableOutfeed_in = new input_Channel();
  public output_Channel tableInfeed_o = new output_Channel();
  public output_Channel bottleDone_o = new output_Channel();
  private BeltQueue q_thread_2;//sysj\conveyorController.sysj line: 46, column: 3
  private WorkpieceTwin w_thread_2;//sysj\conveyorController.sysj line: 47, column: 3
  private ConveyorTwin t_thread_3;//sysj\conveyorController.sysj line: 71, column: 3
  private BeltQueue q_thread_4;//sysj\conveyorController.sysj line: 83, column: 3
  private WorkpieceTwin w_thread_4;//sysj\conveyorController.sysj line: 84, column: 3
  private WorkpieceTwin w_thread_5;//sysj\conveyorController.sysj line: 107, column: 3
  private int S26642 = 1;
  private int S24972 = 1;
  private int S24511 = 1;
  private int S24451 = 1;
  private int S24446 = 1;
  private int S24992 = 1;
  private int S25522 = 1;
  private int S24995 = 1;
  private int S25002 = 1;
  private int S24997 = 1;
  private int S26640 = 1;
  private int S25590 = 1;
  private int S25530 = 1;
  private int S25525 = 1;
  private int S25649 = 1;
  private int S25644 = 1;
>>>>>>> Stashed changes
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
<<<<<<< Updated upstream
  public void thread1652(int [] tdone, int [] ends){
        switch(S1638){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S1590){
          case 0 : 
            if(bottleFromTable.getprestatus()){//sysj\conveyorController.sysj line: 109, column: 20
              System.out.println("[CV] Bottle received from turntable.");//sysj\conveyorController.sysj line: 110, column: 4
              injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 112, column: 4
              currsigs.addElement(injectOutfeed);
              S1590=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            S1590=1;
            injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 113, column: 4
            currsigs.addElement(injectOutfeed);
            S1590=2;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
          case 2 : 
            S1590=2;
            injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 114, column: 4
            currsigs.addElement(injectOutfeed);
            S1590=3;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
          case 3 : 
            S1590=3;
            S1590=4;
            motOutfeed.setPresent();//sysj\conveyorController.sysj line: 117, column: 5
            currsigs.addElement(motOutfeed);
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
          case 4 : 
            if(bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 116, column: 10
              System.out.println("[CV] Bottle delivered to labeller point.");//sysj\conveyorController.sysj line: 120, column: 4
              bottleAtLabeller.setPresent();//sysj\conveyorController.sysj line: 123, column: 4
              currsigs.addElement(bottleAtLabeller);
              collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 123, column: 27
              currsigs.addElement(collectFromEnd);
              S1590=5;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 117, column: 5
              currsigs.addElement(motOutfeed);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 5 : 
            S1590=5;
            bottleAtLabeller.setPresent();//sysj\conveyorController.sysj line: 124, column: 4
            currsigs.addElement(bottleAtLabeller);
            collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 124, column: 27
            currsigs.addElement(collectFromEnd);
            S1590=6;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
          case 6 : 
            S1590=6;
            bottleAtLabeller.setPresent();//sysj\conveyorController.sysj line: 125, column: 4
            currsigs.addElement(bottleAtLabeller);
            collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 125, column: 27
            currsigs.addElement(collectFromEnd);
            S1590=7;
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
            break;
          
          case 7 : 
            S1590=7;
            S1590=8;
            if(!bottleFromTable.getprestatus()){//sysj\conveyorController.sysj line: 127, column: 20
              S1590=0;
              if(bottleFromTable.getprestatus()){//sysj\conveyorController.sysj line: 109, column: 20
                System.out.println("[CV] Bottle received from turntable.");//sysj\conveyorController.sysj line: 110, column: 4
                injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 112, column: 4
                currsigs.addElement(injectOutfeed);
                S1590=1;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 8 : 
            if(!bottleFromTable.getprestatus()){//sysj\conveyorController.sysj line: 127, column: 20
              S1590=0;
              if(bottleFromTable.getprestatus()){//sysj\conveyorController.sysj line: 109, column: 20
                System.out.println("[CV] Bottle received from turntable.");//sysj\conveyorController.sysj line: 110, column: 4
                injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 112, column: 4
                currsigs.addElement(injectOutfeed);
                S1590=1;
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
              else {
                active[6]=1;
                ends[6]=1;
                tdone[6]=1;
              }
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1651(int [] tdone, int [] ends){
        switch(S1588){
=======
  public void thread26652(int [] tdone, int [] ends){
        switch(S26640){
>>>>>>> Stashed changes
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
<<<<<<< Updated upstream
        switch(S1385){
          case 0 : 
            if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 81, column: 20
              S1385=1;
              if(tableReady.getprestatus()){//sysj\conveyorController.sysj line: 83, column: 12
                S1385=2;
                bottleToTable.setPresent();//sysj\conveyorController.sysj line: 94, column: 5
                currsigs.addElement(bottleToTable);
=======
        switch(S25590){
          case 0 : 
            if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 109, column: 20
              S25590=1;
              S25530=0;
              if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 111, column: 4
                tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 111, column: 4
                S25530=1;
>>>>>>> Stashed changes
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
<<<<<<< Updated upstream
                System.out.println("[CV] At position 1 - waiting for table.");//sysj\conveyorController.sysj line: 87, column: 5
                if(tableReady.getprestatus()){//sysj\conveyorController.sysj line: 88, column: 21
                  S1385=2;
                  bottleToTable.setPresent();//sysj\conveyorController.sysj line: 94, column: 5
                  currsigs.addElement(bottleToTable);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
=======
                S25525=0;
                if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 111, column: 4
                  tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 111, column: 4
                  S25525=1;
                  if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 111, column: 4
                    tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 111, column: 4
                    ends[5]=2;
                    ;//sysj\conveyorController.sysj line: 111, column: 4
                    w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 112, column: 4
                    System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj\conveyorController.sysj line: 113, column: 4
                    S25590=2;
                    if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 115, column: 20
                      S25590=3;
                      motOutfeed.setPresent();//sysj\conveyorController.sysj line: 120, column: 5
                      currsigs.addElement(motOutfeed);
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    else {
                      injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 116, column: 5
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
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
            if(tableReady.getprestatus()){//sysj\conveyorController.sysj line: 88, column: 21
              S1385=2;
              bottleToTable.setPresent();//sysj\conveyorController.sysj line: 94, column: 5
              currsigs.addElement(bottleToTable);
=======
            switch(S25530){
              case 0 : 
                if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 111, column: 4
                  tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 111, column: 4
                  S25530=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S25525){
                    case 0 : 
                      if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 111, column: 4
                        tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 111, column: 4
                        S25525=1;
                        if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 111, column: 4
                          tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 111, column: 4
                          ends[5]=2;
                          ;//sysj\conveyorController.sysj line: 111, column: 4
                          w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 112, column: 4
                          System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj\conveyorController.sysj line: 113, column: 4
                          S25590=2;
                          if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 115, column: 20
                            S25590=3;
                            motOutfeed.setPresent();//sysj\conveyorController.sysj line: 120, column: 5
                            currsigs.addElement(motOutfeed);
                            active[5]=1;
                            ends[5]=1;
                            tdone[5]=1;
                          }
                          else {
                            injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 116, column: 5
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
                      if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 111, column: 4
                        tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 111, column: 4
                        ends[5]=2;
                        ;//sysj\conveyorController.sysj line: 111, column: 4
                        w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 112, column: 4
                        System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj\conveyorController.sysj line: 113, column: 4
                        S25590=2;
                        if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 115, column: 20
                          S25590=3;
                          motOutfeed.setPresent();//sysj\conveyorController.sysj line: 120, column: 5
                          currsigs.addElement(motOutfeed);
                          active[5]=1;
                          ends[5]=1;
                          tdone[5]=1;
                        }
                        else {
                          injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 116, column: 5
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
                S25530=1;
                S25530=0;
                if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 111, column: 4
                  tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 111, column: 4
                  S25530=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S25525=0;
                  if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 111, column: 4
                    tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 111, column: 4
                    S25525=1;
                    if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 111, column: 4
                      tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 111, column: 4
                      ends[5]=2;
                      ;//sysj\conveyorController.sysj line: 111, column: 4
                      w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 112, column: 4
                      System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj\conveyorController.sysj line: 113, column: 4
                      S25590=2;
                      if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 115, column: 20
                        S25590=3;
                        motOutfeed.setPresent();//sysj\conveyorController.sysj line: 120, column: 5
                        currsigs.addElement(motOutfeed);
                        active[5]=1;
                        ends[5]=1;
                        tdone[5]=1;
                      }
                      else {
                        injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 116, column: 5
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
            if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 115, column: 20
              S25590=3;
              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 120, column: 5
              currsigs.addElement(motOutfeed);
>>>>>>> Stashed changes
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
            if(bottleTaken.getprestatus()){//sysj\conveyorController.sysj line: 93, column: 10
              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 99, column: 4
              currsigs.addElement(takeFromPos1);
              S1385=3;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              bottleToTable.setPresent();//sysj\conveyorController.sysj line: 94, column: 5
              currsigs.addElement(bottleToTable);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 3 : 
<<<<<<< Updated upstream
            S1385=3;
            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 100, column: 4
            currsigs.addElement(takeFromPos1);
            S1385=4;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
          case 4 : 
            S1385=4;
            System.out.println("[CV] Handed off to table.");//sysj\conveyorController.sysj line: 101, column: 4
            S1385=5;
            if(!bottleTaken.getprestatus()){//sysj\conveyorController.sysj line: 102, column: 20
              S1385=6;
              if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 103, column: 20
                S1385=0;
                if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 81, column: 20
                  S1385=1;
                  if(tableReady.getprestatus()){//sysj\conveyorController.sysj line: 83, column: 12
                    S1385=2;
                    bottleToTable.setPresent();//sysj\conveyorController.sysj line: 94, column: 5
                    currsigs.addElement(bottleToTable);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    System.out.println("[CV] At position 1 - waiting for table.");//sysj\conveyorController.sysj line: 87, column: 5
                    if(tableReady.getprestatus()){//sysj\conveyorController.sysj line: 88, column: 21
                      S1385=2;
                      bottleToTable.setPresent();//sysj\conveyorController.sysj line: 94, column: 5
                      currsigs.addElement(bottleToTable);
=======
            if(bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 119, column: 10
              S25590=4;
              if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 123, column: 20
                System.out.println("[CV] " + w_thread_5 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 126, column: 4
                S25590=5;
                S25649=0;
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 128, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 128, column: 4
                  S25649=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S25644=0;
                  if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 128, column: 4
                    bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 128, column: 4
                    S25644=1;
                    if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 128, column: 4
                      bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 128, column: 4
                      ends[5]=2;
                      ;//sysj\conveyorController.sysj line: 128, column: 4
                      S25590=6;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
                  else {
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                }
              }
              else {
                collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 124, column: 5
                currsigs.addElement(collectFromEnd);
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
            }
            else {
              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 120, column: 5
              currsigs.addElement(motOutfeed);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 4 : 
            if(!bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 123, column: 20
              System.out.println("[CV] " + w_thread_5 + " delivered to the labeller point.");//sysj\conveyorController.sysj line: 126, column: 4
              S25590=5;
              S25649=0;
              if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 128, column: 4
                bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 128, column: 4
                S25649=1;
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
              else {
                S25644=0;
                if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 128, column: 4
                  bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 128, column: 4
                  S25644=1;
                  if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 128, column: 4
                    bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 128, column: 4
                    ends[5]=2;
                    ;//sysj\conveyorController.sysj line: 128, column: 4
                    S25590=6;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
>>>>>>> Stashed changes
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
          
          case 5 : 
<<<<<<< Updated upstream
            if(!bottleTaken.getprestatus()){//sysj\conveyorController.sysj line: 102, column: 20
              S1385=6;
              if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 103, column: 20
                S1385=0;
                if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 81, column: 20
                  S1385=1;
                  if(tableReady.getprestatus()){//sysj\conveyorController.sysj line: 83, column: 12
                    S1385=2;
                    bottleToTable.setPresent();//sysj\conveyorController.sysj line: 94, column: 5
                    currsigs.addElement(bottleToTable);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    System.out.println("[CV] At position 1 - waiting for table.");//sysj\conveyorController.sysj line: 87, column: 5
                    if(tableReady.getprestatus()){//sysj\conveyorController.sysj line: 88, column: 21
                      S1385=2;
                      bottleToTable.setPresent();//sysj\conveyorController.sysj line: 94, column: 5
                      currsigs.addElement(bottleToTable);
=======
            switch(S25649){
              case 0 : 
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 128, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 128, column: 4
                  S25649=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  switch(S25644){
                    case 0 : 
                      if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 128, column: 4
                        bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 128, column: 4
                        S25644=1;
                        if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 128, column: 4
                          bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 128, column: 4
                          ends[5]=2;
                          ;//sysj\conveyorController.sysj line: 128, column: 4
                          S25590=6;
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
                      if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 128, column: 4
                        bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 128, column: 4
                        ends[5]=2;
                        ;//sysj\conveyorController.sysj line: 128, column: 4
                        S25590=6;
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
                S25649=1;
                S25649=0;
                if(!bottleDone_o.isPartnerPresent() || bottleDone_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 128, column: 4
                  bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 128, column: 4
                  S25649=1;
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  S25644=0;
                  if(bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 128, column: 4
                    bottleDone_o.setVal(w_thread_5);//sysj\conveyorController.sysj line: 128, column: 4
                    S25644=1;
                    if(!bottleDone_o.isACK()){//sysj\conveyorController.sysj line: 128, column: 4
                      bottleDone_o.setREQ(false);//sysj\conveyorController.sysj line: 128, column: 4
                      ends[5]=2;
                      ;//sysj\conveyorController.sysj line: 128, column: 4
                      S25590=6;
>>>>>>> Stashed changes
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
                }
<<<<<<< Updated upstream
                else {
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
              }
              else {
=======
                break;
              
            }
            break;
          
          case 6 : 
            S25590=6;
            S25590=0;
            if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 109, column: 20
              S25590=1;
              S25530=0;
              if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 111, column: 4
                tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 111, column: 4
                S25530=1;
>>>>>>> Stashed changes
                active[5]=1;
                ends[5]=1;
                tdone[5]=1;
              }
<<<<<<< Updated upstream
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 6 : 
            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 103, column: 20
              S1385=0;
              if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 81, column: 20
                S1385=1;
                if(tableReady.getprestatus()){//sysj\conveyorController.sysj line: 83, column: 12
                  S1385=2;
                  bottleToTable.setPresent();//sysj\conveyorController.sysj line: 94, column: 5
                  currsigs.addElement(bottleToTable);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  System.out.println("[CV] At position 1 - waiting for table.");//sysj\conveyorController.sysj line: 87, column: 5
                  if(tableReady.getprestatus()){//sysj\conveyorController.sysj line: 88, column: 21
                    S1385=2;
                    bottleToTable.setPresent();//sysj\conveyorController.sysj line: 94, column: 5
                    currsigs.addElement(bottleToTable);
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
=======
              else {
                S25525=0;
                if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 111, column: 4
                  tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 111, column: 4
                  S25525=1;
                  if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 111, column: 4
                    tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 111, column: 4
                    ends[5]=2;
                    ;//sysj\conveyorController.sysj line: 111, column: 4
                    w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 112, column: 4
                    System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj\conveyorController.sysj line: 113, column: 4
                    S25590=2;
                    if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 115, column: 20
                      S25590=3;
                      motOutfeed.setPresent();//sysj\conveyorController.sysj line: 120, column: 5
                      currsigs.addElement(motOutfeed);
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
                    else {
                      injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 116, column: 5
                      currsigs.addElement(injectOutfeed);
                      active[5]=1;
                      ends[5]=1;
                      tdone[5]=1;
                    }
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
  public void thread1650(int [] tdone, int [] ends){
        switch(S1371){
=======
  public void thread26651(int [] tdone, int [] ends){
        switch(S25522){
>>>>>>> Stashed changes
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
<<<<<<< Updated upstream
        motInfeed.setPresent();//sysj\conveyorController.sysj line: 74, column: 4
        currsigs.addElement(motInfeed);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
=======
        switch(S24995){
          case 0 : 
            if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 86, column: 20
              w_thread_4 = q_thread_4.peek();//sysj\conveyorController.sysj line: 88, column: 4
              if(w_thread_4 != null) {//sysj\conveyorController.sysj line: 89, column: 17
                w_thread_4.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 89, column: 19
              }
              System.out.println("[CV] " + w_thread_4 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 90, column: 4
              S24995=1;
              S25002=0;
              if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 93, column: 4
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 93, column: 4
                S25002=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S24997=0;
                if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 93, column: 4
                  tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 93, column: 4
                  S24997=1;
                  if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 93, column: 4
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 93, column: 4
                    ends[4]=2;
                    ;//sysj\conveyorController.sysj line: 93, column: 4
                    q_thread_4.pop();//sysj\conveyorController.sysj line: 94, column: 4
                    S24995=2;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 98, column: 20
                      System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 101, column: 4
                      S24995=3;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 99, column: 5
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
            switch(S25002){
              case 0 : 
                if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 93, column: 4
                  tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 93, column: 4
                  S25002=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  switch(S24997){
                    case 0 : 
                      if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 93, column: 4
                        tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 93, column: 4
                        S24997=1;
                        if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 93, column: 4
                          tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 93, column: 4
                          ends[4]=2;
                          ;//sysj\conveyorController.sysj line: 93, column: 4
                          q_thread_4.pop();//sysj\conveyorController.sysj line: 94, column: 4
                          S24995=2;
                          if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 98, column: 20
                            System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 101, column: 4
                            S24995=3;
                            active[4]=1;
                            ends[4]=1;
                            tdone[4]=1;
                          }
                          else {
                            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 99, column: 5
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
                      if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 93, column: 4
                        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 93, column: 4
                        ends[4]=2;
                        ;//sysj\conveyorController.sysj line: 93, column: 4
                        q_thread_4.pop();//sysj\conveyorController.sysj line: 94, column: 4
                        S24995=2;
                        if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 98, column: 20
                          System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 101, column: 4
                          S24995=3;
                          active[4]=1;
                          ends[4]=1;
                          tdone[4]=1;
                        }
                        else {
                          takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 99, column: 5
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
                S25002=1;
                S25002=0;
                if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 93, column: 4
                  tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 93, column: 4
                  S25002=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                else {
                  S24997=0;
                  if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 93, column: 4
                    tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 93, column: 4
                    S24997=1;
                    if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 93, column: 4
                      tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 93, column: 4
                      ends[4]=2;
                      ;//sysj\conveyorController.sysj line: 93, column: 4
                      q_thread_4.pop();//sysj\conveyorController.sysj line: 94, column: 4
                      S24995=2;
                      if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 98, column: 20
                        System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 101, column: 4
                        S24995=3;
                        active[4]=1;
                        ends[4]=1;
                        tdone[4]=1;
                      }
                      else {
                        takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 99, column: 5
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
            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 98, column: 20
              System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 101, column: 4
              S24995=3;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 99, column: 5
              currsigs.addElement(takeFromPos1);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 3 : 
            S24995=3;
            S24995=0;
            if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 86, column: 20
              w_thread_4 = q_thread_4.peek();//sysj\conveyorController.sysj line: 88, column: 4
              if(w_thread_4 != null) {//sysj\conveyorController.sysj line: 89, column: 17
                w_thread_4.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 89, column: 19
              }
              System.out.println("[CV] " + w_thread_4 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 90, column: 4
              S24995=1;
              S25002=0;
              if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 93, column: 4
                tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 93, column: 4
                S25002=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S24997=0;
                if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 93, column: 4
                  tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 93, column: 4
                  S24997=1;
                  if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 93, column: 4
                    tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 93, column: 4
                    ends[4]=2;
                    ;//sysj\conveyorController.sysj line: 93, column: 4
                    q_thread_4.pop();//sysj\conveyorController.sysj line: 94, column: 4
                    S24995=2;
                    if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 98, column: 20
                      System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 101, column: 4
                      S24995=3;
                      active[4]=1;
                      ends[4]=1;
                      tdone[4]=1;
                    }
                    else {
                      takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 99, column: 5
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
>>>>>>> Stashed changes
        break;
      
    }
  }

<<<<<<< Updated upstream
  public void thread1649(int [] tdone, int [] ends){
        switch(S1366){
=======
  public void thread26650(int [] tdone, int [] ends){
        switch(S24992){
>>>>>>> Stashed changes
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1350){
          case 0 : 
            if(bottlePlaced.getprestatus()){//sysj\conveyorController.sysj line: 54, column: 20
              System.out.println("[CV] Bottle received from loader.");//sysj\conveyorController.sysj line: 55, column: 4
              injectInfeed.setPresent();//sysj\conveyorController.sysj line: 57, column: 4
              currsigs.addElement(injectInfeed);
              S1350=1;
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
          
          case 1 : 
            S1350=1;
            injectInfeed.setPresent();//sysj\conveyorController.sysj line: 58, column: 4
            currsigs.addElement(injectInfeed);
            S1350=2;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 2 : 
            S1350=2;
            injectInfeed.setPresent();//sysj\conveyorController.sysj line: 59, column: 4
            currsigs.addElement(injectInfeed);
            S1350=3;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 3 : 
            S1350=3;
            S1350=4;
            if(!bottlePlaced.getprestatus()){//sysj\conveyorController.sysj line: 63, column: 20
              S1350=0;
              if(bottlePlaced.getprestatus()){//sysj\conveyorController.sysj line: 54, column: 20
                System.out.println("[CV] Bottle received from loader.");//sysj\conveyorController.sysj line: 55, column: 4
                injectInfeed.setPresent();//sysj\conveyorController.sysj line: 57, column: 4
                currsigs.addElement(injectInfeed);
                S1350=1;
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
          
          case 4 : 
            if(!bottlePlaced.getprestatus()){//sysj\conveyorController.sysj line: 63, column: 20
              S1350=0;
              if(bottlePlaced.getprestatus()){//sysj\conveyorController.sysj line: 54, column: 20
                System.out.println("[CV] Bottle received from loader.");//sysj\conveyorController.sysj line: 55, column: 4
                injectInfeed.setPresent();//sysj\conveyorController.sysj line: 57, column: 4
                currsigs.addElement(injectInfeed);
                S1350=1;
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
        break;
      
    }
  }

<<<<<<< Updated upstream
  public void thread1648(int [] tdone, int [] ends){
        switch(S1348){
=======
  public void thread26649(int [] tdone, int [] ends){
        switch(S24972){
>>>>>>> Stashed changes
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
<<<<<<< Updated upstream
        if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 45, column: 12
          conveyorReady.setPresent();//sysj\conveyorController.sysj line: 46, column: 5
          currsigs.addElement(conveyorReady);
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        else {
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
=======
        switch(S24511){
          case 0 : 
            if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 51, column: 20
              S24511=1;
              S24451=0;
              if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 53, column: 4
                bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 53, column: 4
                S24451=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S24446=0;
                if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 53, column: 4
                  bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 53, column: 4
                  S24446=1;
                  if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 53, column: 4
                    bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 53, column: 4
                    ends[2]=2;
                    ;//sysj\conveyorController.sysj line: 53, column: 4
                    w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 54, column: 4
                    q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 55, column: 4
                    System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 56, column: 4
                    S24511=2;
                    if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 63, column: 20
                      S24511=3;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      injectInfeed.setPresent();//sysj\conveyorController.sysj line: 64, column: 5
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
            switch(S24451){
              case 0 : 
                if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 53, column: 4
                  bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 53, column: 4
                  S24451=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S24446){
                    case 0 : 
                      if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 53, column: 4
                        bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 53, column: 4
                        S24446=1;
                        if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 53, column: 4
                          bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 53, column: 4
                          ends[2]=2;
                          ;//sysj\conveyorController.sysj line: 53, column: 4
                          w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 54, column: 4
                          q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 55, column: 4
                          System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 56, column: 4
                          S24511=2;
                          if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 63, column: 20
                            S24511=3;
                            active[2]=1;
                            ends[2]=1;
                            tdone[2]=1;
                          }
                          else {
                            injectInfeed.setPresent();//sysj\conveyorController.sysj line: 64, column: 5
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
                      if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 53, column: 4
                        bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 53, column: 4
                        ends[2]=2;
                        ;//sysj\conveyorController.sysj line: 53, column: 4
                        w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 54, column: 4
                        q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 55, column: 4
                        System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 56, column: 4
                        S24511=2;
                        if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 63, column: 20
                          S24511=3;
                          active[2]=1;
                          ends[2]=1;
                          tdone[2]=1;
                        }
                        else {
                          injectInfeed.setPresent();//sysj\conveyorController.sysj line: 64, column: 5
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
                S24451=1;
                S24451=0;
                if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 53, column: 4
                  bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 53, column: 4
                  S24451=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S24446=0;
                  if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 53, column: 4
                    bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 53, column: 4
                    S24446=1;
                    if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 53, column: 4
                      bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 53, column: 4
                      ends[2]=2;
                      ;//sysj\conveyorController.sysj line: 53, column: 4
                      w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 54, column: 4
                      q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 55, column: 4
                      System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 56, column: 4
                      S24511=2;
                      if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 63, column: 20
                        S24511=3;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      else {
                        injectInfeed.setPresent();//sysj\conveyorController.sysj line: 64, column: 5
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
            if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 63, column: 20
              S24511=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              injectInfeed.setPresent();//sysj\conveyorController.sysj line: 64, column: 5
              currsigs.addElement(injectInfeed);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            S24511=3;
            S24511=0;
            if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 51, column: 20
              S24511=1;
              S24451=0;
              if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 53, column: 4
                bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 53, column: 4
                S24451=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S24446=0;
                if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 53, column: 4
                  bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 53, column: 4
                  S24446=1;
                  if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 53, column: 4
                    bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 53, column: 4
                    ends[2]=2;
                    ;//sysj\conveyorController.sysj line: 53, column: 4
                    w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 54, column: 4
                    q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 55, column: 4
                    System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 56, column: 4
                    S24511=2;
                    if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 63, column: 20
                      S24511=3;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    else {
                      injectInfeed.setPresent();//sysj\conveyorController.sysj line: 64, column: 5
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
          
>>>>>>> Stashed changes
        }
        break;
      
    }
  }

<<<<<<< Updated upstream
  public void thread1646(int [] tdone, int [] ends){
        S1638=1;
    S1590=0;
    if(bottleFromTable.getprestatus()){//sysj\conveyorController.sysj line: 109, column: 20
      System.out.println("[CV] Bottle received from turntable.");//sysj\conveyorController.sysj line: 110, column: 4
      injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 112, column: 4
      currsigs.addElement(injectOutfeed);
      S1590=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread1645(int [] tdone, int [] ends){
        S1588=1;
    S1385=0;
    if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 81, column: 20
      S1385=1;
      if(tableReady.getprestatus()){//sysj\conveyorController.sysj line: 83, column: 12
        S1385=2;
        bottleToTable.setPresent();//sysj\conveyorController.sysj line: 94, column: 5
        currsigs.addElement(bottleToTable);
=======
  public void thread26647(int [] tdone, int [] ends){
        S26640=1;
    w_thread_5 = null;//sysj\conveyorController.sysj line: 107, column: 3
    S25590=0;
    if(outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 109, column: 20
      S25590=1;
      S25530=0;
      if(!tableOutfeed_in.isPartnerPresent() || tableOutfeed_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 111, column: 4
        tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 111, column: 4
        S25530=1;
>>>>>>> Stashed changes
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
      }
      else {
<<<<<<< Updated upstream
        System.out.println("[CV] At position 1 - waiting for table.");//sysj\conveyorController.sysj line: 87, column: 5
        if(tableReady.getprestatus()){//sysj\conveyorController.sysj line: 88, column: 21
          S1385=2;
          bottleToTable.setPresent();//sysj\conveyorController.sysj line: 94, column: 5
          currsigs.addElement(bottleToTable);
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
=======
        S25525=0;
        if(!tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 111, column: 4
          tableOutfeed_in.setACK(true);//sysj\conveyorController.sysj line: 111, column: 4
          S25525=1;
          if(tableOutfeed_in.isREQ()){//sysj\conveyorController.sysj line: 111, column: 4
            tableOutfeed_in.setACK(false);//sysj\conveyorController.sysj line: 111, column: 4
            ends[5]=2;
            ;//sysj\conveyorController.sysj line: 111, column: 4
            w_thread_5 = (WorkpieceTwin)(tableOutfeed_in.getVal() == null ? null : ((WorkpieceTwin)tableOutfeed_in.getVal()));//sysj\conveyorController.sysj line: 112, column: 4
            System.out.println("[CV] " + w_thread_5 + " received from the table.");//sysj\conveyorController.sysj line: 113, column: 4
            S25590=2;
            if(!outfeedClear.getprestatus()){//sysj\conveyorController.sysj line: 115, column: 20
              S25590=3;
              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 120, column: 5
              currsigs.addElement(motOutfeed);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 116, column: 5
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
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
  public void thread1644(int [] tdone, int [] ends){
        S1371=1;
=======
  public void thread26646(int [] tdone, int [] ends){
        S25522=1;
    q_thread_4 = BeltQueue.shared();//sysj\conveyorController.sysj line: 83, column: 3
    w_thread_4 = null;//sysj\conveyorController.sysj line: 84, column: 3
    S24995=0;
    if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 86, column: 20
      w_thread_4 = q_thread_4.peek();//sysj\conveyorController.sysj line: 88, column: 4
      if(w_thread_4 != null) {//sysj\conveyorController.sysj line: 89, column: 17
        w_thread_4.arrived(Machine.CONVEYOR);//sysj\conveyorController.sysj line: 89, column: 19
      }
      System.out.println("[CV] " + w_thread_4 + " at position 1, offering to the table.");//sysj\conveyorController.sysj line: 90, column: 4
      S24995=1;
      S25002=0;
      if(!tableInfeed_o.isPartnerPresent() || tableInfeed_o.isPartnerPreempted()){//sysj\conveyorController.sysj line: 93, column: 4
        tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 93, column: 4
        S25002=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S24997=0;
        if(tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 93, column: 4
          tableInfeed_o.setVal(w_thread_4);//sysj\conveyorController.sysj line: 93, column: 4
          S24997=1;
          if(!tableInfeed_o.isACK()){//sysj\conveyorController.sysj line: 93, column: 4
            tableInfeed_o.setREQ(false);//sysj\conveyorController.sysj line: 93, column: 4
            ends[4]=2;
            ;//sysj\conveyorController.sysj line: 93, column: 4
            q_thread_4.pop();//sysj\conveyorController.sysj line: 94, column: 4
            S24995=2;
            if(!bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 98, column: 20
              System.out.println("[CV] " + w_thread_4 + " handed to the table.");//sysj\conveyorController.sysj line: 101, column: 4
              S24995=3;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 99, column: 5
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

  public void thread26645(int [] tdone, int [] ends){
        S24992=1;
    t_thread_3 = new ConveyorTwin();//sysj\conveyorController.sysj line: 71, column: 3
    t_thread_3.setMoving(true);//sysj\conveyorController.sysj line: 72, column: 3
>>>>>>> Stashed changes
    motInfeed.setPresent();//sysj\conveyorController.sysj line: 74, column: 4
    currsigs.addElement(motInfeed);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread1643(int [] tdone, int [] ends){
        S1366=1;
    S1350=0;
    if(bottlePlaced.getprestatus()){//sysj\conveyorController.sysj line: 54, column: 20
      System.out.println("[CV] Bottle received from loader.");//sysj\conveyorController.sysj line: 55, column: 4
      injectInfeed.setPresent();//sysj\conveyorController.sysj line: 57, column: 4
      currsigs.addElement(injectInfeed);
      S1350=1;
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

<<<<<<< Updated upstream
  public void thread1642(int [] tdone, int [] ends){
        S1348=1;
    if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 45, column: 12
      conveyorReady.setPresent();//sysj\conveyorController.sysj line: 46, column: 5
      currsigs.addElement(conveyorReady);
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
=======
  public void thread26644(int [] tdone, int [] ends){
        S24972=1;
    q_thread_2 = BeltQueue.shared();//sysj\conveyorController.sysj line: 46, column: 3
    w_thread_2 = null;//sysj\conveyorController.sysj line: 47, column: 3
    S24511=0;
    if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 51, column: 20
      S24511=1;
      S24451=0;
      if(!bottleHandoff_in.isPartnerPresent() || bottleHandoff_in.isPartnerPreempted()){//sysj\conveyorController.sysj line: 53, column: 4
        bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 53, column: 4
        S24451=1;
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        S24446=0;
        if(!bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 53, column: 4
          bottleHandoff_in.setACK(true);//sysj\conveyorController.sysj line: 53, column: 4
          S24446=1;
          if(bottleHandoff_in.isREQ()){//sysj\conveyorController.sysj line: 53, column: 4
            bottleHandoff_in.setACK(false);//sysj\conveyorController.sysj line: 53, column: 4
            ends[2]=2;
            ;//sysj\conveyorController.sysj line: 53, column: 4
            w_thread_2 = (WorkpieceTwin)(bottleHandoff_in.getVal() == null ? null : ((WorkpieceTwin)bottleHandoff_in.getVal()));//sysj\conveyorController.sysj line: 54, column: 4
            q_thread_2.push(w_thread_2);//sysj\conveyorController.sysj line: 55, column: 4
            System.out.println("[CV] Accepted " + w_thread_2 + " from the loader.");//sysj\conveyorController.sysj line: 56, column: 4
            S24511=2;
            if(infeedAdmitted.getprestatus()){//sysj\conveyorController.sysj line: 63, column: 20
              S24511=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              injectInfeed.setPresent();//sysj\conveyorController.sysj line: 64, column: 5
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
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
      switch(S1640){
        case 0 : 
          S1640=0;
          break RUN;
        
        case 1 : 
          S1640=2;
          S1640=2;
          thread1642(tdone,ends);
          thread1643(tdone,ends);
          thread1644(tdone,ends);
          thread1645(tdone,ends);
          thread1646(tdone,ends);
          int biggest1647 = 0;
          if(ends[2]>=biggest1647){
            biggest1647=ends[2];
          }
          if(ends[3]>=biggest1647){
            biggest1647=ends[3];
          }
          if(ends[4]>=biggest1647){
            biggest1647=ends[4];
          }
          if(ends[5]>=biggest1647){
            biggest1647=ends[5];
          }
          if(ends[6]>=biggest1647){
            biggest1647=ends[6];
          }
          if(biggest1647 == 1){
=======
      switch(S26642){
        case 0 : 
          S26642=0;
          break RUN;
        
        case 1 : 
          S26642=2;
          S26642=2;
          thread26644(tdone,ends);
          thread26645(tdone,ends);
          thread26646(tdone,ends);
          thread26647(tdone,ends);
          int biggest26648 = 0;
          if(ends[2]>=biggest26648){
            biggest26648=ends[2];
          }
          if(ends[3]>=biggest26648){
            biggest26648=ends[3];
          }
          if(ends[4]>=biggest26648){
            biggest26648=ends[4];
          }
          if(ends[5]>=biggest26648){
            biggest26648=ends[5];
          }
          if(biggest26648 == 1){
>>>>>>> Stashed changes
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
<<<<<<< Updated upstream
          thread1648(tdone,ends);
          thread1649(tdone,ends);
          thread1650(tdone,ends);
          thread1651(tdone,ends);
          thread1652(tdone,ends);
          int biggest1653 = 0;
          if(ends[2]>=biggest1653){
            biggest1653=ends[2];
          }
          if(ends[3]>=biggest1653){
            biggest1653=ends[3];
          }
          if(ends[4]>=biggest1653){
            biggest1653=ends[4];
          }
          if(ends[5]>=biggest1653){
            biggest1653=ends[5];
          }
          if(ends[6]>=biggest1653){
            biggest1653=ends[6];
          }
          if(biggest1653 == 1){
=======
          thread26649(tdone,ends);
          thread26650(tdone,ends);
          thread26651(tdone,ends);
          thread26652(tdone,ends);
          int biggest26653 = 0;
          if(ends[2]>=biggest26653){
            biggest26653=ends[2];
          }
          if(ends[3]>=biggest26653){
            biggest26653=ends[3];
          }
          if(ends[4]>=biggest26653){
            biggest26653=ends[4];
          }
          if(ends[5]>=biggest26653){
            biggest26653=ends[5];
          }
          if(biggest26653 == 1){
>>>>>>> Stashed changes
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
<<<<<<< Updated upstream
          if(biggest1653 == 0){
            S1640=0;
            active[1]=0;
            ends[1]=0;
            S1640=0;
=======
          if(biggest26653 == 0){
            S26642=0;
            active[1]=0;
            ends[1]=0;
            S26642=0;
>>>>>>> Stashed changes
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0};
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
          bottlePlaced.gethook();
          bottleAtPos1.gethook();
          infeedClear.gethook();
          bottleAtOutfeedEnd.gethook();
          outfeedClear.gethook();
          tableReady.gethook();
          bottleFromTable.gethook();
          bottleTaken.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottlePlaced.setpreclear();
      bottleAtPos1.setpreclear();
      infeedClear.setpreclear();
      bottleAtOutfeedEnd.setpreclear();
      outfeedClear.setpreclear();
      tableReady.setpreclear();
      bottleFromTable.setpreclear();
      bottleTaken.setpreclear();
      conveyorReady.setpreclear();
      motInfeed.setpreclear();
      injectInfeed.setpreclear();
      takeFromPos1.setpreclear();
      motOutfeed.setpreclear();
      injectOutfeed.setpreclear();
      collectFromEnd.setpreclear();
      bottleToTable.setpreclear();
      bottleAtLabeller.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottlePlaced.getStatus() ? bottlePlaced.setprepresent() : bottlePlaced.setpreclear();
      bottlePlaced.setpreval(bottlePlaced.getValue());
      bottlePlaced.setClear();
      dummyint = bottleAtPos1.getStatus() ? bottleAtPos1.setprepresent() : bottleAtPos1.setpreclear();
      bottleAtPos1.setpreval(bottleAtPos1.getValue());
      bottleAtPos1.setClear();
      dummyint = infeedClear.getStatus() ? infeedClear.setprepresent() : infeedClear.setpreclear();
      infeedClear.setpreval(infeedClear.getValue());
      infeedClear.setClear();
      dummyint = bottleAtOutfeedEnd.getStatus() ? bottleAtOutfeedEnd.setprepresent() : bottleAtOutfeedEnd.setpreclear();
      bottleAtOutfeedEnd.setpreval(bottleAtOutfeedEnd.getValue());
      bottleAtOutfeedEnd.setClear();
      dummyint = outfeedClear.getStatus() ? outfeedClear.setprepresent() : outfeedClear.setpreclear();
      outfeedClear.setpreval(outfeedClear.getValue());
      outfeedClear.setClear();
      dummyint = tableReady.getStatus() ? tableReady.setprepresent() : tableReady.setpreclear();
      tableReady.setpreval(tableReady.getValue());
      tableReady.setClear();
      dummyint = bottleFromTable.getStatus() ? bottleFromTable.setprepresent() : bottleFromTable.setpreclear();
      bottleFromTable.setpreval(bottleFromTable.getValue());
      bottleFromTable.setClear();
      dummyint = bottleTaken.getStatus() ? bottleTaken.setprepresent() : bottleTaken.setpreclear();
      bottleTaken.setpreval(bottleTaken.getValue());
      bottleTaken.setClear();
      conveyorReady.sethook();
      conveyorReady.setClear();
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
      bottleToTable.sethook();
      bottleToTable.setClear();
      bottleAtLabeller.sethook();
      bottleAtLabeller.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottlePlaced.gethook();
        bottleAtPos1.gethook();
        infeedClear.gethook();
        bottleAtOutfeedEnd.gethook();
        outfeedClear.gethook();
        tableReady.gethook();
        bottleFromTable.gethook();
        bottleTaken.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
