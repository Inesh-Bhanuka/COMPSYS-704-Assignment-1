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
  public Signal conveyorReady = new Signal("conveyorReady", Signal.OUTPUT);
  public Signal motInfeed = new Signal("motInfeed", Signal.OUTPUT);
  public Signal injectInfeed = new Signal("injectInfeed", Signal.OUTPUT);
  public Signal takeFromPos1 = new Signal("takeFromPos1", Signal.OUTPUT);
  public Signal motOutfeed = new Signal("motOutfeed", Signal.OUTPUT);
  public Signal injectOutfeed = new Signal("injectOutfeed", Signal.OUTPUT);
  public Signal collectFromEnd = new Signal("collectFromEnd", Signal.OUTPUT);
  public Signal bottleToTable = new Signal("bottleToTable", Signal.OUTPUT);
  public Signal bottleAtLabeller = new Signal("bottleAtLabeller", Signal.OUTPUT);
  private int S1482 = 1;
  private int S1348 = 1;
  private int S1430 = 1;
  private int S1350 = 1;
  private int S1480 = 1;
  private int S1432 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread1490(int [] tdone, int [] ends){
        switch(S1480){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S1432){
          case 0 : 
            if(bottleFromTable.getprestatus()){//sysj\conveyorController.sysj line: 80, column: 20
              System.out.println("[CV] Bottle received from turntable.");//sysj\conveyorController.sysj line: 81, column: 4
              injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 83, column: 4
              currsigs.addElement(injectOutfeed);
              S1432=1;
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
          
          case 1 : 
            S1432=1;
            injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 84, column: 4
            currsigs.addElement(injectOutfeed);
            S1432=2;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 2 : 
            S1432=2;
            injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 85, column: 4
            currsigs.addElement(injectOutfeed);
            S1432=3;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 3 : 
            S1432=3;
            S1432=4;
            motOutfeed.setPresent();//sysj\conveyorController.sysj line: 88, column: 5
            currsigs.addElement(motOutfeed);
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 4 : 
            if(bottleAtOutfeedEnd.getprestatus()){//sysj\conveyorController.sysj line: 87, column: 10
              System.out.println("[CV] Bottle delivered to labeller point.");//sysj\conveyorController.sysj line: 91, column: 4
              bottleAtLabeller.setPresent();//sysj\conveyorController.sysj line: 94, column: 4
              currsigs.addElement(bottleAtLabeller);
              collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 94, column: 27
              currsigs.addElement(collectFromEnd);
              S1432=5;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              motOutfeed.setPresent();//sysj\conveyorController.sysj line: 88, column: 5
              currsigs.addElement(motOutfeed);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 5 : 
            S1432=5;
            bottleAtLabeller.setPresent();//sysj\conveyorController.sysj line: 95, column: 4
            currsigs.addElement(bottleAtLabeller);
            collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 95, column: 27
            currsigs.addElement(collectFromEnd);
            S1432=6;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 6 : 
            S1432=6;
            bottleAtLabeller.setPresent();//sysj\conveyorController.sysj line: 96, column: 4
            currsigs.addElement(bottleAtLabeller);
            collectFromEnd.setPresent();//sysj\conveyorController.sysj line: 96, column: 27
            currsigs.addElement(collectFromEnd);
            S1432=7;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
          case 7 : 
            S1432=7;
            S1432=8;
            if(!bottleFromTable.getprestatus()){//sysj\conveyorController.sysj line: 98, column: 20
              S1432=0;
              if(bottleFromTable.getprestatus()){//sysj\conveyorController.sysj line: 80, column: 20
                System.out.println("[CV] Bottle received from turntable.");//sysj\conveyorController.sysj line: 81, column: 4
                injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 83, column: 4
                currsigs.addElement(injectOutfeed);
                S1432=1;
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
          
          case 8 : 
            if(!bottleFromTable.getprestatus()){//sysj\conveyorController.sysj line: 98, column: 20
              S1432=0;
              if(bottleFromTable.getprestatus()){//sysj\conveyorController.sysj line: 80, column: 20
                System.out.println("[CV] Bottle received from turntable.");//sysj\conveyorController.sysj line: 81, column: 4
                injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 83, column: 4
                currsigs.addElement(injectOutfeed);
                S1432=1;
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
          
        }
        break;
      
    }
  }

  public void thread1489(int [] tdone, int [] ends){
        switch(S1430){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1350){
          case 0 : 
            if(bottlePlaced.getprestatus()){//sysj\conveyorController.sysj line: 48, column: 20
              System.out.println("[CV] Bottle received from loader.");//sysj\conveyorController.sysj line: 49, column: 4
              injectInfeed.setPresent();//sysj\conveyorController.sysj line: 51, column: 4
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
            injectInfeed.setPresent();//sysj\conveyorController.sysj line: 52, column: 4
            currsigs.addElement(injectInfeed);
            S1350=2;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 2 : 
            S1350=2;
            injectInfeed.setPresent();//sysj\conveyorController.sysj line: 53, column: 4
            currsigs.addElement(injectInfeed);
            S1350=3;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 3 : 
            S1350=3;
            S1350=4;
            motInfeed.setPresent();//sysj\conveyorController.sysj line: 56, column: 5
            currsigs.addElement(motInfeed);
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 4 : 
            if(bottleAtPos1.getprestatus()){//sysj\conveyorController.sysj line: 55, column: 10
              S1350=5;
              if(tableReady.getprestatus()){//sysj\conveyorController.sysj line: 59, column: 12
                bottleToTable.setPresent();//sysj\conveyorController.sysj line: 67, column: 4
                currsigs.addElement(bottleToTable);
                takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 67, column: 24
                currsigs.addElement(takeFromPos1);
                S1350=6;
                active[3]=1;
                ends[3]=1;
                tdone[3]=1;
              }
              else {
                System.out.println("[CV] At position 1 - waiting for turntable.");//sysj\conveyorController.sysj line: 63, column: 5
                if(tableReady.getprestatus()){//sysj\conveyorController.sysj line: 64, column: 21
                  bottleToTable.setPresent();//sysj\conveyorController.sysj line: 67, column: 4
                  currsigs.addElement(bottleToTable);
                  takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 67, column: 24
                  currsigs.addElement(takeFromPos1);
                  S1350=6;
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
            }
            else {
              motInfeed.setPresent();//sysj\conveyorController.sysj line: 56, column: 5
              currsigs.addElement(motInfeed);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 5 : 
            if(tableReady.getprestatus()){//sysj\conveyorController.sysj line: 64, column: 21
              bottleToTable.setPresent();//sysj\conveyorController.sysj line: 67, column: 4
              currsigs.addElement(bottleToTable);
              takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 67, column: 24
              currsigs.addElement(takeFromPos1);
              S1350=6;
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
          
          case 6 : 
            S1350=6;
            bottleToTable.setPresent();//sysj\conveyorController.sysj line: 68, column: 4
            currsigs.addElement(bottleToTable);
            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 68, column: 24
            currsigs.addElement(takeFromPos1);
            S1350=7;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 7 : 
            S1350=7;
            bottleToTable.setPresent();//sysj\conveyorController.sysj line: 69, column: 4
            currsigs.addElement(bottleToTable);
            takeFromPos1.setPresent();//sysj\conveyorController.sysj line: 69, column: 24
            currsigs.addElement(takeFromPos1);
            S1350=8;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
          case 8 : 
            S1350=8;
            System.out.println("[CV] Handed off to turntable.");//sysj\conveyorController.sysj line: 70, column: 4
            S1350=9;
            if(!bottlePlaced.getprestatus()){//sysj\conveyorController.sysj line: 74, column: 20
              S1350=0;
              if(bottlePlaced.getprestatus()){//sysj\conveyorController.sysj line: 48, column: 20
                System.out.println("[CV] Bottle received from loader.");//sysj\conveyorController.sysj line: 49, column: 4
                injectInfeed.setPresent();//sysj\conveyorController.sysj line: 51, column: 4
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
          
          case 9 : 
            if(!bottlePlaced.getprestatus()){//sysj\conveyorController.sysj line: 74, column: 20
              S1350=0;
              if(bottlePlaced.getprestatus()){//sysj\conveyorController.sysj line: 48, column: 20
                System.out.println("[CV] Bottle received from loader.");//sysj\conveyorController.sysj line: 49, column: 4
                injectInfeed.setPresent();//sysj\conveyorController.sysj line: 51, column: 4
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

  public void thread1488(int [] tdone, int [] ends){
        switch(S1348){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 39, column: 12
          conveyorReady.setPresent();//sysj\conveyorController.sysj line: 40, column: 5
          currsigs.addElement(conveyorReady);
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

  public void thread1486(int [] tdone, int [] ends){
        S1480=1;
    S1432=0;
    if(bottleFromTable.getprestatus()){//sysj\conveyorController.sysj line: 80, column: 20
      System.out.println("[CV] Bottle received from turntable.");//sysj\conveyorController.sysj line: 81, column: 4
      injectOutfeed.setPresent();//sysj\conveyorController.sysj line: 83, column: 4
      currsigs.addElement(injectOutfeed);
      S1432=1;
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

  public void thread1485(int [] tdone, int [] ends){
        S1430=1;
    S1350=0;
    if(bottlePlaced.getprestatus()){//sysj\conveyorController.sysj line: 48, column: 20
      System.out.println("[CV] Bottle received from loader.");//sysj\conveyorController.sysj line: 49, column: 4
      injectInfeed.setPresent();//sysj\conveyorController.sysj line: 51, column: 4
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

  public void thread1484(int [] tdone, int [] ends){
        S1348=1;
    if(infeedClear.getprestatus()){//sysj\conveyorController.sysj line: 39, column: 12
      conveyorReady.setPresent();//sysj\conveyorController.sysj line: 40, column: 5
      currsigs.addElement(conveyorReady);
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

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S1482){
        case 0 : 
          S1482=0;
          break RUN;
        
        case 1 : 
          S1482=2;
          S1482=2;
          thread1484(tdone,ends);
          thread1485(tdone,ends);
          thread1486(tdone,ends);
          int biggest1487 = 0;
          if(ends[2]>=biggest1487){
            biggest1487=ends[2];
          }
          if(ends[3]>=biggest1487){
            biggest1487=ends[3];
          }
          if(ends[4]>=biggest1487){
            biggest1487=ends[4];
          }
          if(biggest1487 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread1488(tdone,ends);
          thread1489(tdone,ends);
          thread1490(tdone,ends);
          int biggest1491 = 0;
          if(ends[2]>=biggest1491){
            biggest1491=ends[2];
          }
          if(ends[3]>=biggest1491){
            biggest1491=ends[3];
          }
          if(ends[4]>=biggest1491){
            biggest1491=ends[4];
          }
          if(biggest1491 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1491 == 0){
            S1482=0;
            active[1]=0;
            ends[1]=0;
            S1482=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0};
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
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
