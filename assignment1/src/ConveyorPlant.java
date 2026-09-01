import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class ConveyorPlant extends ClockDomain{
  public ConveyorPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal motInfeed = new Signal("motInfeed", Signal.INPUT);
  public Signal injectInfeed = new Signal("injectInfeed", Signal.INPUT);
  public Signal takeFromPos1 = new Signal("takeFromPos1", Signal.INPUT);
  public Signal motOutfeed = new Signal("motOutfeed", Signal.INPUT);
  public Signal injectOutfeed = new Signal("injectOutfeed", Signal.INPUT);
  public Signal collectFromEnd = new Signal("collectFromEnd", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.OUTPUT);
  public Signal infeedClear = new Signal("infeedClear", Signal.OUTPUT);
  public Signal bottleAtOutfeedEnd = new Signal("bottleAtOutfeedEnd", Signal.OUTPUT);
  public Signal outfeedClear = new Signal("outfeedClear", Signal.OUTPUT);
  private int LEN_thread_2;//sysj\conveyorPlant.sysj line: 28, column: 3
  private int pos_thread_2;//sysj\conveyorPlant.sysj line: 29, column: 3
  private int LEN_thread_3;//sysj\conveyorPlant.sysj line: 71, column: 3
  private int pos_thread_3;//sysj\conveyorPlant.sysj line: 72, column: 3
  private int S2001 = 1;
  private int S1745 = 1;
  private int S1999 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread2007(int [] tdone, int [] ends){
        switch(S1999){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\conveyorPlant.sysj line: 75, column: 12
          if(injectOutfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 77, column: 13
            if(pos_thread_3 < 0) {//sysj\conveyorPlant.sysj line: 78, column: 17
              pos_thread_3 = 0;//sysj\conveyorPlant.sysj line: 79, column: 7
              System.out.println("[CVPlant] Bottle entered outfeed.");//sysj\conveyorPlant.sysj line: 80, column: 7
            }
            if(pos_thread_3 >= 0){//sysj\conveyorPlant.sysj line: 84, column: 8
              if(pos_thread_3 < LEN_thread_3){//sysj\conveyorPlant.sysj line: 85, column: 9
                if(motOutfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 86, column: 15
                  pos_thread_3 = pos_thread_3 + 1;//sysj\conveyorPlant.sysj line: 87, column: 8
                  if(pos_thread_3 == LEN_thread_3) {//sysj\conveyorPlant.sysj line: 88, column: 22
                    System.out.println("[CVPlant] Bottle arrived at labeller point.");//sysj\conveyorPlant.sysj line: 89, column: 9
                  }
                  if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
                    if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
                      pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
                      System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
                    }
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                      currsigs.addElement(outfeedClear);
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
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                      currsigs.addElement(outfeedClear);
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
                  if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
                    if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
                      pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
                      System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
                    }
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                      currsigs.addElement(outfeedClear);
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
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                      currsigs.addElement(outfeedClear);
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
                bottleAtOutfeedEnd.setPresent();//sysj\conveyorPlant.sysj line: 94, column: 7
                currsigs.addElement(bottleAtOutfeedEnd);
                if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
                  if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
                    pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
                  }
                  if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                    outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                    currsigs.addElement(outfeedClear);
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
                  if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                    outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                    currsigs.addElement(outfeedClear);
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
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
                if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
                  pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
                  System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                  currsigs.addElement(outfeedClear);
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
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                  currsigs.addElement(outfeedClear);
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
            if(pos_thread_3 >= 0){//sysj\conveyorPlant.sysj line: 84, column: 8
              if(pos_thread_3 < LEN_thread_3){//sysj\conveyorPlant.sysj line: 85, column: 9
                if(motOutfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 86, column: 15
                  pos_thread_3 = pos_thread_3 + 1;//sysj\conveyorPlant.sysj line: 87, column: 8
                  if(pos_thread_3 == LEN_thread_3) {//sysj\conveyorPlant.sysj line: 88, column: 22
                    System.out.println("[CVPlant] Bottle arrived at labeller point.");//sysj\conveyorPlant.sysj line: 89, column: 9
                  }
                  if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
                    if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
                      pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
                      System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
                    }
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                      currsigs.addElement(outfeedClear);
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
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                      currsigs.addElement(outfeedClear);
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
                  if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
                    if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
                      pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
                      System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
                    }
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                      currsigs.addElement(outfeedClear);
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
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                      currsigs.addElement(outfeedClear);
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
                bottleAtOutfeedEnd.setPresent();//sysj\conveyorPlant.sysj line: 94, column: 7
                currsigs.addElement(bottleAtOutfeedEnd);
                if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
                  if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
                    pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
                  }
                  if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                    outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                    currsigs.addElement(outfeedClear);
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
                  if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                    outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                    currsigs.addElement(outfeedClear);
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
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
                if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
                  pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
                  System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                  currsigs.addElement(outfeedClear);
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
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                  currsigs.addElement(outfeedClear);
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
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread2006(int [] tdone, int [] ends){
        switch(S1745){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\conveyorPlant.sysj line: 32, column: 12
          if(injectInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 34, column: 13
            if(pos_thread_2 < 0) {//sysj\conveyorPlant.sysj line: 35, column: 17
              pos_thread_2 = 0;//sysj\conveyorPlant.sysj line: 36, column: 7
              System.out.println("[CVPlant] Bottle entered infeed.");//sysj\conveyorPlant.sysj line: 37, column: 7
            }
            if(pos_thread_2 >= 0){//sysj\conveyorPlant.sysj line: 41, column: 8
              if(pos_thread_2 < LEN_thread_2){//sysj\conveyorPlant.sysj line: 42, column: 9
                if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 43, column: 15
                  pos_thread_2 = pos_thread_2 + 1;//sysj\conveyorPlant.sysj line: 44, column: 8
                  if(pos_thread_2 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 45, column: 22
                    System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 46, column: 9
                  }
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
                    if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
                      pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
                      System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
                    }
                    if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                      currsigs.addElement(infeedClear);
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
                    if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                      currsigs.addElement(infeedClear);
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
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
                    if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
                      pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
                      System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
                    }
                    if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                      currsigs.addElement(infeedClear);
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
                    if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                      currsigs.addElement(infeedClear);
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
              }
              else {
                bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 51, column: 7
                currsigs.addElement(bottleAtPos1);
                if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
                  if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
                    pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
                  }
                  if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                    infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                    currsigs.addElement(infeedClear);
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
                  if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                    infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                    currsigs.addElement(infeedClear);
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
            }
            else {
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
                if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
                  pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
                  System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
                }
                if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                  currsigs.addElement(infeedClear);
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
                if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                  currsigs.addElement(infeedClear);
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
          }
          else {
            if(pos_thread_2 >= 0){//sysj\conveyorPlant.sysj line: 41, column: 8
              if(pos_thread_2 < LEN_thread_2){//sysj\conveyorPlant.sysj line: 42, column: 9
                if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 43, column: 15
                  pos_thread_2 = pos_thread_2 + 1;//sysj\conveyorPlant.sysj line: 44, column: 8
                  if(pos_thread_2 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 45, column: 22
                    System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 46, column: 9
                  }
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
                    if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
                      pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
                      System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
                    }
                    if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                      currsigs.addElement(infeedClear);
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
                    if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                      currsigs.addElement(infeedClear);
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
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
                    if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
                      pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
                      System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
                    }
                    if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                      currsigs.addElement(infeedClear);
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
                    if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                      currsigs.addElement(infeedClear);
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
              }
              else {
                bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 51, column: 7
                currsigs.addElement(bottleAtPos1);
                if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
                  if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
                    pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
                  }
                  if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                    infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                    currsigs.addElement(infeedClear);
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
                  if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                    infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                    currsigs.addElement(infeedClear);
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
            }
            else {
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
                if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
                  pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
                  System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
                }
                if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                  currsigs.addElement(infeedClear);
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
                if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                  currsigs.addElement(infeedClear);
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

  public void thread2004(int [] tdone, int [] ends){
        S1999=1;
    LEN_thread_3 = 6;//sysj\conveyorPlant.sysj line: 71, column: 3
    pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 72, column: 3
    if(enable.getprestatus()){//sysj\conveyorPlant.sysj line: 75, column: 12
      if(injectOutfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 77, column: 13
        if(pos_thread_3 < 0) {//sysj\conveyorPlant.sysj line: 78, column: 17
          pos_thread_3 = 0;//sysj\conveyorPlant.sysj line: 79, column: 7
          System.out.println("[CVPlant] Bottle entered outfeed.");//sysj\conveyorPlant.sysj line: 80, column: 7
        }
        if(pos_thread_3 >= 0){//sysj\conveyorPlant.sysj line: 84, column: 8
          if(pos_thread_3 < LEN_thread_3){//sysj\conveyorPlant.sysj line: 85, column: 9
            if(motOutfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 86, column: 15
              pos_thread_3 = pos_thread_3 + 1;//sysj\conveyorPlant.sysj line: 87, column: 8
              if(pos_thread_3 == LEN_thread_3) {//sysj\conveyorPlant.sysj line: 88, column: 22
                System.out.println("[CVPlant] Bottle arrived at labeller point.");//sysj\conveyorPlant.sysj line: 89, column: 9
              }
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
                if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
                  pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
                  System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                  currsigs.addElement(outfeedClear);
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
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                  currsigs.addElement(outfeedClear);
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
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
                if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
                  pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
                  System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                  currsigs.addElement(outfeedClear);
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
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                  currsigs.addElement(outfeedClear);
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
            bottleAtOutfeedEnd.setPresent();//sysj\conveyorPlant.sysj line: 94, column: 7
            currsigs.addElement(bottleAtOutfeedEnd);
            if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
              if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
                pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
                System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
              }
              if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                currsigs.addElement(outfeedClear);
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
              if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                currsigs.addElement(outfeedClear);
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
          if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
            if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
              pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
              System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
            }
            if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
              outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
              currsigs.addElement(outfeedClear);
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
            if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
              outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
              currsigs.addElement(outfeedClear);
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
        if(pos_thread_3 >= 0){//sysj\conveyorPlant.sysj line: 84, column: 8
          if(pos_thread_3 < LEN_thread_3){//sysj\conveyorPlant.sysj line: 85, column: 9
            if(motOutfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 86, column: 15
              pos_thread_3 = pos_thread_3 + 1;//sysj\conveyorPlant.sysj line: 87, column: 8
              if(pos_thread_3 == LEN_thread_3) {//sysj\conveyorPlant.sysj line: 88, column: 22
                System.out.println("[CVPlant] Bottle arrived at labeller point.");//sysj\conveyorPlant.sysj line: 89, column: 9
              }
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
                if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
                  pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
                  System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                  currsigs.addElement(outfeedClear);
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
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                  currsigs.addElement(outfeedClear);
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
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
                if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
                  pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
                  System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                  currsigs.addElement(outfeedClear);
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
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                  currsigs.addElement(outfeedClear);
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
            bottleAtOutfeedEnd.setPresent();//sysj\conveyorPlant.sysj line: 94, column: 7
            currsigs.addElement(bottleAtOutfeedEnd);
            if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
              if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
                pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
                System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
              }
              if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                currsigs.addElement(outfeedClear);
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
              if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
                outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
                currsigs.addElement(outfeedClear);
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
          if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 98, column: 13
            if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 99, column: 20
              pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 100, column: 7
              System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 101, column: 7
            }
            if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
              outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
              currsigs.addElement(outfeedClear);
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
            if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 105, column: 8
              outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 106, column: 6
              currsigs.addElement(outfeedClear);
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
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread2003(int [] tdone, int [] ends){
        S1745=1;
    LEN_thread_2 = 6;//sysj\conveyorPlant.sysj line: 28, column: 3
    pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 29, column: 3
    if(enable.getprestatus()){//sysj\conveyorPlant.sysj line: 32, column: 12
      if(injectInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 34, column: 13
        if(pos_thread_2 < 0) {//sysj\conveyorPlant.sysj line: 35, column: 17
          pos_thread_2 = 0;//sysj\conveyorPlant.sysj line: 36, column: 7
          System.out.println("[CVPlant] Bottle entered infeed.");//sysj\conveyorPlant.sysj line: 37, column: 7
        }
        if(pos_thread_2 >= 0){//sysj\conveyorPlant.sysj line: 41, column: 8
          if(pos_thread_2 < LEN_thread_2){//sysj\conveyorPlant.sysj line: 42, column: 9
            if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 43, column: 15
              pos_thread_2 = pos_thread_2 + 1;//sysj\conveyorPlant.sysj line: 44, column: 8
              if(pos_thread_2 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 45, column: 22
                System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 46, column: 9
              }
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
                if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
                  pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
                  System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
                }
                if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                  currsigs.addElement(infeedClear);
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
                if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                  currsigs.addElement(infeedClear);
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
                if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
                  pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
                  System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
                }
                if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                  currsigs.addElement(infeedClear);
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
                if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                  currsigs.addElement(infeedClear);
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
          }
          else {
            bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 51, column: 7
            currsigs.addElement(bottleAtPos1);
            if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
              if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
                pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
                System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
              }
              if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                currsigs.addElement(infeedClear);
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
              if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                currsigs.addElement(infeedClear);
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
        }
        else {
          if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
            if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
              pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
              System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
            }
            if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
              infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
              currsigs.addElement(infeedClear);
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
            if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
              infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
              currsigs.addElement(infeedClear);
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
      }
      else {
        if(pos_thread_2 >= 0){//sysj\conveyorPlant.sysj line: 41, column: 8
          if(pos_thread_2 < LEN_thread_2){//sysj\conveyorPlant.sysj line: 42, column: 9
            if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 43, column: 15
              pos_thread_2 = pos_thread_2 + 1;//sysj\conveyorPlant.sysj line: 44, column: 8
              if(pos_thread_2 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 45, column: 22
                System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 46, column: 9
              }
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
                if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
                  pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
                  System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
                }
                if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                  currsigs.addElement(infeedClear);
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
                if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                  currsigs.addElement(infeedClear);
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
                if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
                  pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
                  System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
                }
                if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                  currsigs.addElement(infeedClear);
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
                if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                  currsigs.addElement(infeedClear);
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
          }
          else {
            bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 51, column: 7
            currsigs.addElement(bottleAtPos1);
            if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
              if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
                pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
                System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
              }
              if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                currsigs.addElement(infeedClear);
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
              if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
                infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
                currsigs.addElement(infeedClear);
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
        }
        else {
          if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 55, column: 13
            if(pos_thread_2 >= LEN_thread_2) {//sysj\conveyorPlant.sysj line: 56, column: 20
              pos_thread_2 = -1;//sysj\conveyorPlant.sysj line: 57, column: 7
              System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 58, column: 7
            }
            if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
              infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
              currsigs.addElement(infeedClear);
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
            if(pos_thread_2 < 0){//sysj\conveyorPlant.sysj line: 62, column: 8
              infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 63, column: 6
              currsigs.addElement(infeedClear);
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
      switch(S2001){
        case 0 : 
          S2001=0;
          break RUN;
        
        case 1 : 
          S2001=2;
          S2001=2;
          thread2003(tdone,ends);
          thread2004(tdone,ends);
          int biggest2005 = 0;
          if(ends[2]>=biggest2005){
            biggest2005=ends[2];
          }
          if(ends[3]>=biggest2005){
            biggest2005=ends[3];
          }
          if(biggest2005 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread2006(tdone,ends);
          thread2007(tdone,ends);
          int biggest2008 = 0;
          if(ends[2]>=biggest2008){
            biggest2008=ends[2];
          }
          if(ends[3]>=biggest2008){
            biggest2008=ends[3];
          }
          if(biggest2008 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2008 == 0){
            S2001=0;
            active[1]=0;
            ends[1]=0;
            S2001=0;
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
          motInfeed.gethook();
          injectInfeed.gethook();
          takeFromPos1.gethook();
          motOutfeed.gethook();
          injectOutfeed.gethook();
          collectFromEnd.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      motInfeed.setpreclear();
      injectInfeed.setpreclear();
      takeFromPos1.setpreclear();
      motOutfeed.setpreclear();
      injectOutfeed.setpreclear();
      collectFromEnd.setpreclear();
      bottleAtPos1.setpreclear();
      infeedClear.setpreclear();
      bottleAtOutfeedEnd.setpreclear();
      outfeedClear.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = motInfeed.getStatus() ? motInfeed.setprepresent() : motInfeed.setpreclear();
      motInfeed.setpreval(motInfeed.getValue());
      motInfeed.setClear();
      dummyint = injectInfeed.getStatus() ? injectInfeed.setprepresent() : injectInfeed.setpreclear();
      injectInfeed.setpreval(injectInfeed.getValue());
      injectInfeed.setClear();
      dummyint = takeFromPos1.getStatus() ? takeFromPos1.setprepresent() : takeFromPos1.setpreclear();
      takeFromPos1.setpreval(takeFromPos1.getValue());
      takeFromPos1.setClear();
      dummyint = motOutfeed.getStatus() ? motOutfeed.setprepresent() : motOutfeed.setpreclear();
      motOutfeed.setpreval(motOutfeed.getValue());
      motOutfeed.setClear();
      dummyint = injectOutfeed.getStatus() ? injectOutfeed.setprepresent() : injectOutfeed.setpreclear();
      injectOutfeed.setpreval(injectOutfeed.getValue());
      injectOutfeed.setClear();
      dummyint = collectFromEnd.getStatus() ? collectFromEnd.setprepresent() : collectFromEnd.setpreclear();
      collectFromEnd.setpreval(collectFromEnd.getValue());
      collectFromEnd.setClear();
      bottleAtPos1.sethook();
      bottleAtPos1.setClear();
      infeedClear.sethook();
      infeedClear.setClear();
      bottleAtOutfeedEnd.sethook();
      bottleAtOutfeedEnd.setClear();
      outfeedClear.sethook();
      outfeedClear.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        motInfeed.gethook();
        injectInfeed.gethook();
        takeFromPos1.gethook();
        motOutfeed.gethook();
        injectOutfeed.gethook();
        collectFromEnd.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
