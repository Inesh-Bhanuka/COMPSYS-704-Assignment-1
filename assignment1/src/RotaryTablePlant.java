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
  public Signal reset = new Signal("reset", Signal.INPUT);
  public Signal tableAligned = new Signal("tableAligned", Signal.OUTPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.OUTPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.OUTPUT);
  public Signal exitCleared = new Signal("exitCleared", Signal.OUTPUT);
  private int ROT_thread_1;//sysj\rotaryTablePlant.sysj line: 45, column: 3
  private int rotating_thread_1;//sysj\rotaryTablePlant.sysj line: 46, column: 3
  private boolean[] occ_thread_1;//sysj\rotaryTablePlant.sysj line: 47, column: 3
  private boolean loading_thread_1;//sysj\rotaryTablePlant.sysj line: 51, column: 3
  private boolean unloading_thread_1;//sysj\rotaryTablePlant.sysj line: 52, column: 3
  private boolean exited_thread_1;//sysj\rotaryTablePlant.sysj line: 53, column: 3
  private boolean triggered_thread_1;//sysj\rotaryTablePlant.sysj line: 54, column: 3
  private boolean last_thread_1;//sysj\rotaryTablePlant.sysj line: 63, column: 7
  private int i_thread_1;//sysj\rotaryTablePlant.sysj line: 64, column: 7
  private int S314574 = 1;
  private int S311290 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S314574){
        case 0 : 
          S314574=0;
          break RUN;
        
        case 1 : 
          S314574=2;
          S314574=2;
          S311290=0;
          if(reset.getprestatus()){//sysj\rotaryTablePlant.sysj line: 44, column: 19
            S311290=1;
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          else {
            ROT_thread_1 = PlantTiming.ticks(6);//sysj\rotaryTablePlant.sysj line: 45, column: 3
            rotating_thread_1 = 0;//sysj\rotaryTablePlant.sysj line: 46, column: 3
            occ_thread_1 = new boolean[6];//sysj\rotaryTablePlant.sysj line: 47, column: 3
            loading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 51, column: 3
            unloading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 52, column: 3
            exited_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 53, column: 3
            triggered_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 54, column: 3
            if(enable.getprestatus()){//sysj\rotaryTablePlant.sysj line: 57, column: 12
              if(rotating_thread_1 > 0){//sysj\rotaryTablePlant.sysj line: 59, column: 8
                rotating_thread_1 = rotating_thread_1 - 1;//sysj\rotaryTablePlant.sysj line: 60, column: 6
                if(rotating_thread_1 == 0) {//sysj\rotaryTablePlant.sysj line: 61, column: 23
                  last_thread_1 = occ_thread_1[5];//sysj\rotaryTablePlant.sysj line: 63, column: 7
                  i_thread_1 = 5;//sysj\rotaryTablePlant.sysj line: 64, column: 7
                  while(i_thread_1 > 0) {//sysj\rotaryTablePlant.sysj line: 65, column: 19
                    occ_thread_1[i_thread_1] = occ_thread_1[i_thread_1 - 1];//sysj\rotaryTablePlant.sysj line: 66, column: 8
                    i_thread_1 = i_thread_1 - 1;//sysj\rotaryTablePlant.sysj line: 67, column: 8
                  }
                  occ_thread_1[0] = last_thread_1;//sysj\rotaryTablePlant.sysj line: 69, column: 7
                  System.out.println("[RTPlant] Rotation complete.");//sysj\rotaryTablePlant.sysj line: 70, column: 7
                }
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                tableAligned.setPresent();//sysj\rotaryTablePlant.sysj line: 74, column: 6
                currsigs.addElement(tableAligned);
                if(rotaryTrigger.getprestatus()){//sysj\rotaryTablePlant.sysj line: 76, column: 14
                  if(!triggered_thread_1) {//sysj\rotaryTablePlant.sysj line: 77, column: 21
                    triggered_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 78, column: 8
                    rotating_thread_1 = ROT_thread_1;//sysj\rotaryTablePlant.sysj line: 79, column: 8
                    System.out.println("[RTPlant] Rotating.");//sysj\rotaryTablePlant.sysj line: 80, column: 8
                  }
                  if(loadPos1.getprestatus()){//sysj\rotaryTablePlant.sysj line: 87, column: 14
                    if(!loading_thread_1) {//sysj\rotaryTablePlant.sysj line: 88, column: 19
                      loading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 89, column: 8
                      if(!occ_thread_1[0]) {//sysj\rotaryTablePlant.sysj line: 90, column: 19
                        occ_thread_1[0] = true;//sysj\rotaryTablePlant.sysj line: 91, column: 9
                        System.out.println("[RTPlant] Bottle loaded at position 1.");//sysj\rotaryTablePlant.sysj line: 92, column: 9
                      }
                    }
                    if(unloadExit.getprestatus()){//sysj\rotaryTablePlant.sysj line: 100, column: 14
                      if(!unloading_thread_1) {//sysj\rotaryTablePlant.sysj line: 101, column: 21
                        unloading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 102, column: 8
                        if(occ_thread_1[5]) {//sysj\rotaryTablePlant.sysj line: 103, column: 18
                          occ_thread_1[5] = false;//sysj\rotaryTablePlant.sysj line: 104, column: 9
                          exited_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 105, column: 9
                          System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\rotaryTablePlant.sysj line: 106, column: 9
                        }
                      }
                      if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                        bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                        currsigs.addElement(bottleAtPos1);
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                      unloading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 111, column: 7
                      exited_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 112, column: 7
                      if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                        bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                        currsigs.addElement(bottleAtPos1);
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                    loading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 97, column: 7
                    if(unloadExit.getprestatus()){//sysj\rotaryTablePlant.sysj line: 100, column: 14
                      if(!unloading_thread_1) {//sysj\rotaryTablePlant.sysj line: 101, column: 21
                        unloading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 102, column: 8
                        if(occ_thread_1[5]) {//sysj\rotaryTablePlant.sysj line: 103, column: 18
                          occ_thread_1[5] = false;//sysj\rotaryTablePlant.sysj line: 104, column: 9
                          exited_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 105, column: 9
                          System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\rotaryTablePlant.sysj line: 106, column: 9
                        }
                      }
                      if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                        bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                        currsigs.addElement(bottleAtPos1);
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                      unloading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 111, column: 7
                      exited_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 112, column: 7
                      if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                        bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                        currsigs.addElement(bottleAtPos1);
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                else {
                  triggered_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 84, column: 7
                  if(loadPos1.getprestatus()){//sysj\rotaryTablePlant.sysj line: 87, column: 14
                    if(!loading_thread_1) {//sysj\rotaryTablePlant.sysj line: 88, column: 19
                      loading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 89, column: 8
                      if(!occ_thread_1[0]) {//sysj\rotaryTablePlant.sysj line: 90, column: 19
                        occ_thread_1[0] = true;//sysj\rotaryTablePlant.sysj line: 91, column: 9
                        System.out.println("[RTPlant] Bottle loaded at position 1.");//sysj\rotaryTablePlant.sysj line: 92, column: 9
                      }
                    }
                    if(unloadExit.getprestatus()){//sysj\rotaryTablePlant.sysj line: 100, column: 14
                      if(!unloading_thread_1) {//sysj\rotaryTablePlant.sysj line: 101, column: 21
                        unloading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 102, column: 8
                        if(occ_thread_1[5]) {//sysj\rotaryTablePlant.sysj line: 103, column: 18
                          occ_thread_1[5] = false;//sysj\rotaryTablePlant.sysj line: 104, column: 9
                          exited_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 105, column: 9
                          System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\rotaryTablePlant.sysj line: 106, column: 9
                        }
                      }
                      if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                        bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                        currsigs.addElement(bottleAtPos1);
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                      unloading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 111, column: 7
                      exited_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 112, column: 7
                      if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                        bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                        currsigs.addElement(bottleAtPos1);
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                    loading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 97, column: 7
                    if(unloadExit.getprestatus()){//sysj\rotaryTablePlant.sysj line: 100, column: 14
                      if(!unloading_thread_1) {//sysj\rotaryTablePlant.sysj line: 101, column: 21
                        unloading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 102, column: 8
                        if(occ_thread_1[5]) {//sysj\rotaryTablePlant.sysj line: 103, column: 18
                          occ_thread_1[5] = false;//sysj\rotaryTablePlant.sysj line: 104, column: 9
                          exited_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 105, column: 9
                          System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\rotaryTablePlant.sysj line: 106, column: 9
                        }
                      }
                      if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                        bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                        currsigs.addElement(bottleAtPos1);
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                      unloading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 111, column: 7
                      exited_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 112, column: 7
                      if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                        bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                        currsigs.addElement(bottleAtPos1);
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                        if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                          bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                          currsigs.addElement(bottleAtPos2);
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                          if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                            bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                            currsigs.addElement(bottleAtPos4);
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                              bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                              currsigs.addElement(bottleAtPos5);
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
                              if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                currsigs.addElement(exitCleared);
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
            }
            else {
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
        
        case 2 : 
          switch(S311290){
            case 0 : 
              if(reset.getprestatus()){//sysj\rotaryTablePlant.sysj line: 44, column: 19
                S311290=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                if(enable.getprestatus()){//sysj\rotaryTablePlant.sysj line: 57, column: 12
                  if(rotating_thread_1 > 0){//sysj\rotaryTablePlant.sysj line: 59, column: 8
                    rotating_thread_1 = rotating_thread_1 - 1;//sysj\rotaryTablePlant.sysj line: 60, column: 6
                    if(rotating_thread_1 == 0) {//sysj\rotaryTablePlant.sysj line: 61, column: 23
                      last_thread_1 = occ_thread_1[5];//sysj\rotaryTablePlant.sysj line: 63, column: 7
                      i_thread_1 = 5;//sysj\rotaryTablePlant.sysj line: 64, column: 7
                      while(i_thread_1 > 0) {//sysj\rotaryTablePlant.sysj line: 65, column: 19
                        occ_thread_1[i_thread_1] = occ_thread_1[i_thread_1 - 1];//sysj\rotaryTablePlant.sysj line: 66, column: 8
                        i_thread_1 = i_thread_1 - 1;//sysj\rotaryTablePlant.sysj line: 67, column: 8
                      }
                      occ_thread_1[0] = last_thread_1;//sysj\rotaryTablePlant.sysj line: 69, column: 7
                      System.out.println("[RTPlant] Rotation complete.");//sysj\rotaryTablePlant.sysj line: 70, column: 7
                    }
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    tableAligned.setPresent();//sysj\rotaryTablePlant.sysj line: 74, column: 6
                    currsigs.addElement(tableAligned);
                    if(rotaryTrigger.getprestatus()){//sysj\rotaryTablePlant.sysj line: 76, column: 14
                      if(!triggered_thread_1) {//sysj\rotaryTablePlant.sysj line: 77, column: 21
                        triggered_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 78, column: 8
                        rotating_thread_1 = ROT_thread_1;//sysj\rotaryTablePlant.sysj line: 79, column: 8
                        System.out.println("[RTPlant] Rotating.");//sysj\rotaryTablePlant.sysj line: 80, column: 8
                      }
                      if(loadPos1.getprestatus()){//sysj\rotaryTablePlant.sysj line: 87, column: 14
                        if(!loading_thread_1) {//sysj\rotaryTablePlant.sysj line: 88, column: 19
                          loading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 89, column: 8
                          if(!occ_thread_1[0]) {//sysj\rotaryTablePlant.sysj line: 90, column: 19
                            occ_thread_1[0] = true;//sysj\rotaryTablePlant.sysj line: 91, column: 9
                            System.out.println("[RTPlant] Bottle loaded at position 1.");//sysj\rotaryTablePlant.sysj line: 92, column: 9
                          }
                        }
                        if(unloadExit.getprestatus()){//sysj\rotaryTablePlant.sysj line: 100, column: 14
                          if(!unloading_thread_1) {//sysj\rotaryTablePlant.sysj line: 101, column: 21
                            unloading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 102, column: 8
                            if(occ_thread_1[5]) {//sysj\rotaryTablePlant.sysj line: 103, column: 18
                              occ_thread_1[5] = false;//sysj\rotaryTablePlant.sysj line: 104, column: 9
                              exited_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 105, column: 9
                              System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\rotaryTablePlant.sysj line: 106, column: 9
                            }
                          }
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                          unloading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 111, column: 7
                          exited_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 112, column: 7
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                        loading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 97, column: 7
                        if(unloadExit.getprestatus()){//sysj\rotaryTablePlant.sysj line: 100, column: 14
                          if(!unloading_thread_1) {//sysj\rotaryTablePlant.sysj line: 101, column: 21
                            unloading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 102, column: 8
                            if(occ_thread_1[5]) {//sysj\rotaryTablePlant.sysj line: 103, column: 18
                              occ_thread_1[5] = false;//sysj\rotaryTablePlant.sysj line: 104, column: 9
                              exited_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 105, column: 9
                              System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\rotaryTablePlant.sysj line: 106, column: 9
                            }
                          }
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                          unloading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 111, column: 7
                          exited_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 112, column: 7
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                    else {
                      triggered_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 84, column: 7
                      if(loadPos1.getprestatus()){//sysj\rotaryTablePlant.sysj line: 87, column: 14
                        if(!loading_thread_1) {//sysj\rotaryTablePlant.sysj line: 88, column: 19
                          loading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 89, column: 8
                          if(!occ_thread_1[0]) {//sysj\rotaryTablePlant.sysj line: 90, column: 19
                            occ_thread_1[0] = true;//sysj\rotaryTablePlant.sysj line: 91, column: 9
                            System.out.println("[RTPlant] Bottle loaded at position 1.");//sysj\rotaryTablePlant.sysj line: 92, column: 9
                          }
                        }
                        if(unloadExit.getprestatus()){//sysj\rotaryTablePlant.sysj line: 100, column: 14
                          if(!unloading_thread_1) {//sysj\rotaryTablePlant.sysj line: 101, column: 21
                            unloading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 102, column: 8
                            if(occ_thread_1[5]) {//sysj\rotaryTablePlant.sysj line: 103, column: 18
                              occ_thread_1[5] = false;//sysj\rotaryTablePlant.sysj line: 104, column: 9
                              exited_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 105, column: 9
                              System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\rotaryTablePlant.sysj line: 106, column: 9
                            }
                          }
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                          unloading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 111, column: 7
                          exited_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 112, column: 7
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                        loading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 97, column: 7
                        if(unloadExit.getprestatus()){//sysj\rotaryTablePlant.sysj line: 100, column: 14
                          if(!unloading_thread_1) {//sysj\rotaryTablePlant.sysj line: 101, column: 21
                            unloading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 102, column: 8
                            if(occ_thread_1[5]) {//sysj\rotaryTablePlant.sysj line: 103, column: 18
                              occ_thread_1[5] = false;//sysj\rotaryTablePlant.sysj line: 104, column: 9
                              exited_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 105, column: 9
                              System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\rotaryTablePlant.sysj line: 106, column: 9
                            }
                          }
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                          unloading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 111, column: 7
                          exited_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 112, column: 7
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                }
                else {
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 1 : 
              S311290=1;
              S311290=0;
              if(reset.getprestatus()){//sysj\rotaryTablePlant.sysj line: 44, column: 19
                S311290=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                ROT_thread_1 = PlantTiming.ticks(6);//sysj\rotaryTablePlant.sysj line: 45, column: 3
                rotating_thread_1 = 0;//sysj\rotaryTablePlant.sysj line: 46, column: 3
                occ_thread_1 = new boolean[6];//sysj\rotaryTablePlant.sysj line: 47, column: 3
                loading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 51, column: 3
                unloading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 52, column: 3
                exited_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 53, column: 3
                triggered_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 54, column: 3
                if(enable.getprestatus()){//sysj\rotaryTablePlant.sysj line: 57, column: 12
                  if(rotating_thread_1 > 0){//sysj\rotaryTablePlant.sysj line: 59, column: 8
                    rotating_thread_1 = rotating_thread_1 - 1;//sysj\rotaryTablePlant.sysj line: 60, column: 6
                    if(rotating_thread_1 == 0) {//sysj\rotaryTablePlant.sysj line: 61, column: 23
                      last_thread_1 = occ_thread_1[5];//sysj\rotaryTablePlant.sysj line: 63, column: 7
                      i_thread_1 = 5;//sysj\rotaryTablePlant.sysj line: 64, column: 7
                      while(i_thread_1 > 0) {//sysj\rotaryTablePlant.sysj line: 65, column: 19
                        occ_thread_1[i_thread_1] = occ_thread_1[i_thread_1 - 1];//sysj\rotaryTablePlant.sysj line: 66, column: 8
                        i_thread_1 = i_thread_1 - 1;//sysj\rotaryTablePlant.sysj line: 67, column: 8
                      }
                      occ_thread_1[0] = last_thread_1;//sysj\rotaryTablePlant.sysj line: 69, column: 7
                      System.out.println("[RTPlant] Rotation complete.");//sysj\rotaryTablePlant.sysj line: 70, column: 7
                    }
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    tableAligned.setPresent();//sysj\rotaryTablePlant.sysj line: 74, column: 6
                    currsigs.addElement(tableAligned);
                    if(rotaryTrigger.getprestatus()){//sysj\rotaryTablePlant.sysj line: 76, column: 14
                      if(!triggered_thread_1) {//sysj\rotaryTablePlant.sysj line: 77, column: 21
                        triggered_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 78, column: 8
                        rotating_thread_1 = ROT_thread_1;//sysj\rotaryTablePlant.sysj line: 79, column: 8
                        System.out.println("[RTPlant] Rotating.");//sysj\rotaryTablePlant.sysj line: 80, column: 8
                      }
                      if(loadPos1.getprestatus()){//sysj\rotaryTablePlant.sysj line: 87, column: 14
                        if(!loading_thread_1) {//sysj\rotaryTablePlant.sysj line: 88, column: 19
                          loading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 89, column: 8
                          if(!occ_thread_1[0]) {//sysj\rotaryTablePlant.sysj line: 90, column: 19
                            occ_thread_1[0] = true;//sysj\rotaryTablePlant.sysj line: 91, column: 9
                            System.out.println("[RTPlant] Bottle loaded at position 1.");//sysj\rotaryTablePlant.sysj line: 92, column: 9
                          }
                        }
                        if(unloadExit.getprestatus()){//sysj\rotaryTablePlant.sysj line: 100, column: 14
                          if(!unloading_thread_1) {//sysj\rotaryTablePlant.sysj line: 101, column: 21
                            unloading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 102, column: 8
                            if(occ_thread_1[5]) {//sysj\rotaryTablePlant.sysj line: 103, column: 18
                              occ_thread_1[5] = false;//sysj\rotaryTablePlant.sysj line: 104, column: 9
                              exited_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 105, column: 9
                              System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\rotaryTablePlant.sysj line: 106, column: 9
                            }
                          }
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                          unloading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 111, column: 7
                          exited_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 112, column: 7
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                        loading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 97, column: 7
                        if(unloadExit.getprestatus()){//sysj\rotaryTablePlant.sysj line: 100, column: 14
                          if(!unloading_thread_1) {//sysj\rotaryTablePlant.sysj line: 101, column: 21
                            unloading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 102, column: 8
                            if(occ_thread_1[5]) {//sysj\rotaryTablePlant.sysj line: 103, column: 18
                              occ_thread_1[5] = false;//sysj\rotaryTablePlant.sysj line: 104, column: 9
                              exited_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 105, column: 9
                              System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\rotaryTablePlant.sysj line: 106, column: 9
                            }
                          }
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                          unloading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 111, column: 7
                          exited_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 112, column: 7
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                    else {
                      triggered_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 84, column: 7
                      if(loadPos1.getprestatus()){//sysj\rotaryTablePlant.sysj line: 87, column: 14
                        if(!loading_thread_1) {//sysj\rotaryTablePlant.sysj line: 88, column: 19
                          loading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 89, column: 8
                          if(!occ_thread_1[0]) {//sysj\rotaryTablePlant.sysj line: 90, column: 19
                            occ_thread_1[0] = true;//sysj\rotaryTablePlant.sysj line: 91, column: 9
                            System.out.println("[RTPlant] Bottle loaded at position 1.");//sysj\rotaryTablePlant.sysj line: 92, column: 9
                          }
                        }
                        if(unloadExit.getprestatus()){//sysj\rotaryTablePlant.sysj line: 100, column: 14
                          if(!unloading_thread_1) {//sysj\rotaryTablePlant.sysj line: 101, column: 21
                            unloading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 102, column: 8
                            if(occ_thread_1[5]) {//sysj\rotaryTablePlant.sysj line: 103, column: 18
                              occ_thread_1[5] = false;//sysj\rotaryTablePlant.sysj line: 104, column: 9
                              exited_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 105, column: 9
                              System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\rotaryTablePlant.sysj line: 106, column: 9
                            }
                          }
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                          unloading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 111, column: 7
                          exited_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 112, column: 7
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                        loading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 97, column: 7
                        if(unloadExit.getprestatus()){//sysj\rotaryTablePlant.sysj line: 100, column: 14
                          if(!unloading_thread_1) {//sysj\rotaryTablePlant.sysj line: 101, column: 21
                            unloading_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 102, column: 8
                            if(occ_thread_1[5]) {//sysj\rotaryTablePlant.sysj line: 103, column: 18
                              occ_thread_1[5] = false;//sysj\rotaryTablePlant.sysj line: 104, column: 9
                              exited_thread_1 = true;//sysj\rotaryTablePlant.sysj line: 105, column: 9
                              System.out.println("[RTPlant] Bottle unloaded from position 6.");//sysj\rotaryTablePlant.sysj line: 106, column: 9
                            }
                          }
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                          unloading_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 111, column: 7
                          exited_thread_1 = false;//sysj\rotaryTablePlant.sysj line: 112, column: 7
                          if(occ_thread_1[0]){//sysj\rotaryTablePlant.sysj line: 116, column: 6
                            bottleAtPos1.setPresent();//sysj\rotaryTablePlant.sysj line: 116, column: 18
                            currsigs.addElement(bottleAtPos1);
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                            if(occ_thread_1[1]){//sysj\rotaryTablePlant.sysj line: 117, column: 6
                              bottleAtPos2.setPresent();//sysj\rotaryTablePlant.sysj line: 117, column: 18
                              currsigs.addElement(bottleAtPos2);
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                              if(occ_thread_1[3]){//sysj\rotaryTablePlant.sysj line: 118, column: 6
                                bottleAtPos4.setPresent();//sysj\rotaryTablePlant.sysj line: 118, column: 18
                                currsigs.addElement(bottleAtPos4);
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                if(occ_thread_1[4]){//sysj\rotaryTablePlant.sysj line: 119, column: 6
                                  bottleAtPos5.setPresent();//sysj\rotaryTablePlant.sysj line: 119, column: 18
                                  currsigs.addElement(bottleAtPos5);
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
                                  if(exited_thread_1){//sysj\rotaryTablePlant.sysj line: 123, column: 6
                                    exitCleared.setPresent();//sysj\rotaryTablePlant.sysj line: 123, column: 18
                                    currsigs.addElement(exitCleared);
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
          reset.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      rotaryTrigger.setpreclear();
      loadPos1.setpreclear();
      unloadExit.setpreclear();
      reset.setpreclear();
      tableAligned.setpreclear();
      bottleAtPos1.setpreclear();
      bottleAtPos2.setpreclear();
      bottleAtPos4.setpreclear();
      bottleAtPos5.setpreclear();
      exitCleared.setpreclear();
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
      dummyint = reset.getStatus() ? reset.setprepresent() : reset.setpreclear();
      reset.setpreval(reset.getValue());
      reset.setClear();
      tableAligned.sethook();
      tableAligned.setClear();
      bottleAtPos1.sethook();
      bottleAtPos1.setClear();
      bottleAtPos2.sethook();
      bottleAtPos2.setClear();
      bottleAtPos4.sethook();
      bottleAtPos4.setClear();
      bottleAtPos5.sethook();
      bottleAtPos5.setClear();
      exitCleared.sethook();
      exitCleared.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        rotaryTrigger.gethook();
        loadPos1.gethook();
        unloadExit.gethook();
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
