import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class RecyclingConveyorPlant extends ClockDomain{
  public RecyclingConveyorPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal recyclingConveyorMotor = new Signal("recyclingConveyorMotor", Signal.INPUT);
  public Signal injectAtEntry = new Signal("injectAtEntry", Signal.INPUT);
  public Signal collectAtReturn = new Signal("collectAtReturn", Signal.INPUT);
  public Signal bottleAtSplitterExit = new Signal("bottleAtSplitterExit", Signal.OUTPUT);
  public Signal bottleAtLidRemoval = new Signal("bottleAtLidRemoval", Signal.OUTPUT);
  public Signal bottleAtDumper = new Signal("bottleAtDumper", Signal.OUTPUT);
  public Signal bottleAtReturn = new Signal("bottleAtReturn", Signal.OUTPUT);
  public Signal bottleLeftReturn = new Signal("bottleLeftReturn", Signal.OUTPUT);
  private int STEP_thread_1;//sysj\recyclingConveyorPlant.sysj line: 95, column: 2
  private int LAST_thread_1;//sysj\recyclingConveyorPlant.sysj line: 97, column: 2
  private int pos_thread_1;//sysj\recyclingConveyorPlant.sysj line: 101, column: 2
  private int travel_thread_1;//sysj\recyclingConveyorPlant.sysj line: 103, column: 2
  private boolean injecting_thread_1;//sysj\recyclingConveyorPlant.sysj line: 105, column: 2
  private boolean collecting_thread_1;//sysj\recyclingConveyorPlant.sysj line: 107, column: 2
  private boolean cleared_thread_1;//sysj\recyclingConveyorPlant.sysj line: 109, column: 2
  private boolean running_thread_1;//sysj\recyclingConveyorPlant.sysj line: 111, column: 2
  private boolean indexing_thread_1;//sysj\recyclingConveyorPlant.sysj line: 113, column: 2
  private int S200401 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S200401){
        case 0 : 
          S200401=0;
          break RUN;
        
        case 1 : 
          S200401=2;
          S200401=2;
          STEP_thread_1 = 5;//sysj\recyclingConveyorPlant.sysj line: 95, column: 2
          LAST_thread_1 = 3;//sysj\recyclingConveyorPlant.sysj line: 97, column: 2
          pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 101, column: 2
          travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 103, column: 2
          injecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 105, column: 2
          collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 107, column: 2
          cleared_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 109, column: 2
          running_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 111, column: 2
          indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 113, column: 2
          if(enable.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 119, column: 11
            if(injectAtEntry.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 123, column: 12
              if(!injecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 19
                injecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 127, column: 6
                if(pos_thread_1 < 0) {//sysj\recyclingConveyorPlant.sysj line: 129, column: 17
                  pos_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 131, column: 7
                  travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 133, column: 7
                  indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 7
                  cleared_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 137, column: 7
                  System.out.println("[RCPlant] Bottle entered the recycling conveyor.");//sysj\recyclingConveyorPlant.sysj line: 139, column: 7
                }
              }
              if(recyclingConveyorMotor.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 155, column: 12
                if(!running_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 167, column: 17
                  running_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 169, column: 6
                  if(pos_thread_1 >= 0 && pos_thread_1 < LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 171, column: 32
                    indexing_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 173, column: 7
                  }
                }
                if(indexing_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 181, column: 17
                  travel_thread_1 = travel_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 183, column: 6
                  if(travel_thread_1 >= STEP_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 185, column: 24
                    travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 187, column: 7
                    indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 189, column: 7
                    pos_thread_1 = pos_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 191, column: 7
                    if(pos_thread_1 == 1) {//sysj\recyclingConveyorPlant.sysj line: 193, column: 19
                      System.out.println("[RCPlant] Bottle arrived at lid removal.");//sysj\recyclingConveyorPlant.sysj line: 193, column: 21
                    }
                    if(pos_thread_1 == 2) {//sysj\recyclingConveyorPlant.sysj line: 195, column: 19
                      System.out.println("[RCPlant] Bottle arrived at the liquid dumper.");//sysj\recyclingConveyorPlant.sysj line: 195, column: 21
                    }
                    if(pos_thread_1 == 3) {//sysj\recyclingConveyorPlant.sysj line: 197, column: 19
                      System.out.println("[RCPlant] Bottle arrived at the bottle return.");//sysj\recyclingConveyorPlant.sysj line: 197, column: 21
                    }
                  }
                }
                if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 219, column: 7
                  if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 221, column: 8
                    bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 221, column: 19
                    currsigs.addElement(bottleAtSplitterExit);
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                  if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                    if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                      collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                      if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                        pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                        cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                        System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                      }
                    }
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
                    collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
                running_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 207, column: 5
                if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 219, column: 7
                  if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 221, column: 8
                    bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 221, column: 19
                    currsigs.addElement(bottleAtSplitterExit);
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                  if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                    if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                      collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                      if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                        pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                        cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                        System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                      }
                    }
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
                    collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
              injecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 149, column: 5
              if(recyclingConveyorMotor.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 155, column: 12
                if(!running_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 167, column: 17
                  running_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 169, column: 6
                  if(pos_thread_1 >= 0 && pos_thread_1 < LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 171, column: 32
                    indexing_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 173, column: 7
                  }
                }
                if(indexing_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 181, column: 17
                  travel_thread_1 = travel_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 183, column: 6
                  if(travel_thread_1 >= STEP_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 185, column: 24
                    travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 187, column: 7
                    indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 189, column: 7
                    pos_thread_1 = pos_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 191, column: 7
                    if(pos_thread_1 == 1) {//sysj\recyclingConveyorPlant.sysj line: 193, column: 19
                      System.out.println("[RCPlant] Bottle arrived at lid removal.");//sysj\recyclingConveyorPlant.sysj line: 193, column: 21
                    }
                    if(pos_thread_1 == 2) {//sysj\recyclingConveyorPlant.sysj line: 195, column: 19
                      System.out.println("[RCPlant] Bottle arrived at the liquid dumper.");//sysj\recyclingConveyorPlant.sysj line: 195, column: 21
                    }
                    if(pos_thread_1 == 3) {//sysj\recyclingConveyorPlant.sysj line: 197, column: 19
                      System.out.println("[RCPlant] Bottle arrived at the bottle return.");//sysj\recyclingConveyorPlant.sysj line: 197, column: 21
                    }
                  }
                }
                if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 219, column: 7
                  if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 221, column: 8
                    bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 221, column: 19
                    currsigs.addElement(bottleAtSplitterExit);
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                  if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                    if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                      collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                      if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                        pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                        cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                        System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                      }
                    }
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
                    collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
                running_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 207, column: 5
                if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 219, column: 7
                  if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 221, column: 8
                    bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 221, column: 19
                    currsigs.addElement(bottleAtSplitterExit);
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                  if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                    if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                      collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                      if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                        pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                        cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                        System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                      }
                    }
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
                    collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          if(enable.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 119, column: 11
            if(injectAtEntry.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 123, column: 12
              if(!injecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 125, column: 19
                injecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 127, column: 6
                if(pos_thread_1 < 0) {//sysj\recyclingConveyorPlant.sysj line: 129, column: 17
                  pos_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 131, column: 7
                  travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 133, column: 7
                  indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 135, column: 7
                  cleared_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 137, column: 7
                  System.out.println("[RCPlant] Bottle entered the recycling conveyor.");//sysj\recyclingConveyorPlant.sysj line: 139, column: 7
                }
              }
              if(recyclingConveyorMotor.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 155, column: 12
                if(!running_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 167, column: 17
                  running_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 169, column: 6
                  if(pos_thread_1 >= 0 && pos_thread_1 < LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 171, column: 32
                    indexing_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 173, column: 7
                  }
                }
                if(indexing_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 181, column: 17
                  travel_thread_1 = travel_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 183, column: 6
                  if(travel_thread_1 >= STEP_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 185, column: 24
                    travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 187, column: 7
                    indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 189, column: 7
                    pos_thread_1 = pos_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 191, column: 7
                    if(pos_thread_1 == 1) {//sysj\recyclingConveyorPlant.sysj line: 193, column: 19
                      System.out.println("[RCPlant] Bottle arrived at lid removal.");//sysj\recyclingConveyorPlant.sysj line: 193, column: 21
                    }
                    if(pos_thread_1 == 2) {//sysj\recyclingConveyorPlant.sysj line: 195, column: 19
                      System.out.println("[RCPlant] Bottle arrived at the liquid dumper.");//sysj\recyclingConveyorPlant.sysj line: 195, column: 21
                    }
                    if(pos_thread_1 == 3) {//sysj\recyclingConveyorPlant.sysj line: 197, column: 19
                      System.out.println("[RCPlant] Bottle arrived at the bottle return.");//sysj\recyclingConveyorPlant.sysj line: 197, column: 21
                    }
                  }
                }
                if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 219, column: 7
                  if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 221, column: 8
                    bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 221, column: 19
                    currsigs.addElement(bottleAtSplitterExit);
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                  if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                    if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                      collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                      if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                        pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                        cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                        System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                      }
                    }
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
                    collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
                running_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 207, column: 5
                if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 219, column: 7
                  if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 221, column: 8
                    bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 221, column: 19
                    currsigs.addElement(bottleAtSplitterExit);
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                  if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                    if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                      collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                      if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                        pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                        cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                        System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                      }
                    }
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
                    collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
              injecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 149, column: 5
              if(recyclingConveyorMotor.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 155, column: 12
                if(!running_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 167, column: 17
                  running_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 169, column: 6
                  if(pos_thread_1 >= 0 && pos_thread_1 < LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 171, column: 32
                    indexing_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 173, column: 7
                  }
                }
                if(indexing_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 181, column: 17
                  travel_thread_1 = travel_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 183, column: 6
                  if(travel_thread_1 >= STEP_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 185, column: 24
                    travel_thread_1 = 0;//sysj\recyclingConveyorPlant.sysj line: 187, column: 7
                    indexing_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 189, column: 7
                    pos_thread_1 = pos_thread_1 + 1;//sysj\recyclingConveyorPlant.sysj line: 191, column: 7
                    if(pos_thread_1 == 1) {//sysj\recyclingConveyorPlant.sysj line: 193, column: 19
                      System.out.println("[RCPlant] Bottle arrived at lid removal.");//sysj\recyclingConveyorPlant.sysj line: 193, column: 21
                    }
                    if(pos_thread_1 == 2) {//sysj\recyclingConveyorPlant.sysj line: 195, column: 19
                      System.out.println("[RCPlant] Bottle arrived at the liquid dumper.");//sysj\recyclingConveyorPlant.sysj line: 195, column: 21
                    }
                    if(pos_thread_1 == 3) {//sysj\recyclingConveyorPlant.sysj line: 197, column: 19
                      System.out.println("[RCPlant] Bottle arrived at the bottle return.");//sysj\recyclingConveyorPlant.sysj line: 197, column: 21
                    }
                  }
                }
                if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 219, column: 7
                  if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 221, column: 8
                    bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 221, column: 19
                    currsigs.addElement(bottleAtSplitterExit);
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                  if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                    if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                      collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                      if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                        pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                        cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                        System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                      }
                    }
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
                    collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
                running_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 207, column: 5
                if(!indexing_thread_1){//sysj\recyclingConveyorPlant.sysj line: 219, column: 7
                  if(pos_thread_1 == 0){//sysj\recyclingConveyorPlant.sysj line: 221, column: 8
                    bottleAtSplitterExit.setPresent();//sysj\recyclingConveyorPlant.sysj line: 221, column: 19
                    currsigs.addElement(bottleAtSplitterExit);
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                    if(pos_thread_1 == 1){//sysj\recyclingConveyorPlant.sysj line: 223, column: 8
                      bottleAtLidRemoval.setPresent();//sysj\recyclingConveyorPlant.sysj line: 223, column: 19
                      currsigs.addElement(bottleAtLidRemoval);
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                      if(pos_thread_1 == 2){//sysj\recyclingConveyorPlant.sysj line: 225, column: 8
                        bottleAtDumper.setPresent();//sysj\recyclingConveyorPlant.sysj line: 225, column: 19
                        currsigs.addElement(bottleAtDumper);
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                        if(pos_thread_1 == 3){//sysj\recyclingConveyorPlant.sysj line: 227, column: 8
                          bottleAtReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 227, column: 19
                          currsigs.addElement(bottleAtReturn);
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                          if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                            if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                              collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                              if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                                pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                                cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                                System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                              }
                            }
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                            collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                            if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                              bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                              currsigs.addElement(bottleLeftReturn);
                              active[1]=1;
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
                  if(collectAtReturn.getprestatus()){//sysj\recyclingConveyorPlant.sysj line: 233, column: 12
                    if(!collecting_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 235, column: 20
                      collecting_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 237, column: 6
                      if(pos_thread_1 == LAST_thread_1) {//sysj\recyclingConveyorPlant.sysj line: 239, column: 21
                        pos_thread_1 = -1;//sysj\recyclingConveyorPlant.sysj line: 241, column: 7
                        cleared_thread_1 = true;//sysj\recyclingConveyorPlant.sysj line: 243, column: 7
                        System.out.println("[RCPlant] Bottle removed at the return station.");//sysj\recyclingConveyorPlant.sysj line: 245, column: 7
                      }
                    }
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
                    collecting_thread_1 = false;//sysj\recyclingConveyorPlant.sysj line: 255, column: 5
                    if(cleared_thread_1){//sysj\recyclingConveyorPlant.sysj line: 261, column: 4
                      bottleLeftReturn.setPresent();//sysj\recyclingConveyorPlant.sysj line: 263, column: 5
                      currsigs.addElement(bottleLeftReturn);
                      active[1]=1;
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
          recyclingConveyorMotor.gethook();
          injectAtEntry.gethook();
          collectAtReturn.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      recyclingConveyorMotor.setpreclear();
      injectAtEntry.setpreclear();
      collectAtReturn.setpreclear();
      bottleAtSplitterExit.setpreclear();
      bottleAtLidRemoval.setpreclear();
      bottleAtDumper.setpreclear();
      bottleAtReturn.setpreclear();
      bottleLeftReturn.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = recyclingConveyorMotor.getStatus() ? recyclingConveyorMotor.setprepresent() : recyclingConveyorMotor.setpreclear();
      recyclingConveyorMotor.setpreval(recyclingConveyorMotor.getValue());
      recyclingConveyorMotor.setClear();
      dummyint = injectAtEntry.getStatus() ? injectAtEntry.setprepresent() : injectAtEntry.setpreclear();
      injectAtEntry.setpreval(injectAtEntry.getValue());
      injectAtEntry.setClear();
      dummyint = collectAtReturn.getStatus() ? collectAtReturn.setprepresent() : collectAtReturn.setpreclear();
      collectAtReturn.setpreval(collectAtReturn.getValue());
      collectAtReturn.setClear();
      bottleAtSplitterExit.sethook();
      bottleAtSplitterExit.setClear();
      bottleAtLidRemoval.sethook();
      bottleAtLidRemoval.setClear();
      bottleAtDumper.sethook();
      bottleAtDumper.setClear();
      bottleAtReturn.sethook();
      bottleAtReturn.setClear();
      bottleLeftReturn.sethook();
      bottleLeftReturn.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        recyclingConveyorMotor.gethook();
        injectAtEntry.gethook();
        collectAtReturn.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
