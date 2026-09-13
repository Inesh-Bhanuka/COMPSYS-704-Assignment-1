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
  public Signal reset = new Signal("reset", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.OUTPUT);
  public Signal infeedClear = new Signal("infeedClear", Signal.OUTPUT);
  public Signal infeedAdmitted = new Signal("infeedAdmitted", Signal.OUTPUT);
  public Signal bottleAtOutfeedEnd = new Signal("bottleAtOutfeedEnd", Signal.OUTPUT);
  public Signal outfeedClear = new Signal("outfeedClear", Signal.OUTPUT);
  private int LEN_thread_2;//sysj\conveyorPlant.sysj line: 39, column: 4
  private boolean[] slot_thread_2;//sysj\conveyorPlant.sysj line: 40, column: 4
  private boolean injecting_thread_2;//sysj\conveyorPlant.sysj line: 41, column: 4
  private boolean admitted_thread_2;//sysj\conveyorPlant.sysj line: 42, column: 4
  private boolean taking_thread_2;//sysj\conveyorPlant.sysj line: 43, column: 4
  private int i_thread_2;//sysj\conveyorPlant.sysj line: 84, column: 8
  private int LEN_thread_3;//sysj\conveyorPlant.sysj line: 125, column: 4
  private int pos_thread_3;//sysj\conveyorPlant.sysj line: 126, column: 4
  private boolean injecting_thread_3;//sysj\conveyorPlant.sysj line: 127, column: 4
  private boolean collecting_thread_3;//sysj\conveyorPlant.sysj line: 128, column: 4
  private int S61992 = 1;
  private int S60610 = 1;
  private int S60354 = 1;
  private int S60608 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread62001(int [] tdone, int [] ends){
        S60608=1;
    LEN_thread_3 = PlantTiming.ticks(6);//sysj\conveyorPlant.sysj line: 125, column: 4
    pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 126, column: 4
    injecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 127, column: 4
    collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 128, column: 4
    if(enable.getprestatus()){//sysj\conveyorPlant.sysj line: 131, column: 13
      if(injectOutfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 133, column: 14
        if(!injecting_thread_3) {//sysj\conveyorPlant.sysj line: 134, column: 21
          injecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 135, column: 8
          if(pos_thread_3 < 0) {//sysj\conveyorPlant.sysj line: 136, column: 19
            pos_thread_3 = 0;//sysj\conveyorPlant.sysj line: 137, column: 9
            System.out.println("[CVPlant] Bottle entered outfeed.");//sysj\conveyorPlant.sysj line: 138, column: 9
          }
        }
        if(pos_thread_3 >= 0){//sysj\conveyorPlant.sysj line: 146, column: 9
          if(pos_thread_3 < LEN_thread_3){//sysj\conveyorPlant.sysj line: 147, column: 10
            if(motOutfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 148, column: 16
              pos_thread_3 = pos_thread_3 + 1;//sysj\conveyorPlant.sysj line: 149, column: 9
              if(pos_thread_3 == LEN_thread_3) {//sysj\conveyorPlant.sysj line: 150, column: 23
                System.out.println("[CVPlant] Bottle arrived at labeller point.");//sysj\conveyorPlant.sysj line: 151, column: 10
              }
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                  collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                  if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                    pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                  }
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                  collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                  if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                    pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                  }
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
            bottleAtOutfeedEnd.setPresent();//sysj\conveyorPlant.sysj line: 156, column: 8
            currsigs.addElement(bottleAtOutfeedEnd);
            if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
              if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                  pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                  System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                }
              }
              if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
              collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
              if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
          if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
            if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
              collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
              if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
              }
            }
            if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
              outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
            collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
            if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
              outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
        injecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 143, column: 7
        if(pos_thread_3 >= 0){//sysj\conveyorPlant.sysj line: 146, column: 9
          if(pos_thread_3 < LEN_thread_3){//sysj\conveyorPlant.sysj line: 147, column: 10
            if(motOutfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 148, column: 16
              pos_thread_3 = pos_thread_3 + 1;//sysj\conveyorPlant.sysj line: 149, column: 9
              if(pos_thread_3 == LEN_thread_3) {//sysj\conveyorPlant.sysj line: 150, column: 23
                System.out.println("[CVPlant] Bottle arrived at labeller point.");//sysj\conveyorPlant.sysj line: 151, column: 10
              }
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                  collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                  if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                    pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                  }
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                  collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                  if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                    pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                  }
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
            bottleAtOutfeedEnd.setPresent();//sysj\conveyorPlant.sysj line: 156, column: 8
            currsigs.addElement(bottleAtOutfeedEnd);
            if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
              if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                  pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                  System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                }
              }
              if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
              collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
              if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
          if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
            if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
              collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
              if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
              }
            }
            if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
              outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
            collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
            if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
              outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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

  public void thread62000(int [] tdone, int [] ends){
        S60354=1;
    LEN_thread_2 = PlantTiming.ticks(6);//sysj\conveyorPlant.sysj line: 39, column: 4
    slot_thread_2 = new boolean[LEN_thread_2 + 1];//sysj\conveyorPlant.sysj line: 40, column: 4
    injecting_thread_2 = false;//sysj\conveyorPlant.sysj line: 41, column: 4
    admitted_thread_2 = false;//sysj\conveyorPlant.sysj line: 42, column: 4
    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 43, column: 4
    if(enable.getprestatus()){//sysj\conveyorPlant.sysj line: 46, column: 13
      if(injectInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 52, column: 14
        if(!injecting_thread_2) {//sysj\conveyorPlant.sysj line: 53, column: 21
          injecting_thread_2 = true;//sysj\conveyorPlant.sysj line: 54, column: 8
          if(!slot_thread_2[0]) {//sysj\conveyorPlant.sysj line: 55, column: 20
            slot_thread_2[0] = true;//sysj\conveyorPlant.sysj line: 56, column: 9
            admitted_thread_2 = true;//sysj\conveyorPlant.sysj line: 57, column: 9
            System.out.println("[CVPlant] Bottle entered infeed.");//sysj\conveyorPlant.sysj line: 58, column: 9
          }
        }
        if(admitted_thread_2){//sysj\conveyorPlant.sysj line: 73, column: 6
          infeedAdmitted.setPresent();//sysj\conveyorPlant.sysj line: 74, column: 7
          currsigs.addElement(infeedAdmitted);
          if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 81, column: 14
            if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 82, column: 18
              i_thread_2 = LEN_thread_2 - 1;//sysj\conveyorPlant.sysj line: 84, column: 8
              while(i_thread_2 >= 0) {//sysj\conveyorPlant.sysj line: 85, column: 21
                if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj\conveyorPlant.sysj line: 86, column: 34
                  slot_thread_2[i_thread_2 + 1] = true;//sysj\conveyorPlant.sysj line: 87, column: 10
                  slot_thread_2[i_thread_2] = false;//sysj\conveyorPlant.sysj line: 88, column: 10
                  if(i_thread_2 + 1 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 89, column: 26
                    System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 90, column: 11
                  }
                }
                i_thread_2 = i_thread_2 - 1;//sysj\conveyorPlant.sysj line: 93, column: 9
              }
            }
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
          if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 81, column: 14
            if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 82, column: 18
              i_thread_2 = LEN_thread_2 - 1;//sysj\conveyorPlant.sysj line: 84, column: 8
              while(i_thread_2 >= 0) {//sysj\conveyorPlant.sysj line: 85, column: 21
                if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj\conveyorPlant.sysj line: 86, column: 34
                  slot_thread_2[i_thread_2 + 1] = true;//sysj\conveyorPlant.sysj line: 87, column: 10
                  slot_thread_2[i_thread_2] = false;//sysj\conveyorPlant.sysj line: 88, column: 10
                  if(i_thread_2 + 1 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 89, column: 26
                    System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 90, column: 11
                  }
                }
                i_thread_2 = i_thread_2 - 1;//sysj\conveyorPlant.sysj line: 93, column: 9
              }
            }
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
        injecting_thread_2 = false;//sysj\conveyorPlant.sysj line: 63, column: 7
        admitted_thread_2 = false;//sysj\conveyorPlant.sysj line: 64, column: 7
        if(admitted_thread_2){//sysj\conveyorPlant.sysj line: 73, column: 6
          infeedAdmitted.setPresent();//sysj\conveyorPlant.sysj line: 74, column: 7
          currsigs.addElement(infeedAdmitted);
          if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 81, column: 14
            if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 82, column: 18
              i_thread_2 = LEN_thread_2 - 1;//sysj\conveyorPlant.sysj line: 84, column: 8
              while(i_thread_2 >= 0) {//sysj\conveyorPlant.sysj line: 85, column: 21
                if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj\conveyorPlant.sysj line: 86, column: 34
                  slot_thread_2[i_thread_2 + 1] = true;//sysj\conveyorPlant.sysj line: 87, column: 10
                  slot_thread_2[i_thread_2] = false;//sysj\conveyorPlant.sysj line: 88, column: 10
                  if(i_thread_2 + 1 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 89, column: 26
                    System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 90, column: 11
                  }
                }
                i_thread_2 = i_thread_2 - 1;//sysj\conveyorPlant.sysj line: 93, column: 9
              }
            }
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
          if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 81, column: 14
            if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 82, column: 18
              i_thread_2 = LEN_thread_2 - 1;//sysj\conveyorPlant.sysj line: 84, column: 8
              while(i_thread_2 >= 0) {//sysj\conveyorPlant.sysj line: 85, column: 21
                if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj\conveyorPlant.sysj line: 86, column: 34
                  slot_thread_2[i_thread_2 + 1] = true;//sysj\conveyorPlant.sysj line: 87, column: 10
                  slot_thread_2[i_thread_2] = false;//sysj\conveyorPlant.sysj line: 88, column: 10
                  if(i_thread_2 + 1 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 89, column: 26
                    System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 90, column: 11
                  }
                }
                i_thread_2 = i_thread_2 - 1;//sysj\conveyorPlant.sysj line: 93, column: 9
              }
            }
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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

  public void thread61998(int [] tdone, int [] ends){
        switch(S60608){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\conveyorPlant.sysj line: 131, column: 13
          if(injectOutfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 133, column: 14
            if(!injecting_thread_3) {//sysj\conveyorPlant.sysj line: 134, column: 21
              injecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 135, column: 8
              if(pos_thread_3 < 0) {//sysj\conveyorPlant.sysj line: 136, column: 19
                pos_thread_3 = 0;//sysj\conveyorPlant.sysj line: 137, column: 9
                System.out.println("[CVPlant] Bottle entered outfeed.");//sysj\conveyorPlant.sysj line: 138, column: 9
              }
            }
            if(pos_thread_3 >= 0){//sysj\conveyorPlant.sysj line: 146, column: 9
              if(pos_thread_3 < LEN_thread_3){//sysj\conveyorPlant.sysj line: 147, column: 10
                if(motOutfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 148, column: 16
                  pos_thread_3 = pos_thread_3 + 1;//sysj\conveyorPlant.sysj line: 149, column: 9
                  if(pos_thread_3 == LEN_thread_3) {//sysj\conveyorPlant.sysj line: 150, column: 23
                    System.out.println("[CVPlant] Bottle arrived at labeller point.");//sysj\conveyorPlant.sysj line: 151, column: 10
                  }
                  if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                    if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                      collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                      if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                        pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                        System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                      }
                    }
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                    collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                  if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                    if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                      collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                      if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                        pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                        System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                      }
                    }
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                    collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                bottleAtOutfeedEnd.setPresent();//sysj\conveyorPlant.sysj line: 156, column: 8
                currsigs.addElement(bottleAtOutfeedEnd);
                if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                  if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                    collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                    if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                      pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                      System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                    }
                  }
                  if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                    outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                  collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                  if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                    outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                  collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                  if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                    pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                  }
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
            injecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 143, column: 7
            if(pos_thread_3 >= 0){//sysj\conveyorPlant.sysj line: 146, column: 9
              if(pos_thread_3 < LEN_thread_3){//sysj\conveyorPlant.sysj line: 147, column: 10
                if(motOutfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 148, column: 16
                  pos_thread_3 = pos_thread_3 + 1;//sysj\conveyorPlant.sysj line: 149, column: 9
                  if(pos_thread_3 == LEN_thread_3) {//sysj\conveyorPlant.sysj line: 150, column: 23
                    System.out.println("[CVPlant] Bottle arrived at labeller point.");//sysj\conveyorPlant.sysj line: 151, column: 10
                  }
                  if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                    if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                      collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                      if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                        pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                        System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                      }
                    }
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                    collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                  if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                    if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                      collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                      if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                        pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                        System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                      }
                    }
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                    collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                    if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                      outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                bottleAtOutfeedEnd.setPresent();//sysj\conveyorPlant.sysj line: 156, column: 8
                currsigs.addElement(bottleAtOutfeedEnd);
                if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                  if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                    collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                    if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                      pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                      System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                    }
                  }
                  if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                    outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                  collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                  if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                    outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                  collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                  if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                    pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                  }
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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

  public void thread61997(int [] tdone, int [] ends){
        switch(S60354){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\conveyorPlant.sysj line: 46, column: 13
          if(injectInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 52, column: 14
            if(!injecting_thread_2) {//sysj\conveyorPlant.sysj line: 53, column: 21
              injecting_thread_2 = true;//sysj\conveyorPlant.sysj line: 54, column: 8
              if(!slot_thread_2[0]) {//sysj\conveyorPlant.sysj line: 55, column: 20
                slot_thread_2[0] = true;//sysj\conveyorPlant.sysj line: 56, column: 9
                admitted_thread_2 = true;//sysj\conveyorPlant.sysj line: 57, column: 9
                System.out.println("[CVPlant] Bottle entered infeed.");//sysj\conveyorPlant.sysj line: 58, column: 9
              }
            }
            if(admitted_thread_2){//sysj\conveyorPlant.sysj line: 73, column: 6
              infeedAdmitted.setPresent();//sysj\conveyorPlant.sysj line: 74, column: 7
              currsigs.addElement(infeedAdmitted);
              if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 81, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 82, column: 18
                  i_thread_2 = LEN_thread_2 - 1;//sysj\conveyorPlant.sysj line: 84, column: 8
                  while(i_thread_2 >= 0) {//sysj\conveyorPlant.sysj line: 85, column: 21
                    if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj\conveyorPlant.sysj line: 86, column: 34
                      slot_thread_2[i_thread_2 + 1] = true;//sysj\conveyorPlant.sysj line: 87, column: 10
                      slot_thread_2[i_thread_2] = false;//sysj\conveyorPlant.sysj line: 88, column: 10
                      if(i_thread_2 + 1 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 89, column: 26
                        System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 90, column: 11
                      }
                    }
                    i_thread_2 = i_thread_2 - 1;//sysj\conveyorPlant.sysj line: 93, column: 9
                  }
                }
                if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
                  bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
                  bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 81, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 82, column: 18
                  i_thread_2 = LEN_thread_2 - 1;//sysj\conveyorPlant.sysj line: 84, column: 8
                  while(i_thread_2 >= 0) {//sysj\conveyorPlant.sysj line: 85, column: 21
                    if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj\conveyorPlant.sysj line: 86, column: 34
                      slot_thread_2[i_thread_2 + 1] = true;//sysj\conveyorPlant.sysj line: 87, column: 10
                      slot_thread_2[i_thread_2] = false;//sysj\conveyorPlant.sysj line: 88, column: 10
                      if(i_thread_2 + 1 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 89, column: 26
                        System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 90, column: 11
                      }
                    }
                    i_thread_2 = i_thread_2 - 1;//sysj\conveyorPlant.sysj line: 93, column: 9
                  }
                }
                if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
                  bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
                  bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
            injecting_thread_2 = false;//sysj\conveyorPlant.sysj line: 63, column: 7
            admitted_thread_2 = false;//sysj\conveyorPlant.sysj line: 64, column: 7
            if(admitted_thread_2){//sysj\conveyorPlant.sysj line: 73, column: 6
              infeedAdmitted.setPresent();//sysj\conveyorPlant.sysj line: 74, column: 7
              currsigs.addElement(infeedAdmitted);
              if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 81, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 82, column: 18
                  i_thread_2 = LEN_thread_2 - 1;//sysj\conveyorPlant.sysj line: 84, column: 8
                  while(i_thread_2 >= 0) {//sysj\conveyorPlant.sysj line: 85, column: 21
                    if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj\conveyorPlant.sysj line: 86, column: 34
                      slot_thread_2[i_thread_2 + 1] = true;//sysj\conveyorPlant.sysj line: 87, column: 10
                      slot_thread_2[i_thread_2] = false;//sysj\conveyorPlant.sysj line: 88, column: 10
                      if(i_thread_2 + 1 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 89, column: 26
                        System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 90, column: 11
                      }
                    }
                    i_thread_2 = i_thread_2 - 1;//sysj\conveyorPlant.sysj line: 93, column: 9
                  }
                }
                if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
                  bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
                  bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 81, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 82, column: 18
                  i_thread_2 = LEN_thread_2 - 1;//sysj\conveyorPlant.sysj line: 84, column: 8
                  while(i_thread_2 >= 0) {//sysj\conveyorPlant.sysj line: 85, column: 21
                    if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj\conveyorPlant.sysj line: 86, column: 34
                      slot_thread_2[i_thread_2 + 1] = true;//sysj\conveyorPlant.sysj line: 87, column: 10
                      slot_thread_2[i_thread_2] = false;//sysj\conveyorPlant.sysj line: 88, column: 10
                      if(i_thread_2 + 1 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 89, column: 26
                        System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 90, column: 11
                      }
                    }
                    i_thread_2 = i_thread_2 - 1;//sysj\conveyorPlant.sysj line: 93, column: 9
                  }
                }
                if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
                  bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
                  bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
                  currsigs.addElement(bottleAtPos1);
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                  if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                    if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                      taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                      if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                        slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                        System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                      }
                    }
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                    if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                      infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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

  public void thread61995(int [] tdone, int [] ends){
        S60608=1;
    LEN_thread_3 = PlantTiming.ticks(6);//sysj\conveyorPlant.sysj line: 125, column: 4
    pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 126, column: 4
    injecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 127, column: 4
    collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 128, column: 4
    if(enable.getprestatus()){//sysj\conveyorPlant.sysj line: 131, column: 13
      if(injectOutfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 133, column: 14
        if(!injecting_thread_3) {//sysj\conveyorPlant.sysj line: 134, column: 21
          injecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 135, column: 8
          if(pos_thread_3 < 0) {//sysj\conveyorPlant.sysj line: 136, column: 19
            pos_thread_3 = 0;//sysj\conveyorPlant.sysj line: 137, column: 9
            System.out.println("[CVPlant] Bottle entered outfeed.");//sysj\conveyorPlant.sysj line: 138, column: 9
          }
        }
        if(pos_thread_3 >= 0){//sysj\conveyorPlant.sysj line: 146, column: 9
          if(pos_thread_3 < LEN_thread_3){//sysj\conveyorPlant.sysj line: 147, column: 10
            if(motOutfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 148, column: 16
              pos_thread_3 = pos_thread_3 + 1;//sysj\conveyorPlant.sysj line: 149, column: 9
              if(pos_thread_3 == LEN_thread_3) {//sysj\conveyorPlant.sysj line: 150, column: 23
                System.out.println("[CVPlant] Bottle arrived at labeller point.");//sysj\conveyorPlant.sysj line: 151, column: 10
              }
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                  collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                  if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                    pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                  }
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                  collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                  if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                    pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                  }
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
            bottleAtOutfeedEnd.setPresent();//sysj\conveyorPlant.sysj line: 156, column: 8
            currsigs.addElement(bottleAtOutfeedEnd);
            if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
              if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                  pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                  System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                }
              }
              if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
              collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
              if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
          if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
            if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
              collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
              if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
              }
            }
            if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
              outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
            collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
            if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
              outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
        injecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 143, column: 7
        if(pos_thread_3 >= 0){//sysj\conveyorPlant.sysj line: 146, column: 9
          if(pos_thread_3 < LEN_thread_3){//sysj\conveyorPlant.sysj line: 147, column: 10
            if(motOutfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 148, column: 16
              pos_thread_3 = pos_thread_3 + 1;//sysj\conveyorPlant.sysj line: 149, column: 9
              if(pos_thread_3 == LEN_thread_3) {//sysj\conveyorPlant.sysj line: 150, column: 23
                System.out.println("[CVPlant] Bottle arrived at labeller point.");//sysj\conveyorPlant.sysj line: 151, column: 10
              }
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                  collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                  if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                    pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                  }
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
              if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
                if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                  collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                  if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                    pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                    System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                  }
                }
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
                collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
                if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                  outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
            bottleAtOutfeedEnd.setPresent();//sysj\conveyorPlant.sysj line: 156, column: 8
            currsigs.addElement(bottleAtOutfeedEnd);
            if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
              if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
                collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
                if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                  pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                  System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
                }
              }
              if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
              collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
              if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
                outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
          if(collectFromEnd.getprestatus()){//sysj\conveyorPlant.sysj line: 160, column: 14
            if(!collecting_thread_3) {//sysj\conveyorPlant.sysj line: 161, column: 22
              collecting_thread_3 = true;//sysj\conveyorPlant.sysj line: 162, column: 8
              if(pos_thread_3 >= LEN_thread_3) {//sysj\conveyorPlant.sysj line: 163, column: 22
                pos_thread_3 = -1;//sysj\conveyorPlant.sysj line: 164, column: 9
                System.out.println("[CVPlant] Bottle collected from outfeed.");//sysj\conveyorPlant.sysj line: 165, column: 9
              }
            }
            if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
              outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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
            collecting_thread_3 = false;//sysj\conveyorPlant.sysj line: 170, column: 7
            if(pos_thread_3 < 0){//sysj\conveyorPlant.sysj line: 173, column: 9
              outfeedClear.setPresent();//sysj\conveyorPlant.sysj line: 174, column: 7
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

  public void thread61994(int [] tdone, int [] ends){
        S60354=1;
    LEN_thread_2 = PlantTiming.ticks(6);//sysj\conveyorPlant.sysj line: 39, column: 4
    slot_thread_2 = new boolean[LEN_thread_2 + 1];//sysj\conveyorPlant.sysj line: 40, column: 4
    injecting_thread_2 = false;//sysj\conveyorPlant.sysj line: 41, column: 4
    admitted_thread_2 = false;//sysj\conveyorPlant.sysj line: 42, column: 4
    taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 43, column: 4
    if(enable.getprestatus()){//sysj\conveyorPlant.sysj line: 46, column: 13
      if(injectInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 52, column: 14
        if(!injecting_thread_2) {//sysj\conveyorPlant.sysj line: 53, column: 21
          injecting_thread_2 = true;//sysj\conveyorPlant.sysj line: 54, column: 8
          if(!slot_thread_2[0]) {//sysj\conveyorPlant.sysj line: 55, column: 20
            slot_thread_2[0] = true;//sysj\conveyorPlant.sysj line: 56, column: 9
            admitted_thread_2 = true;//sysj\conveyorPlant.sysj line: 57, column: 9
            System.out.println("[CVPlant] Bottle entered infeed.");//sysj\conveyorPlant.sysj line: 58, column: 9
          }
        }
        if(admitted_thread_2){//sysj\conveyorPlant.sysj line: 73, column: 6
          infeedAdmitted.setPresent();//sysj\conveyorPlant.sysj line: 74, column: 7
          currsigs.addElement(infeedAdmitted);
          if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 81, column: 14
            if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 82, column: 18
              i_thread_2 = LEN_thread_2 - 1;//sysj\conveyorPlant.sysj line: 84, column: 8
              while(i_thread_2 >= 0) {//sysj\conveyorPlant.sysj line: 85, column: 21
                if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj\conveyorPlant.sysj line: 86, column: 34
                  slot_thread_2[i_thread_2 + 1] = true;//sysj\conveyorPlant.sysj line: 87, column: 10
                  slot_thread_2[i_thread_2] = false;//sysj\conveyorPlant.sysj line: 88, column: 10
                  if(i_thread_2 + 1 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 89, column: 26
                    System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 90, column: 11
                  }
                }
                i_thread_2 = i_thread_2 - 1;//sysj\conveyorPlant.sysj line: 93, column: 9
              }
            }
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
          if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 81, column: 14
            if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 82, column: 18
              i_thread_2 = LEN_thread_2 - 1;//sysj\conveyorPlant.sysj line: 84, column: 8
              while(i_thread_2 >= 0) {//sysj\conveyorPlant.sysj line: 85, column: 21
                if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj\conveyorPlant.sysj line: 86, column: 34
                  slot_thread_2[i_thread_2 + 1] = true;//sysj\conveyorPlant.sysj line: 87, column: 10
                  slot_thread_2[i_thread_2] = false;//sysj\conveyorPlant.sysj line: 88, column: 10
                  if(i_thread_2 + 1 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 89, column: 26
                    System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 90, column: 11
                  }
                }
                i_thread_2 = i_thread_2 - 1;//sysj\conveyorPlant.sysj line: 93, column: 9
              }
            }
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
        injecting_thread_2 = false;//sysj\conveyorPlant.sysj line: 63, column: 7
        admitted_thread_2 = false;//sysj\conveyorPlant.sysj line: 64, column: 7
        if(admitted_thread_2){//sysj\conveyorPlant.sysj line: 73, column: 6
          infeedAdmitted.setPresent();//sysj\conveyorPlant.sysj line: 74, column: 7
          currsigs.addElement(infeedAdmitted);
          if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 81, column: 14
            if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 82, column: 18
              i_thread_2 = LEN_thread_2 - 1;//sysj\conveyorPlant.sysj line: 84, column: 8
              while(i_thread_2 >= 0) {//sysj\conveyorPlant.sysj line: 85, column: 21
                if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj\conveyorPlant.sysj line: 86, column: 34
                  slot_thread_2[i_thread_2 + 1] = true;//sysj\conveyorPlant.sysj line: 87, column: 10
                  slot_thread_2[i_thread_2] = false;//sysj\conveyorPlant.sysj line: 88, column: 10
                  if(i_thread_2 + 1 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 89, column: 26
                    System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 90, column: 11
                  }
                }
                i_thread_2 = i_thread_2 - 1;//sysj\conveyorPlant.sysj line: 93, column: 9
              }
            }
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
          if(motInfeed.getprestatus()){//sysj\conveyorPlant.sysj line: 81, column: 14
            if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 82, column: 18
              i_thread_2 = LEN_thread_2 - 1;//sysj\conveyorPlant.sysj line: 84, column: 8
              while(i_thread_2 >= 0) {//sysj\conveyorPlant.sysj line: 85, column: 21
                if(slot_thread_2[i_thread_2] && !slot_thread_2[i_thread_2 + 1]) {//sysj\conveyorPlant.sysj line: 86, column: 34
                  slot_thread_2[i_thread_2 + 1] = true;//sysj\conveyorPlant.sysj line: 87, column: 10
                  slot_thread_2[i_thread_2] = false;//sysj\conveyorPlant.sysj line: 88, column: 10
                  if(i_thread_2 + 1 == LEN_thread_2) {//sysj\conveyorPlant.sysj line: 89, column: 26
                    System.out.println("[CVPlant] Bottle arrived at position 1.");//sysj\conveyorPlant.sysj line: 90, column: 11
                  }
                }
                i_thread_2 = i_thread_2 - 1;//sysj\conveyorPlant.sysj line: 93, column: 9
              }
            }
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
            if(slot_thread_2[LEN_thread_2]){//sysj\conveyorPlant.sysj line: 98, column: 6
              bottleAtPos1.setPresent();//sysj\conveyorPlant.sysj line: 99, column: 7
              currsigs.addElement(bottleAtPos1);
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
              if(takeFromPos1.getprestatus()){//sysj\conveyorPlant.sysj line: 102, column: 14
                if(!taking_thread_2) {//sysj\conveyorPlant.sysj line: 103, column: 18
                  taking_thread_2 = true;//sysj\conveyorPlant.sysj line: 104, column: 8
                  if(slot_thread_2[LEN_thread_2]) {//sysj\conveyorPlant.sysj line: 105, column: 21
                    slot_thread_2[LEN_thread_2] = false;//sysj\conveyorPlant.sysj line: 106, column: 9
                    System.out.println("[CVPlant] Bottle left infeed.");//sysj\conveyorPlant.sysj line: 107, column: 9
                  }
                }
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
                taking_thread_2 = false;//sysj\conveyorPlant.sysj line: 112, column: 7
                if(!slot_thread_2[0]){//sysj\conveyorPlant.sysj line: 116, column: 9
                  infeedClear.setPresent();//sysj\conveyorPlant.sysj line: 117, column: 7
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
      switch(S61992){
        case 0 : 
          S61992=0;
          break RUN;
        
        case 1 : 
          S61992=2;
          S61992=2;
          S60610=0;
          if(reset.getprestatus()){//sysj\conveyorPlant.sysj line: 33, column: 19
            S60610=1;
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          else {
            thread61994(tdone,ends);
            thread61995(tdone,ends);
            int biggest61996 = 0;
            if(ends[2]>=biggest61996){
              biggest61996=ends[2];
            }
            if(ends[3]>=biggest61996){
              biggest61996=ends[3];
            }
            if(biggest61996 == 1){
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
        
        case 2 : 
          switch(S60610){
            case 0 : 
              if(reset.getprestatus()){//sysj\conveyorPlant.sysj line: 33, column: 19
                S60610=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                thread61997(tdone,ends);
                thread61998(tdone,ends);
                int biggest61999 = 0;
                if(ends[2]>=biggest61999){
                  biggest61999=ends[2];
                }
                if(ends[3]>=biggest61999){
                  biggest61999=ends[3];
                }
                if(biggest61999 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest61999 == 0){
                  S60610=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 1 : 
              S60610=1;
              S60610=0;
              if(reset.getprestatus()){//sysj\conveyorPlant.sysj line: 33, column: 19
                S60610=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                thread62000(tdone,ends);
                thread62001(tdone,ends);
                int biggest62002 = 0;
                if(ends[2]>=biggest62002){
                  biggest62002=ends[2];
                }
                if(ends[3]>=biggest62002){
                  biggest62002=ends[3];
                }
                if(biggest62002 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
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
          reset.gethook();
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
      reset.setpreclear();
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
      dummyint = reset.getStatus() ? reset.setprepresent() : reset.setpreclear();
      reset.setpreval(reset.getValue());
      reset.setClear();
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
        reset.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
