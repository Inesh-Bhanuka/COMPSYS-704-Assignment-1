import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class RotaryTablePlant extends ClockDomain{
  public RotaryTablePlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal rotaryTrigger = new Signal("rotaryTrigger", Signal.INPUT);
  public Signal loadPos1 = new Signal("loadPos1", Signal.INPUT);
  public Signal unloadExit = new Signal("unloadExit", Signal.INPUT);
  public Signal tableAligned = new Signal("tableAligned", Signal.OUTPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.OUTPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  public Signal bottleAtPos6 = new Signal("bottleAtPos6", Signal.OUTPUT);
  private int ROT_thread_1;//sysj\turntablePlant.sysj line: 33, column: 2
  private int rotating_thread_1;//sysj\turntablePlant.sysj line: 34, column: 2
  private boolean[] occ_thread_1;//sysj\turntablePlant.sysj line: 35, column: 2
  private boolean loading_thread_1;//sysj\turntablePlant.sysj line: 39, column: 2
  private boolean unloading_thread_1;//sysj\turntablePlant.sysj line: 40, column: 2
  private boolean triggered_thread_1;//sysj\turntablePlant.sysj line: 41, column: 2
  private boolean last_thread_1;//sysj\turntablePlant.sysj line: 50, column: 6
  private int i_thread_1;//sysj\turntablePlant.sysj line: 51, column: 6
  private int S57235 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S57235){
        case 0 : 
          S57235=0;
          break RUN;
        
        case 1 : 
          S57235=2;
          S57235=2;
          ROT_thread_1 = 6;//sysj\turntablePlant.sysj line: 33, column: 2
          rotating_thread_1 = 0;//sysj\turntablePlant.sysj line: 34, column: 2
          occ_thread_1 = new boolean[6];//sysj\turntablePlant.sysj line: 35, column: 2
          loading_thread_1 = false;//sysj\turntablePlant.sysj line: 39, column: 2
          unloading_thread_1 = false;//sysj\turntablePlant.sysj line: 40, column: 2
          triggered_thread_1 = false;//sysj\turntablePlant.sysj line: 41, column: 2
          if(enable.getprestatus()){//sysj\turntablePlant.sysj line: 44, column: 11
            if(rotating_thread_1 > 0){//sysj\turntablePlant.sysj line: 46, column: 7
              rotating_thread_1 = rotating_thread_1 - 1;//sysj\turntablePlant.sysj line: 47, column: 5
              if(rotating_thread_1 == 0) {//sysj\turntablePlant.sysj line: 48, column: 22
                last_thread_1 = occ_thread_1[5];//sysj\turntablePlant.sysj line: 50, column: 6
                i_thread_1 = 5;//sysj\turntablePlant.sysj line: 51, column: 6
                while(i_thread_1 > 0) {//sysj\turntablePlant.sysj line: 52, column: 18
                  occ_thread_1[i_thread_1] = occ_thread_1[i_thread_1 - 1];//sysj\turntablePlant.sysj line: 53, column: 7
                  i_thread_1 = i_thread_1 - 1;//sysj\turntablePlant.sysj line: 54, column: 7
                }
                occ_thread_1[0] = last_thread_1;//sysj\turntablePlant.sysj line: 56, column: 6
                System.out.println("[RTPlant] Rotation complete.");//sysj\turntablePlant.sysj line: 57, column: 6
              }
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
            else {
              tableAligned.setPresent();//sysj\turntablePlant.sysj line: 61, column: 5
              currsigs.addElement(tableAligned);
              if(rotaryTrigger.getprestatus()){//sysj\turntablePlant.sysj line: 63, column: 13
                if(!triggered_thread_1) {//sysj\turntablePlant.sysj line: 64, column: 20
                  triggered_thread_1 = true;//sysj\turntablePlant.sysj line: 65, column: 7
                  rotating_thread_1 = ROT_thread_1;//sysj\turntablePlant.sysj line: 66, column: 7
                  System.out.println("[RTPlant] Rotating.");//sysj\turntablePlant.sysj line: 67, column: 7
                }
                if(loadPos1.getprestatus()){//sysj\turntablePlant.sysj line: 74, column: 13
                  if(!loading_thread_1) {//sysj\turntablePlant.sysj line: 75, column: 18
                    loading_thread_1 = true;//sysj\turntablePlant.sysj line: 76, column: 7
                    if(!occ_thread_1[0]) {//sysj\turntablePlant.sysj line: 77, column: 18
                      occ_thread_1[0] = true;//sysj\turntablePlant.sysj line: 78, column: 8
                      System.out.println("[RTPlant] Bottle loaded at position 1.");//sysj\turntablePlant.sysj line: 79, column: 8
                    }
                  }
                  if(unloadExit.getprestatus()){//sysj\turntablePlant.sysj line: 87, column: 13
                    if(!unloading_thread_1) {//sysj\turntablePlant.sysj line: 88, column: 20
                      unloading_thread_1 = true;//sysj\turntablePlant.sysj line: 89, column: 7
                      if(occ_thread_1[5]) {//sysj\turntablePlant.sysj line: 90, column: 17
                        occ_thread_1[5] = false;//sysj\turntablePlant.sysj line: 91, column: 8
                        System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\turntablePlant.sysj line: 92, column: 8
                      }
                    }
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    unloading_thread_1 = false;//sysj\turntablePlant.sysj line: 97, column: 6
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                }
                else {
                  loading_thread_1 = false;//sysj\turntablePlant.sysj line: 84, column: 6
                  if(unloadExit.getprestatus()){//sysj\turntablePlant.sysj line: 87, column: 13
                    if(!unloading_thread_1) {//sysj\turntablePlant.sysj line: 88, column: 20
                      unloading_thread_1 = true;//sysj\turntablePlant.sysj line: 89, column: 7
                      if(occ_thread_1[5]) {//sysj\turntablePlant.sysj line: 90, column: 17
                        occ_thread_1[5] = false;//sysj\turntablePlant.sysj line: 91, column: 8
                        System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\turntablePlant.sysj line: 92, column: 8
                      }
                    }
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    unloading_thread_1 = false;//sysj\turntablePlant.sysj line: 97, column: 6
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                }
              }
              else {
                triggered_thread_1 = false;//sysj\turntablePlant.sysj line: 71, column: 6
                if(loadPos1.getprestatus()){//sysj\turntablePlant.sysj line: 74, column: 13
                  if(!loading_thread_1) {//sysj\turntablePlant.sysj line: 75, column: 18
                    loading_thread_1 = true;//sysj\turntablePlant.sysj line: 76, column: 7
                    if(!occ_thread_1[0]) {//sysj\turntablePlant.sysj line: 77, column: 18
                      occ_thread_1[0] = true;//sysj\turntablePlant.sysj line: 78, column: 8
                      System.out.println("[RTPlant] Bottle loaded at position 1.");//sysj\turntablePlant.sysj line: 79, column: 8
                    }
                  }
                  if(unloadExit.getprestatus()){//sysj\turntablePlant.sysj line: 87, column: 13
                    if(!unloading_thread_1) {//sysj\turntablePlant.sysj line: 88, column: 20
                      unloading_thread_1 = true;//sysj\turntablePlant.sysj line: 89, column: 7
                      if(occ_thread_1[5]) {//sysj\turntablePlant.sysj line: 90, column: 17
                        occ_thread_1[5] = false;//sysj\turntablePlant.sysj line: 91, column: 8
                        System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\turntablePlant.sysj line: 92, column: 8
                      }
                    }
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    unloading_thread_1 = false;//sysj\turntablePlant.sysj line: 97, column: 6
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                }
                else {
                  loading_thread_1 = false;//sysj\turntablePlant.sysj line: 84, column: 6
                  if(unloadExit.getprestatus()){//sysj\turntablePlant.sysj line: 87, column: 13
                    if(!unloading_thread_1) {//sysj\turntablePlant.sysj line: 88, column: 20
                      unloading_thread_1 = true;//sysj\turntablePlant.sysj line: 89, column: 7
                      if(occ_thread_1[5]) {//sysj\turntablePlant.sysj line: 90, column: 17
                        occ_thread_1[5] = false;//sysj\turntablePlant.sysj line: 91, column: 8
                        System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\turntablePlant.sysj line: 92, column: 8
                      }
                    }
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    unloading_thread_1 = false;//sysj\turntablePlant.sysj line: 97, column: 6
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          else {
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          if(enable.getprestatus()){//sysj\turntablePlant.sysj line: 44, column: 11
            if(rotating_thread_1 > 0){//sysj\turntablePlant.sysj line: 46, column: 7
              rotating_thread_1 = rotating_thread_1 - 1;//sysj\turntablePlant.sysj line: 47, column: 5
              if(rotating_thread_1 == 0) {//sysj\turntablePlant.sysj line: 48, column: 22
                last_thread_1 = occ_thread_1[5];//sysj\turntablePlant.sysj line: 50, column: 6
                i_thread_1 = 5;//sysj\turntablePlant.sysj line: 51, column: 6
                while(i_thread_1 > 0) {//sysj\turntablePlant.sysj line: 52, column: 18
                  occ_thread_1[i_thread_1] = occ_thread_1[i_thread_1 - 1];//sysj\turntablePlant.sysj line: 53, column: 7
                  i_thread_1 = i_thread_1 - 1;//sysj\turntablePlant.sysj line: 54, column: 7
                }
                occ_thread_1[0] = last_thread_1;//sysj\turntablePlant.sysj line: 56, column: 6
                System.out.println("[RTPlant] Rotation complete.");//sysj\turntablePlant.sysj line: 57, column: 6
              }
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
            else {
              tableAligned.setPresent();//sysj\turntablePlant.sysj line: 61, column: 5
              currsigs.addElement(tableAligned);
              if(rotaryTrigger.getprestatus()){//sysj\turntablePlant.sysj line: 63, column: 13
                if(!triggered_thread_1) {//sysj\turntablePlant.sysj line: 64, column: 20
                  triggered_thread_1 = true;//sysj\turntablePlant.sysj line: 65, column: 7
                  rotating_thread_1 = ROT_thread_1;//sysj\turntablePlant.sysj line: 66, column: 7
                  System.out.println("[RTPlant] Rotating.");//sysj\turntablePlant.sysj line: 67, column: 7
                }
                if(loadPos1.getprestatus()){//sysj\turntablePlant.sysj line: 74, column: 13
                  if(!loading_thread_1) {//sysj\turntablePlant.sysj line: 75, column: 18
                    loading_thread_1 = true;//sysj\turntablePlant.sysj line: 76, column: 7
                    if(!occ_thread_1[0]) {//sysj\turntablePlant.sysj line: 77, column: 18
                      occ_thread_1[0] = true;//sysj\turntablePlant.sysj line: 78, column: 8
                      System.out.println("[RTPlant] Bottle loaded at position 1.");//sysj\turntablePlant.sysj line: 79, column: 8
                    }
                  }
                  if(unloadExit.getprestatus()){//sysj\turntablePlant.sysj line: 87, column: 13
                    if(!unloading_thread_1) {//sysj\turntablePlant.sysj line: 88, column: 20
                      unloading_thread_1 = true;//sysj\turntablePlant.sysj line: 89, column: 7
                      if(occ_thread_1[5]) {//sysj\turntablePlant.sysj line: 90, column: 17
                        occ_thread_1[5] = false;//sysj\turntablePlant.sysj line: 91, column: 8
                        System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\turntablePlant.sysj line: 92, column: 8
                      }
                    }
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    unloading_thread_1 = false;//sysj\turntablePlant.sysj line: 97, column: 6
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                }
                else {
                  loading_thread_1 = false;//sysj\turntablePlant.sysj line: 84, column: 6
                  if(unloadExit.getprestatus()){//sysj\turntablePlant.sysj line: 87, column: 13
                    if(!unloading_thread_1) {//sysj\turntablePlant.sysj line: 88, column: 20
                      unloading_thread_1 = true;//sysj\turntablePlant.sysj line: 89, column: 7
                      if(occ_thread_1[5]) {//sysj\turntablePlant.sysj line: 90, column: 17
                        occ_thread_1[5] = false;//sysj\turntablePlant.sysj line: 91, column: 8
                        System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\turntablePlant.sysj line: 92, column: 8
                      }
                    }
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    unloading_thread_1 = false;//sysj\turntablePlant.sysj line: 97, column: 6
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                }
              }
              else {
                triggered_thread_1 = false;//sysj\turntablePlant.sysj line: 71, column: 6
                if(loadPos1.getprestatus()){//sysj\turntablePlant.sysj line: 74, column: 13
                  if(!loading_thread_1) {//sysj\turntablePlant.sysj line: 75, column: 18
                    loading_thread_1 = true;//sysj\turntablePlant.sysj line: 76, column: 7
                    if(!occ_thread_1[0]) {//sysj\turntablePlant.sysj line: 77, column: 18
                      occ_thread_1[0] = true;//sysj\turntablePlant.sysj line: 78, column: 8
                      System.out.println("[RTPlant] Bottle loaded at position 1.");//sysj\turntablePlant.sysj line: 79, column: 8
                    }
                  }
                  if(unloadExit.getprestatus()){//sysj\turntablePlant.sysj line: 87, column: 13
                    if(!unloading_thread_1) {//sysj\turntablePlant.sysj line: 88, column: 20
                      unloading_thread_1 = true;//sysj\turntablePlant.sysj line: 89, column: 7
                      if(occ_thread_1[5]) {//sysj\turntablePlant.sysj line: 90, column: 17
                        occ_thread_1[5] = false;//sysj\turntablePlant.sysj line: 91, column: 8
                        System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\turntablePlant.sysj line: 92, column: 8
                      }
                    }
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    unloading_thread_1 = false;//sysj\turntablePlant.sysj line: 97, column: 6
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                }
                else {
                  loading_thread_1 = false;//sysj\turntablePlant.sysj line: 84, column: 6
                  if(unloadExit.getprestatus()){//sysj\turntablePlant.sysj line: 87, column: 13
                    if(!unloading_thread_1) {//sysj\turntablePlant.sysj line: 88, column: 20
                      unloading_thread_1 = true;//sysj\turntablePlant.sysj line: 89, column: 7
                      if(occ_thread_1[5]) {//sysj\turntablePlant.sysj line: 90, column: 17
                        occ_thread_1[5] = false;//sysj\turntablePlant.sysj line: 91, column: 8
                        System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\turntablePlant.sysj line: 92, column: 8
                      }
                    }
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                  else {
                    unloading_thread_1 = false;//sysj\turntablePlant.sysj line: 97, column: 6
                    if(occ_thread_1[0]){//sysj\turntablePlant.sysj line: 101, column: 5
                      bottleAtPos1.setPresent();//sysj\turntablePlant.sysj line: 101, column: 17
                      currsigs.addElement(bottleAtPos1);
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                    else {
                      if(occ_thread_1[1]){//sysj\turntablePlant.sysj line: 102, column: 5
                        bottleAtPos2.setPresent();//sysj\turntablePlant.sysj line: 102, column: 17
                        currsigs.addElement(bottleAtPos2);
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                      else {
                        if(occ_thread_1[3]){//sysj\turntablePlant.sysj line: 103, column: 5
                          bottleAtPos4.setPresent();//sysj\turntablePlant.sysj line: 103, column: 17
                          currsigs.addElement(bottleAtPos4);
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                        else {
                          if(occ_thread_1[4]){//sysj\turntablePlant.sysj line: 104, column: 5
                            bottleAtPos6.setPresent();//sysj\turntablePlant.sysj line: 104, column: 17
                            currsigs.addElement(bottleAtPos6);
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                          else {
                            active[1]=1;
                            ends[1]=1;
                            break RUN;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          else {
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1};
    char [] paused1 = {0, 0};
    char [] suspended1 = {0, 0};
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
          rotaryTrigger.gethook();
          loadPos1.gethook();
          unloadExit.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      rotaryTrigger.setpreclear();
      loadPos1.setpreclear();
      unloadExit.setpreclear();
      tableAligned.setpreclear();
      bottleAtPos1.setpreclear();
      bottleAtPos2.setpreclear();
      bottleAtPos4.setpreclear();
      bottleAtPos6.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = rotaryTrigger.getStatus() ? rotaryTrigger.setprepresent() : rotaryTrigger.setpreclear();
      rotaryTrigger.setpreval(rotaryTrigger.getValue());
      rotaryTrigger.setClear();
      dummyint = loadPos1.getStatus() ? loadPos1.setprepresent() : loadPos1.setpreclear();
      loadPos1.setpreval(loadPos1.getValue());
      loadPos1.setClear();
      dummyint = unloadExit.getStatus() ? unloadExit.setprepresent() : unloadExit.setpreclear();
      unloadExit.setpreval(unloadExit.getValue());
      unloadExit.setClear();
      tableAligned.sethook();
      tableAligned.setClear();
      bottleAtPos1.sethook();
      bottleAtPos1.setClear();
      bottleAtPos2.sethook();
      bottleAtPos2.setClear();
      bottleAtPos4.sethook();
      bottleAtPos4.setClear();
      bottleAtPos6.sethook();
      bottleAtPos6.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        rotaryTrigger.gethook();
        loadPos1.gethook();
        unloadExit.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
