import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class LidLoaderPlant extends ClockDomain{
  public LidLoaderPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.INPUT);
  public Signal vacOn = new Signal("vacOn", Signal.INPUT);
  public Signal armSource = new Signal("armSource", Signal.INPUT);
  public Signal armDest = new Signal("armDest", Signal.INPUT);
  public Signal refill = new Signal("refill", Signal.INPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.OUTPUT);
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.OUTPUT);
  public Signal lidAtPickup = new Signal("lidAtPickup", Signal.OUTPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.OUTPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.OUTPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.OUTPUT);
  public Signal magazineEmpty = new Signal("magazineEmpty", Signal.OUTPUT);
  public Signal refilled = new Signal("refilled", Signal.OUTPUT);
  private int STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 26, column: 3
  private int lids_thread_3;//sysj\lidLoaderPlant.sysj line: 27, column: 3
  private boolean extended_thread_3;//sysj\lidLoaderPlant.sysj line: 28, column: 3
  private boolean lidReady_thread_3;//sysj\lidLoaderPlant.sysj line: 29, column: 3
  private boolean holding_thread_3;//sysj\lidLoaderPlant.sysj line: 30, column: 3
  private int S103538 = 1;
  private int S102676 = 1;
  private int S102648 = 1;
  private int S103536 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread103544(int [] tdone, int [] ends){
        switch(S103536){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\lidLoaderPlant.sysj line: 33, column: 12
          if(pusherExtend.getprestatus()){//sysj\lidLoaderPlant.sysj line: 36, column: 13
            if(!extended_thread_3) {//sysj\lidLoaderPlant.sysj line: 37, column: 19
              extended_thread_3 = true;//sysj\lidLoaderPlant.sysj line: 38, column: 7
              if(lids_thread_3 > 0 && !lidReady_thread_3) {//sysj\lidLoaderPlant.sysj line: 39, column: 32
                lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderPlant.sysj line: 40, column: 8
                lidReady_thread_3 = true;//sysj\lidLoaderPlant.sysj line: 41, column: 8
                System.out.println("[LIDPlant] Lid pushed out, " + lids_thread_3 + " left.");//sysj\lidLoaderPlant.sysj line: 42, column: 8
              }
            }
            pusherExtended.setPresent();//sysj\lidLoaderPlant.sysj line: 45, column: 6
            currsigs.addElement(pusherExtended);
            if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 53, column: 5
              if(vacOn.getprestatus()){//sysj\lidLoaderPlant.sysj line: 54, column: 14
                if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
                  lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
                  currsigs.addElement(lidAtPickup);
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
                else {
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
              }
              else {
                holding_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 58, column: 7
                System.out.println("[LIDPlant] Lid released.");//sysj\lidLoaderPlant.sysj line: 59, column: 7
                if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
                  lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
                  currsigs.addElement(lidAtPickup);
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
                else {
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
              }
            }
            else {
              if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lidLoaderPlant.sysj line: 63, column: 14
                if(lidReady_thread_3) {//sysj\lidLoaderPlant.sysj line: 64, column: 19
                  lidReady_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 65, column: 8
                  holding_thread_3 = true;//sysj\lidLoaderPlant.sysj line: 66, column: 8
                }
                if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
                  lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
                  currsigs.addElement(lidAtPickup);
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
                else {
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
              }
              else {
                if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
                  lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
                  currsigs.addElement(lidAtPickup);
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
                else {
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
              }
            }
          }
          else {
            extended_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 48, column: 6
            pusherRetracted.setPresent();//sysj\lidLoaderPlant.sysj line: 49, column: 6
            currsigs.addElement(pusherRetracted);
            if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 53, column: 5
              if(vacOn.getprestatus()){//sysj\lidLoaderPlant.sysj line: 54, column: 14
                if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
                  lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
                  currsigs.addElement(lidAtPickup);
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
                else {
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
              }
              else {
                holding_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 58, column: 7
                System.out.println("[LIDPlant] Lid released.");//sysj\lidLoaderPlant.sysj line: 59, column: 7
                if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
                  lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
                  currsigs.addElement(lidAtPickup);
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
                else {
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
              }
            }
            else {
              if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lidLoaderPlant.sysj line: 63, column: 14
                if(lidReady_thread_3) {//sysj\lidLoaderPlant.sysj line: 64, column: 19
                  lidReady_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 65, column: 8
                  holding_thread_3 = true;//sysj\lidLoaderPlant.sysj line: 66, column: 8
                }
                if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
                  lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
                  currsigs.addElement(lidAtPickup);
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
                else {
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
              }
              else {
                if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
                  lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
                  currsigs.addElement(lidAtPickup);
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
                else {
                  if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                    WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                    currsigs.addElement(WPgripped);
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                    if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                      lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                      refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                      currsigs.addElement(refilled);
                      active[3]=1;
                      ends[3]=1;
                      tdone[3]=1;
                    }
                    else {
                      if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                        magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                        currsigs.addElement(magazineEmpty);
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
                }
              }
            }
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

  public void thread103543(int [] tdone, int [] ends){
        switch(S102676){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S102648){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\lidLoaderPlant.sysj line: 16, column: 10
              S102648=1;
              armAtSource.setPresent();//sysj\lidLoaderPlant.sysj line: 20, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\lidLoaderPlant.sysj line: 17, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\lidLoaderPlant.sysj line: 19, column: 10
              S102648=0;
              armAtDest.setPresent();//sysj\lidLoaderPlant.sysj line: 17, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\lidLoaderPlant.sysj line: 20, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread103541(int [] tdone, int [] ends){
        S103536=1;
    STOCK_thread_3 = 3;//sysj\lidLoaderPlant.sysj line: 26, column: 3
    lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 27, column: 3
    extended_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 28, column: 3
    lidReady_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 29, column: 3
    holding_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 30, column: 3
    if(enable.getprestatus()){//sysj\lidLoaderPlant.sysj line: 33, column: 12
      if(pusherExtend.getprestatus()){//sysj\lidLoaderPlant.sysj line: 36, column: 13
        if(!extended_thread_3) {//sysj\lidLoaderPlant.sysj line: 37, column: 19
          extended_thread_3 = true;//sysj\lidLoaderPlant.sysj line: 38, column: 7
          if(lids_thread_3 > 0 && !lidReady_thread_3) {//sysj\lidLoaderPlant.sysj line: 39, column: 32
            lids_thread_3 = lids_thread_3 - 1;//sysj\lidLoaderPlant.sysj line: 40, column: 8
            lidReady_thread_3 = true;//sysj\lidLoaderPlant.sysj line: 41, column: 8
            System.out.println("[LIDPlant] Lid pushed out, " + lids_thread_3 + " left.");//sysj\lidLoaderPlant.sysj line: 42, column: 8
          }
        }
        pusherExtended.setPresent();//sysj\lidLoaderPlant.sysj line: 45, column: 6
        currsigs.addElement(pusherExtended);
        if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 53, column: 5
          if(vacOn.getprestatus()){//sysj\lidLoaderPlant.sysj line: 54, column: 14
            if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
              lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
              currsigs.addElement(lidAtPickup);
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
            else {
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
          }
          else {
            holding_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 58, column: 7
            System.out.println("[LIDPlant] Lid released.");//sysj\lidLoaderPlant.sysj line: 59, column: 7
            if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
              lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
              currsigs.addElement(lidAtPickup);
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
            else {
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
          }
        }
        else {
          if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lidLoaderPlant.sysj line: 63, column: 14
            if(lidReady_thread_3) {//sysj\lidLoaderPlant.sysj line: 64, column: 19
              lidReady_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 65, column: 8
              holding_thread_3 = true;//sysj\lidLoaderPlant.sysj line: 66, column: 8
            }
            if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
              lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
              currsigs.addElement(lidAtPickup);
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
            else {
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
          }
          else {
            if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
              lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
              currsigs.addElement(lidAtPickup);
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
            else {
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
          }
        }
      }
      else {
        extended_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 48, column: 6
        pusherRetracted.setPresent();//sysj\lidLoaderPlant.sysj line: 49, column: 6
        currsigs.addElement(pusherRetracted);
        if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 53, column: 5
          if(vacOn.getprestatus()){//sysj\lidLoaderPlant.sysj line: 54, column: 14
            if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
              lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
              currsigs.addElement(lidAtPickup);
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
            else {
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
          }
          else {
            holding_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 58, column: 7
            System.out.println("[LIDPlant] Lid released.");//sysj\lidLoaderPlant.sysj line: 59, column: 7
            if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
              lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
              currsigs.addElement(lidAtPickup);
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
            else {
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
          }
        }
        else {
          if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lidLoaderPlant.sysj line: 63, column: 14
            if(lidReady_thread_3) {//sysj\lidLoaderPlant.sysj line: 64, column: 19
              lidReady_thread_3 = false;//sysj\lidLoaderPlant.sysj line: 65, column: 8
              holding_thread_3 = true;//sysj\lidLoaderPlant.sysj line: 66, column: 8
            }
            if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
              lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
              currsigs.addElement(lidAtPickup);
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
            else {
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
          }
          else {
            if(lidReady_thread_3){//sysj\lidLoaderPlant.sysj line: 71, column: 5
              lidAtPickup.setPresent();//sysj\lidLoaderPlant.sysj line: 71, column: 19
              currsigs.addElement(lidAtPickup);
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
            else {
              if(holding_thread_3){//sysj\lidLoaderPlant.sysj line: 72, column: 5
                WPgripped.setPresent();//sysj\lidLoaderPlant.sysj line: 72, column: 18
                currsigs.addElement(WPgripped);
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
                if(refill.getprestatus()){//sysj\lidLoaderPlant.sysj line: 74, column: 13
                  lids_thread_3 = STOCK_thread_3;//sysj\lidLoaderPlant.sysj line: 75, column: 6
                  refilled.setPresent();//sysj\lidLoaderPlant.sysj line: 76, column: 6
                  currsigs.addElement(refilled);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  if(lids_thread_3 == 0 && !lidReady_thread_3 && !holding_thread_3){//sysj\lidLoaderPlant.sysj line: 78, column: 13
                    magazineEmpty.setPresent();//sysj\lidLoaderPlant.sysj line: 79, column: 6
                    currsigs.addElement(magazineEmpty);
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
            }
          }
        }
      }
    }
    else {
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread103540(int [] tdone, int [] ends){
        S102676=1;
    S102648=0;
    armAtDest.setPresent();//sysj\lidLoaderPlant.sysj line: 17, column: 5
    currsigs.addElement(armAtDest);
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S103538){
        case 0 : 
          S103538=0;
          break RUN;
        
        case 1 : 
          S103538=2;
          S103538=2;
          thread103540(tdone,ends);
          thread103541(tdone,ends);
          int biggest103542 = 0;
          if(ends[2]>=biggest103542){
            biggest103542=ends[2];
          }
          if(ends[3]>=biggest103542){
            biggest103542=ends[3];
          }
          if(biggest103542 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread103543(tdone,ends);
          thread103544(tdone,ends);
          int biggest103545 = 0;
          if(ends[2]>=biggest103545){
            biggest103545=ends[2];
          }
          if(ends[3]>=biggest103545){
            biggest103545=ends[3];
          }
          if(biggest103545 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest103545 == 0){
            S103538=0;
            active[1]=0;
            ends[1]=0;
            S103538=0;
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
          enable.gethook();
          pusherExtend.gethook();
          vacOn.gethook();
          armSource.gethook();
          armDest.gethook();
          refill.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      refill.setpreclear();
      pusherExtended.setpreclear();
      pusherRetracted.setpreclear();
      lidAtPickup.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      magazineEmpty.setpreclear();
      refilled.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = pusherExtend.getStatus() ? pusherExtend.setprepresent() : pusherExtend.setpreclear();
      pusherExtend.setpreval(pusherExtend.getValue());
      pusherExtend.setClear();
      dummyint = vacOn.getStatus() ? vacOn.setprepresent() : vacOn.setpreclear();
      vacOn.setpreval(vacOn.getValue());
      vacOn.setClear();
      dummyint = armSource.getStatus() ? armSource.setprepresent() : armSource.setpreclear();
      armSource.setpreval(armSource.getValue());
      armSource.setClear();
      dummyint = armDest.getStatus() ? armDest.setprepresent() : armDest.setpreclear();
      armDest.setpreval(armDest.getValue());
      armDest.setClear();
      dummyint = refill.getStatus() ? refill.setprepresent() : refill.setpreclear();
      refill.setpreval(refill.getValue());
      refill.setClear();
      pusherExtended.sethook();
      pusherExtended.setClear();
      pusherRetracted.sethook();
      pusherRetracted.setClear();
      lidAtPickup.sethook();
      lidAtPickup.setClear();
      WPgripped.sethook();
      WPgripped.setClear();
      armAtSource.sethook();
      armAtSource.setClear();
      armAtDest.sethook();
      armAtDest.setClear();
      magazineEmpty.sethook();
      magazineEmpty.setClear();
      refilled.sethook();
      refilled.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        pusherExtend.gethook();
        vacOn.gethook();
        armSource.gethook();
        armDest.gethook();
        refill.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
