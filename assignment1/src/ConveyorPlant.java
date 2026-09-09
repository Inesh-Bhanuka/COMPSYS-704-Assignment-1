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
  public Signal infeedAdmitted = new Signal("infeedAdmitted", Signal.OUTPUT);
  public Signal bottleAtOutfeedEnd = new Signal("bottleAtOutfeedEnd", Signal.OUTPUT);
  public Signal outfeedClear = new Signal("outfeedClear", Signal.OUTPUT);
  private int LEN_thread_2;//sysj/conveyorPlant.sysj line: 32, column: 3
  private boolean[] slot_thread_2;//sysj/conveyorPlant.sysj line: 33, column: 3
  private boolean injecting_thread_2;//sysj/conveyorPlant.sysj line: 34, column: 3
  private boolean admitted_thread_2;//sysj/conveyorPlant.sysj line: 35, column: 3
  private boolean taking_thread_2;//sysj/conveyorPlant.sysj line: 36, column: 3
  private int LEN_thread_3;//sysj/conveyorPlant.sysj line: 118, column: 3
  private int pos_thread_3;//sysj/conveyorPlant.sysj line: 119, column: 3
  private boolean injecting_thread_3;//sysj/conveyorPlant.sysj line: 120, column: 3
  private boolean collecting_thread_3;//sysj/conveyorPlant.sysj line: 121, column: 3
  private int i_thread_2;//sysj/conveyorPlant.sysj line: 77, column: 7
  private int S27319 = 1;
  private int S27063 = 1;
  private int S27317 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread27325(int [] tdone, int [] ends){
        switch(S27317){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj/conveyorPlant.sysj line: 124, column: 12
          if(injectOutfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 126, column: 13
            if(!injecting_thread_3) {//sysj/conveyorPlant.sysj line: 127, column: 20
              injecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 128, column: 7
              if(pos_thread_3 < 0) {//sysj/conveyorPlant.sysj line: 129, column: 18
                pos_thread_3 = 0;//sysj/conveyorPlant.sysj line: 130, column: 8
                System.out.println("[CVPlant] Bottle entered outfeed.");//sysj/conveyorPlant.sysj line: 131, column: 8
              }
            }
            if(pos_thread_3 >= 0){//sysj/conveyorPlant.sysj line: 139, column: 8
              if(pos_thread_3 < LEN_thread_3){//sysj/conveyorPlant.sysj line: 140, column: 9
                if(motOutfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 141, column: 15
                  pos_thread_3 = pos_thread_3 + 1;//sysj/conveyorPlant.sysj line: 142, column: 8
                  if(pos_thread_3 == LEN_thread_3) {//sysj/conveyorPlant.sysj line: 143, column: 22
                    System.out.println("[CVPlant] Bottle arrived at labeller point.");//sysj/conveyorPlant.sysj line: 144, column: 9
                  }
                  if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
                    if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
                      collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
                      if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                        pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                        System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
                      }
                    }
                    if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                      outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                    collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
                    if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                      outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                  if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
                    if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
                      collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
                      if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                        pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                        System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
                      }
                    }
                    if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                      outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                    collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
                    if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                      outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                bottleAtOutfeedEnd.setPresent();//sysj/conveyorPlant.sysj line: 149, column: 7
                currsigs.addElement(bottleAtOutfeedEnd);
                if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
                  if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
                    collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
                    if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                      pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                      System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
                    }
                  }
                  if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                    outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                  collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
                  if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                    outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
              if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
                if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
                  collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
                  if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                    pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
                  }
                }
                if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                  outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
                if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                  outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
            injecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 136, column: 6
            if(pos_thread_3 >= 0){//sysj/conveyorPlant.sysj line: 139, column: 8
              if(pos_thread_3 < LEN_thread_3){//sysj/conveyorPlant.sysj line: 140, column: 9
                if(motOutfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 141, column: 15
                  pos_thread_3 = pos_thread_3 + 1;//sysj/conveyorPlant.sysj line: 142, column: 8
                  if(pos_thread_3 == LEN_thread_3) {//sysj/conveyorPlant.sysj line: 143, column: 22
                    System.out.println("[CVPlant] Bottle arrived at labeller point.");//sysj/conveyorPlant.sysj line: 144, column: 9
                  }
                  if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
                    if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
                      collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
                      if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                        pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                        System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
                      }
                    }
                    if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                      outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                    collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
                    if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                      outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                  if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
                    if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
                      collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
                      if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                        pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                        System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
                      }
                    }
                    if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                      outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                    collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
                    if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                      outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                bottleAtOutfeedEnd.setPresent();//sysj/conveyorPlant.sysj line: 149, column: 7
                currsigs.addElement(bottleAtOutfeedEnd);
                if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
                  if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
                    collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
                    if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                      pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                      System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
                    }
                  }
                  if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                    outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                  collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
                  if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                    outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
              if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
                if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
                  collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
                  if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                    pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
                  }
                }
                if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                  outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
                if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                  outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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

  public void thread27324(int [] tdone, int [] ends){
        switch(S27063){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj/conveyorPlant.sysj line: 39, column: 12
          if(injectInfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 45, column: 13
            if(!injecting_thread_2) {//sysj/conveyorPlant.sysj line: 46, column: 20
              injecting_thread_2 = true;//sysj/conveyorPlant.sysj line: 47, column: 7
              if(!slot_thread_2[0]) {//sysj/conveyorPlant.sysj line: 48, column: 19
                slot_thread_2[0] = true;//sysj/conveyorPlant.sysj line: 49, column: 8
                admitted_thread_2 = true;//sysj/conveyorPlant.sysj line: 50, column: 8
                System.out.println("[CVPlant] Bottle entered infeed.");//sysj/conveyorPlant.sysj line: 51, column: 8
              }
            }
            if(admitted_thread_2){//sysj/conveyorPlant.sysj line: 66, column: 5
              infeedAdmitted.setPresent();//sysj/conveyorPlant.sysj line: 67, column: 6
              currsigs.addElement(infeedAdmitted);
              if(motInfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 74, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 75, column: 17
                  i_thread_2 = LEN_thread_2 - 1;//sysj/conveyorPlant.sysj line: 77, column: 7
                  while(i_thread_2 >= 0) {//sysj/conveyorPlant.sysj line: 78, column: 20
                    if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj/conveyorPlant.sysj line: 79, column: 33
                      slot_thread_2[i_thread_2 + 1] = true;//sysj/conveyorPlant.sysj line: 80, column: 9
                      slot_thread_2[i_thread_2] = false;//sysj/conveyorPlant.sysj line: 81, column: 9
                      if(i_thread_2 + 1 == LEN_thread_2) {//sysj/conveyorPlant.sysj line: 82, column: 25
                        System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj/conveyorPlant.sysj line: 83, column: 10
                      }
                    }
                    i_thread_2 = i_thread_2 - 1;//sysj/conveyorPlant.sysj line: 86, column: 8
                  }
                }
                if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
                  bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
                  bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
              if(motInfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 74, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 75, column: 17
                  i_thread_2 = LEN_thread_2 - 1;//sysj/conveyorPlant.sysj line: 77, column: 7
                  while(i_thread_2 >= 0) {//sysj/conveyorPlant.sysj line: 78, column: 20
                    if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj/conveyorPlant.sysj line: 79, column: 33
                      slot_thread_2[i_thread_2 + 1] = true;//sysj/conveyorPlant.sysj line: 80, column: 9
                      slot_thread_2[i_thread_2] = false;//sysj/conveyorPlant.sysj line: 81, column: 9
                      if(i_thread_2 + 1 == LEN_thread_2) {//sysj/conveyorPlant.sysj line: 82, column: 25
                        System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj/conveyorPlant.sysj line: 83, column: 10
                      }
                    }
                    i_thread_2 = i_thread_2 - 1;//sysj/conveyorPlant.sysj line: 86, column: 8
                  }
                }
                if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
                  bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
                  bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
          }
          else {
            injecting_thread_2 = false;//sysj/conveyorPlant.sysj line: 56, column: 6
            admitted_thread_2 = false;//sysj/conveyorPlant.sysj line: 57, column: 6
            if(admitted_thread_2){//sysj/conveyorPlant.sysj line: 66, column: 5
              infeedAdmitted.setPresent();//sysj/conveyorPlant.sysj line: 67, column: 6
              currsigs.addElement(infeedAdmitted);
              if(motInfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 74, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 75, column: 17
                  i_thread_2 = LEN_thread_2 - 1;//sysj/conveyorPlant.sysj line: 77, column: 7
                  while(i_thread_2 >= 0) {//sysj/conveyorPlant.sysj line: 78, column: 20
                    if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj/conveyorPlant.sysj line: 79, column: 33
                      slot_thread_2[i_thread_2 + 1] = true;//sysj/conveyorPlant.sysj line: 80, column: 9
                      slot_thread_2[i_thread_2] = false;//sysj/conveyorPlant.sysj line: 81, column: 9
                      if(i_thread_2 + 1 == LEN_thread_2) {//sysj/conveyorPlant.sysj line: 82, column: 25
                        System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj/conveyorPlant.sysj line: 83, column: 10
                      }
                    }
                    i_thread_2 = i_thread_2 - 1;//sysj/conveyorPlant.sysj line: 86, column: 8
                  }
                }
                if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
                  bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
                  bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
              if(motInfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 74, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 75, column: 17
                  i_thread_2 = LEN_thread_2 - 1;//sysj/conveyorPlant.sysj line: 77, column: 7
                  while(i_thread_2 >= 0) {//sysj/conveyorPlant.sysj line: 78, column: 20
                    if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj/conveyorPlant.sysj line: 79, column: 33
                      slot_thread_2[i_thread_2 + 1] = true;//sysj/conveyorPlant.sysj line: 80, column: 9
                      slot_thread_2[i_thread_2] = false;//sysj/conveyorPlant.sysj line: 81, column: 9
                      if(i_thread_2 + 1 == LEN_thread_2) {//sysj/conveyorPlant.sysj line: 82, column: 25
                        System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj/conveyorPlant.sysj line: 83, column: 10
                      }
                    }
                    i_thread_2 = i_thread_2 - 1;//sysj/conveyorPlant.sysj line: 86, column: 8
                  }
                }
                if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
                  bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
                  bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                  if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                    if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                      taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                      if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                        slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                      }
                    }
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                    if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                      infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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

  public void thread27322(int [] tdone, int [] ends){
        S27317=1;
    LEN_thread_3 = 6;//sysj/conveyorPlant.sysj line: 118, column: 3
    pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 119, column: 3
    injecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 120, column: 3
    collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 121, column: 3
    if(enable.getprestatus()){//sysj/conveyorPlant.sysj line: 124, column: 12
      if(injectOutfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 126, column: 13
        if(!injecting_thread_3) {//sysj/conveyorPlant.sysj line: 127, column: 20
          injecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 128, column: 7
          if(pos_thread_3 < 0) {//sysj/conveyorPlant.sysj line: 129, column: 18
            pos_thread_3 = 0;//sysj/conveyorPlant.sysj line: 130, column: 8
            System.out.println("[CVPlant] Bottle entered outfeed.");//sysj/conveyorPlant.sysj line: 131, column: 8
          }
        }
        if(pos_thread_3 >= 0){//sysj/conveyorPlant.sysj line: 139, column: 8
          if(pos_thread_3 < LEN_thread_3){//sysj/conveyorPlant.sysj line: 140, column: 9
            if(motOutfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 141, column: 15
              pos_thread_3 = pos_thread_3 + 1;//sysj/conveyorPlant.sysj line: 142, column: 8
              if(pos_thread_3 == LEN_thread_3) {//sysj/conveyorPlant.sysj line: 143, column: 22
                System.out.println("[CVPlant] Bottle arrived at labeller point.");//sysj/conveyorPlant.sysj line: 144, column: 9
              }
              if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
                if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
                  collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
                  if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                    pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
                  }
                }
                if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                  outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
                if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                  outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
              if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
                if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
                  collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
                  if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                    pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
                  }
                }
                if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                  outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
                if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                  outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
            bottleAtOutfeedEnd.setPresent();//sysj/conveyorPlant.sysj line: 149, column: 7
            currsigs.addElement(bottleAtOutfeedEnd);
            if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
              if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
                collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
                if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                  pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                  System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
                }
              }
              if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
              collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
              if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
          if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
            if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
              collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
              if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
              }
            }
            if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
              outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
            collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
            if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
              outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
        injecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 136, column: 6
        if(pos_thread_3 >= 0){//sysj/conveyorPlant.sysj line: 139, column: 8
          if(pos_thread_3 < LEN_thread_3){//sysj/conveyorPlant.sysj line: 140, column: 9
            if(motOutfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 141, column: 15
              pos_thread_3 = pos_thread_3 + 1;//sysj/conveyorPlant.sysj line: 142, column: 8
              if(pos_thread_3 == LEN_thread_3) {//sysj/conveyorPlant.sysj line: 143, column: 22
                System.out.println("[CVPlant] Bottle arrived at labeller point.");//sysj/conveyorPlant.sysj line: 144, column: 9
              }
              if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
                if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
                  collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
                  if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                    pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
                  }
                }
                if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                  outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
                if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                  outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
              if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
                if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
                  collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
                  if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                    pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
                  }
                }
                if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                  outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
                collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
                if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                  outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
            bottleAtOutfeedEnd.setPresent();//sysj/conveyorPlant.sysj line: 149, column: 7
            currsigs.addElement(bottleAtOutfeedEnd);
            if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
              if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
                collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
                if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                  pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                  System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
                }
              }
              if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
              collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
              if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
                outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
          if(collectFromEnd.getprestatus()){//sysj/conveyorPlant.sysj line: 153, column: 13
            if(!collecting_thread_3) {//sysj/conveyorPlant.sysj line: 154, column: 21
              collecting_thread_3 = true;//sysj/conveyorPlant.sysj line: 155, column: 7
              if(pos_thread_3 >= LEN_thread_3) {//sysj/conveyorPlant.sysj line: 156, column: 21
                pos_thread_3 = -1;//sysj/conveyorPlant.sysj line: 157, column: 8
                System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj/conveyorPlant.sysj line: 158, column: 8
              }
            }
            if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
              outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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
            collecting_thread_3 = false;//sysj/conveyorPlant.sysj line: 163, column: 6
            if(pos_thread_3 < 0){//sysj/conveyorPlant.sysj line: 166, column: 8
              outfeedClear.setPresent();//sysj/conveyorPlant.sysj line: 167, column: 6
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

  public void thread27321(int [] tdone, int [] ends){
        S27063=1;
    LEN_thread_2 = 6;//sysj/conveyorPlant.sysj line: 32, column: 3
    slot_thread_2 = new boolean[LEN_thread_2 + 1];//sysj/conveyorPlant.sysj line: 33, column: 3
    injecting_thread_2 = false;//sysj/conveyorPlant.sysj line: 34, column: 3
    admitted_thread_2 = false;//sysj/conveyorPlant.sysj line: 35, column: 3
    taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 36, column: 3
    if(enable.getprestatus()){//sysj/conveyorPlant.sysj line: 39, column: 12
      if(injectInfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 45, column: 13
        if(!injecting_thread_2) {//sysj/conveyorPlant.sysj line: 46, column: 20
          injecting_thread_2 = true;//sysj/conveyorPlant.sysj line: 47, column: 7
          if(!slot_thread_2[0]) {//sysj/conveyorPlant.sysj line: 48, column: 19
            slot_thread_2[0] = true;//sysj/conveyorPlant.sysj line: 49, column: 8
            admitted_thread_2 = true;//sysj/conveyorPlant.sysj line: 50, column: 8
            System.out.println("[CVPlant] Bottle entered infeed.");//sysj/conveyorPlant.sysj line: 51, column: 8
          }
        }
        if(admitted_thread_2){//sysj/conveyorPlant.sysj line: 66, column: 5
          infeedAdmitted.setPresent();//sysj/conveyorPlant.sysj line: 67, column: 6
          currsigs.addElement(infeedAdmitted);
          if(motInfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 74, column: 13
            if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 75, column: 17
              i_thread_2 = LEN_thread_2 - 1;//sysj/conveyorPlant.sysj line: 77, column: 7
              while(i_thread_2 >= 0) {//sysj/conveyorPlant.sysj line: 78, column: 20
                if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj/conveyorPlant.sysj line: 79, column: 33
                  slot_thread_2[i_thread_2 + 1] = true;//sysj/conveyorPlant.sysj line: 80, column: 9
                  slot_thread_2[i_thread_2] = false;//sysj/conveyorPlant.sysj line: 81, column: 9
                  if(i_thread_2 + 1 == LEN_thread_2) {//sysj/conveyorPlant.sysj line: 82, column: 25
                    System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj/conveyorPlant.sysj line: 83, column: 10
                  }
                }
                i_thread_2 = i_thread_2 - 1;//sysj/conveyorPlant.sysj line: 86, column: 8
              }
            }
            if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
              bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
            if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
              bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
          if(motInfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 74, column: 13
            if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 75, column: 17
              i_thread_2 = LEN_thread_2 - 1;//sysj/conveyorPlant.sysj line: 77, column: 7
              while(i_thread_2 >= 0) {//sysj/conveyorPlant.sysj line: 78, column: 20
                if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj/conveyorPlant.sysj line: 79, column: 33
                  slot_thread_2[i_thread_2 + 1] = true;//sysj/conveyorPlant.sysj line: 80, column: 9
                  slot_thread_2[i_thread_2] = false;//sysj/conveyorPlant.sysj line: 81, column: 9
                  if(i_thread_2 + 1 == LEN_thread_2) {//sysj/conveyorPlant.sysj line: 82, column: 25
                    System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj/conveyorPlant.sysj line: 83, column: 10
                  }
                }
                i_thread_2 = i_thread_2 - 1;//sysj/conveyorPlant.sysj line: 86, column: 8
              }
            }
            if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
              bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
            if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
              bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
      }
      else {
        injecting_thread_2 = false;//sysj/conveyorPlant.sysj line: 56, column: 6
        admitted_thread_2 = false;//sysj/conveyorPlant.sysj line: 57, column: 6
        if(admitted_thread_2){//sysj/conveyorPlant.sysj line: 66, column: 5
          infeedAdmitted.setPresent();//sysj/conveyorPlant.sysj line: 67, column: 6
          currsigs.addElement(infeedAdmitted);
          if(motInfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 74, column: 13
            if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 75, column: 17
              i_thread_2 = LEN_thread_2 - 1;//sysj/conveyorPlant.sysj line: 77, column: 7
              while(i_thread_2 >= 0) {//sysj/conveyorPlant.sysj line: 78, column: 20
                if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj/conveyorPlant.sysj line: 79, column: 33
                  slot_thread_2[i_thread_2 + 1] = true;//sysj/conveyorPlant.sysj line: 80, column: 9
                  slot_thread_2[i_thread_2] = false;//sysj/conveyorPlant.sysj line: 81, column: 9
                  if(i_thread_2 + 1 == LEN_thread_2) {//sysj/conveyorPlant.sysj line: 82, column: 25
                    System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj/conveyorPlant.sysj line: 83, column: 10
                  }
                }
                i_thread_2 = i_thread_2 - 1;//sysj/conveyorPlant.sysj line: 86, column: 8
              }
            }
            if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
              bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
            if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
              bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
          if(motInfeed.getprestatus()){//sysj/conveyorPlant.sysj line: 74, column: 13
            if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 75, column: 17
              i_thread_2 = LEN_thread_2 - 1;//sysj/conveyorPlant.sysj line: 77, column: 7
              while(i_thread_2 >= 0) {//sysj/conveyorPlant.sysj line: 78, column: 20
                if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj/conveyorPlant.sysj line: 79, column: 33
                  slot_thread_2[i_thread_2 + 1] = true;//sysj/conveyorPlant.sysj line: 80, column: 9
                  slot_thread_2[i_thread_2] = false;//sysj/conveyorPlant.sysj line: 81, column: 9
                  if(i_thread_2 + 1 == LEN_thread_2) {//sysj/conveyorPlant.sysj line: 82, column: 25
                    System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj/conveyorPlant.sysj line: 83, column: 10
                  }
                }
                i_thread_2 = i_thread_2 - 1;//sysj/conveyorPlant.sysj line: 86, column: 8
              }
            }
            if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
              bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
            if(slot_thread_2[LEN_thread_2]){//sysj/conveyorPlant.sysj line: 91, column: 5
              bottleAtPos1.setPresent();//sysj/conveyorPlant.sysj line: 92, column: 6
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
              if(takeFromPos1.getprestatus()){//sysj/conveyorPlant.sysj line: 95, column: 13
                if(!taking_thread_2) {//sysj/conveyorPlant.sysj line: 96, column: 17
                  taking_thread_2 = true;//sysj/conveyorPlant.sysj line: 97, column: 7
                  if(slot_thread_2[LEN_thread_2]) {//sysj/conveyorPlant.sysj line: 98, column: 20
                    slot_thread_2[LEN_thread_2] = false;//sysj/conveyorPlant.sysj line: 99, column: 8
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj/conveyorPlant.sysj line: 100, column: 8
                  }
                }
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
                taking_thread_2 = false;//sysj/conveyorPlant.sysj line: 105, column: 6
                if(!slot_thread_2[0]){//sysj/conveyorPlant.sysj line: 109, column: 8
                  infeedClear.setPresent();//sysj/conveyorPlant.sysj line: 110, column: 6
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
      switch(S27319){
        case 0 : 
          S27319=0;
          break RUN;
        
        case 1 : 
          S27319=2;
          S27319=2;
          thread27321(tdone,ends);
          thread27322(tdone,ends);
          int biggest27323 = 0;
          if(ends[2]>=biggest27323){
            biggest27323=ends[2];
          }
          if(ends[3]>=biggest27323){
            biggest27323=ends[3];
          }
          if(biggest27323 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread27324(tdone,ends);
          thread27325(tdone,ends);
          int biggest27326 = 0;
          if(ends[2]>=biggest27326){
            biggest27326=ends[2];
          }
          if(ends[3]>=biggest27326){
            biggest27326=ends[3];
          }
          if(biggest27326 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest27326 == 0){
            S27319=0;
            active[1]=0;
            ends[1]=0;
            S27319=0;
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
      infeedAdmitted.setpreclear();
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
      infeedAdmitted.sethook();
      infeedAdmitted.setClear();
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
